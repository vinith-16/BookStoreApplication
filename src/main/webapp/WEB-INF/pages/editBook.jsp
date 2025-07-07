<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Book</title>
    <style>
    body {
            font-family: Arial, sans-serif;
            background-color: pink;
            padding: 40px;
        }

        form {
            background-color: white;
                        padding: 25px;
            border-radius: 8px;
            width: 400px;
            margin: 0 auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
                h2 {
            text-align: center;
            color: #333;
        }

        label {
            font-weight: bold;
        }

        input[type="text"], input[type="password"], input[type="submit"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: red;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    
    </style>
</head>
<body>

    <h2>Edit Book</h2>
    <form action="${pageContext.request.contextPath}/update" method="post">
        <input type="hidden" name="bookNo" value="${book.bookNo}" />

        Title: <input type="text" name="title" value="${book.title}" required /><br><br>
        Author: <input type="text" name="author" value="${book.author}" required /><br><br>
        Publisher: <input type="text" name="publisher" value="${book.publisher}" required /><br><br>
        Category: <input type="text" name="category" value="${book.category}" required /><br><br>
        Price: <input type="number" name="price" value="${book.price}" required /><br><br>

        <input type="submit" value="Update Book" />
    </form>
</body>
</html>
