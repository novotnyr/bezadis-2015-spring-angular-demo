(function(angular) {
    angular
        .module("hateomat", ["ngResource"])
        .controller("HateController", HateController)
        .service("HateService", HateService)
    // ---------------------------

    var HateService = function($resource) {
        return $resource("/hates");
    }
    HateService.$inject = ["$resource"];

    //-----------------------------------

    var HateController = function($scope, HateService) {
        $scope.newHate = {};

        HateService.query(function (response) {
            $scope.hates = response;
        });

        $scope.addHate = function() {
        HateService
            .save($scope.newHate, function(newHate) {
                $scope.hates.push(newHate);
            })
        }
    }
    HateController.$inject = ["$scope", "HateService"];
    //-----------------------------------

})(angular);