package ${baseInfo.packageName};

import ${(baseInfo.packageName)?replace('.domain.ext','.domain.base')}.Base${tableClass.shortClassName};
import lombok.Getter;
import lombok.Setter;

/**
 * <p>描述：扩展实体类 ${tableClass.tableName}<#if tableClass.remark?has_content> (${tableClass.remark!})</#if></p>
 * <p>时间：${.now?string('yyyy-MM-dd HH:mm:ss')}</p>
 * @author ${author!}
 */
@Getter
@Setter
public class ${tableClass.shortClassName} extends Base${tableClass.shortClassName} {

}
