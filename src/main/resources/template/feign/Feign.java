package com.changgou.order.feign;

import com.changgou.common.entity.Result;
import ${package_pojo}.${Table};
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Demo ${Table} Feign接口
 *
 * @author lishiquan
 */
@FeignClient(name = "${serviceName}")
@RequestMapping("/${table}")
public interface ${Table}Feign {

    /**
     * 查询${Table}全部数据
     * @return 查询结果
     */
    @GetMapping
    Result<List<${Table}>> findAll();

    /**
     * 根据ID查询${Table}数据
     * @param id ${Table} id
     * @return 查询结果
     */
    @GetMapping("/{id}")
    Result<${Table}> findById(@PathVariable ${keyType} id);

    /**
     * 新增${Table}数据
     * @param ${table} ${Table}实体类
     * @return 新增
     */
    @PostMapping
    Result add(@RequestBody ${Table} ${table});

    /**
     * 修改${Table}数据
     * @param ${table} ${Table}实体类
     * @param id ${Table} id
     * @return 修改
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody ${Table} ${table},@PathVariable ${keyType} id);

    /**
     * 根据ID删除数据
     * @param id ${Table} id
     * @return 删除
     */
    @DeleteMapping(value = "/{id}" )
    Result<${Table}> delete(@PathVariable ${keyType} id);

    /**
     * 多条件查询
     * @param ${table} 查询条件
     * @return 查询结果
     */
    @PostMapping(value = "/search" )
    Result<List<${Table}>> findList(@RequestBody(required = false) ${Table} ${table});

    /**
     * ${Table}分页搜索
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo<${Table}>> findPage(@PathVariable Integer page, @PathVariable Integer size);

    /**
     * ${Table}条件搜索 + 分页
     * @param ${table} 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo<${Table}>> findPage(@RequestBody(required = false) ${Table} ${table}, @PathVariable Integer page, @PathVariable Integer size);
}