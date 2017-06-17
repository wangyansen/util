/**
 * Created with jing.zhao2013
 * Date: 13-7-30
 * Time: ����4:03
 */
//cookie��ز���������Ҫdom������ɺ����У���˵���д
function setCookie(name,value){
    if(!name||!value) return;
    var Days = 30;//Ĭ��30��
    var exp  = new Date();
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ encodeURIComponent(value) +";expires="+ exp.toUTCString();
}
function getCookie(name){
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
    if(arr != null) return decodeURIComponent(arr[2]);
    return null;
}
function delCookie(name){
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(!cval) document.cookie=name +"="+cval+";expires="+exp.toUTCString();
}
//gobuy
function inArray(array, str){
    for(a in array) {
        if(array[a] == str) return true;
    }
    return false;
}
function goBuy(id, price){
    var newCookie = "";
    var oldCookie = getCookie("product");
    if(oldCookie) {
        if(inArray(oldCookie.split(","), id)) {
            newCookie = oldCookie;
        } else {
            newCookie = id + "," + oldCookie;
        }
    } else {
        newCookie = id;
    }
    setCookie("product", newCookie);
    location.href = "Cart?action=add&entityId="+id;
}
function goBuy2(id){
    var newCookie = "";
    var oldCookie = getCookie("product");
    if(oldCookie) {
        if(inArray(oldCookie.split(","), id)) {
            newCookie = oldCookie;
        } else {
            newCookie = id + "," + oldCookie;
        }
    } else {
        newCookie = id;
    }
    setCookie("product", newCookie);
    location.href = "Cart?action=addBuy&entityId="+id;
}
//dom�����������
$(function(){
    //��ȡ���㷽��
    function focusItem(dom){
        $(dom).parent().parent().addClass("current");
        var eBox=$(dom).parent().find("span");
        eBox.removeClass("error").text("");
    }
    //ʧȥ������������������֤��Ϣ����
    function checkItem(dom){
        $(dom).parent().parent().removeClass("current");
        var eBox=$(dom).parent().find("span");
        var name = $(dom).attr("name");
        var value = $(dom).val();
        var errorMessage="",isError=true;
        switch(name){
            case "userId":
                if(value == "") {
                    errorMessage = "�û�������Ϊ��";
                }else if(!/[a-zA-Z0-9]+/.test(value)){
                    errorMessage = "�û���ֻ����Ӣ����ĸ��������";
                }else{
                    isError = false ;
                }
                break;
            case "userName":
                if(value == "") {
                    errorMessage = "��ʵ��������Ϊ��";
                }else if(value.length>10){
                    errorMessage = "��ʵ���������10������";
                }else{
                    isError = false ;
                }
                break;
            case "oldpassword":
                if(value == "") {
                    errorMessage = "�����벻��Ϊ��";
                }else{
                    isError = false ;
                }
                break;    
            case "password":
                if(value == "") {
                    errorMessage = "���벻��Ϊ��";
                }else{
                    isError = false ;
                }
                break;
            case "confirmPassword":
                if(value == "") {
                    errorMessage = "ȷ�����벻��Ϊ��";
                    break;
                } else if(value != $("#password").val()) {
                    errorMessage = "������������벻��ͬ";
                    break;
                }else{
                    isError = false ;
                    break;
                }
                break;
            case "address":
                if(value == "") {
                    errorMessage = "��ַ����Ϊ��";
                }else{
                    isError = false ;
                }
                break;
            case "birthday":
                if((value != "") && !/\d{4}[-]\d{1,2}[-]\d{1,2}/.test(value)) {
                    errorMessage = "�������ڸ�ʽֻ����yyyy-mm-dd";
                }else{
                    isError = false ;
                }
                break;
            case "identityCode":
                if((value != "") && !/((\d{17}\w{1})|(\d{15}))/.test(value)) {
                    errorMessage = "���֤�����ʽ����ȷ";
                }else{
                    isError = false ;
                }
                break;
            case "email":
                if((value != "") && !/^[a-z0-9]+\@([a-z0-9]+\.)+[a-z0-9]{2,4}$/i.test(value)) {
                    errorMessage = "�ʼ���ַ��ʽ����ȷ";
                }else{
                    isError = false ;
                }
                break;
            case "mobile":
                if((value == "") || !/\d{11}/.test(value)) {
                    errorMessage = "�ֻ������ʽ����ȷ";
                }else{
                    isError = false ;
                }
                break;
            case "productName":
                if(value == "") {
                    errorMessage = "���Ʋ���Ϊ��";
                }else{
                    isError = false ;
                }
                break;
            case "productPrice":
                if((value == "")||!(/^\d+(\.\d+)?$/.test(value))) {
                    errorMessage = "����Ϊ����ֻ��Ϊ����";
                }else{
                    isError = false ;
                }
                break;
            case "productNumber":
                if((value == "")||!(/^[0-9]*[1-9][0-9]*$/.test(value))) {
                    errorMessage = "����Ϊ����ֻ��Ϊ������";
                }else{
                    isError = false ;
                }
                break;
            case "photo":
                if(value == "") {
                    errorMessage = "����Ϊ��";
                }else{
                    isError = false ;
                }
                break;
            case "content":
                if(value == "") {
                    errorMessage = "����Ϊ��";
                }else if(value.length>500){
                    errorMessage = "�������ܴ���500";
                }else{
                    isError = false ;
                }
                break;
            case "title":
                if(value == "") {
                    errorMessage = "����Ϊ��";
                }else if(value.length>20){
                    errorMessage = "�������ܴ���20";
                }else{
                    isError = false ;
                }
                break;
            default:
                isError = false ;
                break;
        }
        if(isError){
            eBox.text(errorMessage);
            eBox.addClass("error");
            return false;
        }
        return true;
    }
    //�ύ������
    function checkForm(){
        var flag=true;
        $(this).find("input[class='text']").each(function(i,dom){
            if(!checkItem($(dom))) flag = false;
        })
        if(!checkItem($(this).find("input[name='productPrice']"))) flag = false;
        if(!checkItem($(this).find("input[name='productNumber']"))) flag = false;
        return flag;
    }
    //�����Ʒ
    $("#productAdd").find("input[class!='submit']").bind({
        focus:function(){focusItem(this)},
        blur:function(){checkItem(this)}
    });
    $("#productAdd").submit(checkForm);
    //���������֤
    $("#newsAdd").find("[class='text']").bind({
        focus:function(){focusItem(this)},
        blur:function(){checkItem(this)}
    });
    $("#newsAdd").submit(function(){
        var $self = $(this);
        var $title = $self.find("[name=title]");
        var $content = $self.find("textarea");
        if($title.val().length>20){
            $title.next("span").addClass("error").html("���ö���20��");
        }
        if($content.val().length>500){
            $content.next("span").addClass("error").html("���ö���500��");
        }
        if($title.val().length<=20&&$title.text().length<=500){
            return true;
        }
        return false;
    });
    //dom���þ۽���ʧ���¼�
    $("#userId").bind({
        focus:function(){focusItem(this)},
        blur:function(){checkItem(this)}
    });
    $("#password").bind({
        focus:function(){focusItem(this)},
        blur:function(){checkItem(this)}
    });
    //����
    $("#birthday").click(function(){
        WdatePicker({
            highLineWeekDay:true //��ĩ����
            ,readOnly:true      //ֻ����ֻ���ÿؼ�input�� �޸�����
            ,dateFmt:'yyyy-MM-dd'
        });
    });
    //�������֤��
    $("#changeCode").click(function(){
        $("#safeCode").attr("src","Number.jsp?id="+Math.random());
    });
    //ע��ҳ����֤
    $("#regForm").find("input[class='text']").bind({
        focus:function(){focusItem(this)},
        blur:function(){checkItem(this)}
    })
    //���ύ�¼�
    $("#loginForm").submit(checkForm);
    $("#regForm").submit(checkForm);
    //����µ�ַ�¼�
    $("#addr").click(function(){
        var val = $(this).val()
        if(val=="���"){
//            location.href = "Cart?action=addAddress&address="+$("#addAddr").val();
            var addr = $("#addAddr").val();
            if(addr==""){
                alert("��ַ����Ϊ��");
                return;
            }
            var reg=new RegExp(/;|��/gi);
            if(reg.test(addr)){
                alert("��ַ�����зֺ�");
                return;
            }
            var flag=true;
            $(this).parent().find("input[name='address']").each(function(i,d){
                if($(d).next().text()==addr){
                    flag=false;
                }
            })
            if(!flag){
                alert("��ַ������ͬ");
                return;
            }
            $("#span").append('<br/><input name="address" type="radio" id="address0"/><span>'+addr+'</span>');
        }else{
            var span=$("#span").html('<input type="text" name="addAddr" id="addAddr"/>');
            $(this).val("���");
        }
    });
    //ɾ����Ʒ
    $(".delete").find("a").click(function(){
        var tr = $(this).parent().parent();
        if(confirm("ȷ��Ҫɾ����")) {
            var oldCookie = getCookie("product");
            if(oldCookie) {
                var oldCookieArr = oldCookie.split(",");
                var newCookieArr = new Array();
                for(c in oldCookieArr) {
                    var cookie = parseInt(oldCookieArr[c]);
                    if(cookie != id) newCookieArr.push(cookie);
                }
                var newCookie = newCookieArr.join(",");
                setCookie("product", newCookie);
            }
            if(tr) tr.remove();
            location.herf="";
        }else{
            return false;
        }
    });
    //��̨ɾ��
    $(".manageDel").click(function(){
        var $tr = $(this).parent().parent();
        if(confirm("ȷ��Ҫɾ����")) {
            if($tr) $tr.remove();
            location.herf="";
        }else{
            return false;
        }
    })
    //�޸�
    $(".number").find("span").click(function(){
        var $tds=$(this).parent().parent().children("td");
        var $price= $($tds[1]);
        var $number=$($tds[2]);
        var price = $price.find("input[type='hidden']").val();//��ֵ
        var $priceBox =$price.find("span");//��ʵ��Ǯ
        var $number= $number.find("input");//�õ��洢input����
        var opr=$(this).attr("name");//�ж�����
        var number = $number.val();//����
        if(opr=="del"){
            number--;
            if(number<=0){
                if(confirm("ȷ��Ҫɾ����")) {
                    $price.parent().remove();
                }else{
                    number=1;
                }
            }
        }else if(opr=="add"){
            number++;
        }
        $number.val(number);
        $priceBox.text("��" + price * number);
        $("#shopping").find("#total").text("�ܼƣ���"+totalPrice());
    });
    //�����ܼ�
    function totalPrice(){
        var totalPrice=0;
        $("#shopping").find(".price").find("input[type='hidden']").each(function(i,d){
            var p= parseFloat($(d).val());
            var n = $(d).parent().parent().find("input[name='number']").val();
            totalPrice=totalPrice+p*n;
        });
        return totalPrice;
    }
    $("#shopping").find("input[name='number']").change(function(){
        var v=$(this).val();
        if(!(/^[0-9]*[1-9][0-9]*$/.test(v))){
            alert("������������");
            $(this).val(1);
        }
        var $price=$($(this).parent().parent().children("td")[1]);
        var p = $price.find("input").val();
        $price.find("span").text(p*$(this).val());
        $("#shopping").find("#total").text("�ܼƣ���"+totalPrice());
    });
    $("#shopping").find("#total").text("�ܼƣ���"+totalPrice());
    //ע��
    $("#logout").click(function(){
        if(confirm("���ﳵ������δ�������Ʒ���Ƿ���ˣ�")) {
            location.href="shopping.html";
        }else{
            location.href="index.html";
            return false;
        }
    });
    //�ֻ����
    var index=0;
    setInterval(function(){
        index++;
        var $li=$("#slideBox").children("li");
        if(index>=$li.length){
            index=0;
        }
        $li.eq(index).stop(true,true).fadeIn().siblings().fadeOut();
    },3000);
    //��ӭͼƬ
    if(document.referrer==""){
    	$("#welcomeImage").slideDown(4000).delay(1000).slideUp(4000);
    }
    //��������֤��ֻ��Ϊ����
    $("#orderForm").submit(function(){
       var flag = !isNaN($("#entityId").val());
       if(!flag){
           alert("ֻ�������֣�");
       }
        return flag;
    });
    //���ִ�ͼ��
    $("#product .thumb img").mouseover(function(){
        var src= $(this).attr("src").split("/");
        var name=src[src.length-1].split(".")[0];
        $("#product").append('<img id="bigImg" src="images/product/'+name+'_big.jpg"/>');
        $("#bigImg").show().error(function(){
            $(this).remove();
        });
    }).mouseleave(function(){
        $("#bigImg").hide();
    })
    //��Ʒ����,Ĭ�ϵ�һ��չ��
    $($("#main .box dl dt")[0]).nextUntil('dt').show();
    $("#main .box dl dt").click(function(){
        $(this).nextUntil('dt').toggle();
    });
    //���ﳵ
    $("#shoppingBag").mouseover(function(){
        var o = $(this).offset();
        var $table=$('<table id="floatBag" border="1" style="left:'+ o.left+'px;top:'+ (o.top+20)+'px;"></table>');
        $("#header").append($table);
        var html=[
            "<tr><th>ͼ��</th><th>����</th><th>�۸�</th></tr>",
            "<tr><td>ͼ��</td><td>VVVVV</td><td>99</td></tr>"
        ]
        $table.html(html.join(""));
        $("#floatBag").show();
    }).mouseleave(function(){
        $("#floatBag").hide();
    });
    //��֤����
    $("#guestBook").submit(function(){
        if($(this).find("textarea").val().length<=100){
            return true;
        }
        $(this).find("span").addClass("error").html("���Բ��ö���100��");
        return false;
    });
})