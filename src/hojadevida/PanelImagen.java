/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadevida;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author edgar
 */
public class PanelImagen extends JPanel implements Interfaz,ActionListener{
    
    private JLabel imagen;
    private JButton boton;
    private String direccion="imagenes/persona.png";
    
    public PanelImagen() {
        setBackground(Color.WHITE);
        setLayout(null);
        boton= new JButton("Añadir Imagen");
        boton.addActionListener(this);
        boton.setBounds(0, 225, 180, 20);
        ImageIcon icon= new ImageIcon(direccion);
        imagen = new JLabel();
        imagen.setIcon(new ImageIcon(icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH)));
        imagen.setBounds(140, 0, 200, 200);
        add(imagen);
        add(boton);
    }
    
    @Override
    public void repintar() {
        ImageIcon nuevaImagen= new ImageIcon(direccion);
        imagen.setIcon(new ImageIcon(nuevaImagen.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH)));
        repaint();
    }

    @Override
    public void mensajeError() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DialogoArchivos archivo1 = new DialogoArchivos(this);
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
   
}
