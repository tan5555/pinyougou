 //控制层 
app.controller('typeTemplateController' ,function($scope,$controller,typeTemplateService,brandService,specificationService){	
	
	$controller('baseController',{$scope:$scope});//继承

    //查询条件
    $scope.searchEntity = {}
    $scope.findPage = function (page,size) {
        typeTemplateService.findPageTypeTemplate(page,size,$scope.searchEntity).success(function (response) {
            $scope.list=response.rows
            $scope.paginationConf.totalItems=response.total
        })
    }

    //添加和修改
    $scope.save = function () {
        $scope.entity.brandIds=JSON.stringify($scope.entity.brandIds)
        $scope.entity.specIds=JSON.stringify($scope.entity.specIds)
        $scope.entity.customAttributeItems=JSON.stringify($scope.entity.customAttributeItems)
        if ($scope.entity.id != null){
            typeTemplateService.update($scope.entity).success(function (response) {
                if (response==1){
                    $scope.reloadList()
                    alert("修改成功")
                }else {
                    alert("修改失败")
                }
            })
        }else {
            typeTemplateService.add($scope.entity).success(function (response) {
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
        typeTemplateService.findOne(id).success(function (response) {
            $scope.entity=response

            //将返回的字符串转换为json
            //将返回的字符串转换为json
            $scope.entity.specIds = JSON.parse($scope.entity.specIds);
            $scope.entity.brandIds = JSON.parse($scope.entity.brandIds);
            $scope.entity.customAttributeItems = JSON.parse($scope.entity.customAttributeItems);
        })
    };

    //删除
    $scope.del = function () {
        typeTemplateService.del($scope.ids).success(function (response) {
            if (response==1){
                $scope.reloadList()
                alert("删除成功")
            }else {
                alert("删除失败")
            }
        })
    }

	
	//品牌列表
	$scope.brandList = {data:[]};
    $scope.findBrandList = function(){
    	brandService.findAllBrand().success(
    		function(response){
    			$scope.brandList = {data:response};
    	});
    }
    
    //规格列表
    $scope.sectList = {data:[]};
    $scope.findSpecificationList = function(){
    	specificationService.findAllSpecification().success(
    		function(response){
    			$scope.sectList = {data:response};
    	});
    }
    
    //增加行
    $scope.addTableRow = function(){
    	$scope.entity.customAttributeItems.push({});
    }
    
    //删除行
    $scope.delTableRow = function(index){
    	$scope.entity.customAttributeItems.splice(index,1);
    }
});	
