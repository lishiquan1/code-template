package ${package_controller};

import ${package_pojo}.${Table};
import ${package_service}.${Table}Service;
import com.github.pagehelper.PageInfo;
import com.changgou.common.entity.Result;
import com.changgou.common.entity.StatusCode;
<#if swagger==true>import io.swagger.annotations.*;</#if>
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Demo ${Table}表现层
 *
 * @author ${author}
 */
<#if swagger==true>@Api("${Table}Controller")</#if>
@RestController
@RequestMapping("/${table}")
@CrossOrigin
public class ${Table}Controller {

    /**
     * ${table}业务层接口
     */
    @Autowired
    private ${Table}Service ${table}Service;

    /**
     * 查询${Table}全部数据
     * @return 查询成功
     */
    <#if swagger==true>
    @ApiOperation(value = "查询所有${Table}", notes = "查询所${Table}有方法详情", tags = {"${Table}Controller"})
    </#if>
    @GetMapping
    public Result<List<${Table}>> findAll(){
        // 调用${Table}Service实现查询所有${Table}
        List<${Table}> ${table}s = ${table}Service.findAll();
        return new Result<>(true, StatusCode.OK, "查询成功", ${table}s) ;
    }

    /**
     * 根据ID查询${Table}数据
     * @param id ${Table} id
     * @return 查询成功
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}根据ID查询", notes = "根据ID查询${Table}方法详情", tags = {"${Table}Controller"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "${keyType}")
    </#if>
    @GetMapping("/{id}")
    public Result<${Table}> findById(@PathVariable ${keyType} id){
        // 调用${Table}Service实现根据主键查询${Table}
        ${Table} ${table} = ${table}Service.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", ${table});
    }

    /**
     * 新增${table}数据
     * @param ${table} ${Table}实体类
     * @return 添加成功
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}添加", notes = "添加${Table}方法详情", tags = {"${Table}Controller"})
    </#if>
    @PostMapping
    public Result add(@RequestBody <#if swagger==true>@ApiParam(name = "${Table}对象",value = "传入JSON数据",required = true)</#if> ${Table} ${table}){
        // 调用${Table}Service实现添加${Table}
        ${table}Service.add(${table});
        return new Result<>(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改${Table}数据
     * @param ${table} ${Table}实体类
     * @param id ${Table} id
     * @return 修改成功
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}根据ID修改", notes = "根据ID修改${Table}方法详情", tags = {"${Table}Controller"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "${keyType}")
    </#if>
    @PutMapping("/{id}")
    public Result update(@RequestBody <#if swagger==true>@ApiParam(name = "${Table}对象",value = "传入JSON数据",required = false)</#if> ${Table} ${table},@PathVariable ${keyType} id){
        // 设置主键值
        ${table}.${keySetMethod}(id);
        // 调用${table}Service实现修改${Table}
        ${table}Service.update(${table});
        return new Result<>(true, StatusCode.OK, "修改成功");
    }

    /**
     * 根据ID删除数据
     * @param id ${Table} id
     * @return 删除成功
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}根据ID删除", notes = "根据ID删除${Table}方法详情", tags = {"${Table}Controller"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "${keyType}")
    </#if>
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable ${keyType} id){
        // 调用${Table}Service实现根据主键删除
        ${table}Service.delete(id);
        return new Result<>(true, StatusCode.OK, "删除成功");
    }

    /**
     * 多条件搜索品牌数据
     * @param ${table} 查询条件
     * @return 查询结果
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}条件查询", notes = "条件查询${Table}方法详情", tags = {"${Table}Controller"})
    </#if>
    @PostMapping("/search")
    public Result<List<${Table}>> findList(@RequestBody(required = false) <#if swagger==true>@ApiParam(name = "${Table}对象",value = "传入JSON数据",required = false)</#if> ${Table} ${table}){
        // 调用${Table}Service实现条件查询${Table}
        List<${Table}> ${table}s = ${table}Service.findList(${table});
        return new Result<>(true, StatusCode.OK, "查询成功", ${table}s);
    }

    /**
     * ${Table}分页搜索
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}分页查询", notes = "分页查询${Table}方法详情", tags = {"${Table}Controller"})
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
        @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    </#if>
    @GetMapping("/search/{page}/{size}")
    public Result<PageInfo<${Table}>> findPage(@PathVariable Integer page, @PathVariable Integer size){
        //调用${Table}Service实现分页查询${Table}
        PageInfo<${Table}> pageInfo = ${table}Service.findPage(page, size);
        return new Result<>(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /**
     * ${Table}分页条件搜索
     * @param ${table} 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}条件分页查询",notes = "分页条件查询${Table}方法详情",tags = {"${Table}Controller"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    </#if>
    @PostMapping("/search/{page}/{size}")
    public Result<PageInfo<${Table}>> findPage(@RequestBody(required = false) <#if swagger==true>@ApiParam(name = "${Table}对象",value = "传入JSON数据",required = false)</#if> ${Table} ${table}, @PathVariable  Integer page, @PathVariable  Integer size){
        //调用${Table}Service实现分页条件查询${Table}
        PageInfo<${Table}> pageInfo = ${table}Service.findPage(${table}, page, size);
        return new Result<>(true, StatusCode.OK, "查询成功", pageInfo);
    }
}
