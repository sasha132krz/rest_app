var app = angular.module('piecesOfArt', []);

app.controller("PiecesOfArtController", function ($scope, $http) {

    $scope.getPieces = function () {
        $http.get('/public/rest/pieces_of_art').success(function (data, status, headers, config) {
            $scope.piecesList = data;
            for (var i = 0; i < $scope.piecesList.length; i++) {
                $scope.piecesList[i].edit = 0;
            }
        }).error(function (data, status, headers, config) {
            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };

    $scope.delete = function (id) {
        $http.delete('/public/rest/pieces_of_art/' + id).success(function (data, status, headers, config) {
            for (var i = 0; i < $scope.piecesList.length; i++) {
                var j = $scope.piecesList[i];
                if (j.id === id) {
                    $scope.piecesList.splice(i, 1);
                    break;
                }
            }
        }).error(function (data, status, headers, config) {
            console.error(status, data, headers);
        });
    };

    $scope.addPiece = function () {
        $http.post('/public/rest/pieces_of_art/' + $scope.name + "/" + $scope.type + "/" + $scope.owner + "/" + $scope.year + "/" + $scope.price).success(function (data, status, headers, config) {
            $scope.piecesList.splice(0, 0, data);
            $scope.getPieces();
        }
        ).error(function (data, status, headers, config) {
            console.error(status, data, headers);
        });
    };
});