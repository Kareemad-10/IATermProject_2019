// Register Ajax Check E-mail Excitation in DB: 
function EMail_exicte() {
	try {
		var em = document.getElementById("em").value;
		if (em !== "" || em !== " " || em !== null) {

			var xmlHttp = new XMLHttpRequest();
			xmlHttp.open("GET", "Myservlet?EM=" + em + "&OP=regist", true);
			xmlHttp.send();
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
					if (xmlHttp.responseText === "already taken") {
						document.getElementById("em").style.background = "red";
						document.getElementById("sbt").type = 'hidden';
						document.getElementById("show").type = 'button'; // Approval
																			// Button
						document.getElementById("show_response").innerHTML = xmlHttp.responseText;
						document.getElementById("examsB").type = 'button'; // Exam
																			// Button
					} else if (xmlHttp.responseText === "you can take this") {
						document.getElementById("em").style.background = "lightgreen";
						document.getElementById("sbt").type = 'submit';
						document.getElementById("show").type = 'hidden';
						document.getElementById("examsB").type = 'hidden';
						document.getElementById("show_approval").innerHTML = "";
						document.getElementById("show_response").innerHTML = xmlHttp.responseText;

					} else if (xmlHttp.responseText === "0") {
						document.getElementById("em").style.background = "white";
						document.getElementById("sbt").type = 'hidden';
						document.getElementById("show").type = 'hidden';
						document.getElementById("examsB").type = 'hidden';
						document.getElementById("show_response").innerHTML = "";
					}
				}
			};
		} else {
			document.getElementById("em").style.background = "white";
			document.getElementById("show_response").innerHTML = " ";
			document.getElementById("show").type = 'hidden';
			document.getElementById("show_approval").innerHTML = " ";
			document.getElementById("examsB").type = 'hidden';
			document.getElementById("m1").type = 'hidden';
		}

	} catch (e) {
		document.getElementById("show_response").innerHTML = e.message;
	}
};
// SignUP Validation
function SignUP_Check() {
	var un = document.getElementById("un").value;
	var ps = document.getElementById("pass").value;

	if (un === "" || un === null) {
		alert("Please Enter Your Name ! ");
		return false;
	}
	if (ps === "" || ps === null) {
		alert("Please Enter Your Password ! ");
		return false;
	}
	return true;
}
// Login Validation
function Check() {
	var cand_CH = document.getElementById("cand");
	var hr_CH = document.getElementById("hr");
	var un = document.getElementById("uname").value;
	var ps = document.getElementById("pass").value;

	if (cand_CH.checked == false && hr_CH.checked == false) {
		alert("Please select the role ! ");
		return false;
	}
	if (cand_CH.checked == true && hr_CH.checked == true) {
		alert("Please select one role ! ");
		return false;
	}
	if (un == "" || un == null) {
		alert("Please Enter Your Name ! ");
		return false;
	}
	if (ps == "" || ps == null) {
		alert("Please Enter Your Password ! ");
		return false;
	}
	if (cand_CH.checked == true) {
		cand_CH.value = "1";
		hr_CH = "0";
		return true;
	} else {
		hr_CH.value = "1";
		cand_CH = "0";
	}

}
// check validation of Registration :
function ValidReg() {
	try {
		var em = document.getElementById("em").value;
		var cv = document.getElementById("cv").value;
		var tele = document.getElementById("tele").value;

		if (em == "" || em == null) {
			alert("Please Enter Your E-mail ! ");
			return false;
		}
		if (cv == "" || cv == null) {
			alert("Please Enter Your CV ! ");
			return false;
		}
		if (tele == "" || tele == null) {
			document.getElementById("tele").value = 0;
		}
		return true;

	} catch (e) {
		document.innerHTML = e.message;
	}
}
// Sign up Ajax :
function UN_exicte() {
	try {
		var un = document.getElementById("un").value;
		if (un != "" || un != " " || un != null) {

			var xmlHttp = new XMLHttpRequest();
			xmlHttp.open("GET", "Myservlet?UN=" + un + "&OP=signup", true);
			xmlHttp.send();
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					if (xmlHttp.responseText == "Please Enter Another Name !") {
						document.getElementById("un").style.background = "red";
						document.getElementById("sbt").type = 'hidden';
						document.getElementById("show_response").innerHTML = xmlHttp.responseText;

					} else if (xmlHttp.responseText == "free") {
						document.getElementById("un").style.background = "lightgreen";
						document.getElementById("sbt").type = 'submit';
						document.getElementById("show_response").innerHTML = xmlHttp.responseText;

					} else if (xmlHttp.responseText == "0") { // is empty
						document.getElementById("un").style.background = "white";
						document.getElementById("sbt").type = 'hidden';
						document.getElementById("show_response").innerHTML = "";
					}
				}
			}
		}

	} catch (e) {
		document.getElementById("show_response").innerHTML = e.message;
	}

}
// Show Approval State Ajax:
function checkApproval() {
	var em = document.getElementById("em").value;
	if (em != "" || em != " " || em != null) {
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET", "Myservlet?EM=" + em + "&OP=ifApprov", true);
		xmlHttp.send();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				document.getElementById("show_approval").innerHTML = xmlHttp.responseText;
			}
		}
	}
}
// Show if having exams:
function show_exams() {
	var em = document.getElementById("em").value;
	if (em != "" || em != " " || em != null) {
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET", "Myservlet?EM=" + em + "&OP=HaveExmas", true);
		xmlHttp.send();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				document.getElementById("show_approval").innerHTML = xmlHttp.responseText;
				if (xmlHttp.responseText == "yes") 
					window.location.href = 'Servlet_Loading?OP=sh_ex';					
			}
		}
	}
}

var count_ans = 0;
// function of each Answer Action :
function myFunction(btn_id) {
	
	var ET = document.getElementById("ET").value;
	var Qid = parseInt(btn_id);
	var checkboxes = document.getElementsByClassName("ch" + Qid);
	var numberOfCheckedItems = 0;

	for (var i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked == false)
			checkboxes[i].type = 'hidden';
	}
	for (var i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked == true)
			var Aid = parseInt(checkboxes[i].value);
	}
	// Ajax for Answer Action :
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "Myservlet?OP=AA" + "&ET=" + ET + "&QID=" + Qid + "&AID=" + Aid, true);
	xmlHttp.send();
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			if (xmlHttp.responseText == "correct") {
				document.getElementById("Atd"+Aid).style.background = "lightgreen";

			} else if (xmlHttp.responseText == "incorrect") {
				document.getElementById("Atd"+Aid).style.background = "red";
			}
			else{
				document.getElementById("Atd"+Aid).style.background = "yellow";

			}
		}
	}
}

document.getElementById(0).disabled = false;
// Exam_Button Action :
function goto(name){
	window.location.href = 'Servlet_Loading?OP=sh_Q&ET='+name;
}
// Exam_Submit_Button Action :
function record(){
	window.location.href = 'Record' ;
}
function ExamTimer(min,sec){
	var timerLabel = document.getElementById("timer_ID");
	timerLabel.innerHTML = '0'+min +':' + sec;
	if (sec > 0){
		sec--;
	}
	else if(min > 0){
		min--;
		sec = 59 ;
	}
	if (min == 0 && sec == 0 ){
		window.location.href = 'Record' ;// Auto Submit
	}
	var timer = setTimeout('ExamTimer('+min+','+sec+')',1000);
	
}