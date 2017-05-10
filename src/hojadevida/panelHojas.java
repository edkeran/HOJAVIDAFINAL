/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadevida;

import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author edgar
 */
public class panelHojas extends JPanel{
   VentanaPrincipal menu;
   JTable tabla;
   JLabel Imagen; 
   DefaultTableModel dtm;
   Object[] data;

    public panelHojas() {
        setBorder(BorderFactory.createTitledBorder(""));
        setLayout(null);
        Imagen= new JLabel(); 
       
        dtm= new DefaultTableModel();
        tabla = new JTable(dtm);
        
        tabla.setEditingColumn(20);
        
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellido");
        dtm.addColumn("Identificacion");
        dtm.addColumn("Fecha Nacimiento");
        dtm.addColumn("Edad");
        dtm.addColumn("Email");
        dtm.addColumn("Genero");
        dtm.addColumn("Profesion");
        dtm.addColumn("Imagen");
        //dtm.addRow(data);
        tabla.setDefaultRenderer(Object.class,new IconCellRenderer());
        tabla.setBounds(0, 0, 1200, 800);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.createVerticalScrollBar();
        scrollPane.setBounds(30, 20, 1000, 800);
        add(scrollPane);
    }
    
    
    public void actualizarTabla(String name,String apell,String ID,String fecha,String edad,String email,String genero,String profesion,String imagen){
        this.Imagen= new JLabel(); 
        data=new Object[9];
        data[0]=name;
        data[1]=apell;
        data[2]=ID;
        data[3]=fecha;
        data[4]=edad;
        data[5]=email;
        data[6]=genero;
        data[7]=profesion;
        ImageIcon nuevaImagen= new ImageIcon(imagen);
        this.Imagen.setIcon(new ImageIcon(nuevaImagen.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH)));
        data[8]=this.Imagen;
        dtm.addRow(data);
    }
}
