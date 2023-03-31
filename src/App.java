import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        NumberSet numberSet = new NumberSet();
        Random random = new Random();
        for(int i = 0; i<10; i++){
            numberSet.add(random.nextInt(10));
        }
        numberSet.print();
        System.out.println("Rozmiar zbioru: " + numberSet.getSize());
        System.out.println("Suma elementów: " + numberSet.getSumOfElements());
        try {
            numberSet.remove(5);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Losowo usunięty element o indeksie: " + numberSet.getRandomValue());
        System.out.println("Rozmiar zbioru: " + numberSet.getSize());



        System.out.println("Czy w zbiorze istnieje: 7 " +numberSet.contains(7));

        numberSet.divideAllElementsBy(2);
        numberSet.print();

    }
}
