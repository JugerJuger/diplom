<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/edit.css">
</head>
<body>
	<div class="head">
		<div class="in-part" id="my_head"></div>
		<div class="menu">
			<ul>
				<li><a href="index.jsp">Main</a></li>
				<li><a href="map.html">Map</a></li>
				<li><a href="shedule.html">schedule</a></li>
				<li><a href="advice.html">Advice</a></li>
				<li><a href="setting.html">Setting</a></li>
				<li><a href="registration.jsp">Registration</a></li>
			</ul>
		</div>
	</div>
	<div class="main" id="main_id">
		
		<div class="user-edit">

			<div class="main-data">
				<div class="titles">
					<div>phone</div>
					<div>email</div>
					<div>chaing password</div>
					<div>password confirm</div>
				</div>
				<div class="forms">
					<input type="text" name="phone" id="phone"><br> <input
						type="text" name="email" id="email"><br> <input
						type="password" name="password" id="password"><br> <input
						type="password" name="password_confirm" id="password_confirm"><br>
				</div>

			</div>
			<div class="user-info">
				<div class="titles">
					<div>name</div>
					<div>surname</div>
				</div>
				<div class="forms">
					<input type="text" name="name" id="name"><br> 
					<input type="text" name="surname" id="surname"><br> 
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
			<input type="submit" id="edit" name="edit" value="edit"
			onclick="onEditClick()">
	
		</div>
		
		<div class="houses">
			<div id="houses_list">
				
			</div>
			<div class="titles">
					<div>address</div>
					<div>-</div>
					<div>uuid</div>
					
			</div>
			<div class="forms"> 
				<div>
					<input type="text" name="address" id="address">
					<input type="submit" name="verify" id="verify" value="verify" onclick="onVerifyClick()">
				</div>
				<div><input type="checkbox" name="house_uuid_check" id="house_uuid_check" onchange="show()">house is not used</div>
				<div><input type="text" name="house_uuid" id="house_uuid"></div>
			</div> 
			<div><input type="submit" name="add_house" id="add_house"  value="add" onclick="onHouseAddClick()"></div>
			<div id="map">
				
			</div>
			 
		</div>
		<div class="sensors">
			<div><a href="#">Sensor 2</a></div>
			<div><a href="#">Sensor 3</a></div>
			<div><a href="#">Sensor 4</a></div>
			<div class="titles">
				<div>sensor name</div>
				<div>uuid</div>
			</div>
			<div class="forms">
				<div><input type="text" name="sensor_name" id="sensor_name"></div>
				<div><input type="text" name="sensor_uuid" id="sensor_uuid"></div>
			</div> 
			<div><input type="submit" name="add_sensor" id="add_sensor" value="add" onclick="onSensorAddClick()"></div>
			<div id="room">
				
			</div>
		</div>
	</div>
	<div class="foot"></div>
	<script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/edit.js"></script>
	<script type="text/javascript" src="js/maps.js"></script>
	
</body>
</html>