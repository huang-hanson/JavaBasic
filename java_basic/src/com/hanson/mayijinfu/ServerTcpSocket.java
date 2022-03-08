package com.hanson.mayijinfu;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerTcpSocket {
    static byte[] bytes = new byte[1024];

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            // 1.创建一个ServerSocket连接
            final ServerSocket serverSocket = new ServerSocket();
            // 2.绑定端口号
            serverSocket.bind(new InetSocketAddress(8080));
            // 3.当前线程放弃cpu资源等待获取数据
            System.out.println("等待获取数据...");
            while (true) {
                final Socket socket = serverSocket.accept();
                executorService.execute(new Runnable() {
                    public void run() {
                        try {
                            System.out.println("获取到数据...");
                            // 4.读取数据
                            int read = socket.getInputStream().read(bytes);
                            String result = new String(bytes);
                            System.out.println(result);
                        } catch (Exception e) {

                        }
                    }
                });

            }
        } catch (Exception e) {

        }
    }
}
