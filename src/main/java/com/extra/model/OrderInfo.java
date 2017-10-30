package com.extra.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by Extra on 2017/8/17.
 * GitHub cnhttt@163.com
 * Work to SZFP
 * Order类型:值为1或2。订单类型= 1,交付;订单类型= 2,收集。
 客户类型:值是4或5。客户类型= 4,验证;客户类型= 5,而不是验证。
 支付状态:值为6或7。支付状态=6，支付顺序;付款状态=7，不付款。

 *Order Type*
 Order No*
 Quantity,Food1, Amount;
 Quantity,Food2, Amount;
 Quantity,Food3, Amount*
 Delivery Chg;
 CC+Handeling fees;
 Total;
 Customer Type;
 Customer Name;
 Customer Address;
 Requested For;
 Previous Number of orders;
 Payment Status;
 Payment Card No;
 Customer Phone*customer comments#
 Order Type: The value is 1 or 2. Order Type=1, Delivery; Order Type=2, Collection.
 Customer Type: The value is 4 or 5. Customer Type=4, Verified; Customer Type=5, Not Verified.
 Payment Status: The value is 6 or 7. Payment Status =6, Order paid; Payment Status=7, Order not paid.
 Order类型:值为1或2。订单类型= 1,交付;订单类型= 2,收集。
 客户类型:值是4或5。客户类型= 4,验证;客户类型= 5,而不是验证。
 支付状态:值为6或7。支付状态=6，支付顺序;付款状态=7，不付款。
 */



public class OrderInfo {
        private String id;
        private String orderType;   //1-3
        private String orderNo;
        private List<OrderFoodGroups>   datas;
        private  String deliveryChg;//运费
        private  String CCHandelingFees;
        private String total;
        private String customerType;
        private String  rise ="SZFP TECHNOLOGY LIMITED ";//Xpert Technologies
        private String sellerAddress="Room 506-507,HuaTong Business Building,XinGao Road,XiLi Town,NanShan District,ShenZhen,China";//Office No 09, IT Park, Mansehra Road, Mandian, Abbottabad
        private String customerName;
        private String customerAddress;
        private String paymentMethod;
        private String remark;
        private String Discount="1";
        private String phone = "86276295";
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")        private Date Requestedfor;
        private String previousNumberoforders;
        private String  paymentStatus;
        private String  paymentCardNo;
        private String  customerPhone;
        private String  customerComments;


        private List<MeunItems> menu_items;

    public List<MeunItems> getMeun_items() {
        return menu_items;
    }

    public void setMeun_items(List<MeunItems> meun_items) {
        this.menu_items = meun_items;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
        private Date time ;


    public Date getTime() {
        return time;
    }


    public String getRise() {
        return rise;
    }

    public void setRise(String rise) {
        this.rise = rise;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<OrderFoodGroups> getDatas() {
        return datas;
    }

    public void setDatas(List<OrderFoodGroups> datas) {
        this.datas = datas;
    }

    public String getDeliveryChg() {
        return deliveryChg;
    }

    public void setDeliveryChg(String deliveryChg) {
        this.deliveryChg = deliveryChg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCCHandelingFees() {
        return CCHandelingFees;
    }

    public void setCCHandelingFees(String CCHandelingFees) {
        this.CCHandelingFees = CCHandelingFees;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Date getRequestedfor() {
        return Requestedfor;
    }

    public void setRequestedfor(Date requestedfor) {
        Requestedfor = requestedfor;
    }

    public String getPreviousNumberoforders() {
        return previousNumberoforders;
    }

    public void setPreviousNumberoforders(String previousNumberoforders) {
        this.previousNumberoforders = previousNumberoforders;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentCardNo() {
        return paymentCardNo;
    }

    public void setPaymentCardNo(String paymentCardNo) {
        this.paymentCardNo = paymentCardNo;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerComments() {
        return customerComments;
    }
    public void setCustomerComments(String customerComments) {
        this.customerComments = customerComments;
    }

    @Override
    public String toString() {
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("order number:" +orderNo+"\n")


        return
                "orderType:" + orderType  +"\n"+
                "orderNo:" + orderNo +"\n"+
                "[ datas]" + datas + "[ datas]" +"\n"+
                "[ deliveryChg]" + deliveryChg + "[ deliveryChg]"+"\n"+
                "[ CCHandelingFees]" + CCHandelingFees + "[ CCHandelingFees]" +"\n"+
                "[ total]" + total +"[ total]"+"\n"+
                "[ remark]" + remark +"[ total]"+"\n"+
                 "[ customerType]" + customerType + "[ customerType]" +"\n"+
                "[ CustomerName]" + customerName + "[ CustomerName]"+"\n"+
                 "[ CustomerAddress]" + customerAddress + "[ CustomerAddress]"+"\n"+
                "[ equestedFor]" + remark + "[ equestedFor]" + "\n"+
                        "[ previousNumberoforders]" + previousNumberoforders + "[ previousNumberoforders]"+"\n"+
                "[ paymentStatus]" + paymentStatus +"[ paymentStatus]"+ "\n"+
                        "[ paymentCardNo]" + paymentCardNo +"\n"+
                "[ customerPhone]" + customerPhone + "[ customerPhone]" +"\n";
    }
}
