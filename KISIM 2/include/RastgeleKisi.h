/**
*
* @author       Umut ZARİF umutzarif34@gmail.com
* @öğrenci_No   G151210568 2B
* @since        23/04/2020
***
*/

#ifndef RASTGELEKISI_H
#define RASTGELEKISI_H
#include "Random.h"
//rastgele karakter ureten yapi.
// RastgeleKisi, Random yapısından kalıtım alıyor.
//Yazılan fonksiyonlar yapi icerisinden fonksiyon gostericisi yardimiyla gosteriliyor 
//ve o sekilde cagriliyor.
//Baslik dosyalarinda metot govdesi yazilmadi.
struct RastgeleKisi{
	//random tipinden degisken
	Random ran;
	//rastgele karakterimiz icinde saklicaz
	int  yas;
	
	//bir karakter ureten fonksiyon
	int (*Yas)(struct RastgeleKisi*);
	//birden fazla karakter ureten fonksiyon, int parametresine gore sayi belirtilir
	char* (*coklu)(struct RastgeleKisi*,int);
	//bir rastgele karakter iki karakter arasından ureten fonksiyon
	char (*birerSinirli)(struct RastgeleKisi*,char,char);
	//5 karakter icinden rastgele secen fonksiyon
	char (*Belirli)(struct RastgeleKisi*,char,char,char,char,char);
	//bir rastgele cumle ureten fonksiyon
	char* (*cumle)(struct RastgeleKisi*);
};
typedef struct RastgeleKisi* RastgeleKisi;
//bir rastgele karakter olusturan
//bu fonksiyon diğer tum fonksiyonlardan kullanılacak
RastgeleKisi BirCharOlustur(int,int);

int Yas(RastgeleKarakter);
char* _coklu(RastgeleKarakter ,int);
char _birerSinirli(RastgeleKarakter,char,char);
char _BelirliKar(RastgeleKarakter,char ,char ,char ,char ,char);
char* _cumle(RastgeleKarakter);


#endif