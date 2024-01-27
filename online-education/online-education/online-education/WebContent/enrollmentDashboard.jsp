<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enrollment Dashboard</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Enrollments</h2>
        <a href="${pageContext.request.contextPath}/enrollments/dashboard" class="btn btn-success">display</a>
        <a href="${pageContext.request.contextPath}/addEnrollment.jsp" class="btn btn-success">Add</a>
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success">${successMessage}</div>
        </c:if>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">${errorMessage}</div>
        </c:if>
        <table class="table table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Student Name</th>
                    <th>Course Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${enrollments}" var="enrollment">
                    <tr>
                        <td>${enrollment.id}</td>
                        <td>${enrollment.studentName}</td>
                        <td>${enrollment.courseName}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/enrollments/delete/${enrollment.id}" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
