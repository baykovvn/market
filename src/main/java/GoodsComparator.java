import java.util.Comparator;

public class GoodsComparator implements Comparator<Goods> {
    public int compare(Goods o1, Goods o2) {
        float o1_price = o1.getPrice();
        float o2_price = o2.getPrice();
        return (int) (o1_price - o2_price);
    }
}
