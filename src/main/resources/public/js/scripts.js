var app = angular.module('myApp', []);
app.controller('studentsCtrl', function($scope, $http) {
    $scope.students = [];
    $http.get("webservice/students").success(function (data) {

        $scope.students = data;
        
    });

});

