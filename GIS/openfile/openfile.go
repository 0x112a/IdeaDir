package openfile

import (
	"os"
)

func Read(path string) *os.File {
	f,err := os.Open(path)
	if err != nil{
		panic(err)
	}
	return f
	//input := bufio.NewScanner(f)
	//i := 0
	//for input.Scan(){
	//	temp := strings.Split(input.Text(),",")
	//	fmt.Println(temp)
	//	if i > 5 {
	//		break
	//	}
	//	i++
	//}
}
