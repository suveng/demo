package my.suveng.oauth.service;

import cn.hutool.core.collection.CollUtil;
import my.suveng.oauth.dao.AuthorizationDao;
import my.suveng.oauth.entity.TbPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * 认证服务
 * @author suwenguang
 **/
@Service
public class AuthorizationService {


	@Resource
	private AuthorizationDao authorizationDao;
	/**
	 * 根据userId获取权限
	 * @author suwenguang
	 */
	public ArrayList<GrantedAuthority> getGrantedAuthorityByUserId(long userId){
		ArrayList<GrantedAuthority> result = new ArrayList<>();
		ArrayList<TbPermission> permissions = authorizationDao.getGrantedAuthorityByUserId(userId);
		if (CollUtil.isEmpty(permissions)){
			return null;
		}
		permissions.parallelStream().forEach((permission)->{
			result.add(new SimpleGrantedAuthority(permission.getEnname()));
		});

		return result;
	}
}
