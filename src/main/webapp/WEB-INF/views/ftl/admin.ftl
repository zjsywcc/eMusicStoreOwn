<#include "template/header.ftl">

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">This is the adminstrator page!</p>
        </div>
        <#if currentUser ??>
            <h2>
                Welcome: ${currentUser} | <a href="/j_spring_security_logout">Logout</a>
            </h2>
        </#if>
        <h3>
            <a href="/admin/productInventory">Product Inventory</a>
        </h3>

        <p>Here you can view, check and modify the product inventory!</p>
    <#include "template/footer.ftl">
