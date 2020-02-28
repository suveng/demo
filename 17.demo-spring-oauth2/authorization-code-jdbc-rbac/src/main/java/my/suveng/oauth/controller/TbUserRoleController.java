package my.suveng.oauth.controller;

import my.suveng.oauth.entity.TbUserRole;
import my.suveng.oauth.service.TbUserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户角色表(TbUserRole)表控制层
 *
 * @author makejava
 * @since 2020-02-28 18:20:55
 */
@RestController
@RequestMapping("tbUserRole")
public class TbUserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private TbUserRoleService tbUserRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbUserRole selectOne(Long id) {
        return this.tbUserRoleService.queryById(id);
    }

}