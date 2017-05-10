package java112.project2;


import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * This servlet (First112Servlet) will create an html page with an image and a
 * link back to the home page.
 * @author Tony Alvarez
 **/
@WebServlet(
name = "First112Servlet",
urlPatterns = {"/First112Servlet", "/First"}
) public class First112Servlet extends HttpServlet {

    /**
     * Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");

        // set the response type before sending data
        PrintWriter out = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>First112Servlet Page</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Tony Alvarez</h1>");
        out.print("<p>Advanced Java - Monday Class at 5:30pm</p>");
        out.print("<img src=\"images/javaImage.jpeg\" alt=\"\">");
        out.print("<h3><a href=\"/java112\">Back to home page</a></h3>");

        // out.print(properties.getproperties("author");
        // System.out.println("Is this logging?");
        // log("Is this logging?");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
