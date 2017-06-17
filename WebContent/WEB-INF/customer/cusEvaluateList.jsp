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
    	<li><a href="stuStudent.do?findAllStudent">�ҵ����ۼ�¼</a></li>
        <li>�鿴</li>
    </ul>
</div>
<form class="form-inline" action="" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">ҽ��������</label>
        <input type="text" class="form-control" id="activename" placeholder="������ҽ������" name="sickerName">
      </div>

    <input type="submit"  class="btn btn-danger"  value="��ѯ"/>
    <a  class="btn btn-success"  href="<%=basePath%>evaluate/addEvaluate.do">��������</a>
</div>



<div class="row" style="padding:15px; padding-top:0px;">
	<table class="table  table-condensed table-striped">
		<tr>
        	<th>���</th>
            <th>ҽ������</th>
            <th>����ʱ��</th>
            <th>��������</th>
            <th>״̬</th>
            <th>����</th>
        </tr>
         <c:forEach items="${evaluateList}" var="evaluateList" varStatus="idx">
        <tr>
        	<td>${idx.index+1}</td>
        	<td>${ evaluateList.user.userName}</td>
        	<td><fmt:formatDate value="${ evaluateList.evaluateTime}" pattern="yyyy-MM-dd" /></td>
        	<td>${ evaluateList.evaluateDetails}</td>
        	<c:if test="${evaluateList.delFlag == '1' }">
        	<td>δ�ظ�</td>
        	</c:if>
        	<c:if test="${evaluateList.delFlag == '0' }">
        	<td>�ѻظ�</td>
        	</c:if>
        	<c:if test="${evaluateList.delFlag == '0' }">
        	<th>
        	<a href="evaluate/seeReplyEvaluate.do?eid=${evaluateList.id}">�鿴�ظ�����</a>
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
