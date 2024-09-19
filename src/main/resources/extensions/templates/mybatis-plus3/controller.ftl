package ${baseInfo.packageName};

import com.yuanzy.framework.aspectj.lang.annotation.Log;
import com.yuanzy.framework.aspectj.lang.enums.BusinessType;
import com.yuanzy.framework.web.controller.BaseController;
import com.yuanzy.framework.web.page.PageData;
import ${tableClass.fullClassName};
import ${serviceInterface.packageName}.${serviceInterface.fileName};
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

/**
 * <p>描述：<#if tableClass.remark?has_content> (${tableClass.remark!})</#if>操作类(${tableClass.tableName})</p>
 * <p>时间：${.now?string('yyyy-MM-dd HH:mm:ss')}</p>
 * @author ${author!}
 */
@RequiredArgsConstructor
//@RestController
@RequestMapping("/config/${tableClass.tableName}")
public class ${baseInfo.fileName} extends BaseController {

    private final ${serviceInterface.fileName} ${serviceInterface.fileName?uncap_first};

    @GetMapping("/list")
    public PageData list${tableClass.shortClassName}() {
        List<${tableClass.shortClassName}> ${tableClass.shortClassName?uncap_first}List = ${serviceInterface.fileName?uncap_first}.list();
        return getPageData(${tableClass.shortClassName?uncap_first}List);
    }

    @GetMapping("/{${tableClass.pkFields[0].fieldName}}")
    public ${tableClass.shortClassName} get${tableClass.shortClassName}(@PathVariable String ${tableClass.pkFields[0].fieldName}) {
        return ${serviceInterface.fileName?uncap_first}.getById(${tableClass.pkFields[0].fieldName});
    }

    @Log(title = "添加${tableClass.remark!}", businessType = BusinessType.INSERT)
    @PostMapping
    public ${tableClass.shortClassName} add${tableClass.shortClassName}(@RequestBody ${tableClass.shortClassName} ${tableClass.shortClassName?uncap_first}) {
        ${serviceInterface.fileName?uncap_first}.save(${tableClass.shortClassName?uncap_first});
        return ${tableClass.shortClassName?uncap_first};
    }

    @Log(title = "修改${tableClass.remark!}", businessType = BusinessType.UPDATE)
    @PutMapping
    public ${tableClass.shortClassName} modify${tableClass.shortClassName}(@RequestBody ${tableClass.shortClassName} ${tableClass.shortClassName?uncap_first}) {
        ${serviceInterface.fileName?uncap_first}.updateById(${tableClass.shortClassName?uncap_first});
        return ${tableClass.shortClassName?uncap_first};
    }

    @Log(title = "删除${tableClass.remark!}", businessType = BusinessType.DELETE)
    @DeleteMapping
    public Boolean remove${tableClass.shortClassName}(@RequestParam HashSet<${tableClass.pkFields[0].shortTypeName}> ${tableClass.pkFields[0].fieldName}s) {
        return ${serviceInterface.fileName?uncap_first}.removeByIds(${tableClass.pkFields[0].fieldName}s);
    }

}




