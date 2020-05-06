//服务层
app.service('itemCatService',function($http){

    this.findAllItemCat=function (searchEntity) {
        return $http.post("../itemCat/findAllItemCat,searchEntity")
    }

    this.findByParentId=function (id) {
        return $http.get("../itemCat/findByParentId?parentId="+id)
    }

    this.findOne=function (id) {
        return $http.get("../itemCat/findOne?id="+id)
    }

    this.del=function (ids) {
        return $http.post("../itemCat/delItemCat",ids)
    }

    this.add=function (searchEntity) {
        return $http.post("../itemCat/addItemCat",searchEntity)
    }

    this.update=function (searchEntity) {
        return $http.post("../itemCat/updateItemCat",searchEntity)
    }
});
