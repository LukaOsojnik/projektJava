package hr.java.production.main;

import hr.java.restaurant.model.*;

import javax.print.attribute.standard.OrientationRequested;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static final int BROJ_KATEGORIJA = 1;
    private static final int BROJ_SASTOJAKA = 1;
    private static final int BROJ_JELA = 1;
    private static final int BROJ_SEFOVA = 1;
    private static final int BROJ_KONOBARA = 1;
    private static final int BROJ_DOSTAVLJACA = 1;
    private static final int BROJ_RESTORANA = 1;
    private static final int BROJ_NARUDZBA = 2;

    public static Category unosKategorije(Scanner sc) {
        System.out.println("Unesite ime kategorije: ");
        String name = sc.nextLine();

        System.out.println("Unesite opis kategorije: ");
        String opis = sc.nextLine();

        System.out.println("Unesite id: ");
        Long id = sc.nextLong();
        sc.nextLine();

        Category kategorija = new Category(name, opis, id);

        return kategorija;
    }

    public static Ingredient unosSastojka(Scanner sc, Category[] kategorija) {
        System.out.println("Unesite ime sastojka: ");
        String name = sc.nextLine();

        System.out.println("Unesite kojoj kategoriji pripada sastojak: ");
        for(int i = 0; i < BROJ_KATEGORIJA; i++){
            System.out.println("Kategorija" + (i + 1) + kategorija[i].getName());
        }

        Integer brojKategorije = sc.nextInt();

        while(brojKategorije > BROJ_KATEGORIJA || brojKategorije < 1){
            System.out.println("Unesite ispravni broj kategorije: ");
            brojKategorije = sc.nextInt();
        }
        Category kategorijaSastojka = kategorija[brojKategorije - 1];

        System.out.println("Unesite broj kalorija: ");
        BigDecimal kcal = sc.nextBigDecimal();

        sc.nextLine();

        System.out.println("Unesite metodu obrade: ");
        String prepMethod = sc.nextLine();
        System.out.println("Unesite id: ");
        Long id = sc.nextLong();
        sc.nextLine();

        Ingredient sastojak = new Ingredient(name, kategorijaSastojka, kcal, prepMethod, id);
        return sastojak;
    }

    public static Meal unosJela(Scanner sc, Category[] kategorija, Ingredient[] sastojak) {

        System.out.println("Unesite ime jela:");

        String name = sc.nextLine();

        System.out.println("Unesite broj kategorije kojoj pripada jelo: ");
        for(int i = 0; i < BROJ_KATEGORIJA; i++){
            System.out.println("Kategorija" + (i + 1) + kategorija[i].getName());
        }
        Integer brojKategorije = sc.nextInt();
        while(brojKategorije > BROJ_KATEGORIJA || brojKategorije < 1){
            System.out.println("Unesite ispravni broj kategorije: ");
            brojKategorije = sc.nextInt();
        }
        Category category = kategorija[brojKategorije - 1];

        System.out.println("Unesite broj sastojaka koje je potrebno za jelo, max broj je " + BROJ_SASTOJAKA);
        Integer brojSastojka = sc.nextInt();
        while(brojSastojka > BROJ_SASTOJAKA || brojSastojka < 1){
            System.out.println("Unesite ispravan broj sastojka: ");
            brojSastojka = sc.nextInt();
        }

        Ingredient[] ingredients = new Ingredient[brojSastojka];
        for(int i = 0; i < brojSastojka; i++){
            System.out.println("Upisite koje od sastojaka pripada ovom jelu: ");
            for(int j = 0; j < BROJ_SASTOJAKA; j++){
                System.out.println("Sastojak" + (j + 1) + sastojak[j].getName());
            }
            Integer redniBrSastojka = sc.nextInt();
            while(redniBrSastojka > BROJ_SASTOJAKA || redniBrSastojka < 1){
                System.out.println("Unesite ispravan broj sastojka: ");
                redniBrSastojka = sc.nextInt();
            }

            ingredients[i] = sastojak[redniBrSastojka - 1];
        }

        System.out.println("Unesite cijenu jela: ");
        BigDecimal price = sc.nextBigDecimal();
        sc.nextLine();
        System.out.println("Unesite id: ");
        Long id = sc.nextLong();
        sc.nextLine();
        Meal jelo = new Meal(name, category, ingredients, price, id);
        return jelo;
    }

    public static Chef unosSefova(Scanner sc){

        System.out.println("Unesite ime kuhara: ");
        String name = sc.nextLine();
        System.out.println("Unesite prezime kuhara: ");
        String lastName = sc.nextLine();
        System.out.println("Unesite plaću: ");
        BigDecimal salary = sc.nextBigDecimal();

        System.out.println("Unesite id: ");
        Long id = sc.nextLong();
        sc.nextLine();
        Chef chef = new Chef(name, lastName, salary, id);
        return chef;
    }

    public static Waiter unosKonobara(Scanner sc){
        System.out.println("Unesite ime konobara: ");
        String name = sc.nextLine();
        System.out.println("Unesite prezime konobara: ");
        String lastName = sc.nextLine();
        System.out.println("Unesite plaću konobara: ");
        BigDecimal salary = sc.nextBigDecimal();
        sc.nextLine();
        System.out.println("Unesite id: ");
        Long id = sc.nextLong();
        sc.nextLine();

        Waiter waiter = new Waiter(name, lastName, salary, id);
        return waiter;
    }

    public static Deliverer unosDostavljaca(Scanner sc){

        System.out.println("Unesite ime dostavljaca: ");
        String name = sc.nextLine();
        System.out.println("Unesite prezime dostavljaca: ");
        String lastName = sc.nextLine();
        System.out.println("Unesite plaću: ");
        BigDecimal salary = sc.nextBigDecimal();
        sc.nextLine();
        System.out.println("Unesite id: ");
        Long id = sc.nextLong();
        sc.nextLine();
        Deliverer deliverer = new Deliverer(name, lastName, salary, id);
        return deliverer;
    }

    public static Address unosAdrese(Scanner sc){
        System.out.println("Unesite ime ulice: ");
        String ulica = sc.nextLine();
        System.out.println("Unesite kućni broj: ");
        String kucniBroj = sc.nextLine();
        System.out.println("Unesite ime grada: ");
        String imeGrada = sc.nextLine();
        System.out.println("Unesite postanski broj: ");
        String postanskiBroj = sc.nextLine();
        System.out.println("Unesite id broj: ");
        Long id = sc.nextLong();
        sc.nextLine();

        Address adresa = new Address(ulica, kucniBroj, imeGrada, postanskiBroj, id);

        return adresa;
    }

    public static Restaurant unosRestorana(Scanner sc, Meal[] meals, Chef[] chefs, Waiter[] waiters, Deliverer[] deliverers) {
        System.out.println("Unesite ime restorana: ");
        String name = sc.nextLine();

        System.out.println("Na kojoj se adresi nalazi restoran? ");
        Address address = unosAdrese(sc);

        System.out.println("Koliko jela se posluzuje? Maksimalan broj je " + BROJ_JELA);
        Integer brJela = sc.nextInt();
        Meal[] chosenMeals= new Meal[brJela];

        System.out.println("Koja su to jela od ponuđenih: \n");

        for(int i = 0; i < brJela; i++){
            for(int j = 0; j < BROJ_JELA; j++){
                System.out.println((j + 1) + ". jelo: " + meals[j].getName() + "\n");
            }
            System.out.println("Izaberi: ");
            Integer izabranoJelo = sc.nextInt();
            chosenMeals[i] = meals[izabranoJelo - 1];
        }

        // Kuhari
        System.out.println("Kolko kuhara radi u kuhinji? Maksimalni broj je " + BROJ_JELA);
        Integer brKuhara = sc.nextInt();
        Chef[] chef = new Chef[brKuhara];
        System.out.println("Koji su to kuhari od ponuđenih?\n");
        for(int i = 0; i < brKuhara; i++){
            for(int j = 0; j < BROJ_SEFOVA; j++){
                System.out.println((j + 1) + ". šef kuhinje: " + chefs[j].getFirstName() + " " + chefs[j].getLastName());
            }
            System.out.println("Izaberi: ");
            Integer rdBrKuhara = sc.nextInt();
            chef[i] = chefs[rdBrKuhara - 1];
        }

        // Konobari
        System.out.println("Kolko konobara radi u kuhinji? Maksimalni broj je " + BROJ_KONOBARA + "\n");
        Integer brKonobara = sc.nextInt();
        Waiter[] waiter = new Waiter[brKonobara];
        System.out.println("Koji su to konobari od ponuđenih?\n");
        for(int i = 0; i < brKonobara; i++){
            for(int j = 0; j < BROJ_KONOBARA; j++){
                System.out.println((j + 1) + ". konobar: " + waiters[j].getFirstName() + " " + waiters[j].getLastName());
            }
            System.out.println("Izaberi: ");
            Integer rdBrKonobara = sc.nextInt();
            waiter[i] = waiters[rdBrKonobara - 1];
        }

        // Dostavljaci
        System.out.println("Koliko dostavljaca radi u restoranu? Maksimalan broj dostavljača je " + BROJ_DOSTAVLJACA + "\n");
        Integer brDostavljaca = sc.nextInt();
        Deliverer[] deliverer = new Deliverer[brDostavljaca];
        System.out.println("Koji su dostavljači zaposleni od ponuđenih?\n");
        for(int i = 0; i  < brDostavljaca; i++){
            for(int j = 0; j < BROJ_DOSTAVLJACA; j++){
                System.out.println((j + 1) + ". dostavljač: " + deliverers[j].getFirstName() + " " + deliverers[j].getLastName());
            }
            System.out.println("Izaberi: ");
            Integer rdBrDostavljaca = sc.nextInt();
            deliverer[i] = deliverers[rdBrDostavljaca - 1];
        }
        sc.nextLine();

        System.out.println("Uneite id: ");
        Long id = sc.nextLong();
        sc.nextLine();
        Restaurant restoran = new Restaurant(name, address, meals, chef, waiter, deliverer, id);

        return restoran;
    }

    public static Order unosNarudzbe(Scanner sc, Restaurant[] restaurants, Meal[] meals, Deliverer[] deliverers) {
        System.out.println("Narucujete hranu. Izaberite restoran: \n");
        for(int i = 0; i < BROJ_RESTORANA; i++){
            System.out.println((i + 1) + ". restoran: " + restaurants[i].getName() + "\n");
        }
        Integer brRestorana = sc.nextInt();
        Restaurant restoran = restaurants[brRestorana - 1];

        System.out.println("Izaberite kolicinu jela koje planirate narucit. Maksimalan broj je " + BROJ_JELA);
        Integer kolJela = sc.nextInt();
        Meal[] meal = new Meal[kolJela];
        for(int i = 0; i < kolJela; i++){
            for(int j = 0; j < BROJ_JELA; j++){
                System.out.println((i + 1) + ". jelo: " + meals[i].getName() + "\n");
            }
            System.out.println("Izaberite: ");
            Integer brJela = sc.nextInt();
            meal[i]= meals[brJela - 1];
        }
        System.out.println("Izaberite dostavljaca: \n");
        for(int i = 0; i < BROJ_DOSTAVLJACA; i++){
            System.out.println((i + 1) + ". dostavljac: " + deliverers[i].getFirstName() + deliverers[i].getLastName() + "\n");
        }
        Integer brDostavljaca = sc.nextInt();
        Deliverer deliverer = deliverers[brDostavljaca - 1];

        LocalDateTime deliveryDateAndTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        while (true) {
            try {
                System.out.println("Unesite datum i vrijeme dostave (yyyy-MM-dd HH:mm):");
                String dateTimeStr = sc.nextLine();
                deliveryDateAndTime = LocalDateTime.parse(dateTimeStr, formatter);
                break;
            } catch (Exception e) {
                System.out.println("Neispravan format datuma! Pokušajte ponovno.");
            }
        }
        System.out.println("Unesite id: ");
        Long id = sc.nextLong();
        sc.nextLine();
        return new Order(restoran, meal, deliverer, deliveryDateAndTime, id);

    }

    public static void mostExpensiveOrder(Order[] orders){

        BigDecimal mostExpensive = BigDecimal.ZERO;
        for(Order order : orders){
            BigDecimal tmpPrice = BigDecimal.ZERO;
            for(Meal meal : order.getMeals()){
                tmpPrice = tmpPrice.add(meal.getPrice());
            }
            if(tmpPrice.compareTo(mostExpensive) > 0){
                mostExpensive = tmpPrice;

            }
        }

        for(Order order : orders){
            BigDecimal totalPrice = BigDecimal.ZERO;
            for(Meal meal : order.getMeals()){
                totalPrice = totalPrice.add(meal.getPrice());
            }
            if(totalPrice.compareTo(mostExpensive) == 0){
                System.out.println("Najveca narudzba dolazi iz sljedecih restorana: " +
                        order.getRestaurant().getName() +
                        order.getRestaurant().getAddress());
                System.out.println("Iznos narudzbe je " + totalPrice);
                System.out.println("Jela u narudzbi su: ");
                for(Meal meal : order.getMeals()){
                    System.out.println(meal.getName());
                }

            }
        }



    }

    public static void mostDeliveries(Order[] orders, Deliverer[] deliverers) {
        Integer mostDeliveries = 0;


        for(Deliverer deliverer : deliverers){
            Integer count = 0;
           for(Order order : orders){
               if(deliverer.getLastName().compareTo(order.getDeliverer().getLastName()) == 0){
                   count++;
               }
           }
           if(count > mostDeliveries){
               mostDeliveries = count;
           }
        }
        Integer tmpCount = 0;
        System.out.println("Dostavljači s najviše dostava su sljedeći: ");
        for(Deliverer deliverer : deliverers){
            for(Order order : orders){
                if(deliverer.getLastName().compareTo(order.getDeliverer().getLastName()) == 0){
                    tmpCount++;
                }
            }
            if(tmpCount == mostDeliveries){
                System.out.println("Dostavljač " + deliverer.getFirstName()
                        + " " + deliverer.getLastName() +
                        "i ima ");
            }
        }
    }


    public static void main(String[] args) {
        Category[] categories = new Category[BROJ_KATEGORIJA];
        Ingredient[] ingredient = new Ingredient[BROJ_SASTOJAKA];
        Meal[] meals = new Meal[BROJ_JELA];
        Chef[] chefs = new Chef[BROJ_SEFOVA];
        Waiter[] waiters = new Waiter[BROJ_KONOBARA];
        Deliverer[] deliverers = new Deliverer[BROJ_DOSTAVLJACA];
        Restaurant[] restaurants = new Restaurant[BROJ_RESTORANA];
        Order[] orders = new Order[BROJ_NARUDZBA];

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < BROJ_KATEGORIJA; i++) {
            System.out.println("Unesite " + (i + 1) + ". kategoriju. ");

            categories[i] = unosKategorije(sc);
        }

        for(int i = 0; i < BROJ_SASTOJAKA; i++) {
            System.out.println("Unesite " + (i + 1) + ". sastojak. ");
            ingredient[i] = unosSastojka(sc, categories);
        }

        for(int i = 0; i < BROJ_JELA; i++) {
            System.out.println("Unesite " + (i + 1) + ". jelo. ");
            meals[i] = unosJela(sc, categories, ingredient);
        }
        for(int i = 0; i < BROJ_SEFOVA; i++){
            System.out.println("Unesite ime " + (i + 1) + ". šefa.");
            chefs[i] = unosSefova(sc);
        }

        for(int i = 0; i < BROJ_KONOBARA; i++){
            System.out.println("Unesite " + (i + 1) + ". konobara. ");
            waiters[i] = unosKonobara(sc);
        }

        for(int i = 0; i < BROJ_DOSTAVLJACA; i++){
            System.out.println("Unesite " + (i + 1) + ". dostavljaca. ");
            deliverers[i] = unosDostavljaca(sc);
        }

        for(int i = 0; i < BROJ_RESTORANA; i++){
            System.out.println("Unesite " + (i + 1) + ". restoran. ");
            restaurants[i] = unosRestorana(sc, meals, chefs, waiters, deliverers);
        }

        for(int i = 0; i < BROJ_NARUDZBA; i++){
            System.out.println("Unesite " + (i + 1) + ". narudzbu. ");
            orders[i] = unosNarudzbe(sc, restaurants, meals, deliverers);
        }

        mostExpensiveOrder(orders);

        mostDeliveries(orders, deliverers);


    }
}


