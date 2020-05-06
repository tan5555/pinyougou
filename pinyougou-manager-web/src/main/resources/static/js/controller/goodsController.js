 //控制层 
app.controller('goodsController', function($scope, $controller,$location, goodsService, itemCatService) {
	
	$controller('baseController',{$scope:$scope});//继承

    //查询条件
    $scope.searchEntity = {}
    $scope.findAllBrand = function (page,size) {
        brandService.findAllBrand(page,size,$scope.searchEntity).success(function (response) {
            $scope.list=response.rows
            $scope.paginationConf.totalItems=response.total
        })
    }

    //添加和修改
    $scope.save = function () {
        if ($scope.entity.id != null){
            brandService.update($scope.entity).success(function (response) {
                if (response==1){
                    $scope.reloadList()
                    alert("修改成功")
                }else {
                    alert("修改失败")
                }
            })
        }else {
            brandService.add($scope.entity).success(function (response) {
                if (response==1){
                    $scope.reloadList()
                    alert("新增成功")
                }else {
                    alert("新增失败")
                }
            })
        }

    }

    //更新查询
    $scope.findOne=function(id){
        brandService.findOne(id).success(function (response) {
            $scope.entity=response
        })
    };

    //删除
    $scope.del = function () {
        brandService.del($scope.ids).success(function (response) {
            if (response==1){
                $scope.reloadList()
                alert("删除成功")
            }else {
                alert("删除失败")
            }
        })
    }
});	
