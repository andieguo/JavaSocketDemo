package com.andieguo.socket_1;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	public static void main(String args[]) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		// ˵���������ɹ����������ڵȴ��ͻ�������
		System.out.println("Listening...");
		while (true) {
			Socket socket = ss.accept();
			// ˵���пͻ�����������
			System.out.println("Client Connected...");
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("���Ƿ�����������");
			out.close();
			socket.close();
		}
	}
}
