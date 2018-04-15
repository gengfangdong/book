<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图书下载</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="/book/css/templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/book/css/bootstrap/js/jquery-1.10.2.js" ></script>
</head>
<body>
 		<h1>${book.book_name}</h1>
        <div class="image_panel"><img src="http://www.dxian.top/Book/img/${book.book_file}.jpg" alt="CSS Template" width="100" height="150" /></div>
          <h2>Read the lessons - Watch the videos - Do the exercises</h2>
            <ul>
	            <li>作者:${book.book_user}</a></li>
            	<li>发布日期:${book.book_data}</li>
            </ul>
            
            <p>书籍描述:${book.book_desc}</p>
            
             <div class="buy_now_button"><br><input type="hidden" value="${book.book_file}"/><a href="/book/admin/Book/download?filename=${book.book_file}" >下载</a></div>
</body>
</html>