package com.ycx.dao;

import java.math.BigDecimal;
import java.util.Date;

public class AcqTradeOrderExtDO {
    /**
     * 交易凭证号
     */
    private String     tradeVoucherNo;

    /**
     * 商品信息
     */
    private String     prodDesc;

    /**
     * 商品展示URL
     */
    private String     prodShowUrl;

    /**
     * 下订金额
     */
    private BigDecimal prepaidAmount;

    /**
     * 下订交易关联凭证号
     */
    private String     prepaidVoucherNo;

    /**
     * 金币金额
     */
    private BigDecimal coinAmount;

    /**
     * 担保金额
     */
    private BigDecimal ensureAmount;

    /**
     * 已付款金额
     */
    private BigDecimal paidAmount;

    /**
     * 已结算金额
     */
    private BigDecimal settledAmount;

    /**
     * 创建时间
     */
    private Date       gmtCreate;

    /**
     * 修改时间
     */
    private Date       gmtModified;

    /**
     * 支付时间
     */
    private Date       gmtPaid;

    /**
     * 退担保金额
     */
    private BigDecimal refundEnsureAmount;

    /**
     * 已退结算金额
     */
    private BigDecimal refundedSettleAmount;

    /**
     * 已退付款金额
     */
    private BigDecimal refundedPayAmount;

    public String getTradeVoucherNo() {
        return tradeVoucherNo;
    }

    public void setTradeVoucherNo(String tradeVoucherNo) {
        this.tradeVoucherNo = tradeVoucherNo == null ? null : tradeVoucherNo.trim();
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc == null ? null : prodDesc.trim();
    }

    public String getProdShowUrl() {
        return prodShowUrl;
    }

    public void setProdShowUrl(String prodShowUrl) {
        this.prodShowUrl = prodShowUrl == null ? null : prodShowUrl.trim();
    }

    public BigDecimal getPrepaidAmount() {
        return prepaidAmount;
    }

    public void setPrepaidAmount(BigDecimal prepaidAmount) {
        this.prepaidAmount = prepaidAmount;
    }

    public String getPrepaidVoucherNo() {
        return prepaidVoucherNo;
    }

    public void setPrepaidVoucherNo(String prepaidVoucherNo) {
        this.prepaidVoucherNo = prepaidVoucherNo == null ? null : prepaidVoucherNo.trim();
    }

    public BigDecimal getCoinAmount() {
        return coinAmount;
    }

    public void setCoinAmount(BigDecimal coinAmount) {
        this.coinAmount = coinAmount;
    }

    public BigDecimal getEnsureAmount() {
        return ensureAmount;
    }

    public void setEnsureAmount(BigDecimal ensureAmount) {
        this.ensureAmount = ensureAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getSettledAmount() {
        return settledAmount;
    }

    public void setSettledAmount(BigDecimal settledAmount) {
        this.settledAmount = settledAmount;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtPaid() {
        return gmtPaid;
    }

    public void setGmtPaid(Date gmtPaid) {
        this.gmtPaid = gmtPaid;
    }

    public BigDecimal getRefundEnsureAmount() {
        return refundEnsureAmount;
    }

    public void setRefundEnsureAmount(BigDecimal refundEnsureAmount) {
        this.refundEnsureAmount = refundEnsureAmount;
    }

    public BigDecimal getRefundedSettleAmount() {
        return refundedSettleAmount;
    }

    public void setRefundedSettleAmount(BigDecimal refundedSettleAmount) {
        this.refundedSettleAmount = refundedSettleAmount;
    }

    public BigDecimal getRefundedPayAmount() {
        return refundedPayAmount;
    }

    public void setRefundedPayAmount(BigDecimal refundedPayAmount) {
        this.refundedPayAmount = refundedPayAmount;
    }
}