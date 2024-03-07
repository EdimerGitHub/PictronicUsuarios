/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author usuar
 */
public class OperacionesBD {
    //con ese metodo listamos los usuarios existentes
    public static ArrayList<Usuario> listarUsuarios(){
        ArrayList<Usuario> data = new ArrayList<Usuario>(); // creamos una lista de Usuarios
        ResultSet rs;
        Usuario nuevoUsuario;
        
        try{
            Connection conexion = ConexionJdbc.getConexionJdbc(); //conectamos con la base de datos
            String sentencia = "SELECT * FROM usuarios";// esta es nuestra consulta
            PreparedStatement consulta = conexion.prepareStatement(sentencia);
            rs = consulta.executeQuery(sentencia);
            while(rs.next()){
                nuevoUsuario = new Usuario(rs.getInt("idUsuario"),
                                        rs.getInt("rolUsuario"),
                                        rs.getString("claveUsuario"),
                                        rs.getString("aliasUsuario"),
                                        rs.getInt("cedulaUsuario"),
                                        rs.getString("nombreUsuario"),
                                        rs.getString("apellidoUsuario"),
                                        rs.getString("nacimientoUsuario"),
                                        rs.getString("sexoUsuario"),
                                        rs.getString("rhUsuario"),
                                        rs.getString("direccionUsuario"),
                                        rs.getInt("telefonoUsuario"),
                                        rs.getString("emailUsuario"),
                                        rs.getString("creacionUsuario")
                                        );                                                                                                                                                                                                                                                                                                               
                data.add(nuevoUsuario);
            }  
        }catch(SQLException e){
            System.out.println("Error"+e.getMessage());
        }
        return data;
    }
    
    // con este metodo verificamos si el usuario es jefe especialista, esto es porque no se pueden eliminar estos usarios ya que son los admin principales
    public static boolean esJefeEspecialista(String cedulaUsuario){
        boolean esJefe = false;
        ResultSet rs;
        try{
            Connection conexion = ConexionJdbc.getConexionJdbc();
            String sentencia = "SELECT rolUsuario FROM usuarios WHERE cedulaUsuario =? AND rolUsuario = 1";
            PreparedStatement consulta = conexion.prepareStatement(sentencia);
            consulta.setString(1, cedulaUsuario);
            rs = consulta.executeQuery();
            esJefe = rs.next();           
        }catch(SQLException e){
            System.out.println("Error"+e.getMessage());
        }      
        return esJefe;
    }
    
    // con este metodo verificamos si el usuario existe en la BD
    public static boolean existeUsuario(String cedulaUsuario){
        boolean existe = false;
        ResultSet rs;
        try{
            Connection conexion = ConexionJdbc.getConexionJdbc();
            String sentencia = "SELECT nombreUsuario FROM usuarios WHERE cedulaUsuario =?";
            PreparedStatement consulta = conexion.prepareStatement(sentencia);
            consulta.setString(1, cedulaUsuario);
            rs = consulta.executeQuery();
            existe = rs.next();           
        }catch(SQLException e){
            System.out.println("Error"+e.getMessage());
        }      
        return existe;
    }
       
    //con este metodo agregamos un nuevo usuario a la base de datos desde el formulario de agregar un nuevo usuario
    public static boolean agregarUsuario(Usuario nuevoUsuario){
        boolean exito = true;
        try{
            Connection conexion = ConexionJdbc.getConexionJdbc();
            String sentencia = "INSERT INTO usuarios (rolUsuario,claveUsuario,aliasUsuario,cedulaUsuario,nombreUsuario,apellidoUsuario,nacimientoUsuario,sexoUsuario,rhUsuario,direccionUsuario,telefonoUsuario,emailUsuario,creacionUsuario) "
                                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement consulta = conexion.prepareStatement(sentencia);
            //consulta.setInt(1, nuevoUsuario.getIdUsuario());// el id no lo agregramos porque es autoincremental en la BD
            consulta.setInt(1, nuevoUsuario.getRolUsuario());
            consulta.setString(2,nuevoUsuario.getClaveUsuario());
            consulta.setString(3,nuevoUsuario.getAliasUsuario());
            consulta.setInt(4,nuevoUsuario.getCedulaUsuario());
            consulta.setString(5,nuevoUsuario.getNombreUsuario());
            consulta.setString(6,nuevoUsuario.getApellidoUsuario());
            consulta.setString(7,nuevoUsuario.getNacimientoUsuario());
            consulta.setString(8,nuevoUsuario.getSexoUsuario());
            consulta.setString(9,nuevoUsuario.getRhUsuario());
            consulta.setString(10,nuevoUsuario.getDireccionUsuario());
            consulta.setInt(11,nuevoUsuario.getTelefonoUsuario());
            consulta.setString(12,nuevoUsuario.getEmailUsuario());
            consulta.setString(13,nuevoUsuario.getCreacionUsuario());
            consulta.execute();
            consulta.close();
            conexion.close();

            
        }catch(SQLException e){
            System.out.println("Error"+e.getMessage());
            exito = false;
        }
        return exito;
    }
    
    //con este metodo eliminamos un usuario siempre y cuando no sea jefe especialista
    public static boolean eliminarUsuario(String cedulaUsuario){
        boolean exito = true;
        try{
            Connection conexion = ConexionJdbc.getConexionJdbc();
            String sentencia = "DELETE FROM usuarios WHERE  cedulaUsuario = ?";
            PreparedStatement consulta = conexion.prepareStatement(sentencia);
            consulta.setInt(1,Integer.parseInt(cedulaUsuario));
            
            consulta.execute();
            consulta.close();
            conexion.close();

            
        }catch(SQLException e){
            System.out.println("Error"+e.getMessage());
            exito = false;
        }
        return exito;
    }
    
    //con este metodo obtenemos los datos de un usuario segun su cedula
    public static Usuario getUsuario(String cedulaUsuario){
        Usuario usuario = null;
        ResultSet rs;
        try{
            Connection conexion = ConexionJdbc.getConexionJdbc();
            String sentencia = "SELECT * FROM usuarios WHERE cedulaUsuario =?";
            PreparedStatement consulta = conexion.prepareStatement(sentencia);
            consulta.setString(1, cedulaUsuario);
            rs = consulta.executeQuery();
            if(rs.next()){
                usuario = new Usuario(rs.getInt("idUsuario"),
                rs.getInt("rolUsuario"),
                rs.getString("claveUsuario"),
                rs.getString("aliasUsuario"),
                rs.getInt("cedulaUsuario"),
                rs.getString("nombreUsuario"),
                rs.getString("apellidoUsuario"),
                rs.getString("nacimientoUsuario"),
                rs.getString("sexoUsuario"),
                rs.getString("rhUsuario"),
                rs.getString("direccionUsuario"),
                rs.getInt("telefonoUsuario"),
                rs.getString("emailUsuario"),
                rs.getString("creacionUsuario")
                );  
                
            }else{
                
            }         
        }catch(SQLException e){
            System.out.println("Error"+e.getMessage());
        }      
        return usuario;
    }
    
    //con este metodo modificamos los datos de un usuario desde el formulario de modificacion, el id no se puede modificar
    public static boolean modificaUsuario(Usuario usuario){
        boolean exito = true;
        try{
            Connection conexion = ConexionJdbc.getConexionJdbc();
            String sentencia = "UPDATE usuarios SET    rolUsuario=?,claveUsuario=?,aliasUsuario=?,cedulaUsuario=?,"
                                                    + "nombreUsuario=?,apellidoUsuario=?,nacimientoUsuario=?,sexoUsuario=?,"
                                                    + "rhUsuario=?,direccionUsuario=?,telefonoUsuario=?,emailUsuario=?,creacionUsuario=? WHERE idUsuario=?";
            PreparedStatement consulta = conexion.prepareStatement(sentencia);
            consulta.setInt(1, usuario.getRolUsuario());
            consulta.setString(2,usuario.getClaveUsuario());
            consulta.setString(3,usuario.getAliasUsuario());
            consulta.setInt(4,usuario.getCedulaUsuario());
            consulta.setString(5,usuario.getNombreUsuario());
            consulta.setString(6,usuario.getApellidoUsuario());
            consulta.setString(7,usuario.getNacimientoUsuario());
            consulta.setString(8,usuario.getSexoUsuario());
            consulta.setString(9,usuario.getRhUsuario());
            consulta.setString(10,usuario.getDireccionUsuario());
            consulta.setInt(11,usuario.getTelefonoUsuario());
            consulta.setString(12,usuario.getEmailUsuario());
            consulta.setString(13,usuario.getCreacionUsuario());
            consulta.setInt(14, usuario.getIdUsuario());
            consulta.execute();
            consulta.close();
            conexion.close();

            
        }catch(SQLException e){
            System.out.println("Error"+e.getMessage());
            exito = false;
        }
        return exito;
    }
    
}

