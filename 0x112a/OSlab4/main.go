package main

import (
	"fmt"
	"math/rand"
)
//定义内存矩阵
type Memory struct {
	size int
	data [][]int
	remain int
}

//分页进程存储结点
type PageTable struct {
	name string
	size int
	table map[int]int
}

//分页链表，存储整个，内存中所有的进程
type PageLink struct {
	node *PageTable
	next *PageLink
}

func (m *Memory)initM() {
	var s int
	//计算内存的行数
	fmt.Print("请输入内存大小：")
	fmt.Scan(&s)

	m.size = s
	column := s/10
	m.data = make([][]int,column)

	fmt.Print("请选择（1.手动 OR 2.随机）初始化内存状态:")
	var o int
	fmt.Scan(&o)
	if o == 2{
		//做伪随机数Seed
		a := 666
		for i := range m.data{
			m.data[i] = make([]int,10)
			for ji:=0;ji<10;ji++{
				rand.Seed(int64(a*i/(ji+1)))
				m.data[i][ji] = rand.Intn(2)
			}
		}
		fmt.Println("初始化完成!")
	}else {

		for i := range m.data{
			m.data[i] = make([]int,10)
		}
		var temp int
		fmt.Println("请输入已使用的块号（输入-1结束）：")
		fmt.Scan(&temp)
		for temp!=-1{
			i := temp/10
			j := temp%10
			m.data[i][j]=1
			fmt.Scan(&temp)
		}

		fmt.Println("初始化完成!")

	}
	m.Remain()

}

func(m *Memory)Remain(){
	var count int
	for _,i := range m.data{
		for _,j := range i{
			if j == 0{
				count++
			}
		}

	}
	m.remain=count
}

func allot(m *Memory,p *PageTable) bool{
	if p.size > m.remain{
		fmt.Println("内存不足！")
		return false
	}
	m.remain -=p.size
	//create table
	index := 0
	p.table = make(map[int]int)
	for i := range m.data{
		for j:=range m.data[i]{
			if index != p.size && m.data[i][j]==0{
				m.data[i][j] = 1
				p.table[index] = (i*10+j)
				index++
			}
			if index== p.size {
				return true
			}
		}
	}

	return false
}

func recycle(m *Memory, p *PageLink) bool{
	fmt.Print("请输入要回收的作业号：")
	var n string
	_,err := fmt.Scanf("%s",&n)
	if err != nil{
		panic(err)
	}
	q := p.next
	pre := p
	for q != nil{
		if q.node.name == n{
			m.remain+=q.node.size
			for _,v := range q.node.table{
				i := v /10
				j := v %10
				m.data[i][j]=0
			}
			pre.next = q.next
			return true
		}
		q =q.next
		pre = pre.next
	}
	fmt.Println("作业不存在!")
	return true
}


func (m *Memory)display(p *PageLink){
	fmt.Println("--------位示图-------")
	for _,v := range m.data{
		fmt.Println(v)
	}
	fmt.Println("--------------------")
	fmt.Println("作业号 | 大小")
	q := p.next
	for q != nil{
		fmt.Println(q.node.name,"\t",q.node.size)
		q=q.next
	}


}

func main() {

	var m *Memory
	m = new(Memory)
	m.initM()

	var head *PageLink
	head = new(PageLink)

	for {
		var o int
		fmt.Print("请选择接下来的操作（1.分配，2.回收，3.显示）：")
		fmt.Scan(&o)
		switch o {
		case 1:
			var na string
			var si int
			fmt.Println("请输入作业号和大小（使用空格隔开）：")
			fmt.Scan(&na,&si)
			node := new(PageTable)
			node.name=na
			node.size=si
			allot(m,node)
			//头插法
			temp := new(PageLink)
			temp.node=node
			temp.next=head.next
			head.next=temp

		case 2:
			recycle(m,head)
		case 3:
			m.display(head)
		}

	}



	//var t *Memory
	//t = new(Memory)
	//t.initM(100)
	//t.display()
	//t.Remain()
	//var n = new(PageTable)
	//n.name= "01"
	//n.size=15
	//n.table = make(map[int]int)
	//b := allot(t,n)
	//fmt.Println(b)
	//t.display()
	//var l = new(PageLink)
	//l.next=new(PageLink)
	//l.next.node=n
	//a := recycle(t,l)
	//fmt.Println(a)
	//t.display()

}
