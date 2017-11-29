
package Encriptacion;


public class AES {

    
    public String Encriptar(String dato, String clave) throws Exception{
        String datoEnc=AESFeo.encrypt(dato,  clave);
        return datoEnc;
    }
    
    public String Desencriptar(String datoEnc, String clave) throws Exception{
        String datoDec=AESFeo.decrypt(datoEnc, clave);
        return datoDec;
    }
}
