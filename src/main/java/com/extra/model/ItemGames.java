package com.extra.model;

/**
 * Created by CT on 2017/8/10.
 */
public class ItemGames {
    private Long idl;
    private Long adminID;
    private Long operatorID;
    private Long reportHistoryID;
    private String  itemGame;
    private String  secoValue;
    private String itemGameValue;
    private String gameKey;

    public Long getIdl() {
        return idl;
    }

    public void setIdl(Long idl) {
        this.idl = idl;
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
