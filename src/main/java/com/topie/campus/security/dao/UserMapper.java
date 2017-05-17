package com.topie.campus.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;

import com.topie.campus.common.TreeNode;
import com.topie.campus.security.model.User;

public interface UserMapper extends Mapper<User> {

    User findUserByLoginName(@Param("loginname") String loginName);

    int insertUserRole(@Param("userId") String userId, @Param("roleId") String roleId);

    int deleteUserAllRoles(@Param("userId") String userId);

    int deleteUserRole(@Param("userId") String userId, @Param("roleId") String roleId);

    List<String> findUserRoleByUserId(String userId);

    List<User> findUserList(User user);

    int findExistUser(User user);

    List<TreeNode> findUserFunctionByLoginName(@Param("loginname") String loginName);

    List<TreeNode> findUserFunctionByLoginNameAndDisplayType(@Param("loginname") String loginName,
            @Param("displayType") Integer displayType);

    int countByLoginName(@Param("loginname") String loginName);

    int updateAccountNonLocked(@Param("userId") String UserId, @Param("accountNonLocked") Boolean accountNonLocked);

    String findLoginNameByUserId(@Param("userId") String userId);

    List<User> findUserListByRoleId(@Param("user") User user, @Param("roleId") String roleId);
}
