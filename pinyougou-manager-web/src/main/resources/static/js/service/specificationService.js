//服务层
app.service('specificationService',function($http){
    this.findAllSpecification=function () {
        return $http.get("../specification/findAllSpecification")
    }

    this.findPageSpecification=function (page,size,searchEntity) {
        return $http.post("../specification/findPageSpecification?page="+page+"&size="+size,searchEntity)
    }

    this.findOne=function (id) {
        return $http.get("../specification/findOne?id="+id)
    }

    this.del=function (ids) {
        return $http.post("../specification/delSpecification",ids)
    }

    this.add=function (searchEntity) {
        return $http.post("../specification/addSpecification",searchEntity)
    }

    this.update=function (searchEntity) {
        return $http.post("../specification/updateSpecification",searchEntity)
    }
});
