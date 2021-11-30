
package RASTGELEKISIURET;
/**
*
* @author       Umut ZARİF umutzarif34@gmail.com
* @öğrenci_No   G151210568 2B
* @since        21/04/2020
* @explaining :
* Kisi sınıfı :
* üç fonksiyondan oluşmaktadır,
* Ana fonksiyon Isim fonksiyonudur , getLinesCount() fonksiyonu çağırarak 'random isimler.txt' dosyasındaki satır sayısını öğrenilir
* daha sonra o sayıya göre Rastgele sınıfından bir rastgele sayı üretilir , daha sonra DosyaOku(int KacSatir) fonksiyonuna rastgele 
* üretilen sayı gönderilir ,o sayıya kadar 'random isimler.txt' dosyasındaki satırları sayar ve son satırdaki ismi alır Isim fonksiyonuna
* döndürür. Isim fonkiyonu üretilecek dosyadaki bilgileri hizalamasını \t ile sağlamaktadır.
*** 
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Kisi {
    Rastgele rast=new Rastgele();
    private String isim;
    
    private String DosyaOku(int KacSatir) throws FileNotFoundException, IOException 
    {
        String adSoyad="";
        int i=0;
        
            BufferedReader bufferreader = new BufferedReader(new FileReader("random isimler.txt"));
            while (i!=KacSatir)
            {
                adSoyad = bufferreader.readLine();
                i++;
            }
         
        return adSoyad;
    }
    
    public String Isim() throws IOException
    {
        int SatirSec = (int)rast.rastgele(getLinesCount());
        isim=DosyaOku(SatirSec);
        //isimlerin ayni hizaya yerlestirmek ve isim boş gönderme hatasını atlatmak için
        if (isim.length()<=1)
        {
            isim=DosyaOku(SatirSec);
        }
        else if (isim.length()>15)
        {
                isim+="\t";
        }else
                isim+="\t\t";
     return isim;
    }
    
    private int getLinesCount() throws FileNotFoundException, IOException
    {
        BufferedReader bufferreader = new BufferedReader(new FileReader("random isimler.txt"));
        int count = 0;
        String line;
        while ((line = bufferreader.readLine()) != null) 
        {
            count++;
        }
        return count;
    }
    
    
}    
