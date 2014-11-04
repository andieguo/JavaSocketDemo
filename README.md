
###用javac命令编译带有包定义的java文件###
-------------
**1）源码**

>Hello.java（D:\Java）

    package com.test;
    public class Hello
    {
     public static void main(String args[])
     {
     System.out.println(“Hello”);
     }
    }

**2）编译**

>-d参数指明在当前目录按照源码包结构建立目录，并将字节码文件放在里面，即生成D:\Java\com\test\Hello.class

    D:\Java> javac Hello.java -d .\

**3）运行**


>在D:\Java路径下使用java命令运行Hello类，此时需指明完整的包名。

    D:\Java> java com.test.Hello

###运行SocketDemo例子2###
----------------------------
SocketDemo例子2实现了Socket客户端与Socket服务器端建立连接，
Socket客户端输入字符串后，Socket服务器端获取到客户端的字符串信息并打印,。

1）编译

    D:\SocketDemo>javac src\com\andieguo\socket_2\*.java -d bin\

2）运行

>开启一个终端，运行Socket服务器端；

     D:\SocketDemo>cd bin\
     D:\SocketDemo\bin> java com.andieguo.socket_2.TalkServer
     Client:hello


>开启另外一个终端，运行Socket客户端；

    D:\SocketDemo>cd bin\
    D:\SocketDemo\bin> java com.andieguo.socket_2.TalkClient
	hello #输入hello
    Client:hello

###运行SocketDemo例子3###
----------------------------
1）编译

    D:\SocketDemo>javac src\com\andieguo\socket_3\*.java -d bin\

2）运行

>开启第一个终端，运行Socket服务器端；


    F:\project\java\SocketDemo\bin>java com.andieguo.socket_3.MultiTalkServer
    hello,this is client1
    hello,this is client2
    hello,this is client1
    hello,this is client2


>开启第二个终端，运行Socket客户端1；

    F:\project\java\SocketDemo\bin>java com.andieguo.socket_3.TalkClient
    hello,this is client1
    server has received message successfully!
    hello,this is client1
    server has received message successfully!

>开启第三个终端，运行Socket客户端2；


    F:\project\java\SocketDemo\bin>java com.andieguo.socket_3.TalkClient
    hello,this is client2
    server has received message successfully!
    hello,this is client2
    server has received message successfully!

### 服务器/客户端Socket实现步骤 ###
---

- **服务器基本步骤：**

1）指定端口实例化一个SeverSocket  

    ServerSocket server = new ServerSocket(8888);

2）调用ServerSocket的accept()方法，以在等待连接期间造成阻塞  

    // 使用accept()阻塞等待客户请求，有客户请求到来则产生一个Socket对象，并继续执行
    Socket socket = server.accept();

3）获取位于该底层的Socket的流以进行读写操作  

    //获取服务器端Socket对象的输入流，通过该输入流读取客户端Socket数据。
    InputStream inputStream = socket.getInputStream()；
    //获取服务器端Socket对象的输出流，通过该输出流写数据到客户端Socket。
    OutputStream outputStream = socket.getOutputStream()；

4）把流封装进BufferedReader/PrintWriter的实例

	// 向客户端写数据：由服务器端Socket对象得到输出流，并构造PrintWriter对象
	PrintWriter os = new PrintWriter(socket.getOutputStream());
	// 读取客户端数据：由服务器端Socket对象得到输入流，经InputStreamReader将字节输入流转换为字符流
	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

5）对Socket进行读写  
6）关闭打开的流  

- **客户端基本步骤：**

1）通过IP地址和端口实例化Socket，请求连接服务器  

    Socket socket = new Socket("127.0.0.1", 8888);

2）获得Socket上的流以进行读写  

    //获取客户端Socket对象的输入流，通过该输入流读取服务器端Socket数据。
    InputStream inputStream = socket.getInputStream()；
    //获取客户端Socket对象的输出流，通过该输出流写数据到服务器端Socket。
    OutputStream outputStream = socket.getOutputStream()；


3）把流封装进BufferedReader/PrintWriter的实例  

	// 向服务器端写数据：由客户端Socket对象得到输出流，并构造PrintWriter对象
	PrintWriter os = new PrintWriter(socket.getOutputStream());
	// 读取服务器端数据：由客户端Socket对象得到输入流，经InputStreamReader将字节输入流转换为字符流
	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

4）对Socket进行读写  
5）关闭打开的流  