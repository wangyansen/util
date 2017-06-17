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
    	<li><a href="stuStudent.do?findAllStudent">ҩƷһ��</a></li>
        <li>�鿴</li>
    </ul>
</div>
<form class="form-inline" action="" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">ҩƷ���֣�</label>
        <input type="text" class="form-control" id="activename" placeholder="������ҩƷ��" name="">
      </div>

    <input type="submit"  class="btn btn-danger"  value="��ѯ"/>
</div>



<div class="row" style="padding:15px; padding-top:0px;">
	<table class="table  table-condensed table-striped">
		<tr>
        	<th>���</th>
            <th>ҩƷ����</th>
            <th>������˾</th>
            <th>�۸�</th>
            <th>���</th>
            <th>��������</th>
            <th>��ע</th>
        </tr>
        <c:forEach items="${drugList}" var="drugList" varStatus="idx">
        <tr>
        	<td>${idx.index+1}</td>
        	<td>${ drugList.drugName}</td>
        	<td>${drugList.drugCompany}</td>
        	<td>${ drugList.drugPrice}Ԫ</td>
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
