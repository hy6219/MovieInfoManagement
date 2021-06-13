<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  request.setCharacterEncoding("UTF-8"); %>
<%  response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 정보 수정</title>
<link rel="stylesheet" href="./css/update.css">
</head>
<script src="./js/updateMovie.js"></script>
<body>
	<header>
		<h1>영화 정보 수정</h1>
	</header>
	<section>
		<article>
			<form method="post" enctype="multipart/form-data" name="frm">
			<input type="hidden" name="code" value="${targetToUpdate.code }">
			<input type="hidden" name="posterBefore" value="${targetToUpdate.poster }">
				<table id="outer">
					<tr>
						<td>
							<c:choose>
								<c:when test="${empty targetToUpdate.poster}">
									<img src="./img/noImg.png" alt="no image"/>
								</c:when>
								<c:otherwise>
									<img src="upload/${targetToUpdate.poster}" alt="${targetToUpdate.poster }"/>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<table id="inner">
								<tr>
									<th>제목</th>
									<td><input type="text" name="title" value="${targetToUpdate.title }"></td>
								</tr>
								<tr>
									<th>가격</th>
									<td><input type="text" name="price" value="${targetToUpdate.price }">원</td>
								</tr>
								<tr>
									<th>감독</th>
									<td><input type="text" name="director" value="${targetToUpdate.director }"></td>
								</tr>
								<tr>
									<th>배우</th>
									<td><input type="text" name="actor" value="${targetToUpdate.actor }"></td>
								</tr>
								<tr>
									<th>시놉시스</th>
									<td><textarea cols="90" rows="20" name="synopsis">${targetToUpdate.synopsis }</textarea></td>
								</tr>
								<tr>
									<th>사진</th>
									<td><input type="file" name="poster"><br>
									(필요한 경우, 수정해야할 경우에만 10MB 크기 이하의 이미지를 교체해주세요)
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<div id="btn">
				<input type="submit" value="수정" onclick="return updateCheck();">
				<input type="button" value="목록" onclick="location.href='movieList.do';">
				</div>
			</form>
		</article>
	</section>
</body>
</html>