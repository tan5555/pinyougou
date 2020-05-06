 //控制层 
app.controller('specificationController' ,function($scope,$controller ,specificationService){
	
	$controller('baseController',{$scope:$scope});//继承

    //查询条件
    $scope.searchEntity = {}
    $scope.findPage = function (page,size) {
        specificationService.findPageSpecification(page,size,$scope.searchEntity).success(function (response) {
            $scope.list=response.rows
            $scope.paginationConf.totalItems=response.total
        })
    }

    //添加和修改
    $scope.save = function () {
        if ($scope.entity.id != null){
            specificationService.update($scope.entity).success(function (response) {
                if (response==1){
                    $scope.reloadList()
                    alert("修改成功")
                }else {
                    alert("修改失败")
                }
            })
        }else {
            specificationService.add($scope.entity).success(function (response) {
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
        specificationService.findOne(id).success(function (response) {
            $scope.entity=response
        })
    };

    //删除
    $scope.del = function () {
        specificationService.del($scope.ids).success(function (response) {
            if (response==1){
                $scope.reloadList()
                alert("删除成功")
            }else {
                alert("删除失败")
            }
        })
    }
    
    //增加规格选项
    $scope.addTableRow = function () {
        $scope.entity.specificationOptionList.push({})
    }
    //删除规格选项
    $scope.deleteTableRow =function (index) {
        $scope.entity.specificationOptionList.splice(index,1)
    }
});	
