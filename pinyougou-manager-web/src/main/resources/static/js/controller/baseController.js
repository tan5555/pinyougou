app.controller('baseController', function($scope) {
	// 分页控件配置currentPage:当前页 totalItems :总记录数 itemsPerPage:每页记录数 perPageOptions
	// :分页选项 onChange:当页码变更后自动触发的方法
    $scope.paginationConf = {
        currentPage : 1,
        totalItems : 5,
        itemsPerPage : 10,
        perPageOptions : [ 10, 20, 30, 50 ],
        onChange : function() {
            $scope.reloadList();// 重新加载
        }
    };

	// 为了后面调用的方便，把调用分页的方法封装为一个方法
    $scope.reloadList = function () {
        $scope.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage)
    }

	// 获取选中项的id并保存到集合
    $scope.ids = []
    $scope.updateSelection = function ($event,id) {
        if ($event.target.checked){
            $scope.ids.push(id)
        } else {
            var index = $scope.ids.indexOf(id)
            $scope.ids.splice(index,1)
        }

    }

	// 选择所有
	$scope.selectAll = function() {
		if($("#selall").prop("checked")){
			$(":checkbox[name = 'as']").prop("checked",true);
			//选择的时候将页面加载记录的id数组赋值给选择的数组
			$scope.ids = $scope.AllRecordsId;
		}else{
			//取消选择的时候清空选择的数组
			$scope.ids = [];
			$(":checkbox[name = 'as']").prop("checked",false);
		}
	}
	//记录当前页的所有记录的id
	$scope.AllRecordsId = [];
	// 点击分页时清空全选和数组中的值
	$scope.emptySelect = function() {
		$scope.AllRecordsId = [];
		$scope.ids = [];
		if ($("#selall").prop("checked")) {
			$("#selall").prop("checked", false);
			$(":checkbox[name = 'as']").prop("checked", false);
		}
	}
	
	//将加载的数据的id加在当前页的所有记录的id的数组
    $scope.idss = function(){
    	for(var i = 0;i<$scope.list.length;i++){
			$scope.AllRecordsId.push($scope.list[i].id);
		}
    }

    //提取json字符串数据中某个属性，返回拼接字符串 逗号分隔
    $scope.jsonToString=function(jsonString,key){
        var json=JSON.parse(jsonString);//将json字符串转换为json对象
        var value="";
        for(var i=0;i<json.length;i++){
            if(i>0){
                value+=","
            }
            value+=json[i][key];
        }
        return value;
    }
});