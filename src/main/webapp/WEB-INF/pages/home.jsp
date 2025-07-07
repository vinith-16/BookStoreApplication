<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Store Home</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f5;
        }

        .navbar {
            background-color: #333;
            padding: 15px 30px;
            color: #fff;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar h1 {
            margin: 0;
            font-size: 24px;
        }

        .navbar a {
            color: #fff;
            text-decoration: none;
            margin-left: 20px;
            font-weight: bold;
        }

        .hero {
            background-image: url('https://images.unsplash.com/photo-1512820790803-83ca734da794');
            background-size: cover;
            background-position: center;
            height: 400px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #fff;
            text-align: center;
        }

        .hero h2 {
            font-size: 48px;
            background-color: rgba(0, 0, 0, 0.6);
            padding: 20px;
            border-radius: 10px;
        }

        .features {
            display: flex;
            justify-content: space-around;
            padding: 40px 20px;
            background-color: #fff;
        }

        .feature-box {
            width: 30%;
            text-align: center;
        }

        .feature-box h3 {
            color: #333;
        }

        .feature-box p {
            color: #555;
        }

        .footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 15px;
        }
    </style>
</head>
<body>

    <div class="navbar">
        <h1>BookStore</h1>
        <div>
            <a href="/login">Login</a>
            <a href="/signup">Signup</a>
            <a href="/view">Books</a>
        </div>
    </div>

    <div class="hero">
        <h2>Welcome to the World of Books</h2>
    </div>

    <div class="features">
        <div class="feature-box">
            <h3>Wide Collection</h3>
            <p>Explore thousands of books across all genres and authors.</p>
        </div>
        <div class="feature-box">
            <h3>Easy Access</h3>
            <p>Find and manage your favorite books effortlessly.</p>
        </div>
        <div class="feature-box">
            <h3>Secure Login</h3>
            <p>Protect your data with our secure and reliable system.</p>
        </div>
    </div>

    <div class="footer">
        &copy; 2025 BookStore. All Rights Reserved.
    </div>

</body>
</html>
