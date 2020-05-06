//为了达到代码的复用和维护性，将服务进行抽取
app.service("brandService", function($http) {
    this.findAllBrand=function () {
        return $http.get("../brand/findAllBrand")
    }

    this.findPageBrand=function (page,size,searchEntity) {
        return $http.post("../brand/findPageBrand?page="+page+"&size="+size,searchEntity)
    }

    this.findOne=function (id) {
        return $http.get("../brand/findOne?id="+id)
    }

    this.del=function (ids) {
        return $http.post("../brand/delBrand",ids)
    }

    this.add=function (searchEntity) {
        return $http.post("../brand/addBrand",searchEntity)
    }

    this.update=function (searchEntity) {
        return $http.post("../brand/updateBrand",searchEntity)
    }
});