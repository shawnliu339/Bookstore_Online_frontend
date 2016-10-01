//判断用户的输入是否合法
function check(){
	if (registerform.username.value==""){
		alert("请输入用户名！");
		registerform.username.focus();
		return;
	}
	if (registerform.username.value.length<3){
		alert("用户名长度错误，请重新输入！");
		registerform.username.focus();
		return;
	}
	if (registerform.Password1.value==""){
		alert("请输入密码！");
		registerform.Password1.focus();
		return;
	}
	if (registerform.Password1.value.length<6 || registerform.Password1.value.length>20){
		alert("密码长度错误，请重新输入！");
		registerform.Password1.focus();
		return;
	}
	if (registerform.Password2.value==""){
		alert("请确认密码！");
		registerform.Password2.focus();
		return;
	}
	if (registerform.Password1.value!=registerform.Password2.value){
		alert("您两次输入的密码不一致，请重新输入！");
		registerform.Password1.focus();
		return;
	}
	if (registerform.Nickname.value==""){
		alert("请输入用户昵称！");
		registerform.Nickname.focus();
		return;
	}
	if (registerform.Tel.value==""){
		alert("请输入联系手机！");
		registerform.Tel.focus();
		return;
	}
	if (registerform.Tel.value.length!=11){
		alert("您输入的手机号码长度不正确，请重新输入！");
		registerform.Tel.focus();
		return;
	}
	if (registerform.Email.value==""){
		alert("请输入Email地址！");
		registerform.Email.focus();
		return;
	}
	var i=registerform.Email.value.indexOf("@");
	var j=registerform.Email.value.indexOf(".");
	if((i<0)||(i-j>0)||(j<0)){
		alert("您输入的Email地址不正确，请重新输入！");
		registerform.Email.value="";
		registerform.Email.focus();
		return;
	}
	registerform.submit();		
}
//判断用户的输入是否合法
function check_modify(){
	if (usermodifyform.Nickname.value==""){
		alert("请输入昵称！");
		usermodifyform.Nickname.focus();
		return;
	}
	if (usermodifyform.Password1.value==""){
		alert("请输入原密码！");
		usermodifyform.Password1.focus();
		return;
	}
	if (usermodifyform.Password1.value!=usermodifyform.OldPassword.value){
		alert("您输入的原密码不正确，请重新输入！");
		usermodifyform.Password1.focus();
		return;
	}		
	if(usermodifyform.CardNum.value.length!=18 && usermodifyform.CardNum.value.length!=15 && usermodifyform.CardNum.value!=""){
		alert("请输入正确的证件号码！");
		usermodifyform.CardNum.focus();
		return;
	}
	usermodifyform.submit();		
}

//订单生成检查
function checkOrder(orderForm){
  if(orderForm.truename.value==""){
    alert("请输入您的真实姓名!");orderForm.truename.focus();return; 
  }
  if(orderForm.address.value==""){
    alert("请输入您的联系地址!");orderForm.address.focus();return;  
  } 
  if(orderForm.postcode.value==""){
    alert("请输入您的邮政编码!");orderForm.postcode.focus();return; 
  } 
  if(orderForm.tel.value==""){
    alert("请输入您的联系电话!");orderForm.tel.focus();return;  
  }
  if(orderForm.email.value==""){
    alert("请输入您的Email地址!");orderForm.email.focus();return; 
  }
  var i=orderForm.email.value.indexOf("@");
  var j=orderForm.email.value.indexOf(".");
  if((i<0)||(i-j>0)||(j<0)){
    alert("您输入的Email地址不正确，请重新输入！");orderForm.email.value="";orderForm.email.focus();return;
  }
  orderForm.submit();
}

