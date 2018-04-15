<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图书下载</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="/book/css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
        <h1>${cate_name}</h1>
        	<#list column_list as column>
			<#if ((column_index+1)%2==0)>
				<div class="templatemo_product_box">
					<h1>${column.column_name}</h1>
					<img src="/book/image/templatemo_image_02.jpg" alt="image" />
					<div class="product_info">
					  <p style="font-size:15px;">${column.column_desc}</p>
						<div class="detail_button"><input value="${column.column_id}" type="hidden"><a href="#" class="book_detail">查看所有</a></div>
					</div>
					<div class="cleaner">&nbsp;</div>
					</div>
            
				<div class="cleaner_with_height">&nbsp;</div>
			</#if>
			<#if ((column_index+1)%2==1)>
				<div class="templatemo_product_box">
            	<h1>${column.column_name}</h1>
   	      		<img src="/book/image/templatemo_image_03.jpg" alt="image" />
                <div class="product_info">
               	  <p style="font-size:15px;">${column.column_desc}</p>
                    <div class="detail_button"><input value="${column.column_id}" type="hidden"><a href="#" class="book_detail">查看所有</a></div>
                    <script type="text/javascript">
			  		$(function(){
			  			$(".book_detail").click(function(){
			  		
			  				var id=$(this).prev().val();
			  				 $.post("/book/admin/Book/get", {
								"id" : parseInt(id),
							},function(data){ 
							     $("#templatemo_content_right").html(data);
						     }); 
			  			});	
			  		});	
			  </script>
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>
            
            <div class="cleaner_with_width">&nbsp;</div>
			</#if>
		</#list>
		<div id="pager"></div>
        <script type="text/javascript" src="/book/css/bootstrap/js/jquery-1.10.2.js" ></script>
        <link href="/book/css/pagination.css"  type="text/css" rel="stylesheet" />
        <script type="text/javascript" src="/book/scripts/jquery.pagination.js" ></script>
        <script type="text/javascript">
           //初始化分页组件
           var count=${count};
           var size=${size};
           var pageNO=${pageNO};
           var id=${id};
           $("#pager").pagination(count, {
              items_per_page:size,
               current_page:pageNO-1,
               next_text:"下一页",
               prev_text:"上一页",
               num_edge_entries:2,
               load_first_page:false,
              callback:handlePaginationClick
            });
           
           //回调方法
           function handlePaginationClick(new_page_index, pagination_container){
               $.post("/book/admin/Column/getcolumn", {
								"id" : id,
								"pageNO":new_page_index+1,
							},function(data){ 
							     $("#templatemo_content_right").html(data);
						     });
           }
          
        </script>  
</body>
</html>