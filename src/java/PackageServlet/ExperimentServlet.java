/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageServlet;

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
public class ExperimentServlet extends HttpServlet {

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
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExperimentServlet</title>");            
            out.println("</head>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
            
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1 align='center'>Ma première Servlet</h1> <br><br>");
            out.println("<h3>Informations concernant l'adresse IP et le navigateur utilisé par le client :</h3>");
            out.println("<p>Adressee IP du client : "  +request.getRemoteAddr()+"</p>");
            out.println("<p>Navigateur du client : "  +request.getHeader("user-agent")+"</p>");
            out.println("<h3>Informations concernant la requête du client :</h3>");
            out.println("<p>Méthode : "  +request.getMethod()+"</p>");
            out.println("<p>Protocole : "  +request.getProtocol()+"</p>");
            out.println("<p>URI demandée : "  +request.getRequestURI()+"</p>");  
            out.println("<h3>Informations concernant l'entête de la requête</h3>");
            out.println("<p>Host : "  +request.getServerName()+":"+ request.getServerPort()+"</p>");
            out.println("<p>User-agent : "  +request.getHeader("user-agent")+"</p>");
            out.println("<p>Accept : "  +request.getHeader("Accept")+"</p>"); 
            out.println("<p>Accept-language : "  +request.getHeader("Accept-language")+"</p>");
            out.println("<p>Accept-encoding : "  +request.getHeader("Accept-encoding")+"</p>");
            out.println("<p>Accept-charset : "  +request.getHeader("Accept-charset")+":</p>"); 
            out.println("<p>Keep-alive : "  +request.getHeader("keep-Alive")+"</p>");
            out.println("<p>Connection : "  +request.getHeader("connection")+"</p>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
