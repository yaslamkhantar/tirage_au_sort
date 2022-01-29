package org.socket.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
Socket s=new Socket("localhost",1194);
InputStream is=s.getInputStream();
OutputStream os=s.getOutputStream();
os.write(300);
int reponse=is.read();
System.out.println(reponse);
	}

}
