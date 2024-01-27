<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <!-- ... other head elements ... -->
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
    <div class="container mt-5">
        <h2>Update Course</h2>
        <form action="${pageContext.request.contextPath}/course/update" method="POST">
            <input type="hidden" name="id" value="${course.id}" />

            <div class="form-group">
                <label for="name">Course Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="${course.name}" required />
            </div>

            <div class="form-group">
                <label for="description">Description:</label>
                <textarea class="form-control" id="description" name="description" required>${course.description}</textarea>
            </div>

            <div class="form-group">
                <label for="teacherName">Teacher Name:</label>
                <input type="text" class="form-control" id="teacherName" name="teacherName" value="${course.teacherName}" required />
            </div>

            <button type="submit" class="btn btn-primary">Update Course</button>
        </form>
    </div>

    <!-- Optional: Include the jQuery library -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>