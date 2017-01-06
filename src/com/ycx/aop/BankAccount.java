package com.ycx.aop;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>会员绑定银行卡领域对象</p>
 * @author chenfei
 * @version $Id: BankAccount.java, v 0.1 2012-11-17 下午2:38:01 cf Exp $
 */
public class BankAccount implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -835915883353426146L;

    private String            memberId;                               // 会员ID
    private String            bankCode;                               // 银行编号
    private String            bankName;                               // 银行名称
    private String            bankBranch;                             // 支行名称
    private String            bankAccountNo;                          // 银行账号
    private String            bankAccountNoDetail;                    // 银行账户明细(明文)
    private String            bankAccountSummary;                     // 银行账号摘要
    private String            realName;                               // 户名
    private String            province;                               // 省份
    private String            city;                                   // 城市
    private Integer           cardType;                               // 卡类型
    private Integer           cardAttribute;                          // 卡属性(0对公 1对私)
    private Integer           isVerified;                             // 是否认证
    private String            alias;                                  //别名
    private String            cardSkin;                               //银行卡皮肤
    private String            isSigning;                              //是否签约（Y是 N否）  
    private Integer           status;                                 // 状态
    private Long              bankcardId;                             //银行卡绑定Id
    private String            extention;                              //扩展信息
    private String            signNo;                                 //协议号
    private String            signId;                                 //内部协议号
    private String            certNo;                                 //证件号（查询返回ticket+mask)
    private String            certNoDetail;                           //证件号明文
    private String            cvNo;                                   //cvv2
    private String            cvNoDetail;                             //cvv2明文
    private String            cardValidDate;                          //有效期
    private String            cardValidDateDetail;                    //有效期明文
    private Date              agreementValidDate;                     //协议有效期
    private String            mobileNo;                               //手机号（查询返回ticket+mask)
    private String            mobileDetail;                           //手机号明文
    private String            channelCode;                            //渠道编号

    private String            mobileNoMask;                           //手机号的掩码(查询银行卡列表时需要)
    private String            mobileNoTicket;                         //手机号的ticket(查询银行卡详情时需要)
    private String            certNoMask;                             //证件号的掩码(查询银行卡详情时需要)
    private String            certNoTicket;                           //证件号的ticket;(查询银行卡列表时需要)

    private Date              activateDate;                           //激活时间
    private String            branchNo;                               //联行号

    private Integer			  accountRoleType;						  //会员角色（1卖家,2推广者）

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public Date getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Date activateDate) {
        this.activateDate = activateDate;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getSignId() {
        return signId;
    }

    public void setSignId(String signId) {
        this.signId = signId;
    }

    public Date getAgreementValidDate() {
        return agreementValidDate;
    }

    public void setAgreementValidDate(Date agreementValidDate) {
        this.agreementValidDate = agreementValidDate;
    }

    public String getSignNo() {
        return signNo;
    }

    public void setSignNo(String signNo) {
        this.signNo = signNo;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCvNo() {
        return cvNo;
    }

    public void setCvNo(String cvNo) {
        this.cvNo = cvNo;
    }

    public String getCardValidDate() {
        return cardValidDate;
    }

    public void setCardValidDate(String cardValidDate) {
        this.cardValidDate = cardValidDate;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getBankAccountSummary() {
        return bankAccountSummary;
    }

    public void setBankAccountSummary(String bankAccountSummary) {
        this.bankAccountSummary = bankAccountSummary;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getCardAttribute() {
        return cardAttribute;
    }

    public void setCardAttribute(Integer cardAttribute) {
        this.cardAttribute = cardAttribute;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCardSkin() {
        return cardSkin;
    }

    public void setCardSkin(String cardSkin) {
        this.cardSkin = cardSkin;
    }

    public String getIsSigning() {
        return isSigning;
    }

    public void setIsSigning(String isSigning) {
        this.isSigning = isSigning;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getBankcardId() {
        return bankcardId;
    }

    public void setBankcardId(Long bankcardId) {
        this.bankcardId = bankcardId;
    }

    public String getMobileNoMask() {
        return mobileNoMask;
    }

    public void setMobileNoMask(String mobileNoMask) {
        this.mobileNoMask = mobileNoMask;
    }

    public String getMobileNoTicket() {
        return mobileNoTicket;
    }

    public void setMobileNoTicket(String mobileNoTicket) {
        this.mobileNoTicket = mobileNoTicket;
    }

    public String getCertNoMask() {
        return certNoMask;
    }

    public void setCertNoMask(String certNoMask) {
        this.certNoMask = certNoMask;
    }

    public String getCertNoTicket() {
        return certNoTicket;
    }

    public void setCertNoTicket(String certNoTicket) {
        this.certNoTicket = certNoTicket;
    }

    public Integer getAccountRoleType() {
		return accountRoleType;
	}

	public void setAccountRoleType(Integer accountRoleType) {
		this.accountRoleType = accountRoleType;
	}

    public String getBankAccountNoDetail() {
        return bankAccountNoDetail;
    }

    public void setBankAccountNoDetail(String bankAccountNoDetail) {
        this.bankAccountNoDetail = bankAccountNoDetail;
    }

    public String getCertNoDetail() {
        return certNoDetail;
    }

    public void setCertNoDetail(String certNoDetail) {
        this.certNoDetail = certNoDetail;
    }

    public String getCvNoDetail() {
        return cvNoDetail;
    }

    public void setCvNoDetail(String cvNoDetail) {
        this.cvNoDetail = cvNoDetail;
    }

    public String getCardValidDateDetail() {
        return cardValidDateDetail;
    }

    public void setCardValidDateDetail(String cardValidDateDetail) {
        this.cardValidDateDetail = cardValidDateDetail;
    }

    public String getMobileDetail() {
        return mobileDetail;
    }

    public void setMobileDetail(String mobileDetail) {
        this.mobileDetail = mobileDetail;
    }

    //产品有要求不能打印卡号，cvv2，有效期，singNo关键字段
    @Override
    public String toString() {
        return (new ReflectionToStringBuilder(this) {
            protected boolean accept(Field f) {
                //排除解密后的字段
                List<String> filterList = new ArrayList<String>(Arrays.asList("bankAccountNoDetail", "certNoDetail", "cvNoDetail", "mobileDetail", "cardValidDateDetail"));
                return super.accept(f) && !filterList.contains(f.getName());
            }
        }).toString();
    }
}
