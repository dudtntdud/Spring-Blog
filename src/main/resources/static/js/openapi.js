function getDom(id){
  return document.getElementById(id)
}

var wrap = getDom("wrap");
var StringField = getDom("inputString");
var template = getDom('ListTemplate').innerHTML;
var button = getDom("button")
var wantsearch = null;
var pagenumber = 1;
var apikey = '2c5481187fc5fd8012a831b26eb89960';
var data_list = null;

StringField.addEventListener('keyup', function(event){
  if(event.keyCode==13){
    wrap.innerHTML= ''              //신규검색시 모든 리스트 삭제
    pagenumber = 1;                 //신규검색시 페이지넘버 초기화
    wantsearch = StringField.value;

    if(wantsearch != ""){
      addUrlList();
    }
  }
});

function addUrlList(){
  var apiurl = 'https://apis.daum.net/contents/movie?q='+ wantsearch +'&apikey='+apikey+
   '&output=json'+'&pageno='+ pagenumber;

   button.removeAttribute("style")

   getJSON(apiurl, function(res){
     console.log(res.channel.item);

     data_list = res.channel.item;
     for(var i=0; i<data_list.length; i++) {
         $("#wrap").append("<div id='" + i +"'><div id='" + i +"' class='thumbnail round movielist' style='background-image:url("+ data_list[i].thumbnail[0].content +")'></div><div id='" + i +"'>" + data_list[i].title[0].content + "</div></div>");
     }
   });

   console.log(apiurl);
}

function buttonclick(){
  pagenumber++;
  addUrlList();
}

$(document).ready(function(){
    $('body').click(function(e) {
        var id = e.target.getAttribute("id");
        if ( ( id >= 0) && (id <= 50)) {
            var returnValue = data_list[id];
            console.log(returnValue);
            console.log(id);
            window.opener.getReturnValue(JSON.stringify(returnValue));
            window.opener.document.getElementById("thumbnail").setAttribute('src', returnValue.thumbnail[0].content);
            window.opener.document.getElementById("title").innerHTML = returnValue.title[0].content;
            window.opener.document.getElementById("title2").value = returnValue.title[0].content;
            window.opener.document.getElementById("director").innerHTML = returnValue.director[0].content;
            window.opener.document.getElementById("thumbnail2").setAttribute('value', returnValue.thumbnail[0].content);
            window.opener.document.getElementById("story").innerHTML = returnValue.story[0].content;
            window.close();
        }
    });
});

