package flyweight;

public abstract class ChessPiece {
    String name;
    int numberPosition;
    char letterPosition;
    Color color;

    public ChessPiece(String name, int numberPosition, char letterPosition, boolean isWhite) {
        this.name = name;
        this.numberPosition = numberPosition;
        this.letterPosition = letterPosition;
        this.color = (isWhite) ? ColorRepository.getWhite() : ColorRepository.getBlack();
    }

    public static void main(String[] args) {
        WhitePawn whitePawn1 = new WhitePawn(7, 'a');
        BlackPawn blackPawn1 = new BlackPawn(2, 'a');
        WhiteKing whiteKing = new WhiteKing();

        System.out.println(whiteKing.color==whitePawn1.color);
    }
}
