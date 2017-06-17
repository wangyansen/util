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
    	<li><a href="chufang/chufangList.do">我的历史处方</a></li>
        <li>修改</li>
    </ul>
</div>

<form action="<%=basePath%>chufang/chufangUpdateTwo.do" method="post" class="form-horizontal">
<input type="hidden" name="id" value="${chufang.id}">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">主治医师</label>
                <div class="col-sm-9">
               			<input type="text"  class="form-control input-sm" value="${chufang.doctorName}" readonly="readonly" name="doctorName" />
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">患者姓名</label>
                <div class="col-sm-9">
               			<input type="text"  class="form-control input-sm" name="sickerName" value="${chufang.sickerName}"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">患者患病的学名</label>
                <div class="col-sm-9">
               			<input type="text"  class="form-control input-sm" name="sickName"value="${chufang.sickName}"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">总价</label>
                <div class="col-sm-9">
               			<input type="text"  class="form-control input-sm" name="price" value="${chufang.price}"/>
                </div>
            </div>
        </div>
    </div>
	<div class="row">
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">所用药品</label>
                <div class="col-sm-9">
                	<select name="drugId" class="form-control input-sm">
                    	<c:forEach items="${drugList}" var="drugList">
                    		<option ${drugList.id==chufang.drugId? "selected": "" } value="${drugList.id }">${drugList.drugName }</option>
                		</c:forEach>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">所用医疗器械</label>
                <div class="col-sm-9">
                	<select name="medicalApplianceId" class="form-control input-sm">
                    	<c:forEach items="${medicalApplianceList}" var="medicalApplianceList">
                    		<option ${medicalApplianceList.id==chufang.medicalApplianceId? "selected": "" } value="${medicalApplianceList.id }">${medicalApplianceList.medicalApplianceName }</option>
                		</c:forEach>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">看病时间</label>
                <div class="col-sm-9">
               			<input type="text" name="openTime" class="form-control input-sm" value="<fmt:formatDate value='${chufang.openTime }' pattern='yyyy-MM-dd'/>"/>
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
                	<textarea class="form-control" name="remark">${chufang.remark}</textarea>
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
