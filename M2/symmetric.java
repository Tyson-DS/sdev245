import java.io.File;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;


static class Keys { 
    byte[] key;
    byte[] iv;
    byte[] cipher;
}

public static Keys symmetricEncrypt(byte[] plaintextbytes) throws Exception{
    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

    KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
    keygenerator.init(128);
    SecretKey key = keygenerator.generateKey();

    byte[] iv = new byte[12];
    new SecureRandom().nextBytes(iv);

    GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);
    cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);

    Keys k = new Keys();
    k.cipher = cipher.doFinal(plaintextbytes);
    k.key = key.getEncoded();
    k.iv = iv;

    return k;
}

public static byte[] symmetricDecrypt(Keys r) throws Exception{
    SecretKey key = new SecretKeySpec(r.key, "AES");
    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
    GCMParameterSpec spec = new GCMParameterSpec(128, r.iv);
    cipher.init(Cipher.DECRYPT_MODE, key, spec);
    return cipher.doFinal(r.cipher);
}

public static void main(String[] args) throws Exception{
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
    Keys result = symmetricEncrypt(plaintextbytes);
    System.out.println("Encrypted text: "+Base64.getEncoder().encodeToString(result.cipher));

    byte[] decrypted = symmetricDecrypt(result);
    System.out.println("Decrypted text: "+ new String(decrypted));



}           