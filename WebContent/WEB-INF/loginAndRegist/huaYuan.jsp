<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<title>wys��ҵ���</title>
<!-- �� Bootstrap ���� CSS �ļ� -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jQuery�ļ��������bootstrap.min.js ֮ǰ���� -->
<script src="js/jquery.min.js"></script>
<!-- ���µ� Bootstrap ���� JavaScript �ļ� -->
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
<!--���ù���-->
<!--�˴�Ϊ���õ������-->
var i=1;
$(function(){
$("#a").click(function(){
	$("#i1").attr("src","img/i"+i+".png");
	i++;
	if(i>3){i=1};
	});
<!--�˴�Ϊ����ÿ1���Զ�����-->	
var time=setInterval("wang()",1000);
$("#i1").mouseover(function(){
	clearInterval(time);
	}).mouseout(function(){
		time=setInterval("wang()",1000);
		});
		
$("#haha").click(function(){
	var contextPath='/'+window.location.pathname.split('/')[1];
	window.location=contextPath+"/welcome/realLogin.do";
})		
		
});
<!--�����Զ������ķ���-->	
function wang(){
	console.debug("asdasdasd");
	$("#i1").attr("src","img/i"+i+".png");
	i++;
	if(i>3){i=1};
}
</script>
</head>
<body>
<div > 
<div class="onerow" id="001" style="background-color: #005aab">
<p style="font-size:40px;margin-left: 100px ">��ӭ��������԰��ǻ����ҽԺ</p> <input type="button"  class="btn btn-danger"  value="�û���¼" style="margin-left: 1500px" id="haha"/>
</div>
</div>
  <!-- 3 -->
   <div >
   <img src="img/j7.png" style="margin-left: 380px">
   </div>
<!-- �ֲ�BANNER -->
  <div  style="margin-left: 440px;height: 390px" id="a">
   <img id="i1" src="img/i3.png" />
   <img id="i2" src="img/i2.png" style="display: none;"/>
   <img  id="i3" src="img/i1.png" style="display: none;"/>
   </div> 
   <div style="">
   <img  src="img/j12.png" style="margin-left: 380px">
   </div>
   <div>
   <img  src="img/j9.png" style="margin-left: 380px">
   </div>
   <div>
   <img  src="img/j10.png" style="margin-left: 380px">
   </div>
 	<div>
   <img  src="img/j13.png" style="margin-left: 380px">
   </div>
   <div>
   <img  src="img/j8.png" style="margin-left: 380px">
   </div>
   <div style="background-color: #005aab;position:absolute; width: 1900px" ><p style="float: right; font-size: 30px;"> Copyright ����ɭ��ҵ���     2016-02-26</p></div>
</body>
</html>