var href = window.location.href;//请求路径
var sid =href.substr(href.indexOf("?"+1));

$(function(){

	$("#showMember").on("click",function(){
		$("#memberInfo").modal("toggle") ;
	}) ;
	$("#showWarehouse").on("click",function(){
		$("#warehouseInfo").modal("toggle") ;
	}) ;
	

	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			form.submit(); // 提交表单
		},
		errorPlacement : function(error, element) {
			$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
		},
		highlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1, function() {
					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
				});

			})
		},
		unhighlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1,function() {
						$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
				});
			})
		},
		errorClass : "text-danger",
		rules : {
			"audit" : {
				required : true,
			},
			"note" : {
				required : true
			}
		}
	});
	
	$("#contentOne").each(function () {
		said=sid;
		$.post("pages/back/admin/storageaudit/edit_num.action",{"said":sid},function(data){
			console.log(data) ;
			apply = data.allApplyDetails ;
			
			for(x = 0 ; x < apply.length; x ++){
				var row ="<tr class='text-primary'>"+
				"<td class='text-center' id='gid-"+apply[x].gid+"'>"+apply[x].gid+"</td>"+
				"<td class='text-left'   id='name-"+ apply[x].gid+"'>"+apply[x].name+"</td>"+
				"<td class='text-center' id='num-"+apply[x].gid+"'>"+apply[x].num+"</td>"+
				"<td class='text-center' id='price-"+apply[x].gid+"'>"+apply[x].price+"</td>"+
				"<td class='text-center' id='weight-"+apply[x].gid+"'>"+apply[x].weight+"</td>"+
				"<td class='text-center' id='sum-"+apply[x].gid+"'>"+(apply[x].price*apply[x].num).toFixed(2)+"</td>" +
				"</tr>";
				$("#tbody").append($(row)) ;
			}
			 
	},"json")
	});

//	$("#buttonadd").on("click",function(){
//		
//		$("td[id^=gid-]").each(function(){
//			 gid = this.id.split("-")[1];
//			 name = $("#name-"+gid).html();
//			 num  = $("#num-"+gid).html();
//			 price =$("#price-"+gid).html();
//			 weight =$("#weight-"+gid).html();
//			 audit= $("#audit").html();
//			$.ajax({
//				url:"pages/back/admin/storageaudit/edit.action",
//				method:"post",
//				data:{
//					"gid":gid,
//					"name":name,
//					"num":num,
//					"price":price,
//					"weight":weight,
//					"said":sid,
//					"audit":audit
//				},
//				dataType:"json"
//			});
// 
//		}) ;
//
//	}) ;
	
	
})