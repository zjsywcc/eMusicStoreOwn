<#include "template/header.ftl">






<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory Page</h1>

            <p class="lead">This is the product inventory page!</p>
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
        <#if products ??><#list products as product>
            <tr>
                <td><img src="/resources/images/${product.productId}.png" alt="image" style="width:100%"/></td>
                <td>${product.productName!""}</td>
                <td>${product.productCategory!""}</td>
                <td>${product.productCondition!""}</td>
                <td>${product.productPrice!""} USD</td>
                <td><a href="/productList/viewProduct/${product.productId}"><span class="glyphicon glyphicon-info-sign"></span></a>
                    <a href="/admin/productInventory/deleteProduct/${product.productId}"><span class="glyphicon glyphicon-remove"></span></a>
                    <a href="/admin/productInventory/editProduct/${product.productId}"><span class="glyphicon glyphicon-pencil"></span></a>
                </td>
            </tr>
        </#list></#if>

        </table>
        <a href="/admin/productInventory/addProduct" class="btn btn-primary">Add Product</a>
    <#include "template/footer.ftl">
