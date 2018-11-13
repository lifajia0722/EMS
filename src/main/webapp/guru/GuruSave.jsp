<%@page pageEncoding="UTF-8" isELIgnored="false"%>
    <div style="text-align: center">
        <form id="saveGuruForm" class="easyui-form" method="post" enctype="multipart/form-data">
            <div style="margin-top: 70px;">
                法名: <input type="text" name="name" class="easyui-textbox" >
            </div>
            <div style="margin-top: 20px;">
                头像上传: <input name="headPic1" class="easyui-filebox" style="width:160px">
            </div>
            <div style="margin-top: 20px;">
                性别:
                <select class="easyui-combobox" name="sex"  data-options="width:170">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
            <div style="margin-top: 20px;">
                状态:
                <select class="easyui-combobox" name="status"  data-options="width:170">
                    <option value="Y">YES</option>
                    <option value="N">NO</option>
                </select>
            </div>
        </form>
    </div>
