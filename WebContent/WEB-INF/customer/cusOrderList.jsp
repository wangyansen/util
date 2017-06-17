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
    	<li><a href="###">我的预约记录</a></li>
        <li>查看</li>
    </ul>
</div>
<form class="form-inline" action="<%=basePath%>order/findOrderByDoctorName.do" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">预约医生姓名：</label>
        <input type="text" class="form-control" id="activename" placeholder="请输入医生姓名" name="doctorName">
      </div>

    <input type="submit"  class="btn btn-danger"  value="查询"/>
     <a  class="btn btn-success"  href="<%=basePath%>order/orderAdd.do">添加预约</a>
</div>



<div class="row" style="padding:15px; padding-top:0px;">
	<table class="table  table-condensed table-striped">
		<tr>
        	<th>序号</th>
            <th>预约医生姓名</th>
            <th>预约时间</th>
            <th>预约原因及备注</th>
            <th>预约状态</th>
            <th>操作</th>
        </tr>
         <c:forEach items="${orderList}" var="orderList" varStatus="idx">
        <tr>
        	<td>${idx.index+1}</td>
        	<td>${ orderList.user.userName}</td>
        	<td><fmt:formatDate value="${ orderList.orderTime}" pattern="yyyy-MM-dd" /></td>
        	<td>${ orderList.remark}</td>
        	<c:if test="${orderList.orderStatus == '1' }">
        	<td>预约成功</td>
        	</c:if>
        	<c:if test="${orderList.orderStatus == '0' }">
        	<td>正在申请中</td>
        	</c:if >
        	<c:if test="${orderList.orderStatus == '0' }">
        	<th>
        	<a href="order/updateOrderOne.do?id=${orderList.id}">修改</a> 
        	<a href="javascript:deleteThisOrder(${orderList.id});">删除</a>
        	</th>
        	</c:if>
        	<c:if test="${orderList.orderStatus == '1' }">
        	<th>
        	<a href="javascript:deleteThisOrder(${orderList.id});">取消此预约</a>
        	</th>
        	</c:if>
        </tr>
        </c:forEach>
		 
    </table>
</div>
</form>

</body>
</html>
