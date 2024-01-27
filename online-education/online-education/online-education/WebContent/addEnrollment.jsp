<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Enrollment</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Add Enrollment</h2>
        <form action="${pageContext.request.contextPath}/enrollments/add" method="post">
            <div class="form-group">
                <label for="studentId">Student ID</label>
                <input type="number" class="form-control" id="studentId" name="studentId" required>
            </div>
            <div class="form-group">
                <label for="courseId">Course ID</label>
                <input type="number" class="form-control" id="courseId" name="courseId" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>

