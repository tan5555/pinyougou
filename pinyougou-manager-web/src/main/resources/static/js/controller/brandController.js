app.controller('brandController', function($scope, $http,$controller,brandService) {
		
		//继承，实质就是把继承过来的js中的$scope让他和本js中的$scope相等，这实质是伪继承
	$controller('baseController',{$scope:$scope});

    //查询所有
    $scope.finAll = function () {
        brandService.findAllBrand()
    }

    //查询条件
    $scope.searchEntity = {}
    $scope.findPage = function (page,size) {
        brandService.findPageBrand(page,size,$scope.searchEntity).success(function (response) {
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