> 创建数据库

``` sql
CREATE DATABASE GIS;
```





> GIS SQL

```sql
CREATE TABLE IF NOT EXISTS GIS.track( carID BIGINT, 
                                     indentID BIGINT, 
                                     t BIGINT, 
                                     lon DOUBLE, 
                                     lat DOUBLE  
                                    )charset utf8;
                                    

```

> insert

```sql
INSERT INTO track SET carID=?,indentID=?,t=?,lon=?,lat=?;
```

