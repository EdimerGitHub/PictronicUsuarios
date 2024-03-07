/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.OperacionesBD;
import modelo.Usuario;

/**
 *
 * @author usuar
 */
public class ServletModificar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher vista;
        boolean existe;
        existe = OperacionesBD.existeUsuario(request.getParameter("cedulaUsuario"));// Si la cedula del usuario existe nos devuelve TRUE sino FALSE
        if(existe){
            Usuario usuario; //creamos una instancia de Usuario
            usuario = new Usuario(Integer.parseInt(request.getParameter("idUsuario")),
                                       Integer.parseInt(request.getParameter("rolUsuario")),
                                       request.getParameter("claveUsuario"),
                                       request.getParameter("aliasUsuario"),
                                       Integer.parseInt(request.getParameter("cedulaUsuario")),
                                       request.getParameter("nombreUsuario"),
                                       request.getParameter("apellidoUsuario"),
                                       request.getParameter("nacimientoUsuario"),
                                       request.getParameter("sexoUsuario"),
                                       request.getParameter("rhUsuario"),
                                       request.getParameter("direccionUsuario"),
                                       Integer.parseInt(request.getParameter("telefonoUsuario")),
                                       request.getParameter("emailUsuario"),
                                       request.getParameter("creacionUsuario")
            );//traemos todos sus valores de la pagina
            OperacionesBD.modificaUsuario(usuario); // este metodo de la clase modifica el usuario con los nuevos valores
            vista = request.getRequestDispatcher("mostrarUsuarios.jsp?mensaje=0");// mostramos los usarios nuevamente

        }else{
            vista = request.getRequestDispatcher("mostrarUsuarios.jsp?mensaje=2");
        }
        vista.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
