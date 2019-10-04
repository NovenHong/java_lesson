package com.owner.test.handler;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.owner.test.entity.Role;
import com.owner.test.service.RoleService;

@Component
public class MySecurityMetadataSourceHandler implements FilterInvocationSecurityMetadataSource {
	
	@Resource(name="roleService")
	private RoleService roleService;

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		
		FilterInvocation filterInvocation = (FilterInvocation) object;
		
//		String url = filterInvocation.getRequestUrl();
//        System.out.println("访问的URL地址为(包括参数):" + url);
        
        String url = filterInvocation.getRequest().getServletPath();
        System.out.println("访问的URL地址为:" + url);
        
        List<Role> roles = roleService.findAllRoleByPermissionUrl(url);
        
        Collection<ConfigAttribute> collection = new HashSet<ConfigAttribute>();
        
        for(Role role : roles) {
        	
        	collection.add(new ConfigAttribute() {
    			private static final long serialVersionUID = 1L;
    			@Override
    			public String getAttribute() {
    				return role.getName();
    			}
    		});
        	
        }
        
        return collection;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
