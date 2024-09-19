package ${mapperInterface.packageName};

import ${tableClass.fullClassName};
<#if tableClass.pkFields??>
    <#list tableClass.pkFields as field><#assign pkName>${field.shortTypeName}</#assign></#list>
</#if>
import com.yuanzy.framework.mybatis.mapper.CommonMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>描述：Mapper接口类 ${tableClass.tableName}<#if tableClass.remark?has_content> (${tableClass.remark!})</#if></p>
 * <p>时间：${.now?string('yyyy-MM-dd HH:mm:ss')}</p>
 * @author ${author!}
 */
@Mapper
@Repository
public interface ${mapperInterface.fileName} extends CommonMapper<${tableClass.shortClassName}> {

}




