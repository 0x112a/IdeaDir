# Go Mod(包管理工具)

### 1. go mod init 初始化项目

### 2.大写导出，小写私有![image-20210712094405233](./assets/image-20210712094405233.png)



### 3.Note：

![image-20210712095022407](./assets/image-20210712095022407.png)

### 导入初始化顺序

![image-20210712100340049](./assets/image-20210712100340049.png)

![image-20210712095814895](./assets/image-20210712095814895.png)

### 第三方包的使用

1. 下载安装包

   ``` go 
    
   go get github.com/shopspring/decimal （全局）
   //第二种
   go mod download （全局）
   ```

   

2. go mod vendor 将依赖复制到vendor目录下