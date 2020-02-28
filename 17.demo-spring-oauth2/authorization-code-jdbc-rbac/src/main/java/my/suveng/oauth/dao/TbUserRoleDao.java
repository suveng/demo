package my.suveng.oauth.dao;

import my.suveng.oauth.entity.TbUserRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户角色表(TbUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-28 18:20:55
 */
public interface TbUserRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbUserRole queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbUserRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbUserRole 实例对象
     * @return 对象列表
     */
    List<TbUserRole> queryAll(TbUserRole tbUserRole);

    /**
     * 新增数据
     *
     * @param tbUserRole 实例对象
     * @return 影响行数
     */
    int insert(TbUserRole tbUserRole);

    /**
     * 修改数据
     *
     * @param tbUserRole 实例对象
     * @return 影响行数
     */
    int update(TbUserRole tbUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}