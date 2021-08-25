//verificare ca parola sa coincida cu confirmarea parolei
function Validate() {
    var password=document.getElementById("pwd").value;
    var confirmPassword = document.getElementById("rpwd").value;
    if (password != confirmPassword) {
        alert("Passwords do not match.");
        document.getElementById('submit').disabled = true;
    }
    else{
        document.getElementById('submit').disabled = false;
    }
}

function GetData()
{
    var nume_pacient= document.getElementById("nume_pacient").value;
    var CNP=document.getElementById("CNP").value;
    var telefon=document.getElementById("tel").value;
    var adresa=document.getElementById("adresa").value;
    var email=document.getElementById("email").value;
    var parola=document.getElementById("pwd").value;
    var cparola=document.getElementById("rpwd").value;
    var data= JSON.stringify({nume_pacient:nume_pacient,CNP:CNP,telefon:telefon,adresa:adresa,email:email,parola:parola,cparala:cparola});
    //document.getElementById("info").innerHTML=data;
    return data;
}
