<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="multipart/form-data;charset=UTF-8">
<link href="/book/css/main.css" type="text/css" rel="stylesheet" />
<title>添加图书</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>添加图书</span></h2>
        <form action="save" modelAttribute="entity" enctype="multipart/form-data" method="post">
        <fieldset>
            <legend>图书</legend>
            <p>
                <label for="name">图书名称：</label>
                <input type="text" name="book_name" size="50" /> 
            </p>
            
            <p>
                <label for="name">图书描述：</label>
                <input type="text" name="book_desc" size="50" />    
            </p>
             <p>
                <label for="name">图书管理员：</label>
                <input type="text" name="book_user" size="50" />    
            </p>
             <p>
                <label for="name">所属栏目：</label>
                <select name="column_id">
                <#list columnlist as column>
                     <option value="${column.column_id}">${column.column_name}</option>
                </#list>
                </select>  
            </p>
            <p>
                <label for="name">上传文件：</label>
                <input type="file" name="file" size="50" />    
            </p>
            <p>
              <input type="submit" value="保存" class="btn out">
            </p>
        </fieldset>
        </form>
        <p>
            <a href="list"  class="abtn out">返回列表</a>
        </p>
    </div>
</body>
</html>
