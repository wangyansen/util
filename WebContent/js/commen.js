var contextPath='/'+window.location.pathname.split('/')[1];

var dengluclickcheck =function(){
var	userword=$("#userId").val();
var	password=$("#userPw").val();
	if(userword==""){
		alert("�˺Ų���Ϊ�գ�");
		return false;
	}
	if(password==""){
		alert("���벻��Ϊ�գ�");
		return false;
	}
	var reg = /^[a-zA-Z0-9]*$/;
	if(reg.test(userword) != true){
		alert("�����˺Ÿ�ʽ����ȷ��");
	}
	if(reg.test(password) != true){
		alert("���������ʽ����ȷ��");
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
			alert("��������˺����벻��ȷ��");
		}
		if(data=="11"){
			//�˺�Ϊҽ��������ת��ҽ���˵��б�
			window.location=contextPath+"/empMain/empMenuList.do";
		}
		if(data=="22"){
			//�˺�Ϊ�����ߣ�����ת���������ڵ��б�
			window.location=contextPath+"/empMain/customerMenuList.do";
		}
	});
};

function changePassword(){
	$.post(contextPath+"/welcome/changePasswordTwo.do",{loginKey:$("#userId").val(),
		password:$("#oldpassword").val(),newPassword:$("#password").val()},
		function(data){
			if(data=="00"){
				alert("��������˺����벻��ȷ��");
			}
			if(data=="11"){
				//�˺�������ȷ�������޸�Action,�����ݿ���������ɹ�ҳ��
				window.location=contextPath+"/welcome/changePasswordThree.do";
			}
			
	});
	
}
function agreeOrder(orderId){
	$.post(contextPath+"/order/agreeOrder.do",{id:orderId},
			function(data){
		if(data=="00"){
			alert("���Ѿ�ͬ���ԤԼ���������Ѱ��źõ�ԤԼ��¼�в鿴��");
			window.location=contextPath+"/order/myNewOrderList.do";
		}
	});
}
function deleteThisOrder(orderId){
	$.post(contextPath+"/order/deleteThisOrder.do",{id:orderId},
			function(data){
		if(data=="00"){
			alert("�Ѿ��ɹ�ɾ�������¼����");
			window.location=contextPath+"/order/cusOrderList.do";
		}
	});
}




