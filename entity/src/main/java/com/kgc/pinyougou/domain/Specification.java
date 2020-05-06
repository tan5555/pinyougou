package com.kgc.pinyougou.domain;

import java.io.Serializable;
import java.util.List;

public class Specification implements Serializable {
    private Long id;

    private String specName;

    private List<SpecificationOption> specificationOptionList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public List<SpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<SpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "id=" + id +
                ", specName='" + specName + '\'' +
                ", specificationOptionList=" + specificationOptionList +
                '}';
    }
}