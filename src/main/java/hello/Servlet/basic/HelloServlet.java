package hello.Servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username"); // 리퀘스트 파라미터를 받아옴
        System.out.println("username = " + username);

        response.setContentType("text/plain");  // http 응담 헤더에 포함
        response.setCharacterEncoding("utf-8"); // http 응담 헤더에 포함
        response.getWriter().write("hello"+username);
    }
}
