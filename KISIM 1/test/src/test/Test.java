/**
*
* @author       Umut ZARİF umutzarif34@gmail.com
* @öğrenci_No   G151210568 2B
* @since        21/04/2020
***
* bu Rastgele kişi üreten kütüphanenin çalıştırma kodudur.
* kütüphaneyi ekledikten sonra RastgeleKisi Sınıfından bir nesne üretilmiş daha sonra
* kişi üretmek için o sınıftaki KisiUret() fonksiyonu çağırılmaktadır.
* üretilmiş kişilerin TC ve IMEI numaralarını kontrol etmek için Control() fonksiyonunu çağırılmaktadır.
*** 
*/

package test;
import RASTGELEKISIURET.RastgeleKisi;
import java.io.IOException;
import java.util.Scanner;


public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        
        RastgeleKisi kisiuret=new RastgeleKisi();
        int giris=0;
        int temp=0;
        do 
        {
            System.out.println("1- Rastgele Kişi Üret\n2- Üretilmiş Dosya Kontrol Et\n3- Çıkış");
            giris=sc.nextInt();
            switch(giris)
            {
                case 1:      
                    System.out.println("Kaç adet kişi üretmek istersiniz ?");
                    temp=sc.nextInt();
                    kisiuret.KisiUret(temp);
                    break;
                case 2:
                    kisiuret.Control();
                    break;
                case 3:
                    break;
                default :System.out.println("Hatali giris");
            }
        } while (giris!=3);
    }
    
}
