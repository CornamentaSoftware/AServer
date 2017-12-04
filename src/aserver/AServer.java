/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aserver;

import java.io.*;
import Encriptacion.AES;
import java.net.*;

/**
 *
 * @author Alumno
 */
public class AServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, Exception {
        //Se crea un ServerSocket para que actúe como servidor para el cliente
        int miPuerto= 5000;
        ServerSocket srv = new ServerSocket(miPuerto);
        Socket socket = srv.accept();
        InputStream flujoE = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(flujoE));
        String mensaje = reader.readLine();
        OutputStream flujoS = socket.getOutputStream();
        PrintWriter escritor = new PrintWriter(new OutputStreamWriter(flujoS));
        System.out.println(mensaje);
        String datos[] = new String[3];

        //Aquí checa qué datos recibió y los mete en un arreglo
        for(int i=0, j=0; i<mensaje.length() && j<3; i++){
            if(mensaje.charAt(i)==' '){
                datos[j] = mensaje.substring(0,i);
                mensaje = mensaje.substring(i+1);
                i=0;
                j++;
            }
        }
        System.out.println("Aún sirve");
        //Busca al usuario
        Base base = new Base();
        if(base.buscarUsuario(datos[2])){
            mensaje = datos[0] + " " + datos[1];
            AES cifrar = new AES();
            String ticketI = cifrar.Encriptar(mensaje, "CFRR");
            System.out.println(ticketI);
            escritor.println("Correcto");
            escritor.flush();
            //Se manda una respuesta al cliente "Correcto"
            //Aquí se crea un socket para actuar como cliente con el servidor de tickets
            int puertoTS= 3500;
            InetAddress ipTS= InetAddress.getByName("192.168.1.72");
            //IP del servidor de tickets, pero quién sabe en qué máquina quede
            Socket socket2 = new Socket(ipTS, puertoTS);
            OutputStream flujoS2 = socket2.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(flujoS2));
            writer.println(ticketI);
            writer.flush();
            socket2.close();
        }
        //Si existe, se manda su IP y el servicio que requiere al servidor de tickets, 
        //cifrado con AES y con la clave CFRR, que ambos conocen
        else{
            escritor.println("Error");
            escritor.flush();
            System.out.println("kk");
        }
        //Si no existe, se envía un mensaje de error al cliente xdxd
        
    }
    
}
