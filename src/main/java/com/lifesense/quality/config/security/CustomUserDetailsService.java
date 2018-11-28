package com.lifesense.quality.config.security;

import com.lifesense.quality.domain.QaPreview;
import com.lifesense.quality.domain.QaUser;
import com.lifesense.quality.domain.Role2preview;
import com.lifesense.quality.domain.User2role;
import com.lifesense.quality.facade.SystemServiceFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 赵春定 on 2017/8/11.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SystemServiceFacadeImpl systemServiceFacade;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //SUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用SUser中的email作为用户名:
        QaUser user = systemServiceFacade.findQaUserByAccount(userName);
        if (userName.equals("admin") && user == null) {
            user = new QaUser();
            user.setAccount("admin");
            user.setPassword("f6b091d3b3f27ff8f4b661087f14464a");
            user.setProcessSign(1);
           // List<QaPreview> allQaPreviews = systemServiceFacade.findAllQaPreviews();
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
            //allQaPreviews.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getUri())));
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authorities.add(new SimpleGrantedAuthority("ROLE_SUPPER"));
            return new SecurityUser(user, authorities);
        }else if (userName.equals("admin")){
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
            //allQaPreviews.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getUri())));
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authorities.add(new SimpleGrantedAuthority("ROLE_SUPPER"));
            return new SecurityUser(user, authorities);
        }
        if (user == null || user.getValid() != 0) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        if (user.getProcessSign() == 0) {
            //作业员密码
            user.setPassword("e10adc3949ba59abbe56e057f20f883e");
            authorities.add(new SimpleGrantedAuthority("ROLE_WORKER"));
        } else if (user.getProcessSign() == 1) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else if (user.getProcessSign() == 2){
            authorities.add(new SimpleGrantedAuthority("ROLE_REPAIR"));
        } else if (user.getProcessSign() == 3){
            authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
        }
        // SecurityUser实现UserDetails并将SUser的Email映射为username

       /* List<User2role> user2roles = systemServiceFacade.findUser2roleByUserId(user.getId());
        if (user2roles != null) {
            List<String> roleCodes = user2roles.stream().map(r -> r.getRoleCode()).collect(Collectors.toList());
            roleCodes.forEach(r -> authorities.add(new SimpleGrantedAuthority("ROLE_" + r.toUpperCase())));
            List<Role2preview> role2previews = systemServiceFacade.findRole2previewByRoleCode(roleCodes);
            if (role2previews != null) {
                List<String> previewCodes = role2previews.stream().map(p -> p.getPreviewCode()).collect(Collectors.toList());
                if (previewCodes != null) {
                    List<QaPreview> qaPreviewByCodes = systemServiceFacade.findQaPreviewByCodes(previewCodes);
                    qaPreviewByCodes.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getUri())));
                }
            }
        }*/
        return new SecurityUser(user, authorities);
    }
}
