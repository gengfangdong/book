<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="multipart/form-data;charset=UTF-8">
<link href="/book/css/main.css" type="text/css"
    rel="stylesheet" />
<script src="/book/scripts/jquery-1.7.min.js" type="text/javascript"></script>
<title>编辑图书</title>
</head>
<body>
    <div class="main">
        <h2 class="title">
            <span>编辑图书</span>
        </h2>
        <form action="/book/admin/Book/update" modelAttribute="entity" enctype="multipart/form-data" method="post">
            <fieldset>
                <legend>图书</legend>
                <input type="hidden" name="book_id" value="${entity.book_id}" />
               <p>
                <label for="name">图书名字 ：</label> 
                <input type="text" name="book_name" size="50" value="${entity.book_name}"/> 
               </p>
               <p>
                <label for="name">图书描述 ：</label> 
                <input type="text" name="book_desc" size="50" value="${entity.book_desc}"/> 
               </p>
               <p>
                <label for="name">图书管理员：</label> 
                <input type="text" name="book_user" size="50" value="${entity.book_user}"/> 
               </p>
            <p>
                <label for="usertype">所属类别：</label>
                <select name="column_id">
                <#list columnlist as column>
                     <option value="${column.column_id}" <#if (entity.column_id==column.column_id)> selected="selected"</#if>>${column.column_name}</option>
                </#list>
                </select>      
            </p>
            
            <p>
                <label for="name" id="n">文件：</label>
                <input type="text" value="${book_map.book_util}" id="filename"/><input type="button" value="重新上传" id="XiuGai"/>
                <br/>
                <input type="file" name="file" size="50" style="display:none" id="file"/>
                <script type="text/javascript">
					$("#XiuGai").click(function(){
						var file=$("#file");
						var filename=$("#filename");
						file.show();
						filename.hide();
						$("#XiuGai").hide();
						$("#n").hide();
					})
				</script>
  
            </p>
            <input type="submit" value="保存" class="btn out">
            </fieldset>
        </form>
        <p style="color: red"></p>
        
        <p>
            <a href="/admin/Book/list" class="abtn out">返回列表</a>
        </p>
    </div>
</body>
</html>