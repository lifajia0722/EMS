<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center;">
    <form id="editUserForm" class="easyui-form" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 70px;">
            账&nbsp;&nbsp;&nbsp;号: <input type="text" readonly="readonly" name="username" value="${sessionScope.login.username}" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>
        <div style="margin-top: 20px;">
            姓&nbsp;&nbsp;&nbsp;名: <input type="text" readonly="readonly" name="name" value="${sessionScope.login.name}"  class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            新密码:<input type="text" name="password"  class="easyui-passwordbox">
        </div>
    </form>
</div>