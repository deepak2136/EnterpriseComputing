package Problem1;

import java.util.Scanner;

public class PollSimulator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] candNames = new String[5];
        candNames[0] = "Deep Goyal";
        candNames[1] = "Sneha Mohan";
        candNames[2] = "Praveen Shah";
        candNames[3] = "Akshay Singh";
        candNames[4] = "Somin Majumdar";

        PollDB poll_db = new PollDB(candNames);
        int nc = poll_db.getNumberOfCandidates();

        System.out.println("please give votes to candidate numbered between 1 to " + poll_db.getNumberOfCandidates());
        for (int i = 1; i <= 5; i++) {
            int x = Integer.valueOf(sc.nextLine());
            poll_db.voteTo(x);
        }

        for (int i = 1; i <= poll_db.getNumberOfCandidates(); i++) {
            System.out.println(poll_db.getCandidateName(i) + ": " + poll_db.votesCount(i));
        }
        System.out.println("Winner: " + getWinner(sc, poll_db));
    }

    private static String getWinner(Scanner sc, PollDB pollDB) {
        int attempt = 0;
        boolean flag = false;
        while (attempt < 3) {
            System.out.println("Enter password !");
            if (sc.nextLine().equals(pollDB.getPassword())) {
                flag = true;
                break;
            }
            attempt++;
        }
        if (flag) {
            return pollDB.getPassword();
        } else {
            return "your three attempt is complete try after some time !";
        }
    }
}
