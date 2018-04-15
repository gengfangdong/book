<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/book/css/main.css"  type="text/css" rel="stylesheet" />
<title>栏目管理</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>栏目管理</span></h2>
        <form action="deletes" method="post">
        <table border="1" width="100%" class="tab">
            <tr>
                <th><input type="checkbox" id="chbAll"></th>
                <th>栏目编号</th>
                <th>栏目名称</th>
                <th>栏目描述</th>
                <th>所属类别</th>
                <th>栏目操作</th>
            </tr>
            <#list column_list as columnlist>
					<tr>
                    <th><input type="checkbox" name="id" value="${columnlist.column.column_id}"></th>
                    <td>${columnlist.column.column_id}</td>
                    <td>${columnlist.column.column_name}</td>
                    <td>${columnlist.column.column_desc}</td>
                    <td>${columnlist.cateGory.cate_name}</td>
                    <td>
                    <a href="delete/${columnlist.column.column_id}" class="abtn">删除</a>
                    <a href="edit/${columnlist.column.column_id}" class="abtn">编辑</a>
                    </td>
                </tr>
           </#list> 
        </table>
        <div id="pager"></div>
        <p>
            <a href="add" class="abtn out">添加</a>
            <input type="submit"  value="批量删除" class="btn out"/>
        </p>
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
               location.href="list?pageNO="+(new_page_index+1);
           }
          
        </script>
    </form>
    </div>
</body>
</html>
