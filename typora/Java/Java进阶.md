# Java 进阶

1. **异常处理**

   1. 异常类继承层次

      - Throwable
        - Error
          - VirtualMechineError
          - LinkageError
          - AWTRError
        - Exception
          - RuntimeException
            - IndexOutOfBoundsException
            - DateTimeParseException
            - NullPointerException
            - ClassCastException
            - ArithmeticException
            - ...
          - IOException
            - FileNotFoundException
            - ...
          - ParseException

   2. 所有的异常类都直接或间接地继承于java.lang.Throwable类。其中有几个非常重要的方法：

      - String getMessage（）：获得发生异常的详细信息
      - void printStackTrace（）：打印异常堆栈跟踪信息。
      - String toString（）：获得异常对象描述。

   3. Error是程序无法恢复的严重错误。

   4. Exception是程序可以恢复的异常。

   5. 受检查时异常和运行时异常

   6. 捕获异常

      1. try-catch语句

      2. 多catch代码块，一个catch捕获到一个异常时，其他的catch代码块就不在进行匹配。

      3. 当捕获的多个异常类之间存在父子类关系时，捕获异常的顺序与catch代码块的顺序有关。一般先捕获子类，后捕获父类，否则子类捕获不到。

      4. try-catch语句可以任意嵌套

      5. 多重捕获

         1. ```java 
            try{
                
            }catch (FileNotFoundException a){
                
            }catch(IOException b){
                
            }
            
            //等价于
            try{
                
            }catch(FileNotFoundException | IOException e){
                
            } 
            ```

      6. finally 代码块释放资源

      7. 自动资源管理

      8. throws与声明方法抛出异常

         1. 在一个方法中如果能够处理异常，则需要捕获并处理。但是若方法没有能力处理该异常 捕获它没有任何意义，此时需要在方法 后面 明抛出 该异常 ，通知上层调用者该方法有可能发生异常 
         2. 方法后面声明抛出使用 throws 关键字。
         3. 如果声明抛出的多个异常类之间有父子关系，可以只声明抛出父类。但在没有父子类关系的情况下，最好声明抛出每一个异常。

   7. 自定义异常类需要继承Exception或RuntimeException或其子类

   8. throw与显式抛出异常

      1. ```java
         throw Throwable 或其他子类实例。
         ```

   9. throw显式抛出的异常与系统生成并抛出的异常在处理方式上没有区别，就是两种方法：**要么自己处理，要么抛给上层调用者。**

2. 对象容器——集合

   1. List
   2. Set
   3. Map

3. 泛型（generics）

   1. 

