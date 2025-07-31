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

    private JLabel crearLabel(String texto, int x, int y, int width, int height) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Raleway", Font.BOLD, 20));
        label.setBounds(x, y, width, height);
        label.setForeground(Color.WHITE);
        add(label);
        return label;
    }

    private JTextField crearTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Raleway", Font.BOLD, 14));
        textField.setBounds(x, y, width, height);
        add(textField);
        return textField;
    }

    private JRadioButton crearRadioButton(String texto, int x, int y, int width, int height) {
        JRadioButton radioButton = new JRadioButton(texto);
        radioButton.setBounds(x, y, width, height);
        radioButton.setForeground(Color.WHITE);
        radioButton.setBackground(Login.azulBbva);  // Usando tu color personalizado
        radioButton.setFont(new Font("Raleway", Font.BOLD, 14));  // Estilo consistente
        add(radioButton);
        return radioButton;
    }

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

        nombre = crearLabel("Nombre:",100,140,100,30);
        nombreTf = crearTextField(350,140,400,30);

        apellidoPaterno = crearLabel("Apellido Paterno:",100,190,200,30);
        apellidoPaternoTf = crearTextField(350,190,400,30);

        fechaNacimiento = crearLabel("Fecha de nacimiento:", 100,240,250,30);

        dateChooser =  new JDateChooser();
        dateChooser.setBounds(350,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        genero = crearLabel("Genero:",100,290,200,30);

        hombre = crearRadioButton("Hombre",350,290,80,30);
        mujer = crearRadioButton("Mujer",500,290,80,30);

        grupoGenero = new ButtonGroup();
        grupoGenero.add(hombre);
        grupoGenero.add(mujer);

        email = crearLabel("Email", 100,340,200,30);
        emailTf = crearTextField(350,340,400,30);

        estadoCivil = crearLabel("Estado civil:", 100,390,200,30);

        casado = crearRadioButton("Casado",350,390,80,30);
        soltero = crearRadioButton("Soltero",500,390,80,30);
        otro = crearRadioButton("Otro",650,390,60,30);

        grupoEstadoCivil = new ButtonGroup();
        grupoEstadoCivil.add(casado);
        grupoEstadoCivil.add(soltero);
        grupoEstadoCivil.add(otro);

        direccion = crearLabel("Direccion:",100,440,200,30);
        direccionTf = crearTextField(350,440,400,30);

        estado = crearLabel("Estado:",100,490,200,30);
        estadoTf = crearTextField(350,490,400,30);

        ciudad = crearLabel("Ciudad:",100,540,200,30);
        ciudadTf = crearTextField(350,540,400,30);

        codigoPostal = crearLabel("Codigo Postal:", 100,590,200,30);
        codigoPostalTf = crearTextField(350,590,400,30);

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

               setVisible(false);
               new SignUpTwo(formno).setVisible(true);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
