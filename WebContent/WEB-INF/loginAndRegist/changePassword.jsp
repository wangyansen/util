<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="gbk"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<base href="<%=basePath%>">
<title>�û�ע��</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/commen.js"></script>
<script type="text/javascript" src="js/function.js"></script>
<script type="text/javascript">
function  as(){
	$(".background").height($(window).height());
}
</script>
<style type="text/css">
.background {background:rgba(0,0,0,0);background:url(img/101.png) center center no-repeat;width:100%;background-size:100% 100%;}
</style>
</head>
<body class="background">
<div id="register" class="wrap">
<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
<div class="box">
			<h1>�˻������޸�</h1>
			<ul class="steps clearfix">
				<li class="current"><em></em>��д�޸���Ϣ</li>
				<li class="last"><em></em>�޸ĳɹ�</li>
			</ul>
			<form id="regForm" method="post" action="" >
				<table>
					<tr>
						<td class="field">�û���(*)��</td>
						<td>
							<input class="text" type="text" name="userId"  id="userId" maxlength="10"  />
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="field">������(*)��</td>
						<td><input class="text" type="oldpassword" id="oldpassword" name="oldpassword" /><span></span></td>
					</tr>
					<tr>
						<td class="field">������(*)��</td>
						<td><input class="text" type="password" id="password" name="password" /><span></span></td>
					</tr>
					<tr>
						<td class="field">ȷ������(*)��</td>
						<td><input class="text" type="password" name="confirmPassword" /><span></span></td>
					</tr>
					<tr>
						<td><label class="ui-green"><input type="button" name="submit" id="changeSub" value="�ύ" /></label></td>
					</tr>
				</table>
			</form>
		</div>
</div>
</div>
<div><img  src="img/103.jpg"> </div>
<div id="footer">
	Copyright &copy; 2016 ����ɭ All Rights Reserved. 
</div>

</body>
</html>