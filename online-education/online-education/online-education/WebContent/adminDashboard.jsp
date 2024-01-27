<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
</head>
<body>
    <div class="container mt-4">
    
    <h2>Admin Dashboard</h2>
    <br>
    <br>
    <div class="row">
        <!-- User Management Card -->
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><i class="fas fa-users"></i> User Management</h5>
                    <p class="card-text">Manage your users here.</p>
                    <a href="${pageContext.request.contextPath}/users/dashboard" class="btn btn-primary">Go to Users</a>
                </div>
            </div>
        </div>

        <!-- Enrollment Management Card -->
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><i class="fas fa-book-reader"></i> Enrollment Management</h5>
                    <p class="card-text">Overview of course enrollments.</p>
                    <a href="${pageContext.request.contextPath}/enrollments/dashboard" class="btn btn-primary">Manage Enrollments</a>
                </div>
            </div>
        </div>

        <!-- Course Management Card -->
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><i class="fas fa-chalkboard-teacher"></i> Course Management</h5>
                    <p class="card-text">Organize and update your courses.</p>
                    <a href="${pageContext.request.contextPath}/course/courseDashboard" class="btn btn-primary">Go to Courses</a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
</html>