package com.andieguo.socket_1;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	public static void main(String args[]) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		// 说明服务器成功启动，正在等待客户端连接
		System.out.println("Listening...");
		while (true) {
			Socket socket = ss.accept();
			// 说明有客户端请求连接
			System.out.println("Client Connected...");
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("我是服务器端数据");
			out.close();
			socket.close();
		}
	}
}
