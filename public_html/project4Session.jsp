<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="" scope="request" />

<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="pageTitle" value="home" scope="session" />
<c:import url="jsp/head-tag.jsp"/>

<body>
<div id="container">
<!-- header -->

<c:import url="jsp/header.jsp"/>

<!--end header -->
<!-- main -->


<c:import url="content-session-lab.jsp"/>

<!-- end main -->
<!-- footer -->
<c:import url="jsp/footer.jsp"/>
<!-- end footer -->
</div>
</body>
</html>
