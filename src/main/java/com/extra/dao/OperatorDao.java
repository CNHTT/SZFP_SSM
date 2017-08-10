package com.extra.dao;

import com.extra.model.Operator;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Extra on 2017/8/10.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Repository
public interface OperatorDao {
    int insertOperator(Operator operator);
    int selectCount(@Param("adminID") Long adminID);
    Operator loginOperator(Operator operator);
}
