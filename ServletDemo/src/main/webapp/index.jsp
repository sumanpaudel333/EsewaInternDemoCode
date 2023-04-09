<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>CRUD operation for user</title>
  <style>
    input[type=text], [type=password],[type=email] {
      width: 80%;
      padding: 12px 20px;
      margin: 8px 0;
      box-sizing: border-box;
    }
    input[type=button], input[type=submit], input[type=reset] a{
      background-color: #04AA6D;
      border: none;
      color: white;
      padding: 16px 32px;
      text-decoration: none;
      margin: 4px 2px;
      cursor: pointer;
    }
  </style>
</head>
<body>
<h1>Welcome to CRUD operation portal</h1>
<form action="SaveServlet" method="post">
  <label for="name">Username:</label>
  <input type="text" name="name" id="name"><br>
  <label for="email">Email:</label>
  <input type="email" name="email" id="email"><br>
  <label for="password">Password:</label>
  <input type="password" name="password" id="password"><br>
  <input type="submit">
</form>
<button><a href="${pageContext.request.contextPath}/view">View Users</a></button>
</body>
</html>