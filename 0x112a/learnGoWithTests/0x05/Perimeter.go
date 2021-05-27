package Perimeter

import "math"

type Shape interface {
	Area() float64
}

type Rectangle struct {
	width  float64
	height float64
}

type Circle struct {
	Radius float64
}

type Triangle struct {
	Base   float64
	height float64
}

func Perimeter(r Rectangle) (Per float64) {
	Per = (r.width + r.height) * 2
	return
}

func (r Rectangle) Area() (area float64) {
	area = r.width * r.height
	return
}

func (c Circle) Area() (area float64) {
	area = math.Pi * math.Pow(c.Radius, 2.0)
	return
}

func (t Triangle) Area() (area float64) {
	area = t.Base * t.height / 2.0
	return
}
