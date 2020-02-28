package my.suveng.oauth.service;

import my.suveng.oauth.entity.TbUserRole;
import java.util.List;

/**
 * 用户角色表(TbUserRole)表服务接口
 *
 * @author makejava
 * @since 2020-02-28 18:20:55
 */
public interface TbUserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbUserRole queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbUserRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbUserRole 实例对象
     * @return 实例对象
     */
    TbUserRole insert(TbUserRole tbUserRole);

    /**
     * 修改数据
     *
     * @param tbUserRole 实例对象
     * @return 实例对象
     */
    TbUserRole update(TbUserRole tbUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}