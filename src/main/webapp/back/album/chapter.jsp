<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center">
    <form id="chapterForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 50px">
            <input type="hidden" name="id">
        </div>
        <div style="margin-top: 15px">
            章节名称：<input type="text" class="easyui-textbox" name="title">
        </div>
        <div style="margin-top: 15px">
            上传时间：<input type="text" class="easyui-datebox" name="uploadTime">
        </div>
        <div style="margin-top: 15px">
            上传音频：<input class="easyui-filebox" name="downPath1" data-options="buttonText:'点我选择'">
        </div>
        <div style="margin-top:10px">
            <input type="hidden" name="album_id" value="${param.album_id}">
        </div>

    </form>
</div>
