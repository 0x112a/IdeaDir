package main

import (
	"fmt"
	"log"
	"net/http"
)

//创建一个处理器函数
func handler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintln(w, "Hello,世界", r.URL.Path)
}

func main() {
	http.HandleFunc("/", handler)

	err := http.ListenAndServe(":888", nil)
	if err != nil {
		log.Fatal("ListenAndServe:", err)
	}
}
