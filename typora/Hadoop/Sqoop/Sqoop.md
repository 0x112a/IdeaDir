# Sqoop

[Sqoop官网](http://sqoop.apache.org/)

## 简介

​	Sqoop是一款开源工具，主要用在 Hadoop（Hive）与传统数据库（MySQL，postgresql等）间进行数据的传递，可以将一个关系型数据库中的数据导入到Hadoop的HDFS中，也可以将HDFS的数据导进到关系型数据库中。

## 原理

​	基于MapReduce

​	将导入or导出命令翻译成mapreduce程序来实现

​	在翻译出的MapReduce中主要是对inputformat和outputformat进行定制。

## 安装

1. 下载安装包

2. 解压到指定目录

3. 修改环境文件`./conf/sqoop-env-templete.sh` 为`./conf/sqoop-env.sh`

4.   设置相应的环境变量

5. 拷贝JDBC驱动（jar文件）到`./lib`下

   - [下载jar参见此网站](https://stackoverflow.com/questions/25546417/where-can-i-download-mysql-jdbc-jar-from)

6. 验证Sqoop 

7. `./bin/sqoop help` 

8. 尝试链接mysql

   - `./bin/sqoop list-databases --connect jdbc:mysql://172.21.1.159:3306/ --username root -password 1q2w3e`  

   NOTE:

   - ERROR: [Host is not allowed to connect to this MySQL server](https://www.programmersought.com/article/94914006238/)

   ``` sql
   Log in to MySQL on the machine where MySQL is installed: # mysql -u root -proot (password);
   Execute use mysql;
    Execute update user set host ='%' where user ='root'; This sentence may be wrong after execution, don't worry about it.
    Perform FLUSH PRIVILEGES; ```
   ```

   - ERROR:[Sqoop1.4.7 java.lang.ClassNotFoundException: org.apache.commons.lang.StringUtils solution - Programmer Sought](https://www.programmersought.com/article/63596848836/)

     [Download Apache Commons Lang](http://commons.apache.org/proper/commons-lang/download_lang.cgi)

## Sqoop 的简单使用案例

1. 导入数据

   在Sqoop中，“导入”概念是指，从非大数据集群（RDBMS）向大数据集群（HDFS，Hive，Hbase）中传输数据。使用import关键字

   

2. RDBMS到HDFS

   - 确定Mysql服务正常开启

   - 在MySQL中建立一张表并插入一些数据

   - 导入数据

     ```sql
     全表导入
     ./bin/sqoop import \
     --connect jdbc:mysql://172.21.1.162:3306/GIS \
     --username root \
     --password 1q2w3e \
     --table track \
     --target-dir /user/GIS \
     --delete-target-dir \
     --num-mappers 1 \
     --fields-terminated-by "\t"
     ```

   - 查询导入(--num-mappers 1 指定map任务的数量)

     ```sql
     ./bin/sqoop import \
     --connect jdbc:mysql://172.21.1.162:3306/GIS \
     --username root \
     --password 1q2w3e \
     --target-dir /user/GIS \
     --delete-target-dir \
     --num-mappers 1 \ 
     --fields-terminated-by " " \
     --query 'select carID,indentID,t from track where carID >400 and $CONDITIONS;
     ```

   - 导入指定列

     ```sql
     ./bin/sqoop import \
     --connect jdbc:mysql://172.21.1.162:3306/GIS \
     --username root \
     --password 1q2w3e \
     --columns carID,indentID \
     --table track \
     --target-dir /user/GIS \
     --delete-target-dir \
     --num-mappers 1 \
     --fields-terminated-by " "
     ```

     

   - 使用sqoop关键字筛选查询 导入数据

     ```sql
     ./bin/sqoop import \
     --connect jdbc:mysql://172.21.1.162:3306/GIS \
     --username root \
     --password 1q2w3e \
     --table track \
     --columns lon,lat \
     --where 'carID<=100' \
     --target-dir /user/GIS \
     --delete-target-dir \
     --num-mappers 1 \
     --fields-terminated-by " "
     
     ```

     

3. 导出数据（export关键字）

   

   ```sql
   ./bin/sqoop \
   --connect jdbc:mysql://172.21.1.159:3306/company \
   --username root \
   --password 1q2w3e \
   --table track \
   --num-mappers 1 \
   --export-dir /user/ \
   --input-fields-terminated-by " "
   ```

   - 

