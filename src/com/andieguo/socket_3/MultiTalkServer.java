package com.andieguo.socket_3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiTalkServer extends Thread {
	private Socket client;

	public MultiTalkServer(Socket c) {
		this.client = c;
	}

	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream());
			while (true) {
				String str = in.readLine();
				System.out.println(str);
				out.println("server has received message successfully!");
				out.flush();
				if (str.equals("end"))
					break;
			}
			client.close();
		} catch (IOException ex) {
		} finally {
			
		}
	}

	public static void main(String[] args) throws IOException {
		// 创建一个ServerSocket在端口5678监听客户请求
		ServerSocket server = new ServerSocket(5678);
		while (true) {
			// 使用accept()阻塞等待客户请求，有客户请求到来则产生一个Socket对象，并开启一个线程读取客户端Socket发送过来的数据。
			// 当前线程子线程执行完之后，立即执行下一个accept()阻塞等待客户请求，一旦有客户请求到来则产生另外一个Socket对象，并开启另外一个线程读取客户端Socket发送过来的数据。
			MultiTalkServer mc = new MultiTalkServer(server.accept());
			mc.start();
		}
	}
}
