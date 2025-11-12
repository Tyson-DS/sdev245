import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;



public class SHA2562 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Password you want to be encripted: ");
        String PlainText = scanner.nextLine();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(PlainText.getBytes());

            // Convert the byte array to a hex string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            System.out.println("SHA-256: " + sb.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
