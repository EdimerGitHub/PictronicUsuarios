<%-- 
    Document   : modificarUsuario
    Created on : 3/03/2024, 7:13:49 p. m.
    Author     : usuar
--%>

<%@page import="modelo.OperacionesBD"%>
<%@page import="modelo.Usuario"%>

<%
    Usuario usuario;
    usuario = OperacionesBD.getUsuario(request.getParameter("cedulaUsuario"));
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
        
        <h1>Modificar datos del usuario</h1>
        
        <form action="ServletModificar" method="POST">             
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
                        <td><input type="text" name="idUsuario" value="<%=usuario.getIdUsuario()%>" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td>Rol: </td>
                        <td><input type="text" name="rolUsuario" value="<%=usuario.getRolUsuario()%>" /></td>
                    </tr>
                    <tr>
                        <td>Clave: </td>
                        <td><input type="text" name="claveUsuario" value="<%=usuario.getClaveUsuario()%>" /></td>
                    </tr>
                    <tr>
                        <td>Alias: </td>
                        <td><input type="text" name="aliasUsuario" value="<%=usuario.getAliasUsuario()%>" /></td>
                    </tr>
                    <tr>
                        <td>Cedula: </td>
                        <td><input type="text" name="cedulaUsuario" value="<%=usuario.getCedulaUsuario() %>" /></td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="nombreUsuario" value="<%=usuario.getNombreUsuario() %>" /></td>
                    </tr>
                    <tr>
                        <td>Apellido: </td>
                        <td><input type="text" name="apellidoUsuario" value="<%=usuario.getApellidoUsuario() %>" /></td>
                    </tr>
                    <tr>
                        <td>Fecha nacimiento: </td>
                        <td><input type="text" name="nacimientoUsuario" value="<%=usuario.getNacimientoUsuario() %>" /></td>
                    </tr>
                    <tr>
                        <td>Sexo: </td>
                        <td><input type="text" name="sexoUsuario" value="<%=usuario.getSexoUsuario() %>" /></td>
                    </tr>
                    <tr>
                        <td>Tipo sangre: </td>
                        <td><input type="text" name="rhUsuario" value="<%=usuario.getRhUsuario() %>" /></td>
                    </tr>
                    <tr>
                        <td>Direccion: </td>
                        <td><input type="text" name="direccionUsuario" value="<%=usuario.getDireccionUsuario() %>" /></td>
                    </tr>
                    <tr>
                        <td>Telefono: </td>
                        <td><input type="text" name="telefonoUsuario" value="<%=usuario.getTelefonoUsuario() %>" /></td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td><input type="text" name="emailUsuario" value="<%=usuario.getEmailUsuario() %>" /></td>
                    </tr>
                    <tr>
                        <td>Fecha creacion: </td>
                        <%-- <%=LocalDate.now().toString()%> --%>
                        <td><input type="text" name="creacionUsuario" value="<%=usuario.getCreacionUsuario() %>" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Modificar usuario" class="btn btn-success"/></td>
                    </tr>
                </tbody>
            </table>
        </form> 
    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
