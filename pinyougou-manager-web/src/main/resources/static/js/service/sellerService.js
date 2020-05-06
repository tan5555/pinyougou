//服务层
app.service('sellerService',function($http){

    this.findAllBrand=function () {
        return $http.get("../seller/findAllSeller")
    }

    this.findPageSeller=function (page,size,searchEntity) {
        return $http.post("../seller/findPageSeller?page="+page+"&size="+size,searchEntity)
    }

    this.findOne=function (id) {
        return $http.get("../seller/findOne?sellerId="+id)
    }

    this.del=function (ids) {
        return $http.post("../seller/delSeller",ids)
    }

    this.add=function (searchEntity) {
        return $http.post("../seller/addSeller",searchEntity)
    }

    this.update=function (searchEntity) {
        return $http.post("../seller/updateSeller",searchEntity)
    }

    this.updateStatus=function (id,status) {
        return $http.get("../seller/updateStatus?sellerId="+id+"&status="+status)
    }
});
