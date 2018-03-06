// RzymArab.java
// Copyright 2018 Jakub Filistyński
/**
*@author Jakub Filistyński
*/
/**
* Definiewa wyjątku oraz jego konstruktora.
*/

class RzymArabException extends Exception {
  public RzymArabException(String napis) {
    super(napis);
  }
}

/**
*Klasa RzymArab ma jedno statyczne prywatne pole  liczyb, które zawiera
*wszykiego liczby rzymskie oraz dwie publiczne metody, które zamieniają liczby
*między arabskiem systemem zapisu a rzymskim.
*/

public class RzymArab {
  /**
  *Prywatna statyczna tablica z liczbami w systemie rzymskim.
  */
  private static String[] liczby = {"I", "V", "X", "L", "C", "D", "M"};

  /**
  *Prywatna metoda statyczna pomocnicza, do zamiany liczb setek, dziesiątek
  *i jedności.
  *@param int pomoc
  *@param int rzadLiczby
  *@param String odpowiedz
  *@return String odpowiedz
  */
  private static String ar2rz (int pomoc, int rzadLiczby, String odpowiedz) {
    switch (pomoc) {
      case 0:
        break;
      case 1:
        odpowiedz += liczby[rzadLiczby-1];
        break;
      case 2:
        odpowiedz += liczby[rzadLiczby-1];
        odpowiedz += liczby[rzadLiczby-1];
        break;
      case 3:
        odpowiedz += liczby[rzadLiczby-1];
        odpowiedz += liczby[rzadLiczby-1];
        odpowiedz += liczby[rzadLiczby-1];
        break;
      case 4:
        odpowiedz += liczby[rzadLiczby-1];
        odpowiedz += liczby[rzadLiczby];
        break;
      case 5:
        odpowiedz += liczby[rzadLiczby];
        break;
      case 6:
        odpowiedz += liczby[rzadLiczby];
        odpowiedz += liczby[rzadLiczby-1];
        break;
      case 7:
        odpowiedz += liczby[rzadLiczby];
        odpowiedz += liczby[rzadLiczby-1];
        odpowiedz += liczby[rzadLiczby-1];
        break;
      case 8:
        odpowiedz += liczby[rzadLiczby];
        odpowiedz += liczby[rzadLiczby-1];
        odpowiedz += liczby[rzadLiczby-1];
        odpowiedz += liczby[rzadLiczby-1];
        break;
      case 9:
        odpowiedz += liczby[rzadLiczby-1];
        odpowiedz += liczby[rzadLiczby+1];
        break;
    }
    return odpowiedz;
  }

  /**
  *Statyczna prywatna matoda zamienia liczbę z systemu arabskiego na rzymski.
  *@param int wejscie
  *@return Zwraca liczbę w systemie rzymskim.
  @throws RzymArabException Sprawdza, czy liczba jes w dobrym przedziale.
  */

  public static String arab2rzym (int wejscie) throws RzymArabException {
    if (wejscie < 0) {
      throw new RzymArabException("Liczba musi być dodatnia.");
    } else if (wejscie >= 4000) {
      throw new RzymArabException("Liczba nie może być większa niż 3999.");
    } else if (wejscie == 0) {
      throw new RzymArabException("Liczba musi być różna od 0.");
    }
    String odpowiedz = "";
    int rzadLiczby = 7;
    for (int i = 1000; i > 0; i = i/10) {
      int pomoc;
      pomoc = (int)(wejscie/i);
      wejscie = wejscie%i;
      odpowiedz = ar2rz(pomoc, rzadLiczby, odpowiedz);
      rzadLiczby -= 2;
    }
    return odpowiedz;
  }
  /**
  *Prywatna metoda statyczna pomocnicza zamieniająca liczby rzymskie na arabskie
  *(nielicząc tych zrobionych przez odejmowanie).
  *@param String wejscie
  @return Wartość liczby "regularnej", lub -1000 gdy jest błąd.
  */
  private static int rz2ar (String wejscie) {
    for (int i = 0; i < 7; i++)
      if (wejscie.equals(liczby[i])) {
        if (i%2 == 1)
          return 5*(int)Math.pow(10, (int)(i/2));
        else
          return (int)Math.pow(10, i/2);
      }
      return -1000;
  }

  /**
  *Prywatna metoda statyczna pomocnicza, sprawdzająca ile jest V, L, D w ciągu
  *znaków.
  *@param int dlugosc
  *@param String wejscie
  *@return true - ciąg nie ma więcej niż po jednej takiej liczbie, false - w
  *przeciwnym przypadku
  */

  private static boolean piec (int dlugosc, String wejscie) {
    int piatki = 0;
    int piecdziesiatki = 0;
    int piecsetki = 0;
    for (int i = 0; i < dlugosc; i++) {
      if (wejscie.charAt(i) == 'V')
        piatki++;
      else if (wejscie.charAt(i) == 'L')
        piecdziesiatki++;
      else if (wejscie.charAt(i) == 'D')
        piecsetki++;
    }
    if (piatki > 1 || piecdziesiatki > 1 || piecsetki > 1)
      return false;
    return true;
  }

  /**
  *Prywatna metoda statyczna pomocnicza sprawdzająca, czy ciąg liclzb jest
  *liczbą powstałą przez odejmowanie dwóch liczb arabskich. Pięta również, czy
  *wcześniej nie było takiej liczby rozpoczynającej się od tego samego znaku.
  *@param boolean[] ograniczenie
  *@param String obecny
  *@param String następny
  *@return Zwraca czy liczba jest zrobiona przez odejmowanie dwóch liczb
  */

  private static boolean rzymOdej(boolean ograniczenie[], String obecny,
  String nastepny) {
    switch (obecny.charAt(0)) {
      case 'I':
        if (nastepny.equals("X") && ograniczenie[0] == false) {
          ograniczenie[0] = true;
          return true;
        } else if (nastepny.equals("V") && ograniczenie[0] == false) {
          ograniczenie[0] = true;
          return true;
        }
        break;
      case 'X':
        if (nastepny.equals("C") && ograniczenie[1] == false) {
          ograniczenie[1] = true;
          return true;
        } else if (nastepny.equals("L") && ograniczenie[1] == false) {
          ograniczenie[1] = true;
          return true;
        }
        break;
      case 'C':
        if (nastepny.equals("M") && ograniczenie[2] == false) {
          ograniczenie[2] = true;
          return true;
        } else if (nastepny.equals("D") && ograniczenie[2] == false) {
          ograniczenie[2] = true;
          return true;
        }
        break;
      }
      return false;
  }

  /**
  *Statyczna metoda prywatna pomocnicza która wzraca, czy dany ciąg znaków jest
  *liczbą w systemie rzymskim.
  *@param int dlugosc
  *@param String wejscie
  @return Zwraca, czy liczba jest w systemie rzymskim
  */

  private static boolean rzymskieSpr(int dlugosc, String wejscie) {
    /**
    *Liczy serię jednego znaku.
    */
    int seria = 0;
    /**
    *Pamięta, miejsce w stringu.
    */
    int iterator = 0;
    /**
    *Wyznacza granicę sprawdzania w tablicy rzadLiczby.
    */
    int zakres = 6;
    /**
    *Stringi zapamiętujące poprzednią literkę i obecną.
    */
    if (piec(dlugosc, wejscie) == false)
      return false;
    String ostatni = "";
    String obecny = "";
    boolean dopasowanie = false;
    boolean odpowiedz = true;
    boolean[] ograniczenie = new boolean[3];
    while (iterator < dlugosc) {
      obecny = String.valueOf(wejscie.charAt(iterator));
      dopasowanie = false;
      /**
      *Szykanie odpowiedniego dopasowania.
      */
      for (int i = zakres; i >= 0; i--) {
        /**
        *Sprawdzanie, czy jest to kolejna liczba do serii.
        */
          if (obecny.equals(liczby[i])) {
            dopasowanie = true;
            if (obecny.equals(ostatni)) {
              seria++;
            } else {
              zakres = i;
              seria = 1;
              ostatni = obecny;
            }
            /**
            *Sprawdzanie, czy to jest liczba składająca się z dwóch znaków.
            */
            if (dlugosc - iterator > 1 && seria == 1 &&
            rzymOdej(ograniczenie, obecny,
            String.valueOf(wejscie.charAt(iterator+1)))) {
              /**
              *Dodatkowe przesiunięcie
              */
              iterator++;
              zakres = i-1;
              seria = 0;
              ostatni = "";
            }
            iterator++;
            break;
          }
      }
      /**
      *Nie znaleziono dopasowania.
      */
      if (dopasowanie == false) {
        odpowiedz = false;
        break;
      }
      /**
      *SA więcej niż trzy takie same znaki pod rząd lub seria 5, 50, 500 jes
      *większa niż 1.
      */
      if (seria > 3 || (seria > 1 && (ostatni.equals("D") || ostatni.equals("L")
      || ostatni.equals("V")))) {
        odpowiedz = false;
        break;
      }
    }
    return odpowiedz;
  }

  /**
  *Statyczna publiczba metoda, która przelicza liczbe z zapisu rzymskiego na
  *arabski.
  *@param String wejscie
  *@return Zwraca liczbę preliczoną na system arabski
  *@throws RzymArabException Wyjątek przechwytujący w przypadku złego zapisu
  */

  public static int rzym2arab (String wejscie) throws RzymArabException {
    int odpowiedz = 0;
    int dlugosc = wejscie.length();
    /**
    *Sprawdza, czy liczba jest zapisana poprawnie, lub czy jej długość jest
    *odpowiednia.
    */
    if (rzymskieSpr(dlugosc, wejscie) == false) {
      throw new RzymArabException("To nie jest liczba w systemie rzymskim.");
    } else if (dlugosc == 0) {
      throw new RzymArabException("Podaj liczbę.");
    }
    /**
    *System wyszukiwania liczb zapisanych za pomocą dwóch róźnych znaków.
    */
    for (int i = 0; i < dlugosc; i++) {
      switch (wejscie.charAt(i)) {
        case 'I':
          if (dlugosc - i > 1 && wejscie.charAt(i+1) == 'X') {
            odpowiedz += 9;
            i++;
          } else if (dlugosc -i > 1 && wejscie.charAt(i+1) == 'V') {
            odpowiedz += 4;
            i++;
          } else
            odpowiedz +=rz2ar(String.valueOf(wejscie.charAt(i)));
          break;
        case 'X':
          if (dlugosc - i > 1 && wejscie.charAt(i+1) == 'C') {
            odpowiedz += 90;
            i++;
          } else if (dlugosc -i > 1 && wejscie.charAt(i+1) == 'L') {
            odpowiedz += 40;
            i++;
          } else
            odpowiedz +=rz2ar(String.valueOf(wejscie.charAt(i)));
          break;
        case 'C':
          if (dlugosc - i > 1 && wejscie.charAt(i+1) == 'M') {
            odpowiedz += 900;
            i++;
          } else if (dlugosc -i > 1 && wejscie.charAt(i+1) == 'D') {
            odpowiedz += 400;
            i++;
          } else
            odpowiedz +=rz2ar(String.valueOf(wejscie.charAt(i)));
          break;
        default:
          /*
          *W przeciwnym wypadku jest wyliczana rozmalnie wartość za pomocą
          *metody pomocniczej.
          */
          odpowiedz +=rz2ar(String.valueOf(wejscie.charAt(i)));
          break;
        }
      }
      return odpowiedz;
    }
  }
