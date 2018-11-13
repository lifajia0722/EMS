<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<script>
    $(function () {
        $(function () {
            $("#courseDg").datagrid({
                url:'${pageContext.request.contextPath}/Course/findPage',
                toolbar:'#tb',
                rownumbers:true,
                pagination:true,
                pageNumber:1,
                pageSize:2,
                pageList:[2,4,6,8],
                height:200,
                fit:true,
                columns:[[
                    {
                        title:'cxf',
                        field:'cxf',
                        checkbox:true,
                    }, {
                        title:'id',
                        field:'id',
                        width:'200',

                    },{
                        title:'title',
                        field:'title',
                        width:'150',

                    },{
                        title:'flag',
                        field:'flag',
                        width:'100',

                    },{
                        title:'creatTime',
                        field:'creatTime',
                        width:'200',

                    },
                ]],
                onLoadSuccess:function () {
                    $('.operates').linkbutton();
                }
            });
        });

    });
    function add() {
        $("#saveCourse").dialog({
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:function () {
                    $("#saveCourseForm").form('submit',{
                        url:'${pageContext.request.contextPath}/Course/add',
                        success:function (result) {
                            var res=$.parseJSON(result);
                            if(res.success) {
                                //提示信息
                                $.messager.show({title: '消息', msg: '添加成功！！！'});
                            }else{
                                $.messager.show({title: '消息',msg:'添加失败！！！'});
                            }
                            //关闭窗口
                            $("#saveCourse").dialog('close');
                            //刷新datagrid
                            $("#courseDg").datagrid('reload');
                        }
                    });
                }
            },{
                text:'取消',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#saveCourse").dialog('close');
                }
            }
            ],
        });
    }
    function deleteCourse() {
        var row = $("#courseDg").treegrid('getSelected');
        $.ajax({
            url:'${pageContext.request.contextPath}/Course/delete',
            type:"POST",
            data:{id:row.id},
            traditional:true,
            success:function () {
                //消息提示
                $.messager.show({title:'提示',msg:"删除成功!!!"});
                //刷新datagrid
                $("#courseDg").datagrid('reload');
            },
            error:function () {
                //消息提示
                $.messager.show({title:'提示',msg:"删除失败!!!"});
                //刷新datagrid
                $("#courseDg").datagrid('reload');
            }
            });
    }
</script>
<table id="courseDg"></table>

<div id="tb">
    <a href="javascript:;" class="easyui-linkbutton" onclick="add()" data-options="iconCls:'icon-add',plain:true">添加</a>
    <a href="javascript:;" class="easyui-linkbutton" onclick="deleteCourse()" data-options="iconCls:'icon-remove',plain:true,">删除</a>
</div>

<div id="saveCourse" data-options="href:'${pageContext.request.contextPath}/back/course/courseSave.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'添加功课'"></div>