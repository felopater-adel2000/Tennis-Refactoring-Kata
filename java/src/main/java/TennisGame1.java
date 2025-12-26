import java.text.MessageFormat;

public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1==m_score2) return handleEqualityScore(m_score1);
        else if (m_score1>=4 || m_score2>=4) return handlePlayerAdvantage(m_score1, m_score2);
        else return handleTwoPlayerScore(m_score1, m_score2);
    }

    private String handleEqualityScore(int score) {
        return switch (score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

    private String handlePlayerAdvantage(int score1, int score2) {
        int minusResult = score1 - score2;
        if (minusResult==1) return "Advantage player1";
        else if (minusResult ==-1) return "Advantage player2";
        else if (minusResult>=2) return "Win for player1";
        else return "Win for player2";
    }

    private String handleTwoPlayerScore(int score1, int score2) {
        String player1Score = stringScore(score1);
        String player2Score = stringScore(score2);
        return MessageFormat.format("{0}-{1}", player1Score, player2Score);
    }

    private String stringScore(int score) {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            default -> "Forty";
        };
    }
}
