 //控制层 
app.controller('sellerController' ,function($scope,$controller ,sellerService){
	
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
         sellerService.update($scope.entity).success(function (response) {
                if (response==1){
                    $scope.reloadList()
                    alert("修改成功")
                }else {
                    alert("修改失败")
                }
         })


    }

    $scope.add = function (){
        sellerService.add($scope.entity).success(function (response) {
            if (response==1){
                alert("入驻成功")
                //注册成功跳转到登录页面
                location.href='/login'
            }else {
                alert("入驻失败")
            }
        })



	}


    //更新查询
    $scope.findOne=function(id){
        sellerService.findOne(id).success(function (response) {
            $scope.entity=response
        })
    };

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
