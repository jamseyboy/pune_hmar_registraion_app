var app = angular.module("puneHmarApp",[]);

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);


app.controller("puneHmarController", function($scope,$http, $location, $window){





    $scope.register = function(){
        localStorage.setItem('membershipStatus', 'register' )
        $window.location.href = '/registerPage.html'
    }

    $scope.renewMembership = function(){
       
        localStorage.setItem('membershipStatus', 'renew')
        $window.location.href = '/loginPage.html'
    }

    $scope.editUserDetails = function(){


        localStorage.setItem('membershipStatus', 'edit')
        $window.location.href = '/loginPage.html'
    }


});


