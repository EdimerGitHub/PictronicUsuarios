/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Edimer Castro Molina
 * Analisis y desarrollo de software SENA ADSO
 * ficha  2627062
 */
public class ConexionJdbc {
    public static Connection getConexionJdbc(){
        Connection conexion = null;
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/pictronic";
        
        try{    
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        }catch(Exception e){
            e.printStackTrace();
        }       
        return conexion;
    }   
    
}

