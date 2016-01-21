$(document).ready(function(){
   var num=1;
   var pause;
   var sum=$('li').length-1;
   var show=function(Y){
    $('img').css({'left':'-400px'});
    $('img').eq(Y).css({'left':'0px'});
    $('li').removeClass("color");
    $('li').eq(Y).addClass("color");
   };
   var run=function(){
         show(num);
        num=(num!=sum)?(num+1):0;
         pause=setTimeout(run,5000);
     };
   $('li').hover(function(event){
                   clearTimeout(pause);
                   num=$(this).text()-1;
                   show(num);  
                  },
                  function(){
                     num=(num!=sum)?(num+1):0;
                    pause=setTimeout(run,2000);
                  });  
   $('img').hover(function(event){
                   clearTimeout(pause);  
                  },
                  function(){
                    pause=setTimeout(run,2000);
                  });  
  show(0);
  pause=setTimeout(run,5000);
  });