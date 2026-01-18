
public class TennisGame3 implements TennisGame {
    
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    private final String[] scoresList = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public String getScore() {
        if (p1 >= 4) {
            if (p1 == p2) return "Deuce";
            String s;
            if (p1 > p2) s = p1N;
            else s = p2N;

            if (isDifferenceBetween2PointsEqual1()) return "Advantage " + s;
            return "Win for " + s;
        }
        else if (p2 >= 4) {
            String s;
            s = p2N;
            if (isDifferenceBetween2PointsEqual1()) return "Advantage " + s;
            return "Win for " + s;
        }
        else if (p1 + p2 == 6) {
            return "Deuce";
        }
        else {
            String s = scoresList[p1];
            if (p1 == p2) {
                return s + "-All";
            } else {
                return s + "-" + scoresList[p2];
            }
        }

    }

    private boolean isDifferenceBetween2PointsEqual1() {
        return Math.abs(p1 - p2) == 1;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

}
