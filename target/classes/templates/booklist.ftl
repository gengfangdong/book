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
        <h1>所有图书</h1>
        	<#list booklist as book>
			<#if ((book_index+1)%2==0)>
				<div class="templatemo_product_box">
					<h1>${book.book_name}</h1>
					<img src="www.dxian.top/Book/img/${book.book_file}.jpg" alt="image" />
					<div class="product_info">
					  <p style="font-size:15px;">${book.book_desc}</p>
						<div class="detail_button"><a href="booksdetail.html">详情</a></div>
                   		<div class="buy_now_button"><a href="/admin/Book/download?filename=${book.book_file}" >下载</a></div>
					</div>
					<div class="cleaner">&nbsp;</div>
					</div>
            
				<div class="cleaner_with_height">&nbsp;</div>
			</#if>
			<#if ((book_index+1)%2==1)>
				<div class="templatemo_product_box">
            	<h1>${book.book_name}</h1>
   	      		<img src="http://www.dxian.top/Book/img/${book.book_file}.jpg" alt="image" height="150px" wight="100px"/>
                <div class="product_info">
               	  <p style="font-size:15px;">${book.book_desc}</p>
                    <div class="detail_button"><input value="${book.book_id}" type="hidden"/><a href="#" class="detail">详情</a></div>
                   		<div class="buy_now_button"><a href="/admin/Book/download?filename=${book.book_file}" >下载</a></div>
                    <script type="text/javascript">
			  		$(function(){
			  			$(".detail").click(function(){
			  		
			  				var id=$(this).prev().val();
			  				 $.post("/admin/Book/detail", {
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
               $.post("/admin/Book/getall", {
								"pageNO":new_page_index+1,
							},function(data){ 
							     $("#templatemo_content_right").html(data);
						     });
           }
          
        </script>  
</body>
</html>