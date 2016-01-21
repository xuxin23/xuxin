$(document).ready(function(){
  var pause;
  var active=false;
  var count=$('li').length-1;
  var reset=function(){
      $('li').each(function(index){
              $(this).css({'left':330-index*110+'px'});});
       };
  var run=function(){
          if(!active){
         active=true;
         reset();
         $('li').each(function(index){
              if(index!=count){
                   $(this).animate({'left':330-index*110+440+'px'},'slow');
              }else{
                   $(this).animate({'left':330-index*110+440+'px'},'slow',function(){        
                                        $('li').each(function(index){
                                                if(index<4){
                                                    $(this).appendTo('ul');
                                                 }});
                                        active=false;
                                        pause=setTimeout(run,8000);});}
                                    });
                  }
            };
   $('ul').hover(function(event){
                 clearTimeout(pause);
                },function(event){
                 pause=setTimeout(run,2000);
                });
   $('li').hover(function(event){
                 $(this).addClass('on');
                 },function(event){
                 $(this).removeClass('on');
                 });
 reset();
 pause=setTimeout(run,5000);
});