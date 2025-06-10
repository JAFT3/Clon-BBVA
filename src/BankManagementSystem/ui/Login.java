package BankManagementSystem.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    private Color azulBbva = new Color(17, 0, 41);
    private Color azulBbva2 = new Color(42, 0, 87);

    JButton signupBttn, clearBtnn, loginBttn;
    JLabel bienvenida, numTarjeta, nip;
    JTextField tarjetaTF;
    JPasswordField nipTF;
    public Login(){
        //Propiedades del frame
        setTitle("Sistema Bancario");
        setSize(800,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(azulBbva);
        setLayout(null);
        setResizable(false);

        //Intentar agregar el logo

        try {
            ImageIcon logo = new ImageIcon("src/BankManagementSystem/resources/logo.png");
            Image logo2 = logo.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
            ImageIcon logo3 = new ImageIcon(logo2);
            JLabel label = new JLabel(logo3);
            label.setBounds(70,10,100,100 );
            add(label);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error cargando la imagen" +
                    e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            add(new JLabel("BBVA", SwingConstants.CENTER));
        }
        bienvenida = new JLabel("Bienvenido a BBVA");
        bienvenida.setFont(new Font("Osward", Font.BOLD, 38));
        bienvenida.setBounds(250,35,400,40);
        bienvenida.setForeground(Color.WHITE);
        add(bienvenida);

        numTarjeta = new JLabel("Numero de tarjeta");
        numTarjeta.setFont(new Font("Raleway", Font.BOLD, 18));
        numTarjeta.setBounds(150,100,250,40);
        numTarjeta.setForeground(Color.WHITE);
        add(numTarjeta);

        tarjetaTF = new JTextField();
        tarjetaTF.setBounds(150, 150, 500,30);
        tarjetaTF.setFont(new Font("Arial", Font.BOLD, 14));
        add(tarjetaTF);

        nip = new JLabel("NIP");
        nip.setFont(new Font("Raleway", Font.BOLD, 18));
        nip.setBounds(150,200,150,40);
        nip.setForeground(Color.WHITE);
        add(nip);

        nipTF = new JPasswordField();
        nipTF.setBounds(150,250,500,30);
        add(nipTF);

        loginBttn = new JButton("Iniciar Sesion");
        loginBttn.setBounds(300,350,230,30);
        loginBttn.setBackground(azulBbva2);
        loginBttn.setForeground(Color.WHITE);
        loginBttn.addActionListener(this);
        add(loginBttn);

        signupBttn = new JButton("Registrar");
        signupBttn.setBounds(300,300,100,30);
        signupBttn.setBackground(azulBbva2);
        signupBttn.setForeground(Color.WHITE);
        signupBttn.addActionListener(this);
        add(signupBttn);

        clearBtnn = new JButton("Clear");
        clearBtnn.setBounds(430,300,100,30);
        clearBtnn.setBackground(azulBbva2);
        clearBtnn.setForeground(Color.WHITE);
        clearBtnn.addActionListener(this);
        add(clearBtnn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clearBtnn){
            tarjetaTF.setText("");
            nipTF.setText("");
        }else if (ae.getSource() == loginBttn){


        } else if (ae.getSource() == signupBttn) {

        }
    }
}
