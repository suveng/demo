package my.suveng.oauth.controller;

import my.suveng.oauth.entity.TbRolePermission;
import my.suveng.oauth.service.TbRolePermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 角色权限表(TbRolePermission)表控制层
 *
 * @author makejava
 * @since 2020-02-28 18:15:03
 */
@RestController
@RequestMapping("tbRolePermission")
public class TbRolePermissionController {
    /**
     * 服务对象
     */
    @Resource
    private TbRolePermissionService tbRolePermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbRolePermission selectOne(Long id) {
        return this.tbRolePermissionService.queryById(id);
    }

}