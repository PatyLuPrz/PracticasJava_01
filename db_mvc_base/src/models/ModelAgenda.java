/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Zeo
 */
public class ModelAgenda {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private String nombre;
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método que realiza las siguietnes acciones:
     * 1.- Conecta con la base agenda_mvc.
     * 2.- Consulta todo los registros de la tabla contactos.
     * 3.- Obtiene el nombre y el email y los guarda en las variables globales
     * nombre y email.
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda_mvc", "user_mvc", "pass_mvc.2018");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM contactos;");
            rs.next();
            nombre = rs.getString("nombre");
            email = rs.getString("email");
            this.setEmail(email);
            this.setNombre(nombre);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 001: " + err.getMessage());
        }

    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al primer registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverPrimerRegistro(){
        System.out.print("Programa accion moverPrimerRegistro");
       try {
            rs.first();
            llenarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 004" + ex.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al siguiente registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverSiguienteRegistro(){
        System.out.print("Programa accion moverSiguienteRegistro");
         try {
            if (!rs.isLast()) {
                rs.next();
                llenarDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 003" + ex.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al anterior registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverAnteriorRegistro(){
        System.out.print("Programa accion moverAnteriorRegistro");
          try {
            if (!rs.isFirst()) {
                rs.previous();
                llenarDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 004" + ex.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al ultimo registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverUltimoRegistro(){
        System.out.print("Programa accion moverUltimoRegistro");
        try {
            rs.last();
            llenarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 005" + ex.getMessage());
        }
    }

    private void llenarDatos() {
        try {
            this.setNombre(rs.getString("nombre"));
            this.setEmail(rs.getString("email"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 006" + ex.getMessage());
        }        
    }
}
