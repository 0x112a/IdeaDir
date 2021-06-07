package main

import (
	"fmt"
	"math/rand"
)

type Memory struct {
	size int
	data [][]int
}

type PageTable struct {
	name string
	key map[int]int
}

type PageLink struct {
	node *PageTable
	next *PageLink
}

func (m *Memory)initM(s int) {
	m.size = s
	column := s/10
	m.data = make([][]int,column)
	a := 1
	for i,_ := range m.data{
		a++
		m.data[i] = make([]int,10)

		for ji:=0;ji<10;ji++{
			rand.Seed(int64(a*i/(ji+1)))
			m.data[i][ji] = rand.Intn(2)
		}


	}
}



func (m *Memory)display(){
	for _,v := range m.data{
		fmt.Println(v)
	}
}

func main() {
	var t *Memory
	t = new(Memory)
	t.initM(1000)
	t.display()

}
