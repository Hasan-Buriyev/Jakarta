package com.oss.lesson_7.back.http_connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculate", value = "/cal")
public class Calculate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        writer.println("""
                <form method="post">
                    <div style="padding: 10px">
                        <label for="n1">Num one</label>
                        <input name="in_a" id="n1" type="number">
                        <select name="op" style="font-size:20px">
                            <option value="+">+</option>
                            <option value="-">-</option>
                            <option value="*">*</option>
                            <option value="/">/</option>
                        </select>
                        <label for="n2">Num two</label>
                        <input type="number" name="in_b" id="n2">
                    </div>
                    <div>
                        <button type="submit">Submit</button>
                    </div>
                </form>
                """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer a = Integer.valueOf(req.getParameter("in_a"));
            Integer b = Integer.valueOf(req.getParameter("in_b"));

            String op = req.getParameter("op");
            double sum = switch (op){
                case "+"->a+b;
                case "-"->a-b;
                case "*"->a*b;
                default-> (double) a /b;
            };
            PrintWriter writer = resp.getWriter();
            resp.setContentType("text/html");
            writer.println("""
                    <form method="get">
                    <div style="padding: 10px;font-size: 20px">
                                         <p>%s %s %s = %s</p>
                                         <a href="/cal">Reset</a><br>
                                         <a href="index.jsp">Home</a>
                                     </div>
                                     </form>
                """.formatted(a,op,b,sum));
        }catch (Exception e){
            PrintWriter writer = resp.getWriter();
            resp.setContentType("text/html");
            writer.println("""
                    <form method="get">
                    <div style="padding: 10px;font-size: 20px">
                                         <h1>ERROR PLEASE TRY AGAIN </h1>
                                         <a href="/cal">TRY AGAIN</a>
                                     </div>
                                     </form>
                """);
        }

    }
}
