package com.joshua.easypass.controller.business;

import com.joshua.easypass.entity.Vendor;
import com.joshua.easypass.service.VendorService;
import com.joshua.easypass.util.DataUtil;
import com.joshua.easypass.util.DateUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class VendorController {
    public final static Logger logger = LoggerFactory.getLogger(VendorController.class);
    @Autowired
    private VendorService vdrService;

    @GetMapping(value="/getAllVdrs")
    public Vendor[] getAllVdrs(){return vdrService.getAllVdrs();}

    @PostMapping(value = "/createVdr")
    public Integer createVdr(@RequestParam("creator") String creator) {
        return vdrService.createVdr(creator);
    }

    @PostMapping(value = "/getVdr")
    public Vendor getVdr(@RequestParam("vdrid") Integer vdrid) {
        return vdrService.getVdr(vdrid);
    }

    @PostMapping(value = "/getVdrs")
    public Vendor[] getVdrs(@RequestParam("vdraddr1") String vdraddr1,
                            @RequestParam("vdraddr2") String vdraddr2,
                            @RequestParam("vdraddr3") String vdraddr3,
                            @RequestParam("vdrplate1") String vdrplate1,
                            @RequestParam("vdrplate2") String vdrplate2,
                            @RequestParam("contact") String contact,
                            @RequestParam("contactphone") String contactphone,
                            @RequestParam("firstdate") String firstdate,
                            @RequestParam("state") String state,
                            @RequestParam("itemlist") String itemlist
    ) {

        String[] a = DataUtil.VdrSearchTrim(itemlist.split(","));
        logger.info(a[0]+" "+a[1]);
        if ("".equals(firstdate)) {
            logger.info("vendor 查询，无日期条件");
            return vdrService.getVdrsWithoutDate(vdraddr1, vdraddr2, vdraddr3, vdrplate1, vdrplate2, contact, contactphone, state,
                    a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7], a[8], a[9]);
        } else {
            logger.info("vendor 查询，有日期条件");
            String[] dates = firstdate.split(" ");
            Date date1 = DateUtil.StrToDate(dates[0]);
            Date date2 = DateUtil.StrToDate(dates[1]);
            return vdrService.getVdrsWithDate(vdraddr1, vdraddr2, vdraddr3, vdrplate1, vdrplate2, contact, contactphone, date1, date2, state,
                    a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7], a[8], a[9]);
        }
    }

    @PostMapping(value = "/saveVdr")
    public void saveVdr(
            @RequestParam("vendor") String vendor
//            @RequestParam("vdrid") Integer vdrid,
//            @RequestParam("vdrname") String vdrname,
//            @RequestParam("vdraddr") String vdraddr,
//            @RequestParam("vdraddrdetail") String vdraddrdetail,
//            @RequestParam("vdrplate") String vdrplate,
//            @RequestParam("contact") String contact,
//            @RequestParam("contactphone") String contactphone,
//            @RequestParam("contacts") String contacts,
//            @RequestParam("itemTidang") String itemTidang,
//            @RequestParam("itemTidangTax") float itemTidangTax,
//            @RequestParam("itemTidangCost") float itemTidangCost,
//            @RequestParam("itemTidangCompletedate") Date itemTidangCompletedate,
//            @RequestParam("itemTidangDesc") String itemTidangDesc,
//            @RequestParam("itemTidangReqId") Integer itemTidangReqId,
//            @RequestParam("itemGuohu") String itemGuohu,
//            @RequestParam("itemGuohuTax") float itemGuohuTax,
//            @RequestParam("itemGuohuCost") float itemGuohuCost,
//            @RequestParam("itemGuohuCompletedate") Date itemGuohuCompletedate,
//            @RequestParam("itemGuohuDesc") String itemGuohuDesc,
//            @RequestParam("itemGuohuReqId") Integer itemGuohuReqId,
//            @RequestParam("itemShangpai") String itemShangpai,
//            @RequestParam("itemShangpaiTax") float itemShangpaiTax,
//            @RequestParam("itemShangpaiCost") float itemShangpaiCost,
//            @RequestParam("itemShangpaiCompletedate") Date itemShangpaiCompletedate,
//            @RequestParam("itemShangpaiDesc") String itemShangpaiDesc,
//            @RequestParam("itemShangpaiReqId") Integer itemShangpaiReqId,
//            @RequestParam("itemWeizhang") String itemWeizhang,
//            @RequestParam("itemWeizhangTax") float itemWeizhangTax,
//            @RequestParam("itemWeizhangCost") float itemWeizhangCost,
//            @RequestParam("itemWeizhangCompletedate") Date itemWeizhangCompletedate,
//            @RequestParam("itemWeizhangDesc") String itemWeizhangDesc,
//            @RequestParam("itemWeizhangReqId") Integer itemWeizhangReqId,
//            @RequestParam("itemDiya") String itemDiya,
//            @RequestParam("itemDiyaCost") float itemDiyaCost,
//            @RequestParam("itemDiyaCompletedate") Date itemDiyaCompletedate,
//            @RequestParam("itemDiyaDesc") String itemDiyaDesc,
//            @RequestParam("itemDiyaReqId") Integer itemDiyaReqId,
//            @RequestParam("itemJiechudiya") String itemJiechudiya,
//            @RequestParam("itemJiechudiyaCost") float itemJiechudiyaCost,
//            @RequestParam("itemJiechudiyaCompletedate") Date itemJiechudiyaCompletedate,
//            @RequestParam("itemJiechudiyaDesc") String itemJiechudiyaDesc,
//            @RequestParam("itemJiechudiyaReqId") Integer itemJiechudiyaReqId,
//            @RequestParam("itemWeituo") String itemWeituo,
//            @RequestParam("itemWeituoTax") float itemWeituoTax,
//            @RequestParam("itemWeituoCost") float itemWeituoCost,
//            @RequestParam("itemWeituoCompletedate") Date itemWeituoCompletedate,
//            @RequestParam("itemWeituoDesc") String itemWeituoDesc,
//            @RequestParam("itemWeituoReqId") Integer itemWeituoReqId,
//            @RequestParam("itemNianjian") String itemNianjian,
//            @RequestParam("itemNianjianTax") float itemNianjianTax,
//            @RequestParam("itemNianjianCost") float itemNianjianCost,
//            @RequestParam("itemNianjianCompletedate") Date itemNianjianCompletedate,
//            @RequestParam("itemNianjianDesc") String itemNianjianDesc,
//            @RequestParam("itemNianjianReqId") Integer itemNianjianReqId,
//            @RequestParam("itemBuhuan") String itemBuhuan,
//            @RequestParam("itemBuhuanTax") float itemBuhuanTax,
//            @RequestParam("itemBuhuanCost") float itemBuhuanCost,
//            @RequestParam("itemBuhuanCompletedate") Date itemBuhuanCompletedate,
//            @RequestParam("itemBuhuanDesc") String itemBuhuanDesc,
//            @RequestParam("itemBuhuanReqId") Integer itemBuhuanReqId,
//            @RequestParam("itemQita") String itemQita,
//            @RequestParam("itemQitaCost") float itemQitaCost,
//            @RequestParam("itemQitaCompletedate") Date itemQitaCompletedate,
//            @RequestParam("itemQitaDesc") String itemQitaDesc,
//            @RequestParam("state") String state,
//            @RequestParam("createdate") Date createdate,
//            @RequestParam("creator") String creator,
//            @RequestParam("add1") String add1,
//            @RequestParam("add2") String add2,
//            @RequestParam("add3") String add3
    ) {
        JSONObject jasonV = JSONObject.fromObject(vendor);
        logger.info("转成的jason对象为：" + jasonV);

        Vendor v = (Vendor) JSONObject.toBean(jasonV, Vendor.class);
//        v.setVdrid(vdrid);
//        v.setVdrname(vdrname);
//        v.setVdraddr(vdraddr);
//        v.setVdraddrdetail(vdraddrdetail);
//        v.setVdrplate(vdrplate);
//        v.setContact(contact);
//        v.setContactphone(contactphone);
//        v.setContacts(contacts);
//        v.setItemTidang(itemTidang);
//        v.setItemTidangTax(itemTidangTax);
//        v.setItemTidangCost(itemTidangCost);
//        v.setItemTidangCompletedate(itemTidangCompletedate);
//        v.setItemTidangDesc(itemTidangDesc);
//        v.setItemTidangReqId(itemTidangReqId);
//        v.setItemGuohu(itemGuohu);
//        v.setItemGuohuTax(itemGuohuTax);
//        v.setItemGuohuCost(itemGuohuCost);
//        v.setItemGuohuCompletedate(itemGuohuCompletedate);
//        v.setItemGuohuDesc(itemGuohuDesc);
//        v.setItemGuohuReqId(itemGuohuReqId);
//        v.setItemShangpai(itemShangpai);
//        v.setItemShangpaiTax(itemShangpaiTax);
//        v.setItemShangpaiCost(itemShangpaiCost);
//        v.setItemShangpaiCompletedate(itemShangpaiCompletedate);
//        v.setItemShangpaiDesc(itemShangpaiDesc);
//        v.setItemShangpaiReqId(itemShangpaiReqId);
//        v.setItemWeizhang(itemWeizhang);
//        v.setItemWeizhangTax(itemWeizhangTax);
//        v.setItemWeizhangCost(itemWeizhangCost);
//        v.setItemWeizhangCompletedate(itemWeizhangCompletedate);
//        v.setItemWeizhangDesc(itemWeizhangDesc);
//        v.setItemWeizhangReqId(itemWeizhangReqId);
//        v.setItemDiya(itemDiya);
//        v.setItemDiyaCost(itemDiyaCost);
//        v.setItemDiyaCompletedate(itemDiyaCompletedate);
//        v.setItemDiyaDesc(itemDiyaDesc);
//        v.setItemDiyaReqId(itemDiyaReqId);
//        v.setItemJiechudiya(itemJiechudiya);
//        v.setItemJiechudiyaCost(itemJiechudiyaCost);
//        v.setItemJiechudiyaCompletedate(itemJiechudiyaCompletedate);
//        v.setItemJiechudiyaDesc(itemJiechudiyaDesc);
//        v.setItemJiechudiyaReqId(itemJiechudiyaReqId);
//        v.setItemWeituo(itemWeituo);
//        v.setItemWeituoTax(itemWeituoTax);
//        v.setItemWeituoCost(itemWeituoCost);
//        v.setItemWeituoCompletedate(itemWeituoCompletedate);
//        v.setItemWeituoDesc(itemWeituoDesc);
//        v.setItemWeituoReqId(itemWeituoReqId);
//        v.setItemNianjian(itemNianjian);
//        v.setItemNianjianTax(itemNianjianTax);
//        v.setItemNianjianCost(itemNianjianCost);
//        v.setItemNianjianCompletedate(itemNianjianCompletedate);
//        v.setItemNianjianDesc(itemNianjianDesc);
//        v.setItemNianjianReqId(itemNianjianReqId);
//        v.setItemBuhuan(itemBuhuan);
//        v.setItemBuhuanTax(itemBuhuanTax);
//        v.setItemBuhuanCost(itemBuhuanCost);
//        v.setItemBuhuanCompletedate(itemBuhuanCompletedate);
//        v.setItemBuhuanDesc(itemBuhuanDesc);
//        v.setItemBuhuanReqId(itemBuhuanReqId);
//        v.setItemQita(itemQita);
//        v.setItemQitaCost(itemQitaCost);
//        v.setItemQitaCompletedate(itemQitaCompletedate);
//        v.setItemQitaDesc(itemQitaDesc);
//        v.setState(state);
//        v.setCreatedate(createdate);
//        v.setCreator(creator);
//        v.setAdd1(add1);
//        v.setAdd2(add2);
//        v.setAdd3(add3);
        vdrService.saveVdr(v);
    }
}
