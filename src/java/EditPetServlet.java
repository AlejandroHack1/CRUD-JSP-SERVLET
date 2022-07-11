/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Modelo.claseMascota;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import services.operationPets;

/**
 *
 * @author xespi
 */
@WebServlet(urlPatterns = {"/EditPetServlet"})
public class EditPetServlet extends HttpServlet {

    private operationPets mascotas;

    @Override
    public void init() {
        mascotas = new operationPets();
    }

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
        response.setContentType("text/html;charset=UTF-8");

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

        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String raza = request.getParameter("raza");
        String especie = request.getParameter("specie");
        String color = request.getParameter("color");
        String gender = request.getParameter("gender");
        String weight = request.getParameter("weight");
        String age = request.getParameter("age");
        String diagnostic = request.getParameter("diagnostic");

        int peso = Integer.valueOf(weight);
        int edad = Integer.valueOf(age);
        int idUser = (int) session.getAttribute("userId");
        int idPets = (int) session.getAttribute("petsId");

        //String user = (String) session.getAttribute("userData");
        claseMascota mascota = new claseMascota();
        mascota.setNombre(name);
        mascota.setRaza(raza);
        mascota.setEspecie(especie);
        mascota.setColor(color);
        mascota.setGenero(gender);
        mascota.setPeso(peso);
        mascota.setEdad(edad);
        mascota.setDiagnostico(diagnostic);
        mascota.setIdUsuario(idUser);
        mascota.setIdMascota(idPets);
        try {
            int result = mascotas.updatePets(mascota);
            out.println(result);
            if (result != 0) {
                request.setAttribute("successUpdate", "Actualización Exitosa!");
                request.setAttribute("user", session.getAttribute("userData"));
                RequestDispatcher req = request.getRequestDispatcher("home.jsp");
                req.include(request, response);
            } else {

                request.setAttribute("errorUpdate", "No se Actualizó la Mascota");
                request.setAttribute("user", session.getAttribute("userData"));
                RequestDispatcher req = request.getRequestDispatcher("home.jsp");
                req.forward(request, response);
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Error: " + e);
        }
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
