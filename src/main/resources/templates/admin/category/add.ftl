<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link href="/book/css/main.css" type="text/css" rel="stylesheet" />
<title>添加学生</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>添加类别</span></h2>
        <form action="save" modelAttribute="entity">
        <fieldset>
            <legend>分类</legend>
            <p>
                <label for="name">类别名称：</label>
                <input type="text" name="cate_name" size="50" /> 
            </p>
            
            <p>
                <label for="name">类别描述：</label>
                <input type="text" name="cate_desc" size="50" />    
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
