/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadevida;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;
import persona.Persona;

/**
 *
 * @author Edgar Andres Krejci Bautista
 * @author Michael Leandro Cardenas
 */
public class PanelInformacion extends JPanel implements Interfaz,ActionListener{
    private JTextField name;
    private JTextField apellido;
    private JComboBox profesion;
    private JComboBox genero;
    private JTextField ID;
    private JTextField email;
    private JLabel labelName;
    private JLabel labelLastName;
    private JLabel labelID;
    private JLabel labelProfesion;
    private JLabel gen;
    private JLabel labelEmail;
    private JLabel labelDate;
    private JButton guardar;
    private Persona persona1;
    String fecha1;
    SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
    Date fechaNacimiento;
    JXDatePicker fecha;
    VentanaPrincipal menu;
    PanelImagen image;
    public PanelInformacion(VentanaPrincipal menu,PanelImagen image) {
        this.image=image;
        this.menu=menu;
        setLayout(null);
        setBackground(Color.CYAN);
        name= new JTextField();
        apellido= new JTextField();
        ID= new JTextField();
        labelName= new JLabel("INGRESE SU NOMBRE*");
        labelLastName= new JLabel("INGRESE SU APELLIDO*");
        labelID= new JLabel("INGRESE SU IDENTIFICACION*");
        labelProfesion= new JLabel("INGRESE SU PROFESION*");
        gen = new JLabel("INGRESE SU GENERO*");
        labelDate= new JLabel("SELECCIONE SU FECHA DE NACIMIENTO*");
        guardar = new JButton("GUARDAR");
        profesion= new JComboBox();
        genero= new JComboBox();
        email=new JTextField();
        fecha= new JXDatePicker();
        labelEmail= new JLabel("INGRESE SU CORREO ELECTRONICO*");
        labelName.setBounds(0, 0, 200, 20);
        name.setBounds(160, 0, 150, 20);
        labelLastName.setBounds(0, 20, 200, 20);
        apellido.setBounds(200, 20, 150, 20);
        labelID.setBounds(0, 40,200, 20);
        ID.setBounds(200, 40, 150, 20);
        labelProfesion.setBounds(0,60,200,20);
        profesion.setBounds(200,60,150,20);
        profesion.setModel(new DefaultComboBoxModel(profesiones.values()));
        gen.setBounds(0, 80, 200, 20);
        genero.setBounds(200, 80, 150, 20);
        genero.setModel(new DefaultComboBoxModel(Genero.values()));
        guardar.setBounds(100, 230, 100, 25);
        guardar.addActionListener(this);
        labelEmail.setBounds(0,100,250,20);
        email.setBounds(260,100,150,20);
        labelDate.setBounds(0, 120, 280, 20);
        fecha.setBounds(290, 120, 150, 20);
        add(fecha);
        add(labelDate);
        add(labelName);
        add(name);
        add(labelLastName);
        add(apellido);
        add(labelID);
        add(ID);
        add(labelProfesion);
        add(profesion);
        add(gen);
        add(genero);
        add(guardar);
        add(labelEmail);
        add(email);
    }

    @Override
    public void repintar() {
        repaint();
    }

    @Override
    public void mensajeError() {
        JOptionPane.showMessageDialog(this, "Debe Ingresar Solo Numeros y Solo puede tener un '.'", "MENSAJE", JOptionPane.ERROR_MESSAGE);
    }
    public void mensajeError(String a) {
        JOptionPane.showMessageDialog(this, "La Identificacion Ya Existe", "MENSAJE", JOptionPane.ERROR_MESSAGE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean validar=true;
        String fecha;
        if (name.getText().equals("")){
            labelName.setForeground(Color.red);
            validar=false;
        }
        else{
            labelName.setForeground(Color.BLACK);
        }
        if (this.apellido.getText().equals("")){
            labelLastName.setForeground(Color.red);
            validar=false;
        }
        else{
            labelLastName.setForeground(Color.BLACK);
        }
        if(ID.getText().equals("")){
            labelID.setForeground(Color.red);
            validar=false;
        }
        else{
            try{
                int cont=0;
                double ayu;
                labelID.setForeground(Color.BLACK);
                ayu=Double.parseDouble(ID.getText().toString());
                for (Persona usuario : menu.usuarios) {
                        if (usuario.getID()==ayu){
                            cont++;
                        }
                    }
                if (cont!=0){
                    mensajeError("mal");
                    validar=false;
                }
            }catch(NumberFormatException ae){
                mensajeError();
                labelID.setForeground(Color.red);
                validar=false;
            }
        }
        if (profesion.getSelectedItem().equals(profesiones.SELECCIONE)){
            labelProfesion.setForeground(Color.red);
            validar=false;
        }
        else{
            labelProfesion.setForeground(Color.BLACK);
        }
        if (genero.getSelectedItem().equals(Genero.SELECCIONE)){
            gen.setForeground(Color.red);
            validar=false;
        }
        else{
            gen.setForeground(Color.BLACK);
        }
        if (((Validar.correo(email.getText()))==false)){
            labelEmail.setForeground(Color.red);
            validar=false;
        }
        else{
            if (Utilidad.verificarExistenciaCorreo(menu, email.getText())){
                labelEmail.setForeground(Color.BLACK);
            }else{
                labelEmail.setForeground(Color.red);
                validar=false;
            }
        }
        if (this.fecha.getDate()==null){
            labelDate.setForeground(Color.red);
            validar=false;
        }
        else{
            Date feh=this.fecha.getDate();
            fecha1=formatter.format(feh);
            System.out.println(fecha1);
            if (validarFecha(fecha1)){
                labelDate.setForeground(Color.BLACK);
            } else {
                labelDate.setForeground(Color.red);
                validar=false;
            }
        }
        if (validar==true){
            try {
                String ayu;
                String edad;
                edad=Utilidad.calularEdad(fecha1);
                System.out.println("ENTRO AL TRUE"+edad);
                ayu=(name.getText().toString())+";"+(apellido.getText().toString())+";"+(email.getText().toString())+";"+(profesion.getSelectedItem().toString())+";"+(fecha1)+";"+(ID.getText().toString())+";"+image.getDireccion()+";"+genero.getSelectedItem().toString()+";"+edad;
                persona1= new Persona();
                persona1.setNombre(name.getText().toString());
                persona1.setApellido(apellido.getText().toString());
                persona1.setProfesion(profesion.getSelectedItem().toString());
                persona1.setEmail(email.getText().toString());
                persona1.setGen(genero.getSelectedItem().toString());
                persona1.setFechaNacimiento(this.fecha.getDate());
                persona1.setID(Double.parseDouble(ID.getText().toString()));
                persona1.setEdad(edad);
                persona1.setImagen(image.getDireccion());
                menu.anadir(persona1);
                Utilidad.Escribir("Fichero/Archivo.txt", true, ayu);
                name.setText("");
                apellido.setText("");
                profesion.setSelectedItem(profesiones.SELECCIONE);
                email.setText("");
                genero.setSelectedItem(Genero.SELECCIONE);
                this.fecha.setDate(null);
                ID.setText("");
                
            } catch (IOException ex) {
                Logger.getLogger(PanelInformacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private boolean validarFecha(String feh){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
        LocalDate fechaNac = LocalDate.parse(feh, fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        int years = periodo.getYears();
        System.out.println("LOS AÑOS SON"+years);
        int mes= periodo.getMonths();
        int ano=periodo.getDays();
        if ((years>=15)){
            return true;
        }
        else{
            return false;
        }
        }catch(java.time.format.DateTimeParseException asdk){
            return false;
        }
    }
}
