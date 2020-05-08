//服务层
app.service('itemCatService',function($http){

    this.findByParentId=function (id) {
        return $http.get("../itemCat/findByParentId?parentId="+id)
    }

});
