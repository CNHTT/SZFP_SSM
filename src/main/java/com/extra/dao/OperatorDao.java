package com.extra.dao;

import com.extra.model.ItemGames;
import com.extra.model.Operator;
import com.extra.model.ReportHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
    ArrayList<Operator> selectOperatorList(Long adminID);

    int insertReport(ReportHistory reportHistory);

    int inertItemGames(List<ItemGames> list);

    ArrayList<ReportHistory> selectReportList(Long adminID);

    ArrayList<ItemGames> selectItemGameList(@Param("id") Long id, @Param("type") String type);

    ArrayList<ReportHistory> selectReportItemList(Long adminID);
}
