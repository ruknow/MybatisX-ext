<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- XML配置 ${tableClass.tableName}<#if tableClass.remark?has_content> (${tableClass.remark!})</#if> -->
<mapper namespace="${mapperInterface.packageName}.${baseInfo.fileName?substring(4)}">

    <resultMap id="BaseResultMap" type="${tableClass.fullClassName}">
    <#list tableClass.pkFields as field>
        <id property="${field.fieldName}"${""?right_pad(24 - field.fieldName?length)}column="${field.columnName}"${""?right_pad(24 - field.columnName?length)}jdbcType="${field.jdbcType}"/>
    </#list>
    <#list tableClass.baseBlobFields as field>
        <result property="${field.fieldName}"${""?right_pad(20 - field.fieldName?length)}column="${field.columnName}"${""?right_pad(24 - field.columnName?length)}jdbcType="${field.jdbcType}"/>
    </#list>
    </resultMap>

    <sql id="Select_Base">
        SELECT <#list tableClass.allFields as field>${tableClass.shortTableName}.${field.columnName}<#sep>, <#if field_index%10==9>${"\n        "}</#if></#list>
        FROM ${tableClass.tableName} ${tableClass.shortTableName}
    </sql>

</mapper>
