<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js"></script> 				
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<title>user registration form </title>
<style>
*{
	margin:0px;
	padding:0px;
	}
	
body{
	font-family:Tahoma, Geneva, sans-serif;
	}
	
#container{
/*	width:90%;
	background-color:rgba(250,250,252,.9);
	margin:auto;
	margin-top:10px;
	margin-bottom:10px;
	box-shadow:0 0 3px #999;*/
	}
#container_body{
	background-color:rgba(250,250,252,.9);
	width:60%;
	padding:20px;
	}
.form_title{
	font-size:35px;
	color:#141823;
	text-align:center;
	padding:10px;
	font-weight:normal;
	}
.head_para{
	font-size:19px;
	color:#99a2a7;
	text-align:center;
	font-weight:normal;
	}
#form_name{
	padding:25px 0 0 15px;
	}
.firstnameorlastname{
	 margin-right:20px;
	}
.input_name{
	width:207px;
	padding:5px;
	font-size:18px;
	}
#email_form{
	clear:both;
	padding:15px 0 10px 0px;
	}
#username{
	clear:both;
	padding:15px 0 10px 0px;
	}
.username{
	width:434px;
	padding:5px;
	font-size:18px;
	}
.input_email{
	width:434px;
	padding:5px;
	font-size:18px;
	}
#Re_enter_password{
	padding:10px 0 10px 0px;
	}
.input_Re_pass{
	width:434px;
	padding:5px;
	font-size:18px;
	}
#password_form{
	padding:10px 0 10px 0px;
	}
.input_password{
	width:434px;
	padding:5px;
	font-size:18px;
	}
.birthday_title{
	font-size:16px; 
	color:#8b919d; 
	font-weight:normal;
	padding:0 0 10px 0;
	}
select{
	padding:5px;
	}
#birthday{
	font-size:12px;
	color:#8b919d;
	padding-top:10px;
	}
#radio_button{
	padding:10px 0 0 0;
	}
#sign_user{
width:200px;
	font-size:14px;
	color:#FFF;
	text-align:center;
	background-color:#3B5998;
	padding:10px;
	margin-top:10px;
	cursor: pointer;
	}
#errorBox{
	color:#F00;
	}



</style>
<script>
function submit(){
	var regexp = /^[A-Za-z0-9_-]{1,20}$/; 
	var emailRegex = /^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,5}$/;
	var fname=document.forms["my_form"].Name.value;
	//var fname = document.form.Name.value,
	var	lname = document.forms["my_form"].LastName.value;
	var user = document.forms["my_form"].User.value;
	var	femail = document.forms["my_form"].Email.value;
//	var	freemail = document.forms["my_form"].enterEmail.value;
	var	fpassword = document.forms["my_form"].Password.value;
	var	refpassword = document.forms["my_form"].rePassword.value;
//	var	fmonth = document.forms["my_form"].birthday_month.value;
////	var	fday = document.forms["my_form"].birthday_day.value;
//	var	fyear = document.forms["my_form"].birthday_year.value;
		
	//alert (fname);
	if( fname == "" )
   {
     document.form.Name.focus() ;
	 document.getElementById("errorBox").innerHTML = "Enter the first name";
     return false;
   }
	if( lname == "" )
   {
     document.form.LastName.focus() ;
	  document.getElementById("errorBox").innerHTML = "Enter the last name";
     return false;
   }
	if(user.length <5)
	 {
		 document.form.User.focus();
		 document.getElementById("errorBox").innerHTML = "Username length must be bigger or equal to 5 and smaller or equal to 16";
		 return false;
	 }
	else if(!regexp.test(user)){
		document.form.User.focus();
		document.getElementById("errorBox").innerHTML = "Enter the valid username";
		return false;
	 }
   if (femail == "" )
	{
		document.form.Email.focus();
		document.getElementById("errorBox").innerHTML = "Enter the email";
		return false;
	 }else if(!emailRegex.test(femail)){
		document.form.Email.focus();
		document.getElementById("errorBox").innerHTML = "Enter the valid email";
		return false;
	 }
	 
	  /*if (freemail == "" )
	{
		document.form.enterEmail.focus();
		document.getElementById("errorBox").innerHTML = "Re-enter the email";
		return false;
	 }else if(!emailRegex.test(freemail)){
		document.form.enterEmail.focus();
		document.getElementById("errorBox").innerHTML = "Re-enter the valid email";
		return false;
	 }
	 
	 if(freemail !=  femail){
		 document.form.enterEmail.focus();
		 document.getElementById("errorBox").innerHTML = "emails are not matching, re-enter again";
		 return false;
		 }*/
	
	 
	if(fpassword.length <6)
	 {
		 document.form.Password.focus();
		 document.getElementById("errorBox").innerHTML = "Password length must be bigger or equal to 6 and smaller or equal to 16";
		 return false;
	 }
	 
		 if(refpassword == "")
		 {
			 document.form.Password.focus();
			 document.getElementById("errorBox").innerHTML = "Enter the password";
			 return false;
		 }	
		 
		 if(fpassword!=refpassword){
			 document.form.Password.focus();
			 document.getElementById("errorBox").innerHTML = "ReEntered password is wrong";
			 return false;
		 }
		/*
		if(fname != '' && lname != '' && femail != '' && freemail != '' && fpassword != '' && fmonth != '' && fday != '' && fyear != ''){
			document.getElementById("errorBox").innerHTML = "Form submitted successfully";
			}*/
		
		 // return true;
	document.forms["my_form"].submit();

}


</script>
</head>

<body>

<div id="description"></div>
<!--container start-->
<div id="container">
  <div id="container_body">
    <div>
      <h2 class="form_title">User Registration Form </h2>
    </div>
    <!--Form  start-->
     <form  method="post" name="form" action="/dms/public/registration" id="my_form" >
    <div id="form_name">
      <div class="firstnameorlastname">
      
       <div id="errorBox"></div><br>
        <input type="text" name="Name" id="Name" value="" placeholder="First Name"  class="input_name" >
        <input type="text" name="LastName" value="" placeholder="Last Name" class="input_name" >
        
      </div>
      <div id="username">
        <input type="text" name="User" value=""  placeholder="Your Username" class="username">
      </div>
      <div id="email_form">
        <input type="text" name="Email" value=""  placeholder="Your Email" class="input_email">
      </div>
      <div id="password_form">
        <input type="password" name="Password" value=""  placeholder="New Password" class="input_password">
      </div>
       <div id="Re_enter_password">
        <input type="Password" name="rePassword" value=""  placeholder="Re-enter Password" class="input_Re_pass">
      </div>
          <!--    <p id="sign_user" onclick="Submit()">Sign Up </p>  -->
 
    </div>
    </form>
    <p id="sign_user" onclick="return submit()">Sign Up </p> 
    
    <!--form ends--> 
  </div>
</div>
<!--container ends-->
</body>
</html>