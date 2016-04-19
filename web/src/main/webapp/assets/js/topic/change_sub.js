$(function(){
	$('.panel_sub').click(function(e){
		if($(e.target).hasClass('del_content')){
			$(e.target).parents("tr").remove();
		}
		if($(e.target).hasClass("append_content")){
			var app_content = $(e.target).parents("tr").clone();
			app_content.find("td input").val("");

			var oTable1 = document.getElementById('itemInfoTableId');
			var rowlength= oTable1.rows.length+1;
			app_content.find("td button").attr("data-id","itemImage"+rowlength);
			app_content.find("td button").prev().attr("id","itemImage"+rowlength);
			$(e.target).parents("tr").after(app_content);
		}
	});
});