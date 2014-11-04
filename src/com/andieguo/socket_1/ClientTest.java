package com.andieguo.socket_1;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientTest {
	public static void main(String[] args) throws Exception {
		//本机作为服务器，所以服务器地址是本机的ip地址，本机同时又是客户端
		Socket socket = new Socket("127.0.0.1", 8888);//服务器端的ip地址和端口号
		DataInputStream in = new DataInputStream(socket.getInputStream());// 读取服务端发来的消息
		String msg = in.readUTF();
		System.out.println(msg);
	}
}
