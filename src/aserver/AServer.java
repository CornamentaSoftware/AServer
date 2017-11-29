/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import Encriptacion.AES;

/**
 *
 * @author Alumno
 */
public class AServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, Exception {
        while(true){
            int puertoTS= 3000;
            int miPuerto= 5000;
            InetAddress ipTS= InetAddress.getByName("192.168.9.255");
            //IP del servidor de tickets, pero quién sabe en qué máquina quede
            Socket socket = new Socket(miPuerto);

            String mensaje = socket.recibe();
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

            //Busca al usuario
            Base base = new Base();
            if(base.buscarUsuario(datos[2])){
                mensaje = datos[0] + " " + datos[1];

                AES cifrar = new AES();
                String ticketI = cifrar.Encriptar(mensaje, "CFRR");
                socket.envia(ipTS, puertoTS, ticketI);
            }
            //Si existe, se manda su IP y el servicio que requiere al servidor de tickets, 
            //cifrado con AES y con la clave CFRR, que ambos conocen
            else{
                socket.envia(InetAddress.getByName(datos[0]), 4000, "Error");
            }
            //Si no existe, se envía un mensaje de error al cliente xdxd
            socket.close();
        }
    }
    
}
