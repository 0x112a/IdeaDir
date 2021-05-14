package main

import (
	mysql_driver "GIS/mysql-driver"
	"GIS/openfile"
	"bufio"
	"fmt"
	_ "github.com/go-sql-driver/mysql"
	"strconv"
	"strings"
	"time"
)

func main()  {
	dsn := "root:1q2w3e@tcp(127.0.0.1:3306)/GIS"
	filepath := "/home/monica/IdeaProjects/GIS/gps_20161101"
	db := mysql_driver.Connect(dsn)
	err := db.Ping()
	checkErr(err)
	db.SetConnMaxLifetime(time.Millisecond*1)
	defer db.Close()


	f := openfile.Read(filepath)
	defer f.Close()



	begin := time.Now()
	input := bufio.NewScanner(f)
	car ,index := "",0
	indent ,index1 := "",0
	i:=0
	for input.Scan(){
		//if i < 16380{
		//	i++
		//	continue
		//}
		temp := strings.Split(input.Text(),",")
		fmt.Println(i,"\t",temp)
		if car != temp[0]{
			car = temp[0]
			index++
		}
		if indent != temp[1]{
			indent = temp[1]
			index1++
		}
		index2 ,err:= strconv.Atoi(temp[2])
		checkErr(err)
		mysql_driver.Insert(db,int64(index),int64(index1),int64(index2),temp[3],temp[4])
		i++
	}
	end := time.Since(begin)
	fmt.Println(end.Seconds())
}


func checkErr(err error)  {
	if err != nil{
		panic(err)
	}
}
