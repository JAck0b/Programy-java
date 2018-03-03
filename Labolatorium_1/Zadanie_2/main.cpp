//  main.cpp
// Copyright 2018 Jakub Filistyński

#include <cstdlib>
#include <iostream>
#include "Naglowek.h"

using namespace std;

int main (int argc, char *argv[]) {
  int n;
  if (argc > 1) {  // Sprawdzanie czy sa podane jakies argumenty
    try {  // Spradzanie, czy zakres jest ok
      n = stoi(argv[1]);
      if (n > 1) {
        LiczbyPierwsze *objekt = new LiczbyPierwsze(n);
        int pomoc = objekt->dlugosc();
        for (int i = 2; i < argc; i++) {
          try {  // Spradzanie, czy erszta liczb spełnia warunki
            n = stoi(argv[i]);
            if (n >= 0 && n < pomoc) {
              cout << n << " liczbą z zakresu jest " << objekt->liczba(n) << endl;;
            } else if (n < 0) {
              cout << "Liczba powinna być nieujemna" << endl;
            } else if (n >= pomoc) {
              cout << "Liczba nie mieści się w zakrsie" << endl;
            }
          } catch(...) {
            cout << argv[i] << " nie jest liczbą naturalną" << endl;
          }
        }
        delete objekt;
      } else {
        cout << "Liczba powinna być większa od 1." << endl;
      }
    } catch (...) {
      cout << argv[1] << " nie jest liczbą naturalną." << endl;
    }
  } else {
    cout << "Podaj argumenty." << endl;
  }
  return 0;
}
