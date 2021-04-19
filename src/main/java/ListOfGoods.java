import java.util.ArrayList;

public class ListOfGoods {
    private static ArrayList<Goods> listOfGoods = new ArrayList();

    public ListOfGoods() {

    }

    public void addGoods(Goods goods) {
        listOfGoods.add(goods);
    }

    public boolean checkGoods(int productNumber) {
        for (Goods goods : listOfGoods) {
            if (goods.getGoodsNumber() == productNumber & goods.getCount() > 0) {
                return true;
            }
        }
        return false;
    }

    public Goods returnGoods(int productNumber) {
        for (Goods goods : listOfGoods) {
            if (goods.getGoodsNumber() == productNumber) {
                return new Goods(goods.getName(), 1, goods.getPrice(), goods.getWeight(), goods.getFat(), goods.getRating(), goods.getGoodsNumber());
            }
        }
        return null;
    }

    public void takeProductFromStore(int productNumber) {
        for (Goods goods : listOfGoods) {
            if (goods.getGoodsNumber() == productNumber) {
                goods.decreaseCount(); // уменьшаем количество товара на складе
            }
        }
    }


    public Goods getGoods(int index) {   // Получение Объекта по индексу
        Goods goods = listOfGoods.get(index);
        return goods;
    }

    public int getGoogsLength() {
        int length = listOfGoods.size();
        return length;
    }

    public ArrayList<Goods> sortGoodsByPrice() {
        //TODO
        return null;
    }

    public int getSize() {
        return listOfGoods.size();
    }

    public String getFilteredList(String word) {
        String result = "";
        for (Goods goods : listOfGoods) {
            if (goods.getName().contains(word)) {
                result = result + " \n " + goods.toString();
            }
        }
        return result;
    }

    public void getGoodsRank() {
        ComparatorGoodsRating comparator = new ComparatorGoodsRating();
        listOfGoods.sort(comparator);
    }

    public void getSortedByPriceList() {
        GoodsComparator comparator = new GoodsComparator();
        listOfGoods.sort(comparator);
    }

    @Override
    public String toString() {
        String result = "";
        for (Goods goods : listOfGoods) {
            result = result + " \n " + goods.toString();
        }
        return result;
    }

}
