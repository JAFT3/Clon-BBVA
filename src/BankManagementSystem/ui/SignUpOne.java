package BankManagementSystem.ui;

import BankManagementSystem.process.Conexion;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class SignUpOne extends JFrame implements ActionListener {
    JLabel form, personalDetails, nombre, apellidoPaterno, fechaNacimiento, genero, email, estadoCivil, direccion, ciudad, estado, codigoPostal;
    JTextField nombreTf, apellidoPaternoTf, emailTf, direccionTf, ciudadTf, estadoTf, codigoPostalTf;
    JRadioButton hombre, mujer, casado, soltero, otro;
    ButtonGroup grupoEstadoCivil, grupoGenero;
    JDateChooser dateChooser;
    JButton siguiente;
    long random;

    SignUpOne(){
        getContentPane().setBackground(Login.azulBbva);
        setSize(850, 800);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        Random ran = new Random();
        random = ran.nextInt(9000);

        form = new JLabel("Formulario de solicitud No. " + random);
        form.setFont(new Font("Raleway", Font.BOLD, 30));
        form.setBounds(180,20,600,40);
        form.setForeground(Color.white);
        add(form);

        personalDetails = new JLabel("Pagina 1: Informacion Personal");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(260,80,400,30);
        personalDetails.setForeground(Color.white);
        add(personalDetails);

        nombre = new JLabel("Nombre:");
        nombre.setFont(new Font("Raleway", Font.BOLD, 20));
        nombre.setBounds(100,140,100,30);
        nombre.setForeground(Color.white);
        add(nombre);

        nombreTf = new JTextField();
        nombreTf.setFont(new Font("Raleway", Font.BOLD, 14));
        nombreTf.setBounds(350,140,400,30);
        add(nombreTf);

        apellidoPaterno = new JLabel("Apellido Paterno:");
        apellidoPaterno.setFont(new Font("Raleway", Font.BOLD, 20));
        apellidoPaterno.setBounds(100,190,200,30);
        apellidoPaterno.setForeground(Color.white);
        add(apellidoPaterno);

        apellidoPaternoTf = new JTextField();
        apellidoPaternoTf.setFont(new Font("Raleway", Font.BOLD, 14));
        apellidoPaternoTf.setBounds(350,190,400,30);
        add(apellidoPaternoTf);

        fechaNacimiento = new JLabel("Fecha de nacimiento:");
        fechaNacimiento.setFont(new Font("Raleway", Font.BOLD, 20));
        fechaNacimiento.setBounds(100,240,250,30);
        fechaNacimiento.setForeground(Color.white);
        add(fechaNacimiento);

        dateChooser =  new JDateChooser();
        dateChooser.setBounds(350,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        genero = new JLabel("Genero: ");
        genero.setFont(new Font("Raleway", Font.BOLD, 20));
        genero.setBounds(100,290,200,30);
        genero.setForeground(Color.white);
        add(genero);

        hombre = new JRadioButton("Hombre");
        hombre.setBounds(350,290,80,30);
        hombre.setForeground(Color.white);
        hombre.setBackground(Login.azulBbva);
        add(hombre);

        mujer = new JRadioButton("Mujer");
        mujer.setBounds(500,290,60,30);
        mujer.setForeground(Color.white);
        mujer.setBackground(Login.azulBbva);
        add(mujer);

        grupoGenero = new ButtonGroup();
        grupoGenero.add(hombre);
        grupoGenero.add(mujer);

        email = new JLabel("Email: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        email.setForeground(Color.white);
        add(email);

        emailTf = new JTextField();
        emailTf.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTf.setBounds(350,340,400,30);
        add(emailTf);

        estadoCivil = new JLabel("Estado Civil: ");
        estadoCivil.setFont(new Font("Raleway", Font.BOLD, 20));
        estadoCivil.setBounds(100,390,200,30);
        estadoCivil.setForeground(Color.white);
        add(estadoCivil);

        casado = new JRadioButton("Casado");
        casado.setBounds(350,390,80,30);
        casado.setForeground(Color.white);
        casado.setBackground(Login.azulBbva);
        add(casado);

        soltero = new JRadioButton("Soltero");
        soltero.setBounds(500,390,80,30);
        soltero.setForeground(Color.white);
        soltero.setBackground(Login.azulBbva);
        add(soltero);

        otro = new JRadioButton("Otro");
        otro.setBounds(650,390,60,30);
        otro.setForeground(Color.white);
        otro.setBackground(Login.azulBbva);
        add(otro);

        grupoEstadoCivil = new ButtonGroup();
        grupoEstadoCivil.add(casado);
        grupoEstadoCivil.add(soltero);
        grupoEstadoCivil.add(otro);

        direccion = new JLabel("Direccion: ");
        direccion.setFont(new Font("Raleway", Font.BOLD, 20));
        direccion.setBounds(100,440,200,30);
        direccion.setForeground(Color.white);
        add(direccion);

        direccionTf = new JTextField();
        direccionTf.setFont(new Font("Raleway", Font.BOLD, 14));
        direccionTf.setBounds(350,440,400,30);
        add(direccionTf);

        estado = new JLabel("Estado:");
        estado.setFont(new Font("Raleway", Font.BOLD, 20));
        estado.setBounds(100,490,200,30);
        estado.setForeground(Color.white);
        add(estado);

        estadoTf = new JTextField();
        estadoTf.setFont(new Font("Raleway", Font.BOLD, 14));
        estadoTf.setBounds(350,490,400,30);
        add(estadoTf);

        ciudad = new JLabel("Ciudad:");
        ciudad.setFont(new Font("Raleway", Font.BOLD, 20));
        ciudad.setBounds(100,540,200,30);
        ciudad.setForeground(Color.white);
        add(ciudad);

        ciudadTf = new JTextField();
        ciudadTf.setFont(new Font("Raleway", Font.BOLD, 14));
        ciudadTf.setBounds(350,540,400,30);
        add(ciudadTf);

        codigoPostal = new JLabel("Codigo Postal:");
        codigoPostal.setFont(new Font("Raleway", Font.BOLD, 20));
        codigoPostal.setBounds(100,590,200,30);
        codigoPostal.setForeground(Color.white);
        add(codigoPostal);

        codigoPostalTf = new JTextField();
        codigoPostalTf.setFont(new Font("Raleway", Font.BOLD, 14));
        codigoPostalTf.setBounds(350,590,400,30);
        add(codigoPostalTf);

        siguiente = new JButton("Siguiente");
        siguiente.setBackground(Login.azulBbva2);
        siguiente.setForeground(Color.WHITE);
        siguiente.setFont(new Font("Raleway", Font.BOLD, 14));
        siguiente.setBounds(630,660,120,30);
        siguiente.addActionListener(this);
        add(siguiente);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = "" + random; //Generador aleatorio de numero de telefono
        String nombre = nombreTf.getText();
        String apellido = apellidoPaternoTf.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String genero = null;
        if (hombre.isSelected()){
            genero = "Hombre";
        } else if (mujer.isSelected()) {
            genero = "Mujer";
        }
        String email = emailTf.getText();
        String estadoCivil = null;
        if (casado.isSelected()){
            estadoCivil = "Casado";
        }else if (soltero.isSelected()){
            estadoCivil = "Soltero";
        }else if (otro.isSelected()){
            estadoCivil = "Otro";
        }

        String direccion = direccionTf.getText();
        String ciudad = ciudadTf.getText();
        String estado = estadoTf.getText();
        String codigoPostal = codigoPostalTf.getText();

        try {
            if(nombre.equals("") || apellido.equals("")){
                JOptionPane.showMessageDialog(null, "Rellena los campos obligatorios");
            }else {
                Conexion c = new Conexion();
                String query = "insert into signup values('"+formno+"', '"+nombre+"', '"+apellido+"', '"+dob+"', '"+genero+"', '"+email+"', '"+estadoCivil+"'," +
                        " '"+direccion+"', '"+ciudad+"', '"+estado+"', '"+codigoPostal+"')";
               c.s.executeUpdate(query);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
