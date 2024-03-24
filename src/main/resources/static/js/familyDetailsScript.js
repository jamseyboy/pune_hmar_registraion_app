var app = angular.module("SaveFamilyDetailsApp",[]);

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);


app.controller("submitFamilyController", function($scope,$http, $location, $window){

    $scope.familyInfo ={};
    $scope.familyInfo2={};
    var tempFamilyList = localStorage.getItem('families');
    var tempFamily = tempFamilyList ? JSON.parse(tempFamilyList):[];
    var updatetempFamilyList={};
    $scope.isVisible = false;






    $scope.submitFamily = function(){

        $scope.familyInfo.dob = formatDate($scope.familyInfo.dob);
        console.log($scope.familyInfo);
        tempFamily.push($scope.familyInfo);
        updatetempFamilyList = JSON.stringify(tempFamily);
        localStorage.setItem('families', updatetempFamilyList);
        showFamilyDetails();
        $scope.isVisible= true;
        
    }








    $scope.addMoreFamily = function(){

        $window.location.href = '/family.html';

    }

    $scope.clearList = function(){

    localStorage.removeItem('families');
    $window.location.href = '/family.html';

    }




    function formatDate(date) {
        var yyyy = date.getFullYear().toString();
        var mm = (date.getMonth() + 1).toString().padStart(2, '0');
        var dd = date.getDate().toString().padStart(2, '0');
        return yyyy + '-' + mm + '-' + dd;
    }

    





    function showFamilyDetails(){

        $scope.familyDetails = JSON.parse(localStorage.getItem('families'));
        console.log($scope.familyDetails);

    }






    $scope.finish = function(){

        var list = JSON.parse(localStorage.getItem('families'));
        $scope.userId = JSON.parse(localStorage.getItem('userId'));

        list.forEach(function(obj){
            
            $scope.family = obj;

            $http({

                method: 'POST',
                url: 'http://localhost:8080/hsa/family/saveFamily?userId=' + $scope.userId,
                data: $scope.family
            }).then(function saveUser(response){

    
                localStorage.removeItem('families');
                localStorage.removeItem('userId');
                $window.location.href = '/allUserDetails.html';
                
            }).catch(function(error){
                console.error('Error:', error);

        });
    });
    }



});