package domain;

public class Goods {
    private String goodsId;
    private String goodsName;
    private Float price;
    private String kindId;
    public Goods(){}
    public String toString(){
        return "{"+ goodsId +","+ goodsName +","+ price +","+ kindId+"}";
    }
    //重写equals和hashCode
    public boolean equals(Object object){
        if(this == object){
            return true;
        }else{
            if(object instanceof Goods){
               Goods anotherObject = (Goods)object;
               if(anotherObject.getGoodsId().equals(this.goodsId)){
                   return true;
               }
            }
            return false;
        }
    }
    public int hashCode(){
        return this.getGoodsId().hashCode();
    }
    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getKindId() {
        return kindId;
    }

    public void setKindId(String kindId) {
        this.kindId = kindId;
    }
}
