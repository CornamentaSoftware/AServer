/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aserver;
import java.net.*;
import java.io.*;
/**
 *
 * @author Ana
 */
public class Socket extends DatagramSocket{
	static final int MAX_LON= 500;
	public Socket(int numPuerto) throws SocketException{
		super(numPuerto);
	}
	public void envia(InetAddress maquinaR, int puertoR, String mensaje) throws IOException{
		byte[] almacenE= mensaje.getBytes();
		DatagramPacket datagrama= new DatagramPacket(almacenE, almacenE.length, maquinaR, puertoR);
		this.send(datagrama);
	}//fin de envia mensaje
	
	public String recibe() throws IOException{
		byte[] almacenR= new byte[MAX_LON];
		DatagramPacket datagrama= new DatagramPacket(almacenR, MAX_LON);
		this.receive(datagrama);
		String mensaje= new String(almacenR);
		return mensaje;
	} //fin de recibemensaje
}// fin de class

