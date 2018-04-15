<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link href="/book/css/bootstrap/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="/book/css/bootstrap/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="/book/css/bootstrap/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   <style type="text/css">
    .sidebar-collapse .nav{margin-top: -50px}
   </style>
</head>
<body>
<br/>
<ul class="nav nav-pills nav-stacked">
    <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                  
                    <li>
                        <a href="Category/list" target="show"><i class="fa fa-desktop "></i>分类管理</a>
                    </li>

                    <li>
                        <a href="Column/list"  target="show"><i class="fa fa-table "></i>栏目管理</a>
                    </li>
                    <li>
                        <a href="Book/list"  target="show"><i class="fa fa-edit "></i>书籍管理</a>
                    </li>
                    <li>
                        <a href="Suggestion/getlistpager?flag=0"  target="show"><i class="fa fa-edit "></i>反馈管理</a>
                    </li>
                    <#if (user=="admin")>
                    	<li>
                        	<a  href="User/list"  target="show"><i class="fa fa-qrcode "></i>系统管理员</a>
                    	</li>
                    </#if>
   
                </ul>
             </div>

        </nav>
</ul>
</body>
</html>
