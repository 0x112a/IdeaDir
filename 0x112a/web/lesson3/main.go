package main

import (
	"fmt"
	"log"
	"net/http"
	"strings"
)

func sayHello(w http.ResponseWriter, r *http.Request){
	r.ParseForm()
	fmt.Println(r.Form)
	fmt.Println("path",r.URL.Path)
	fmt.Println("scheme",r.URL.Scheme)
	fmt.Println(r.Form["url_long"])
	for k,v := range r.Form{
		fmt.Println("key:",k)
		fmt.Println("values:",strings.Join(v,""))
	}
	fmt.Fprintf(w,"hello astaxie")

}

func main() {
	http.HandleFunc("/",sayHello)
	err := http.ListenAndServe(":899",nil)
	if err != nil{
		log.Fatal("ListenAndServer",err)
	}
}