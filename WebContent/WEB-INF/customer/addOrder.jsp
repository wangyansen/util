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
    	<li><a href="##">�ҵ�ԤԼ��¼</a></li>
        <li>����</li>
    </ul>
</div>

<form action="<%=basePath%>order/orderAddTwo.do" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">������Ϣ</h5>
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">��������</label>
                <div class="col-sm-9">
               			<input type="text"  class="form-control input-sm" value="${userName}" readonly="readonly" name="" />
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">ҪԤԼ��ҽʦ����</label>
                <div class="col-sm-9">
               		<select name="doctorId" class="form-control input-sm">
                    	<c:forEach items="${doctorList}" var="doctorList">
                    		<option value="${doctorList.id }">${doctorList.userName }</option>
                		</c:forEach>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">ҪԤԼ��ʱ��</label>
                <div class="col-sm-9">
               			<input type="date" name="orderTime" class="form-control input-sm" placeholder="�����빵ͨʱ��"/>
                </div>
            </div>
        </div>
    </div>


 
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">��ע</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">��ע����</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="remark"></textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="����"/>

              <a class="btn btn-warning" href="<%=basePath%>chufang/chufangList.do">������һ��</a>
        </div>
    </div>
</form>

</body>
</html>
