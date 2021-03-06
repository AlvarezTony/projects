package java112.project.project4;

import java112.employee.*;
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
    name = "applicationStartup", 
    urlPatterns = { "/project4-startup" },
    loadOnStartup = 1
)
 
public class ApplicationStartup extends HttpServlet {
 
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
   
    private Properties properties;

    /**
     ** This method will initialize the properties file and will
     ** apply it to the properties instance variable
     * @exception ServletException  throws a servlet exception
     **/
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        
        
        // Initialization code
        loadProperties("/project4.properties");
        EmployeeDirectory employeeDirectory = new EmployeeDirectory(properties);
        servletContext.setAttribute("project4Properties", properties);
        servletContext.setAttribute("employeeDirectory", employeeDirectory);
        
        
        //EmployeeDirectory employeeDirectory = new EmployeeDirectory();
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
}
   




