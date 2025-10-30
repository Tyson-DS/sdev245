import java.util.Scanner;

void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    boolean login = true;

    //info for a user
    String username ="user1"; 
    String password = "Passw0rd1";
    String role = "user";
    
    //login loop
    while (login){
    System.out.print("Username: ");
    String username_input = scanner.nextLine();
    System.out.print("Password: ");
    String password_input = scanner.nextLine();

    if (username_input.equals(username) && password_input.equals(password)){
        System.out.println("Login succesful");
        login = false;
    }else{System.out.println("Login failed");}
    }

    //access loop for admin or user roles.
    while(true){
    System.out.println("type admin to enter admin access");
    System.out.println("type user to enter admin access");

    String input = scanner.nextLine();
    if (input.equals("admin")){
        admin_access(role);
    }else if (input.equals("user")){
        user_access(role);
    }
    
    System.out.println("type switch to switch to admin or user for user.");
    input = scanner.nextLine();
    if (input.equals("switch")){
        role = "admin";
        System.out.println("switched to admin");
    }else if(input.equals("user")){role = "user";}
}
}

public void admin_access(String role){
    if ("admin".equals(role)){
        System.out.println("access granted!");
    }
    else{System.out.println("access denied.");}
}

public void user_access(String role){
    if (!"admin".equals(role) || !"User".equals(role)){
        System.out.println("access granted!");
    }
    else{System.out.println("access denied.");}
}
