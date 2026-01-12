import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (P1point == P2point) {
            if (P1point >= 3) {
                return "Deuce";
            }
            String score = getScoreFromPoint(P1point);
            return MessageFormat.format("{0}-All", score);
        }
        else if(isPlayer1Win()) return "Win for player1";
        else if(isPlayer2Win()) return "Win for player2";
        else if (isAdvantagePlayer1()) return "Advantage player1";
        else if (isAdvantagePlayer2()) return "Advantage player2";

        String scorePlayer1 = getScoreFromPoint(P1point);
        String scorePlayer2 = getScoreFromPoint(P2point);
        return scorePlayer1 + "-" + scorePlayer2;
    }

    private String getScoreFromPoint(int point) {
        Map<Integer, String> scorePointMapper = new HashMap<>();
        scorePointMapper.put(0, "Love");
        scorePointMapper.put(1, "Fifteen");
        scorePointMapper.put(2, "Thirty");
        scorePointMapper.put(3, "Forty");
        return scorePointMapper.getOrDefault(point, "");
    }

    private boolean isPlayer1Win() {
        return P1point >= 4 && (P1point - P2point) >= 2;
    }

    private boolean isPlayer2Win() {
        return P2point >= 4 && (P2point - P1point) >= 2;
    }

    private boolean isAdvantagePlayer1() {
        return P1point > P2point && P2point >= 3;
    }

    private boolean isAdvantagePlayer2() {
        return P2point > P1point && P1point >= 3;
    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}