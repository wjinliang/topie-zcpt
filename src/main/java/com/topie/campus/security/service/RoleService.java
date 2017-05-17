package com.topie.campus.security.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topie.campus.basedao.service.IService;
import com.topie.campus.common.TreeNode;
import com.topie.campus.core.dto.HasRoleUserDto;
import com.topie.campus.security.model.Role;

/**
 * 工程：os-app 创建人 : ChenGJ 创建时间： 2015/9/3 说明：
 */
public interface RoleService extends IService<Role> {

    int insertRole(Role role);

    int updateRole(Role role);

    Role findRoleById(String id);

    int deleteRole(String id);

    int insertRoleFunction(String roleId, Integer functionId);

    int deleteFunctionByRoleId(String roleId);

    List<Map> findRoleMatchUpFunctions();

    List<Integer> findFunctionByRoleId(String roleId);

    List<TreeNode> getRoleTreeNodes(Role role);

    PageInfo<Role> findRoleList(int pageNum, int pageSize, Role role);

    List<Role> findRoleList(Role role);

    List<String> findHasRoleUserIdsByRoleId(String roleId);

    PageInfo<HasRoleUserDto> findHasRoleUserDtoListByRoleId(int pageNum, int pageSize, HasRoleUserDto hasRoleUserDto);

    void refreshAuthAndResource(String roleId);
}
