package hello.Servlet.basic.reqeust;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;


// Http 요청 메세지의 요소를 꺼내보는 예제
@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);

        response.getWriter().write("ok");
    }

    // Http 요청 메세지의 start line 정보 출력하기
    private void printStartLine(HttpServletRequest request) {
        System.out.println("--- 요청 라인 - 시작 ---");
        System.out.println("request.getMethod() = " + request.getMethod()); // Http 메서드 호출 GET
        System.out.println("request.getProtocol() = " + request.getProtocol()); // HTTP/1.1 - 프로토콜
        System.out.println("request.getScheme() = " + request.getScheme()); //http - 스킴
        System.out.println("request.getRequestURL() = " + request.getRequestURL()); // 요청 URL - http://localhost:8080/request-header
        System.out.println("request.getRequestURI() = " + request.getRequestURI()); // /request-header
        System.out.println("request.getQueryString() = " +
                request.getQueryString());  //username=hi - 쿼리 스트링 가져오기
        System.out.println("request.isSecure() = " + request.isSecure()); //https  사용 유무
        System.out.println("--- 요청 라인 - 끝 ---");
        System.out.println();
    }

    // Http 요청 헤더의 모든 정보 출력하기
    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- 헤더 - 시작 ---");
    /* 옛날 방식의 컬렉션 프레임워크에 속한 인터페이스 Enumeration
        Vector와 같은 컬렉션에서 요소를 순차적으로 읽어오는 방법을 제공한다.'
        일부 레거시 코드나 오래된 라이브러리에서 여전히 사용되는 컬렉션.
        Enumeration<String> headerNames = request.getHeaderNames();    // 헤더 정보를 저장
        while (headerNames.hasMoreElements()) {    // 읽어올 요소가 있는지 확인
        String headerName = headerNames.nextElement(); // 다음 요소를 반환한다.
        System.out.println(headerName + ": " + request.getHeader(headerName)); // 헤더 출력
 }
    */
        /*
            최신 방식, Stream API를 사용하여 작업을 간결하게 수행한다.
         */
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ":" + request.getHeader(headerName)));
        System.out.println("--- Headers - end ---");
        System.out.println();
    }

    //Header 편리한 조회
    private void printHeaderUtils(HttpServletRequest request) {

        System.out.println("--- Header 편의 조회 start ---");

        // host 조회
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " +
                request.getServerName()); //Host 헤더 - localhost
        System.out.println("request.getServerPort() = " +
                request.getServerPort()); //Host 헤더 - 8080
        System.out.println();

        // Accep-Language 헤더 조회
        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " +
                        locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        // Cookie 조회
        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();
        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " +
                request.getContentType());
        System.out.println("request.getContentLength() = " +
                request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " +
                request.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }


    //기타 정보
    // Http 메세지 정보 아님
    private void printEtc(HttpServletRequest request) {
        System.out.println("--- 기타 조회 start ---");
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " +
                request.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " +
                request.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " +
                request.getRemotePort()); //
        System.out.println();
        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " +
                request.getLocalName()); //
        System.out.println("request.getLocalAddr() = " +
                request.getLocalAddr()); //
        System.out.println("request.getLocalPort() = " +
                request.getLocalPort()); //
        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }
}
