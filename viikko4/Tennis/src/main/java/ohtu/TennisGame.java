package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    private String pointsToScore(int playerScore) {
        switch (playerScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }

    public String getScore() {
        String score;
        if (player1Score == player2Score) {
            if (player1Score != 4) {
                score = pointsToScore(player1Score) + "-All";
            } else {
                score = "Deuce";
            }
        } else if (player1Score >= 4 || player2Score >= 4) {
            int pointDifference = player1Score - player2Score;
            score = advantage(pointDifference);
        } else {
            score = pointsToScore(player1Score) + "-" + pointsToScore(player2Score);
        }
        return score;
    }

    private String advantage(int pointDifference) {
        if (pointDifference == 1) {
            return "Advantage player1";
        } else if (pointDifference == -1) {
            return "Advantage player2";
        } else if (pointDifference >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }
}
