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
    	<li><a href="##">我的预约记录</a></li>
        <li>新增</li>
    </ul>
</div>

<form action="<%=basePath%>order/orderAddTwo.do" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">本人姓名</label>
                <div class="col-sm-9">
               			<input type="text"  class="form-control input-sm" value="${userName}" readonly="readonly" name="" />
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">要预约的医师姓名</label>
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
            	<label class="col-sm-3 control-label">要预约的时间</label>
                <div class="col-sm-9">
               			<input type="date" name="orderTime" class="form-control input-sm" placeholder="请输入沟通时间"/>
                </div>
            </div>
        </div>
    </div>


 
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">备注内容</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="remark"></textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>

              <a class="btn btn-warning" href="<%=basePath%>chufang/chufangList.do">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
