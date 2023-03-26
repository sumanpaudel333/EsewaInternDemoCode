import java.util.Scanner;

public class WordleGameDemo {
    public static final String ANSI_RESET="\u001B[0m";
    public static final String ANSI_Green="\u001B[32m";
    public static final String ANSI_Yellow="\u001B[33m";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] guess = new String[6];
        String wordOfTheDay = "Nepal".toUpperCase();
        char[] wotd = wordOfTheDay.toCharArray();
        StringBuilder b=new StringBuilder();
        for (int i = 0; i < guess.length; i++) {
            System.out.println("Enter a word");
            guess[i] = sc.nextLine().toUpperCase();
            char wor = guess[i].charAt(i);
            if (wordOfTheDay.charAt(i)==wor) {
                b.append(ANSI_Green+wor+ANSI_RESET);
            }
            else if(wordOfTheDay.contains(Character.toString(wor))) {
                b.append(ANSI_Yellow+"c"+ANSI_RESET);
            }
            else {
                b.append(guess);
            }
        }
        System.out.println(b.toString());
    }
}

