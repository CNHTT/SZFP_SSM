package com.extra.model;

/**
 * Created by Extra on 2017/8/17.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class OrderItemInfo {
    private Long id;
    private Long foodId;
    private String Quantity;
    private String food;
    private String amount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "[DATA]"+"\n"+
                "[Quantity]" + Quantity +"[Quantity]" +"\n" +
                "[food]" + food +"[food]" +"\n" +
                "[amount]" + amount + "[amount]"+ "\n"
        +"[DATA]";
    }
}
