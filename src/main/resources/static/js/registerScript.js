var app = angular.module("registerApp", []);

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);



app.controller("registerController", function($scope, $window, $http,$timeout, $location){
    $scope.waitMessage="Loading...."
    $scope.isVisible=false;
    $scope.loading = false;

    

    $scope.register = function(){
            if($scope.user && $scope.user.password == $scope.user.confirmPassword){
                $scope.isVisible = false;
                $scope.loading =true;
                    $scope.userData = {
                        email : $scope.user.email,
                        password : $scope.user.password,
                        status : $scope.user.status
                        }
                        $timeout(function(){
                            $scope.waitMessage="Processing...."
                            $http({
                                method: 'POST',
                                url: "http://localhost:8080/hsa/users/registerUser",
                                data: $scope.userData
                            }).then(function(response){
    
                                if(response.data != null && response.data == "1"){
                                    $scope.waitMessage="Success"
                                    localStorage.setItem('email', $scope.userData.email)
                                    $window.location.href="/basicInfo.html"
                                }
                                else if(response.data != null && response.data == "0"){
                                    $scope.loading =false;
                                    $scope.isVisible = true;
                                    console.log(response.data)
                                    $scope.alertMessage = "email id " + $scope.userData.email + " already exist try another one";
                                }
                                else{
                                    $scope.loading=false;
                                    $scope.isVisible = true;
                                    console.log(error.data)
                                    $scope.alertMessage = "An Error has occurred";
                                }
    
                            }).catch(function(error){
                                $scope.loading=false;
                                $scope.isVisible = true;
                                console.log(error.data)
                                $scope.alertMessage = "An Error has occurred";
                            })

                        },2000);

                        
                    console.log($scope.userData);
            }else if($scope.user && $scope.user.password != $scope.user.confirmPassword){
                    $scope.isVisible = true;
                    $scope.alertMessage = "Password does not Match !!!";
                    console.log($scope.user);
            }else{
                    $scope.isVisible = true;
                    $scope.alertMessage = "Something is wrong Contact admin !!!";
            }
            }



});