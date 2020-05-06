 //控制层 
app.controller('sellerController' ,function($scope,$controller   ,sellerService){	
	
	$controller('baseController',{$scope:$scope});//继承

    //查询所有
    $scope.finAll = function () {
        sellerService.findAllSeller()
    }

    //查询条件
    $scope.searchEntity = {}
    $scope.findPage = function (page,size) {
        sellerService.findPageSeller(page,size,$scope.searchEntity).success(function (response) {
            $scope.list=response.rows
            $scope.paginationConf.totalItems=response.total
        })
    }

    //添加和修改
    $scope.save = function () {
        if ($scope.entity.id != null){
            sellerService.update($scope.entity).success(function (response) {
                if (response==1){
                    $scope.reloadList()
                    alert("修改成功")
                }else {
                    alert("修改失败")
                }
            })
        }else {
            sellerService.add($scope.entity).success(function (response) {
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
        sellerService.findOne(id).success(function (response) {
            $scope.entity=response
        })
    };

    //审核
	$scope.updateStatus=function (sellerId,status) {
        sellerService.updateStatus(sellerId,status).success(function (response) {
			if (response==1){
                alert("审核成功")
                $scope.reloadList()
			}else {
				alert("审核失败")
			}
        })
    }

    //删除
    $scope.del = function () {
        sellerService.del($scope.ids).success(function (response) {
            if (response==1){
                $scope.reloadList()
                alert("删除成功")
            }else {
                alert("删除失败")
            }
        })
    }
    
});	
