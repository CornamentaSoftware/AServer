package Encriptacion;

import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import aserver.Conexion;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AESFeo {

    static String correoUsuario="";
    static byte a, b,c,d;
    
    private static final String Algo = "AES";
    private static byte[] keyValue = new byte[]{a,b,c,d,a,b,c,d,a,b,c,d,a,b,c,d};

    public static String encrypt(String contrasenia, String correo) throws Exception {
        a=caractera(correo);
        b=caracterb(correo);
        c=caracterc(correo);
        d=caracterd(correo);
        
        Key key = generateKey();
        Cipher c = Cipher.getInstance(Algo);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValores = c.doFinal(contrasenia.getBytes());
        String encriptadoValores = new BASE64Encoder().encode(encValores);
        return encriptadoValores;
    }

    public static String decrypt(String contrasenia, String correo) throws Exception {
        a=caractera(correo);
        b=caracterb(correo);
        c=caracterc(correo);
        d=caracterd(correo);
        
        Key key = generateKey();
        Cipher c = Cipher.getInstance(Algo);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodificarValores = new BASE64Decoder().decodeBuffer(contrasenia);
        byte[] descifrarvalores= c.doFinal(decodificarValores);
        String decodificartexto = new String(descifrarvalores);
        return decodificartexto;
    }

    private static Key generateKey() {
        Key key = new SecretKeySpec(keyValue, Algo);
        return key;
    }
    
    public static byte caractera(String correoUsuario){
        char a = 0;
        byte b=0;
        
        a=correoUsuario.charAt(0);
        b=Convertir(a);
        
        return b;
    }
    
    public static byte caracterb(String correoUsuario){
        char a = 0;
        byte b=0;
        
        a=correoUsuario.charAt(1);
        b=Convertir(a);
        
        return b;
    }
    
    public static byte caracterc(String correoUsuario){
        char a = 0;
        byte b=0;
        
        a=correoUsuario.charAt(2);
        b=Convertir(a);
        
        return b;
    }
    
    public static byte caracterd(String correoUsuario){
        char a = 0;
        byte b=0;
        
        a=correoUsuario.charAt(3);
        b=Convertir(a);
        
        return b;
    }
    
    public static byte Convertir(char owp){
        byte a=0;
        a=(byte)owp;
        
        return a;
    }
}
