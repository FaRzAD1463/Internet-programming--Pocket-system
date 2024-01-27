<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            padding-top: 20px;
            font-family: 'Roboto', sans-serif;
        }
        .container {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 6px 10px rgba(0,0,0,.1);
        }
        .header {
            background-color: #007bff;
            color: white;
        }
        .header h1 {
            padding: 10px 0;
        }
        .course-card {
            margin-bottom: 20px;
        }
        .card .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .card .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="header text-center">
        <h1>Welcome, ${studentName}</h1>
    </div>
    <h2>Enrolled Courses:</h2>

    <div class="row">
        <c:forEach items="${courses}" var="course">
            <div class="col-md-4">
                <div class="card course-card">
                    <div class="card-body">
                        <h5 class="card-title">${course.name}</h5>
                        <p class="card-text">${course.description}</p>
                        
                        <a href="${pageContext.request.contextPath}/materials/list?courseId=${course.id}" class="btn btn-primary btn-sm"><i class="fas fa-eye"></i> View Materials</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>


