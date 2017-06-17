var contextPath='/'+window.location.pathname.split('/')[1];

var dengluclickcheck =function(){
var	userword=$("#userId").val();
var	password=$("#userPw").val();
	if(userword==""){
		alert("账号不能为空！");
		return false;
	}
	if(password==""){
		alert("密码不能为空！");
		return false;
	}
	var reg = /^[a-zA-Z0-9]*$/;
	if(reg.test(userword) != true){
		alert("输入账号格式不正确！");
	}
	if(reg.test(password) != true){
		alert("输入密码格式不正确！");
	}
};
$(document).ready(function(){
	$("#denglu").click(dengluclickcheck);
	$("#zhuce").click(zhuce);
	$("#xiugaimima").click(xiugaimima);
	$("#denglu").click(denglu);
	$("#changeSub").click(changePassword);
});

function zhuce(){
	window.location=contextPath+"/welcome/regist.do";
}
function xiugaimima(){
	window.location=contextPath+"/welcome/changePasswordOne.do";
}
function denglu(){
	$.post(contextPath+"/welcome/dengluAjax.do",{loginKey:$("#userId").val(),password:$("#userPw").val()},
	function(data){
		if(data=="0"){
			alert("您输入的账号密码不正确！");
		}
		if(data=="11"){
			//账号为医生，则跳转到医生菜单列表
			window.location=contextPath+"/empMain/empMenuList.do";
		}
		if(data=="22"){
			//账号为消费者，则跳转到消费者在旦列表
			window.location=contextPath+"/empMain/customerMenuList.do";
		}
	});
};

function changePassword(){
	$.post(contextPath+"/welcome/changePasswordTwo.do",{loginKey:$("#userId").val(),
		password:$("#oldpassword").val(),newPassword:$("#password").val()},
		function(data){
			if(data=="00"){
				alert("您输入的账号密码不正确！");
			}
			if(data=="11"){
				//账号密码正确，进入修改Action,做数据库操作，跳成功页面
				window.location=contextPath+"/welcome/changePasswordThree.do";
			}
			
	});
	
}
function agreeOrder(orderId){
	$.post(contextPath+"/order/agreeOrder.do",{id:orderId},
			function(data){
		if(data=="00"){
			alert("您已经同意此预约！可以在已安排好的预约记录中查看！");
			window.location=contextPath+"/order/myNewOrderList.do";
		}
	});
}
function deleteThisOrder(orderId){
	$.post(contextPath+"/order/deleteThisOrder.do",{id:orderId},
			function(data){
		if(data=="00"){
			alert("已经成功删除此项记录！！");
			window.location=contextPath+"/order/cusOrderList.do";
		}
	});
}




