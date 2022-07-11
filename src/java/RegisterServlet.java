/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Modelo.claseUsuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import static java.lang.System.out;
import services.insertUser;

/**
 *
 * @author xespi
 */
@WebServlet(urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    private insertUser user;

    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
        user = new insertUser();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

        claseUsuario usuario = new claseUsuario();
        usuario.setFirstname(first_name);
        usuario.setLastname(last_name);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setDirection(address);
        usuario.setPhone(contact);

        try {
            user.registerUser(usuario);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Error: " + e);
        }

        if (first_name.isEmpty() || last_name.isEmpty() || username.isEmpty()
                || password.isEmpty() || address.isEmpty() || contact.isEmpty()) {
            RequestDispatcher req = request.getRequestDispatcher("register.jsp");
            req.include(request, response);
        } else {

            request.setAttribute("success", "Registro Exitoso!");
            RequestDispatcher req = request.getRequestDispatcher("index.jsp");
            req.forward(request, response);
        }
    }

}
