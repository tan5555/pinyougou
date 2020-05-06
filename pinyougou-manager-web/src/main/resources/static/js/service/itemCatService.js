//服务层
app.service('itemCatService',function($http){

    this.findAllItemCat=function (entity) {
        return $http.post("../itemCat/findAllItemCat,entity")
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

    this.add=function (entity) {
        return $http.post("../itemCat/addItemCat",entity)
    }

    this.update=function (entity) {
        return $http.post("../itemCat/updateItemCat",entity)
    }
});
