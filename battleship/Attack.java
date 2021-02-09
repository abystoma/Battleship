package battleship;

public class Attack extends GameField {
    public String[][] boardField;
    public int row;
    public int col;
    public Attack(String[][] boardField, int player) {
        super(player);
        this.boardField = boardField;
        this.row = 0;
        this.col = 0;        
    }

    @Override
    public void printField() {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                System.out.print(boardField[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void launchAttack() {
        
        System.out.printf("Player %d, it's your turn:%n", this.player);

        //System.out.println("Take a shot!");

            if (gameOver()) {
                System.out.println("You sank the last ship. You won. Congratulations!");
            }   
            String launch = sc.next();
    
            int row = launch.charAt(0) - 65 + 1;
            int col = launch.length() > 2 ? Integer.parseInt(launch.split("")[1] + launch.split("")[2]) : Integer.parseInt(launch.split("")[1]);
            try {
                if (boardField[row][col].equals("O ")) {
                    boardField[row][col] = "X ";
                    //fogOfWar();
                    boolean sunk = shipSunk(row, col);
                    String res = sunk == true ? "You sank a ship! Specify a new target: " :  "You hit a ship!";
                    System.out.println(res);
                  
                    //printField();   
                } else if (boardField[row][col].equals("~ ")){
                    boardField[row][col] = "M ";
                    //fogOfWar();
                    System.out.println("You missed!");
                    
                } else {
                    System.out.println("You shot there before!");
                    //fogOfWar();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
        


    }

    @Override
    public void fogOfWar() {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {

                if (boardField[i][j].equals("O ")) {
                    System.out.print("~ ");
                } else {
                    System.out.print(boardField[i][j]);
                }
            }
            System.out.println();
        }
    }

    public boolean shipSunk(int row, int col) {
        int upsideRow = row > 1 ? row - 1 : 1;
        int undersideRow = row < 10 ? row + 1 : 10;
        int leftSideColumn = col > 1 ? col - 1 : 1;
        int rightSideColumn = col < 10 ? col + 1 : 10;
        
        // System.out.println(upsideRow);
        // System.out.println(leftSideColumn);
        // System.out.println(undersideRow);
        // System.out.println(rightSideColumn);

        for (int i = upsideRow; i <= undersideRow; i++) {
            for (int j = leftSideColumn; j <= rightSideColumn; j++) {
                if (boardField[i][j].equals("O ")) {
                    return false;
                }
            }
        }
        
        return true;
    } 
    
    public boolean gameOver() {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (boardField[i][j].equals("O ")) {
                    return false;
                }                
            }
        }
        System.out.println("You sank the last ship. You won. Congratulations!");

        return true;
           
    } 
}
