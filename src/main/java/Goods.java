
public class Goods {
    private String name; // Коровье, Козье
    private int count; // Количество на складе
    private float price; // Цена за еденицу
    private int weight; // Вес еденицы продукции
    private int fat;
    private int rating; // Рэйтинг товара ( считается по количеству сделанных покупок )
    private int goodsNumber; //Артикул товара


    public Goods(String name, int count, float price, int weight, int fat, int rating, int goodsNumber) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.weight = weight;
        this.fat = fat;
        this.rating = rating; // Рейтинг товара при создании всегда равен 0;
        this.goodsNumber = goodsNumber;
    }

    public void decreaseCount() {
        this.count = this.count - 1;
        this.rating = this.rating + 1; //увеличиваем рейтинг на еденицу, когда берем со склада продукт
    }

    public int getFat() {
        return this.fat;
    }

    public int getRating() {
        return this.rating;
    }

    public int getWeight() {
        return this.weight;
    }

    public void addCount() {
        this.count = this.count + 1;
    }

    public int getCount() {
        return this.count;
    }

    public int getGoodsNumber() {
        return this.goodsNumber;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }


    @Override
    public String toString() {
        return goodsNumber + " Наименование: " + name +
                ", количество " + count +
                ", цена " + price +
                ", вес " + weight +
                ", жирность " + fat;
    }
}
