<%@page pageEncoding="UTF-8" isELIgnored="false"%>

<script>
    $(function () {
        $('#bannerDg').edatagrid({
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
            url:'${pageContext.request.contextPath}/banner/findPage',
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
                    title:'title',
                    field:'title',
                    width:'100',
                    editor:'text',
                },{
                    title:'imgPath',
                    field:'imgPath',
                    width:'150',
                    editor:'text',
                },{
                    title:'descend',
                    field:'descend',
                    width:'200',
                    editor:'text',
                },{
                    title:'status',
                    field:'status',
                    width:'100',
                    editor:'text',
                },{
                    title:'date',
                    field:'date',
                    width:'200',
                    editor:'datebox',
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
                    '<td rowspan=2 style="border:0"><img src="../' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>title: ' + rowData.title + '</p>' +
                    '<p>status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            onLoadSuccess:function () {
                $('.operates').linkbutton();
            }

        });
        $("#bannerDg").edatagrid('disableEditing');

    });
    //删除
    function delRow(id) {
        $.post('${pageContext.request.contextPath}/banner/delete',{"id":id},function () {
            $.messager.show({title: '消息', msg: '删除成功！！！'});
            $("#bannerDg").datagrid('reload');
        });
    }
    /*function guid() {
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
            var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
            return v.toString(16);
        });
    }
    function add() {
        $("#bannerDg").edatagrid('addRow',{
            row:{
                id:guid()
            }
        });
    }*/
    function add() {
        $("#saveBanner").dialog({
            title:'保存用户信息',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:function () {
                    $("#saveBannerForm").form('submit',{
                        url:'${pageContext.request.contextPath}/banner/add',
                        success:function (result) {
                            var res=$.parseJSON(result);
                            if(res.success) {
                                //提示信息
                                $.messager.show({title: '消息', msg: '添加成功！！！'});
                            }else{
                                $.messager.show({title: '消息',msg:'添加失败！！！'});
                            }
                            //关闭窗口
                            $("#saveBanner").dialog('close');
                            //刷新datagrid
                            $("#bannerDg").datagrid('reload');
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
    //修改事件
    function update(id) {
        $("#editBanner").dialog({
            title:'修改用户信息',
            href:'${pageContext.request.contextPath}/back/edit.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:function () {
                    $("#editBannerForm").form('submit',{
                        url:'${pageContext.request.contextPath}/banner/update',
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
                            $("#editBanner").dialog('close');
                            //刷新datagrid
                            $("#bannerDg").datagrid('reload');
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
    function openBanner() {
       $("#bannerDg").edatagrid('enableEditing');
    }
</script>
<table id="bannerDg"></table>

<div id="tb">
    <a href="javascript:;" class="easyui-linkbutton" onclick="add()" data-options="iconCls:'icon-add',plain:true">添加</a>
    <%--<a href="javascript:;" class="easyui-linkbutton" onclick="openBanner()" data-options="iconCls:'icon-add',plain:true">开启控件</a>--%>
    <%--<a href="javascript:;" class="easyui-linkbutton" onclick="deleteAll()" data-options="iconCls:'icon-remove',plain:true">批量删除</a>--%>
</div>
<%--添加弹出框--%>
<div id="saveBanner" data-options="href:'${pageContext.request.contextPath}/back/BannerSave.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'添加图片'"></div>

<%--修改弹出框--%>
<div id="editBanner" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'更新用户信息'">
