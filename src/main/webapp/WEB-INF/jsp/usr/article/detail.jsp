<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${article.id}번 게시물 상세</title>
</head>
<body>
    <h1>${article.id}번 게시물 상세</h1>
    <hr />
    <table border="1">
        <tr>
            <th>번호</th>
            <td>${article.id}</td>
        </tr>
        <tr>
            <th>작성날짜</th>
            <td>${article.regDate}</td>
        </tr>
        <tr>
            <th>수정날짜</th>
            <td>${article.updateDate}</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>${article.memberId}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${article.title}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${article.body}</td>
        </tr>
    </table>

    <div class="btns">
        <button type="button" onclick="history.back();">뒤로가기</button>
        <a href="doDelete?id=${article.id}">삭제</a>
        <a href="modify?id=${article.id}">수정</a>
    </div>
</body>
</html>