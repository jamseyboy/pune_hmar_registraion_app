var app = angular.module("loginApp", []);



app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);



app.controller("loginController", function($http, $window, $location, $scope, $timeout){

    $scope.loading = false;
    $scope.isVisible = false;
    $scope.waitMessage = "Checking Credentials..";

    $scope.login = function(){

    $scope.loading = true;

    $timeout(function(){

        console.log($scope.user);

                $http({

                    method : 'POST',
                    url: "http://localhost:8080/hsa/users/loginUser",
                    data: $scope.user
                }).then(function(response){



                    if(response.data == "1"){
                    $scope.waitMessage = "Success"
                    $window.location.href ="/basicInfo.html"
                    }
                    else if(response.data == "0"){
                    $scope.isVisible = true
                    $scope.loading = false;
                    $scope.alertMessage = "Email ID " + $scope.user.email + " is not yet registered or Incorrect"

                    }else if(response.data == "10"){
                    $scope.isVisible = true;
                    $scope.loading = false;
                    $scope.alertMessage = "Incorrect password, please try again"
                    }
                    else{
                    $scope.isVisible = true;
                    $scope.loading = false;
                    $scope.alertMessage = "An error has occurred"
                    }


                }).catch(function(error){
                    $scope.isVisible = true
                    $scope.alertMessage = "Unknown Error"
                    console.error('Error:', error);
                })

        }, 2000);




    }
    



});