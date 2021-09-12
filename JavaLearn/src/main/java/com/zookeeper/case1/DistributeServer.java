package com.zookeeper.case1;

import org.apache.zookeeper.*;

import java.io.IOException;

public class DistributeServer {

    private String connectString = "master:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zk;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        DistributeServer server = new DistributeServer();

        //
        server.getConnect();

        server.regist(args[0]);

        server.business();
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void regist(String hostname) throws InterruptedException, KeeperException {
        String create= zk.create("/servers/",hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

        System.out.println(hostname + " is online");

    }

    private void getConnect() throws IOException {
        zk = new ZooKeeper(connectString,sessionTimeout,new Watcher(){
            @Override
            public void process(WatchedEvent event) {

            }
        });
    }

}
