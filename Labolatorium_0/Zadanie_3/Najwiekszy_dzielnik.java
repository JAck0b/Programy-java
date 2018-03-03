// Najwiekszy_dzielnik.java
// Copyright 2018 Jakub Filistyński

public class Najwiekszy_dzielnik {
  public static int div(int n) {  // Wyszukiwanie najwiekszego dzielnika za pomocą znalezienia najmniejszego zielnika
    int wynik = 1;
    int pierwiastek = (int)Math.sqrt(n);
    for (int i = 2; i <= pierwiastek; i++) {  // Można też szykać od n/2 w dół
      if (n%i == 0) {
        wynik = i;
        break;
      }
    }
    if (wynik != 1) {
      wynik = n/wynik;
    }
    return wynik;
  }
  public static void main (String[] args) {
    int n;
    for (int i = 0; i < args.length; i++) {
      try {
        n = Integer.parseInt(args[i]);
        if (n == 0) {
          System.out.println("Zero nie ma największego dzielnika.");
        } else if (n < 0) {
          System.out.println("Liczba musi być dodatnia.");
        } else {
          System.out.println(args[i]+" "+div(n));
        }
      } catch (NumberFormatException ex) {
        System.out.println(args[i] + " nie jest liczba całkowitą.");
      }
    }
  }
}
