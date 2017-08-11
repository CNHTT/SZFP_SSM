package com.extra.service.impl;

import com.extra.dao.OperatorDao;
import com.extra.model.ItemGames;
import com.extra.model.Operator;
import com.extra.model.ReportHistory;
import com.extra.model.response.ResponsePage;
import com.extra.service.OperatorService;
import com.extra.utils.BeanUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    public ResponsePage<Operator> queryByPage(Integer pageNo, Integer pageSize, Long adminID) {
        pageNo      = pageNo ==null?1:pageNo;
        pageSize    = pageSize ==null?1 :pageSize;
        PageHelper.startPage(pageNo,pageSize);
        return BeanUtils.toResponseResult(operatorDao.selectOperatorList(adminID));
    }

    /**
     *
     * @param reportHistory
     * @return
     */
    public boolean insertReport(ReportHistory reportHistory) {
        if (operatorDao.insertReport(reportHistory) ==0)return false;
        return true;
    }

    /**
     *
     * @param gamesList
     * @return
     */
    public boolean insertItemGames(List<ItemGames> gamesList) {
        if (operatorDao.inertItemGames(gamesList)==0) return false;
        return true;
    }
}
