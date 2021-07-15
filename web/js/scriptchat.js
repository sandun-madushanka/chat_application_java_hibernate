
//
//window.setInterval(function () {
//    loadms();
//    loadmcount();
//}, 20);


function scrollmsg() {
    $('#message-body').scrollTop($('#message-body')[0].scrollHeight - $('#message-body')[0].clientHeight);

}

function loadms() {
    var xhttp;
    var chatroom = document.getElementById("valchatroom").value;
    var lastmsg = document.getElementById("valmsgid").value;
    var userid = document.getElementById("valuserid").value;
    var currentuser = document.getElementById("valcurrentuser").value;
    //alert(chatroom+" "+lastmsg+" "+ userid+" "+currentuser);
    if (window.XMLHttpRequest) {

        xhttp = new XMLHttpRequest();

    } else {

        xmhttp = new Activxobject("Microsoft.XMLHTTP");

    }

    xhttp.onreadystatechange = function () {

        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("msg-inner-body").innerHTML =  xhttp.responseText;
        }

    }
    xhttp.open("GET", "LoadMsg?valchatroom=" + chatroom + "&valuserid=" + userid + "&valcurrentuser=" + currentuser + "&valmsgid=" + lastmsg, true);
    xhttp.send();
}


function loadmcount() {
    var xhttp;
    var chatroom = document.getElementById("valchatroom").value;
    var lastmsg = document.getElementById("valmsgid").value;
    var userid = document.getElementById("valuserid").value;
    var currentuser = document.getElementById("valcurrentuser").value;

    if (window.XMLHttpRequest) {

        xhttp = new XMLHttpRequest();

    } else {

        xmhttp = new Activxobject("Microsoft.XMLHTTP");

    }

    xhttp.onreadystatechange = function () {

        if (xhttp.readyState == 4 && xhttp.status == 200) {
            // document.getElementById("valmsgid").value=xhttp.responseText;
            //alert(xhttp.responseText);
            var res = xhttp.responseText;
            var s = res.split(" ");
            // alert(s);
            document.getElementById("valmsgid").value = s[0];
            document.getElementById("valcurrentuser").value = s[1];

        }

    }
    xhttp.open("GET", "LoadMsgCount?valchatroom=" + chatroom + "&valuserid=" + userid + "&valcurrentuser=" + currentuser + "&valmsgid=" + lastmsg, true);
    xhttp.send();
}
function twome() {
    loadms();
    loadmcount();

}


function sendMsg() {
    var msg = document.getElementById("msg").value;
    var chatroom = document.getElementById("chatroom").value;
    var userid = document.getElementById("userid").value;
    document.getElementById("msg").value = "";

    var xhttp;

    if (window.XMLHttpRequest) {

        xhttp = new XMLHttpRequest();

    } else {

        xmhttp = new Activxobject("Microsoft.XMLHTTP");

    }

    xhttp.onreadystatechange = function () {

        if (xhttp.readyState == 4 && xhttp.status == 200) {
            twome();
            


        }
    }
    xhttp.open("POST", "SendMsg?msg=" + msg + "&chatroom=" + chatroom + "&userid=" + userid, false);
    xhttp.send();

}






