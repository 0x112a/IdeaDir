package Perimeter

import (
	"testing"
)

func TestPerimeter(t *testing.T) {
	rectangle := Rectangle{10.0, 10.0}
	got := Perimeter(rectangle)
	want := 40.0

	if got != want {
		t.Errorf("got %.2f want %.2f", got, want)
	}
}

//方法实现
//func TestArea(t *testing.T) {
//	t.Run("Rectangle", func(t *testing.T) {
//		rectangle := Rectangle{12.0, 6.0}
//		got := rectangle.Area()
//		want := 72.0
//
//		if got != want {
//			t.Errorf("got : %v,want : %v", got, want)
//		}
//	})
//	t.Run("circles", func(t *testing.T) {
//		circle := Circle{10}
//		got := circle.Area()
//		want := 314.1592653589793
//		if got != want {
//			t.Errorf("got : %v,want : %v", got, want)
//		}
//	})
//}
//
//接口实现
//func TestArea(t *testing.T) {
//	checkArea := func(t *testing.T, shape Shape, want float64) {
//		t.Helper()
//		got := shape.Area()
//		if got != want {
//			t.Errorf("got : %v,want : %v", got, want)
//		}
//	}
//
//	t.Run("rectangle", func(t *testing.T) {
//		rectangle := Rectangle{12, 6}
//		checkArea(t, rectangle, 72.0)
//	})
//
//	t.Run("circles", func(t *testing.T) {
//		circle := Circle{10}
//		checkArea(t, circle, 314.1592653589793)
//	})
//}

//表格驱动测试

//func TestArea(t *testing.T) {
//	//创建一个匿名结构体
//	areaTests := []struct {
//		shape Shape
//		want  float64
//	}{
//		{shape: Rectangle{12, 6}, want: 72.0},
//		{shape: Circle{10}, want: 314.1592653589793},
//		{shape: Triangle{12, 6}, want: 36.0},
//	}
//
//	for _, v := range areaTests {
//		got := v.shape.Area()
//		if got != v.want {
//			t.Errorf("got %.2f want %.2f", got, v.want)
//		}
//	}
//}

// 使用t.run()

func TestArea(t *testing.T) {
	areaTests := []struct {
		name    string
		shape   Shape
		hasArea float64
	}{
		{name: "Rectangle", shape: Rectangle{width: 12, height: 6}, hasArea: 72.0},
		{name: "Circle", shape: Circle{Radius: 10}, hasArea: 314.1592653589793},
		{name: "Triangle", shape: Triangle{Base: 12, height: 6}, hasArea: 36.0},
	}

	for _, v := range areaTests {
		t.Run(v.name, func(t *testing.T) {
			got := v.shape.Area()
			if got != v.hasArea {
				t.Errorf("%#v got %.2f want %.2f", v.shape, got, v.hasArea)
			}
		})
	}
}
