<#include "template/header.ftl">


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <form action="${springMacroRequestContext.contextPath}/admin/productInventory/addProduct" method="post"
                    enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Name</label>
                <@spring.bind "product.productName" /><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                <input id="name" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
            </div>

            <div class="form-group">
                <label for="category">Category</label>
                <label class="checkbox-inline"><@spring.formRadioButtons "product.productCategory", category, '</label><label class="checkbox-inline">'/></label>
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <@spring.bind "product.productDescription" />
                <textarea id="description" class="form-control" name="${spring.status.expression}" >${spring.status.value?default("")}</textarea>
            </div>

            <div class="form-group">
                <label for="price">Price</label>
                <@spring.bind "product.productPrice" /><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                <input id="price" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
            </div>

            <div class="form-group">
                <label for="condition">Condition</label>
                <label class="checkbox-inline"><@spring.formRadioButtons "product.productCondition", condition, '</label><label class="checkbox-inline">'/></label>
            </div>

            <div class="form-group">
                <label for="status">Status</label>
                <label class="checkbox-inline"><@spring.formRadioButtons "product.productStatus", status, '</label><label class="checkbox-inline">'/></label>
            </div>

            <div class="form-group">
                <label for="unitInStock">Unit In Stock</label>
                <@spring.bind "product.unitInStock" /><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                <input id="unitInStock" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
            </div>

            <div class="form-group">
                <label for="manufacturer">Manufacturer</label>
                <@spring.bind "product.productManufacturer" />
                <input id="manufacturer" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
            </div>

            <div class="form-group">
                <label class="control-label" for="productImage">Upload Picture</label>
                <@spring.bind "product.productImage" />
                <input id="productImage" type="file" class="form:input-large" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
            </div>
            <br><br>
            <input type="submit" value="submit" class="btn btn-default">
            <a href="/admin/productInventory" class="btn btn-default">Cancel</a>
        </form>







    <#include "template/footer.ftl">
