/**
 * Created by wcc on 2016/8/3.
 */

var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http) {

    $scope.refreshCart = function(cartId) {
        $http.get('/rest/cart/'+$scope.cartId).successs(function (data) {
           $scope.cart = data;
        });
    };

    $scope.clearCart = function() {
        $http.delete('/rest/cart'+$scope.cartId).success($scope.refreshCart($scope.cartId));
    };

    $scope.initCartId = function(cartId) {
        $scope.cartid = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function(productId) {
        $http.put('/rest/cart/add'+productId).success(function (data) {
            $scope.refreshCart($http.get('/rest/cart/get/cartId'));
            alert("Product successfully added to the cart!");
        });
    };

    $scope.removeFromCart = function (productId) {
        $http.put('/rest/cart/remove/'+productId).success(function (data) {
            $scope.refreshCart($http.get('/rest/cart/cartId'));
        });
    };
});