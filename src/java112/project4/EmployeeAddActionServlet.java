package java112.project4;
 
import java.io.*;
import java.util.*;
import java.lang.*;
import java112.employee.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
/**
 *  
 *
 *@author    Tony Alvarez
 */
@WebServlet(
    name = "employeeAddActionServlet", 
    urlPatterns = { "/employeeAddAction" }
)
 
public class EmployeeAddActionServlet extends HttpServlet {
    
 
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
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
          
          String firstName = request.getParameter("firstName");  
          String lastName = request.getParameter("lastName");
          String socialSecurityNumber = request.getParameter("socialSecurityNumber");             
          String department = request.getParameter("department");
          String roomNumber = request.getParameter("roomNumber");
          String phoneNumber = request.getParameter("phoneNumber");
          
          HttpSession session = request.getSession();
          String message = "The employee record was added";
          
          session.setAttribute("message", message);
          
          ServletContext servletContext = getServletContext(); 
          EmployeeDirectory employeeDirectory = (EmployeeDirectory) servletContext.getAttribute("employeeDirectory");
         
          employeeDirectory.addEmployeeRecord(firstName, lastName, 
                socialSecurityNumber, department, roomNumber, phoneNumber);
            
         //Create the url
        String url = "./employeeAdd";
 
        // Redirect to JSP page
        response.sendRedirect(url);
            
        }
 
}





