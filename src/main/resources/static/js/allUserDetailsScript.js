var app = angular.module("allUserDetailsApp",[]);



app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);


app.controller("indexScript", function($scope, $http, $window){

    $scope.getUserDetails = function(){

        $scope.userId = JSON.parse(localStorage.getItem('userId'));
        console.log("This is the user ID " + $scope.userId)
        $http({

            method: 'GET',
            url: 'http://localhost:8080/hsa/users'
        }).then(function(response){

            $scope.userDetails = response.data;
            $scope.isVisible=true;
        });
    };

});

app.controller("addressCtrl", function($scope, $http, $window){

    $scope.getAddressDetails = function(){
        $http({

            method: 'GET',
            url: 'http://localhost:8080/hsa/address'
        }).then(function(response){

            $scope.addressDetails = response.data;
            $scope.isVisible=true;
        });
    };

});
