package my.suveng.oauth.dao;

import my.suveng.oauth.entity.TbRolePermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色权限表(TbRolePermission)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-28 18:15:03
 */
public interface TbRolePermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbRolePermission queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbRolePermission> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbRolePermission 实例对象
     * @return 对象列表
     */
    List<TbRolePermission> queryAll(TbRolePermission tbRolePermission);

    /**
     * 新增数据
     *
     * @param tbRolePermission 实例对象
     * @return 影响行数
     */
    int insert(TbRolePermission tbRolePermission);

    /**
     * 修改数据
     *
     * @param tbRolePermission 实例对象
     * @return 影响行数
     */
    int update(TbRolePermission tbRolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}