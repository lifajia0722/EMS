<%@page pageEncoding="UTF-8" isELIgnored="false"%>
    <div style="text-align: center">
        <form id="saveCourseForm" class="easyui-form" method="post" enctype="multipart/form-data">
            <div style="margin-top: 70px;">
                标题: <input type="text" name="title" class="easyui-textbox" >
            </div>
            <div style="margin-top: 20px;">
                级别:
                <select class="easyui-combobox" name="flag"  data-options="width:170">
                    <option value="Y">必修</option>
                    <option value="N">选修</option>
                </select>
            </div>
            <div style="margin-top: 20px;">
                日期: <input  id="dd" name="creatTime" type= "text" class= "easyui-datebox" >
            </div>

        </form>
    </div>
