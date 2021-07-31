package com.doit.mapper;

import com.doit.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Task)表数据库访问层
 *
 * @author 李二帅
 * @date 2021-07-31 16:08:44
 */
@Mapper
public interface TaskMapper {

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Task> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Task queryById(Integer id);

    /**
     * 新增数据
     *
     * @param task 实例对象
     * @return 影响行数
     */
    int insert(Task task);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Task> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Task> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Task> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Task> entities);

    /**
     * 修改数据
     *
     * @param task 实例对象
     * @return 影响行数
     */
    int update(Task task);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

