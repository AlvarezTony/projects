package java112.project3;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * HttpRequestServlet uses a java bean in order to pull data from the request
 * and forward it on to the httpRequestData.jsp page for display.
 *
 *@author    Tony Alvarez
 */
@WebServlet(
name = "requestServlet",
urlPatterns = {"/request-servlet"}
) public class HttpRequestServlet extends HttpServlet {

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

        HttpRequestData myBean = new HttpRequestData();

        myBean.setRemoteComputer(request.getRemoteHost());
        myBean.setRemoteComputerAddress(request.getRemoteAddr());
        myBean.setHttpMethod(request.getMethod());
        myBean.setRequestUri(request.getRequestURI());
        myBean.setRequestUrl(request.getRequestURL());
        myBean.setHttpProtocol(request.getProtocol());
        myBean.setServerName(request.getServerName());
        myBean.setServerPortNumber(request.getServerPort());
        myBean.setCurrentLocaleOfServer(request.getLocale().toString());
        myBean.setQueryString(request.getQueryString());
        myBean.setQueryParameter(request.getParameter("queryParameter"));
        myBean.setUserAgent(request.getHeader("User-Agent"));

        request.setAttribute("myCoolBean", myBean);

        String url = "/httpRequestData.jsp";

        RequestDispatcher dispatcher
        = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
