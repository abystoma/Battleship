package battleship;

import java.util.*;


public class GameField {
    protected Scanner sc = new Scanner(System.in);
    protected String[][] boardField;
    protected Input input;
    protected int player;

    public GameField(int player) {
        this.boardField = new String[11][11];
        this.input = null;
        this.player = player;
    }
    public String callPlayer() {
        return String.format("Player %d, place your ships on the game field", this.player);
    }
    public int getPlayer(int n) {
        return this.player;
    }
    public void play() {
        // Write your code here
        printField();

        for (Arsenal status : Arsenal.values()) {
            switch (status) {
                case AIRCRAFT:
                    prompt(input, status);
                    break;
                case BATTLESHIP:
                    prompt(input, status);                    
                    break;
                case SUBMARINE:
                    prompt(input, status);                    
                    break;                    
                case CRUISER:
                    prompt(input, status);                    
                    break;
                case DESTROYER:
                    prompt(input, status);                    
                    break;
                default:
                    System.out.println("Unsupported enum constant.");
            }

        }

    }

    public void prompt(Input input, Arsenal status) {
        boolean check = false;
        while (!check) {
            System.out.println(String.format("Enter the coordinates of the %s (%d cells): %n",status.getName(), status.getSize()));

            input = getCoordinates();
          

            if (input.startY == input.endY) {

                if (Math.max(input.startX, input.endX) - Math.min(input.startX, input.endX) + 1 != status.getSize()) {
                    System.out.println(String.format("Error! Wrong length of the %s! Try again: ", status.getName()));
                    continue;
                }  
                boolean close = isTooClose(boardField, input.startY - 65 + 1, input.startX, input.endY - 65 + 1, input.endX); 
                if(close) {
                    continue;
                } 
            } else if (input.startX == input.endX){

                if (Math.max(input.startY - 65 + 1, input.endY - 65 + 1) - Math.min(input.startY - 65 + 1, input.endY - 65 + 1) + 1 != status.getSize()) {
                    System.out.println(String.format("Error! Wrong length of the %s! Try again: %n", status.getName()));
                    continue;
                }  
                boolean close = isTooClose(boardField, input.startY - 65 + 1, input.startX, input.endY - 65 + 1, input.endX); 
                if(close) {
                    continue;
                }           
            } else {
                System.out.println("Error! Wrong ship location! Try again: \n");
                continue;
            }

            initialize(input);                
            break;
        }
        printField();        
    }

    public Input getCoordinates() {
        // return input details from the method
        String[] coordinates = sc.nextLine().split(" ");

        int startY = coordinates[0].charAt(0);
        int startX = coordinates[0].length() > 2 ? Integer.valueOf(coordinates[0].split("")[1] + coordinates[0].split("")[2]) : Integer.valueOf(coordinates[0].split("")[1]);
        int endY = coordinates[1].charAt(0);
        int endX = coordinates[1].length() > 2 ? Integer.valueOf(coordinates[1].split("")[1] + coordinates[1].split("")[2]) : Integer.valueOf(coordinates[1].split("")[1]);
 
        return new Input(startY, startX, endY, endX);
    }



    public void initialize(Input input) {
        

        // System.out.println(input.startY);
        // System.out.println(input.startX);
        // System.out.println(input.endY);
        // System.out.println(input.endX);

        if (input.startY == input.endY) {
            if (input.startX > input.endX) {
                for (int i = input.endX; i <= input.startX; i++) {
                    boardField[input.startY - 65 + 1][i] = "O ";
                    // System.out.println(input.startY - 65 + 1);
                    // System.out.println(i);
                } 
            } else {
                    for (int i = input.startX; i <= input.endX; i++) {
                        boardField[input.startY - 65 + 1][i] = "O ";
                        // System.out.println(input.startY - 65 + 1);
                        // System.out.println(i);

                }
            }        
        } else if (input.startX == input.endX) {
            if (input.startY > input.endY) {
                for (int i = input.endY; i <= input.startY; i++) {
                    boardField[i - 65 + 1][input.startX] = "O ";
                }
            } else {
                for (int i = input.startY; i <= input.endY; i++) {
                    boardField[i - 65 + 1][input.startX] = "O ";
                }
            }
        }
    }

    public boolean isTooClose(String[][] board, int startY, int startX, int endY, int endX) {
        // check that the new position is not next to any ship already set

        int beginRow;
        int endRow;
        int beginColumn;
        int endColumn;

        if (startY >= endY) {
            beginRow = endY;
            endRow = startY;
        } else {
            beginRow = startY;
            endRow = endY;           
        }

        if (startX >= endX) {
            beginColumn = endX;
            endColumn = startX;
        } else {
            beginColumn = startX;
            endColumn = endX;            
        }
        // System.out.println(beginRow);
        // System.out.println(beginColumn);
        // System.out.println(endRow);
        // System.out.println(endColumn);
        int upsideRow = beginRow > 1 ? beginRow - 1 : 1;
        int undersideRow = endRow < 10 ? endRow + 1 : 10;
        int leftSideColumn = beginColumn > 1 ? beginColumn - 1 : 1;
        int rightSideColumn = endColumn < 10 ? endColumn + 1 : 10;
        
        // System.out.println(upsideRow);
        // System.out.println(leftSideColumn);
        // System.out.println(undersideRow);
        // System.out.println(rightSideColumn);

        for (int i = upsideRow; i <= undersideRow; i++) {
            for (int j = leftSideColumn; j <= rightSideColumn; j++) {
                if (board[i][j].equals("O ")) {
                    System.out.println("Error! You placed it too close to another one. Try again: \n");
                    return true;
                }
            }
        }
        
        return false;
    }

    public void generateBoard() {
        char x = 'A';
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (j == 0 && i == 0) {
                    boardField[i][j] = "  ";
                } else if (i == 0) {
                    boardField[i][j] = String.valueOf(j + " ");
                } else if (j == 0) {
                    boardField[i][j] = String.valueOf(x++ + " ");
                } else {
                    boardField[i][j] = "~ ";
                }
            }
        }
    }

    public void printField() {
        System.out.println();
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                System.out.print(boardField[i][j]);
            }
            System.out.println();
        }
    System.out.println();
    }

    public void launchAttack() {
    
    }
    public void fogOfWar() {

               
    }



}
