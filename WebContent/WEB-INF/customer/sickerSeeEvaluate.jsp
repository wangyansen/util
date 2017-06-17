<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
 <base href="<%=basePath%>">
<meta charset="gbk">
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>首页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/commen.js">

</script>
</head>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="stuStudent.do?findAllStudent">主治医师一览</a></li>
        <li>查看此医生的评论记录</li>
    </ul>
</div>

<div class="row" style="padding:15px; padding-top:0px;">
	<table class="table  table-condensed table-striped">
		<tr>
        	<th>序号</th>
            <th>评论者</th>
            <th>评论时间</th>
            <th>评论内容</th>
        </tr>
         <c:forEach items="${list}" var="list" varStatus="idx">
        <tr>
        	<td>${idx.index+1}</td>
        	<td>${ list.user.userName}</td>
        	<td><fmt:formatDate value="${ list.evaluateTime}" pattern="yyyy-MM-dd" /></td>
        	<td>${ list.evaluateDetails}</td>
        </tr>
        </c:forEach>
		 
    </table>
</div>
  	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
              <a class="btn btn-warning" href="<%=basePath%>welcome/findAllDoctor.do">返回上一级</a>
        </div>
    </div>

</body>
</html>
