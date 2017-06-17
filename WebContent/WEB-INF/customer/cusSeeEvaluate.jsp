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
    	<li><a href="">我的评论记录</a></li>
        <li>查看回复</li>
    </ul>
</div>


    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">回复者</label>
                <div class="col-sm-9">
               			<input type="text"  class="form-control input-sm" value="${replyList.user.userName}" readonly="readonly"  />
                </div>
            </div>
        </div>
    </div>
	   <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">回复时间</label>
                <div class="col-sm-9">
               			<input type="text"  class="form-control input-sm" value="<fmt:formatDate value="${replyList.time }" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
                </div>
            </div>
        </div>
    </div>

 
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">回复内容</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">回复内容</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="remark" readonly="readonly">${replyList.content}</textarea>
                </div>
            </div>
        
        </div>
      
    </div>
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
              <a class="btn btn-warning" href="<%=basePath%>evaluate/cusEvaluateList.do">返回上一级</a>
        </div>
    </div>

</body>
</html>
