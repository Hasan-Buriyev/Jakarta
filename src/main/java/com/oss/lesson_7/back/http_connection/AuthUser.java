package com.oss.lesson_7.back.http_connection;

import com.oss.lesson_7.back.Enums.Gender;
import com.oss.lesson_7.back.JDBC.Methods;
import com.oss.lesson_7.back.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Auth", value = "/auth")
public class AuthUser extends HttpServlet {
    private static final Methods jdbc=Methods.getInstance();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter writer = res.getWriter();
        res.setContentType("text/html");
        writer.println("""
                <head>
                           <meta charset="UTF-8">
                           <meta name="viewport" content="width=device-width, initial-scale=1.0">
                           <title>Styled Form</title>
                           <style>
                               body {
                                   font-family: Arial, sans-serif;
                                   display: flex;
                                   justify-content: center;
                                   align-items: center;
                                   height: 100vh;
                                   background-color: #f0f0f0;
                                   margin: 0;
                               }
                               form {
                                   background-color: #fff;
                                   padding: 20px;
                                   border-radius: 8px;
                                   box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                                   max-width: 400px;
                                   width: 100%;
                               }
                               form div {
                                   margin-bottom: 15px;
                               }
                               label {
                                   display: block;
                                   margin-bottom: 5px;
                                   font-weight: bold;
                               }
                               input[type="text"], input[type="password"], input[type="number"], select {
                                   width: 100%;
                                   padding: 10px;
                                   margin-top: 5px;
                                   border: 1px solid #ccc;
                                   border-radius: 4px;
                               }
                               select {
                                   padding: 10px;
                               }
                               input[type="submit"] {
                                   background-color: #4CAF50;
                                   color: white;
                                   padding: 10px 15px;
                                   border: none;
                                   border-radius: 4px;
                                   cursor: pointer;
                                   font-size: 16px;
                               }
                               input[type="submit"]:hover {
                                   background-color: #45a049;
                               }
                           </style>
                       </head>
                       <body>
                       <form method="post">
                           <div>
                               <label for="name">Name</label>
                               <input type="text" name="name" id="name" placeholder="name">
                           </div>
                           <div>
                               <label for="username">Username</label>
                               <input type="text" name="username" id="username" placeholder="username">
                           </div>
                           <div>
                               <label for="password">Password</label>
                               <input type="password" name="password" id="password" placeholder="password">
                           </div>
                           <div>
                               <label for="phoneNumber">Phone Number</label>
                               <input type="number" name="phoneNumber" id="phoneNumber" placeholder="phone number">
                           </div>
                           <div>
                               <label for="gender">Gender</label>
                               <select name="gender" id="gender">
                                   <option value="FEMALE">Female</option>
                                   <option value="MALE">Male</option>
                                   <option value="DEFAULT">Unspecified</option>
                               </select>
                           </div>
                           <div>
                               <input type="submit" value="Submit">
                           </div>
                       </form>
                       </body>
                       </html>
                """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(
                req.getParameter("name"),
                req.getParameter("username"),
                req.getParameter("password"),
                req.getParameter("phoneNumber"),
                Gender.valueOf(req.getParameter("gender")));
        jdbc.sava(user);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1><a href=\"index.jsp\">Home</a></h1><br>");
        out.println("<h1><a href=\"/auth\">Sign Up</a></h1><br>");
        out.println("<h1><a href=\"/authors\">All Users Go my friend</a></h1>");
    }
}
