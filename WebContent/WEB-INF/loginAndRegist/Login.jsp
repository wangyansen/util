<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<title>wys毕业设计</title>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
<script  type="text/javascript" src="assets/jquery.min.js"></script>

<script type="text/javascript">
function  as(){
	$(".login-layout").height($(window).height());
}
</script>
<style type="text/css">
.login-layout{background:rgba(0,0,0,0);background:url(img/0002.png) center center no-repeat;width:100%;background-size:100% 100%;}
.login-container{width:1200px;}
.position-relative {
    position: absolute;
    width: 375px;
    left: 65%;
    top: 300px;
}
.login-container .center{padding-top:25px;}
.center  .red{font-size: 90px;font-weight: bold;}
#xiugaimima{ 
    position: absolute;
    top: 196px;
    margin-left: 140px;   
}
#denglu{
	position: absolute;
    margin-left: 229px;
}
#tubiao01{
    position: absolute;
    top: 1px;
    margin-left: -500px;
}
.footer_copyright{
	background-color: #d0a24c;
	position: absolute;
    top: 850px;
    width: 100%;
    height: 60px; 
	
}
</style>
</head>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i ><img id="tubiao01" src="img/0009.png"> </i> <span class="red">花园牙科欢迎您！</span><span
									class="white"></span>
							</h1>
						</div>
						<div class="space-6"></div>
						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border" >
								<div class="widget-body">
									<div class="widget-main" >
										<h4 class="header blue lighter bigger">
											<i><img  src="img/0003.png"> </i> 请输入您的账号和密码
										</h4>

										<div class="space-6"></div>
										<form action="" method="post">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="userId"
														name="loginKey" type="text" class="form-control"
														placeholder="请输入账号" /> <i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="userPw"
														name="password" type="password" class="form-control"
														placeholder="请输入密码" /> <i class="icon-lock"></i>
												</span>
												</label>

												<div class="clearfix">
													<button type="button" id="denglu">
														<i class="icon-key"></i> 登陆
													</button>
												</div>
													<div class="clearfix" >
													<button type="button"  id="zhuce">
														<i class="icon-key"></i> 注册
													</button>
												</div>
												</div>
													<div class="clearfix" >
													<button type="button"  id="xiugaimima">
														<i class="icon-key"></i> 修改密码
													</button>
												</div>
											</fieldset>
										</form>

									</div>

								</div>

							</div>
					</div>
					  <div class="footer_copyright"><p style="float: right; font-size: 16px;"> Copyright 王彦森毕业设计     2016-02-26</p></div>
</div>
				</div>
			</div>

		</div>
</div>
	</div>
</body>
<script type="text/javascript" src="js/commen.js" ></script>
</html>