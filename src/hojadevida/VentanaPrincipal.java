/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadevida;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import persona.Persona;

/**
 *
 * @author edgar
 */
public class VentanaPrincipal extends JFrame implements ActionListener{
    PanelInformacion info;
    PanelImagen imagen;
    List<Persona> usuarios = new ArrayList<Persona>();
    JMenuBar aux;
    JMenu menu;
    JMenuItem m1,m2,m3;
    public VentanaPrincipal() {
        setSize(1000,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        imagen = new PanelImagen();
        info= new PanelInformacion(this,imagen);
        aux=new JMenuBar();
        menu= new JMenu("Principal");
        
        
        setLayout(null);
        info.setBounds(0, 20, 500, 300);
        imagen.setBounds(520,20,470,300);
        m1=new JMenuItem("Lista Completa de Hojas de Vida");
        m1.addActionListener(this);
        m1.setActionCommand("LISTA");
        aux.setBounds(0, 0,1000, 20);
        setJMenuBar(aux);
        menu.add(m1);
        aux.add(menu);
        recuperarInfo();
        
        add(info);
        add(imagen);
        add(aux);
        
        setVisible(true);
    }
    public void anadir(Persona persona1){
        usuarios.add(persona1);
    }
    private void recuperarInfo(){
        String datos;
        try {
            String vector [];
            datos=Utilidad.leerFichero("Fichero/Archivo.txt");
            System.out.print(datos);
            if (datos!=""){
                vector=datos.split("\n");
            for (int i=0;i<vector.length;i++){
                Persona aux=new Persona();
                String vector2[];
                vector2=vector[i].split(";");
                aux.setNombre(vector2[0]);
                aux.setApellido(vector2[1]);
                aux.setEmail(vector2[2]);
                aux.setProfesion(vector2[3]);
                try {
                    aux.setFechaNacimiento(Utilidad.stringToDate(vector2[4]));
                } catch (ParseException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                aux.setID(Double.parseDouble(vector2[5]));
                aux.setImagen(vector2[6]);
                aux.setGen(vector2[7]);
                aux.setEdad(vector2[8]);
                anadir(aux);
            }
        }
       }catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
    }
 }   
    @Override
    public void actionPerformed(ActionEvent e) {
         VentanaTablaHojas tabla =new VentanaTablaHojas(this);
    }
    public List getUsuarios() {
        return usuarios;
    }
    
}
