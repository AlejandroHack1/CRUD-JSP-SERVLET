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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.operationPets;

/**
 *
 * @author xespi
 */
@WebServlet(urlPatterns = {"/RegisterPetServlet"})
public class RegisterPetServlet extends HttpServlet {

    private operationPets mascotas;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init() {
        mascotas = new operationPets();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        HttpSession session = request.getSession();
        List<claseMascota> listaMascotas = new ArrayList<>();
        List<claseMascota> listaMascota = new ArrayList<>();

        String returnPage = request.getParameter("return");
        String buttonViewListPets = request.getParameter("showList");
        String editPets = request.getParameter("idMascotaEdit");
        String deletePets = request.getParameter("idMascota");

        if (returnPage != null) {
            request.setAttribute("user", session.getAttribute("userData"));
            RequestDispatcher req = request.getRequestDispatcher("home.jsp");
            req.include(request, response);
        }

        if (buttonViewListPets != null) {

            int idUser = (int) session.getAttribute("userId");

            try {
                listaMascotas = mascotas.listPets(idUser);

                if (!listaMascotas.isEmpty()) {
                    request.setAttribute("user", session.getAttribute("userData"));
                    request.setAttribute("listPets", listaMascotas);
                    request.getRequestDispatcher("home.jsp").forward(request, response);

                }
                else{
                    request.setAttribute("user", session.getAttribute("userData"));
                    request.setAttribute("listPets", listaMascotas);
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                }

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(RegisterPetServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (deletePets != null) {
            try {
                int result = mascotas.deletePets(Integer.valueOf(deletePets));
                if (result != 0) {

                    request.setAttribute("user", session.getAttribute("userData"));
                    request.setAttribute("sucessDelete", "Registro Eliminado Exitosamente");
                    request.getRequestDispatcher("home.jsp").forward(request, response);

                }
            } catch (ClassNotFoundException ex) {
                System.out.println("Error: " + ex);
            }
        }

        if (editPets != null) {
            try {
                session.setAttribute("petsId", Integer.valueOf(editPets));
                listaMascota = mascotas.listPetsEdit(Integer.valueOf(editPets));
                if (!listaMascota.isEmpty()) {

                    request.setAttribute("listEditPet", listaMascota);
                    RequestDispatcher req = request.getRequestDispatcher("editPets.jsp");
                    req.forward(request, response);

                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterPetServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegisterPetServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

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

        try {
            int result = mascotas.registerPets(mascota);

            if (result != 0) {
                request.setAttribute("user", session.getAttribute("userData"));
                request.setAttribute("success", "Registro Exitoso!");
                RequestDispatcher req = request.getRequestDispatcher("home.jsp");
                req.include(request, response);
            } else {

                request.setAttribute("error", "No se registró la Mascota");
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
