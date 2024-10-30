/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pagosofa_db", "root", "K4NAEriol89720ryok4naeDSBAA4378monday");
            System.out.println("Conexión exitosa a MySQL!");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;

        try {
            st = cn.con.createStatement();
            rs = st.executeQuery("SELECT * FROM usuario");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("User") + " " + rs.getString("dni"));
            }

            cn.con.close();
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }
}