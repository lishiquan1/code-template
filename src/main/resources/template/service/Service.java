package ${package_service};

import ${package_pojo}.${Table};
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Demo ${Table}业务层接口
 *
 * @author lishiquan
 */
public interface ${Table}Service {
    
    /**
     * 查询所有${Table}
     * @return 查询结果
     */
    List<${Table}> findAll();

    /**
     * 根据ID查询${Table}
     * @param id ${Table} id
     * @return 查询结果
     */
    ${Table} findById(${keyType} id);


    /**
     * 新增${Table}
     * @param ${table} ${Table}实体类
     */
    void add(${Table} ${table});


    /**
     * 修改${Table}数据
     * @param ${table} ${Table}实体类
     */
    void update(${Table} ${table});

    /**
     * 删除${Table}
     * @param id ${Table} id
     */
    void delete(${keyType} id);


    /**
     * ${Table}多条件搜索方法
     * @param ${table} 查询条件
     * @return 查询结果
     */
    List<${Table}> findList(${Table} ${table});

    /**
     * ${Table}分页查询
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    PageInfo<${Table}> findPage(Integer page, Integer size);

    /**
     * ${Table}条件查询 + 分页
     * @param ${table} 分页条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    PageInfo<${Table}> findPage(${Table} ${table}, Integer page, Integer size);

}
