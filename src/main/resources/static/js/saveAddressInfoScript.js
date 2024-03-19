var app = angular.module("SaveAddressDetailsApp",[]);

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);


app.controller("submitAddressController", function($scope, $http, $location, $window){

    $scope.addressInfo ={};
    $scope.isVisible = false;

    $scope.submitAddress = function(){

        console.log($scope.addressInfo);
        $scope.isVisible = true;
    }

    $scope.nextPage = function(){


        $scope.userId = JSON.parse(localStorage.getItem('userId'));

        $http({
            method: 'POST',
            url: 'http://localhost:8080/hsa/address/saveAddress?userId=' + $scope.userId ,
            data: $scope.addressInfo
        }).then(function saveAddress(response){
            console.log("Save Successfully");
            $window.location.href = '/emergencyContact.html';
        }).catch(function(error){
        console.error('Error:', error);



        });

    }



});