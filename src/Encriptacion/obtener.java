/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encriptacion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author rodri
 */
public class obtener{        
        public String convertir(String clavei, String numero) {        
            String cifrado="";
            llaves com = new llaves();
            com.tabla1(clavei, numero);

            cifrado=com.dame2(); 
            return cifrado;
        }
}
