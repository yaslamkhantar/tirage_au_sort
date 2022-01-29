package org.socket.demonstration;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
ServerSocket serversocket=new ServerSocket(1208);
System.out.println("je suis dans la partie avant  accept");
Socket ss=serversocket.accept();
System.out.println("je suis dans la partie accept");

InputStream is=ss.getInputStream();
OutputStream os=ss.getOutputStream();

int nb=is.read();

int rep=nb+13;
os.write(rep);
ss.close();
	}

}
