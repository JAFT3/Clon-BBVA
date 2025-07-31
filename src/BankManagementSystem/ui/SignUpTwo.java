package BankManagementSystem.ui;

import BankManagementSystem.process.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpTwo extends JFrame implements ActionListener{
    JLabel additionalDetails, curp, rfc, id, comprobante, ingreso, ocupacion, tipo_cuenta, existente;
    JTextField curpTf, rfcTf, numId, ingresoTf;
    JRadioButton ine, pasaporte, agua, luz, telefono, asalariado, independiente, jubilado,
            ahorro, nomina, empresarial, si_existe, no_existe;
    ButtonGroup grupoID, grupoComprobante, grupoOcupacion, grupoCuenta, grupoExiste;
    String formno;

    JButton siguiente;
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

    SignUpTwo(String formno) {
        this.formno = formno;
        getContentPane().setBackground(Login.azulBbva);
        setSize(850, 800);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        additionalDetails = new JLabel("Pagina 2: Informacion Adicional");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(260, 80, 400, 30);
        additionalDetails.setForeground(Color.white);
        add(additionalDetails);

        //CURP
        curp = crearLabel("CURP:", 100, 140, 100, 30);
        curpTf = crearTextField(350, 140, 400, 30);

        //RFC
        rfc = crearLabel("RFC:", 100, 190, 100, 30);
        rfcTf = crearTextField(350, 190, 400, 30);

        /*IDENTIFICACION OFICIAL
         * [] INE/IFE
         * [] PASAPORTE
         * NUMERO IDENTIFICACION*/

        id = crearLabel("Identificacion oficial:", 100, 240, 200, 30);
        ine = crearRadioButton("INE/IFE", 350, 240, 100, 30);
        pasaporte = crearRadioButton("Pasaporte", 500, 240, 100, 30);
        numId = crearTextField(600, 240, 150, 30);

        grupoID = new ButtonGroup();
        grupoID.add(ine);
        grupoID.add(pasaporte);

        /*COMPROBANTE DOMICILIO
        [] LUZ
        [] AGUA
        [] TELEFONO
         */
        comprobante = crearLabel("Comprobante Domicilio", 100, 290, 200, 30);
        luz = crearRadioButton("Luz", 350, 290, 60, 30);
        agua = crearRadioButton("Agua", 500, 290, 60, 30);
        telefono = crearRadioButton("Telefono", 650, 290, 100, 30);

        grupoComprobante = new ButtonGroup();
        grupoComprobante.add(luz);
        grupoComprobante.add(agua);
        grupoComprobante.add(telefono);

        //INGRESO MENSUAL
        ingreso = crearLabel("Ingreso", 100, 340, 150, 30);
        ingresoTf = crearTextField(350, 340, 400, 30);

        /*OCUPACION
        [] ASALARIADO
        [] INDEPENDIENTE
        [] JUBILADO/PENSIONADO
         */
        ocupacion = crearLabel("Ocupacion", 100, 390, 150, 30);
        asalariado = crearRadioButton("Asalariado", 350, 390, 100, 30);
        independiente = crearRadioButton("Independiente", 500, 390, 100, 30);
        jubilado = crearRadioButton("Jubilado", 650, 390, 100, 30);

        grupoOcupacion = new ButtonGroup();
        grupoOcupacion.add(asalariado);
        grupoOcupacion.add(independiente);
        grupoOcupacion.add(jubilado);

        /*TIPO CUENTA
        [] AHORRO
        [] NOMINA
        [] EMPRESARIAL
         */
        tipo_cuenta = crearLabel("Tipo de cuenta", 100, 440, 150, 30);
        ahorro = crearRadioButton("Ahorro", 350, 440, 100, 30);
        nomina = crearRadioButton("Nomina", 500, 440, 100, 30);
        empresarial = crearRadioButton("Empresarial", 650, 440, 100, 30);

        grupoCuenta = new ButtonGroup();
        grupoCuenta.add(ahorro);
        grupoCuenta.add(nomina);
        grupoCuenta.add(empresarial);

        /* CLIENTE EXISTENTE
        [] SI
        [] NO
         */
        existente = crearLabel("¿Cliente existente?", 100, 490, 200, 30);
        si_existe = crearRadioButton("SI", 350, 490, 60, 30);
        no_existe = crearRadioButton("NO", 500, 490, 60, 30);

        grupoExiste = new ButtonGroup();
        grupoExiste.add(si_existe);
        grupoExiste.add(no_existe);

        siguiente = new JButton("Siguiente");
        siguiente.setBackground(Login.azulBbva2);
        siguiente.setForeground(Color.WHITE);
        siguiente.setFont(new Font("Raleway", Font.BOLD, 14));
        siguiente.setBounds(630,660,120,30);
        siguiente.addActionListener(this);
        add(siguiente);
    }

    public void actionPerformed(ActionEvent ae){
        String curp = curpTf.getText();
        String rfc = rfcTf.getText();
        String ingreso = ingresoTf.getText();
        String id_num = numId.getText();

        String id = null;
        if(ine.isSelected()) {
            id = "INE";
        } else if (pasaporte.isSelected()) {
            id = "Pasaporte";
        }

        String comprobante = null;
        if (agua.isSelected()) {
            comprobante = "Agua";
        } else if (luz.isSelected()) {
            comprobante = "Luz";
        } else if (telefono.isSelected()) {
            comprobante = "Telefono";
        }

        String ocupacion = null;
        if (asalariado.isSelected()) {
            ocupacion = "Asalariado";
        } else if (independiente.isSelected()) {
            ocupacion = "Independiente";
        } else if (jubilado.isSelected()) {
            ocupacion = "Jubilado";
        }

        String tipo_cuenta = null;
        if(ahorro.isSelected()) {
            tipo_cuenta = "Ahorro";
        } else if (nomina.isSelected()) {
            tipo_cuenta = "Nomina";
        } else if (empresarial.isSelected()) {
            tipo_cuenta = "Empresarial";
        }

        String cliente_existente = null;
        if(si_existe.isSelected()) {
            cliente_existente = "Cliente Existente";
        } else if (no_existe.isSelected()) {
            cliente_existente = "No existente";
        }

        try {
            if (curp.equals("") || rfc.equals("") || ingreso.equals("")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                Conexion c = new Conexion();
                String query = "insert into signuptwo values('"+curp+"','"+rfc+"','"+ingreso+"','"+id+"'," +
                        "'"+id_num+"','"+comprobante+"','"+ocupacion+"','"+tipo_cuenta+"', '"+cliente_existente+"')";
                c.s.executeUpdate(query);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
