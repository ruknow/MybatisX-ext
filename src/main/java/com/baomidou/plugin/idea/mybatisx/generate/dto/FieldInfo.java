package com.baomidou.plugin.idea.mybatisx.generate.dto;

import lombok.Getter;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;

/**
 * 字段信息
 */
@Getter
public class FieldInfo {
    /**
     * 字段名称
     */
    private String fieldName;
    /**
     * 列名称
     */
    private String columnName;
    /**
     * 数据库字段类型
     */
    private String typeName;
    /**
     * 列实际限制的长度
     */
    private int columnLength;
    /**
     * 列的精度
     */
    private int columnScale;
    /**
     * java 字段类型是不是数组类型, 用于排除导入
     */
    private boolean columnIsArray;
    /**
     * java类型短名称
     */
    private String shortTypeName;
    /**
     * java类型的长名称, 用于导入
     */
    private String fullTypeName;
    /**
     * 字段注释
     */
    private String remark;
    /**
     * jdbcType 的值
     */
    private String jdbcType;
    /**
     * 缺省值
     */
    private String defaultValue;

    /**
     * 是否允许为空
     */
    private boolean nullable;
    /**
     * 是否自增
     */
    private boolean autoIncrement;

    private boolean notSuperColumn = true;

    public void setNotSuperColumn(boolean notSuperColumn) {
        this.notSuperColumn = notSuperColumn;
    }

    public static FieldInfo build(IntrospectedColumn introspectedColumn) {
        FieldInfo fieldInfo = new FieldInfo();
        fieldInfo.fieldName = introspectedColumn.getJavaProperty();
        fieldInfo.columnName = introspectedColumn.getActualColumnName();
        fieldInfo.typeName = introspectedColumn.getActualTypeName();
        fieldInfo.jdbcType = introspectedColumn.getJdbcTypeName();
        fieldInfo.columnLength = introspectedColumn.getLength();
        fieldInfo.columnScale = introspectedColumn.getScale();
        fieldInfo.defaultValue = introspectedColumn.getDefaultValue();
        FullyQualifiedJavaType fullyQualifiedJavaType = introspectedColumn.getFullyQualifiedJavaType();
        fieldInfo.shortTypeName = fullyQualifiedJavaType.getShortName();
        fieldInfo.fullTypeName = fullyQualifiedJavaType.getFullyQualifiedName();
        fieldInfo.columnIsArray = fullyQualifiedJavaType.isArray();
        fieldInfo.remark = introspectedColumn.getRemarks();
        fieldInfo.nullable = introspectedColumn.isNullable();
        fieldInfo.autoIncrement = introspectedColumn.isAutoIncrement();
        return fieldInfo;
    }

}
