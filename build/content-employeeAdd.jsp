<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">

<c:import url="jsp/menu.jsp"/>


<div id="text">
 <h3>${message}</h3>
 <div>
 <form action ="/java112/employeeAddAction" method = "POST">
 First Name: <input type="text" name="firstName" /> </br>
 Last Name:  <input type="text" name="lastName" /> </br>
 SSN:        <input type="text" name="socialSecurityNumber" /> </br>
 Department: <input type="text" name="department" /> </br>
 Room Number:<input type="text" name="roomNumber" /> </br>
 Phone Number: <input type="text" name="phoneNumber" /> </br> </br>
 <input type = "submit" name="" value="Submit" />
 </form>
 </div>
 
</div>

</div>