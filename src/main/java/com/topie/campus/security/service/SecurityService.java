package com.topie.campus.security.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;

import com.topie.campus.security.security.OrangeSecurityUser;

/**
 * 工程：os-app 创建人 : ChenGJ 创建时间： 2015/9/4 说明：
 */
public interface SecurityService {
    OrangeSecurityUser loadSecurityUserByLoginName(String loginName);

    Map<String, Collection<ConfigAttribute>> getCacheResourceMap();

    Map<String, Collection<ConfigAttribute>> getDbResourceMap();

    String getDefaultAction(String roleId);
}
