// Glowna.java
// Copyright 2018 Jakub Filistyński

/**
*Klasa z metodą główną. Pobiera dane z tablicy Stringów i dla każdego ciągu
*znaków przelicza go pomiędzy systemem arabskim a rzymskim. Dla błędnych danych
*wypiduje komunikat.
*@param String[] args
*/

public class Glowna {
  public static void main (String[] args) {
    int dlugosc = args.length;
    int n;
    /**
    *Przypadek, gdy nie zostały podane dane oraz przeciwny.
    */
    if (dlugosc == 0) {
      System.out.println("Brak danych.");
    } else {
      /**
      *Sprawdzanie wszyskich elemtków tablicy.
      */
      for (int i = 0; i < dlugosc; i++) {
        /**
        *Zamiana na inta, w przeciwnym przypadku idzie do wątku.
        */
        try {
          n = Integer.parseInt(args[i]);
          System.out.println(args[i] + " - " + RzymArab.arab2rzym(n));
        } catch (RzymArabException ar) {
          System.out.println(ar.getMessage());
        } catch (NumberFormatException ex) {
          try {
            System.out.println(args[i] + " - " + RzymArab.rzym2arab(args[i]));
          } catch (RzymArabException ra) {
            System.out.println(ra.getMessage());
          }
        }
      }
    }
  }
}
