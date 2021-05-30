package main

import (
	"fmt"
	"net/http"
)

type Myhandler struct {
	name string
	age  int
}

func (m *Myhandler) ServeHTTP(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "My name is %s,I am %d nowdays\n", m.name, m.age)
}
func main() {
	xiaomi := Myhandler{"xiaomi", 19}
	http.Handle("/xiaomi", &xiaomi)
	http.ListenAndServe(":88", nil)

}
