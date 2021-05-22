package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

// 作业状态
const (
	W = 0 //等待
	R = 1 //运行
	F = 2 //终止
)

//作业数据结构
type job struct {
	name       string
	arriveTime int
	serverTime int
	status     int
	finalTime  int
}

//就绪队列数据结构
type jobQueen struct {
	node *job
	next *jobQueen
}

//初始化作业队列
//带头结点的链表
//实现作业的输入
func (q *jobQueen) initQueen() {
	p := q
	input := bufio.NewScanner(os.Stdin)
	fmt.Printf("请按如下格式依次输入每个作业：\n作业名 作业到达时间 作业服务时间\n")
	for input.Scan() {
		init := new(job)
		node := new(jobQueen)
		temp := strings.Split(input.Text(), " ")
		init.name = temp[0]
		init.arriveTime, _ = strconv.Atoi(temp[1])
		init.serverTime, _ = strconv.Atoi(temp[2])
		init.status = W
		node.node = init
		p.next = node
		p = p.next
	}
}

//显示作业全部信息
func (q *jobQueen) show(nowtime int) {
	//把数字状态转换为word
	toString := func(a int) string {
		switch a {
		case 0:
			{
				return "wait"
			}
		case 1:
			{
				return "runing"
			}
		case 2:
			{
				return "final"
			}
		}
		return ""
	}
	//周转时间函数
	turnover := func(arrive, final int) int {
		return final - arrive
	}

	fmt.Printf("name\tarrivetime\tsever\tfinaltime\tstatus\tturnover\tweighTurnover\n")
	//就绪队列为空则退出
	p := q.next
	if p == nil {
		return
	}

	for p != nil {
		if p.node.arriveTime > nowtime {
			continue
		}
		t := turnover(p.node.arriveTime, p.node.finalTime)
		//带权周转时间
		wt := float32(t) / float32(p.node.serverTime)
		fmt.Printf("%s\t%d\t\t%d\t%d\t\t%s\t%d\t\t%.2f\n", p.node.name, p.node.arriveTime, p.node.serverTime, p.node.finalTime, toString(p.node.status), t, wt)
		p = p.next
	}
	return
}

//SJF调度算法函数
func (q *jobQueen) srotSJF(nowtime int) jobQueen {
	p := q.next
	var temp []*job
	//排除还未到达的作业
	for ; p != nil; p = p.next {
		if p.node.arriveTime > nowtime || p.node.status == R || p.node.status == F {
			continue
		}
		temp = append(temp, p.node)
	}
	//如果为空则返回
	if temp == nil {
		return jobQueen{}
	}
	//对已到达就绪队列的作业按服务时间由短到长排序
	sort.Slice(temp, func(i, j int) bool {
		return temp[i].serverTime < temp[j].serverTime
	})
	r := jobQueen{}
	rp := &r
	for _, v := range temp {
		rp.node = v
		rp.next = &jobQueen{}
		rp = rp.next
	}
	return r
}

// SJF调度
func SJF(q jobQueen, nowtime int) int {
	//队列为空不变
	if q.node == nil {
		return nowtime
	}
	//fmt.Println(q.node.name)
	//改变作业状态,记录作业终止时间
	p := q
	p.node.status = F
	p.node.finalTime = nowtime + p.node.serverTime
	return nowtime + p.node.serverTime - 1
}
func main() {
	//创建一个就绪队列
	jobhead := jobQueen{}
	//初始化队列
	jobhead.initQueen()
	//开始调度
	for i := 0; i < 100; i++ {
		sjf := jobhead.srotSJF(i)
		//	fmt.Println(sjf)
		i = SJF(sjf, i)
		//	fmt.Println(i)
	}
	//显示结果
	jobhead.show(100)
}
