$(".close").click(
function()
	{
	var a=document.getElementById('window_a')
	$(a).css({"display" : "none"});	
	var w=document.getElementById('window_r')
	$(w).css({"display" : "none"});	
	var g=document.getElementById('gray')
	$(g).css({"display" : "none"}); 		
	}	
	);
$("#reg").click(function()
	{
	var w=document.getElementById('window_r')
	$(w).css({"display" : "block"});	
	var g=document.getElementById('gray')
	$(g).css({"display" : "block"}); 		
	}	
	);
$("#aut").click(function()
	{
		/*if()
{*/
	var u=document.getElementById('#uc');
	var au=document.getElementById('#aut');
	var re=document.getElementById('#reg');
	$(u).css({"display" : "block"});
	$(au).css({"display" : "block"});
	$(re).css({"display" : "block"});
/*}
else
{

}*/
	var w=document.getElementById('window_a');
	$(w).css({"display" : "block"});	
	var g=document.getElementById('gray');
	$(g).css({"display" : "block"}); 		
	}	
	);