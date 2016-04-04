<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/registration.css">
</head>
<body>
	<div class="head">
		<div class="in-part" id="my_head">
		</div>
		<div class="menu">
			<ul>
				<li><a href="index.jsp">Main</a></li>
				<li><a href="map.html">Map</a></li>
				<li><a href="shedule.html">schedule</a></li>
				<li><a href="advice.html">Advice</a></li>
				<li><a href="edit.jsp">Setting</a></li>
				<li><a href="registration.jsp">Registration</a></li>
			</ul>
		</div>
	</div>
	<div class="main">
		<div class="main-data">
			<div class="titles">
				<div>phone</div>
				<div>email</div>
				<div>passwor</div>
				<div>password confirm</div>
			</div>
			<div class="forms">
				<input type="text" name="phone" id="phone"><br>
				<input type="text" name="email" id="email"><br>
				<input type="password" name="password" id="password"><br>
				<input type="password" name="password_confirm" id="password_confirm"><br>  
			</div>
			
		</div>	
		<div class="user-info">
			<div class="titles">
				<div>name</div>
				<div>surname</div>
				<div>sex</div>
				<div>date</div>
			</div>
			<div class="forms">
				<input type="text" name="name" id="name"><br> 
				<input type="text" name="surname" id="surname"><br> 
				<input type="radio" name="sex" id="sex" value="man">man
   				<input type="radio" name="sex" id="sex" value="woman">woman<br>
				<input type="date" name="date" id="date"><br>
			</div>
		</div>
		<div class="temperature-options">
			<div class="titles">
				<div>max-temperature</div>
				<div>min-temperature</div>
				<div>opt-temperature</div>
			</div>
			<div class="forms">
				<input type="text" name="max" id="max"> K&deg<br>
				<input type="text" name="min" id="min"> K&deg<br>
				<input type="text" name="opt" id="opt"> K&deg<br>
			</div>
			
		</div>
		<input type="submit" id="registration" name="registration" value="registration" onclick="onRegistretionClick()">
	</div>
	<div class="foot"></div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/registration.js"></script>	
</body>
</html>