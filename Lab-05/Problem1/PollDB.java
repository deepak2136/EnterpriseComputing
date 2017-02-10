package Problem1;

public class PollDB {

    private String[] candidates = null;
    private int[] votes = null;
    private final String password = "deepak";

    public PollDB(String[] candidates) {
        this.candidates = candidates;
        this.votes = new int[candidates.length];
    }

    public int getNoOfCandidates() {
        return candidates.length;
    }

    public void voteTo(int pos) {
        votes[pos - 1]++;
    }

    public String getCandidateName(int pos) {
        return candidates[pos - 1];
    }

    public String getWinner() {
        int maxPos = 0;
        for (int i = 1; i < this.candidates.length; i++) {
            if (votes[maxPos] < votes[i]) {
                maxPos = i;
            }
        }
        return candidates[maxPos] + " : " + votes[maxPos] + " votes.";
    }

    public int getNumberOfCandidates() {
        return candidates.length;
    }

    public int votesCount(int i) {
        return votes[i - 1];
    }

    public String getPassword() {
        return password;
    }
}
