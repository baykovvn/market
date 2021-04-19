import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    /*
     Возможности программы Магазин:
     - Вывод доступных для покупки товаров
     - Фильтрация товаров по ключевым словам, ценам, производителям
     - Составление продуктовой корзины пользователя
     - Система рейтинга для товаров
     - сориторвка товаров по цене и по рейтингу

     Товары хранятся в БД (JSON)

     */

    static ListOfGoods goodList_t = new ListOfGoods(); // Список товаров в магазине
    static BasketList basketList = new BasketList(); // Список товаров в Корзине

    public static void main(String[] args) throws IOException {

        //ListOfGoods goodList_t = new ListOfGoods();
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;  // индикатор выхода из цикла
        System.out.println("Вас приветствует магазаин Фермерских товаров!");
        getJSONBase(); // Загружаем список товаров из JSON в goodList_t
        while (repeat) {
            System.out.println("\n Выберите вариант: ");
            System.out.println(" 1 - Вывести список товаров");
            System.out.println(" 2 - фильтрация товаров по наименованию");
            System.out.println(" 3 - Сортировка списка товаров по цене");
            System.out.println(" 4 - Показать рейтинг товара по частоте покупок");
            System.out.println(" 5 - Посмотреть корзину товаров");
            System.out.println(" 6 - Сделать заказ");
            System.out.println(" 0 - ВЫХОД"); // При выходе текущий статус списка товаров на складе сохраняется в JSON
            String input = scanner.next();
            int input_int = parseInt(input);
            switch (input_int) {
                case (1):
                    System.out.println(goodList_t);
                    break;
                case (2):
                    String inputWord = getWordForFilter();
                    String filteredList = goodList_t.getFilteredList(inputWord);
                    System.out.println("Фильтр слово: " + inputWord);
                    System.out.println(filteredList);
                    break;
                case (3):
                    goodList_t.getSortedByPriceList();
                    System.out.println("Отсортированный по возрастанию цены список: ");
                    System.out.println(goodList_t);
                    break;
                case (4):
                    goodList_t.getGoodsRank();
                    System.out.println("Отсортированный по рейтингу список: ");
                    System.out.println(goodList_t);
                    break;
                case (5):
                    getBasket();
                    break;
                case (6):
                    makeOrder();
                    break;
                case (0):
                    repeat = false;
                    break;
                default:
                    break;

            }

        }
    }

    private static void makeOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean test = true;
        while (test) {
            System.out.println("Введите номер (Артикул) товара для Заказа или 0 для выхода  ");
            System.out.println(goodList_t);
            String input = scanner.next();
            int inputNumber = parseInt(input);
            if (!goodList_t.checkGoods(inputNumber)) {
                System.out.println("Вы ввели несуществующий номер продукта или товара нет на складе: " + inputNumber);
            } else {
                //goodList_t.takeProductFromStore(goodList_t.returnGoods(inputNumber)); // уменьшение количества товара на складе
                // уменьшение количества товара на складе
                if (basketList.checkGoods(inputNumber)) {// проверяем наличие этого товара уже в корзине
                    /// если такой есть, то:
                    basketList.addCountExistGoods(inputNumber);     /// добавляем к нему Count + 1
                } else {
                    basketList.addGoods(goodList_t.returnGoods(inputNumber)); // вернуть из списка товаров объект и добавить его в в корзину
                }
                goodList_t.takeProductFromStore(inputNumber); // уменьшение количества товара на складе
                System.out.println("\nВ вашей корзине следующие товары: ");
                System.out.println(basketList);
            }

            if (inputNumber == 0) test = false;
        }

    }


    private static void getBasket() {
        System.out.println("\nВ вашей коризне: ");
        System.out.println(basketList + "\n");
    }


    private static String getWordForFilter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово для фильтрации по названию продукта: ");
        //String inputString = scanner.nextLine();
        return scanner.nextLine();
    }

    //private static void getGoods() {}


    private static void getJSONBase() throws IOException {
        String fileName = "C:\\Users\\admin\\IdeaProjects\\SHOP\\src\\main\\java\\Goods.json";
        String JsonData = readUsingScanner(fileName);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Goods.class, new ConverterJSON());
        Gson gson = gsonBuilder.create();
        // В этом цикле из строи JSON JsonData последовательно извлекаются элементы JSON и конвертируются в класс Goods
        // После конвертации происходит добавление в Список goodList, содержащий все товары магазина.
        while (JsonData.contains("}")) {
            // формируется строка для преобразования в класс из формата JSon
            String pieceOfJsonData = JsonData.substring(JsonData.indexOf("{"), JsonData.indexOf("}") + 1);
            JsonData = JsonData.replace(pieceOfJsonData, "");
            JsonReader jsonString = new JsonReader(new StringReader(pieceOfJsonData));
            Goods goods = gson.fromJson(jsonString, Goods.class);
            goodList_t.addGoods(goods);
            //goodsList.add(goods);
        }
    }

    private static String readUsingScanner(String fileName) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName));//, StandardCharsets.UTF_8.name());
        StringBuilder JsonData = new StringBuilder();
        while (scanner.hasNext()) {
            JsonData.append(scanner.next());
        }
        scanner.close();
        //System.out.println(JsonData);
        return JsonData.toString();
    }
}