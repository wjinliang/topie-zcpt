package com.topie.campus.security.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.campus.basedao.service.impl.BaseService;
import com.topie.campus.common.TreeNode;
import com.topie.campus.security.dao.UserMapper;
import com.topie.campus.security.model.User;
import com.topie.campus.security.security.OrangeSecurityMetadataSourceImpl;
import com.topie.campus.security.security.OrangeSideUserCache;
import com.topie.campus.security.service.RoleService;
import com.topie.campus.security.service.UserService;
import com.topie.campus.security.utils.SecurityUtil;

/**
 * 工程：os-app 创建人 : ChenGJ 创建时间： 2015/9/2 说明：
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleService roleService;

    @Autowired
    OrangeSideUserCache orangeSideUserCache;

    @Override
    public int insertUser(User user) {
        user.setPassword(SecurityUtil.encodeString(user.getPassword()));
        int result = getMapper().insertSelective(user);
        if (CollectionUtils.isNotEmpty(user.getRoles())) {
            deleteUserAllRoles(user.getCode());
            for (String roleId : user.getRoles()) {
                insertUserRole(user.getCode(), roleId);
            }
        }
        return result;
    }

    @Override
    public int updateUser(User user) {
        if (StringUtils.isNotEmpty(user.getPassword())) {
            user.setPassword(SecurityUtil.encodeString(user.getPassword()));
        }
        int result = getMapper().updateByPrimaryKeySelective(user);
        if (CollectionUtils.isNotEmpty(user.getRoles())) {
            deleteUserAllRoles(user.getCode());
            for (String roleId : user.getRoles()) {
                insertUserRole(user.getCode(), roleId);
            }
        }
        if (result > 0) {
            orangeSideUserCache.removeUserFromCacheByUserId(user.getCode());
            OrangeSecurityMetadataSourceImpl.refreshResourceMap();
        }
        return result;
    }

    @Override
    public int updateUserWithOnlyUserCache(User user) {
        if (StringUtils.isNotEmpty(user.getPassword())) {
            user.setPassword(SecurityUtil.encodeString(user.getPassword()));
        }
        int result = getMapper().updateByPrimaryKeySelective(user);
        if (result > 0) {
            OrangeSecurityMetadataSourceImpl.refreshResourceMap();
        }
        return result;
    }

    @Override
    public User findUserById(String id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public User findUserByLoginName(String loginName) {
        return userMapper.findUserByLoginName(loginName);
    }

    @Override
    public int deleteUser(String id) {
        int result = getMapper().deleteByPrimaryKey(id);
        if (result > 0) {
            deleteUserAllRoles(id);
        }
        return result;
    }

    @Override
    public int insertUserRole(String userId, String roleId) {
        int result = userMapper.insertUserRole(userId, roleId);
        if (result > 0) {
            orangeSideUserCache.removeUserFromCacheByUserId(userId);
            OrangeSecurityMetadataSourceImpl.refreshResourceMap();
        }
        return result;
    }

    @Override
    public List<String> findUserRoleByUserId(String userId) {
        return userMapper.findUserRoleByUserId(userId);
    }

    @Override
    public PageInfo<User> findUserList(Integer pageNum, Integer pageSize, User user) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.findUserList(user);
        PageInfo<User> page = new PageInfo<User>(list);
        return page;
    }

    @Override
    public int findExistUser(User user) {
        return userMapper.findExistUser(user);
    }

    @Override
    public List<TreeNode> findUserFunctionByLoginName(String loginName) {
        return userMapper.findUserFunctionByLoginName(loginName);
    }

    @Override
    public List<TreeNode> findUserFunctionByLoginNameAndDisplayType(String loginName, Integer displayType) {
        return userMapper.findUserFunctionByLoginNameAndDisplayType(loginName, displayType);
    }

    @Override
    public int countByLoginName(String loginName) {
        return userMapper.countByLoginName(loginName);
    }

    @Override
    public int updateLockStatusByUserId(String userId, Boolean accountNonLocked) {
        int result = userMapper.updateAccountNonLocked(userId, accountNonLocked);
        if (result > 0) {
            orangeSideUserCache.removeUserFromCacheByUserId(userId);
        }
        return result;
    }

    @Override
    public String findLoginNameByUserId(String userId) {
        return userMapper.findLoginNameByUserId(userId);
    }

    @Override
    public int deleteUserAllRoles(String userId) {
        int result = userMapper.deleteUserAllRoles(userId);
        if (result > 0) {
            orangeSideUserCache.removeUserFromCacheByUserId(userId);
            OrangeSecurityMetadataSourceImpl.refreshResourceMap();
        }
        return result;
    }

    @Override
    public int deleteUserRole(String userId, String roleId) {
        int result = userMapper.deleteUserRole(userId, roleId);
        if (result > 0) {
            orangeSideUserCache.removeUserFromCacheByUserId(userId);
            OrangeSecurityMetadataSourceImpl.refreshResourceMap();
        }
        return result;
    }

    @Override
    public PageInfo<User> findUserListByRoleId(int pageNum, int pageSize, User user, String roleId) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.findUserListByRoleId(user, roleId);
        PageInfo<User> page = new PageInfo<User>(list);
        return page;
    }
}
