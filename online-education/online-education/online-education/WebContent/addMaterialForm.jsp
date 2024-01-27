<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Material</title>
    <!-- Include Bootstrap 5 CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-3">
        <h2>Add New Material</h2>
        <form action="${pageContext.request.contextPath}/materials/add" >
            <!-- Course ID field (if needed, you can make this a hidden field if the course ID is predefined or use a select dropdown for users to choose) -->
            <div class="form-group">
                <label for="course_id">Course ID:</label>
                <input type="number" class="form-control" id="course_id" name="courseId" required>
            </div>

            <!-- Title field -->
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" class="form-control" id="title" name="title" required>
            </div>

            <!-- Content field -->
            <div class="form-group">
                <label for="content">Content:</label>
                <textarea class="form-control" id="content" name="content" required></textarea>
            </div>

            <input type="submit" class="btn btn-primary" value="Add Material">
        </form>
    </div>

    <!-- Include Bootstrap 5 JS bundle (which includes Popper for dropdowns, tooltips, etc.) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
