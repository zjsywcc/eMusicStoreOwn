<#include "template/header.ftl">

<div class="container-wrapper">
    <div class="container">
        <div class="login-box">

            <h2>Login with Username and Password</h2>

            <#if msg??>
                <div class="msg">${msg}</div>
            </#if>

            <form name="loginForm" action="/j_spring_security_check" method="post">
                <#if error??>
                    <div class="error" style="color: #ff0000">${error}</div>
                </#if>
                <div class="form-group">
                    <label for="username">User: </label>
                    <input type="text" id="username" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="password">Password: </label>
                    <input type="password" id="password" name="password" class="form-control"/>
                </div>

                <input type="submit" value="submit" class="btn btn-default">

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </div>
</div>
<#include "template/footer.ftl">