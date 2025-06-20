package BankManagementSystem.process;

import java.sql.*;

public class Conexion {
    public Connection c;
    public Statement s;
    public Conexion() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbva", "root", "");
            s = c.createStatement();
            System.out.println("Conexión exitosa a la base de datos");
        }catch (Exception e){
            System.out.println(e);

        }
    }
}
