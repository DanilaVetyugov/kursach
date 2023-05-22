(function () {
    angular
        .module('kursach-front', ['ngRoute', 'ngStorage']);



})();

angular.module('kursach-front').controller('indexController', function ($rootScope, $scope, $http, $location, $localStorage) {
            $scope.tryToFind = function () {
                console.log('AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA');
                $http({
                    url:'http://localhost:8189/kursach/student/'+$scope.user.username+'&'+$scope.user.userSurName,
                    method:'GET'
                }).then(function(response){
                    $scope.student = response.data;
                });

            };


     });

