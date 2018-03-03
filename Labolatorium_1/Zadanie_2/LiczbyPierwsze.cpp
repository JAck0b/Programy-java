// LiczbyPierwsze.cpp
// Copyright 2018 Jakub Filistyński

#include <cstdlib>
#include <iostream>
#include <math.h>
#include "Naglowek.h"

using namespace std;

LiczbyPierwsze::LiczbyPierwsze(int a) {  // Konstruktor
  bool *t = new bool[a+1];  // Tablica, która będzie sitem
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
  delete[] t;
}

LiczbyPierwsze::~LiczbyPierwsze() {
  cout << "Kompletnie zniszczona klasa." << endl;
  delete[] tablica;
}

int LiczbyPierwsze::sito(bool t[], int a) {  // Metoda, która modyfikuje
  // odpowienio tablicę boolów, by zliczyć i dodać liczby do końcowej tablicy
  t[0] = false;
  t[1] = false;
  int ilosc_pierwszych = 0;  // Zmienna zliczająca liczby pierwsze
  int pierwiastek = (int)sqrt(a);
  for (int i = 0; i <= pierwiastek; i++) {  // Tylko do pierwiastka,
    // ponieważ reszta już została wyczyszczona przez inne liczby pierwsze
    if (t[i] == true) {
      for (int j = i*i; j <= a; j += i) {
        t[j] = false;
      }
    }
  }
  for (int i = 0; i <= a; i++) {
    if (t[i] == true) {
      ilosc_pierwszych++;
    }
  }
  return ilosc_pierwszych;
}

int LiczbyPierwsze::liczba(int m) {  // Metoda zwracająca, którą m jest liczbą
  // pierwszą z przedziału
  return tablica[m];
}

int LiczbyPierwsze::dlugosc() {
  return ilosc;
}
