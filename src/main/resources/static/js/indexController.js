var app = angular.module("puneHmarApp",[]);

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);


app.controller("puneHmarController", function($scope,$http, $location, $window){


    $scope.registerFresh = function(){

        localStorage.setItem('membershipStatus', 'fresh')
       $window.location.href = '/registerPage.html'
    }


    $scope.registerRenew = function(){
        localStorage.setItem('membershipStatus', 'regRenew' )
        $window.location.href = '/registerPage.html'
    }

    $scope.renewMembership = function(){
       
        localStorage.setItem('membershipStatus', 'renew')
        $window.location.href = '/loginPage.html'
    }

    $scope.editUserDetails = function(){

        localStorage.setItem('membershipStatus', 'edit')
        $window.location.href = '/editUserDetails.html'
    }



    

});