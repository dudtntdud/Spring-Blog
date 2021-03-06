<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content= "text/html; charset=UTF-8">
    <!-- BootStrap CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <title>게시글 작성</title>
</head>
<body>
<h3>게시글 작성</h3>
<div style="padding : 30px;">

    <div class="form-group">
        <label>영화</label>
        <input type="text" name="movie" class="form-control">
    </div>
    <button type="submit" class="btn btn-default" style="margin-bottom:10px">영화검색</button>
    <div class="form-group">
        <label>글제목</label>
        <input type="text" name="subject" class="form-control">
    </div>
    <div class="form-group">
        <label>작성자</label>
        <input type="text" name="writer" class="form-control">
    </div>
    <div class="form-group">
        <label>내용</label>
        <textarea name="content" class="form-control" rows="5"></textarea>
    </div>
    <form method="POST" action="/board/post">
        <button type="submit" class="btn btn-default">작성</button>
    </form>
</div>
</body>
</html>