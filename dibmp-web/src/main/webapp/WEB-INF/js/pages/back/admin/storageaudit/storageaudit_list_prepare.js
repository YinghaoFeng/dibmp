$(function(){
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.split("-")[1] ;
			$("#memberInfo").modal("toggle") ;			
		}) ;
	}) ;
	$("span[id^=sid-]").each(function(){
		$(this).on("click",function(){
			sid = this.id.split("-")[1] ;
			$("#storageDetailsInfo").modal("toggle") ;
			$.post("pages/back/admin/storageaudit/according_to.action",{"said":sid},function(data){
				//console.log(data.sum)
				$("#titles").html(data.apply.title);
				$("#names").html(data.apply.pid+","+data.apply.cid+"通州一号仓库");
				$("#wiids").html(data.apply.wiid);
				$("#nums").html("￥"+data.sum);
				$("#notes").html(data.apply.note);
				
				console.log(data.applyDetails[0].sadid)
				 apply= data.applyDetails;
				var shop = $("#shop");
				shop.empty();
				for(a=0;a<apply.length;a++){
					var rw="<tr class='text-primary'>" +
							"<td class='text-center'>"+apply[a].sadid+"</td>"+
								"<td class='text-left'>"+apply[a].name+"</td>"+
								"<td class='text-center'>"+apply[a].num+"</td>"+
								"<td class='text-center'>"+apply[a].price+"</td>"+
								"<td class='text-center'>"+apply[a].weight+"</td>"+
								"<td class='text-center'>"+(apply[a].price*apply[a].num).toFixed(2)+"</td>"+
							"</tr>" ;
					shop.append($(rw));

				}
			})
		}) ;
	}) ;
	$("span[id^=wid-]").each(function(){
		$(this).on("click",function(){
			sid = this.id.split("-")[1] ;
			$("#warehouseInfo").modal("toggle") ;
		}) ;
	}) ;
}) ;
