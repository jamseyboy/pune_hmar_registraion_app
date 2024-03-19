var app = angular.module("SaveEmContactDetailsApp",[]);

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);


app.controller("submitEmContactController", function($scope, $http, $location, $window){

    $scope.emContactInfo ={};
    $scope.isVisible = false;

    $scope.submitEmContact = function(){

        console.log($scope.emContactInfo);
        $scope.isVisible = true;
    }

    $scope.nextPage = function(){


        $scope.userId = JSON.parse(localStorage.getItem('userId'));

        $http({
            method: 'POST',
            url: 'http://localhost:8080/hsa/emergencyContact/saveEmergencyContact?userId=' + $scope.userId ,
            data: $scope.emContactInfo
        }).then(function saveAddress(response){
            $window.location.href = '/family.html';
        }).catch(function(error){
        console.error('Error:', error);

        });

    }



});