package my.suveng.oauth2.rbac.server.service.db.mysql.dao.jpa;

import my.suveng.oauth2.rbac.server.service.db.mysql.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * jpa
 * 
 * @author suwenguang
 **/
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
}
