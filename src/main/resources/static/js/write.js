/**
 * Created by ncl on 2017-06-14.
 */
var popUrl = "moviesearch.html"; //팝업창에 출력될 페이지 URL
var getJson;

function openNewWindow(popUrl) {
    var name = '_blank';
    var specs = 'menubar=no,status=no,toolbar=no';
    var newWindow = window.open(popUrl, name, specs);
    newWindow.focus();
}

function getReturnValue(returnValue) {
    getJson = JSON.parse(returnValue);
    console.log(getJson);
}

$(function(){
    $('#openNewWindow').click(function() {
        openNewWindow("../moviesearch.html");
    });
});

$(function(){
   $('#submit').click(function(){
       var form = document.getElementsByTagName("input")
       for(var i = 0; i < form.length; i++){
           if(form[i]=="" || form[i]==null){
               alert("값을 입력바랍니다.");
               return false;
           }
       }
   });
});

function blankCheck(){
    var form = document.getElementsByTagName("input")
    console.log(form);
    if(document.form.subject.value=="" ){
        alert("빈칸이 있으면 안됩니다.");
    }
}