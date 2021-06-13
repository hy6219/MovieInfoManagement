<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  request.setCharacterEncoding("UTF-8"); %>
<%  response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글	조회</title>
<link rel="stylesheet" href="./css/common.css">
</head>
<body>
	<header>
		<h1>게시글 조회</h1>
	</header>
	<section>
		<article>
			<table id="wrap">
					<tr>
						<td colspan="6">
							<a href="movieReigster.do">정보 등록</a>
						</td>
					</tr>
					<tr>
						<th>제목</th>
						<th>감독</th>
						<th>배우</th>
						<th>가격</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
				<c:choose>
						<c:when test="${empty movieList}">
							<tr>
								<td colspan="2">---영화 목록이 존재하지 않습니다---</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="list" items="${movieList }">
								<tr>
									<td>${list.title }</td>
									<td>${list.director }</td>
									<td>${list.actor }</td>
									<td>${list.price } 원</td>
									<td><a href="movieUpdate.do?code=${list.code}">정보 수정</a></td>
									<td><a href="movieDelete.do?code=${list.code}">정보 삭제</a></td>									
								</tr>
							</c:forEach>
						
						</c:otherwise>
					</c:choose>
			</table>
		</article>
	</section>
</body>
</html>