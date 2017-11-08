$(function(){
	$("button[id^=access-]").each(function(){
		$(this).on("click",function(){
			sdid = this.id.split("-")[1] ;
			operateAlert(true,"商品成功入库存储！","商品入库失败！") ;
		}) ;
	}) ;
	$("button[id^=denied-]").each(function(){ 
		$(this).on("click",function(){
			sdid = this.id.split("-")[1] ;
			operateAlert(false,"商品成功入库存储！","商品入库失败！") ;
		}) ;
	}) ;

	 said = $("#said").html();
	 $.post("pages/back/admin/manage/storage_shop.action",{"said":said},function(data){
		 console.log(data.details+"长度"+data.details.length);
		 detail = data.details;
		 for(a =0;a< detail.length ;a ++){
			 var row= "<tr id='dettr-1' class='text-success'>"+
				"<td>"+detail[a].sadid+"</td>"+
				"<td>"+detail[a].name+"</td>"+
				"<td>"+detail[a].num+"</td>"+
				"<td>"+detail[a].price+"</td>"+
				"<td>"+detail[a].weight+"</td>"+
				"<td> <button id='access-"+detail[a].sadid+"' class='btn btn-primary btn-xs'>"+
					"<span class='glyphicon glyphicon-edit'></span>&nbsp;允许入库</button>"+
					"<button id='denied-"+detail[a].sadid+"' class='btn btn-danger btn-xs'>"+
					"<span class='glyphicon glyphicon-edit'></span>&nbsp;拒绝入库</button>"+
					"</td>"+
				"</tr>";
			 
			 $("#tbodyTite").append($(row));
		 }
	 });




})