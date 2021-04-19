import java.util.ArrayList;

public class BasketList {
    private static ArrayList<Goods> listOfBasket = new ArrayList();

    public BasketList() {

    }

    public void addGoods(Goods goods) {

        listOfBasket.add(goods);
    }

    public boolean checkGoods(int productNumber) {
        for (Goods goods : listOfBasket) {
            if (goods.getGoodsNumber() == productNumber) {
                //goods.decreaseCount();
                return true;
            }
        }
        return false;
    }

    public Goods returnGoods(int productNumber) {
        for (Goods goods : listOfBasket) {
            if (goods.getGoodsNumber() == productNumber) return goods;
        }
        return null;
    }


    public void addCountExistGoods(int index) {
        Goods goods = returnGoods(index);
        goods.addCount();
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Goods goods : listOfBasket) {
            result.append(" \n ").append(goods.toString());
        }
        return result.toString();
    }

}

