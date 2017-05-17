package com.topie.campus.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;

import com.topie.campus.common.TreeNode;
import com.topie.campus.security.model.Function;

public interface FunctionMapper extends Mapper<Function> {

    public List<TreeNode> selectFunctionTreeNodes(Function function);

    List<Function> findFunctionList(Function function);

    int deleteRoleFunctionByFunctionId(int id);

    List<String> findRoleIdsByFunctionId(@Param("id") int id);
}
