package ${baseInfo.packageName};

import com.yuanzy.framework.mybatis.service.impl.CommonServiceImpl;
import ${tableClass.fullClassName};
import ${serviceInterface.packageName}.${serviceInterface.fileName};
import ${mapperInterface.packageName}.${mapperInterface.fileName};
<#if baseService??&&baseService!="">
import ${baseService};
    <#list baseService?split(".") as simpleName>
        <#if !simpleName_has_next>
            <#assign serviceSimpleName>${simpleName}</#assign>
        </#if>
    </#list>
</#if>
import org.springframework.stereotype.Service;

/**
 * <p>描述：服务实现类 ${tableClass.tableName}<#if tableClass.remark?has_content> (${tableClass.remark!})</#if></p>
 * <p>时间：${.now?string('yyyy-MM-dd HH:mm:ss')}</p>
 * @author ${author!}
 */
@Service
public class ${baseInfo.fileName} extends CommonServiceImpl<${mapperInterface.fileName}, ${tableClass.shortClassName}> implements ${serviceInterface.fileName} {

}




