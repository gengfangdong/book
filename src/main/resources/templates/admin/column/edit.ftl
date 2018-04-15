<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link href="/book/css/main.css" type="text/css"
    rel="stylesheet" />
<title>编辑栏目</title>
</head>
<body>
    <div class="main">
        <h2 class="title">
            <span>编辑栏目</span>
        </h2>
        <form action="/book/admin/Column/update" modelAttribute="entity">
            <fieldset>
                <legend>栏目</legend>
               <p>
                <label for="name">栏目名字 ：</label> 
                <input type="text" name="column_name" size="50" value="${entity.column_name}"/> 
               </p>
               <p>
                <label for="name">栏目描述 ：</label> 
                <input type="text" name="column_desc" size="50" value="${entity.column_desc}"/> 
               </p>
            <p>
                <label for="usertype">所属类别：</label>
                <select name="Cate_id">
                <#list cateGorylist as category>
                     <option value="${category.cate_id}" <#if (entity.cate_id==category.cate_id)> selected="selected"</#if>>${category.cate_name}</option>
                </#list>
                </select>
                
            </p>
        
            <input type="submit" value="保存" class="btn out">
            </fieldset>
        </form>
        <p style="color: red"></p>
        
        <p>
            <a href="/book/admin/Column/list" class="abtn out">返回列表</a>
        </p>
    </div>
</body>
</html>