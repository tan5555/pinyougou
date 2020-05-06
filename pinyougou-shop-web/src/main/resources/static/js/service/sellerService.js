//服务层
app.service('sellerService',function($http){

    this.findAllSeller=function () {
        return $http.get("/seller/findAllSeller")
    }

    this.findPageSeller=function (page,size,searchEntity) {
        return $http.post("/seller/findPageSeller?page="+page+"&size="+size,searchEntity)
    }

    this.findOne=function (id) {
        return $http.get("/seller/findOne?id="+id)
    }

    this.del=function (ids) {
        return $http.post("/seller/delSeller",ids)
    }

    this.add=function (entity) {
        return $http.post("/seller/addSeller",entity)
    }

    this.update=function (entity) {
        return $http.post("/seller/updateSeller",entity)
    }

});
