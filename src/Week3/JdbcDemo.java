package Week3;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class JdbcDemo {
    public static void main(String[] args) {
        try{
            DBConnectionProvider.createConnection();
            System.out.println("Welcome to CRUD operation system: ");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Press 1 to Add User.");
            System.out.println("Press 2 to delete user.");
            System.out.println("Press 3 to Update user.");
            System.out.println("Press 4 to View user.");
            int input= Integer.parseInt(br.readLine());
            if (input==1){
            //Add user
                System.out.println("Enter username of user:");
                String username= br.readLine();

                System.out.println("Enter email of user: ");
                String email=br.readLine();

                System.out.println("Enter password for user: ");
                String password= br.readLine();

                UserRecord usr=new UserRecord(username,email,password);
                boolean ans=UserDao.InsertUserToDb(usr);
                if (ans){
                    System.out.println("User added successfully");
                }
                else {
                    System.out.println("Something went wrong! Please try again");
                }
                System.out.println(usr);
            } else if (input==2) {
                //delete user
                System.out.println("Enter name of user to delete: ");
                String uname= br.readLine();
                boolean dlt=UserDao.removeUserFromDb(uname);
                if (dlt){
                    System.out.println("User deleted successfully");
                }
                else {
                    System.out.println("Unable to delete user");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
