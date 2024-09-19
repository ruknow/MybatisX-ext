package com.baomidou.plugin.idea.mybatisx.generate.dto;

import java.io.Serializable;

/**
 * POJO超类中设置的数据库字段
 */
public class SuperFieldInfo implements Serializable {

    private final String columnName;
    private final String fieldName;
    private final String shortTypeName;
    public boolean notExistColumn;

    public SuperFieldInfo(String columnName, String fieldName, String shortTypeName) {
        this.columnName = columnName;
        this.fieldName = fieldName;
        this.shortTypeName = shortTypeName;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getShortTypeName() {
        return shortTypeName;
    }

    public boolean isNotExistColumn() {
        return notExistColumn;
    }

    public void setNotExistColumn(boolean notExistColumn) {
        this.notExistColumn = notExistColumn;
    }
}
