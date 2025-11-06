import java.io.File;
import java.nio.file.Files;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;


public class Asymmetric {
    
    public static KeyPair generateKeys() throws Exception{
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        return kpg.generateKeyPair();
    }

    public static byte[] encrypte(byte[] plaintext, PublicKey pub) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pub);
        return cipher.doFinal(plaintext);
    }

    public static byte[] decrypte(byte[] encrypteText, PrivateKey priv) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priv);
        return cipher.doFinal(encrypteText);
    }

    public static void main(String[] args)throws Exception{
        KeyPair kp = generateKeys();

        Scanner scanner = new Scanner(System.in);
    System.out.print("File location: ");
    String path = scanner.nextLine().trim();
    File file = new File(path);
    if (!file.exists()) {
                System.out.println("Not found: " + file.getAbsolutePath());
                return;
            }
            if (file.isDirectory()) {
                System.out.println("That's a directory, not a file.");
                return;
            }
            System.out.println("encripting file: " + file.getAbsolutePath());
    byte[] plaintextbytes = Files.readAllBytes(file.toPath());

    byte[] ciphertext = encrypte(plaintextbytes, kp.getPublic());
    System.out.println("encrypted: " + Base64.getEncoder().encodeToString(ciphertext));

    byte[] plaintext = decrypte(ciphertext, kp.getPrivate());
    System.out.println("Decrypted: " +  new String(plaintext));

    }
}