import java.util.*;
import java.io.*;

public class CaesarCipher 
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter test to encrypt: ");
        String str = br.readLine();
        System.out.println("Enter key value: ");
        int key = sc.nextInt();
        String encrypted = encrypt(str, key);
        System.out.println("The encrypted text is " + encrypted);
        String decrypted = decrypt(encrypted, key);
        System.out.println("The decrypted text is " + decrypted);
    }
    
    static String decrypt(String str, int key)
    {
        String decrypted = "";
        for(int i = 0; i < str.length(); i++)
        {
            int c = str.charAt(i);
            if(Character.isUpperCase(c))
            {
                c = c - (key % 26);
                
                if(c < 'A')
                {
                    c = c + 26;
                }
            }
            if(Character.isLowerCase(c))
            {
                c = c - (key % 26);
                if(c< 'a')
                {
                    c = c + 26;
                }
            }
            decrypted += (char)c;
        }
        return decrypted;
    }

    static String encrypt(String str, int key)
    {
        String strIncremented = new String();
        for(int i = 0; i < str.length(); i++)
        {
            if(Character.isUpperCase(str.charAt(i)))
            {
                int c = str.charAt(i) + key;
                if(c > 'Z')
                {
                    c = str.charAt(i);
                    c = c - 26;
                    strIncremented += (char)(c + key);
                }
                else
                {
                    strIncremented += (char)(str.charAt(i) + key);
                }
            }
            if(Character.isLowerCase(str.charAt(i)))
            {
                int c = str.charAt(i) + key;
                if(c > 'z')
                {
                    c = str.charAt(i);
                    c = c - 26;
                    strIncremented += (char)(c + key);
                }
                else
                {
                    strIncremented += (char)(str.charAt(i) + key);
                } 
            }
        }
        return strIncremented;
    }
}
