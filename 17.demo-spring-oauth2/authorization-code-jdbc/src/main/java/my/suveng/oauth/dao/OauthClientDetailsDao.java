package my.suveng.oauth.dao;

import my.suveng.oauth.entity.OauthClientDetails;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (OauthClientDetails)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-28 17:04:55
 */
public interface OauthClientDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param clientId 主键
     * @return 实例对象
     */
    OauthClientDetails queryById(String clientId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OauthClientDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param oauthClientDetails 实例对象
     * @return 对象列表
     */
    List<OauthClientDetails> queryAll(OauthClientDetails oauthClientDetails);

    /**
     * 新增数据
     *
     * @param oauthClientDetails 实例对象
     * @return 影响行数
     */
    int insert(OauthClientDetails oauthClientDetails);

    /**
     * 修改数据
     *
     * @param oauthClientDetails 实例对象
     * @return 影响行数
     */
    int update(OauthClientDetails oauthClientDetails);

    /**
     * 通过主键删除数据
     *
     * @param clientId 主键
     * @return 影响行数
     */
    int deleteById(String clientId);

}