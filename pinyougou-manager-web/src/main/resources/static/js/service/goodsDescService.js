//服务层
app.service('goodsDescService',function($http){

    this.findAllGoodsDesc=function (page,size,searchEntity) {
        return $http.post("../goodsDesc/findAllGoodsDesc?page="+page+"&size="+size,searchEntity)
    }

    this.findOne=function (id) {
        return $http.get("../goodsDesc/findOne?id="+id)
    }

    this.del=function (ids) {
        return $http.post("../goodsDesc/delGoodsDesc",ids)
    }

    this.add=function (searchEntity) {
        return $http.post("../goodsDesc/addGoodsDesc",searchEntity)
    }

    this.update=function (searchEntity) {
        return $http.post("../goodsDesc/updateGoodsDesc",searchEntity)
    }
});
