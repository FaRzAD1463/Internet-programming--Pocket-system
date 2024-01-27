<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Course</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
  <div class="container mt-3">
    <h2>Add Course</h2>
    <form action="${pageContext.request.contextPath}/course/add" >  <div class="form-group">
        <label for="course_name">Course Name:</label>
        <input type="text" class="form-control" id="course_name" name="name" required>
      </div>

      <div class="form-group">
        <label for="description">Description:</label>
        <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
      </div>

      <div class="form-group">
        <label for="teacher_id">Teacher ID:</label>
        <input type="number" class="form-control" id="teacher_id" name="teacherId" required>
      </div>

      <input type="submit" class="btn btn-primary" value="Add Course">
    </form>
  </div>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
