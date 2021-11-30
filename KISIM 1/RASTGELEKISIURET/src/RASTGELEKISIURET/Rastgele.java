
package RASTGELEKISIURET;
/**
*
* @author       Umut ZARİF umutzarif34@gmail.com
* @öğrenci_No   G151210568 2B
* @since        21/04/2020
* @explaining :
* Rastgele sınıfı :
* tek bir fonksiyona sahip "int rastgele(int sinir)" İşletim sistemdeki milisaniyeyi bellekteki
* adres ile toladıktan sonra gönderilen sınırın moduna alıp rastgele değer üretmektir.
*** 
*/
public class Rastgele {
    public int rastgele(int sinir) //Rastgele Integer donduren fonksiyon
    {
        
        int rast= 1; //Rastgele Integerin Basamaklari ayri ayri her bir dongude alinmistir
   
            int ret;
            long time = System.currentTimeMillis();     //isletim sistemin saatinden faydalanarak tekil bir deger alinmistir
            long address = System.identityHashCode(time);   //bir degiskenin hafiza tutuldugu adresin degeri de alinmistir
            ret = ((int)(time +address))%sinir;
            
           
        return ret < 0 ? -ret : ret;   //sonuc negatif ise pozitifi alinmistir
    }
    
  
}
