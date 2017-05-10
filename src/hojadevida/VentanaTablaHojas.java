/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadevida;

import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persona.Persona;

/**
 *
 * @author edgar
 */
public class VentanaTablaHojas extends JDialog{
   panelHojas panel;
   VentanaPrincipal menu;
    public VentanaTablaHojas(VentanaPrincipal menu) {
        this.menu=menu;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        iniciar();
        setVisible(true);
    }
    private void iniciar(){
        setSize(1200, 800);
        setLocation(350, 20);
        setResizable(false);
        setTitle("Hojas de Vida");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);        
        setLayout(null);
        
        panel = new panelHojas();
        panel.setBackground(Color.WHITE);
        panel.setBounds(20, 15, 1200, 800);
        add(panel);
        actualizarTabla();
        setVisible(true);
    }
    
    public void actualizarTabla(){
        for (Persona ayu: menu.usuarios){
            panel.actualizarTabla(ayu.getNombre(),ayu.getApellido(),Double.toString(ayu.getID()) ,ayu.getFechaNacimiento().toString(),ayu.getEdad(),ayu.getEmail(),ayu.getGen(),ayu.getProfesion(),ayu.getImagen());
        }
    }
}
