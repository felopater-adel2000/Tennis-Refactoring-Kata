
public class TennisGame3 implements TennisGame {
    
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    private final String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public String getScore() {
        if (p1 >= 4 || p2 >= 4 || p1 + p2 == 6) {
            if (p1 == p2) return "Deuce";
            String s;
            if (p1 > p2) s = p1N;
            else s = p2N;

            if (Math.abs(p1 - p2) == 1) return "Advantage " + s;
            return "Win for " + s;
        } else {
            String s = p[p1];
            if(p1 == p2) {
                return s + "-All";
            }
            else {
                return s + "-" + p[p2];
            }
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

}
