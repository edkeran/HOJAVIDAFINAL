/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadevida;

import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author edgar
 */
public class DialogoArchivos extends JDialog{
    JFileChooser archivo1;
    File imagen;
    String direccion;
    public DialogoArchivos(PanelImagen main) {
        setSize(1000, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        archivo1= new JFileChooser();
        setLayout(null);
        archivo1.setBounds(0, 0, 1000, 600);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");
        archivo1.setAcceptAllFileFilterUsed(false);
        archivo1.setFileFilter(filtro);
        archivo1.showOpenDialog(null);
        add(archivo1);
        imagen=archivo1.getSelectedFile();
        if (imagen!=null){
            direccion=imagen.toString();
            main.setDireccion(direccion);
            main.repintar();
            dispose();
        }
        else{
            dispose();
        }
        
    }
    
}
