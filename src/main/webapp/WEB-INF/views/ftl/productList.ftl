    <#include "template/header.ftl">






    <div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Products</h1>

            <p class="lead">Checkout all the awesome products available now!</p>
        </div>

    <table class="table table-striped table-hover">
        <thead>
        <tr class="bg-success">
            <th>Photo Thumb</th>
            <th>Product Name</th>
            <th>Category</th>
            <th>Condition</th>
            <th>Price</th>
            <th></th>
        </tr>
        </thead>
        <#if productList??><#list productList as list>
        <tr>
            <td><img src="#" alt="image"/></td>
            <td>${list.productName}</td>
            <td>${list.productCategory}</td>
            <td>${list.productCondition}</td>
            <td>${list.productPrice} USD</td>
            <td><a href="/productList/viewProduct/${list.productId}"><span class="glyphicon glyphicon-info-sign"></span></a>
            </td>
        </tr>
    </#list></#if>

    </table>

    <#include "template/footer.ftl">
