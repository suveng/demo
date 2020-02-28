package my.suveng.oauth.service;

import my.suveng.oauth.entity.TbPermission;
import java.util.List;

/**
 * 权限表(TbPermission)表服务接口
 *
 * @author makejava
 * @since 2020-02-28 18:10:16
 */
public interface TbPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbPermission queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbPermission> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbPermission 实例对象
     * @return 实例对象
     */
    TbPermission insert(TbPermission tbPermission);

    /**
     * 修改数据
     *
     * @param tbPermission 实例对象
     * @return 实例对象
     */
    TbPermission update(TbPermission tbPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}