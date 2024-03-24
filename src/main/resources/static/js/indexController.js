var app = angular.module("puneHmarApp",[]);

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);


app.controller("puneHmarController", function($scope,$http, $location, $window){





    $scope.register = function(){
        $window.location.href = '/registerPage.html'
    }

    $scope.login = function(){
        $window.location.href = '/loginPage.html'
    }



});


