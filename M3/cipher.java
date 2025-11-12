
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cipher {
    public void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("password you want to encrypt: ");
        String plaintext = scanner.nextLine();
        System.out.print("shift: ");
        int shift = scanner.nextInt();
        List<Character> cipherChar = new ArrayList<>();
        List<Integer> cipherint = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String cipherText;

        for (char c : plaintext.toCharArray()){
            
            if (Character.isAlphabetic(c)){
            int d = (int) c;
            int newInt = c + shift;
            
            if (Character.isUpperCase(c)){
                for (int i = newInt; i > 90;){
                newInt -= 26;
                i = newInt;
                }
            }

            if (Character.isLowerCase(c)){
                for (int i = newInt; i > 122;){
                newInt -= 26;
                i = newInt;
                }
            }

            char newcipherchar = (char) newInt;
            sb.append(newcipherchar);
            } else {
                sb.append(c);
            }
            
        }
        cipherText = sb.toString();

        System.out.println(cipherText);

    }
    
}
