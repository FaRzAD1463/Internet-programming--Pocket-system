<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Courses</title>
  <!-- Include Bootstrap 5 CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
      <a class="navbar-brand" href="#">Course Materials</a>
    </div>
  </nav>
<a href="${pageContext.request.contextPath}/course/courses">view</a>
  <div class="container mt-4">
    <h2>Courses</h2>
    <ul class="list-group">
      <c:forEach items="${courses}" var="course">
    <li class="list-group-item">
        <a href="${pageContext.request.contextPath}/materials/list/${course.id}">
            ${course.name}
        </a>
    </li>
</c:forEach>
    </ul>
  </div>

  <!-- Include Bootstrap 5 JS bundle -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
