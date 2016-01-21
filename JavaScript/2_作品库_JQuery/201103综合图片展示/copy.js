$(document).ready(function(){
  var x=1;
  var num=3;
  var Pause;
  var active=false;
  var $list=$('#imgbox li');
  var count=$list.length-1;
  var x_length=336.0/($list.length/4);
  $('#L').width(x_length+'px'); 
  var reset=function(){          
       $('#imgbox li').each(function(index){
                $(this).css({'left':330-index*110+'px'});
                $(this).hover(function(event){
                      clearTimeout(Pause);
                      picShow(index);
                  },function(event){
                      });});    
    };
  var picShow=function(y){
      $('#pic').empty();
      var pic=$('#imgbox img').eq(y).clone();
      pic.appendTo('#pic');
      $('#imgbox li').removeClass('on');
      $('#imgbox li').eq(y).addClass('on');
     }
  var picRun=function(){
      picShow(num);
      if(num!=0){
           num=num-1;
           Pause=setTimeout(picRun,5000);
        }
      else{
            num=3;
           Pause=setTimeout(listRun,5000);
        }
    };
  var listRun=function(){
      if(!active){
      active=true;
      $('#imgbox li').each(function(index){
          if(index!=count){
          $(this).animate({'left':330-index*110+440+'px'},5000);
         } else{
          $(this).animate({'left':330-index*110+440+'px'},5000,function(){        
                                        $('#imgbox li').each(function(index){
                                                if(index<4){
                                                    $(this).appendTo('#imgbox ul');
                                                 }});
                                        active=false;
                                        reset();
                                        Pause=setTimeout(picRun,1000);
                                    });}
                  });
          $('#L').animate({'left':x*x_length+'px'},5000,function(){
                                              if(x!=$list.length/4-1){
                                                x=x+1;
                                             }else{
                                                x=0}});
   }   
 };
   $('#container').hover(function(event){
                 clearTimeout(Pause);
                },function(event){
                 if(!active){
                 num=3;
                 Pause=setTimeout(listRun,2000);}
                });
   $('#next').click(function(event){
                  if(!active){
                 num=3;
                 listRun();}
                });
 reset();
 picRun();
});