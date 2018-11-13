<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
$(function () {
    $('#GuruDg').edatagrid({
        title:'disableEditing',
        toolbar:'#tb',
        rownumbers:true,
        pagination:true,
        pageNumber:1,
        pageSize:2,
        pageList:[2,4,6,8],
        height:200,
        fit:true,
        autoSave:true,
        url:'${pageContext.request.contextPath}/guru/findPage',
        <%--saveUrl:'${pageContext.request.contextPath}/banner/add',--%>
        columns:[[
        {
        title:'cxf',
        field:'cxf',
        checkbox:true,
        }, {
        title:'id',
        field:'id',
        width:'100',

        },{
        title:'name',
        field:'name',
        width:'100',
        editor:'text',
        },{
        title:'headPic',
        field:'headPic',
        width:'150',
        editor:'text',
        },{
        title:'sex',
        field:'sex',
        width:'200',
        editor:'text',
        },{
        title:'status',
        field:'status',
        width:'100',
        editor:'text',
        },{
        title:'operates',
        field:'operates',
        width:'200',
        formatter:function (value,row,index) {
                return "<a href='javascript:;' class='operates' data-options=\"iconCls:'icon-edit',plain:true\" onclick=\"update('"+row.id+"')\">修改</a>&nbsp;&nbsp;&nbsp;" +
                "<a href='javascript:;' class='operates' data-options=\"iconCls:'icon-remove',plain:true\" onclick=\"delRow('"+row.id+"')\">删除</a>"
                }
            },
        ]],
    view: detailview,
    detailFormatter: function(rowIndex, rowData){
        return '<table><tr>' +
        '<td rowspan=2 style="border:0"><img src="../' + rowData.headPic + '" style="height:50px;"></td>' +
        '<td style="border:0">' +
        '<p>name: ' + rowData.name + '</p>' +
        '<p>status: ' + rowData.status + '</p>' +
        '</td>' +
        '</tr></table>';
    },
    onLoadSuccess:function () {
        $('.operates').linkbutton();
    }

    });
    $("#GuruDg").edatagrid('disableEditing');
});

function add() {
    $("#saveGuru").dialog({
        title:'保存用户信息',
        buttons:[{
            text:'保存',
            iconCls:'icon-save',
            handler:function () {
                $("#saveGuruForm").form('submit',{
                    url:'${pageContext.request.contextPath}/guru/add',
                    success:function (result) {
                        var res=$.parseJSON(result);
                        if(res.success) {
                            //提示信息
                            $.messager.show({title: '消息', msg: '添加成功！！！'});
                        }else{
                            $.messager.show({title: '消息',msg:'添加失败！！！'});
                        }
                        //关闭窗口
                        $("#saveGuru").dialog('close');
                        //刷新datagrid
                        $("#GuruDg").datagrid('reload');
                    }
                });
            }
        },{
            text:'取消',
            iconCls:'icon-cancel',
            handler:function () {
                $("#saveBanner").dialog('close');
            }
        }
        ],
    });
}
//删除
function delRow(id) {
    $.post('${pageContext.request.contextPath}/guru/delete',{"id":id},function () {
        $.messager.show({title: '消息', msg: '删除成功！！！'});
        $("#GuruDg").datagrid('reload');
    });
}

function update(id) {
    $("#editGuru").dialog({
        title:'修改用户信息',
        href:'${pageContext.request.contextPath}/guru/edit.jsp?id='+id,
        buttons:[{
            text:'保存',
            iconCls:'icon-save',
            handler:function () {
                $("#editGuruForm").form('submit',{
                    url:'${pageContext.request.contextPath}/guru/update',
                    success:function (result) {
                        var res = $.parseJSON(result);
                        if(res.success){
                            //提示信息
                            $.messager.show({title:'消息',msg:'修改成功！！！'});
                        }else {
                            //提示信息
                            $.messager.show({title:'消息',msg:'修改失败！！！'});
                        }
                        //关闭窗口
                        $("#editGuru").dialog('close');
                        //刷新datagrid
                        $("#GuruDg").datagrid('reload');
                    }

                });
            }
        },{
            text:'取消',
            iconCls:'icon-cancel',
            handler:function () {
                $("#editBanner").dialog('close');
            }
        }
        ],
    });
}
</script>
<table id="GuruDg"></table>

<div id="tb">
    <a href="javascript:;" class="easyui-linkbutton" onclick="add()" data-options="iconCls:'icon-add',plain:true">添加</a>
    <%--<a href="javascript:;" class="easyui-linkbutton" onclick="openBanner()" data-options="iconCls:'icon-add',plain:true">开启控件</a>--%>
    <%--<a href="javascript:;" class="easyui-linkbutton" onclick="deleteAll()" data-options="iconCls:'icon-remove',plain:true">批量删除</a>--%>
</div>

<%--添加弹出框--%>
<div id="saveGuru" data-options="href:'${pageContext.request.contextPath}/guru/GuruSave.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'添加上师'"></div>

<%--修改弹出框--%>
<div id="editGuru" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'更新用户信息'">
