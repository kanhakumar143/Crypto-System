package com.example.cryptosystem;

public class Utility {
    private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private  static int index;
    private static int updated_index;
    private  static int final_index;
    private  static int index_p_t_l;
    private  static int index_s_t_l;
    private static String plaintxt;
    private  static String ciphertxt;
    private static String finaltxt;


    public  static String encrypt1(String plaintext, int encryptionKey){
        reset();
        plaintext = plaintext.toUpperCase();

        for(index= 0; index<plaintext.length(); index++){

            if(plaintext.charAt(index) != ' '){
                index_p_t_l = alphabet.indexOf(plaintext.charAt(index));
                updated_index = encryptionKey+alphabet.indexOf(plaintext.charAt(index));

                if (updated_index >= alphabet.length()){
                    final_index=updated_index-alphabet.length();
                }
                else {
                    final_index=updated_index;
                }
                ciphertxt=alphabet.substring(final_index, final_index+1);
                finaltxt = finaltxt+ciphertxt;
            }

        }
        return finaltxt;
    }

    public static  String decrypt1(String cipherText, int decryptionKey){
        reset();
        cipherText = cipherText.toUpperCase();

        for (index=0; index < cipherText.length(); index++){

            if (cipherText.charAt(index) != ' '){
                index_p_t_l = alphabet.indexOf(cipherText.charAt(index));
                index_s_t_l = index_p_t_l;
                updated_index = alphabet.indexOf(cipherText.charAt(index))-decryptionKey;


                if (updated_index < 0){
                    final_index = updated_index + alphabet.length();
                }
                else {
                    final_index = updated_index;
                }

                plaintxt = alphabet.substring(final_index, final_index+1);
                finaltxt += plaintxt;
            }

        }
        return finaltxt;
    }

    private static void reset() {
        finaltxt="";

    }

}
