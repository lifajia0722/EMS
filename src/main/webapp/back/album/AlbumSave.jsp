<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<form id="saveAlbumForm" class="easyui-form" method="post" enctype="multipart/form-data">
    <div style="text-align: center;margin:30px 0px;padding:10px;">
        专辑名称:<input type="text" class="easyui-textbox"  name="title"><br><br>
        专辑作者: <input type="text" class="easyui-textbox" name="author"><br><br>
        专辑译者: <input type="text" class="easyui-textbox" name="broadCast"><br><br>
        发布时间: <input type="text" class= "easyui-datebox"  name="publishDate"><br><br>
        专辑集数: <input type="text" class="easyui-textbox" name="count"><br><br>
        专辑封面: <input name="coverImg1" class="easyui-filebox" style="width:170px"><br><br>
        专辑简介: <input type="text" class="easyui-textbox" name="brief"><br><br>
        推荐星级: <input type="text" class="easyui-textbox" name="star">
    </div>
</form>
