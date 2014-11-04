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
		// ����һ��ServerSocket�ڶ˿�5678�����ͻ�����
		ServerSocket server = new ServerSocket(5678);
		while (true) {
			// ʹ��accept()�����ȴ��ͻ������пͻ������������һ��Socket���󣬲�����һ���̶߳�ȡ�ͻ���Socket���͹��������ݡ�
			// ��ǰ�߳����߳�ִ����֮������ִ����һ��accept()�����ȴ��ͻ�����һ���пͻ����������������һ��Socket���󣬲���������һ���̶߳�ȡ�ͻ���Socket���͹��������ݡ�
			MultiTalkServer mc = new MultiTalkServer(server.accept());
			mc.start();
		}
	}
}
