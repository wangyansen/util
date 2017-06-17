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
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="stuStudent.do?findAllStudent">药品一览</a></li>
        <li>查看</li>
    </ul>
</div>
<form class="form-inline" action="" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">药品名字：</label>
        <input type="text" class="form-control" id="activename" placeholder="请输入药品名" name="">
      </div>

    <input type="submit"  class="btn btn-danger"  value="查询"/>
</div>



<div class="row" style="padding:15px; padding-top:0px;">
	<table class="table  table-condensed table-striped">
		<tr>
        	<th>序号</th>
            <th>药品名称</th>
            <th>出厂公司</th>
            <th>价格</th>
            <th>库存</th>
            <th>出厂日期</th>
            <th>备注</th>
        </tr>
        <c:forEach items="${drugList}" var="drugList" varStatus="idx">
        <tr>
        	<td>${idx.index+1}</td>
        	<td>${ drugList.drugName}</td>
        	<td>${drugList.drugCompany}</td>
        	<td>${ drugList.drugPrice}元</td>
        	<td>${ drugList.drugAmount}</td>
        	<td><fmt:formatDate value="${ drugList.drugExp}" pattern="yyyy-MM-dd" /></td>
        	<td>${ drugList.drugRemark}</td>
        </tr>
        </c:forEach>
		
    </table>
</div>
</form>
</body>
</html>
