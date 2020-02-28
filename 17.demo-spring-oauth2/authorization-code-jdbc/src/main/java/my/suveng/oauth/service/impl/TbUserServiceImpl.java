package my.suveng.oauth.service.impl;

import my.suveng.oauth.entity.TbUser;
import my.suveng.oauth.dao.TbUserDao;
import my.suveng.oauth.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(TbUser)表服务实现类
 *
 * @author makejava
 * @since 2020-02-28 16:41:40
 */
@Service("tbUserService")
public class TbUserServiceImpl implements TbUserService {
    @Resource
    private TbUserDao tbUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbUser queryById(Long id) {
        return this.tbUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbUser> queryAllByLimit(int offset, int limit) {
        return this.tbUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public TbUser insert(TbUser tbUser) {
        this.tbUserDao.insert(tbUser);
        return tbUser;
    }

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public TbUser update(TbUser tbUser) {
        this.tbUserDao.update(tbUser);
        return this.queryById(tbUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbUserDao.deleteById(id) > 0;
    }
}