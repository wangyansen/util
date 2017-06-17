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
    	<li><a href="stuStudent.do?findAllStudent">�ҵ���ʷ����</a></li>
        <li>������¼</li>
    </ul>
</div>
<form class="form-inline" action="<%=basePath%>chufang/findChufangListBySickerName.do" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">����������</label>
        <input type="text" class="form-control" id="activename" placeholder="�����뻼������" name="sickerName">
      </div>

    <input type="submit"  class="btn btn-danger"  value="��ѯ"/>
    <a  class="btn btn-success"  href="<%=basePath%>chufang/chufangAdd.do">��Ӵ���</a>
    
</div>



<div class="row" style="padding:15px; padding-top:0px;">
	<table class="table  table-condensed table-striped">
		<tr>
        	<th>���</th>
            <th>��������</th>
            <th>����ҽʦ</th>
            <th>������֢</th>
            <th>����ʱ��</th>
            <th>����ҩƷ</th>
            <th>����ҽ����е</th>
            <th>��ע</th>
            <th>����</th>
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
            <a href="chufang/updateChufangOne.do?chufangId=${chufangList.id}">�޸�</a> 
            <a href="chufang/deleteChufang.do?chufangId=${chufangList.id}">ɾ��</a>
            </th>
        </tr>
        </c:forEach>
		
    </table>
</div>
</form>
</body>
</html>
