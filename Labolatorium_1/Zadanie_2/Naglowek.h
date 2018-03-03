//  Naglowek.h
// Copyright 2018 Jakub Filistyński
class LiczbyPierwsze {
private:
  int *tablica;
  int ilosc;
public:
  LiczbyPierwsze(int a);
  ~LiczbyPierwsze();
  int sito(bool t[], int a);
  int liczba(int m);
  int dlugosc();
};
