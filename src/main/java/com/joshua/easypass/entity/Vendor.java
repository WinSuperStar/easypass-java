package com.joshua.easypass.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vdrid;
    private String vdrname;
    private String vdraddr;
    private String vdraddrdetail;
    private String vdrplate;
    private String contact;
    private String contactphone;
    private String contacts;
    // tidang
    private String itemTidang;
    private float itemTidangTax;
    private float itemTidangCost;
    private String itemTidangCompletedate;
    private String itemTidangDesc;
    private Integer itemTidangReqId;
    // guohu
    private String itemGuohu;
    private float itemGuohuTax;
    private float itemGuohuCost;
    private String itemGuohuCompletedate;
    private String itemGuohuDesc;
    private Integer itemGuohuReqId;
    //shangpai
    private String itemShangpai;
    private float itemShangpaiTax;
    private float itemShangpaiCost;
    private String itemShangpaiCompletedate;
    private String itemShangpaiDesc;
    private Integer itemShangpaiReqId;
    //weizhang
    private String itemWeizhang;
    private float itemWeizhangTax;
    private float itemWeizhangCost;
    private float itemWeizhangCost2;
    private String itemWeizhangCompletedate;
    private String itemWeizhangDesc;
    private Integer itemWeizhangReqId;
    //diya
    private String itemDiya;
    private float itemDiyaCost;
    private String itemDiyaCompletedate;
    private String itemDiyaDesc;
    private Integer itemDiyaReqId;
    //jiechudiya
    private String itemJiechudiya;
    private float itemJiechudiyaCost;
    private String itemJiechudiyaCompletedate;
    private String itemJiechudiyaDesc;
    private Integer itemJiechudiyaReqId;
    //weituo
    private String itemWeituo;
    private float itemWeituoTax;
    private float itemWeituoCost;
    private String itemWeituoCompletedate;
    private String itemWeituoDesc;
    private Integer itemWeituoReqId;
    //nianjian
    private String itemNianjian;
    private float itemNianjianTax;
    private float itemNianjianCost;
    private String itemNianjianCompletedate;
    private String itemNianjianDesc;
    private Integer itemNianjianReqId;
    //buhuan
    private String itemBuhuan;
    private float itemBuhuanTax;
    private float itemBuhuanCost;
    private String itemBuhuanCompletedate;
    private String itemBuhuanDesc;
    private Integer itemBuhuanReqId;
    //qita
    private String itemQita;
    private float itemQitaCost;
    private String itemQitaCompletedate;
    private String itemQitaDesc;
    private Integer itemQitaReqId;
    private String state;
    private Date commitdate;
    private Date createdate;
    private String creator;
    private String add1;
    private String add2;
    private String add3;

    public Integer getVdrid() {
        return vdrid;
    }

    public void setVdrid(Integer vdrid) {
        this.vdrid = vdrid;
    }

    public String getVdrname() {
        return vdrname;
    }

    public void setVdrname(String vdrname) {
        this.vdrname = vdrname;
    }

    public String getVdraddr() {
        return vdraddr;
    }

    public void setVdraddr(String vdraddr) {
        this.vdraddr = vdraddr;
    }

    public String getVdraddrdetail() {
        return vdraddrdetail;
    }

    public void setVdraddrdetail(String vdraddrdetail) {
        this.vdraddrdetail = vdraddrdetail;
    }

    public String getVdrplate() {
        return vdrplate;
    }

    public void setVdrplate(String vdrplate) {
        this.vdrplate = vdrplate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
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

    public String getItemTidangCompletedate() {
        return itemTidangCompletedate;
    }

    public void setItemTidangCompletedate(String itemTidangCompletedate) {
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

    public String getItemGuohuCompletedate() {
        return itemGuohuCompletedate;
    }

    public void setItemGuohuCompletedate(String itemGuohuCompletedate) {
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

    public String getItemShangpaiCompletedate() {
        return itemShangpaiCompletedate;
    }

    public void setItemShangpaiCompletedate(String itemShangpaiCompletedate) {
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

    public float getItemWeizhangTax() {
        return itemWeizhangTax;
    }

    public void setItemWeizhangTax(float itemWeizhangTax) {
        this.itemWeizhangTax = itemWeizhangTax;
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

    public String getItemWeizhangCompletedate() {
        return itemWeizhangCompletedate;
    }

    public void setItemWeizhangCompletedate(String itemWeizhangCompletedate) {
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

    public String getItemDiyaCompletedate() {
        return itemDiyaCompletedate;
    }

    public void setItemDiyaCompletedate(String itemDiyaCompletedate) {
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

    public String getItemJiechudiyaCompletedate() {
        return itemJiechudiyaCompletedate;
    }

    public void setItemJiechudiyaCompletedate(String itemJiechudiyaCompletedate) {
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

    public String getItemWeituoCompletedate() {
        return itemWeituoCompletedate;
    }

    public void setItemWeituoCompletedate(String itemWeituoCompletedate) {
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

    public String getItemNianjianCompletedate() {
        return itemNianjianCompletedate;
    }

    public void setItemNianjianCompletedate(String itemNianjianCompletedate) {
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

    public String getItemBuhuanCompletedate() {
        return itemBuhuanCompletedate;
    }

    public void setItemBuhuanCompletedate(String itemBuhuanCompletedate) {
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

    public String getItemQitaCompletedate() {
        return itemQitaCompletedate;
    }

    public void setItemQitaCompletedate(String itemQitaCompletedate) {
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
        return "Vendor{" +
                "vdrid=" + vdrid +
                ", vdrname='" + vdrname + '\'' +
                ", vdraddr='" + vdraddr + '\'' +
                ", vdraddrdetail='" + vdraddrdetail + '\'' +
                ", vdrplate='" + vdrplate + '\'' +
                ", contact='" + contact + '\'' +
                ", contactphone='" + contactphone + '\'' +
                ", contacts='" + contacts + '\'' +
                ", itemTidang='" + itemTidang + '\'' +
                ", itemTidangTax=" + itemTidangTax +
                ", itemTidangCost=" + itemTidangCost +
                ", itemTidangCompletedate='" + itemTidangCompletedate + '\'' +
                ", itemTidangDesc='" + itemTidangDesc + '\'' +
                ", itemTidangReqId=" + itemTidangReqId +
                ", itemGuohu='" + itemGuohu + '\'' +
                ", itemGuohuTax=" + itemGuohuTax +
                ", itemGuohuCost=" + itemGuohuCost +
                ", itemGuohuCompletedate='" + itemGuohuCompletedate + '\'' +
                ", itemGuohuDesc='" + itemGuohuDesc + '\'' +
                ", itemGuohuReqId=" + itemGuohuReqId +
                ", itemShangpai='" + itemShangpai + '\'' +
                ", itemShangpaiTax=" + itemShangpaiTax +
                ", itemShangpaiCost=" + itemShangpaiCost +
                ", itemShangpaiCompletedate='" + itemShangpaiCompletedate + '\'' +
                ", itemShangpaiDesc='" + itemShangpaiDesc + '\'' +
                ", itemShangpaiReqId=" + itemShangpaiReqId +
                ", itemWeizhang='" + itemWeizhang + '\'' +
                ", itemWeizhangTax=" + itemWeizhangTax +
                ", itemWeizhangCost=" + itemWeizhangCost +
                ", itemWeizhangCost2=" + itemWeizhangCost2 +
                ", itemWeizhangCompletedate='" + itemWeizhangCompletedate + '\'' +
                ", itemWeizhangDesc='" + itemWeizhangDesc + '\'' +
                ", itemWeizhangReqId=" + itemWeizhangReqId +
                ", itemDiya='" + itemDiya + '\'' +
                ", itemDiyaCost=" + itemDiyaCost +
                ", itemDiyaCompletedate='" + itemDiyaCompletedate + '\'' +
                ", itemDiyaDesc='" + itemDiyaDesc + '\'' +
                ", itemDiyaReqId=" + itemDiyaReqId +
                ", itemJiechudiya='" + itemJiechudiya + '\'' +
                ", itemJiechudiyaCost=" + itemJiechudiyaCost +
                ", itemJiechudiyaCompletedate='" + itemJiechudiyaCompletedate + '\'' +
                ", itemJiechudiyaDesc='" + itemJiechudiyaDesc + '\'' +
                ", itemJiechudiyaReqId=" + itemJiechudiyaReqId +
                ", itemWeituo='" + itemWeituo + '\'' +
                ", itemWeituoTax=" + itemWeituoTax +
                ", itemWeituoCost=" + itemWeituoCost +
                ", itemWeituoCompletedate='" + itemWeituoCompletedate + '\'' +
                ", itemWeituoDesc='" + itemWeituoDesc + '\'' +
                ", itemWeituoReqId=" + itemWeituoReqId +
                ", itemNianjian='" + itemNianjian + '\'' +
                ", itemNianjianTax=" + itemNianjianTax +
                ", itemNianjianCost=" + itemNianjianCost +
                ", itemNianjianCompletedate='" + itemNianjianCompletedate + '\'' +
                ", itemNianjianDesc='" + itemNianjianDesc + '\'' +
                ", itemNianjianReqId=" + itemNianjianReqId +
                ", itemBuhuan='" + itemBuhuan + '\'' +
                ", itemBuhuanTax=" + itemBuhuanTax +
                ", itemBuhuanCost=" + itemBuhuanCost +
                ", itemBuhuanCompletedate='" + itemBuhuanCompletedate + '\'' +
                ", itemBuhuanDesc='" + itemBuhuanDesc + '\'' +
                ", itemBuhuanReqId=" + itemBuhuanReqId +
                ", itemQita='" + itemQita + '\'' +
                ", itemQitaCost=" + itemQitaCost +
                ", itemQitaCompletedate='" + itemQitaCompletedate + '\'' +
                ", itemQitaDesc='" + itemQitaDesc + '\'' +
                ", itemQitaReqId=" + itemQitaReqId +
                ", state='" + state + '\'' +
                ", commitdate=" + commitdate +
                ", createdate=" + createdate +
                ", creator='" + creator + '\'' +
                ", add1='" + add1 + '\'' +
                ", add2='" + add2 + '\'' +
                ", add3='" + add3 + '\'' +
                '}';
    }
}
