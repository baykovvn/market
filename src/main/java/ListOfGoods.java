import java.util.ArrayList;

public class ListOfGoods {
    private static ArrayList<Goods> listOfGoods = new ArrayList<Goods>();

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


    public String getFilteredList(String word) {
        StringBuilder result = new StringBuilder();
        for (Goods goods : listOfGoods) {
            if (goods.getName().contains(word)) {
                result.append(" \n ").append(goods.toString());
            }
        }
        return result.toString();
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
        StringBuilder result = new StringBuilder();
        for (Goods goods : listOfGoods) {
            result.append(" \n ").append(goods.toString());
        }
        return result.toString();
    }

}
