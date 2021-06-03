# Hive建表时指定分隔符或使用多字符分隔



​      首先我们明确，我们是在建表的时候就指定了导入数据时的分隔符的，建表的时候会有三种场景需要考虑：

  1、正常建表(default)；

  2、指定特定的特殊符号作为分隔符；

  3、使用多字符作为分隔符；

  下面详细讲一下这三种场景在使用文件导入（关于数据导入Hive数仓的，后面有空会发相关文章记录）的情景下怎么指定分隔符：

 

一、正常建表，采用默认的分隔符：

  hive 默认的字段分隔符为ascii码的控制符\001,建表的时候用fields terminated by '\001',如果要测试的话，造数据在vi 打开文件里面，用ctrl+v然后再ctrl+a可以输入这个控制符\001。按顺序，\002的输入方式为ctrl+v,ctrl+b。以此类推。

 

 

二、指定特定的特殊符号作为分隔符：

```sql 
CREATE TABLE test(id int, name string ,tel string) ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t'LINES TERMINATED BY '\n'STORED AS TEXTFILE;

```


上面使用了'\t'作为了字段分隔符，'\n'作为换行分隔符。如果有特殊需求，可以自己动手改一下这两个符号就行了。

 

 

三、使用多字符作为分隔符：

假设我们使用【##】来作为字段分隔符，【\n】作为换行分隔符，则这里有两个方法：

1、使用MultiDelimitSerDe的方法来实现：

```sql
CREATE TABLE test(id int, name string ,tel string) ROW FORMAT SERDE 'org.apache.hadoop.hive.contrib.serde2.MultiDelimitSerDe' WITH SERDEPROPERTIES ("field.delim"="##") LINES TERMINATED BY '\n'STORED AS TEXTFILE;
```

2、使用RegexSerDe的方法实现：

```sql
CREAET TABLE test(id int, name string ,tel string) ROW FORMAT SERDE 'org.apache.hadoop.hive.contrib.serde2.RegexSerDe' WITH SERDEPROPERTIES ("input.regex" = "^(.*)\\#\\#(.*)$") LINES TERMINATED BY '\n'STORED AS TEXTFILE;
```

  至于你要用什么特殊符号，就依瓢画葫芦应该没问题，有什么问题可以发出来一起讨论下。

 

