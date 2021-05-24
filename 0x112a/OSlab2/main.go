package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
	"time"
)

const (
	W = 0
	R = 1
	F = 2
)

//设置进程体
type PCB struct {
	name              string
	arrivetime        int
	servertime        int
	alreadyServerTime int
	priority          int
	finaltime         int
	status            int
	turnOver          int
	WturnOver         float64
}

type PCBNode struct {
	node *PCB
	next *PCBNode
}

//进程初始化
func (p *PCBNode) initPCB() {
	fmt.Println("请按如下格式初始化进程:")
	fmt.Println("进程名 到达时间 服务时间 优先权")
	input := bufio.NewScanner(os.Stdin)
	for input.Scan() {
		tp := new(PCB)
		tn := new(PCBNode)
		t := strings.Split(input.Text(), " ")
		tp.name = t[0]
		tp.arrivetime, _ = strconv.Atoi(t[1])
		tp.servertime, _ = strconv.Atoi(t[2])
		tp.priority, _ = strconv.Atoi(t[3])
		p.node = tp
		p.next = tn
		p = p.next
	}
}

//显示函数
func (p *PCBNode) show() {
	//状态显示
	status := func(v PCB) string {
		switch v.status {
		case 0:
			return "Wait"
		case 1:
			return "Runing"
		default:
			return "Final"
		}
	}

	fmt.Printf("进程\t到达时间\t服务时间\t结束时间\t优先权\t状态\t周转时间\t带权周转时间\n")
	i := p
	for i != nil && i.node != nil {
		name := i.node.name
		arrive := i.node.arrivetime
		server := i.node.servertime
		final := i.node.finaltime
		pri := i.node.priority
		sta := status(*i.node)
		turnOver := i.node.turnOver
		WturnOver := i.node.WturnOver
		fmt.Printf("%s\t  %d\t\t  %d\t\t  %d\t\t  %d\t%s\t  %d\t\t  %.2f\n", name, arrive, server, final, pri, sta, turnOver, WturnOver)
		i = i.next
	}
}

//排序函数
func (p *PCBNode) sortPCB(nowtime int) *PCBNode {
	//声明就绪队列，完成队列
	var s, f []*PCB
	i := p
	for i != nil && i.node != nil {
		if i.node.arrivetime <= nowtime && i.node.status != F {
			s = append(s, i.node)
		} else if i.node.status == F {
			f = append(f, i.node)
		}
		i = i.next
	}
	//按照优先级排序
	sort.Slice(s, func(i, j int) bool {
		return s[i].priority > s[j].priority
	})

	ans := new(PCBNode)
	cur := ans
	for _, v := range s {
		ans.node = v
		ans.next = &PCBNode{}
		ans = ans.next
	}
	for _, v := range f {
		ans.node = v
		ans.next = &PCBNode{}
		ans = ans.next
	}

	return cur
}

//调度函数
func (p *PCBNode) PreHRN(n int, nowtime *int) {
	if p.node.servertime > p.node.alreadyServerTime {
		if p.node.alreadyServerTime+n > p.node.servertime {
			*nowtime += n - (p.node.servertime - p.node.alreadyServerTime)
			p.node.alreadyServerTime = p.node.servertime

		} else {
			p.node.alreadyServerTime += n
		}
		p.node.status = R
	} else {
		p.node.finaltime = *nowtime
		p.node.status = F
	}
}
func (p *PCBNode) PostHRN(change, nowtime int) {
	//改变进程信息
	if p.node.priority < change {
		p.node.priority = 0
	} else {
		p.node.priority -= change
	}

	if p.node.servertime == p.node.alreadyServerTime {
		p.node.finaltime = nowtime + 1
		p.node.status = F
	} else {
		p.node.status = W
	}
	//周转时间和带权周转时间
	if p.node.status == F {
		p.node.turnOver = p.node.finaltime - p.node.arrivetime
		p.node.WturnOver = float64(p.node.turnOver) / float64(p.node.servertime)
	} else {
		p.node.turnOver = nowtime - p.node.arrivetime
		p.node.WturnOver = float64(p.node.turnOver) / float64(p.node.alreadyServerTime)
	}
}

func main() {
	//初始化进程队列
	newjob := new(PCBNode)
	newjob.initPCB()
	fmt.Println("请输入每次运行改变的优先级n的值：")
	var n int
	fmt.Scan(&n)
	s := newjob.sortPCB(0)
	for i := 0; s.node.status != F; i += n {
		fmt.Printf("-------------------------第%d个时间单位进程队列状态-------------------\n", i)
		s.PreHRN(n, &i)
		s.show()
		s.PostHRN(n, i)
		time.Sleep(time.Duration(n) * time.Second)
		fmt.Println()

		s = newjob.sortPCB(i + n)
	}

	fmt.Printf("----------------------进程全部运行结束------------------------\n")
	s.show()
}
