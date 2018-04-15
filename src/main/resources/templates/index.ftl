<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图书下载</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="/book/css/templatemo_style.css" rel="stylesheet" type="text/css" />
<script src="/book/scripts/jquery-1.7.min.js" type="text/javascript"></script>
</head>
<body>
<!--  网站模板 from www.cssmoban.com -->
<div id="templatemo_container">
	<div id="templatemo_menu">
    	<ul>
    		<li><a href="/book/index" class="current">首页</a></li>
            <li><a href="#" class="getallbook">书籍</a></li>            
            <li><a href="#" class="company">公司</a></li> 
            <li><a target="_blank" href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=w-Hz8fT6_vb6_vCDsrLtoKyu" style="text-decoration:none;">联系我们</a></li>
    	</ul>
    </div> <!-- end of menu -->
    
    <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p>
            	尽我们最大努力帮助您找到需要的电子图书资源。
        	</p>
        </div>
        
        
        <div id="templatemo_new_books">
        	<ul>
                <#list booklist as book>
                    	<li><input type="hidden" value="${book.book_id}"/><a href="#" class="showbook_detail">${book.book_name}</a></li>
                </#list>
            </ul>
            <a href="/Book/more" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->
    
    <div id="templatemo_content">
    	
        <div id="templatemo_content_left">
        	<div class="templatemo_content_left_section">
            	<h1>栏目</h1>
            	<script type="text/javascript">
			  		$(function(){
			  			$(".Tiao").click(function(){
			  				var id=$(this).prev().val();
			  				 $.post("/book/admin/Column/getcolumn", {
								"id" : parseInt(id),
							},function(data){ 
							     $("#templatemo_content_right").html(data);
						     }); 
			  			});
			  			$(".showbook_detail").click(function(){
			  				var id=$(this).prev().val();
			  				$.post("/book/admin/Book/detail",{"id":parseInt(id),},function(data){
			  					$("#templatemo_content_right").html(data);
			  				});
			  			});
			  			$(".selectall").click(function(){
			  				var id=$(this).prev().val();
			  				$.post("/book/admin/Book/get",{"id":parseInt(id),},function(data){
			  					$("#templatemo_content_right").html(data);
			  				});
			  			});
			  			$(".company").click(function(){
			  				$.post("company",function(data){
			  					$("#templatemo_content_right").html(data);
			  				});
			  			});
			  			$(".getallbook").click(function(){
			  				alert("fd");
			  				$.post("/book/admin/Book/getall",function(data){
			  					$("#templatemo_content_right").html(data);
			  				});
			  			
			  			});
			  			$(".feedback").click(function(){
			  				$.post("/book/admin/Suggestion/add",function(data){
			  					$("#templatemo_content_right").html(data);
			  				});
			  			
			  			});
			  		});	
			  </script>
                <ul>
                    <#list categorylist as category>
                    	<li><input value="${category.cate_id}" type="hidden" id="did"/><a href="#" class="Tiao">${category.cate_name}</a></li>
                    </#list>
                    
            	</ul>
            </div>
			<div class="templatemo_content_left_section">
            	<h1>畅销书</h1>
                <ul>
                    <#list booklist as book>
                    	<li><input type="hidden" value="${book.book_id}"/><a href="#" class="showbook_detail">${book.book_name}</a></li>
                    </#list>
            	</ul>
            </div>
        </div> <!-- end of content left -->
        
        <div id="templatemo_content_right">
        <h1>热门类别</h1>
        	<#list columnlist as column>
			<#if ((column_index+1)%2==0)>
				<div class="templatemo_product_box">
					<h1>${column.column_name}</h1>
					<img src="http://www.dxian.top/Book/img/1.jpg" alt="image" height="150px" wight="100px"/>
					<div class="product_info">
					  <p style="font-size:15px;">${column.column_desc}</p>
						<div class="detail_button"><input value="${column.column_id}" type="hidden"/><a href="#" class="selectall">查看所有</a></div>
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
                    <div class="detail_button"><input value="${column.column_id}" type="hidden"/><a href="#" class="selectall">查看所有</a></div>
                	
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>
            
            <div class="cleaner_with_width">&nbsp;</div>
			</#if>
		</#list>
            
            
      </div> <!-- end of content right -->
    	
    	<div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->
    
    <div id="templatemo_footer">
    
	       <a href="index.html">首页</a> | <a href="#" class="feedback">反馈</a> | <a href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=w-Hz8fT6_vb6_vCDsrLtoKyu" style="text-decoration:none;">联系我们</a><br />
        Copyright © 2018 <a href="#"><strong>myCompany</strong></a> </div> 
</div> <!-- end of container -->
</body>
</html>
