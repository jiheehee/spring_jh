<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="게시판리스트"/>
</jsp:include>

<section id="board-container" class="container">
        <p>총 ${totalContents }건의 게시물이 있습니다.</p>
        <table>
          <td>
             <button class="btn btn-outline-success" ahref="${path }/board/insertboard.do">등록</button>
             <button class="btn btn-outline-success">수정</button>
             <button class="btn btn-outline-danger">삭제</button>
          </td>
         </table>
        
        <table id="tbl-board" class="table table-striped table-hover">
            <tr>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">작성일</th>
                <th scope="col">첨부파일</th>
                <th scope="col">조회수</th>
            </tr>
            <c:if test="${not empty boards }">
            	<c:forEach var="b" items="${boards }">
            		<tr>
            			<td scope="col">${b.boardNo }</td>
            			<td scope="col">${b.boardTitle }</td>
            			<td scope="col">${b.boardWriter }</td>
            			<td scope="col">${b.boardDate }</td>
            			<td scope="col"></td>
            			<td scope="col">${b.boardReadCount }</td>
            		</tr>
            	</c:forEach>
          	</c:if>  
        </table> 
</section>



<jsp:include page="/WEB-INF/views/common/footer.jsp"/>