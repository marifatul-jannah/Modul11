/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author Thole
 */
public class AESempel {
    
    static Cipher cipher;
    public static void main(String[] args) throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(168);
        SecretKey secretKey = keyGenerator.generateKey();
        cipher = Cipher.getInstance("AES");
        
        String plainText = "kriptografi menggunakan java kriptografi exstensi";
        System.out.println("plain text before enkripsi\t: " + plainText);
        
        String encryptedText = encrypt(plainText, secretKey);
        System.out.println("enkripsi text after enkripsi\t: " + encryptedText);
        
        String decryptedText = decrypt(encryptedText,secretKey);
        System.out.println("decrypted text after deskiption\t: " +decryptedText);
    }
    
    public static String encrypt(String plainText, SecretKey secretKey) throws Exception {
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }
    
    public static String decrypt(String encryptedText, SecretKey secretKey) throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encyptedTextByte = decoder.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encyptedTextByte);
        String decryptext = new String(decryptedByte);
        return decryptext;
    }
    
}
