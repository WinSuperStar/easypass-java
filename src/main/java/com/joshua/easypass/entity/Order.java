package com.joshua.easypass.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderid;
    private Integer carid;
    private String carnum;
    private Date carRegDate;
    private String carbrand;
    private String carset;
    private String carRegImgPath;
    private String carOtherCertPath;
    private Integer cusid;
    private String cusname;
    private String carAddr;
    private String carPlateCode;
    private String carPlateNum;
    private Integer vdrid;
    private String vdrContact;
    private String oriOwnerName;
    private String oriOwnerPhone;
    private String newOwnerName;
    private String newOwnerPhone;
    private Date itemDeadline;
    private Date itemPlanDate;
    private String weizhangStatus;
    private String weizhangHandle;
    private String weizhangDesc;
    private String nianjianStatus;
    private String nianjianHandle;
    private String nianjianDesc;
    private String diyaStatus;
    private String diyaHandle;
    private String diyaDesc;
    private String paizhengStatus;
    private String paizhengHandle;
    private String paizhengDesc;
    private float qitaCost;
    private String qitaDesc;
    private String cheliangcailiao;
    private String cheliangdengjizhengjian;
    private String xingshizheng;
    private String gongzhang;
    private String oriShenfenzheng;
    private String oriJuzhuzheng;
    private String yingyezhizhao;
    private String qitaxinxi;
    private String kuaidiNum;
    private float kuaidiCost;
    private String kuaidiImgPath;
    private String kuaidiSets;
    // tidang
    private String itemTidang;
    private float itemTidangTax;
    private float itemTidangCost;
    private Date itemTidangCompletedate;
    private String itemTidangDesc;
    private Integer itemTidangReqId;
    // guohu
    private String itemGuohu;
    private float itemGuohuTax;
    private float itemGuohuCost;
    private Date itemGuohuCompletedate;
    private String itemGuohuDesc;
    private Integer itemGuohuReqId;
    //shangpai
    private String itemShangpai;
    private float itemShangpaiTax;
    private float itemShangpaiCost;
    private Date itemShangpaiCompletedate;
    private String itemShangpaiDesc;
    private Integer itemShangpaiReqId;
    //weizhang
    private String itemWeizhang;
    private float itemWeizhangCost;
    private float itemWeizhangCost2;
    private Date itemWeizhangCompletedate;
    private String itemWeizhangDesc;
    private Integer itemWeizhangReqId;
    //diya
    private String itemDiya;
    private float itemDiyaCost;
    private Date itemDiyaCompletedate;
    private String itemDiyaDesc;
    private Integer itemDiyaReqId;
    //jiechudiya
    private String itemJiechudiya;
    private float itemJiechudiyaCost;
    private Date itemJiechudiyaCompletedate;
    private String itemJiechudiyaDesc;
    private Integer itemJiechudiyaReqId;
    //weituo
    private String itemWeituo;
    private float itemWeituoTax;
    private float itemWeituoCost;
    private Date itemWeituoCompletedate;
    private String itemWeituoDesc;
    private Integer itemWeituoReqId;
    //nianjian
    private String itemNianjian;
    private float itemNianjianTax;
    private float itemNianjianCost;
    private Date itemNianjianCompletedate;
    private String itemNianjianDesc;
    private Integer itemNianjianReqId;
    //buhuan
    private String itemBuhuan;
    private float itemBuhuanTax;
    private float itemBuhuanCost;
    private Date itemBuhuanCompletedate;
    private String itemBuhuanDesc;
    private Integer itemBuhuanReqId;
    //qita
    private String itemQita;
    private float itemQitaCost;
    private Date itemQitaCompletedate;
    private String itemQitaDesc;
    private Integer itemQitaReqId;
    private String state;
    private String financeState;
    private float financeSum;
    private Date commitdate;
    private Date createdate;
    private String creator;
    private String add1;
    private String add2;
    private String add3;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public Date getCarRegDate() {
        return carRegDate;
    }

    public void setCarRegDate(Date carRegDate) {
        this.carRegDate = carRegDate;
    }

    public String getCarbrand() {
        return carbrand;
    }

    public void setCarbrand(String carbrand) {
        this.carbrand = carbrand;
    }

    public String getCarset() {
        return carset;
    }

    public void setCarset(String carset) {
        this.carset = carset;
    }

    public String getCarRegImgPath() {
        return carRegImgPath;
    }

    public void setCarRegImgPath(String carRegImgPath) {
        this.carRegImgPath = carRegImgPath;
    }

    public String getCarOtherCertPath() {
        return carOtherCertPath;
    }

    public void setCarOtherCertPath(String carOtherCertPath) {
        this.carOtherCertPath = carOtherCertPath;
    }

    public Integer getCusid() {
        return cusid;
    }

    public void setCusid(Integer cusid) {
        this.cusid = cusid;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getCarAddr() {
        return carAddr;
    }

    public void setCarAddr(String carAddr) {
        this.carAddr = carAddr;
    }

    public String getCarPlateCode() {
        return carPlateCode;
    }

    public void setCarPlateCode(String carPlateCode) {
        this.carPlateCode = carPlateCode;
    }

    public String getCarPlateNum() {
        return carPlateNum;
    }

    public void setCarPlateNum(String carPlateNum) {
        this.carPlateNum = carPlateNum;
    }

    public Integer getVdrid() {
        return vdrid;
    }

    public void setVdrid(Integer vdrid) {
        this.vdrid = vdrid;
    }

    public String getVdrContact() {
        return vdrContact;
    }

    public void setVdrContact(String vdrContact) {
        this.vdrContact = vdrContact;
    }

    public String getOriOwnerName() {
        return oriOwnerName;
    }

    public void setOriOwnerName(String oriOwnerName) {
        this.oriOwnerName = oriOwnerName;
    }

    public String getOriOwnerPhone() {
        return oriOwnerPhone;
    }

    public void setOriOwnerPhone(String oriOwnerPhone) {
        this.oriOwnerPhone = oriOwnerPhone;
    }

    public String getNewOwnerName() {
        return newOwnerName;
    }

    public void setNewOwnerName(String newOwnerName) {
        this.newOwnerName = newOwnerName;
    }

    public String getNewOwnerPhone() {
        return newOwnerPhone;
    }

    public void setNewOwnerPhone(String newOwnerPhone) {
        this.newOwnerPhone = newOwnerPhone;
    }

    public Date getItemDeadline() {
        return itemDeadline;
    }

    public void setItemDeadline(Date itemDeadline) {
        this.itemDeadline = itemDeadline;
    }

    public Date getItemPlanDate() {
        return itemPlanDate;
    }

    public void setItemPlanDate(Date itemPlanDate) {
        this.itemPlanDate = itemPlanDate;
    }

    public String getWeizhangStatus() {
        return weizhangStatus;
    }

    public void setWeizhangStatus(String weizhangStatus) {
        this.weizhangStatus = weizhangStatus;
    }

    public String getWeizhangHandle() {
        return weizhangHandle;
    }

    public void setWeizhangHandle(String weizhangHandle) {
        this.weizhangHandle = weizhangHandle;
    }

    public String getWeizhangDesc() {
        return weizhangDesc;
    }

    public void setWeizhangDesc(String weizhangDesc) {
        this.weizhangDesc = weizhangDesc;
    }

    public String getNianjianStatus() {
        return nianjianStatus;
    }

    public void setNianjianStatus(String nianjianStatus) {
        this.nianjianStatus = nianjianStatus;
    }

    public String getNianjianHandle() {
        return nianjianHandle;
    }

    public void setNianjianHandle(String nianjianHandle) {
        this.nianjianHandle = nianjianHandle;
    }

    public String getNianjianDesc() {
        return nianjianDesc;
    }

    public void setNianjianDesc(String nianjianDesc) {
        this.nianjianDesc = nianjianDesc;
    }

    public String getDiyaStatus() {
        return diyaStatus;
    }

    public void setDiyaStatus(String diyaStatus) {
        this.diyaStatus = diyaStatus;
    }

    public String getDiyaHandle() {
        return diyaHandle;
    }

    public void setDiyaHandle(String diyaHandle) {
        this.diyaHandle = diyaHandle;
    }

    public String getDiyaDesc() {
        return diyaDesc;
    }

    public void setDiyaDesc(String diyaDesc) {
        this.diyaDesc = diyaDesc;
    }

    public String getPaizhengStatus() {
        return paizhengStatus;
    }

    public void setPaizhengStatus(String paizhengStatus) {
        this.paizhengStatus = paizhengStatus;
    }

    public String getPaizhengHandle() {
        return paizhengHandle;
    }

    public void setPaizhengHandle(String paizhengHandle) {
        this.paizhengHandle = paizhengHandle;
    }

    public String getPaizhengDesc() {
        return paizhengDesc;
    }

    public void setPaizhengDesc(String paizhengDesc) {
        this.paizhengDesc = paizhengDesc;
    }

    public float getQitaCost() {
        return qitaCost;
    }

    public void setQitaCost(float qitaCost) {
        this.qitaCost = qitaCost;
    }

    public String getQitaDesc() {
        return qitaDesc;
    }

    public void setQitaDesc(String qitaDesc) {
        this.qitaDesc = qitaDesc;
    }

    public String getCheliangcailiao() {
        return cheliangcailiao;
    }

    public void setCheliangcailiao(String cheliangcailiao) {
        this.cheliangcailiao = cheliangcailiao;
    }

    public String getCheliangdengjizhengjian() {
        return cheliangdengjizhengjian;
    }

    public void setCheliangdengjizhengjian(String cheliangdengjizhengjian) {
        this.cheliangdengjizhengjian = cheliangdengjizhengjian;
    }

    public String getXingshizheng() {
        return xingshizheng;
    }

    public void setXingshizheng(String xingshizheng) {
        this.xingshizheng = xingshizheng;
    }

    public String getGongzhang() {
        return gongzhang;
    }

    public void setGongzhang(String gongzhang) {
        this.gongzhang = gongzhang;
    }

    public String getOriShenfenzheng() {
        return oriShenfenzheng;
    }

    public void setOriShenfenzheng(String oriShenfenzheng) {
        this.oriShenfenzheng = oriShenfenzheng;
    }

    public String getOriJuzhuzheng() {
        return oriJuzhuzheng;
    }

    public void setOriJuzhuzheng(String oriJuzhuzheng) {
        this.oriJuzhuzheng = oriJuzhuzheng;
    }

    public String getYingyezhizhao() {
        return yingyezhizhao;
    }

    public void setYingyezhizhao(String yingyezhizhao) {
        this.yingyezhizhao = yingyezhizhao;
    }

    public String getQitaxinxi() {
        return qitaxinxi;
    }

    public void setQitaxinxi(String qitaxinxi) {
        this.qitaxinxi = qitaxinxi;
    }

    public String getKuaidiNum() {
        return kuaidiNum;
    }

    public void setKuaidiNum(String kuaidiNum) {
        this.kuaidiNum = kuaidiNum;
    }

    public float getKuaidiCost() {
        return kuaidiCost;
    }

    public void setKuaidiCost(float kuaidiCost) {
        this.kuaidiCost = kuaidiCost;
    }

    public String getKuaidiImgPath() {
        return kuaidiImgPath;
    }

    public void setKuaidiImgPath(String kuaidiImgPath) {
        this.kuaidiImgPath = kuaidiImgPath;
    }

    public String getKuaidiSets() {
        return kuaidiSets;
    }

    public void setKuaidiSets(String kuaidiSets) {
        this.kuaidiSets = kuaidiSets;
    }

    public String getItemTidang() {
        return itemTidang;
    }

    public void setItemTidang(String itemTidang) {
        this.itemTidang = itemTidang;
    }

    public float getItemTidangTax() {
        return itemTidangTax;
    }

    public void setItemTidangTax(float itemTidangTax) {
        this.itemTidangTax = itemTidangTax;
    }

    public float getItemTidangCost() {
        return itemTidangCost;
    }

    public void setItemTidangCost(float itemTidangCost) {
        this.itemTidangCost = itemTidangCost;
    }

    public Date getItemTidangCompletedate() {
        return itemTidangCompletedate;
    }

    public void setItemTidangCompletedate(Date itemTidangCompletedate) {
        this.itemTidangCompletedate = itemTidangCompletedate;
    }

    public String getItemTidangDesc() {
        return itemTidangDesc;
    }

    public void setItemTidangDesc(String itemTidangDesc) {
        this.itemTidangDesc = itemTidangDesc;
    }

    public Integer getItemTidangReqId() {
        return itemTidangReqId;
    }

    public void setItemTidangReqId(Integer itemTidangReqId) {
        this.itemTidangReqId = itemTidangReqId;
    }

    public String getItemGuohu() {
        return itemGuohu;
    }

    public void setItemGuohu(String itemGuohu) {
        this.itemGuohu = itemGuohu;
    }

    public float getItemGuohuTax() {
        return itemGuohuTax;
    }

    public void setItemGuohuTax(float itemGuohuTax) {
        this.itemGuohuTax = itemGuohuTax;
    }

    public float getItemGuohuCost() {
        return itemGuohuCost;
    }

    public void setItemGuohuCost(float itemGuohuCost) {
        this.itemGuohuCost = itemGuohuCost;
    }

    public Date getItemGuohuCompletedate() {
        return itemGuohuCompletedate;
    }

    public void setItemGuohuCompletedate(Date itemGuohuCompletedate) {
        this.itemGuohuCompletedate = itemGuohuCompletedate;
    }

    public String getItemGuohuDesc() {
        return itemGuohuDesc;
    }

    public void setItemGuohuDesc(String itemGuohuDesc) {
        this.itemGuohuDesc = itemGuohuDesc;
    }

    public Integer getItemGuohuReqId() {
        return itemGuohuReqId;
    }

    public void setItemGuohuReqId(Integer itemGuohuReqId) {
        this.itemGuohuReqId = itemGuohuReqId;
    }

    public String getItemShangpai() {
        return itemShangpai;
    }

    public void setItemShangpai(String itemShangpai) {
        this.itemShangpai = itemShangpai;
    }

    public float getItemShangpaiTax() {
        return itemShangpaiTax;
    }

    public void setItemShangpaiTax(float itemShangpaiTax) {
        this.itemShangpaiTax = itemShangpaiTax;
    }

    public float getItemShangpaiCost() {
        return itemShangpaiCost;
    }

    public void setItemShangpaiCost(float itemShangpaiCost) {
        this.itemShangpaiCost = itemShangpaiCost;
    }

    public Date getItemShangpaiCompletedate() {
        return itemShangpaiCompletedate;
    }

    public void setItemShangpaiCompletedate(Date itemShangpaiCompletedate) {
        this.itemShangpaiCompletedate = itemShangpaiCompletedate;
    }

    public String getItemShangpaiDesc() {
        return itemShangpaiDesc;
    }

    public void setItemShangpaiDesc(String itemShangpaiDesc) {
        this.itemShangpaiDesc = itemShangpaiDesc;
    }

    public Integer getItemShangpaiReqId() {
        return itemShangpaiReqId;
    }

    public void setItemShangpaiReqId(Integer itemShangpaiReqId) {
        this.itemShangpaiReqId = itemShangpaiReqId;
    }

    public String getItemWeizhang() {
        return itemWeizhang;
    }

    public void setItemWeizhang(String itemWeizhang) {
        this.itemWeizhang = itemWeizhang;
    }

    public float getItemWeizhangCost() {
        return itemWeizhangCost;
    }

    public void setItemWeizhangCost(float itemWeizhangCost) {
        this.itemWeizhangCost = itemWeizhangCost;
    }

    public float getItemWeizhangCost2() {
        return itemWeizhangCost2;
    }

    public void setItemWeizhangCost2(float itemWeizhangCost2) {
        this.itemWeizhangCost2 = itemWeizhangCost2;
    }

    public Date getItemWeizhangCompletedate() {
        return itemWeizhangCompletedate;
    }

    public void setItemWeizhangCompletedate(Date itemWeizhangCompletedate) {
        this.itemWeizhangCompletedate = itemWeizhangCompletedate;
    }

    public String getItemWeizhangDesc() {
        return itemWeizhangDesc;
    }

    public void setItemWeizhangDesc(String itemWeizhangDesc) {
        this.itemWeizhangDesc = itemWeizhangDesc;
    }

    public Integer getItemWeizhangReqId() {
        return itemWeizhangReqId;
    }

    public void setItemWeizhangReqId(Integer itemWeizhangReqId) {
        this.itemWeizhangReqId = itemWeizhangReqId;
    }

    public String getItemDiya() {
        return itemDiya;
    }

    public void setItemDiya(String itemDiya) {
        this.itemDiya = itemDiya;
    }

    public float getItemDiyaCost() {
        return itemDiyaCost;
    }

    public void setItemDiyaCost(float itemDiyaCost) {
        this.itemDiyaCost = itemDiyaCost;
    }

    public Date getItemDiyaCompletedate() {
        return itemDiyaCompletedate;
    }

    public void setItemDiyaCompletedate(Date itemDiyaCompletedate) {
        this.itemDiyaCompletedate = itemDiyaCompletedate;
    }

    public String getItemDiyaDesc() {
        return itemDiyaDesc;
    }

    public void setItemDiyaDesc(String itemDiyaDesc) {
        this.itemDiyaDesc = itemDiyaDesc;
    }

    public Integer getItemDiyaReqId() {
        return itemDiyaReqId;
    }

    public void setItemDiyaReqId(Integer itemDiyaReqId) {
        this.itemDiyaReqId = itemDiyaReqId;
    }

    public String getItemJiechudiya() {
        return itemJiechudiya;
    }

    public void setItemJiechudiya(String itemJiechudiya) {
        this.itemJiechudiya = itemJiechudiya;
    }

    public float getItemJiechudiyaCost() {
        return itemJiechudiyaCost;
    }

    public void setItemJiechudiyaCost(float itemJiechudiyaCost) {
        this.itemJiechudiyaCost = itemJiechudiyaCost;
    }

    public Date getItemJiechudiyaCompletedate() {
        return itemJiechudiyaCompletedate;
    }

    public void setItemJiechudiyaCompletedate(Date itemJiechudiyaCompletedate) {
        this.itemJiechudiyaCompletedate = itemJiechudiyaCompletedate;
    }

    public String getItemJiechudiyaDesc() {
        return itemJiechudiyaDesc;
    }

    public void setItemJiechudiyaDesc(String itemJiechudiyaDesc) {
        this.itemJiechudiyaDesc = itemJiechudiyaDesc;
    }

    public Integer getItemJiechudiyaReqId() {
        return itemJiechudiyaReqId;
    }

    public void setItemJiechudiyaReqId(Integer itemJiechudiyaReqId) {
        this.itemJiechudiyaReqId = itemJiechudiyaReqId;
    }

    public String getItemWeituo() {
        return itemWeituo;
    }

    public void setItemWeituo(String itemWeituo) {
        this.itemWeituo = itemWeituo;
    }

    public float getItemWeituoTax() {
        return itemWeituoTax;
    }

    public void setItemWeituoTax(float itemWeituoTax) {
        this.itemWeituoTax = itemWeituoTax;
    }

    public float getItemWeituoCost() {
        return itemWeituoCost;
    }

    public void setItemWeituoCost(float itemWeituoCost) {
        this.itemWeituoCost = itemWeituoCost;
    }

    public Date getItemWeituoCompletedate() {
        return itemWeituoCompletedate;
    }

    public void setItemWeituoCompletedate(Date itemWeituoCompletedate) {
        this.itemWeituoCompletedate = itemWeituoCompletedate;
    }

    public String getItemWeituoDesc() {
        return itemWeituoDesc;
    }

    public void setItemWeituoDesc(String itemWeituoDesc) {
        this.itemWeituoDesc = itemWeituoDesc;
    }

    public Integer getItemWeituoReqId() {
        return itemWeituoReqId;
    }

    public void setItemWeituoReqId(Integer itemWeituoReqId) {
        this.itemWeituoReqId = itemWeituoReqId;
    }

    public String getItemNianjian() {
        return itemNianjian;
    }

    public void setItemNianjian(String itemNianjian) {
        this.itemNianjian = itemNianjian;
    }

    public float getItemNianjianTax() {
        return itemNianjianTax;
    }

    public void setItemNianjianTax(float itemNianjianTax) {
        this.itemNianjianTax = itemNianjianTax;
    }

    public float getItemNianjianCost() {
        return itemNianjianCost;
    }

    public void setItemNianjianCost(float itemNianjianCost) {
        this.itemNianjianCost = itemNianjianCost;
    }

    public Date getItemNianjianCompletedate() {
        return itemNianjianCompletedate;
    }

    public void setItemNianjianCompletedate(Date itemNianjianCompletedate) {
        this.itemNianjianCompletedate = itemNianjianCompletedate;
    }

    public String getItemNianjianDesc() {
        return itemNianjianDesc;
    }

    public void setItemNianjianDesc(String itemNianjianDesc) {
        this.itemNianjianDesc = itemNianjianDesc;
    }

    public Integer getItemNianjianReqId() {
        return itemNianjianReqId;
    }

    public void setItemNianjianReqId(Integer itemNianjianReqId) {
        this.itemNianjianReqId = itemNianjianReqId;
    }

    public String getItemBuhuan() {
        return itemBuhuan;
    }

    public void setItemBuhuan(String itemBuhuan) {
        this.itemBuhuan = itemBuhuan;
    }

    public float getItemBuhuanTax() {
        return itemBuhuanTax;
    }

    public void setItemBuhuanTax(float itemBuhuanTax) {
        this.itemBuhuanTax = itemBuhuanTax;
    }

    public float getItemBuhuanCost() {
        return itemBuhuanCost;
    }

    public void setItemBuhuanCost(float itemBuhuanCost) {
        this.itemBuhuanCost = itemBuhuanCost;
    }

    public Date getItemBuhuanCompletedate() {
        return itemBuhuanCompletedate;
    }

    public void setItemBuhuanCompletedate(Date itemBuhuanCompletedate) {
        this.itemBuhuanCompletedate = itemBuhuanCompletedate;
    }

    public String getItemBuhuanDesc() {
        return itemBuhuanDesc;
    }

    public void setItemBuhuanDesc(String itemBuhuanDesc) {
        this.itemBuhuanDesc = itemBuhuanDesc;
    }

    public Integer getItemBuhuanReqId() {
        return itemBuhuanReqId;
    }

    public void setItemBuhuanReqId(Integer itemBuhuanReqId) {
        this.itemBuhuanReqId = itemBuhuanReqId;
    }

    public String getItemQita() {
        return itemQita;
    }

    public void setItemQita(String itemQita) {
        this.itemQita = itemQita;
    }

    public float getItemQitaCost() {
        return itemQitaCost;
    }

    public void setItemQitaCost(float itemQitaCost) {
        this.itemQitaCost = itemQitaCost;
    }

    public Date getItemQitaCompletedate() {
        return itemQitaCompletedate;
    }

    public void setItemQitaCompletedate(Date itemQitaCompletedate) {
        this.itemQitaCompletedate = itemQitaCompletedate;
    }

    public String getItemQitaDesc() {
        return itemQitaDesc;
    }

    public void setItemQitaDesc(String itemQitaDesc) {
        this.itemQitaDesc = itemQitaDesc;
    }

    public Integer getItemQitaReqId() {
        return itemQitaReqId;
    }

    public void setItemQitaReqId(Integer itemQitaReqId) {
        this.itemQitaReqId = itemQitaReqId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFinanceState() {
        return financeState;
    }

    public void setFinanceState(String financeState) {
        this.financeState = financeState;
    }

    public float getFinanceSum() {
        return financeSum;
    }

    public void setFinanceSum(float financeSum) {
        this.financeSum = financeSum;
    }

    public Date getCommitdate() {
        return commitdate;
    }

    public void setCommitdate(Date commitdate) {
        this.commitdate = commitdate;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public String getAdd3() {
        return add3;
    }

    public void setAdd3(String add3) {
        this.add3 = add3;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", carid=" + carid +
                ", carnum='" + carnum + '\'' +
                ", carRegDate=" + carRegDate +
                ", carbrand='" + carbrand + '\'' +
                ", carset='" + carset + '\'' +
                ", carRegImgPath='" + carRegImgPath + '\'' +
                ", carOtherCertPath='" + carOtherCertPath + '\'' +
                ", cusid=" + cusid +
                ", cusname='" + cusname + '\'' +
                ", carAddr='" + carAddr + '\'' +
                ", carPlateCode='" + carPlateCode + '\'' +
                ", carPlateNum='" + carPlateNum + '\'' +
                ", vdrid=" + vdrid +
                ", vdrContact='" + vdrContact + '\'' +
                ", oriOwnerName='" + oriOwnerName + '\'' +
                ", oriOwnerPhone='" + oriOwnerPhone + '\'' +
                ", newOwnerName='" + newOwnerName + '\'' +
                ", newOwnerPhone='" + newOwnerPhone + '\'' +
                ", itemDeadline=" + itemDeadline +
                ", itemPlanDate=" + itemPlanDate +
                ", weizhangStatus='" + weizhangStatus + '\'' +
                ", weizhangHandle='" + weizhangHandle + '\'' +
                ", weizhangDesc='" + weizhangDesc + '\'' +
                ", nianjianStatus='" + nianjianStatus + '\'' +
                ", nianjianHandle='" + nianjianHandle + '\'' +
                ", nianjianDesc='" + nianjianDesc + '\'' +
                ", diyaStatus='" + diyaStatus + '\'' +
                ", diyaHandle='" + diyaHandle + '\'' +
                ", diyaDesc='" + diyaDesc + '\'' +
                ", paizhengStatus='" + paizhengStatus + '\'' +
                ", paizhengHandle='" + paizhengHandle + '\'' +
                ", paizhengDesc='" + paizhengDesc + '\'' +
                ", qitaCost=" + qitaCost +
                ", qitaDesc='" + qitaDesc + '\'' +
                ", cheliangcailiao='" + cheliangcailiao + '\'' +
                ", cheliangdengjizhengjian='" + cheliangdengjizhengjian + '\'' +
                ", xingshizheng='" + xingshizheng + '\'' +
                ", gongzhang='" + gongzhang + '\'' +
                ", oriShenfenzheng='" + oriShenfenzheng + '\'' +
                ", oriJuzhuzheng='" + oriJuzhuzheng + '\'' +
                ", yingyezhizhao='" + yingyezhizhao + '\'' +
                ", qitaxinxi='" + qitaxinxi + '\'' +
                ", kuaidiNum='" + kuaidiNum + '\'' +
                ", kuaidiCost=" + kuaidiCost +
                ", kuaidiImgPath='" + kuaidiImgPath + '\'' +
                ", kuaidiSets='" + kuaidiSets + '\'' +
                ", itemTidang='" + itemTidang + '\'' +
                ", itemTidangTax=" + itemTidangTax +
                ", itemTidangCost=" + itemTidangCost +
                ", itemTidangCompletedate=" + itemTidangCompletedate +
                ", itemTidangDesc='" + itemTidangDesc + '\'' +
                ", itemTidangReqId=" + itemTidangReqId +
                ", itemGuohu='" + itemGuohu + '\'' +
                ", itemGuohuTax=" + itemGuohuTax +
                ", itemGuohuCost=" + itemGuohuCost +
                ", itemGuohuCompletedate=" + itemGuohuCompletedate +
                ", itemGuohuDesc='" + itemGuohuDesc + '\'' +
                ", itemGuohuReqId=" + itemGuohuReqId +
                ", itemShangpai='" + itemShangpai + '\'' +
                ", itemShangpaiTax=" + itemShangpaiTax +
                ", itemShangpaiCost=" + itemShangpaiCost +
                ", itemShangpaiCompletedate=" + itemShangpaiCompletedate +
                ", itemShangpaiDesc='" + itemShangpaiDesc + '\'' +
                ", itemShangpaiReqId=" + itemShangpaiReqId +
                ", itemWeizhang='" + itemWeizhang + '\'' +
                ", itemWeizhangCost=" + itemWeizhangCost +
                ", itemWeizhangCost2=" + itemWeizhangCost2 +
                ", itemWeizhangCompletedate=" + itemWeizhangCompletedate +
                ", itemWeizhangDesc='" + itemWeizhangDesc + '\'' +
                ", itemWeizhangReqId=" + itemWeizhangReqId +
                ", itemDiya='" + itemDiya + '\'' +
                ", itemDiyaCost=" + itemDiyaCost +
                ", itemDiyaCompletedate=" + itemDiyaCompletedate +
                ", itemDiyaDesc='" + itemDiyaDesc + '\'' +
                ", itemDiyaReqId=" + itemDiyaReqId +
                ", itemJiechudiya='" + itemJiechudiya + '\'' +
                ", itemJiechudiyaCost=" + itemJiechudiyaCost +
                ", itemJiechudiyaCompletedate=" + itemJiechudiyaCompletedate +
                ", itemJiechudiyaDesc='" + itemJiechudiyaDesc + '\'' +
                ", itemJiechudiyaReqId=" + itemJiechudiyaReqId +
                ", itemWeituo='" + itemWeituo + '\'' +
                ", itemWeituoTax=" + itemWeituoTax +
                ", itemWeituoCost=" + itemWeituoCost +
                ", itemWeituoCompletedate=" + itemWeituoCompletedate +
                ", itemWeituoDesc='" + itemWeituoDesc + '\'' +
                ", itemWeituoReqId=" + itemWeituoReqId +
                ", itemNianjian='" + itemNianjian + '\'' +
                ", itemNianjianTax=" + itemNianjianTax +
                ", itemNianjianCost=" + itemNianjianCost +
                ", itemNianjianCompletedate=" + itemNianjianCompletedate +
                ", itemNianjianDesc='" + itemNianjianDesc + '\'' +
                ", itemNianjianReqId=" + itemNianjianReqId +
                ", itemBuhuan='" + itemBuhuan + '\'' +
                ", itemBuhuanTax=" + itemBuhuanTax +
                ", itemBuhuanCost=" + itemBuhuanCost +
                ", itemBuhuanCompletedate=" + itemBuhuanCompletedate +
                ", itemBuhuanDesc='" + itemBuhuanDesc + '\'' +
                ", itemBuhuanReqId=" + itemBuhuanReqId +
                ", itemQita='" + itemQita + '\'' +
                ", itemQitaCost=" + itemQitaCost +
                ", itemQitaCompletedate=" + itemQitaCompletedate +
                ", itemQitaDesc='" + itemQitaDesc + '\'' +
                ", itemQitaReqId=" + itemQitaReqId +
                ", state='" + state + '\'' +
                ", financeState='" + financeState + '\'' +
                ", financeSum=" + financeSum +
                ", commitdate=" + commitdate +
                ", createdate=" + createdate +
                ", creator='" + creator + '\'' +
                ", add1='" + add1 + '\'' +
                ", add2='" + add2 + '\'' +
                ", add3='" + add3 + '\'' +
                '}';
    }
}
