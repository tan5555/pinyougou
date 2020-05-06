//服务层
app.service('typeTemplateService',function($http){

    this.findPageTypeTemplate=function (page,size,searchEntity) {
        return $http.post("../typeTemplate/findPageTypeTemplate?page="+page+"&size="+size,searchEntity)
    }

    this.findOne=function (id) {
        return $http.get("../typeTemplate/findOne?id="+id)
    }

    this.del=function (ids) {
        return $http.post("../typeTemplate/delTypeTemplate",ids)
    }

    this.add=function (entity) {
        return $http.post("../typeTemplate/addTypeTemplate",entity)
    }

    this.update=function (entity) {
        return $http.post("../typeTemplate/updateTypeTemplate",entity)
    }

    //所有模板
    this.findAllTypeTemplate=function () {
        return $http.get("../typeTemplate/findAllTypeTemplate")
    }

});
