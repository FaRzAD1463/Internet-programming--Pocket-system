<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of Materials</title>
    <!-- Include Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="#">Course Materials</a>
        </div>
    </nav>

    <div class="container mt-4">
        <h2>Select Course to View Materials:</h2>
       

        <a href="${pageContext.request.contextPath}/materials/show" class="btn btn-success mb-2">Add New Material</a>

        <c:if test="${not empty materials}">
            <h3>Materials for Course ID: ${courseId}</h3>
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Content</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="material" items="${materials}">
                            <tr>
                                <td>${material.id}</td>
                                <td>${material.title}</td>																																																																			
                                <td>${material.content}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/materials/edit/${material.id}" class="btn btn-primary btn-sm">Edit</a>
                                    <a href="${pageContext.request.contextPath}/materials/delete/${material.id}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this material?')">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>

        <c:if test="${empty materials && not empty courseId}">
            <div class="alert alert-info">No materials found for this course.</div>
        </c:if>

        <c:if test="${not empty successMessage}">
            <div class="alert alert-success">${successMessage}</div>
        </c:if>

        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">${errorMessage}</div>
</c:if>
</div>

<!-- Include Bootstrap 5 JS bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


