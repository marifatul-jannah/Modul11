/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulcrypto;

/**
 *
 * @author Thole
 */
public class ModulCrypto {

    public static void main(String[] args) {
        String plainText = "SISTER";
        String secretKey = "SECRETKEY";
        System.out.println("plain text before encryption\t: " +plainText);
        String encryptedText = encyrpt(plainText, secretKey);
        System.out.println("encyrpted after encryption\t: " +encryptedText);
        String decryptedText = decyrpt(encryptedText,secretKey);
        System.out.println("decypted text after decription\t: " +decryptedText);
    }

    private static String encyrpt(String plainText, String secretKey) {
        StringBuilder encyrptedString = new StringBuilder();
        int encryptedInt;
        for(int i = 0; i< plainText.length(); i++){
            int plainTextInt = (int) (plainText.charAt(i) - 'A');
            int secretKeyInt = (int) (secretKey.charAt(i) - 'A');
            encryptedInt = (plainTextInt + secretKeyInt) % 26;
            encyrptedString.append((char)((encryptedInt)+(int)'A'));
        }
        return encyrptedString.toString();
    }

    private static String decyrpt(String decryptedText, String secretKey) {
        StringBuilder decyptedString = new StringBuilder();
        int decryptedInt;
        for (int i = 0; i < decryptedText.length(); i++){
            int decreptedTextInt = (int) (decryptedText.charAt(i)-'A');
            int secretKeyInt = (int) (secretKey.charAt(i)- 'A');
            decryptedInt = decreptedTextInt - secretKeyInt;
            if (decryptedInt < 0){
                decryptedInt += 26;
            }
            decyptedString.append((char)((decryptedInt)+(int) 'A'));
        }
        return decyptedString.toString();
    }
    
}
