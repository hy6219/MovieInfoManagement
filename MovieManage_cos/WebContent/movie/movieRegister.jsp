<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("UTF-8"); %>
<%  response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화등록페이지</title>
<link rel="stylesheet" href="./css/register.css">
</head>
<body>
	<header>
		<h1>영화 정보 등록</h1>
	</header>
	<section>
		<article>
			<form method="post" enctype="multipart/form-data" name="frm">
				<table id="wrap">
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" required></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="text" name="price" required>원</td>
					</tr>
					<tr>
						<th>감독</th>
						<td><input type="text" name="director" required></td>
					</tr>
					<tr>
						<th>배우</th>
						<td><input type="text" name="actor" required></td>
					</tr>
					<tr>
						<th>설명</th>
						<td><textarea rows="20" cols="90" name="synopsis" required></textarea></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="file" name="poster" required><br>
							(최대 10MB 까지의 파일업로드가능!)
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="전송">
							<input type="reset"  value="다시 작성">
							<input type="button" value="목록" onclick="location.href='movieList.do';">
						</td>
					</tr>
				</table>
			</form>
		</article>
	</section>
</body>
</html>