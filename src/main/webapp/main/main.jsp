<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<%--<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/datagrid-detailview.js"></script>
<script type="text/javascript" src="../js/jquery.edatagrid.js"></script>--%>
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="../themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>


<script type="text/javascript">
    $(function () {
        //强制登录
        if("${sessionScope.login}"==""){
            window.location="${pageContext.request.contextPath}/admin/quit"
        }
        //加载菜单
        $.post("${pageContext.request.contextPath}/menu/findAll",function (menu) {
            // console.log(menu);
            //遍历菜单

            $.each(menu,function (index,m) {
                var content="<div style='text-align: center;'>";
                $.each(m.parent_id,function (idx,child){
                    content += "<a onclick=\"addTabs('"+child.title+"','"+child.iconCls+"','"+child.href+"')\" " +
                        "style='width:100%;margin:10px 0px; border: 2px #00ee00 solid;' class='easyui-linkbutton'" +
                        "data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.title+"</a><br>";
                });
                content+="</div>"
                //添加菜单
                $("#menu").accordion('add',{
                    title:m.title,
                    iconCls:m.iconCls,
                    selected:false,
                    content:content,
                })
            });
        });
    });
    //选项卡
    function addTabs(title,iconCls,href) {
        if(!$("#tabs").tabs('exists',title)){
            $("#tabs").tabs('add',{
                title:title,
                iconCls:iconCls,
                closable:true,
                href:"${pageContext.request.contextPath}"+href,
            });
        }else {
            $("#tabs").tabs('select',title);
        }
    }
    function update(id) {
        $("#editUser").dialog({
            href:'${pageContext.request.contextPath}/admin/edit.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-ok',
                handler:function () {
                    $("#editUserForm").form('submit',{
                        url:'${pageContext.request.contextPath}/admin/update',
                        success:function (result) {
                            var res=$.parseJSON(result);
                            if(res.success) {
                                $.messager.show({title: '消息',msg:'修改成功！！！'});
                                window.location="${pageContext.request.contextPath}/"+res.success
                            }else{
                                $.messager.show({title: '消息',msg:'修改失败！！！'});
                            }
                            //关闭窗口
                            $("#editUser").dialog('close');
                        }

                    });
                }
            },{
                text:'取消',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#editUser").dialog('close');
                }
            }
            ],
        });
    }
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.login.name} &nbsp;
            <a onclick="update('${sessionScope.login.id}')" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/quit" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 lfj@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
        <div id="menu" class="easyui-accordion" data-options="fit:true"></div>
    </div>   
    <div data-options="region:'center'">
    	<div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div  title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>
    <div id="editUser" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'修改密码'">
</body> 
</html>