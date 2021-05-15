package mysql_driver

import (
	"database/sql"
)

func Connect(dns string) *sql.DB{

	db , err := sql.Open("mysql",dns)
	checkerr(err)
	return db

}

//func Insert(db *sql.DB,carID,indentID int64,t int64,lon,lat string){
//
//	stmt, err := db.Prepare("INSERT INTO track SET carID=?,indentID=?,t=?,lon=?,lat=?")
//	stmt.Exec(carID,indentID,t,lon,lat)
//	checkerr(err)
//	return
//
//}
func Insert(stmt *sql.Stmt,carID,indentID int64,t int64,lon,lat string){
	//respon,err:=stmt.Exec(carID,indentID,t,lon,lat)
	stmt.Exec(carID,indentID,t,lon,lat)
	//respon.LastInsertId()
	//checkerr(err)
	return
}

func checkerr(err error){
	if err != nil {
		panic(err)
	}
}