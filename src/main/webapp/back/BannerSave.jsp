<%@page pageEncoding="UTF-8" isELIgnored="false"%>
    <div style="text-align: center">
        <form id="saveBannerForm" class="easyui-form" method="post" enctype="multipart/form-data">
            <div style="margin-top: 70px;">
                标题: <input type="text" name="title" class="easyui-textbox" >
            </div>
            <div style="margin-top: 20px;">
                图片上传: <input name="imgPath1" class="easyui-filebox" style="width:160px">
            </div>
            <div style="margin-top: 20px;">
                描述: <input type="text" name="descend"  class="easyui-textbox">
            </div>
            <div style="margin-top: 20px;">
                状态:
                <select class="easyui-combobox" name="status"  data-options="width:170">
                    <option value="Y">YES</option>
                    <option value="N">NO</option>
                </select>
            </div>
            <div style="margin-top: 20px;">
                日期: <input  id="dd" name="date" type= "text" class= "easyui-datebox" >
            </div>

        </form>
    </div>
