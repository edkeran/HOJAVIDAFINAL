/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadevida;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author edgar
 */
public class Validar {
   public static boolean correo(String correo){
   // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                              + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        if (mather.find() == true) {
            System.out.println("El email ingresado es válido.");
            return true;
        } else {
            System.out.println("El email ingresado es inválido.");
            return false;
        }
    }
   
   public static void fecha(String date){
       int dia,mes,ano;
       String vector [];
       vector=date.split("/");
       dia=Integer.parseInt(vector[0]);
   }

}
