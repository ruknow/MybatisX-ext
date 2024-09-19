<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 扩展XML配置 ${tableClass.tableName}<#if tableClass.remark?has_content> (${tableClass.remark!})</#if> -->
<mapper namespace="${mapperInterface.packageName}.${baseInfo.fileName}">

    <!--
    <resultMap id="ExtResultMap" extends="BaseResultMap" type="${tableClass.fullClassName}">
    </resultMap>
    -->

</mapper>
