<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
        <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>ע��ɹ���</title>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/function.js"></script>
</head>
<body>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>��ӭע�Ứ԰��ǻ����ҽԺ</h1>
			<ul class="steps clearfix">
				<li class="finished"><em></em>��дע����Ϣ</li>
				<li class="last-current"><em></em>ע��ɹ�</li>
			</ul>
			<div class="msg">
				<p>��ϲ��ע��ɹ���</p>
				<p>���ڽ�����ҳ...</p>
				<script type="text/javascript">
					setTimeout("location.href='/wys_zzuli_graduate_design/welcome/login.do'", 3000);
				</script>
			</div>
		</div>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2016 ����ɭ All Rights Reserved. 
</div>

</body>
</html>