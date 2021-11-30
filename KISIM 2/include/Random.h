/**
*
* @author       Umut ZARİF umutzarif34@gmail.com
* @öğrenci_No   G151210568 2B
* @since        23/04/2020
***
*/


//rastgele sayi uretmek icin kullanilan header
#ifndef RANDOM_H
#define RANDOM_H
#include "stdio.h"
#include "stdlib.h"
//bu kutuphaneler zamandan millisaniyeyi almak icin kullaniliyor
#include <sys/timeb.h>
#include <time.h>

struct RANDOM{
	int Sayi;
	//zaman kayip edici (bilgisayar hizi sepebiyle ayni harf cikiyor)
	void (*ZamanKayip)();	
};
typedef struct RANDOM* Random;
void ZamanKEt();
//sayi uretici
Random RanOlustur(int,int,int);
#endif