package com.andieguo.socket_1;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientTest {
	public static void main(String[] args) throws Exception {
		//������Ϊ�����������Է�������ַ�Ǳ�����ip��ַ������ͬʱ���ǿͻ���
		Socket socket = new Socket("127.0.0.1", 8888);//�������˵�ip��ַ�Ͷ˿ں�
		DataInputStream in = new DataInputStream(socket.getInputStream());// ��ȡ����˷�������Ϣ
		String msg = in.readUTF();
		System.out.println(msg);
	}
}
