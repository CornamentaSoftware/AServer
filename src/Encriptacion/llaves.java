/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encriptacion;

import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class llaves {

    char[] datos;
    String tabla1 = "";
    private String [] c = new String[16];
    private String c1="";
    private String [] k = new String [16];
    private String [] r = new String [17];  
    private String [] l = new String [17];
    int cont=0,contl =0, contr=0, contk=0;
    private String datocifrado="";

    public void tabla1(String clave, String cifrado) {

        char[] datos = clave.toCharArray();

        tabla1 = Character.toString(datos[56]) + Character.toString(datos[48]) + Character.toString(datos[40]) + Character.toString(datos[32]) + Character.toString(datos[24])
                + Character.toString(datos[16]) + Character.toString(datos[8]) + Character.toString(datos[0]) + Character.toString(datos[57]) + Character.toString(datos[49])
                + Character.toString(datos[41]) + Character.toString(datos[33]) + Character.toString(datos[25]) + Character.toString(datos[17]) + Character.toString(datos[9])
                + Character.toString(datos[1]) + Character.toString(datos[58]) + Character.toString(datos[50]) + Character.toString(datos[42]) + Character.toString(datos[34])
                + Character.toString(datos[26]) + Character.toString(datos[18]) + Character.toString(datos[10]) + Character.toString(datos[2]) + Character.toString(datos[59])
                + Character.toString(datos[51]) + Character.toString(datos[43]) + Character.toString(datos[35]) + Character.toString(datos[62]) + Character.toString(datos[54])
                + Character.toString(datos[46]) + Character.toString(datos[38]) + Character.toString(datos[30]) + Character.toString(datos[22]) + Character.toString(datos[14])
                + Character.toString(datos[6]) + Character.toString(datos[61]) + Character.toString(datos[53]) + Character.toString(datos[45]) + Character.toString(datos[37])
                + Character.toString(datos[29]) + Character.toString(datos[21]) + Character.toString(datos[13]) + Character.toString(datos[5]) + Character.toString(datos[60])
                + Character.toString(datos[52]) + Character.toString(datos[44]) + Character.toString(datos[36]) + Character.toString(datos[28]) + Character.toString(datos[20])
                + Character.toString(datos[12]) + Character.toString(datos[4]) + Character.toString(datos[27]) + Character.toString(datos[21]) + Character.toString(datos[11])
                + Character.toString(datos[3]);

        //System.out.println(tabla1);
        String mitad1 = tabla1.substring(0, 28);
        String mitad2 = tabla1.substring(28, 56);
        String inicial = mitad1 + mitad2;
        
        for (int i=0; i<16; i++)
            {
                if (i == 0)
                {
                    c[i] = mitades(inicial, true);
                }
                else
                {
                    if (i == 1 || i==8 || i==15)
                        c[i] = mitades(c[i-1], true);
                    else
                        c[i] = mitades(c[i-1], false);
                }
            }
        
         for (int i=0; i<16; i++)
            {
                k[i] = key(c[i]);
            }

        datocifrado=cifrar(cifrado);

        System.out.println("Numero cifrado: " + datocifrado);
        //System.out.println(k10);
        //System.out.println(mitad1 + "  " + mitad2);
    }

    public String mitades(String cadena, boolean tipo) {
        String clave = "";
        String mitad11 = cadena.substring(0, 28);
        String mitad22 = cadena.substring(28, 56);

        if (tipo == true) {
            clave = claves1(mitad11, mitad22);
        } else {
            clave = claves2(mitad11, mitad22);
        }

        return clave;
    }

    public String claves1(String mit1, String mit2) {
        String cc = "";
        String dd = "";

        char[] c = mit1.toCharArray();
        char[] d = mit2.toCharArray();

        for (int i = 2; i < 29; i++) {

            cc = cc + (Character.toString(c[i - 1]));
            dd = dd + (Character.toString(d[i - 1]));

        }
        cc = cc + (Character.toString(c[0]));
        dd = dd + (Character.toString(d[0]));

        String clave = cc + dd;
        return clave;
    }

    public String claves2(String mit1, String mit2) {
        String cc = "";
        String dd = "";

        char[] c = mit1.toCharArray();
        char[] d = mit2.toCharArray();

        for (int i = 3; i < 29; i++) {

            cc = cc + (Character.toString(c[i - 1]));
            dd = dd + (Character.toString(d[i - 1]));

        }
        cc = cc + (Character.toString(c[0])) + (Character.toString(c[1]));
        dd = dd + (Character.toString(d[0])) + (Character.toString(d[1]));

        String clave = cc + dd;
        return clave;
    }

    public String key(String k) {
        String llave = "";
        char[] datosk = k.toCharArray();

        llave = Character.toString(datosk[13]) + Character.toString(datosk[16]) + Character.toString(datosk[10]) + Character.toString(datosk[23]) + Character.toString(datosk[0])
                + Character.toString(datosk[4]) + Character.toString(datosk[2]) + Character.toString(datosk[27]) + Character.toString(datosk[14]) + Character.toString(datosk[5])
                + Character.toString(datosk[20]) + Character.toString(datosk[9]) + Character.toString(datosk[22]) + Character.toString(datosk[18]) + Character.toString(datosk[11])
                + Character.toString(datosk[3]) + Character.toString(datosk[25]) + Character.toString(datosk[7]) + Character.toString(datosk[15]) + Character.toString(datosk[6])
                + Character.toString(datosk[26]) + Character.toString(datosk[19]) + Character.toString(datosk[12]) + Character.toString(datosk[1]) + Character.toString(datosk[40])
                + Character.toString(datosk[51]) + Character.toString(datosk[30]) + Character.toString(datosk[36]) + Character.toString(datosk[46]) + Character.toString(datosk[54])
                + Character.toString(datosk[29]) + Character.toString(datosk[39]) + Character.toString(datosk[50]) + Character.toString(datosk[44]) + Character.toString(datosk[32])
                + Character.toString(datosk[47]) + Character.toString(datosk[43]) + Character.toString(datosk[48]) + Character.toString(datosk[38]) + Character.toString(datosk[55])
                + Character.toString(datosk[33]) + Character.toString(datosk[52]) + Character.toString(datosk[45]) + Character.toString(datosk[41]) + Character.toString(datosk[49])
                + Character.toString(datosk[35]) + Character.toString(datosk[28]) + Character.toString(datosk[31]);

        return llave;
    }

    public String dame(int tipo) {

        String resultado="";
        
        resultado="k" + cont + ": " + k[cont];
        
        cont=cont+1;
        System.out.println(resultado);
        return resultado;
    }
    
    public String dame2(){
        String res = datocifrado;
        return res;
    }
    
    public String cifrar(String num){
        String peri=permutacioni(num);
        
        for (int i=0; i<16; i++){
                r[i+1] = extension(r[i]);
                l[i+1] = r[i];
        }
        
        String casi=r[16] + l[16];
        String cifrado=perfinal(casi);
        
        return cifrado;
    }
    
    public String permutacioni(String ini) {
        String per = "", ext="";
        char[] datosi = ini.toCharArray();

        per = Character.toString(datosi[57]) + Character.toString(datosi[49]) + Character.toString(datosi[41]) + Character.toString(datosi[33]) + Character.toString(datosi[25])
                + Character.toString(datosi[17]) + Character.toString(datosi[9]) + Character.toString(datosi[1]) + Character.toString(datosi[59]) + Character.toString(datosi[51])
                + Character.toString(datosi[43]) + Character.toString(datosi[35]) + Character.toString(datosi[27]) + Character.toString(datosi[19]) + Character.toString(datosi[11])
                + Character.toString(datosi[3]) + Character.toString(datosi[61]) + Character.toString(datosi[55]) + Character.toString(datosi[45]) + Character.toString(datosi[37])
                + Character.toString(datosi[29]) + Character.toString(datosi[21]) + Character.toString(datosi[13]) + Character.toString(datosi[5]) + Character.toString(datosi[63])
                + Character.toString(datosi[55]) + Character.toString(datosi[47]) + Character.toString(datosi[39]) + Character.toString(datosi[31]) + Character.toString(datosi[23])
                + Character.toString(datosi[15]) + Character.toString(datosi[7]) + Character.toString(datosi[56]) + Character.toString(datosi[48]) + Character.toString(datosi[40]) + Character.toString(datosi[32])
                + Character.toString(datosi[24]) + Character.toString(datosi[16]) + Character.toString(datosi[8]) + Character.toString(datosi[0]) + Character.toString(datosi[58])
                + Character.toString(datosi[50]) + Character.toString(datosi[42]) + Character.toString(datosi[34]) + Character.toString(datosi[26]) + Character.toString(datosi[18])
                + Character.toString(datosi[10]) + Character.toString(datosi[2]) + Character.toString(datosi[60]) + Character.toString(datosi[52]) + Character.toString(datosi[44])
                + Character.toString(datosi[36]) + Character.toString(datosi[28]) + Character.toString(datosi[20]) + Character.toString(datosi[12]) + Character.toString(datosi[4])
                + Character.toString(datosi[62]) + Character.toString(datosi[54]) + Character.toString(datosi[46]) + Character.toString(datosi[38]) + Character.toString(datosi[30])
                + Character.toString(datosi[24]) + Character.toString(datosi[14]) + Character.toString(datosi[6]);

        l[0] = per.substring(0, 32);
        r[0] = per.substring(32, 64);
        return per;
    }
    
    public String extension(String ex) {
        String extendido="";
        char[] datose = ex.toCharArray();

        extendido = Character.toString(datose[31]) + Character.toString(datose[0]) + Character.toString(datose[1]) + Character.toString(datose[2]) + Character.toString(datose[3])
                + Character.toString(datose[4]) + Character.toString(datose[3]) + Character.toString(datose[4]) + Character.toString(datose[5]) + Character.toString(datose[6])
                + Character.toString(datose[7]) + Character.toString(datose[8]) + Character.toString(datose[7]) + Character.toString(datose[8]) + Character.toString(datose[9])
                +  Character.toString(datose[10]) + Character.toString(datose[11]) + Character.toString(datose[12])
                + Character.toString(datose[11]) + Character.toString(datose[12]) + Character.toString(datose[13]) + Character.toString(datose[14]) + Character.toString(datose[15])
                + Character.toString(datose[16]) + Character.toString(datose[15]) + Character.toString(datose[16]) + Character.toString(datose[17]) + Character.toString(datose[18])
                + Character.toString(datose[19]) + Character.toString(datose[20]) + Character.toString(datose[19]) + Character.toString(datose[20]) + Character.toString(datose[21])
                + Character.toString(datose[22]) + Character.toString(datose[23]) + Character.toString(datose[24]) + Character.toString(datose[23]) + Character.toString(datose[24])
                + Character.toString(datose[25]) + Character.toString(datose[26]) + Character.toString(datose[27]) + Character.toString(datose[28]) + Character.toString(datose[27])
                + Character.toString(datose[28]) + Character.toString(datose[29]) + Character.toString(datose[30]) + Character.toString(datose[31]) + Character.toString(datose[0]);
        
        String llaveexp=llavesmasexp(extendido);
        
        contr=contr+1;
        return llaveexp;
    }
    
   public String llavesmasexp(String dato){
        String kmase="";
        String clave=k[contk];

        for (int i=0; i<dato.length(); i++){
            kmase+= (dato.charAt(i)^clave.charAt(i));
        }
        
        String f=sTabla(kmase);
        contk=contk+1;
        return f;
    }
   
   public static final int[][][] S ={
            {
                {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
            },
            {
                {15, 1,  8,  14, 6,  11, 3,  4,  9,  7,  2,  13, 12, 0,  5,  10},
                {3,  13, 4,  7,  15, 2,  8,  14, 12, 0,  1,  10, 6,  9,  11, 5},
                {0,  14, 7,  11, 10, 4,  13, 1,  5,  8,  12, 6,  9,  3,  2,  15},
                {13, 8,  10, 1,  3,  15, 4,  2,  11, 6,  7,  12, 0,  5,  14, 9}
            },
            {
                {10, 0,  9,  14, 6,  3,  15, 5,  1,  13, 12, 7,  11, 4,  2,  8},
                {13, 7,  0,  9,  3,  4,  6,  10, 2,  8,  5,  14, 12, 11, 15, 1},
                {13, 6,  4,  9,  8,  15, 3,  0,  11, 1,  2,  12, 5,  10, 14, 7},
                {1,  10, 13, 0,  6,  9,  8,  7,  4,  15, 14, 3,  11, 5,  2,  12}
            },
            {
                {7,  13, 14, 3,  0,  6,  9,  10, 1,  2,  8,  5,  11, 12, 4,  15},
                {13, 8,  11, 5,  6,  15, 0,  3,  4,  7,  2,  12, 1,  10, 14, 9},
                {10, 6,  9,  0,  12, 11, 7,  13, 15, 1,  3,  14, 5,  2,  8,  4},
                {3,  15, 0,  6,  10, 1,  13, 8,  9,  4,  5,  11, 12, 7,  2,  14}
            },
            {
                    {2,  12, 4,  1,  7,  10, 11, 6,  8,  5,  3,  15, 13, 0,  14, 9},
                    {14, 11, 2,  12, 4,  7,  13, 1,  5,  0,  15, 10, 3,  9,  8,  6},
                    {4,  2,  1,  11, 10, 13, 7,  8,  15, 9,  12, 5,  6,  3,  0,  14},
                    {11, 8,  12, 7,  1,  14, 2,  13, 6,  15, 0,  9,  10, 4,  5,  3}
            },
            {
                    {12, 1,  10, 15, 9,  2,  6,  8,  0,  13, 3,  4,  14, 7,  5,  11},
                    {10, 15, 4,  2,  7,  12, 9,  5,  6,  1,  13, 14, 0,  11, 3,  8},
                    {9,  14, 15, 5,  2,  8,  12, 3,  7,  0,  4,  10, 1,  13, 11, 6},
                    {4,  3,  2,  12, 9,  5,  15, 10, 11, 14, 1,  7,  6,  0,  8,  13}
            },
            {
                    {4,  11, 2,  14, 15, 0,  8,  13, 3,  12, 9,  7,  5,  10, 6,  1},
                    {13, 0,  11, 7,  4,  9,  1,  10, 14, 3,  5,  12, 2,  15, 8,  6},
                    {1,  4,  11, 13, 12, 3,  7,  14, 10, 15, 6,  8,  0,  5,  9,  2},
                    {6,  11, 13, 8,  1,  4,  10, 7,  9,  5,  0,  15, 14, 2,  3,  12}
            },
            {
                    {13, 2,  8,  4,  6,  15, 11, 1,  10, 9,  3,  14, 5,  0,  12, 7},
                    {1,  15, 13, 8,  10, 3,  7,  4,  12, 5,  6,  11, 0,  14, 9,  2},
                    {7,  11, 4,  1,  9,  12, 14, 2,  0,  6,  10, 13, 15, 3,  5,  8},
                    {2,  1,  14, 7,  4,  10, 8,  13, 15, 12, 9,  0,  3,  5,  6,  11}
            }
    };
   
   int[] permutacionp = {
		16, 7,  20, 21,
		29, 12, 28, 17,
		1,  15, 23, 26,
		5,  18, 31, 10,
		2,  8,  24, 14,
		32, 27, 3,  9,
		19, 13, 30, 6,
		22, 11, 4,  25
	};
   
   public String sTabla(String b){
        String salida="";
        
        for(int i=0;i<S.length;i++){
            String bloqueseis = b.substring(i*6,(i+1)*6);
            String ab= ""+bloqueseis.charAt(0)+bloqueseis.charAt(bloqueseis.length()-1);
            String med= bloqueseis.substring(1,bloqueseis.length()-1);

            int[] col= S[i][Integer.parseInt(ab,2)];

            String row =""+ col[Integer.parseInt(med,2)];
            row =""+ binarisacion(row);

            salida+=row;
        }
        String res="";
        for(int i=0;i<permutacionp.length;i++){
            res+=salida.substring(permutacionp[i]-1,permutacionp[i]);
        }
        
        String xorf = xorfinal(res);
        return xorf;
    }
   
   public String binarisacion(String plainText){
        String textobinario=Integer.toBinaryString(Integer.parseInt(plainText));
        String res="";
        for(int i=0;i<(4-textobinario.length());i++){
            res+=0;
        }
        res+=textobinario;
        return res;
    }
   
   public String xorfinal(String f){
       String r1="";
       
       for (int i=0; i<f.length(); i++){
            r1 += (f.charAt(i)^l[contl].charAt(i));
        }
       
       contl=contl+1;
       return r1;
   }
   
   public String perfinal(String finalp){
       String numerocifrado = "";
       
       for(int i=0;i<permutacionf.length;i++){
            numerocifrado+=finalp.substring(permutacionf[i]-1,permutacionf[i]);
        }
       
       return numerocifrado;
   }
   
   int[] permutacionf = {
            40, 8, 48, 16, 56, 24, 64, 32,
            39, 7, 47, 15, 55, 23, 63, 31,
            38, 6, 46, 14, 54, 22, 62, 30,
            37, 5, 45, 13, 53, 21, 61, 29,
            36, 4, 44, 12, 52, 20, 60, 28,
            35, 3, 43, 11, 51, 19, 59, 27,
            34, 2, 42, 10, 50, 18, 58, 26,
            33, 1, 41, 9, 49, 17, 57, 25
	};
}
