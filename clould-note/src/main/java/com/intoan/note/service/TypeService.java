package com.intoan.note.service;

import com.intoan.note.po.Type;
import com.intoan.note.vo.ResultInfo;

import java.util.List;

public interface TypeService {

    public List<Type> findTypeList(Integer id);

    public ResultInfo<Type> delete(String typeId);

    public ResultInfo<Integer> addOrUpdate(String typeName, String typeId, Integer userId);

}
