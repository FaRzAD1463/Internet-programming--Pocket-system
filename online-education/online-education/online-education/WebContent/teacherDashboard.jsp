<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>teacher </title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-3">
        <h2>teacher Dashboard</h2>
        <ul>
           
            <li><a href="${pageContext.request.contextPath}/enrollments/dashboard">Enrollment Management</a></li>
            <li><a href="${pageContext.request.contextPath}/teacherCourse.jsp">Course Management</a></li>
        </ul>
    </div>
</body>
</html>