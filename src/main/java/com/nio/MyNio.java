package com.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/22
 */
public class MyNio {
    public void selector() throws Exception{
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //创建一个选择器
        Selector selector = Selector.open();
        //创建一个服务端的channel
        ServerSocketChannel channel = ServerSocketChannel.open();
        //channel设为非阻塞的
        channel.configureBlocking(false);
        //channel绑定到一个socket对象
        channel.bind(new InetSocketAddress(8080));
        //注册到选择器上监听的事件
        channel.register(selector, SelectionKey.OP_ACCEPT);

        while(true){
            Set selectedKey = selector.keys();

        }
    }
}
