<#include "template/header.ftl">

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>

            <p class="lead">Here is the detail information of the product!</p>
        </div>

        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="/resources/images/${product.productId}.png" alt="image" style="width:100%"/>
                </div>

                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productDescription}</p>
                    <p>
                        <strong>Manufacturer</strong>: ${product.productManufacturer}
                    </p>
                    <p>
                        <strong>Category</strong>: ${product.productCategory}
                    </p>
                    <p>
                        <strong>Condition</strong>: ${product.productCondition}
                    </p>
                    <h4>${product.productPrice} USD</h4>
                    <br>
                    <#if currentUser ??><#assign role="${currentUser}" /></#if>
                    <#assign url="/productList"/>
                    <#if role ??><#if role="admin">
                        <#assign url="/admin/productInventory"/>
                    </#if></#if>
                    <p ng-controller="cartCtrl">
                        <a href="${url}" class="btn btn-default">Back</a>
                        <a href="#" class="btn btn-warning btn-lg" ng-click="addToCart(${product.productId})"><span class="glyphicon glyphicon-shopping-cart"></span>Order Now</a>
                        <a href="/cart" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
                    </p>
                </div>
            </div>
        </div>


<script src="/resources/js/controller.js"/>
<#include "template/footer.ftl">
