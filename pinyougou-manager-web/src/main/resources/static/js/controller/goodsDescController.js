 //控制层 
app.controller('goodsDescController' ,function($scope,$controller   ,goodsDescService){	
	
	$controller('baseController',{$scope:$scope});//继承

    //查询条件
    $scope.searchEntity = {}
    $scope.findAllBrand = function (page,size) {
        goodsDescService.findAllBrand(page,size,$scope.searchEntity).success(function (response) {
            $scope.list=response.rows
            $scope.paginationConf.totalItems=response.total
        })
    }
	
	//查询实体 
	$scope.findOne=function(id){				
		goodsDescService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}

    //添加和修改
    $scope.save = function () {
        if ($scope.entity.id != null){
            goodsDescService.update($scope.entity).success(function (response) {
                if (response==1){
                    $scope.reloadList()
                    alert("修改成功")
                }else {
                    alert("修改失败")
                }
            })
        }else {
            goodsDescService.add($scope.entity).success(function (response) {
                if (response==1){
                    $scope.reloadList()
                    alert("新增成功")
                }else {
                    alert("新增失败")
                }
            })
        }

    }
	
	 
	//批量删除 
    $scope.del = function () {
        goodsDescService.del($scope.ids).success(function (response) {
            if (response==1){
                $scope.reloadList()
                alert("删除成功")
            }else {
                alert("删除失败")
            }
        })
    }

    //搜索查询
	$scope.searchEntity={};//定义搜索对象
    $scope.findAllBrand = function (page,size) {
        goodsDescService.findAllBrand(page,size,$scope.searchEntity).success(function (response) {
            $scope.brandList=response.rows
            $scope.paginationConf.totalItems=response.total
        })
    }
    
});	
