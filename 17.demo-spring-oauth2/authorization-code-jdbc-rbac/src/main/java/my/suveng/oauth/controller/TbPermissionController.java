package my.suveng.oauth.controller;

import my.suveng.oauth.entity.TbPermission;
import my.suveng.oauth.service.TbPermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 权限表(TbPermission)表控制层
 *
 * @author makejava
 * @since 2020-02-28 18:10:16
 */
@RestController
@RequestMapping("tbPermission")
public class TbPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private TbPermissionService tbPermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbPermission selectOne(Long id) {
        return this.tbPermissionService.queryById(id);
    }

}