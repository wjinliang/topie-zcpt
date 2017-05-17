package com.topie.campus.security.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;

import com.topie.campus.common.TreeNode;
import com.topie.campus.core.dto.HasRoleUserDto;
import com.topie.campus.security.model.Role;

public interface RoleMapper extends Mapper<Role> {

    int insertRoleFunction(@Param("roleId") String roleId,@Param("functionId")  Integer functionId);

    List<Map> findRoleMatchUpFunctions();

    List<TreeNode> selectRoleTreeNodes(Role role);

    List<Role> findRoleList(Role role);

    List<Integer> findFunctionByRoleId(@Param("roleId") String roleId);

    int deleteFunctionByRoleId(@Param("roleId") String roleId);

    List<HasRoleUserDto> findHasRoleUserDtoList(HasRoleUserDto hasRoleUserDto);

    void deleteUserRoleRelateByRoleId(String id);

    List<String> findHasRoleUserIdsByRoleId(@Param("roleId") String roleId);
}
