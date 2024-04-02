var app = angular.module("SaveUserDetailsApp",[]);

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);


app.controller("submitUserController", function($scope,$http, $location, $window){

    $scope.basicInfo ={};

    $scope.isVisible = false;

    $scope.submitUser = function(){
        $scope.basicData={
                    firstName : $scope.basicInfo.firstName,
                    lastName : $scope.basicInfo.lastName,
                    email : localStorage.getItem('email'),
                    gender : $scope.basicInfo.gender,
                    phoneNumber : $scope.basicInfo.phoneNumber,
                    dob : formatDate($scope.basicInfo.dob)
                    };
        $scope.isVisible = true;



    }

    $scope.nextPage = function(){


        $scope.basicInfo.dob = formatDate($scope.basicInfo.dob);
        console.log($scope.basicInfo);

        $http({

            method: 'POST',
            url: 'http://localhost:8080/hsa/users/saveUser',
            data: $scope.basicData
        }).then(function saveUser(response){

            localStorage.setItem('userId', JSON.stringify(response.data));
            localStorage.removeItem('email');
            $window.location.href = '/addressInfo.html';
        });
        

    
        
    }

    

    function formatDate(date) {
        var yyyy = date.getFullYear().toString();
        var mm = (date.getMonth() + 1).toString().padStart(2, '0');
        var dd = date.getDate().toString().padStart(2, '0');
        return yyyy + '-' + mm + '-' + dd;
    }

});