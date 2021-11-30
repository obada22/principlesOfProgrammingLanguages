
package RASTGELEKISIURET;
/**
*
* @author       Umut ZARİF umutzarif34@gmail.com
* @öğrenci_No   G151210568 2B
* @since        21/04/2020
* @explaining :
* IMEINo sınıfı :
* üç fonksiyondan oluşmaktadır.
* -> String RandomIMEINo() : 15 haneli olan IMEI numarasının ilk iki rakamı alan kodundan rastgele alınır 
* diğer haneler rastgele atanır daha sonra 15. haneyi algoritmaya göre hesapladıktan sonra IMEI numarasını oluşturur 
* ve string olarak döndürür.
* -> void getIMEI() : 'kisiler.txt' dosyasından IMEI numarasini okuyup control Fonksiyonuna gondererek 
* dogru ve yanlis IMEI numaralari sayip ekrana yazar.
* -> boolean Control(String num) : Gonderilen IMEI numarasini sorgulayip dogru ya da yanliş olduğunu sonuç olarak gönderir
*** 
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class IMEINo {
    
    
    Rastgele rast=new Rastgele();
    
    
    public String RandomIMEINo()
    {
        
        int []Imie =new int[15];
        
        //alan kodlari
        String[] IMEI_BODY_IDS = {"01", "10", "30", "33", "35", "44",
            "45", "49", "50", "51", "52", "53", "54", "86", "91", "98", "99"};
        
        //ilk iki haneyi rastgele secmek ve char arrayina atmak
        String xx=IMEI_BODY_IDS[rast.rastgele(IMEI_BODY_IDS.length)].toString();
        char x[] =xx.toCharArray();
        
        //ilk iki haneyi Imie diziye chardan integere cevirip atmak
        Imie[0]=Integer.valueOf(x[1]);
        Imie[1]=Integer.valueOf(x[0]);
        
        //diger degerleri atmak
        for (int i = 2; i <= 14; i++) {
            Imie[i]=rast.rastgele(9);
        }
        
        int tek=0,cift=0,temp;
        //IMIE numarasinin algoritmasina gore hesaplari yapmak
        for (int i = Imie.length-2; i >=0 ; i--) 
        {
            if (i%2==0) {
                tek+=Imie[i];
            }else
            {
                temp =Imie[i]*2;
                while(temp!=0)
                {
                    cift+=temp%10;
                    temp=temp/10;
                }
            }
        }
        int son=10-((tek+cift)%10);
        String No="";
        for (int i = 0; i < 15; i++) 
        {
            No+= Integer.toString(Imie[i]);
            if (i==14)
                No+= Integer.toString(son);
        }
        return No;
    }
    
   
    private boolean Control(String num)
    {
        char[] numArr = num.toCharArray();
        
        int tek = 0, cift=0, temp;
        
        for (int i = 14; i >= 0; i--)//15. haneyi sorgulamak icin islemler 
        {
            //matriste tekli haneleri toplanır
            if (i % 2 == 0)
                tek +=Character.getNumericValue(numArr[i]);
            //matriste çiftli hanelerin içindeki değerleri 2 ile çarpıp çıkan sonucunun haneleri toplanır
            else 
            {         
                temp=Character.getNumericValue(numArr[i])*2;
                while(temp!=0) 
                {                    
                    cift+=(temp%10);
                    temp/=10;
                }
            }
        }
        return ((tek+cift)%10==0);
    }
    
    
    public void getIMEI() throws FileNotFoundException, IOException
    {
        BufferedReader bufferreader = new BufferedReader(new FileReader("Kisiler.txt"));
        int gecerli = 0;
        int gecersiz = 0;
        String line="";
        int pIndex=0;
        while ((line = bufferreader.readLine()) != null) 
        {
            //IMEI numarasini satirda bulmak icin '(' karakteri aranir 
            pIndex = line.indexOf('(')+1;
            //substring metodu ile IMEI numarasini Control fonksiyonuna gonderir
            if (Control(line.substring(pIndex,pIndex+15)))
               gecerli++;
            else 
               gecersiz++;
        }
        System.out.println("IMEI Kontrol");
        System.out.println(gecerli+"\tGeçerli");
        System.out.println(gecersiz+"\tGeçersiz");
        
    }    
}
