package com.extra.service;

import com.extra.model.Operator;

/**
 * Created by Extra on 2017/8/10.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public interface OperatorService {
    boolean insertOperator(Operator operator);
    int  getOpNum(Long adminID);
    Operator loginMP(Operator operator);

}
