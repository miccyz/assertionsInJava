import java.util.Random;

public class NumberSet {
    private static int MAX_SIZE = 100;
    private int[] nSet = new int[MAX_SIZE];
    private int size = 0;

    Random generator = new Random();

    /**
     * Metoda dodaje liczbę do zbioru liczb
     * (zezwalamy na dodanie liczby już istniejącej)
     *
     * @param i
     *           liczba którą dodajemy
     * @throws Exception
     *             występuje w przypadku przepełnienia zbioru
     */
    public void add(int i) throws Exception {
        assert (nSet != null);
        assert (size+1 <= MAX_SIZE): "Zbiór jest pełny";
        nSet[size] = i;
        size++;
    }

    /**
     * Metoda usuwa liczbę ze zbioru (każde wystąpienie)
     *
     * @param i
     *            liczba do usunięcia
     * @throws Exception
     *             występuje jeśli zbiór nie posiada liczby którą chcemy usunąć
     */
    public void remove(int i) throws Exception {
        assert (nSet != null);
        assert (size != 0): "Tablica jest pusta.";
        int removed = 0;
        for (int j = 0; j < size; j++){
            if (nSet[j] == i){
                int l = j;
                while (l+1 < size){
                    nSet[l] = nSet[l+1];
                    l++;
                }
                System.out.println("Element o wartości " + i + " został usunięty.");
                removed++;
                size--;
                j--;
            }
        }

        if (removed == 0)
            throw new Exception("Nie mozna znaleźć " + i + " w tablicy.");
    }

    /**
     * Metoda losuje jedną liczbę ze zbioru oraz ją usuwa
     *
     * @return wylosowana liczba
     * @throws Exception
     *             występuje jeśli zbiór jest pusty
     */
    public int getRandomValue() throws Exception {
        assert (nSet != null);
        assert(size != 0): "Tablica jest pusta.";
        int random = generator.nextInt(size);
        assert (random >= 0 && random < size): "Zły index.";
        int i = random;
        while(i < size) {
            nSet[i] = nSet[i+1];
            i++;
        }
        size--;
        return random;
    }

    /**
     * Metoda zwraca sumę elementów
     *
     * @return Suma liczb.
     * @throws Exception
     *             występuje jeśli zbiór jest pusty.
     */
    public int getSumOfElements() throws Exception {
        assert (nSet != null);
        assert(size != 0): "Tablica jest pusta.";
        int sum = 0;
        for(int i=0; i<size; i++) {
            sum += nSet[i];
        }
        return sum;
    }

    /**
     * Metoda dzieli każdy element zbioru przez podaną wartość bez reszty
     *
     * @param d
     *            liczba przez którą dzielimy
     * @throws Exception
     *             występuje w przypadku dzielenia przez 0 (można zastąpić asercją)
     */
    public void divideAllElementsBy(int d) throws Exception {
        assert (nSet != null);
        assert (size != 0): "Tablica jest pusta";
        assert (d != 0): "Nie można dzielić przez 0.";
        System.out.println("Dzielimy przez " + d);
        for (int i = 0; i < size; i++){
            nSet[i] = nSet[i]/d;
        }
    }

    /**
     * Metoda sprawdza czy w zbiorze istnieje podany element
     *
     * @param i
     *            element do sprawdzenia
     * @return true w przypadku odnalezienia wartości,
     *         false w przeciwnym razie.
     */
    public boolean contains(int i){
        assert (nSet != null);
        assert(size != 0): "Tablica jest pusta.";

        for(int j=0; j<size; j++){
            if (nSet[j] == i){
                return true;
            }
        }
        return false;
    }

    /**
     * Metoda zwraca rozmiar zbioru (liczbę elementów)
     *
     * @return rozmiar zbioru
     */
    public int getSize() {
        assert (nSet != null);
        return size;
    }

    /**
     * Metoda wyświetla elementy zbioru
     *
     */
    public void print(){
        assert (nSet != null);
        assert(size != 0):"Tablica jest pusta.";
        for (int i = 0; i < size; i++){
            System.out.print(nSet[i] + " ");
        }
        System.out.println("");
    }
}
