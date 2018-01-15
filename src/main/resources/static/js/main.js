angular.module("springDemo",[]).
    controller('AppCtrl',function ($scope,$http) {
        $http.get("http://localhost:8099/api/stackoverflow").then(
            function (response) {
                $scope.websites = response.data;
            }
        );
});