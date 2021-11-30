
package RASTGELEKISIURET;
/**
*
* @author       Umut ZARİF umutzarif34@gmail.com
* @öğrenci_No   G151210568 2B
* @since        21/04/2020
* @explaining :
* RastgeleKisi sınıfı :
* iki fonksiyondan oluşmaktadır,
* ->KisiUret(int adet):"Kisiler.txt" dosyasını oluşturup Gönderilen sayıya kadar 
* diğer sınıflardan nesne oluşturarak rastgele kişi üretmek ve dosyaya yazmak.
* ->Control() : T.C ve IMEI numaralarını kontrol sınıflarını çağırmak.
*** 
*/
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RastgeleKisi {
    //sınıflardan nesne oluşturmak
    Rastgele rast=new Rastgele();
    KimlikNo kimlik=new KimlikNo();
    Kisi kisi=new Kisi(); 
    Telefon telefon=new Telefon();
    IMEINo imei=new IMEINo();
    
    public  void KisiUret(int adet) throws IOException
    {  
        String line="";
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("Kisiler.txt", true));
        for (int i = 0; i < adet; i++) {            
            line= 
                  kimlik.RandomKimlik() + "\t"  //T.C. numarası
                + kisi.Isim()                   //isim
                + (rast.rastgele(99)+1) +"\t"   //yaş
                + telefon.RandomTelefon() +"\t("//telefon numarası
                + imei.RandomIMEINo()+")";      //IMEI numarası
            
            writer.append(line);
            writer.append("\r\n");
        }
        
        writer.close();

    }
    
    public void Control() throws IOException
    {        
        kimlik.getTC();
        imei.getIMEI();
        
    }
}
