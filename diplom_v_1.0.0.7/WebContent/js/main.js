$(window).load(function(){
	var head = document.getElementById("my_head");
	if(checkCookie('uuid')){
		nameGenerator(head, getCookie("uuid"));
	} else{
		logInGenerator(head);
	}
});
var title;


function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(name) {
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2) return parts.pop().split(";").shift();
}

function deleteAllCookies() {
    var cookies = document.cookie.split(";");
    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }
}

function checkCookie(name) {
    var user = getCookie(name);
    if (user == "" || user == null) {
        return false;
    } else{
        return true;
    }
}

function nameGenerator(head, uuid){
	$.ajax({
        method: 'POST',
        url: 'web/user/getuserbyuuid',
        contentType: "text/plain; charset=utf-8",
        data: uuid,
        dataType: 'text',
        success: function (data, textStatus, jqXHR) {
          	generate(head, data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(uuid + " Error!");
            deleteAllCookies();
        }
    });
    
}

function generate(head , title){
	var inP = document.createElement("div");
	
	
	inP.className = 'in';
		
	inP.style.display = 'inline-block';
	inP.style.width = "100%";
	inP.style.float = 'left';

	var name = document.createElement("div");
	name.style.color = '#eaeaea';
	name.style.marginLeft = '30px';
	name.style.fontSize="30px";
	name.innerHTML = title;
	
	var logOut = document.createElement("input");
	logOut.type = 'submit';
	logOut.name = 'logOut';
	logOut.value= 'LogOut';
	logOut.onclick= function(){
		onLogOutClick();
	};
	logOut.style.background = '#ffa31a';
	logOut.style.display = 'inline-block';
	logOut.style.float = 'right';
	logOut.style.padding = '10px 20px';
	logOut.style.margin = '10px 20px';
	logOut.style.border = 'none';
	logOut.onmouseover = function() {
		logOut.style.background = '#ffb84d';
	}
	logOut.onmouseout  = function() {
		logOut.style.background = '#ffa31a';
		}



	inP.appendChild(name);
	inP.appendChild(logOut);
	head.appendChild(inP);
	
}

function logInGenerator(head){
	var inP = document.createElement("div");
	inP.className = 'in';
		
	inP.style.display = 'inline-block';
	inP.style.float = 'right';

	var nMail = document.createElement("input");
	nMail.id = 'cred';
	nMail.type = 'text';
	nMail.name = 'nMail';
	nMail.style.marginLeft = '20px';
	nMail.style.padding = '10px 20px';
	nMail.style.marginTop = '10px';
	nMail.style.marginBottom = '10px';
	nMail.style.float = 'left';

	var pass = document.createElement("input");
	pass.id= 'pass';
	pass.type = 'password';
	pass.name = 'pass';
	pass.style.marginLeft = '20px';
	pass.style.padding = '10px 20px';
	pass.style.marginTop = '10px';
	pass.style.marginBottom = '10px';
	pass.style.float = 'left';

	var logIn = document.createElement("input");
	logIn.type = 'submit';
	logIn.name = 'logIn';
	logIn.value= 'LogIn';
	logIn.onclick= function(){
		onLogInClick();
	};
	logIn.style.background = '#ffa31a';
	logIn.style.padding = '10px 20px';
	logIn.style.margin = '10px 20px';
	logIn.style.border = 'none';
	logIn.onmouseover = function() {
		logIn.style.background = '#ffb84d';
	}
	logIn.onmouseout  = function() {
		logIn.style.background = '#ffa31a';
		}

	inP.appendChild(nMail);
	inP.appendChild(pass);
	inP.appendChild(logIn);

	head.appendChild(inP);	
		
}

var phoneRegEx = /^\+?[0-9]{6,12}$/;
var emailRegEx = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
var passRegEx = /^....+$/;

function onLogInClick(){
	var JSONdata = {
			login: '',
			pass:  ''	
		};
	if (validation($("#pass").val(), passRegEx)){
		JSONdata.pass = $("#pass").val();
	} if (validation($("#cred").val(), phoneRegEx) || validation($("#cred").val(), emailRegEx)){
		JSONdata.login = $("#cred").val();
	} if(!validation($("#cred").val(), phoneRegEx) && !validation($("#cred").val(), emailRegEx)) {
		alert("wrong email or phone!!!")
	}
	insert(JSONdata);
	
}

function validation(name, pattern){
	return name.match(pattern);
}

function insert(JSONdata){
	$.ajax({
		method : 'POST',
		url : 'web/user/logIn',
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(JSONdata),
		dataType : 'text',
		success : function(data, textStatus, jqXHR) {
			setCookie('uuid', data);
			location.reload(true);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseText);
			deleteAllCookies();
		}
	});
	
}


function onLogOutClick(){
	deleteAllCookies();
	location.reload(true);
}




