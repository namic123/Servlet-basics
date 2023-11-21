package hello.Servlet.basic.reqeust;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

// HTTP 요청 바디 활용 예제
@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 메시지 바디의 내용을 바이트 코드로 받을 수 있음
        ServletInputStream inputStream = request.getInputStream();
        // 위 메시지 바디의 바이트 코드를 인코딩 형식 UTF-8 스트링 형식으로 바꿈
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("messageBody = " + messageBody);

        // 응답 본문에 데이터를 직접 입력
        response.getWriter().write("ok");
    }
}
