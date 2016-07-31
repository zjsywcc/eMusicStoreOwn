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
        <#if products??><#list products as product>
        <tr>
            <td><img src="/resources/images/${product.productId}.png" alt="image" style="width:100%"/></td>
            <td>${product.productName}</td>
            <td>${product.productCategory}</td>
            <td>${product.productCondition}</td>
            <td>${product.productPrice} USD</td>
            <td><a href="/productList/viewProduct/${product.productId}"><span class="glyphicon glyphicon-info-sign"></span></a>
            </td>
        </tr>
    </#list></#if>

    </table>

    <#include "template/footer.ftl">
