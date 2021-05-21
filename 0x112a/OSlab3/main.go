package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

const (
	unoccupy = 0
	occupy   = 1
)

type partition struct {
	size int
}

type PartitionNode struct {
	name string
	size int
}

type PartitionLink struct {
	pre        *PartitionLink
	node       *PartitionNode
	firstLocal int
	status     int
	next       *PartitionLink
}

//初始化分区大小
func (p *partition) init() {
	fmt.Println("请输入分区初始化大小（输入整数后回车）：")
	input := bufio.NewScanner(os.Stdin)
	input.Scan()
	p.size, _ = strconv.Atoi(input.Text())
	return
}

// 输入装入的进程
func inputP() *PartitionNode {
	fmt.Println("请输入作业名和作业大小（用空格隔开）")
	input := bufio.NewScanner(os.Stdin)
	//
INPUT:
	input.Scan()
	temp := strings.Split(input.Text(), " ")
	if len(temp) != 2 {
		fmt.Println("输入错误，请重新输入：")
		goto INPUT
	}
	output := new(PartitionNode)
	output.name = temp[0]
	output.size, _ = strconv.Atoi(temp[1])

	return output

}

//首次适应分配算法
func (l *PartitionLink) allotFF(n *PartitionNode) {
	//判断进程是否已存在
	p := l.next
	for p != nil {
		if p.status == unoccupy {
			p = p.next
			continue
		}
		if p.node.name == n.name {
			fmt.Println("进程已存在，请重新选择操作")
			return
		}
		p = p.next
	}

	//为进程分配内存
	p = l.next
	for p != nil {
		if p.status == occupy {
			p = p.next
			continue
		}
		if p.node.size > n.size {
			//剩余空闲分区
			tp := new(PartitionLink)
			//当前分区分配后所剩的空间链接形成一个新的节点
			tp.firstLocal = p.firstLocal + n.size
			tp.node = new(PartitionNode)
			tp.node.size = p.node.size - n.size
			tp.status = unoccupy
			tp.pre = p
			tp.next = p.next

			// 修改后继节点的前驱
			if p.next != nil {
				p.next.pre = tp
			}
			//修改当前节点的信息
			p.node = n
			p.status = occupy
			p.next = tp

			//修改剩于分区
			fmt.Println("内存分配成功！")
			return
		} else if p.node.size == n.size {
			p.status = occupy
			p.node = n
			fmt.Println("内存分配成功！")
			return
		}
		p = p.next
	}

	fmt.Println("内存不足，分配失败!")
	return

}

//最佳适应算法
func (l *PartitionLink) allotBF(n *PartitionNode) {
	var best *PartitionLink
	var size = math.MaxInt32
	p := l.next
	for p != nil {
		if p.status == unoccupy {
			temp := p.node.size - n.size
			if temp >= 0 && temp < size {
				size = temp
				best = p
			}
			p = p.next
			continue
		}
		if p.node.name == n.name {
			fmt.Println("进程已存在，请重新选择操作")
			return
		}
		p = p.next
	}

	if best == nil {
		fmt.Println("内存不足，分配失败！")
		return
	}

	//为进程分配内存
	if best.node.size == n.size {
		best.node = n
		best.status = occupy
		fmt.Println("内存分配成功！")
		return
	}
	tp := new(PartitionLink)
	tp.firstLocal = best.firstLocal + n.size
	tp.pre = best
	tp.next = best.next
	tp.node = new(PartitionNode)
	tp.node.size = best.node.size - n.size
	tp.status = unoccupy

	if tp.next != nil {
		tp.next.pre = tp
	}

	best.status = occupy
	best.node = n
	best.next = tp

	fmt.Println("内存分配成功！")
	return

}

//最差适应算法

func (l *PartitionLink) allotWF(n *PartitionNode) {
	var worst *PartitionLink
	var size int
	p := l.next
	for p != nil {
		if p.status == unoccupy {
			if p.node.size > size {
				size = p.node.size
				worst = p
			}
			p = p.next
			continue
		}
		if p.node.name == n.name {
			fmt.Println("进程已存在，请重新选择操作")
			return
		}
		p = p.next
	}

	if worst == nil || worst.node.size < n.size {
		fmt.Println("内存不足，分配失败！")
		return
	}
	//为进程分配内存
	if worst.node.size == n.size {
		worst.status = occupy
		worst.node = n
		fmt.Println("内存分配成功！")
		return

	}
	tp := new(PartitionLink)
	tp.firstLocal = worst.firstLocal + n.size
	tp.pre = worst
	tp.next = worst.next
	tp.node = new(PartitionNode)
	tp.node.size = worst.node.size - n.size
	tp.status = unoccupy

	if tp.next != nil {
		tp.next.pre = tp
	}

	worst.status = occupy
	worst.node = n
	worst.next = tp

	fmt.Println("内存分配成功！")
	return

}

//分区回收
func (l *PartitionLink) recycle() {
	var success bool
	fmt.Println("请输入要回收的进程号:")
	input := bufio.NewScanner(os.Stdin)
	input.Scan()
	name := input.Text()

	p := l.next
	for p != nil {
		if p.status == occupy && p.node.name == name {
			p.status = unoccupy
			//判断是否与前驱链表和并
			if p.pre != nil && p.pre.status == unoccupy {
				//修改前驱节点到后继节点
				p.pre.next = p.next
				p.pre.node.size += p.node.size
				p = p.pre
			}
			//判断是否与后继节点合并
			if p.next != nil && p.next.status == unoccupy {
				p.node.size += p.next.node.size
				//修改后继节点的后继节点的前驱
				if p.next.next != nil {
					p.next.next.pre = p
				}
				p.next = p.next.next

			}
			success = true
			break
		}
		p = p.next
	}
	if success {
		fmt.Println("内存回收成功!")
		return
	}
	fmt.Println("内存回收失败！进程不存在")
	return

}

//display
func display(part partition, l *PartitionLink) {
	fmt.Println("\n分区总大小：", part.size)
	p := l.next
	fmt.Println("分区使用情况如下")
	fmt.Println("|---------------------------------------------------------------|")
	fmt.Println("|区号\t大小\t起始位置\t终止位置\t状态\t进程名\t|")
	i := 0
	for p != nil {
		status := func() string {
			if p.status == 0 {
				return "空闲"
			}
			return "已使用"
		}()
		name := func() string {
			if p.status == unoccupy {
				return "NULL"
			}
			return p.node.name
		}()
		fmt.Printf("|%d\t%d\t%d\t\t%d\t\t%s\t%s\t|\n", i, p.node.size, p.firstLocal, p.firstLocal+p.node.size, status, name)
		p = p.next
		i++
	}
	fmt.Println("|---------------------------------------------------------------|")
}

func main() {
	//初始化分区
	var s = &partition{}
	s.init()
	fmt.Println("分区初始化完成")

	//声明分区链
	var initLink = &PartitionLink{pre: nil, node: &PartitionNode{size: s.size}, firstLocal: 0, status: unoccupy, next: nil}
	var Link = &PartitionLink{next: initLink}
	//选择下次操作
	var algorithm, nextOperation int
	fmt.Print("\n请选择要使用的动态分区分配算法\n（1，首次适应算法、2，最佳适应算法、3，最坏适应算法）：")
	fmt.Scan(&algorithm)
	for {
		fmt.Print("\n请选择接下开的操作\n（1，装入进程、2，回收空间、3，显示分区分配状态、4，重新选择分配算法）：")
		fmt.Scan(&nextOperation)
		switch nextOperation {
		case 1:
			temp := inputP()
			switch algorithm {
			case 1:
				Link.allotFF(temp)
			case 2:
				Link.allotBF(temp)
			default:
				Link.allotWF(temp)
			}

		case 2:
			Link.recycle()

		case 3:
			display(*s, Link)
		case 4:
			fmt.Print("\n请选择要使用的动态分区分配算法\n（1，首次适应算法、2，最佳适应算法、3，最坏适应算法）：")
			fmt.Scan(&algorithm)
		default:
			fmt.Println("\n输入有误，请重新选择操作")
		}

	}

}
