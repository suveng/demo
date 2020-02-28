package my.suveng.oauth.service;

import my.suveng.oauth.entity.TbRolePermission;
import java.util.List;

/**
 * 角色权限表(TbRolePermission)表服务接口
 *
 * @author makejava
 * @since 2020-02-28 18:15:03
 */
public interface TbRolePermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbRolePermission queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbRolePermission> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbRolePermission 实例对象
     * @return 实例对象
     */
    TbRolePermission insert(TbRolePermission tbRolePermission);

    /**
     * 修改数据
     *
     * @param tbRolePermission 实例对象
     * @return 实例对象
     */
    TbRolePermission update(TbRolePermission tbRolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}