//服务层
app.service('goodsService',function($http){

    this.findAllGoods=function (page,size,searchEntity) {
        return $http.post("../goods/findAllGoods?page="+page+"&size="+size,searchEntity)
    }

    this.findOne=function (id) {
        return $http.get("../goods/findOne?id="+id)
    }

    this.del=function (ids) {
        return $http.post("../goods/delGoods",ids)
    }

    this.add=function (searchEntity) {
        return $http.post("../goods/addGoods",searchEntity)
    }

    this.update=function (searchEntity) {
        return $http.post("../goods/updateGoods",searchEntity)
    }
});
