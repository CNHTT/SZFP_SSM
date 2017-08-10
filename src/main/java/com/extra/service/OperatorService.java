package com.extra.service;

import com.extra.model.Operator;
import com.extra.model.response.ResponsePage;

/**
 * Created by Extra on 2017/8/10.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public interface OperatorService {
    boolean insertOperator(Operator operator);
    int  getOpNum(Long adminID);
    Operator loginMP(Operator operator);
    ResponsePage<Operator> queryByPage(Integer pageNumber, Integer pageSize, Long adminID);
}