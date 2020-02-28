package my.suveng.oauth.service.impl;

import my.suveng.oauth.entity.TbRolePermission;
import my.suveng.oauth.dao.TbRolePermissionDao;
import my.suveng.oauth.service.TbRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色权限表(TbRolePermission)表服务实现类
 *
 * @author makejava
 * @since 2020-02-28 18:15:03
 */
@Service("tbRolePermissionService")
public class TbRolePermissionServiceImpl implements TbRolePermissionService {
    @Resource
    private TbRolePermissionDao tbRolePermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbRolePermission queryById(Long id) {
        return this.tbRolePermissionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbRolePermission> queryAllByLimit(int offset, int limit) {
        return this.tbRolePermissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public TbRolePermission insert(TbRolePermission tbRolePermission) {
        this.tbRolePermissionDao.insert(tbRolePermission);
        return tbRolePermission;
    }

    /**
     * 修改数据
     *
     * @param tbRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public TbRolePermission update(TbRolePermission tbRolePermission) {
        this.tbRolePermissionDao.update(tbRolePermission);
        return this.queryById(tbRolePermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbRolePermissionDao.deleteById(id) > 0;
    }
}