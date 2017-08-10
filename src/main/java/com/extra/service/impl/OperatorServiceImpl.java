package com.extra.service.impl;

import com.extra.dao.OperatorDao;
import com.extra.model.Operator;
import com.extra.service.OperatorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Extra on 2017/8/10.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OperatorServiceImpl implements OperatorService {

    @Resource
    private OperatorDao operatorDao;


    /**
     * 添加操作人员
     * @param operator
     * @return
     */
    public boolean insertOperator(Operator operator) {
        if (operatorDao.insertOperator(operator)==0)return false;
        return true;
    }

    public int getOpNum(Long adminID) {
        return operatorDao.selectCount(adminID);
    }

    public Operator loginMP(Operator operator) {
        return operatorDao.loginOperator(operator);
    }
}
