<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link href="/book/css/main.css" type="text/css" rel="stylesheet" />
<title>添加管理员</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>添加管理员</span></h2>
        <form action="/book/admin/User/save" modelAttribute="entity">
        <fieldset>
            <legend>管理员</legend>
            <p>
                <label for="name">管理员名称：</label>
                <input type="text" name="user_name" size="50" /> 
                
            </p>
            <p>
                <label for="name">管理员密码 ：</label> 
                <input type="password" name="user_password" size="50" /> 
            </p>
            <p>
              <input type="submit" value="保存" class="btn out">
            </p>
        </fieldset>
        </form>
        <p style="color: red"></p>
        <p>
            <a href="/book/admin/User/list"  class="abtn out">返回列表</a>
        </p>
    </div>
</body>
</html>
