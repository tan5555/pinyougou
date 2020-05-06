//服务层
app.service('specificationOptionService',function($http){

    this.findAllSpecificationOption=function (page,size,searchEntity) {
        return $http.post("../specificationOption/findAllSpecificationOption?page="+page+"&size="+size,searchEntity)
    }

    this.findOne=function (id) {
        return $http.get("../specificationOption/findOne?id="+id)
    }

    this.del=function (ids) {
        return $http.post("../specificationOption/delSpecificationOption",ids)
    }

    this.add=function (searchEntity) {
        return $http.post("../specificationOption/addSpecificationOption",searchEntity)
    }

    this.update=function (searchEntity) {
        return $http.post("../specificationOption/updateSpecificationOption",searchEntity)
    }
});
