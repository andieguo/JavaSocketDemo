package com.andieguo.socket_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(5678);
		// ʹ��accept()�����ȴ��ͻ������пͻ������������һ��Socket���󣬲�����ִ��
		Socket client = server.accept();
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
	}
}