<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html>
<head>
    <title>Teacher's Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f4f4f4;
            padding-top: 20px;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 6px 15px rgba(0,0,0,.1);
        }
        .card {
            transition: transform .3s ease-in-out, box-shadow .3s ease-in-out;
        }
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 12px 20px rgba(0,0,0,.2);
        }
        .btn-primary {
            margin-top: 10px;
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
    </style>
</head>

<body>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Welcome, ${sessionScope.teacherName}</h1>
        <div class="row">
            <c:forEach items="${courses}" var="course">
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${course.name}</h5>
                            <p class="card-text">${course.description}</p>
                            <a href="${pageContext.request.contextPath}/materials/list?courseId=${course.id}" class="btn btn-primary btn-sm">Manage Materials</a>
                            <a href="${pageContext.request.contextPath}/enrollments/dashboard" class="btn btn-primary btn-sm">View Enrolled Students</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <script src="https://code
.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>