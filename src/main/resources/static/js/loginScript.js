var app = angular.module("loginApp", []);



app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);



app.controller("loginController", function($http, $window, $location, $scope){


    $scope.login = function(){

    console.log($scope.user);

        $http({

            method : 'POST',
            url: "http://localhost:8080/hsa/users/loginUser",
            data: $scope.user
        }).then(function(response){
            if(response.data == "1"){
            $window.location.href ="/basicInfo.html"
            }
            else{
            window.alert("Incorrect Email or Password")}


        }).catch(function(error){

            console.error('Error:', error);
        })

    }
    



});