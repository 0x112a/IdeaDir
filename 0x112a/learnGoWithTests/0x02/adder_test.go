package integers

import (
	"fmt"
	"testing"
)

func TestHelloWorld(t *testing.T) {
	// t.Fatal("not implemented")
	sum := Add(2, 2)
	expected := 4
	if sum != 4 {
		t.Errorf("expected '%d' but got '%d'", expected, sum)
	}

}

func ExampleAdd() {
	sum := Add(1, 5)
	fmt.Println(sum)
	//output: 6
}
