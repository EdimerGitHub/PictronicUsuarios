/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author usuar
 */

public class Usuario {
    
    private int idUsuario;
    private int rolUsuario;
    private String claveUsuario;
    private String aliasUsuario;
    private int cedulaUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String nacimientoUsuario;
    private String sexoUsuario;
    private String rhUsuario;
    private String direccionUsuario;
    private int telefonoUsuario;
    private String emailUsuario;
    private String creacionUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, int rolUsuario, String claveUsuario, String aliasUsuario, int cedulaUsuario, String nombreUsuario, String apellidoUsuario, String nacimientoUsuario, String sexoUsuario, String rhUsuario, String direccionUsuario, int telefonoUsuario, String emailUsuario, String creacionUsuario) {
        this.idUsuario = idUsuario;
        this.rolUsuario = rolUsuario;
        this.claveUsuario = claveUsuario;
        this.aliasUsuario = aliasUsuario;
        this.cedulaUsuario = cedulaUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.nacimientoUsuario = nacimientoUsuario;
        this.sexoUsuario = sexoUsuario;
        this.rhUsuario = rhUsuario;
        this.direccionUsuario = direccionUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.emailUsuario = emailUsuario;
        this.creacionUsuario = creacionUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(int rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public String getAliasUsuario() {
        return aliasUsuario;
    }

    public void setAliasUsuario(String aliasUsuario) {
        this.aliasUsuario = aliasUsuario;
    }

    public int getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(int cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getNacimientoUsuario() {
        return nacimientoUsuario;
    }

    public void setNacimientoUsuario(String nacimientoUsuario) {
        this.nacimientoUsuario = nacimientoUsuario;
    }

    public String getSexoUsuario() {
        return sexoUsuario;
    }

    public void setSexoUsuario(String sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

    public String getRhUsuario() {
        return rhUsuario;
    }

    public void setRhUsuario(String rhUsuario) {
        this.rhUsuario = rhUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public int getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(int telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getCreacionUsuario() {
        return creacionUsuario;
    }

    public void setCreacionUsuario(String creacionUsuario) {
        this.creacionUsuario = creacionUsuario;
    }

    @Override
    public String toString() {
        return "[ id: " + idUsuario + " ]  |  [ rol: " + rolUsuario + " ]  |  [ clave: " + claveUsuario + " ]  |  [ alias: " + aliasUsuario + " ]  |  [ cedula: " + cedulaUsuario + " ]  |  [ nombres: " + nombreUsuario + " ]  |  [ apellidos: " + apellidoUsuario + " ]  |  [ fecha de nacimiento: " + nacimientoUsuario + " ]  |  [ sexo: " + sexoUsuario + " ]  |  [ rh: " + rhUsuario + " ]  |  [ direccion: " + direccionUsuario + " ]  |  [ telefono: " + telefonoUsuario + " ]  |  [ email: " + emailUsuario + " ] | [ fecha de creacion: " + creacionUsuario +" ]";
        //return "Usuario{" + "idUsuario=" + idUsuario + ", rolUsuario=" + rolUsuario + ", claveUsuario=" + claveUsuario + ", aliasUsuario=" + aliasUsuario + ", cedulaUsuario=" + cedulaUsuario + ", nombreUsuario=" + nombreUsuario + ", apellidoUsuario=" + apellidoUsuario + ", nacimientoUsuario=" + nacimientoUsuario + ", sexoUsuario=" + sexoUsuario + ", rhUsuario=" + rhUsuario + ", direccionUsuario=" + direccionUsuario + ", telefonoUsuario=" + telefonoUsuario + ", emailUsuario=" + emailUsuario + ", creacionUsuario=" + creacionUsuario + '}';
    }
    
    
    
}
