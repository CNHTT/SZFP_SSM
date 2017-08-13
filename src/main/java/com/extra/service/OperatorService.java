package com.extra.service;

import com.extra.model.ItemGames;
import com.extra.model.Operator;
import com.extra.model.ReportHistory;
import com.extra.model.response.ResponsePage;

import java.util.List;

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
    boolean insertReport(ReportHistory  reportHistory);

    boolean insertItemGames(List<ItemGames> gamesList);

    ResponsePage<ReportHistory> queryByReportPage(Integer pageNumber, Integer pageSize, Long adminID);

    ResponsePage<ItemGames> queryByItemGameList(Integer pageNumber, Integer pageSize, Long adminID, String type);

    ResponsePage<ReportHistory> queryByReportLiPage(Integer pageNumber, Integer pageSize, Long adminID);
}
