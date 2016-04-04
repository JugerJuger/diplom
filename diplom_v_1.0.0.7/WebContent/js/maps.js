$(window).load(function() {
	if (checkCookie('uuid')) {
		uuid = getCookie("uuid");
		getUser(uuid);
		setHousesFromUUID(uuid);
	} else {
		$("#main_id").html("");
	}

});

function getUser(uuid) {
	$.ajax({
		method : 'POST',
		url : 'web/user/getuserdatabyuuid',
		contentType : "text/plain; charset=utf-8",
		data : uuid,
		dataType : 'json',
		success : function(data, textStatus, jqXHR) {
			setData(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(uuid + " Error!");
		}
	});

}

function setData(data) {
	$("#phone").val(data.phone);
	$("#email").val(data.email);
	$("#name").val(data.firsName);
	$("#surname").val(data.lastName);
	$("#max").val(data.max);
	$("#min").val(data.min);
	$("#opt").val(data.opt);
}

ymaps.ready(init);
var myMap, myPlacemark;
var myGeocoder;

function init() {
	myMap = new ymaps.Map("map", {
		center : [ 50.27, 30.31 ],
		zoom : 8
	});
	var myPlacemark = new ymaps.GeoObject({
		geometry : {
			type : "Point",
			coordinates : [ 50.45, 30.52 ]
		}
	});

}

function show() {
	if ($("#house_uuid_check").is(':checked'))
		$("#house_uuid").attr('disabled', true);
	else
		$("#house_uuid").attr('disabled', false);
}

function onHouseAddClick() {
	var houseJSON = {
		'address' : '',
		'xPosition' : '',
		'yPosition' : '',
		'uuid' : '',
		'userUuid' : ''
	};

	myGeocoder = ymaps.geocode($("#address").val());
	myGeocoder.then(
			function(res) {
				houseJSON.address = $("#address").val();
				houseJSON.xPosition = res.geoObjects.get(0).geometry
						.getCoordinates()[0];
				houseJSON.yPosition = res.geoObjects.get(0).geometry
						.getCoordinates()[1];
				if (checkCookie('uuid')) {
					houseJSON.userUuid = getCookie('uuid');
				} else {
					alert("login error!!!")
				}

				setHouse(houseJSON);
			}, function(err) {
				alert('Ошибка');
			});

}

function setHouse(houseJSON) {
	$.ajax({
		method : 'POST',
		url : 'web/hous/sethous',
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(houseJSON),
		dataType : 'json',
		success : function(data, textStatus, jqXHR) {
			alert("house add");
			setHousesFromJson(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseText);
		}
	});
}

function setHousesFromUUID(uuid) {
	$.ajax({
		method : 'POST',
		url : 'web/hous/gethouses',
		contentType : "text/plain; charset=utf-8",
		data : uuid,
		dataType : 'json',
		success : function(data, textStatus, jqXHR) {
			setHousesFromJson(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseText);
		}
	});
}

function setHousesFromJson(data) {
	var div = $("#houses_list");
	div.html("");
	alert(JSON.stringify(data))
	for (var i = 0; i < data.length; i++) {
		div
				.append("<div style='width:100%; border: 1px solid;'><input type='submit' onclick='onHouseClick(this)' id='"
						+ data[i].uuid
						+ "' name='edit' value='"
						+ data[i].address
						+ "'><input type='submit' onclick='onHouseClick(this)' id='"
						+ data[i].uuid
						+ "-remove' name='edit' value='remove'><br><div>"
						+ data[i].uuid + "</div></div>");
	}
}

function onVerifyClick() {
	myGeocoder = ymaps.geocode($("#address").val());
	myGeocoder.then(function(res) {
		myMap.geoObjects.add(res.geoObjects);
	}, function(err) {
		alert('Ошибка');
	});
}

function onHouseClick(data){
	var arr = data.id.split("-");
	if(arr[arr.length-1] == 'remove'){
		onRemoveClick(data.id.replace('-remove',''));
	} else 
		clickOnHouse(data.id);	
}

function onRemoveClick(uuid){
	alert(uuid);
}

function clickOnHouse(uuid){
	alert(uuid);
}
