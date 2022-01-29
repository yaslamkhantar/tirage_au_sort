package org.socket.serverMt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Server extends Thread {
private int nombreclient=13990;
private List<Conversation> clients=new ArrayList<Conversation>();
	private String[] loto= {"fleur","maroc","destin","lumiere","avion","cafe"};
	public static void main(String[] args) {
		System.out.println("----------Démarrage du serveur------------ ");
		new Server().start();
	//	System.out.println("je suis en bas de server().start()");
	}
	
	@Override
	public void run() {
		try {
	
			
			ServerSocket sc=new ServerSocket(1298);
	
			while(true) {
				System.out.println();

				System.out.println();
				System.out.println();
			
				System.out.println(" chosir 1 parmi ses éléments suivant  :   [  fleur - maroc - destin - lumiere - avion - cafe]");
				System.out.println();
				System.out.println();
				
				System.out.println("******  Nombre des joueurs  : "+(++nombreclient));
				Socket ss=sc.accept();
				//++nombreclient;
				
				
				Conversation cv=new Conversation(ss,nombreclient);
				
				clients.add(cv);
				cv.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	class Conversation extends Thread{
		
		
		protected int nbrclinet;
		
		protected Socket soc;
		public Conversation(Socket soc,int nbrclient) {
			this.soc=soc;this.nbrclinet=nbrclient;
		}
		
		public void podcast(String message) {
			for(Conversation cl:clients) {
				try {
					PrintWriter pw=new PrintWriter(cl.soc.getOutputStream(),true);
					pw.println(pw);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		@Override
		public void run() {
			System.out.println();
			try {
				InputStream is=this.soc.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				OutputStream os=this.soc.getOutputStream();
				PrintWriter pw=new PrintWriter(os,true);
				System.out.println("client numéro "+(++nbrclinet));
				pw.println("vous etes le client numero "+(nbrclinet));
				while(true) {
					String req=br.readLine();
					int longueur_chaine=req.length();
					int size_tableau=new Random().nextInt(loto.length);
					//System.out.println(loto[size_tableau]);
					//pw.println(longueur_chaine);
					String valeur=loto[size_tableau];
					System.out.println("la valeur générée par le serveur "+loto[size_tableau]);
					if((req.compareTo(valeur)==0)) {
						System.out.println("------------------------- ");
						System.out.println("------------------------- ");
					
						System.out.println(" Bravo , vous avez gagné ");
						System.out.println("------------------------- ");
						System.out.println("------------------------- ");
					}
					else {
						System.out.println("------------------------- ");
						System.out.println("------------------------- ");
					
						System.out.println("Désolé , retenter encore une fois");
						System.out.println("------------------------- ");
						System.out.println("------------------------- ");
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

