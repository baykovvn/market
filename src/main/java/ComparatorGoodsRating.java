import java.util.Comparator;

public class ComparatorGoodsRating implements Comparator<Goods> {

    public int compare(Goods o1, Goods o2) {
        float o1_rating = o1.getRating();
        float o2_rating = o2.getRating();
        return (int) (o2_rating - o1_rating);
    }


}
