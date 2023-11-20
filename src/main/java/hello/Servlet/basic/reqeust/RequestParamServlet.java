package hello.Servlet.basic.reqeust;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// 리퀘스트 파라미터 꺼내오는 메서드 예제
@WebServlet(name ="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException {
        // 전체 파라미터 조회
        System.out.println("전체 파라미터 조회 시작");
        request.getParameterNames()
                .asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName+"="+request.getParameter(paramName)));
        System.out.println("전체 파라미터 조회 끝");
        // 단일 파라미터 조회
        System.out.println("단일 파라미터 조회 ");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println();

        // 이름이 같은 복수 파라미터 조회
        System.out.println("이름이 같은 복수 파라미터 조회");
        String[] usernames = request.getParameterValues("username");
        for(String name: usernames){
            System.out.println("name = " + name);
        }
    }
}
