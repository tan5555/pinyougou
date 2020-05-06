//服务层
app.service('itemService',function($http){

    this.findAllItem=function (page,size,searchEntity) {
        return $http.post("../item/findAllItem?page="+page+"&size="+size,searchEntity)
    }

    this.findOne=function (id) {
        return $http.get("../item/findOne?id="+id)
    }

    this.del=function (ids) {
        return $http.post("../item/delItem",ids)
    }

    this.add=function (searchEntity) {
        return $http.post("../item/addItem",searchEntity)
    }

    this.update=function (searchEntity) {
        return $http.post("../item/updateItem",searchEntity)
    }
});
