# MyBatis

> MyBatis 是一个优秀的基于java的持久层框架

![image-20210912093934384](/home/monica/.config/Typora/typora-user-images/image-20210912093934384.png)

![image-20210912093801826](/home/monica/.config/Typora/typora-user-images/image-20210912093801826.png)

## MyBatis 入门

1. 对象关系映射ORM

![image-20210912093626740](/home/monica/.config/Typora/typora-user-images/image-20210912093626740.png)

2.



## MyBatis 相关API

- Resources

  ![image-20210912094913223](/home/monica/.config/Typora/typora-user-images/image-20210912094913223.png)

- SQLSessionFactoryBuilder

  ![image-20210912095045837](/home/monica/.config/Typora/typora-user-images/image-20210912095045837.png)

- SqlSessionFactory

  ![image-20210912095140285](/home/monica/.config/Typora/typora-user-images/image-20210912095140285.png)

- SqlSession

  ![image-20210912095350334](/home/monica/.config/Typora/typora-user-images/image-20210912095350334.png)

- 小结

  ![image-20210912095519754](/home/monica/.config/Typora/typora-user-images/image-20210912095519754.png)

## 映射配置文件

- 映射配置文件介绍

  映射配置文件包含了数据和对象之间的映射关系以及要执行的SQL语句

  ![image-20210912100103489](/home/monica/.config/Typora/typora-user-images/image-20210912100103489.png)

- 查询功能

  ![image-20210912100307354](/home/monica/.config/Typora/typora-user-images/image-20210912100307354.png)

- 新增功能

  ![image-20210912100352076](/home/monica/.config/Typora/typora-user-images/image-20210912100352076.png)

- 修改功能

  ![image-20210912100443303](/home/monica/.config/Typora/typora-user-images/image-20210912100443303.png)

- 删除功能

  ![image-20210912100502238](/home/monica/.config/Typora/typora-user-images/image-20210912100502238.png)

- 小结

  ![image-20210912100540162](/home/monica/.config/Typora/typora-user-images/image-20210912100540162.png)

## 核心配置文件

![image-20210917151822535](/home/monica/.config/Typora/typora-user-images/image-20210917151822535.png)

- 核心配置文件介绍

  核心配置文件包含了Mybatis最核心的设置和属性信息，如数据库的连接，事务，连接池信息等。

  ![image-20210912101027168](/home/monica/.config/Typora/typora-user-images/image-20210912101027168.png)

- 数据库连接配置文件的引入

  ![image-20210912101230991](/home/monica/.config/Typora/typora-user-images/image-20210912101230991.png)

- 起别名

  ![image-20210912101342289](/home/monica/.config/Typora/typora-user-images/image-20210912101342289.png)

  ![image-20210912101405683](/home/monica/.config/Typora/typora-user-images/image-20210912101405683.png)

- 小结

  ![image-20210912101517788](/home/monica/.config/Typora/typora-user-images/image-20210912101517788.png)

## MyBatis 传统方式实现Dao

- 执行流程

  ![image-20210912101637777](/home/monica/.config/Typora/typora-user-images/image-20210912101637777.png)

  


## 接口代理的方式实现Dao层

![image-20211021131404115](img/image-20211021131404115.png)

![image-20211021131710264](img/image-20211021131710264.png)

![image-20211021131809867](img/image-20211021131809867.png)

![image-20211021132125555](img/image-20211021132125555.png)

![image-20211021132309415](img/image-20211021132309415.png)

## 映射配置文件-动态sql

![image-20211021132845968](img/image-20211021132845968.png)

![image-20211021133030922](img/image-20211021133030922.png)

![image-20211021133057289](img/image-20211021133057289.png)

![image-20211021133451672](img/image-20211021133451672.png)

![image-20211021133356107](img/image-20211021133356107.png)

![image-20211021133713469](img/image-20211021133713469.png)

![image-20211021133844926](img/image-20211021133844926.png)

## 核心配置文件-分页插件

![image-20211021133955105](img/image-20211021133955105.png)

![image-20211021134039318](img/image-20211021134039318.png)

![image-20211021134250421](img/image-20211021134250421.png)

![image-20211021134346620](img/image-20211021134346620.png)

![image-20211021134510487](img/image-20211021134510487.png)

## 多表操作

![image-20211021135934633](img/image-20211021135934633.png)

![image-20211021140443420](img/image-20211021140443420.png)

![image-20211021140252122](img/image-20211021140252122.png)

  ![image-20211021141928985](img/image-20211021141928985.png)

![image-20211021142005081](img/image-20211021142005081.png)

![image-20211021143200915](img/image-20211021143200915.png) 

## 注解开发

![image-20211021204634187](img/image-20211021204634187.png)

## 注解多表操作

![image-20211021210831386](img/image-20211021210831386.png)

![image-20211021210709023](img/image-20211021210709023.png)

![image-20211021211442622](img/image-20211021211442622.png)

![image-20211021211226890](img/image-20211021211226890.png)

![image-20211021212237227](img/image-20211021212237227.png)

![image-20211021211951647](img/image-20211021211951647.png)

![image-20211021212333680](img/image-20211021212333680.png)

## 构建SQL语句

![image-20211021212543425](img/image-20211021212543425.png)

![image-20211021212854009](img/image-20211021212854009.png)

![image-20211021212928141](img/image-20211021212928141.png)

![image-20211021212951305](img/image-20211021212951305.png)

![image-20211021213249515](img/image-20211021213249515.png)

![image-20211021213209340](img/image-20211021213209340.png)

![image-20211021213325161](img/image-20211021213325161.png)

![image-20211021213427454](img/image-20211021213427454.png)
