/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageServlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Axel Koffi
 */
public class EtudiantsServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            String line = "";
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EtudiantsServlet</title>");
            out.println("</head>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1><center>Liste des étudiants</center></h1>");
            out.println("<table class='table table-striped' border='1px'>");
            out.println("<tr>");
            out.println("<th>Nom</th>");
            out.println("<th>Prenom</th>");
            out.println("<th>Email</th>");
            out.println("</tr>");
            out.println("</div>");
            try {
                BufferedReader br = new BufferedReader(new FileReader("etudiants.csv"));
                while ((line = br.readLine()) != null) {
                    String[] donne = line.split(",");
                    out.println("<tr>");
                    out.println("<td>" + donne[0] + "</td>");
                    out.println("<td>" + donne[1] + "</td>");
                    out.println("<td>" + donne[2] + "</td>");
                    out.println("</tr>");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            out.println("<table>");
            out.println("</body>");
            out.println("</html>");
        }
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
       
        String Comma_delimiter = ",";
        String new_line_separator = "\n";
        String file_header = "nom,prenom,email";
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        FileWriter filewritter = new FileWriter("etudiants.csv", true);
        

        filewritter.append(nom);
        filewritter.append(Comma_delimiter);
        filewritter.append(prenom);
        filewritter.append(Comma_delimiter);
        filewritter.append(email);
        filewritter.append(Comma_delimiter);
        filewritter.append(new_line_separator);
        filewritter.flush();
        filewritter.close();
        PrintWriter out = response.getWriter();
        out.println("l'utilisateur " + nom + " a bien été enregistré");
        doGet(request, response);
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
