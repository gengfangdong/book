<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link href="/book/css/main.css" type="text/css"
    rel="stylesheet" />
<title>编辑类别</title>
</head>
<body>
    <div class="main">
        <h2 class="title">
            <span>编辑类别</span>
        </h2>
        <form action="/book/admin/Category/updat" modelAttribute="entity">
            <fieldset>
                
                <p>
                <label for="name">类别名称：</label>
                <input type="text" name="cate_name" size="50" value="${entity.cate_name}"/> 
            </p>
            
            <p>
                <label for="name">类别描述：</label>
                <input type="text" name="cate_desc" size="50" value="${entity.cate_desc}"/>    
            </p>
            <input type="submit" value="保存" class="btn out">
            </fieldset>
        </form>
        <p style="color: red"></p>
        
        <p>
            <a href="/book/admin/Category/list" class="abtn out">返回列表</a>
        </p>
    </div>
</body>
</html>