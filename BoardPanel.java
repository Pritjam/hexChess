import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

class BoardPanel extends JPanel {
    public Tile[][] map;

    public BoardPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        map = new Tile[9][9];
        for(int q = -4; q <= 4; q++) {
            for(int r = (q < 0) ? -4 - q : -4; r <= ((q < 0) ? 4 : 4 - q); r++) {
                map[r + 4][q + 4] = new Tile(q, r);
            }
        }
        map[8][0].setUnit(new Unit(Rank.KNIGHT, Color.black));
        map[8][1].setUnit(new Unit(Rank.QUEEN, Color.black));
        map[8][2].setUnit(new Unit(Rank.KNIGHT, Color.black));
        map[8][3].setUnit(new Unit(Rank.KING, Color.black));
        map[8][4].setUnit(new Unit(Rank.KNIGHT, Color.black));
        map[7][0].setUnit(new Unit(Rank.PAWN, Color.black));
        map[7][1].setUnit(new Unit(Rank.BISHOP, Color.black));
        map[7][2].setUnit(new Unit(Rank.PAWN, Color.black));
        map[7][3].setUnit(new Unit(Rank.PAWN, Color.black));
        map[7][4].setUnit(new Unit(Rank.BISHOP, Color.black));
        map[7][5].setUnit(new Unit(Rank.PAWN, Color.black));
        map[0][4].setUnit(new Unit(Rank.KNIGHT, Color.blue));
        map[0][5].setUnit(new Unit(Rank.QUEEN, Color.blue));
        map[0][6].setUnit(new Unit(Rank.KNIGHT, Color.blue));
        map[0][7].setUnit(new Unit(Rank.KING, Color.blue));
        map[0][8].setUnit(new Unit(Rank.KNIGHT, Color.blue));
        map[1][3].setUnit(new Unit(Rank.PAWN, Color.blue));
        map[1][4].setUnit(new Unit(Rank.BISHOP, Color.blue));
        map[1][5].setUnit(new Unit(Rank.PAWN, Color.blue));
        map[1][6].setUnit(new Unit(Rank.PAWN, Color.blue));
        map[1][7].setUnit(new Unit(Rank.BISHOP, Color.blue));
        map[1][8].setUnit(new Unit(Rank.PAWN, Color.blue));
    }

    public Dimension getPreferredSize() {
        return new Dimension(1000, 800);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Tile[] arr : map) {
            for(Tile hex : arr) {
                if(hex != null) {
                    hex.draw(g, 500, 400, 30);
                }
            }
        }
    }

    public void attemptMove(String move) {
        if(move == null) {
            throw new IllegalArgumentException("Input was null");
        }
        String[] parts = move.split(",");
        if(parts[0].length() != 4) {
            throw new IllegalArgumentException("Improper chess move for move " + move);
        }
        char[] sourceDest = parts[0].toCharArray();
        int[] moves = new int[4];
        moves[0] = sourceDest[0] - 'a'; //source q
        moves[1] = '9' - sourceDest[1]; //r
        moves[2] = sourceDest[2] - 'a'; //dest q
        moves[3] = '9' - sourceDest[3]; //r
        int dq = moves[2] - moves[0];
        int dr = moves[3] - moves[1];
        //check source and dest are in-bounds
        for(int coord : moves) {
            if(coord > 8 || coord < 0) {
                throw new IllegalArgumentException("Chess destination or source out of bounds for move " + move);
            }
        }
        //use checkMove to check if it's a valid move
        Tile t = map[moves[1]][moves[0]];
        Unit piece = t.getUnit();
        if(piece == null) {
            throw new IllegalArgumentException("No piece in specified area!");
        }
        if(!piece.validMove(dq, dr)) {
            throw new IllegalArgumentException("Invalid move for piece " + piece.toString() + " at source of " + move);
        }
        //check captures
        Unit target = map[moves[3]][moves[2]].getUnit();
        if(target != null) {
            if(target.color == piece.color) {
                throw new IllegalArgumentException("Destination is occupied!");
            } else {
                System.out.println("capture happened!");
            }
        }
        //do the move
        map[moves[3]][moves[2]].setUnit(piece);
        map[moves[1]][moves[0]].setUnit(null);
    }
}