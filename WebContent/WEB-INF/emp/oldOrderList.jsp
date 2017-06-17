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
<title>��ҳ</title>
<!-- �� Bootstrap ���� CSS �ļ� -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jQuery�ļ��������bootstrap.min.js ֮ǰ���� -->
<script src="js/jquery.min.js"></script>
<!-- ���µ� Bootstrap ���� JavaScript �ļ� -->
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="stuStudent.do?findAllStudent">�ҵ�ԤԼ����</a></li>
        <li>�Ѵ������ԤԼ��¼</li>
    </ul>
</div>
<form class="form-inline" action="<%=basePath%>order/findOrderBySickerName.do?mark=2" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">ԤԼ��������</label>
        <input type="text" class="form-control" id="activename" placeholder="������ԤԼ����" name="sickerName">
      </div>

    <input type="submit"  class="btn btn-danger"  value="��ѯ"/>
</div>



<div class="row" style="padding:15px; padding-top:0px;">
	<table class="table  table-condensed table-striped">
		<tr>
        	<th>���</th>
            <th>ԤԼ������</th>
            <th>ԤԼ���Ա�</th>
            <th>ԤԼ�˵绰</th>
            <th>ԤԼʱ��</th>
            <th>ԤԼԭ�򼰱�ע</th>
            <th>ԤԼ״̬</th>
        </tr>
         <c:forEach items="${orderList}" var="orderList" varStatus="idx">
        <tr>
        	<td>${idx.index+1}</td>
        	<td>${ orderList.user.userName}</td>
        	<td>${orderList.user.sex}</td>
        	<td>${ orderList.user.phone}</td>
        	<td><fmt:formatDate value="${ orderList.orderTime}" pattern="yyyy-MM-dd" /></td>
        	<td>${ orderList.remark}</td>
        	<td>��ͬ��</td>
        </tr>
        </c:forEach>
		 
    </table>
</div>
</form>

</body>
</html>
