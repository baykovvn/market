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
            if (goods.getGoodsNumber() == productNumber ) {
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


    public Goods getGoods(int index) {   // Получение Объекта по индексу
        Goods goods = listOfBasket.get(index);
        return goods;
    }

    public int getGoogsLength() {
        int length = listOfBasket.size();
        return length;
    }

    public void addCountExistGoods(int index) {
        Goods goods = returnGoods(index);
        goods.addCount();
    }

    public ArrayList<Goods> sortGoodsByPrice() {
        //TODO
        return null;
    }

    public int getSize() {
        return listOfBasket.size();
    }

    public String getFilteredList(String word) {
        String result = "";
        for (Goods goods : listOfBasket) {
            if (goods.getName().contains(word)) {
                result = result + " \n " + goods.toString();
            }
        }
        return result;
    }

    public String getSortedByPriceList() {
        String result = "";
        //listOfGoods.sort();
        ArrayList<Goods> sortedByPriceList = new ArrayList<>();
        //int index = 0;
        int[] index;
        index = new int[listOfBasket.size()];
        int i = 0;
        for (Goods goods : listOfBasket) {
            // Сформировать макссив из индексов списка в порядке возрастания цены.
            int maxPrice = 0;
            while (i > maxPrice) {
                Goods minGoods = goods;
                if (goods.getPrice() > maxPrice) {
                    index[i] = listOfBasket.indexOf(goods);
                    i = i++;
                }
            }

        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        for (Goods goods : listOfBasket) {
            result = result + " \n " + goods.toString();
        }
        return result;
    }

}

