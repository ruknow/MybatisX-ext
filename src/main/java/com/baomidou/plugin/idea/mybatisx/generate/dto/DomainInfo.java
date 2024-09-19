package com.baomidou.plugin.idea.mybatisx.generate.dto;

import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class DomainInfo implements Serializable {
    private String encoding;
    private String basePackage;
    private String relativePackage;
    private String fileName;
    private String basePath;
    private String modulePath;
    private String superClass;
    private String baseClass;

    private final List<SuperFieldInfo> superFields = new ArrayList<>();

    public void setModulePath(String modulePath) {
        this.modulePath = modulePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setRelativePackage(String relativePackage) {
        this.relativePackage = relativePackage;
    }

    public void setSuperClass(String superClass) {
        this.superClass = superClass;
    }

    public void setBaseClass(String baseClass) {
        this.baseClass = baseClass;
    }

    public void setSuperFields(List<SuperFieldInfo> superFields) {
        this.superFields.clear();
        this.superFields.addAll(superFields);
    }

    public DomainInfo copyFromFileName(String extraDomainName) {
        DomainInfo domainInfo = new DomainInfo();
        domainInfo.setModulePath(modulePath);
        domainInfo.setBasePath(basePath);
        domainInfo.setEncoding(encoding);
        domainInfo.setBasePackage(basePackage);
        domainInfo.setFileName(extraDomainName);
        domainInfo.setRelativePackage(relativePackage);
        domainInfo.setSuperClass(superClass);
        domainInfo.setBaseClass(baseClass);
        domainInfo.setSuperFields(superFields);
        return domainInfo;
    }
}
