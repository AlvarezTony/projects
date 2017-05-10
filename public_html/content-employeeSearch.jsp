<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">

<c:import url="jsp/menu.jsp"/>


<div id="text">
 
 <ul>
  <li> You hit the Content-employee-search jsp page</li>
  <li>${project4Properties["author"]}</li>
 </ul>
 
 <div>
 <form action ="/java112/employeeSearchResults" method = "GET">
 Search Term: <input type="text" name="term" /> </br></br>
 ID<input type="radio" name ="searchOptions" value = "emp_id" Checked>
 </br>
 Last Name<input type="radio" name ="searchOptions" value = "last_name" >
 </br>
 First Name<input type="radio" name ="searchOptions" value = "first_name" >
  </br>
  </br>
 <input type = "submit" name="Submit" value="Submit" />
 </form>
 </div>
 <!-- Retaining info below as notes for best testing directly in JSP page BELOW 

------------------------------>
 
</div>

</div>