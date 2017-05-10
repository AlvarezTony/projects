package java112.project4;
 
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
/**
 *  
 *
 *@author    Tony Alvarez
 */
@WebServlet(
    name = "JSTLLabServlet", 
    urlPatterns = { "/JSTLLabServlet" }
)
 
public class JSTLLab1Servlet extends HttpServlet {
 
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
 
         List<String> name = new ArrayList<>();
         
         name.add("Tony");
         name.add("Ivan");
         name.add("Eric");
         name.add("Mindy");
         
         request.setAttribute("myNameRequest", name);
         
         //Create the url
        String url = "/jsp/jstl-lab2.jsp";
 
        //Forward to jsp page
        RequestDispatcher  dispatcher = 
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
 
}





