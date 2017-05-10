/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadevida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import persona.Persona;

/**
 *
 * @author edgar
 */
public class Utilidad {
    private static final SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
    public static String dateToString (Date date){
        return formatter.format(date);
    }
    
    public static Date stringToDate(String date) throws ParseException{
        return formatter.parse(date);
    }
    
    public static void Escribir(String dir,boolean caso,String datos) throws IOException{
          FileWriter escribir = null;
          PrintWriter pw=null;
          
         // File fichero;
          
          escribir= new FileWriter(dir,caso);
          pw= new PrintWriter(escribir);
          String vector[]= datos.split("\n");
            for (String string : vector) {
                pw.write(string+"\n");
            }
        
        if (escribir!=null){
            try {
                escribir.close();
            } catch (IOException ex) {
                 System.out.printf("ERROR");
            }
            }
    }
    public static String leerFichero(String dir) throws IOException{
            Persona a= null;
            File archivo = null;
            FileReader fr= null;
            BufferedReader br= null;
            archivo = new File (dir);
            try{
                fr= new FileReader(archivo);
                br= new BufferedReader(fr);
                StringBuilder aux= new StringBuilder();
                String linea;
                while ((linea=br.readLine())!=null){
                    aux.append(linea+"\n");
                }    
                return aux.toString();
            }catch(Exception aed){
                return "";
            }
    }
    public static String calularEdad(String fecha){
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fecha, fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        int years = periodo.getYears();
        int mes= periodo.getMonths();
        int dias=periodo.getDays();
        return "Años:"+years+" Meses:"+mes+" Dias:"+dias;
    }
    public static boolean verificarExistenciaCorreo(VentanaPrincipal a,String correo){
        for (Persona aux : a.usuarios) {
            if (aux.getEmail().equals(correo)){
                return false;
            }
        }
        return true;
    }
}
