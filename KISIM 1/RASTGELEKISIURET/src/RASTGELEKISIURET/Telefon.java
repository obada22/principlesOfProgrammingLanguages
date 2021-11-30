
package RASTGELEKISIURET;

/**
*
* @author       Umut ZARİF umutzarif34@gmail.com
* @öğrenci_No   G151210568 2B
* @since        21/04/2020
* @explaining :
* Telefon sınıfı :
* RandomTelefon() fonksiyonundan oluşmaktadır, String dizisinde belirtilen alan kodlarından rastgele birini seçerek 
* telefon numarasının ilk 3 hanesini oluşturulmaktadır, diğer 7 hane ise rastgele rakamlar atamaktadır 
* en sonunda numaranın başına 0 ekleyerek String türüne çevirilir ve döndürülür.
*** 
*/
public class Telefon {
    
    Rastgele rast=new Rastgele();
    
    public String RandomTelefon ()
    {
    
        int[] Telefon = new int[11];
        String[] alanKodu={"530","531","532","533", "534","535","536","537","538","539",
                           "561","540","541","542", "543","544","545","546","547","548",
                           "549","552","553","554", "555","559","501","505","506","507",
                           "551"};
     
        int temp;              
        temp = Integer.valueOf(alanKodu[rast.rastgele(30)]);//son index 30 numarali index oldugu icin
        for (int i = 1; i <= 10; i++) 
        {
            //donguye ilk girisinde telefon numarasinin ilk 4 hanesi yerlertirilir
            if (i<3) 
            {
                for (int j = 3; j > 0; j--) 
                {
                    Telefon[j]= temp%10;
                    temp/=10;
                }
                i=4;
            }
            else
                Telefon[i] +=(rast.rastgele(9)); 
            
        }
        String numara="0";
        for (int i = 1; i <= 10; i++) 
        {
            numara += Integer.toString(Telefon[i]);    
        }
       
        return numara;
    }
    
}
