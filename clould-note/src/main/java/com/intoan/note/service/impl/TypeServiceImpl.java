package com.intoan.note.service.impl;

import cn.hutool.core.util.StrUtil;
import com.intoan.note.dao.TypeDao;
import com.intoan.note.po.Type;
import com.intoan.note.service.TypeService;
import com.intoan.note.vo.ResultInfo;

import java.util.List;

public class TypeServiceImpl implements TypeService {

    private TypeDao typeDao = new TypeDao();

    @Override
    public List<Type> findTypeList(Integer id) {


        List<Type> types = typeDao.selectAllTypeByUserId(id);




        return types;
    }

    @Override
    public ResultInfo<Type> delete(String typeId) {
        ResultInfo<Type> typeResultInfo = new ResultInfo<>();

        if (StrUtil.isBlank(typeId)){
            typeResultInfo.setCode(0);
            typeResultInfo.setMsg("系统异常，请重试");
            return typeResultInfo;
        }

        long noteCountByTypeId = typeDao.findNoteCountByTypeId(typeId);

        if (noteCountByTypeId > 0){
            typeResultInfo.setCode(0);
            typeResultInfo.setMsg("该类型存在子类型！不可删除");
            return typeResultInfo;
        }

        int row = typeDao.deleteTypeByTypeId(typeId);

        if (row > 0){
            typeResultInfo.setCode(1);
            typeResultInfo.setMsg("删除成功！");
        }else {
            typeResultInfo.setCode(0);
            typeResultInfo.setMsg("删除失败！");
        }

        return typeResultInfo;
    }

    @Override
    public ResultInfo<Integer> addOrUpdate(String typeName, String typeId, Integer userId) {

        ResultInfo<Integer> resultInfo = new ResultInfo<>();

        if (StrUtil.isBlank(typeName)){
            resultInfo.setCode(0);
            resultInfo.setMsg("类型名称不能为空!");
            return resultInfo;
        }

        Integer code = typeDao.checkTypeName(typeName,typeId,userId);

        if (code == 0){
            resultInfo.setCode(0);
            resultInfo.setMsg("类型名称重复!");
            return resultInfo;
        }

        Integer row = null;
        if (StrUtil.isBlank(typeId)){
            row = typeDao.addTypeByUserId(typeName,userId);
        }else {

            row = typeDao.updateTypeByTypeId(typeName,typeId);
        }


        if (row > 0 ){
            resultInfo.setCode(1);
            resultInfo.setResult(row);

        }else {
            resultInfo.setCode(0);
            resultInfo.setMsg("更新失败！");

        }

        return resultInfo;
    }


}
