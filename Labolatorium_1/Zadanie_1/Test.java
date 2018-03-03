// Test.java
// Copyright 2018 Jakub Filistyński

public class Test {
  public static void main (String[] args) {
    int dlugosc = args.length;
    if (dlugosc > 1) {
      int n;
      try {  // Sprawdzanie, czy pierwsza liczba jest ok
        n = Integer.parseInt(args[0]);
        if (n > 1) {
          LiczbyPierwsze objekt = new LiczbyPierwsze(n);
          int pomoc = objekt.dlugosc();
          for (int i = 1; i < dlugosc; i++) {
            try {  // Sprawdzanie, czy reszta liczb spełnia warunki
              n = Integer.parseInt(args[i]);
              if (n >= 0 && n < pomoc) {
                System.out.println(n +". liczbą z zakresu jest " + objekt.liczba(n));
              } else if (n < 0) {
                System.out.println("Liczba powinna być nieujemna");
              } else if (n >= pomoc) {
                System.out.println("Liczba nie mieści się w zakresie.");
              }
            } catch (NumberFormatException ex) {
              System.out.println(args[i] + " nie jest liczbą naturalną.");
            }
          }
        } else {
          System.out.println("Liczba powinna być większa od 1.");
        }
      } catch (NumberFormatException ex) {
        System.out.println(args[0] + " nie jest liczbą naturalną.");
      }
    } else {
      System.out.println("Za mało argumentów.");
    }
  }
}
