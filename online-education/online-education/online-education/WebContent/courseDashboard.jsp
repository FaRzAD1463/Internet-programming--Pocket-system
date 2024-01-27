<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Course Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Course Management</a>
    </nav>

    <div class="container mt-3">
        <h2>Courses</h2>
        <a href="${pageContext.request.contextPath}/course/courseDashboard" class="btn btn-primary btn-sm">display courses</a>
        <a href="${pageContext.request.contextPath}/courseForm.jsp" class="btn btn-success mb-2">Add New course</a>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Teacher name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${courses}" var="course">
                    <tr>
                        <td>${course.id}</td>
                        <td>${course.name}</td>
                        <td>${course.description}</td>
                        <td>${course.teacherName}</td>
<td>
                            <a href="${pageContext.request.contextPath}/course/edit/${course.id}" class="btn btn-primary btn-sm">Edit</a>
                            <a href="${pageContext.request.contextPath}/course/delete/${course.id}" class="btn btn-danger btn-sm">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
