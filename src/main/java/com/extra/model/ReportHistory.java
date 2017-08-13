package com.extra.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by CT on 2017/8/10.
 */
public class ReportHistory implements Serializable {

    private Long id;
    private Long adminID;
    private Long operatorID;
    private String AWARD_TIME;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date operatorCreateTime;
    private String terminalID;
    private String ticketID;
    private String total;
    @Transient
    private List<ItemGames> itemGames;

    private String gameSize;


    /**
     *
     */
    private String operatorName;


    public String getGameSize() {
        return gameSize;
    }

    public void setGameSize(String gameSize) {
        this.gameSize = gameSize;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAWARD_TIME() {
        return AWARD_TIME;
    }

    public void setAWARD_TIME(String AWARD_TIME) {
        this.AWARD_TIME = AWARD_TIME;
    }

    public Date getOperatorCreateTime() {
        return operatorCreateTime;
    }

    public void setOperatorCreateTime(Date operatorCreateTime) {
        this.operatorCreateTime = operatorCreateTime;
    }

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<ItemGames> getItemGames() {
        return itemGames;
    }

    public void setItemGames(List<ItemGames> itemGames) {
        this.itemGames = itemGames;
    }
}
