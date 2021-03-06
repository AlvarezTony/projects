package java112.project4;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *
 *
 *@author    Tony Alvarez
 */
@WebServlet(
name = "Project4SessionLab",
urlPatterns = {"/SessionLab"}
) public class Project4SessionLab extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        Integer sessionCounter = 0;
        
        HttpSession session = request.getSession();
        
        sessionCounter = 
            (Integer) session.getAttribute("project4SessionCounter");
            
            if (sessionCounter == null || sessionCounter.equals("")){
                sessionCounter = 1;
                
                session.setAttribute("project4SessionCounter", sessionCounter);
                
            } else {
                sessionCounter++;
                
                session.setAttribute("project4SessionCounter", sessionCounter);
            }

        String url = "/project4Session.jsp";

        RequestDispatcher dispatcher
        = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
