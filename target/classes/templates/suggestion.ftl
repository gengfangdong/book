<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>信息反馈</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML, cssMoban.com" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website from cssMoban.com" />
<link href="/book/css/templatemo_style.css" rel="stylesheet" type="text/css" />
<script src="/book/scripts/jquery-1.7.min.js" type="text/javascript"></script>
</head>
<body>
			<script type="text/javascript">
			  		$(function(){
			  			$(".Tiaofankui").click(function(){
			  				var id=$(this).prev().val();
			  				 $.post("/book/admin/Suggestion/save", $("#form1").serialize(),function(data){ 
							     $("#templatemo_content_right").html(data);
						     }); 
			  			});
			  		});	
			  </script>
        	
            <h1>意见反馈</h1>
          <div class="feedback_tips"><h2>请您对我们提出宝贵意见和建议，您留下的每个意见都是我们产品不断改进的动力！</h2></div>
            <form action="" modelAttribute="entity" id="form1">
            <div class="suggestions">
            
            <textarea id="suggestion_desc" class="font" 	 cols="80"
	 rows="12"  style="background-color:#4b4743" name="suggestion_desc"></textarea>
                    
             
             <div class="cleaner_with_height">&nbsp;</div>
            
            
          <td> <p style="font-size:15px"> 您的QQ：</p>
          <input type="text" id="suggestion_flag" value="0" hidden name="suggestion_flag"/>
          <input type="text" id="suggestion_qq" style="background-color:#4b4743"  name="suggestion_qq"/>
          </td>
           <td><span style="font-size:12px">我们有可能邀请您加入产品讨论群，共同参与产品建设。</span></td>
                   	<div class="cleaner_with_height">&nbsp;</div>

                        <div class="submit_button"><a href="#" class="Tiaofankui">提交</a></div>  
                        <p>${addmsg}</p>
                        </form>
</body>
</html>