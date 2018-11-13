<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function(){
        $("#queryAlbum").form('load','${pageContext.request.contextPath}/album/findOne?id=${param.id}');
    });
    $("#queryAlbum").form('submit',{
        url: '${pageContext.request.contextPath}/album/findOne?id=${param.id}',
        onLoadSuccess:function (r) {
            $('#img').attr({'src':'${pageContext.request.contextPath}'+r.coverImg+''});
        }
    })
</script>
<form id="queryAlbum" class="easyui-form" method="post" enctype="multipart/form-data">
    <div style="text-align: center;margin:30px 0px;padding:10px;">
    专辑名称:<input type="text" readonly="readonly" name="title"><br><br>
    专辑作者: <input type="text" readonly="readonly" name="author"><br><br>
    专辑译者: <input type="text" readonly="readonly" name="broadCast"><br><br>
    发布时间: <input type="text" readonly="readonly" name="publishDate"><br><br>
    专辑集数: <input type="text" readonly="readonly" name="count"><br><br>
    专辑封面: <img id="img" src=""/><br><br>
    专辑简介: <input type="text" readonly="readonly" name="brief"><br><br>
    推荐星级: <input type="text" readonly="readonly" name="star">
    </div>
</form>
