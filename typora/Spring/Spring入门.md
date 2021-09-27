# Spring



## 概述

1. Spring是轻量级的开源javaEE框架
2. Spring可以解决企业应用开发的复杂性
3. Spring有两个核心部分：IOC和AOP
   1. IOC控制翻转：把创建对像的过程交给Spring进行管理
   2. AOP面向切面：不修改源码进行功能增加功能增强
4. Spring特点 
   1. 方便解耦，简化开发
   2. AOP编程支持
   3. 方便程序测试
   4. 方便和其他框架整合
   5. 方便进行事务操作
   6. 降低API开发难度

## IOC容器

1. 什么是IOC：控制翻转，把对象创建和对象之间的调用过程，交给Spring进行管理
2. 使用IOC的目的：为了耦合度降低

### IOC底层原理

1. xml解析，工厂模式，反射

2. 工厂模式实现

   ```java
   class UserDao{
       add(){
           ...
       }
   }
   
   //原始方法
   class UserService{
       execute(){
           UserDao userDao = new UserDao();
           userDao.add();
       }
   }
   
   
   //工厂类
   class UserFactory{
       //注意这是个静态方法
       public static UserDao getDao(){
           return new UserDao;
       }
   }
   //工厂模式
   class UserService{
       execute(){
           UserDao dao = UserFacotory.getDao();
           dao.add();
       }
   }
   //目的，耦合度降低最低限度
   ```

3. xml方式

   ```java
   // 第一步配置xml配置文件，配置创建的对象--进一步降低耦合
   <bean id="dao" class="com.intoan.UserDao"></bean>
   //有service类和dao类，创建工厂类
   class UserFactory{
       public static UserDao getDao(){
           String classValue = class属性值;//xml解析
           Class clazz = Class.forName(classValue); //通过反射创建对象
           return (UserDao)clazz.newInstance();
       }
   }
   //
   ```

### IOC接口

1. IOC思想基于IOC容器完成，IOC容器底层就是对象工厂
2. Spring提供IOC容器实现两种方式：（两个接口）
   1. **BeanFactory**：IOC容器基本实现，是Spring内部的使用接口，一般不提供开发人员进行使用。
      - 加载配置文件的时候不会创建对象，在获取对象（使用）的时候采取创建对象
   2. **ApplicationContext**：BeanFactory接口的子接口，提供更多更为强大的功能，一般由开发人员进行使用
      - 加载配置文件的时候就会把在配置文件对象进行创建
   3. 实现类

### IOC操作 Bean管理

1. 什么是Bean管理
   - Bean管理指的是两个操作
   - Spring创建对象
   - Spring注入属性

Bean 管理操作有两种方式

#### IOC操作——基于xml文件方式

基于xml创建对象

1. 在Spring配置文件中使用Bean标签，标签里面添加对应属性，就可以实现对象创建
2. 在bean标签中有很多属性，介绍常用的属性
   - id属性：唯一标识
   - class 属性:类的全路径
   - name：类似Id
3. 创建对象时默认执行无参的构造方法，完成对象的创建

基于xml方式注入属性

1. DI： 依赖注入，就是注入属性（DI是IOC中的一种实现）
2. 使用Set方法注入
   - name：类里面属性名称
   - value： 向属性注入的值
3. 使用有参构造方法注入
4. 

#### IOC操作——基于注解方式





