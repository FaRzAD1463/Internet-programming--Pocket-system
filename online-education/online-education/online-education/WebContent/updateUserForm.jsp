<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-3">
        <h2>Update User</h2>
        <form action="${pageContext.request.contextPath}/users/updating" >
            <!-- Hidden field for user ID -->
            <input type="hidden" name="user_id" value="${user.id}" />

            <!-- Username field -->
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" name="username" value="${user.username}" required>
            </div>

            <!-- Email field -->
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="${user.email}" required>
            </div>

            <!-- Password field -->
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" value="${user.password}" required>
            </div>

            <!-- Role ID field -->
            <div class="form-group">
                <label for="role_id">Role ID:</label>
                <input type="number" class="form-control" id="role_id" name="role_id" value="${user.roleId}" required>
            </div>

            <input type="submit" class="btn btn-primary" value="Update User">
        </form>
    </div>

    <!-- Bootstrap and jQuery -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
