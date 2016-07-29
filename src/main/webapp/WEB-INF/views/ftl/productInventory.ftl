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
        <#if products ??><#list products as list>
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
        <a href="/admin/productInventory/addProduct" class="btn btn-primary">Add Product</a>
    <#include "template/footer.ftl">
