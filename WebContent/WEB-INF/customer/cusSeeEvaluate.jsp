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
    	<li><a href="">�ҵ����ۼ�¼</a></li>
        <li>�鿴�ظ�</li>
    </ul>
</div>


    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">������Ϣ</h5>
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">�ظ���</label>
                <div class="col-sm-9">
               			<input type="text"  class="form-control input-sm" value="${replyList.user.userName}" readonly="readonly"  />
                </div>
            </div>
        </div>
    </div>
	   <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">�ظ�ʱ��</label>
                <div class="col-sm-9">
               			<input type="text"  class="form-control input-sm" value="<fmt:formatDate value="${replyList.time }" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
                </div>
            </div>
        </div>
    </div>

 
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">�ظ�����</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">�ظ�����</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="remark" readonly="readonly">${replyList.content}</textarea>
                </div>
            </div>
        
        </div>
      
    </div>
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
              <a class="btn btn-warning" href="<%=basePath%>evaluate/cusEvaluateList.do">������һ��</a>
        </div>
    </div>

</body>
</html>
