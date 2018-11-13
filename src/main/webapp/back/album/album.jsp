<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $('#albumDg').treegrid({
            url:'${pageContext.request.contextPath}/album/findAll',
            toolbar: '#tdAlbum',
            animate:true,
            fit:true,
            fitColumns: true,//设置自动适应大小*/
            striped: true,
            idField:'id',
            treeField:'title',
            onlyLeafCheck:true,
            toggle:true,
            columns:[[
                {field:'title',title:'名字',width: 80, align: 'left',},
                {field:'size',title:'章节大小',width: 122, align: 'center',},
                {field:'duration',title:'章节时长',width: 122, align: 'center',},
                {field:'downPath',title:'下载路径',width: 122, align: 'center',},
                {field:'uploadTime',title:'上传时间',width: 122, align: 'center',}
            ]],
        });
    })


    //添加专辑
    function addAlbum(){
            $("#albumSeve").dialog({
                href:"${pageContext.request.contextPath}/back/album/AlbumSave.jsp",
                width:500,
                height:400,
                title:'添加专辑',
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:function () {
                        $("#saveAlbumForm").form('submit',{
                            url:'${pageContext.request.contextPath}/album/add',
                            success:function (result) {
                                var res=$.parseJSON(result);
                                if(res.success) {
                                    //提示信息
                                    $.messager.show({title: '消息', msg: '添加成功！！！'});
                                }else{
                                    $.messager.show({title: '消息',msg:'添加失败！！！'});
                                }
                                //关闭窗口
                                $("#albumSeve").dialog('close');
                                //刷新datagrid
                                $("#albumDg").treegrid('reload');
                            }
                        });
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function () {
                        $("#albumSeve").dialog('close');
                    }
                }
                ],
            })
    }
   function details(){
       var select = $("#albumDg").treegrid('getSelected');
       if(select==null){
           $.messager.show({title: '消息', msg: '请选择一行！！！'});
       }if(select!=null && select.children!=null){
           $("#albumMsg").dialog({
               href:"${pageContext.request.contextPath}/back/album/albumMsg.jsp?id="+select.id,
               width:450,
               height:550,
               title:'专辑详情',
           });

       }if(select!=null && select.children==null) {
           $.messager.show({title: '消息', msg: '请选择专辑！！！'});
       }
   }
   
   function addChapter() {
       var select = $("#albumDg").treegrid('getSelected');
       if(select==null){
           $.messager.show({title: '消息', msg: '请选择一行！！！'});
       }if(select!=null && select.children!=null){
           $("#chapterSeve").dialog({
               href:"${pageContext.request.contextPath}/back/album/chapter.jsp?album_id="+select.id,
               width:500,
               height:400,
               title:'添加音频',
               buttons:[{
                   text:'保存',
                   iconCls:'icon-save',
                   handler:function () {
                       $("#chapterForm").form('submit',{
                           url:'${pageContext.request.contextPath}/chapter/add',
                           success:function (result) {

                               var res=$.parseJSON(result);
                               alert(res);
                               if(res.success) {
                                   //提示信息
                                   $.messager.show({title: '消息', msg: '添加成功！！！'});
                               }else{
                                   $.messager.show({title: '消息',msg:'添加失败！！！'});
                               }
                               //关闭窗口
                               $("#chapterSeve").dialog('close');
                               //刷新datagrid
                               $("#albumDg").treegrid('reload');
                           }
                       });
                   }
               },{
                   text:'取消',
                   iconCls:'icon-cancel',
                   handler:function () {
                       $("#chapterSeve").dialog('close');
                   }
               }
               ],
           })
       }if(select!=null && select.children==null) {
           $.messager.show({title: '消息', msg: '请选择专辑！！！'});
       }

   }

    function selectChapter() {

        var select = $("#albumDg").treegrid('getSelected');
        if (select==null||select.downPath==undefined) {
            $.messager.show({title: '提示', msg: "请选择你要下载的音频"});
        } else {
            window.location="${pageContext.request.contextPath}/chapter/download?fileName="+select.downPath;
        }

    }

</script>
<table id="albumDg"></table>

<div id="tdAlbum">
    <a href="#" class="easyui-linkbutton" onclick="details()"  id='albumMessage' data-options="iconCls:'icon-reload',plain:true,">专辑详情</a>
    <a href="#" class="easyui-linkbutton" onclick="addAlbum()" data-options="iconCls:'icon-edit',plain:true,">添加专辑</a>
    <a href="#" class="easyui-linkbutton" onclick="addChapter()" data-options="iconCls:'icon-add',plain:true,">添加音频</a>
    <a href="#" class="easyui-linkbutton" onclick="selectChapter()" data-options="iconCls:'icon-undo',plain:true,">下载音频</a>
</div>
<div id="albumMsg"></div>


<%--专辑详情--%>
<div id="albumMsg"></div>

<%--添加专辑--%>
<div id="albumSeve"></div>

<%--添加音频--%>
<div id="chapterSeve"></div>