package com.oss.lesson_7.back.http_connection;

import com.oss.lesson_7.back.JDBC.Methods;
import com.oss.lesson_7.back.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "authors", value = "/authors")
public class Authors extends HttpServlet {
    private static final Methods method = Methods.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = method.getAll();
        PrintWriter writer = resp.getWriter();
        String str = """
                <head>
                    <title>Pagination Example</title>
                    <style>
                        table {
                            width: 80%;
                            border-collapse: collapse;
                            margin: auto;
                        }
                        table, th, td {
                            border: 1px solid black;
                        }
                        th, td {
                            padding: 8px;
                            text-align: left;
                        }
                        .pagination {
                            margin-top: 20px;
                        }
                        .pagination button {
                            padding: 10px;
                            margin: 5px;
                            cursor: pointer;
                        }
                    </style>
                </head>
                <body>
                <table id="data-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Phone Number</th>
                        <th>Gender</th>
                    </tr>
                    </thead>
                    <tbody>""";
        StringBuilder htmlcode = new StringBuilder(str);
        String td = "<tr>\n" +
                "        <td>%s</td>\n" +
                "        <td>%s</td>\n" +
                "        <td>%s</td>\n" +
                "        <td>%s</td>\n" +
                "        <td>%s</td>\n" +
                "        <td>%s</td>\n" +
                "    </tr>";
        for (User user : users) {
            htmlcode.append(td.formatted(
                    user.getId(),
                    user.getName(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getPhoneNumber(),
                    user.getGender().toString()
            ));
        }
        htmlcode.append("</tbody>").append("</table><br>");
        htmlcode.append("<h1><a href=\"/auth\">Sign Up</a></h1><br>");
        htmlcode.append("<h1><a href=\"/index.jsp\">Home</a></h1>");
        htmlcode.append("</body>").append("</html>");
        writer.write(htmlcode.toString());
    }
}
