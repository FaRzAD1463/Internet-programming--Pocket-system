<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>E-learning Registration</title>
    <style>
        body {
            background: url('file:///C:/Users/Hp/Downloads/dom-fou-YRMWVcdyhmI-unsplash.jpg') center/cover; /* Use file:/// protocol for local file paths */
            color: #ffffff;
        }

        .overlay {
            background-color: rgba(0, 0, 0, 0.6);
        }

        .container {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .card {
            width: 400px;
            padding: 30px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        .card-title {
            color: #6c757d;
            text-align: center;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-control {
            border-radius: 5px;
        }

        .btn-primary {
            background-color: #6c757d;
            border: none;
            border-radius: 5px;
            padding: 10px;
            width: 100%;
        }

        .btn-primary:hover {
            background-color: #555e66;
        }

        .forgot-password {
            text-align: center;
            margin-top: 15px;
            color: #007bff;
        }
    </style>
</head>
<body>
    <div class="container overlay">
        <div class="card">
            <h2 class="mb-4 card-title">Login</h2>
            <form action="${pageContext.request.contextPath}/users/login" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name = "username" placeholder="Enter username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name ="password" placeholder="Enter password">
                </div>
                
                <input type="submit" class="btn btn-primary btn-sm"  value = "Log in">
            </form>
            
        </div>
    </div>
</body>
</html>
