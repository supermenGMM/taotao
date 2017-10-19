<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.4.1/jquery.min.js"></script>
</head>
<body>
<div>
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="importAll()">一键导入商品数据到索引库</a>
</div>
<script type="text/javascript">

function importAll() {
	$.post("/index/importall",null,function(data){
		alert(data.status);
		if (data.status==200) {
			$.messager.alert('提示','商品数据导入成功！');
		} else {
			
			$.messager.alert('提示','商品数据导入失败！');
		}
		
	});	
}
</script>
</body>
</html>