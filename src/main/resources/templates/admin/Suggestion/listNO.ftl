<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/book/css/main.css"  type="text/css" rel="stylesheet" />
<title>反馈管理</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>反馈管理</span></h2>
        <h3 class="htitle"><a href="getlistpager?flag=0">未处理反馈<a/></h3>
        <h3 class="htitle"><a href="getlistpager?flag=1">已处理反馈<a/></h3>
        <br>
        <table border="1" width="100%" class="tab">
            <tr>
             	<td>内容</td>
             	<td>QQ</td>
             	<td>操作</td>
            </tr>
            <#list suggestion_list as suggestion>
					<form action="/book/admin/Suggestion/update" method="post" id="form${suggestion.suggestion_id}">
					<tr>
					<input type="number" name="suggestion_id" value="${suggestion.suggestion_id}" hidden/>
                    <input type="hidden" name="suggestion_desc" value="${suggestion.suggestion_desc}"/><td>${suggestion.suggestion_desc}</td>
                    <input type="number" name="suggestion_qq" value="${suggestion.suggestion_qq}" hidden/><td>${suggestion.suggestion_qq}</td>
                    <td>
                    <input type="number" name="suggestion_flag" value="1" hidden/>
                    <a href="#" class="abtn" onClick="document.getElementById('form${suggestion.suggestion_id}').submit()">已阅</a>
                    </td>
                   </tr>
                   </form>
           </#list> 
        </table>
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
               location.href="/book/admin/Suggestion/getlistpager?pageNO="+(new_page_index+1)+"&&flag=0";
           }
          
        </script>
    
    </div>
</body>
</html>
