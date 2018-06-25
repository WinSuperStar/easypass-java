package com.joshua.easypass.controller.business;

import com.joshua.easypass.entity.Order;
import com.joshua.easypass.service.OrderService;
import com.joshua.easypass.util.DateUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.sun.imageio.plugins.jpeg.JPEG.vendor;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class OrderController {
    public final static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/createOdr")
    public Integer createOdr(@RequestParam("creator") String creator) {
        return orderService.createOdr(creator);
    }

    @PostMapping(value = "/getOdrs")
    public Order[] getOdrs(@RequestParam("orderid") String orderid,
                           @RequestParam("carplate1") String carplate1,
                           @RequestParam("carplate2") String carplate2,
                           @RequestParam("carplatenum") String carplatenum,
                           @RequestParam("oriownername") String oriownername,
                           @RequestParam("carbrand") String carbrand,
                           @RequestParam("carset") String carset,
                           @RequestParam("carnum") String carnum,
                           @RequestParam("cusname") String cusname,
                           @RequestParam("kuaidinum") String kuaidinum,
                           @RequestParam("creator") String creator,
                           @RequestParam("itemlist") String itemlist
    ) {
        return orderService.getOdrs(orderid, carplate1, carplate2, carplatenum, oriownername, carbrand, carset, carnum, cusname, kuaidinum, creator, itemlist);
    }

    @PostMapping(value = "/delOdr")
    public void delVdr(@RequestParam("odrid") Integer odrid) {
        orderService.delOdr(odrid);
    }

    @PostMapping(value = "/autoDelOdr")
    public void autoDelVdr(@RequestParam("odrid") Integer odrid) {
        orderService.delOdr(odrid);
    }

    @PostMapping(value = "/autoGetOdr")
    public Order autoGetOdr(@RequestParam("orderid") Integer orderid) {
        return orderService.getOdr(orderid);
    }

    @PostMapping(value = "/getOdr")
    public Order getOdr(@RequestParam("orderid") Integer orderid) {
        return orderService.getOdr(orderid);
    }

    @PostMapping(value = "/updateOdrPreSubmit")
    public void updateOdrPreSubmit(@RequestParam("orderid") Integer orderid) {
        this.orderService.updateOdr(orderid, "待提交", "已寄出");
    }

    @PostMapping(value = "/updateOdrPreBuz")
    public void updateOdrPreBuz(@RequestParam("orderid") Integer orderid) {
        this.orderService.updateOdr(orderid, "待办证", "已签收");
    }

    @PostMapping(value = "/orderAssign")
    public void orderAssign(@RequestParam("orderid") Integer orderid,
                            @RequestParam("userid") Integer userid,
                            @RequestParam("username") String username) {
        this.orderService.orderAssign(orderid, userid, username);
    }

    @PostMapping(value = "/updateOdrIng")
    public void updateOdrIng(@RequestParam("orderid") Integer orderid) {
        this.orderService.updateOdr(orderid, "办证中", "已签收");
    }

    @PostMapping(value = "/updateOdrDoneBuz")
    public void updateOdrDoneBuz(@RequestParam("orderid") Integer orderid) {
        this.orderService.updateOdr(orderid, "办证完成", "已签收");
    }

    @PostMapping(value = "/saveOdr")
    public void saveVdr(
            @RequestParam("order") String order
    ) {
        JSONObject jasonV = JSONObject.fromObject(order);
        if (jasonV.get("carRegDate") != null) {
            jasonV.put("carRegDate", DateUtil.StrToDate(jasonV.get("carRegDate").toString()));
        }
        logger.info("转成的jason对象为：" + jasonV);
        Order v = (Order) JSONObject.toBean(jasonV, Order.class);
//        v.setItemTidangCompletedate("".equals(jasonV.get("itemTidangCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemTidangCompletedate")+""));
//        v.setItemGuohuCompletedate("".equals(jasonV.get("itemGuohuCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemGuohuCompletedate")+""));
//        v.setItemShangpaiCompletedate("".equals(jasonV.get("itemShangpaiCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemShangpaiCompletedate")+""));
//        v.setItemWeizhangCompletedate("".equals(jasonV.get("itemWeizhangCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemWeizhangCompletedate")+""));
//        v.setItemDiyaCompletedate("".equals(jasonV.get("itemDiyaCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemDiyaCompletedate")+""));
//        v.setItemJiechudiyaCompletedate("".equals(jasonV.get("itemJiechudiyaCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemJiechudiyaCompletedate")+""));
//        v.setItemWeituoCompletedate("".equals(jasonV.get("itemWeituoCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemWeituoCompletedate")+""));
//        v.setItemNianjianCompletedate("".equals(jasonV.get("itemNianjianCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemNianjianCompletedate")+""));
//        v.setItemBuhuanCompletedate("".equals(jasonV.get("itemBuhuanCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemBuhuanCompletedate")+""));
//        v.setItemQitaCompletedate("".equals(jasonV.get("itemQitaCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemQitaCompletedate")+""));
        logger.info(v.toString());
        orderService.saveOdr(v);
    }
}
