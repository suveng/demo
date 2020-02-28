package my.suveng.oauth.config.auth;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import my.suveng.oauth.entity.TbUser;
import my.suveng.oauth.entity.TbUserRole;
import my.suveng.oauth.service.AuthorizationService;
import my.suveng.oauth.service.TbUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 *
 * @author suwenguang
 **/
public class UserDetailServiceImpl implements UserDetailsService {

	@Resource
	private PasswordEncoder passwordEncoder;

	@Resource
	private TbUserService tbUserService;
	@Resource
	private AuthorizationService authorizationService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (StrUtil.isBlank(username)) {
			throw new UsernameNotFoundException("用户名不能为空");
		}

		//权限列表
		ArrayList<GrantedAuthority> authorities = new ArrayList<>();


		TbUser tbUser = tbUserService.queryByUsername(username);
		if (ObjectUtil.isEmpty(tbUser) || StrUtil.isBlank(tbUser.getUsername()) || StrUtil.isBlank(tbUser.getPassword())) {
			throw new UsernameNotFoundException("没找到用户信息");
		}

		ArrayList<GrantedAuthority> grantedAuthorities = authorizationService.getGrantedAuthorityByUserId(tbUser.getId());
		if (CollUtil.isEmpty(grantedAuthorities)){
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority("default");
			authorities.add(authority);
		}

		return new User(tbUser.getUsername(), tbUser.getPassword(), authorities);
	}
}
