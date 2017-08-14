package com.extra.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CT on 2017/8/10.
 */
public class ItemGames implements Serializable {
    private Long id;
    private Long adminID;
    private Long operatorID;
    private Long reportHistoryID;
    private String  itemGame;
    private String  secoValue;
    private String itemGameValue;
    private String gameKey;

    private String  operatorName;
    private String  gameName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date ceateTime;


    public Date getCeateTime() {
        return ceateTime;
    }

    public void setCeateTime(Date ceateTime) {
        this.ceateTime = ceateTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Long getIdl() {
        return id;
    }

    public void setIdl(Long idl) {
        this.id = idl;
    }

    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public Long getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(Long operatorID) {
        this.operatorID = operatorID;
    }

    public Long getReportHistoryID() {
        return reportHistoryID;
    }

    public void setReportHistoryID(Long reportHistoryID) {
        this.reportHistoryID = reportHistoryID;
    }

    public String getItemGame() {
        return itemGame;
    }

    public void setItemGame(String itemGame) {
        this.itemGame = itemGame;
    }

    public String getSecoValue() {
        return secoValue;
    }

    public void setSecoValue(String secoValue) {
        this.secoValue = secoValue;
    }

    public String getItemGameValue() {
        return itemGameValue;
    }

    public void setItemGameValue(String itemGameValue) {
        this.itemGameValue = itemGameValue;
    }

    public String getGameKey() {
        return gameKey;
    }

    public void setGameKey(String gameKey) {
        this.gameKey = gameKey;
    }
}
