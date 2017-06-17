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
    	<li><a href="stuStudent.do?findAllStudent">我的评价记录</a></li>
        <li>查看</li>
    </ul>
</div>
<form class="form-inline" action="" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">医生姓名：</label>
        <input type="text" class="form-control" id="activename" placeholder="请输入医生姓名" name="sickerName">
      </div>

    <input type="submit"  class="btn btn-danger"  value="查询"/>
    <a  class="btn btn-success"  href="<%=basePath%>evaluate/addEvaluate.do">新增评论</a>
</div>



<div class="row" style="padding:15px; padding-top:0px;">
	<table class="table  table-condensed table-striped">
		<tr>
        	<th>序号</th>
            <th>医生姓名</th>
            <th>评论时间</th>
            <th>评论内容</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
         <c:forEach items="${evaluateList}" var="evaluateList" varStatus="idx">
        <tr>
        	<td>${idx.index+1}</td>
        	<td>${ evaluateList.user.userName}</td>
        	<td><fmt:formatDate value="${ evaluateList.evaluateTime}" pattern="yyyy-MM-dd" /></td>
        	<td>${ evaluateList.evaluateDetails}</td>
        	<c:if test="${evaluateList.delFlag == '1' }">
        	<td>未回复</td>
        	</c:if>
        	<c:if test="${evaluateList.delFlag == '0' }">
        	<td>已回复</td>
        	</c:if>
        	<c:if test="${evaluateList.delFlag == '0' }">
        	<th>
        	<a href="evaluate/seeReplyEvaluate.do?eid=${evaluateList.id}">查看回复内容</a>
        	</th>
        	</c:if>
        	<c:if test="${evaluateList.delFlag == '1' }">
        	<th>
        	</th>
        	</c:if>
        </tr>
        </c:forEach>
		 
    </table>
</div>
</form>

</body>
</html>
