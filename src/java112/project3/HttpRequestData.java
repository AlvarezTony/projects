package java112.project3;


import java.lang.*;


/**
 *
 * class httpRequestData is the Java Bean which manages all of the getters
 * and setters for the httpRequestServlet.
 * @author Tony Alvarez
 */
public class HttpRequestData {

    private String remoteComputer;    //getRemoteHost()
    private String remoteComputerAddress;    //getRemoteAddr()
    private String httpMethod;    //getMethod()
    private String requestUri;    //getRequestURI()
    private String requestUrl;    //getRequestURL()
    private String httpProtocol;    //getProtocol()
    private String serverName;    //getServerName()
    private Integer serverPortNumber;    //getServerPort()
    private String currentLocaleOfServer;    //getLocale()
    private String queryString;    // getQueryString()
    private String queryParameter;    //getParamter()
    private String userAgent;    // getHeader("User-Agent")


    /**
     * Returns the value of remoteComputer.
     * @return remoteComputer The value of the remoteComputer variable.
     */
    public String getRemoteComputer() {
        return remoteComputer;
    }


    /**
     * Sets the value of remoteComputer.
     * @param remoteComputer The value to assign remoteComputer.
     */
    public void setRemoteComputer(String remoteComputer) {
        this.remoteComputer = remoteComputer;
    }


    /**
     * Returns the value of remoteComputerAddress.
     * @return remoteComputerAddress The value of the remoteComputerAddress variable.
     */
    public String getRemoteComputerAddress() {
        return remoteComputerAddress;
    }


    /**
     * Sets the value of remoteComputerAddress.
     * @param remoteComputerAddress The value to assign remoteComputerAddress.
     */
    public void setRemoteComputerAddress(String remoteComputerAddress) {
        this.remoteComputerAddress = remoteComputerAddress;
    }


    /**
     * Returns the value of httpMethod.
     * @return httpMethod The value of the httpMethod variable.
     */
    public String getHttpMethod() {
        return httpMethod;
    }


    /**
     * Sets the value of httpMethod.
     * @param httpMethod The value to assign httpMethod.
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }


    /**
     * Returns the value of requestUri.
     * @return requestUri The value of the requestUri variable.
     */
    public String getRequestUri() {
        return requestUri;
    }


    /**
     * Sets the value of requestUri.
     * @param requestUri The value to assign requestUri.
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }


    /**
     * Returns the value of requestUrl.
     * @return requestUrl The value of the requestUrl variable.
     */
    public String getRequestUrl() {
        return requestUrl;
    }


    /**
     * Sets the value of requestUrl.
     * @param requestUrl The value to assign requestUrl.
     */
    public void setRequestUrl(StringBuffer requestUrl) {
        this.requestUrl = requestUrl.toString();
    }


    /**
     * Returns the value of httpProtocol.
     * @return httpProtocol The value of the httpProtocol variable.
     */
    public String getHttpProtocol() {
        return httpProtocol;
    }


    /**
     * Sets the value of httpProtocol.
     * @param httpProtocol The value to assign httpProtocol.
     */
    public void setHttpProtocol(String httpProtocol) {
        this.httpProtocol = httpProtocol;
    }


    /**
     * Returns the value of serverName.
     * @return serverName The value of the serverName variable.
     */
    public String getServerName() {
        return serverName;
    }


    /**
     * Sets the value of serverName.
     * @param serverName The value to assign serverName.
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }


    /**
     * Returns the value of serverPortNumber.
     * @return serverPortNumber The value of the serverPortNumber variable.
     */
    public Integer getServerPortNumber() {
        return serverPortNumber;
    }


    /**
     * Sets the value of serverPortNumber.
     * @param serverPortNumber The value to assign serverPortNumber.
     */
    public void setServerPortNumber(Integer serverPortNumber) {
        this.serverPortNumber = serverPortNumber;
    }


    /**
     * Returns the value of currentLocaleOfServer.
     * @return currentLocaleOfServer The value of the currentLocaleOfServer variable.
     */
    public String getCurrentLocaleOfServer() {
        return currentLocaleOfServer;
    }


    /**
     * Sets the value of currentLocaleOfServer.
     * @param currentLocaleOfServer The value to assign currentLocaleOfServer.
     */
    public void setCurrentLocaleOfServer(String currentLocaleOfServer) {
        this.currentLocaleOfServer = currentLocaleOfServer;
    }


    /**
     * Returns the value of queryString.
     * @return queryString The value of the queryString variable.
     */
    public String getQueryString() {
        return queryString;
    }


    /**
     * Sets the value of queryString.
     * @param queryString The value to assign queryString.
     */
    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }


    /**
     * Returns the value of queryParameter.
     * @return queryParamter The value of the queryParameter variable.
     */
    public String getQueryParameter() {
        return queryParameter;
    }


    /**
     * Sets the value of queryParameter.
     * @param queryParameter The value to assign queryParameter.
     */
    public void setQueryParameter(String queryParameter) {
        this.queryParameter = queryParameter;
    }


    /**
     * Returns the value of userAgent.
     * @return userAgent The value of the userAgent variable.
     */
    public String getUserAgent() {
        return userAgent;
    }


    /**
     * Sets the value of userAgent.
     * @param userAgent The value to assign userAgent.
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}

