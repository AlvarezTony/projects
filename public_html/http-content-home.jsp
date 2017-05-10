<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">

<c:import url="jsp/menu.jsp"/>


<div id="text">
 
 <ul>
  <li>remoteComputer: ${myCoolBean.remoteComputer}</li>
  <li>remoteComputerAddress: ${myCoolBean.remoteComputerAddress}</li>
  <li>httpMethod: ${myCoolBean.httpMethod}</li>
  <li>requestUri: ${myCoolBean.requestUri}</li>
  <li>requestUrl: ${myCoolBean.requestUrl}</li>
  <li>httpProtocol: ${myCoolBean.httpProtocol}</li>
  <li>serverName: ${myCoolBean.serverName}</li>
  <li>serverPortNumber: ${myCoolBean.serverPortNumber}</li>
  <li>currentLocaleOfServer: ${myCoolBean.currentLocaleOfServer}</li>
  <li>queryString: ${myCoolBean.queryString}</li>
  <li>queryParameter: ${myCoolBean.queryParameter}</li>
  <li>User-Agent: ${myCoolBean.userAgent}</li>
  
 </ul>
 <!-- Retaining info below as notes for best testing directly in JSP page BELOW 
 <p>
 request.getMethod(): <%= request.getMethod() %>
 request.getParameter("queryParameter"): <%= request.getParameter("queryParameter") %><br />
 request.getQueryString(): <%= request.getQueryString() %><br/>
 request.getHeader("User-Agent"): <%= request.getHeader("User-Agent") %><br/>
</p>
------------------------------>
 
</div>

</div>