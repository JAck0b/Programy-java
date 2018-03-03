public class LiczbyPierwsze {
  private int tablica[];
  private int ilosc;

  public LiczbyPierwsze(int a) {  // Konstruktor
    boolean t[] = new boolean[a+1];  // Tablica, która będzie sitem
    for (int i = 0; i <= a; i++) {  // Zmienianie wszyskich wartości na true
      t[i] = true;
    }
    ilosc = sito(t, a);
    tablica = new int[ilosc];
    int pomoc = 0;  // Zmienna, którą będziemy zapisywać dane w nowej tablicy
    for (int i = 0; i <= a; i++) {
      if (t[i] == true) {
        tablica[pomoc] = i;
        pomoc++;
      }
    }
  }

  int sito(boolean t[], int a) {  // Metoda, która modyfikuje odpowiednio
    // tablicę booleanów, by móc zliczyć i dodać liczby do końcowej tablicy
    t[0] = false;
    t[1] = false;
    int ilosc_pierwszych = 0;  // Zmienna zliczająca liczby pierwsze
    int pierwiastek = (int)Math.sqrt(a);
    for (int i = 0; i <= pierwiastek; i++) {  // Tylko do pierwiastka,
      // ponieważ reszta już została wyczyszczona przez inne liczby pierwsze
      if (t[i] == true) {
        for (int j = i*i; j <= a; j += i) {
          t[j] = false;
        }
      }
    }
    for (boolean x: t) {
      if (x == true) {
        ilosc_pierwszych++;
      }
    }
    return ilosc_pierwszych;
  }

  int liczba(int m) {  // Metoda zwracająca, którą m jest liczbą pierwszą
    return tablica[m];
  }

  int dlugosc() {
    return ilosc;
  }

}
