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
    	<li><a href="stuStudent.do?findAllStudent">我的历史处方</a></li>
        <li>处方记录</li>
    </ul>
</div>
<form class="form-inline" action="<%=basePath%>chufang/findChufangListBySickerName.do" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">患者姓名：</label>
        <input type="text" class="form-control" id="activename" placeholder="请输入患者姓名" name="sickerName">
      </div>

    <input type="submit"  class="btn btn-danger"  value="查询"/>
    <a  class="btn btn-success"  href="<%=basePath%>chufang/chufangAdd.do">添加处方</a>
    
</div>



<div class="row" style="padding:15px; padding-top:0px;">
	<table class="table  table-condensed table-striped">
		<tr>
        	<th>序号</th>
            <th>患者姓名</th>
            <th>主治医师</th>
            <th>所患病症</th>
            <th>治疗时间</th>
            <th>所用药品</th>
            <th>所用医疗器械</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${chufangList}" var="chufangList" varStatus="idx">
        <tr>
        	<td>${idx.index+1}</td>
        	<td>${ chufangList.sickerName}</td>
        	<td>${userName}</td>
        	<td>${ chufangList.sickName}</td>
        	<td><fmt:formatDate value="${ chufangList.openTime}" pattern="yyyy-MM-dd" /></td>
        	<td>${ chufangList.drug.drugName}</td>
        	<td>${chufangList.medicalAppliance.medicalApplianceName }</td>
        	<td>${ chufangList.remark}</td>
        	<th>
            <a href="chufang/updateChufangOne.do?chufangId=${chufangList.id}">修改</a> 
            <a href="chufang/deleteChufang.do?chufangId=${chufangList.id}">删除</a>
            </th>
        </tr>
        </c:forEach>
		
    </table>
</div>
</form>
</body>
</html>
