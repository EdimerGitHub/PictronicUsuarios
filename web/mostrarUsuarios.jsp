<%-- 
    Document   : mostrarUsuarios
    Created on : 1/03/2024, 9:52:40 p. m.
    Author     : usuar
--%>

<%@page import="modelo.OperacionesBD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.time.*"%>
<%@page import="java.time.format.*"%>
<%@page import="modelo.Mensajes"%>
<%@page import="controlador.ServletAgregar"%>

<%
ArrayList <Usuario> data = new ArrayList<Usuario>();
data = OperacionesBD.listarUsuarios();
String mensaje = "";
if(request.getParameter("mensaje")==null){
}else{
    if(request.getParameter("mensaje").equals("2")){
        mensaje = Mensajes.getMsj(2);
    }
    if(request.getParameter("mensaje").equals("0")){
        mensaje = Mensajes.getMsj(0);
    }
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>CRUD USUARIOS PICTRONIC</title>
    </head>
    <body>
        
        <h1>lista de Usuarios</h1>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Datos del usuario</th>
                    <th>Eliminar</th>
                    <th>Modificar</th>
                </tr>
            </thead>
            <tbody>
            <% for(Usuario tmpUsuario:data){ %>
                <tr>
                    <td><%=tmpUsuario.toString()%></td>
                    <td><% if(! OperacionesBD.esJefeEspecialista(""+tmpUsuario.getCedulaUsuario())){%>
                        
                        <form action="ServletEliminar" method="POST">
                            <input type="hidden" name="cedulaUsuario" value="<%=tmpUsuario.getCedulaUsuario()%>"/>
                            <input type="submit" value="Eliminar" class="btn btn-danger"/>
                        </form>
                        <% } %>
                    </td>
                    <td><a href="modificarUsuario.jsp?cedulaUsuario=<%=tmpUsuario.getCedulaUsuario()%>">Modificar</a></td>
                </tr>
            <% } %>
            </tbody>    
        </table>
        
        <h2>Agregar un nuevo usuario al sistema</h2>     
        <h2><%=mensaje%></h2>    
            
        <form action="ServletAgregar" method="POST">             
            <table class="table table-success table-striped-columns">            
                <thead>
                    <tr>
                        <th>Datos del usuario</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Id: </td>
                        <td><input type="text" name="idUsuario" value="0" hidden="hidden"/></td>
                    </tr>
                    <tr>
                        <td>Rol: </td>
                        <td><input type="text" name="rolUsuario" value="" /></td>
                    </tr>
                    <tr>
                        <td>Clave: </td>
                        <td><input type="text" name="claveUsuario" value="" /></td>
                    </tr>
                    <tr>
                        <td>Alias: </td>
                        <td><input type="text" name="aliasUsuario" value="" /></td>
                    </tr>
                    <tr>
                        <td>Cedula: </td>
                        <td><input type="text" name="cedulaUsuario" value="" /></td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="nombreUsuario" value="" /></td>
                    </tr>
                    <tr>
                        <td>Apellido: </td>
                        <td><input type="text" name="apellidoUsuario" value="" /></td>
                    </tr>
                    <tr>
                        <td>Fecha nacimiento: </td>
                        <td><input type="text" name="nacimientoUsuario" value="" /></td>
                    </tr>
                    <tr>
                        <td>Sexo: </td>
                        <td><input type="text" name="sexoUsuario" value="" /></td>
                    </tr>
                    <tr>
                        <td>Tipo sangre: </td>
                        <td><input type="text" name="rhUsuario" value="" /></td>
                    </tr>
                    <tr>
                        <td>Direccion: </td>
                        <td><input type="text" name="direccionUsuario" value="" /></td>
                    </tr>
                    <tr>
                        <td>Telefono: </td>
                        <td><input type="text" name="telefonoUsuario" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td><input type="text" name="emailUsuario" value="" /></td>
                    </tr>
                    <tr>
                        <td>Fecha creacion: </td>
                        <%-- <%=LocalDate.now().toString()%> --%>
                        <td><input type="text" name="creacionUsuario" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Crear usuario" class="btn btn-success"/></td>
                    </tr>
                </tbody>
            </table>
        </form> 
                        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>        
    </body>
</html>
