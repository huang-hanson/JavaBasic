package com.hanson.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class MyServer {
    private int size = 1024;
    private ServerSocketChannel serverSocketChannel;
    private ByteBuffer byteBuffer;
    private Selector selector;
    private int remoteClientNum = 10;
    public MyServer(int port) {
        try {
            //在构造函数中国初始化Channel监听
            initChannel(port);
        }catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    //Channel的初始化
    private void initChannel(int port) throws IOException {
        //打开Channel
        serverSocketChannel = ServerSocketChannel.open();
        //设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress(port));
        System.out.println("listener on port:"+port);
        //选择器得创建
        selector = Selector.open();
        //先选择器注入通道
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //分配缓冲区的大小
        byteBuffer = ByteBuffer.allocate(size);
    }
    //监听器，用于监听Channel上的数据变化
    private void listener() throws IOException {
        while (true) {
            //返回的int值表示有多少个Channel处于就绪状态
            int n = selector.select();
            if( n == 0 ){
                continue;
            }
            //每个selector对应多个SelectionKey，每一个SelectionKey对应一个Channel
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                //如果key处于连接就绪状态，则开始接收客服端的连接
                if(key.isAcceptable()){
                    //获取Channel
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    //Channel接受连接
                    SocketChannel channel = server.accept();
                    //Channel注册
                    registerChannel(selector,channel,SelectionKey.OP_READ);
                    //远端客户端连接
                    remoteClientNum++;
                    System.out.println("online client num="+ remoteClientNum);
                    write(channel,"hello clinet".getBytes());
                }
                //如果通道已经处于读就绪状态
                if(key.isReadable()){
                    read(key);
                }
                iterator.remove();
            }
        }
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        byteBuffer.clear();
        //从通道中读取数据到缓冲区
        while ((count = socketChannel.read(byteBuffer))>0){
            //byteBuffer写模式变成读模式
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                System.out.println((char)byteBuffer.get());
            }
            byteBuffer.clear();
        }
        if (count < 0) {
            socketChannel.close();
        }
    }

    private void write(SocketChannel channel, byte[] writeData) throws IOException {
        byteBuffer.clear();
        byteBuffer.put(writeData);
        //byteBuffer从写入模式变成读模式
        byteBuffer.flip();
        //从缓冲区的数据写入通道中
        channel.write(byteBuffer);

    }

    private void registerChannel(Selector selector,SocketChannel channel,int opRead)throws IOException {
        if(channel == null){
            return;
        }
        channel.configureBlocking(false);
        channel.register(selector, opRead);
    }

    public static void main(String[] args) {
        try {
            MyServer myServer = new MyServer(9999);
            myServer.listener();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
