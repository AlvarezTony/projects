package java112.project4;

import java.io.*;
import java.util.*;
import java.lang.*;
import java112.employee.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *
 *
 *@author    Tony Alvarez
 */
@WebServlet(
name = "employeeSearch",
urlPatterns = {"/employeeSearchResults"}
) public class EmployeeSearchResultsServlet extends HttpServlet {

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

        ServletContext servletContext = getServletContext();
        EmployeeDirectory employeeDirectory = (EmployeeDirectory)servletContext.getAttribute("employeeDirectory");

        String searchType = request.getParameter("searchOptions");
        String searchTerm = request.getParameter("term");
        
/* Testing ONLY Below 
        PrintWriter out = response.getWriter();
        out.println("<html><body><h3> SearchType: " 
                + searchType + "</h3>" 
                + "<h3>searchTerm: " + searchTerm 
                + "</h3></body></html>");
      
*/

        employeeDirectory.searchEmployeeRecord(searchType, searchTerm);

        String url = "/employeeSearchResults.jsp";

        RequestDispatcher dispatcher
        = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
