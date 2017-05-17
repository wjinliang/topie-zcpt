package com.topie.campus.security.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.topie.campus.basedao.service.IService;
import com.topie.campus.common.TreeNode;
import com.topie.campus.security.model.User;

/**
 * 工程：os-app 创建人 : ChenGJ 创建时间： 2015/9/2 说明：
 */
public interface UserService extends IService<User> {

    int insertUser(User user);

    int updateUser(User user);

    int updateUserWithOnlyUserCache(User user);

    User findUserById(String id);

    User findUserByLoginName(String loginName);

    int deleteUser(String id);

    int insertUserRole(String userId, String roleId);

    int deleteUserAllRoles(String userId);

    List<String> findUserRoleByUserId(String userId);

    PageInfo<User> findUserList(Integer pageNum, Integer pageSize, User user);

    int findExistUser(User user);

    List<TreeNode> findUserFunctionByLoginName(String loginName);

    List<TreeNode> findUserFunctionByLoginNameAndDisplayType(String loginName,Integer displayType);

    int countByLoginName(String loginName);

    int updateLockStatusByUserId(String userId, Boolean accountNonLocked);

    String findLoginNameByUserId(String userId);

    int deleteUserRole(String userId, String roleId);

    PageInfo<User> findUserListByRoleId(int pageNum, int pageSize, User user, String roleId);
}
