package RASTGELEKISIURET;
/**
*
* @author       Umut ZARİF umutzarif34@gmail.com
* @öğrenci_No   G151210568 2B
* @since        21/04/2020
* @explaining :
* KimlikNo sınıfı :
* üç fonksiyondan oluşmaktadır.
* -> String RandomKimlik() fonksiyonunda:
* T.C numarasının oluşturma algoritmasını uygulanmaktadır.
    ilk 9 hane rastgele olarak üretilir
    çift numaralı indexleri (tek numaralı indexleri toplamı 7 ile çarpimindan cikarilip )10'a modu alınır
    ve 10. hanede yerlerştirilir    
    daha sonra çift numaralı indexleri tek numaralı indexler ile 10. hane toplanır 10'a modu alınır
    ve 11. haneye yerlerştirdikten sonra string türüne çevirilir ve döndürülür.
* -> getTC() fonksiyonunda :"Kisiler.txt" dosyasındaki her satrın ilk 11 indexi substring ile alınır 
* boolean Control(String num) gönderilir bu fonksiyonda TC numarasını sorgulamak için hesaplamalar yapılır,
* 10. ve 11. haneler hesaplamalara göre doğru ise getTC() fonksiyonuna doğru döndürür ve geçerli TC. sayısını 1 artılır
* 10. ve 11. haneler hesaplamalara göre doğru değilse getTC() fonksiyonuna yanlış döndürür ve geçersiz TC. sayısını 1 artılır
* en son geçerli ve geçersiz TC. sayılarını ekrana yazdırır.           
*** 
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class KimlikNo 
{
    Rastgele rast = new Rastgele();

    
    public String RandomKimlik() {
        
    //T.C'nin ilk 9 hanesini atamak
    int[] tc = new int[11];
    for (int i = 9; i > 0; i--) 
        tc[i - 1] = (rast.rastgele(9)+1);
    
    //tekli ve çiftli hanelerin hesaplarını yapmak
    int tek = 0, cift = 0;
    for (int i = 0; i < 10; i++) {
        if (i % 2 == 0) {
            tek += tc[i];
        } else {
            cift += tc[i];
        }

    }
    //10. ve 11. hanelerin değerlerini atamak
    tc[9] = (((tek * 7) - cift) % 10);
    tc[10] = ((tek + cift + tc[9]) % 10);

    //TC numarasını integerden stringe çevirmek
    String  tcNo="";    
    for (int i = 0; i <= 10; i++) 
        tcNo += Integer.toString(tc[i]);
    
    return tcNo;
}
    
    private boolean Control(String num)//tc kontrol metodu
    {
        char[] numArr = num.toCharArray();
        //int test=(((((int)numArr[0]+(int)numArr[2]+(int)numArr[4]+(int)numArr[6]+(int)numArr[8])*7)-((int)numArr[1]+(int)numArr[3]+(int)numArr[5]+(int)numArr[7]))%10);
    
        int tek = 0, cift = 0;
        for (int i = 0; i < 9; i++) //10. hane icin kontorl
        {
            if (i % 2 == 0) 
            {
                tek += Character.getNumericValue(numArr[i]);
            }else 
            {
                cift += Character.getNumericValue(numArr[i]);
            }
        }
        int test = (((tek * 7) - cift) % 10);
        int test2 = 0;
        for (int i = 0; i < 10; i++)//11. hane icin kontorl
        {
            test2 += (int) numArr[i];
        }
        test2 = test2 % 10;
        
           return (test == Character.getNumericValue(numArr[9]) && test2 == Character.getNumericValue(numArr[10]));
}
    
    public void getTC() throws FileNotFoundException, IOException
    {
        BufferedReader bufferreader = new BufferedReader(new FileReader("Kisiler.txt"));
        int count = 0;
        int count1 = 0;
        String line;
        while ((line = bufferreader.readLine()) != null) 
        {
            if (Control(line.substring(0,11)))
               count++;
            else 
                count1++;
        }
        System.out.println("T.C. Kimlik Kontrol");
        System.out.println(count+"\tGeçerli");
        System.out.println(count1+"\tGeçersiz");
        
    }    
}
