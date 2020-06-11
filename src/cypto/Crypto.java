/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author Thole
 */
public class Crypto {
    
    private static Cipher cipher = null;
    
    public static void main(String[] args) throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
        keyGenerator.init(168);
        SecretKey secretKey = keyGenerator.generateKey();
        cipher = Cipher.getInstance("DESede");
        
        String plainText = "kriptografi menggunakan java kriptografi exstensi";
        System.out.println("plain text before enkripsi\t: " + plainText);
        
        byte[] plainTextByte = plainText.getBytes("UTF8");
        byte[] encryptedBytes = encrypt(plainTextByte, secretKey);
        
        String encryptedText = new String(encryptedBytes, "UTF8");
        System.out.println("enkripsi text after enkripsi\t: " + encryptedText);
        
        byte[] decryptedBytes = decrypt(encryptedBytes, secretKey);
        String decryptedText = new String(decryptedBytes, "UTF8");
        System.out.println("decrypted text after deskiption\t: " +decryptedText);
    }
    
    static byte[] encrypt(byte[] plainTextByte, SecretKey secretKey) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainTextByte);
        return encryptedBytes;
    }
    
    static byte[] decrypt(byte[] encryptedBytes, SecretKey secretKey) throws  Exception{
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes= cipher.doFinal(encryptedBytes);
        return decryptedBytes;
    }
}