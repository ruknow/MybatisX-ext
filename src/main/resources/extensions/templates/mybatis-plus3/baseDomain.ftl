package ${baseInfo.packageName};

import <#if baseInfo.superClass??>${baseInfo.superClass}<#else>java.io.Serializable</#if>;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
<#-- import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;-->
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.JdbcType;
<#list tableClass.importList as fieldType>${"\n"}import ${fieldType};</#list>

/**
 * <p>描述：实体类 ${tableClass.tableName}<#if tableClass.remark?has_content> (${tableClass.remark!})</#if></p>
 * <p>时间：${.now?string('yyyy-MM-dd HH:mm:ss')}</p>
 * @author ${author!}
 */
@Getter
@Setter
@TableName("${tableClass.tableName}")
public class Base${tableClass.shortClassName} <#if baseInfo.shortSuperClass??>extends ${baseInfo.shortSuperClass}<#else>implements Serializable</#if> {

<#list tableClass.pkFields as field>
<#if field.notSuperColumn>
    /**
     * ${field.remark!}<#if field.defaultValue??> [default:${field.defaultValue!}]</#if>
     */<#if !field.nullable><#if field.jdbcType=="VARCHAR">${"\n    // "}@NotBlank(message = "[${field.remark!}]不能为空")${"\n    // "}@Size(max = ${field.columnLength?c}, message = "长度不能超过${field.columnLength?c}")</#if><#else>${"\n    // "}@NotNull(message = "[${field.remark!}]不能为空")</#if>
    @TableId(value = "${field.columnName}")
    protected ${field.shortTypeName} ${field.fieldName};

</#if>
</#list>
<#list tableClass.baseBlobFields as field>
<#if field.notSuperColumn>
    /**
     * ${field.remark!}<#if field.defaultValue??> [default:${field.defaultValue!}]</#if>
     */<#if !field.nullable><#if field.jdbcType=="VARCHAR">${"\n    // "}@NotBlank(message = "[${field.remark!}]不能为空")${"\n    // "}@Size(max = ${field.columnLength?c}, message = "长度不能超过${field.columnLength?c}")</#if><#else>${"\n    // "}@NotNull(message = "[${field.remark!}]不能为空")</#if>
    @TableField(value = "${field.columnName}", jdbcType = JdbcType.${field.jdbcType})
    protected ${field.shortTypeName} ${field.fieldName};

</#if>
</#list>

<#-- Getter/Setter
<#list tableClass.allFields as field>
<#if field.notSuperColumn>
    /**
     * ${field.remark!}
     */
    public Base${tableClass.shortClassName} set${field.fieldName?cap_first}(${field.shortTypeName} ${field.fieldName}) {
        this.${field.fieldName} = ${field.fieldName};
        return this;
    }

    /**
     * ${field.remark!}
     */
    public ${field.shortTypeName} get${field.fieldName?cap_first}() {
        return this.${field.fieldName};
    }

</#if>
</#list>
-->
<#--
<#list baseInfo.superFields as superField>
<#if superField.notExistColumn>
    @Deprecated
    public void set${superField.fieldName?cap_first}(${superField.shortTypeName} ${superField.fieldName}) {
        throw new UnsupportedOperationException("表中没有字段:[${tableClass.tableName}.${superField.columnName}]");
    }

    @Deprecated
    public ${superField.shortTypeName} get${superField.fieldName?cap_first}() {
        throw new UnsupportedOperationException("表中没有字段:[${tableClass.tableName}.${superField.columnName}]");
    }

</#if>
</#list>
-->
}
