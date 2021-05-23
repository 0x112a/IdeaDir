package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

var filePath = "/home/monica/IdeaProjects/GIS/gps_20161101"

func main() {

	f,err:= os.Open(filePath)
	checkErr(err)
	o,err := os.Create("gps")
	checkErr(err)
	defer f.Close()
	defer o.Close()

	input := bufio.NewScanner(f)

	var carID = make(map[string]int)
	var indentID = make(map[string]int)
	var ID,inID int

	for input.Scan(){
		//if ID > 3{
		//	break
		//}

		temp := strings.Split(input.Text(),",")

		var cID,iID int

		if v,ok := carID[temp[0]];ok{
			cID = v

		}else {
			ID++
			inID=0
			carID[temp[0]]=ID
			cID=ID
		}

		if v,ok := indentID[temp[1]];ok{
			iID = v
		}else {
			inID++
			indentID[temp[1]]=inID
			iID=inID
		}
		temp[0]=strconv.Itoa(cID)
		temp[1]=strconv.Itoa(iID)
		temp=append(temp,"\n")

		output := strings.Join(temp," ")
		o.WriteString(output)

	}

}

func checkErr(err error)  {
	if err != nil{
		panic(err)
	}
	return
}