var phoneRegEx = /^\+?[0-9]{6,12}$/;
var tempratureRegEx = /^([0-9]{1,3})$/;
var namesRegEx = /^[a-zA-Z\s'\-]+$/;
var emailRegEx = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
var passRegEx = /^....+$/;
var dateRegEx = /^((?=\d{4})\d{4}|(?=[a-zA-Z]{3})[a-zA-Z]{3}|\d{2})((?=\/)\/|\-)((?=[0-9]{2})[0-9]{2}|(?=[0-9]{1,2})[0-9]{1,2}|[a-zA-Z]{3})((?=\/)\/|\-)((?=[0-9]{4})[0-9]{4}|(?=[0-9]{2})[0-9]{2}|[a-zA-Z]{3})$/

function onRegistretionClick() {
	var JSONdata = {
		uuid : '',
		phone : '',
		email : '',
		password : '',
		firsName : '',
		lastName : '',
		sex : '',
		birthday : '',
		max : '',
		min : '',
		opt : ''
	};
	
	var sent = true;
	if (validation($("#phone").val(), phoneRegEx)) {
		JSONdata.phone = $("#phone").val();
	} else {
		alert("Input corect Phone");
		$("#phone").val('');
		sent = false;
	}
	if (validation($("#email").val(), emailRegEx)) {
		JSONdata.email = $("#email").val();
	} else {
		alert("Input corect email");
		$("#email").val('');
		sent = false
	}
	if (validation($("#password").val(), passRegEx)
			&& $("#password").val() == $("#password_confirm").val()) {
		JSONdata.password = $("#password").val();
	} else {
		alert("Input corect password");
		$("#password").val('');
		$("#password_confirm").val('');
		sent = false
	}

	if (validation($("#name").val(), namesRegEx) || $("#name").val() == '') {
		JSONdata.firsName = $("#name").val();
	} else {
		alert("Input corect name")
		$("#name").val('')
		sent = false;
	}

	if (validation($("#surname").val(), namesRegEx) || $("#surname").val() == '') {
		JSONdata.lastName = $("#surname").val();
	} else {
		alert("Input corect surname")
		$("#surname").val('')
		sent = false;
	}
	JSONdata.sex = $("#sex:checked").val();
	JSONdata.birthday = $("#date").val();
	
	
	if (temperatureValidation($("#max").val(), tempratureRegEx)
			&& temperatureValidation($("#min").val(), tempratureRegEx)
			&& temperatureValidation($("#opt").val(), tempratureRegEx)) {
		JSONdata.max = $("#max").val();
		JSONdata.min = $("#min").val();
		JSONdata.opt = $("#opt").val();
	} else if($("#max").val() == '' && $("#min").val() == '' && $("#opt").val() == '') {
	}else {
		$("#opt").val('');
		$("#min").val('');
		$("#max").val('');
		sent = false;
	}
	
	if (sent) {
		insertData(JSONdata);
	}

}

function temperatureValidation(name, pattern) {
	if (validation(name, pattern) && name <= 273 && name >= 0)
		return true;
	else
		return false

}

function validation(name, pattern) {
	return name.match(pattern);
}

function insertData(JSONdata) {
	$.ajax({
		method : 'POST',
		url : 'web/user/getus',
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(JSONdata),
		dataType : 'text',
		success : function(data, textStatus, jqXHR) {
			alert("Congratulations!!! We sent you a confirmation mail");
			alert(data);
			setCookie('uuid', data);
			document.location.href = "index.jsp"
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseText);
		}
	});
}

//function setCookie(cname, cvalue, exdays) {
//    var d = new Date();
//    d.setTime(d.getTime() + (exdays*24*60*60*1000));
//    var expires = "expires="+d.toUTCString();
//    document.cookie = cname + "=" + cvalue + "; " + expires;
//}