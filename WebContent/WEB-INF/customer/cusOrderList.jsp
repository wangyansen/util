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
<script type="text/javascript" src="js/commen.js">

</script>
</head>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="###">�ҵ�ԤԼ��¼</a></li>
        <li>�鿴</li>
    </ul>
</div>
<form class="form-inline" action="<%=basePath%>order/findOrderByDoctorName.do" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">ԤԼҽ��������</label>
        <input type="text" class="form-control" id="activename" placeholder="������ҽ������" name="doctorName">
      </div>

    <input type="submit"  class="btn btn-danger"  value="��ѯ"/>
     <a  class="btn btn-success"  href="<%=basePath%>order/orderAdd.do">���ԤԼ</a>
</div>



<div class="row" style="padding:15px; padding-top:0px;">
	<table class="table  table-condensed table-striped">
		<tr>
        	<th>���</th>
            <th>ԤԼҽ������</th>
            <th>ԤԼʱ��</th>
            <th>ԤԼԭ�򼰱�ע</th>
            <th>ԤԼ״̬</th>
            <th>����</th>
        </tr>
         <c:forEach items="${orderList}" var="orderList" varStatus="idx">
        <tr>
        	<td>${idx.index+1}</td>
        	<td>${ orderList.user.userName}</td>
        	<td><fmt:formatDate value="${ orderList.orderTime}" pattern="yyyy-MM-dd" /></td>
        	<td>${ orderList.remark}</td>
        	<c:if test="${orderList.orderStatus == '1' }">
        	<td>ԤԼ�ɹ�</td>
        	</c:if>
        	<c:if test="${orderList.orderStatus == '0' }">
        	<td>����������</td>
        	</c:if >
        	<c:if test="${orderList.orderStatus == '0' }">
        	<th>
        	<a href="order/updateOrderOne.do?id=${orderList.id}">�޸�</a> 
        	<a href="javascript:deleteThisOrder(${orderList.id});">ɾ��</a>
        	</th>
        	</c:if>
        	<c:if test="${orderList.orderStatus == '1' }">
        	<th>
        	<a href="javascript:deleteThisOrder(${orderList.id});">ȡ����ԤԼ</a>
        	</th>
        	</c:if>
        </tr>
        </c:forEach>
		 
    </table>
</div>
</form>

</body>
</html>
