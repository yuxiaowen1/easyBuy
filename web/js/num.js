// JavaScript Document


function addUpdate(jia){		
	var c = $(jia).parent().find(".n_ipt").val();
	c=parseInt(c)+1;	
	jia.parent().find(".n_ipt").val(c);
}

function jianUpdate(jian){    
	var c = $(jian).parent().find(".n_ipt").val();
	if(c==1){    
		c=1;    
	}else{    
		c=parseInt(c)-1;    
		jian.parent().find(".n_ipt").val(c);
	}
}    




function addUpdate1(price,index){
	var c = $(this).parents().find(".car_ipt").val();
	c=parseInt(c)+1;
    $(this).parent().find(".car_ipt").val(c);

}

function jianUpdate1(price,index){
	alert($("[name=subtotal]:nth-of-type("+index+")").html());
	var c = $(this).parents().find(".car_ipt").val();
	if(c==1){    
		c=1;    
	}else{    
		c=parseInt(c)-1;
        $(this).parent().find(".car_ipt").val(c);
	}

}    
