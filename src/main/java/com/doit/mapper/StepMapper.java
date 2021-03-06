package com.doit.mapper;

import com.doit.entity.Step;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Step)表数据库访问层
 *
 * @author 李二帅
 * @date 2021-07-31 16:08:43
 */
@Mapper
public interface StepMapper {

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Step> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Step queryById(Integer id);

    /**
     * 查询单个任务的步骤
     *
     * @param taskId 任务id
     * @return 实例对象
     */
    List<Step> queryStepByTaskId(Integer taskId);

    /**
     * 新增数据
     *
     * @param step 实例对象
     * @return 影响行数
     */
    int insert(Step step);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Step> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Step> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Step> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Step> entities);

    /**
     * 修改数据
     *
     * @param step 实例对象
     * @return 影响行数
     */
    int update(Step step);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

