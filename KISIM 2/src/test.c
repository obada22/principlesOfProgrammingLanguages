/**
*
* @author       Umut ZARİF umutzarif34@gmail.com
* @öğrenci_No   G151210568 2B
* @since        23/04/2020
***
*/


#include"RastgeleKisi.h"
int main(){
    //rastgelekarakter tipinden degisken olusturdum
    RastgeleKisi rass=BirCharOlustur(65,122);
	//islemler her birini birkac kere tekrarladim belli olsun rastgelelik
	
	//bir karakter
    printf("\nBir karakter : %c",rass->Yas(rass));
	printf("\nBir karakter : %c",rass->Yas(rass));

	
	return 0;
}