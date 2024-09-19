package ${baseInfo.packageName};

import ${tableClass.fullClassName};
<#if baseService??&&baseService!="">
import ${baseService};
    <#list baseService?split(".") as simpleName>
        <#if !simpleName_has_next>
            <#assign serviceSimpleName>${simpleName}</#assign>
        </#if>
    </#list>
</#if>
import com.yuanzy.framework.mybatis.service.ICommonService;

/**
 * <p>描述：服务接口类 ${tableClass.tableName}<#if tableClass.remark?has_content> (${tableClass.remark!})</#if></p>
 * <p>时间：${.now?string('yyyy-MM-dd HH:mm:ss')}</p>
 * @author ${author!}
 */
public interface ${baseInfo.fileName} extends ICommonService<${tableClass.shortClassName}> {

}
