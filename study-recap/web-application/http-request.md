# HTTP 요청
### HTTP 요청 메시지를 통해 클라이언트에서 서버로 데이터를 전달하는 방법은 크게 3가지 방법을 사용한다.
### GET - 쿼리 파라미터
* 메시지 바디 없이, URL의 쿼리 파라미터에 데이터를 포함 전달
* 주로 검색 필터 페이징등에서 사용
### POST - HTML Form
* content-type: application/x-www-form-urlencoded
* 요청 메시지 바디에 쿼리 파라미터 형식으로 서버에 전달한다
* 예) name=son&address=seoul 
* 주로 상품 주문, 회원 가입 같은 HTML Form을 통해 전달되는 방식
### HTTP 메시지 본문에 데이터를 담아서 요청
* HTTP API(REST api)에서 주로 사용한다. JSON, XML, TEXT
* 데이터 형식은 주로 JSON을 사용한다. (POST, PUT, PATCH)
