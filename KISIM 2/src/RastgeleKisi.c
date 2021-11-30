/**
*
* @author       Umut ZARİF umutzarif34@gmail.com
* @öğrenci_No   G151210568 2B
* @since        23/04/2020
***
*/
#include "RastgeleKisi.h"

//bu fonksiyon RastgeleKarakter tipinden bir değişken return yapacak
//bu değişken içinde rastgele karakter tutacak ve diğer fonksiyonlara verilecek
RastgeleKisi BirKişiOlustur(int x,int y,int u){
	
	RastgeleKisi this;
	this = (RastgeleKisi)malloc(sizeof(struct RastgeleKisi));
	//ran icinde random tipinden degisken olusturduk rastgele sayi kullanmak icin
	this->ran = RanOlustur(x,y,u);
	//karakterimiz bu sayinin karsiligi
    this->yas=this->ran->Sayi;
	//struct icindeki gosterici fonksiyonlarin islemleri
    this->Yas=Yas;
	this->coklu=_coklu;
	this->birerSinirli=_birerSinirli;
	this->Belirli=_BelirliKar;
	this->cumle=_cumle;
	return this;
}
int Yas(RastgeleKisi rast){
	//bir karakter olusturup donusum yapar
    rast=BirKişiOlustur(-1,100,10);
    return rast->yas;
}



char* _coklu(RastgeleKisi rast,int sayi){
	//bir dizi olusturduk uzunlugu sayi parametreye gore degismekte
	//bu diziyi donus edicez.
    char *dizi=malloc(sizeof(char)*sayi);
    //dizi NULL degilse
    if(dizi!=NULL)
    {
		//for dongusu ;dizinin icinde her indekste bir rastgele karakter ataması yapar.
        int i;
		for(i=0;i<sayi;i++){
        rast=BirCharOlustur(65,122);
        dizi[i]=rast->kar;
		}
		dizi[i]='\0';
    }
    return dizi;
}
char _birerSinirli(RastgeleKisi rast,char a,char b){
    //parametreler integere ceviririz,sinirler olarak kullanmak icin.
	int x=a;
    int y=b;
    rast=BirCharOlustur(a,b);
    return rast->kar;
}
char _BelirliKar(RastgeleKisi rast,char a,char b,char c,char d,char e){
    
	rast=BirCharOlustur(65,122);
	
    
	//y bir hanelik rastgele sayi ,onu hangi harf seçicegmize yardimci olacak.
    int y=(rast->ran->Sayi)%10;
	//bu dizi içine tum parametreleri atacaz
    char parametr []={a,b,c,d,e};
    //bu for dongusu kullanarak y rastgele sayımız:
    // 0 veya 1 ise 1. indeks sececek
    // 2 veya 3 ise 2. indeks sececek
	// 4 veya 5 ise 3. indeks sececek
	// 6 veya 7 ise 4. indeks sececek
	// 8 veya 9 ise 5. indeks sececek
    int i ;
    for(i=0;i<10;i=i+2){
        if(y==i || y==i+1)
            rast->kar=parametr[i/2];
    }
    
    return rast->kar;
}

char* _cumle(RastgeleKisi rast){
	int k;
	//x rastgele sayimiz
    int x=rast->ran->Sayi;
	//y bir hanelik rastgele sayimiz
	int y=x%10;
	if(y<3)
		y=3;
	//ydizi boşluklar nerede koyulacağını belirtilir
	int ydizi[x];
	for(k=0;k<x;k++){
		if(k==0)
			ydizi[0]=y;
		else
			
			ydizi[k]=ydizi[k-1]+y;
		
	}
    //dizi icinde cumleyi tutacaz
    char *dizi=malloc(sizeof(char)*x);
    if(dizi!=NULL)
    {
        int i;
        for(i=0;i<x;i++){
            rast=BirCharOlustur(65,122);
            int sayac;
            for(sayac=0;sayac<x;sayac++)
            {
				//boşluk koymak icin
                if(i==ydizi[sayac])
                    dizi[i]=' ';
            }
            if(dizi[i]==' ')
                dizi[i]=' ';
            else
                dizi[i]=rast->kar;
        }
        dizi[i]='\0';
    }
    return dizi;

}
