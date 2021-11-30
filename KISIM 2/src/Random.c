/**
*
* @author       Umut ZARİF umutzarif34@gmail.com
* @öğrenci_No   G151210568 2B
* @since        23/04/2020
***
*/

#include"Random.h"

//sleep gibi hazır fonksiyonları kullanmamak için geciktiren islemleri yapan bu fonksiyonu oluşturdum 
void ZamanKEt(){
    int i;
    char zaman[1999999];
    for(i=0;i<1999999;i++){
        int z,y;
	
        if((i%100)!=0)
            z=i%100;
        else
            z=25;

        if((i%10)!=0)
            y=i%10;
        else
            y=5;
        zaman[i]=i;
    }
}

//bu fonksiyon rastgele sayi uretir. a ve b parametreleri hangi sinirda olacagini belirtir
Random RanOlustur(int a,int b,int u){
	Random this;
    this=(Random)malloc(sizeof (struct RANDOM));
	//millisaniye almak icin
	struct timeb tmb;
	ftime(&tmb);
	int x=tmb.millitm;
	
    /*buradaki islemler sınırlar içinde bir rasgele bir haneli sayiyi bulmak için*/
	while ((x%10)<=a || (x%10*u)>=b)
        x=tmb.millitm;
    
    int y=x%10;
    
    this->Sayi=x;
    this->ZamanKayip=&ZamanKEt;
    this->ZamanKayip();
    
    return this;

}