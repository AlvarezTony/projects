package java112.project3;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * PropertiesServlet will load a properties file, initilize it and forward to
 * the propertiesData.jsp page.
 *
 *@author    Tony Alvarez
 */
@WebServlet(
    name = "project3PropertiesServlet",
    urlPatterns = {"/project3-properties"}
) 
public class PropertiesServlet extends HttpServlet {

    private Properties properties;


    /**
     ** This method will initialize the properties file and will
     ** apply it to the properties instance variable
     * @exception ServletException  throws a servlet exception
     **/
    public void init() throws ServletException {

        // Initialization code
        loadProperties("/project3.properties");
    }


    /**
     * Loads the properties values to the instance variable.  All exception
     * handling for the properties file is managed here.
     * @param propertiesFilePath the file path of the properties file to be loaded.
     **/
    public void loadProperties(String propertiesFilePath) {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


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

        request.setAttribute("myProperties", properties);

        String url = "/propertiesData.jsp";

        RequestDispatcher dispatcher
        = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
