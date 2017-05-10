<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">

<c:import url="jsp/menu.jsp"/>


<div id="text">

  <table style="border: 1px solid black;">
    <tr>
      <td>Author</td>
      <td>${myProperties["author"]}</td>
    </tr>
    <tr>
      <td>Author Email Address</td>
      <td>${myProperties["author.email.address"]}</td>
    </tr>
    <tr>
      <td>Course Title</td>
      <td>${myProperties["course.title"]}</td>
    </tr>
    <tr>
      <td>Course Meeting Days</td>
      <td>${myProperties["course.meeting.days"]}</td>
    </tr>
    <tr>
      <td>Course Meeting Times</td>
      <td>${myProperties["course.meeting.times"]}</td>
    </tr>
    <tr>
      <td>Instructor Name</td>
      <td>${myProperties["instructor.name"]}</td>
    </tr>
    <tr>
      <td>Project Description</td>
      <td>${myProperties["project.description"]}</td>
    </tr>
    </table>
 
 
 
 
</div>

</div>