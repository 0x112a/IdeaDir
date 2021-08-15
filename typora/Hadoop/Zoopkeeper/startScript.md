# 启动脚本

```shell
#!/bin/bash

case $1 in
"start"){
	for i in master slave1 slave2 slave3
	do
		echo ---------------------- zookeeper $i start
		ssh $i "/opt/module/apache-zookeeper-3.7.0-bin/bin/zkServer.sh start"
	done
}
;;
"stop"){
	for i in master slave1 slave2 slave3
	do
		---------------------- zookeeper $i stop
		ssh $i "/opt/module/apache-zookeeper-3.7.0-bin/bin/zkServer.sh stop"
	done
}
;;
"status"){
	for i in master slave1 slave2 slave3
	do
		---------------------- zookeeper $i status
		ssh $i "/opt/module/apache-zookeeper-3.7.0-bin/bin/zkServer.sh status"
	done
}
;;
esac
```

