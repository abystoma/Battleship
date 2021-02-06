package battleship;

import java.util.*;
final class Input
{
    public int startY;
    public int startX;
    public int endY;
    public int endX;

    public Input(int startY, int startX, int endY, int endX) {
        this.startY = startY;
        this.startX = startX;
        this.endY = endY;
        this.endX = endX;

    }
}


class Main {
    static Scanner sc = new Scanner(System.in);
    enum Arsenal {
        AIRCRAFT , BATTLESHIP , SUBMARINE, CRUISER, DESTROYER // five instances
    }
    public static void main(String[] args) {
        // Write your code here
        String[][] boardField = new String[11][11];

        generateBoard(boardField);
        printField(boardField);
        Input input;
        for (Arsenal status : Arsenal.values()) {
            boolean check = false;
            switch (status) {
                case AIRCRAFT:
                    while (!check) {
                        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells): ");

                        input = getCoordinates();
    
                        if (input.startY == input.startY) {
                            if (Math.max(input.startX, input.endX) - Math.min(input.startX, input.endX) + 1 != 5) {
                                System.out.println("Error! Wrong length of the Aircraft Carrier! Try again: ");
                                continue;
                            }  
                            boolean close = isTooClose(boardField, input.startY - 65 + 1, input.startX, input.endY - 65 + 1, input.endX); 
                            if(close) {
                                continue;
                            } 
                        } else if (input.startX == input.endX ){
                            if (Math.max(input.startY - 65 + 1, input.endY - 65 + 1) - Math.min(input.startY - 65 + 1, input.endY - 65 + 1) + 1 != 5) {
                                System.out.println("Error! Wrong length of the Aircraft Carrier! Try again: ");
                                continue;
                            }  
                            boolean close = isTooClose(boardField, input.startY - 65 + 1, input.startX, input.endY - 65 + 1, input.endX); 
                            if(close) {
                                continue;
                            }           
                        } else {
                            System.out.println("Error! Wrong ship location! Try again: ");
                            continue;
                        }

                        play(boardField, input);                
                        break;
                    }
                    break;

                  
                    

                case BATTLESHIP:
                    while (!check) {
                        System.out.println("Enter the coordinates of the Battleship (4 cells): ");
                        input = getCoordinates();
                        if (input.startY == input.endY) {
                            
                            if (Math.max(input.startX, input.endX) - Math.min(input.startX, input.endX) + 1 != 4) {
                                System.out.println("Error! Wrong length of the Battleship! Try again: ");
                                continue;
                            } 
                            boolean close = isTooClose(boardField, input.startY - 65 + 1, input.startX, input.endY - 65 + 1, input.endX); 
                            if(close) {
                                continue;
                            } 
                        } else if (input.startX == input.endX ){
                            if (Math.max(input.startY - 65 + 1, input.endY - 65 + 1) - Math.min(input.startY - 65 + 1, input.endY - 65 + 1) + 1 != 4) {
                                System.out.println("Error! Wrong length of the Battleship! Try again: ");
                                continue;
                            }   
                            boolean close = isTooClose(boardField, input.startY - 65 + 1, input.startX, input.endY - 65 + 1, input.endX); 
                            if(close) {
                                continue;
                            }                       
                        } else {
                            System.out.println("Error! Wrong ship location! Try again: ");
                            continue;
                        }                        
                        play(boardField, input);                    
                        break;                     
                    }
                    break;

                case SUBMARINE:
                    while(!check) {
                        System.out.println("Enter the coordinates of the Submarine (3 cells): ");
                        input = getCoordinates();
                        if (input.startY == input.endY) {
    
                            if (Math.max(input.startX, input.endX) - Math.min(input.startX, input.endX) + 1 != 3) {
                                System.out.println("Error! Wrong length of the Submarine! Try again: ");
                                continue;
                            } 
                            boolean close = isTooClose(boardField, input.startY - 65 + 1, input.startX, input.endY - 65 + 1, input.endX); 
                            if(close) {
                                continue;
                            } 
                        } else if (input.startX == input.endX ){
                            if (Math.max(input.startY - 65 + 1, input.endY - 65 + 1) - Math.min(input.startY - 65 + 1, input.endY - 65 + 1) + 1 != 3) {
                                System.out.println("Error! Wrong length of the Submarine! Try again: ");
                                continue;
                            } 
                            boolean close = isTooClose(boardField, input.startY - 65 + 1, input.startX, input.endY - 65 + 1, input.endX); 
                            if(close) {
                                continue;
                            }                      
                        } else {
                            System.out.println("Error! Wrong ship location! Try again: ");
                            continue;
                        }                        
                        play(boardField, input);                                   
                        break;
                    }
                    break;
                    
                case CRUISER:
                    while (!check) {
                        System.out.println("Enter the coordinates of the Cruiser (3 cells): ");
                        input = getCoordinates();
                        if (input.startY == input.endY) {
    
                            if (Math.max(input.startX, input.endX) - Math.min(input.startX, input.endX) + 1 != 3) {
                                System.out.println("Error! Wrong length of the Cruiser! Try again: ");
                            }
                            boolean close = isTooClose(boardField, input.startY - 65 + 1, input.startX, input.endY - 65 + 1, input.endX); 
                            if(close) {
                                continue;
                            } 
                        } else if (input.startX == input.endX ){
                            if (Math.max(input.startY - 65 + 1, input.endY - 65 + 1) - Math.min(input.startY - 65 + 1, input.endY - 65 + 1) + 1 != 3) {
                                System.out.println("Error! Wrong length of the Cruiser! Try again: ");
                                continue;
                            }  
                            boolean close = isTooClose(boardField, input.startY - 65 + 1, input.startX, input.endY - 65 + 1, input.endX); 
                            if(close) {
                                continue;
                            }             
                        } else {
                            System.out.println("Error! Wrong ship location! Try again: ");
                            continue;
                        }                        
                        play(boardField, input);                    
                        break;
                    }
                    break;

                case DESTROYER:
                    while (!check) {
                        System.out.println("Enter the coordinates of the Destroyer (2 cells): ");
                        input = getCoordinates();
                        if (input.startY == input.endY) {
    
                            if (Math.max(input.startX, input.endX) - Math.min(input.startX, input.endX) + 1 != 2) {
                                System.out.println("Error! Wrong length of the Destroyer! Try again: ");
                                continue;
                            } 
                            boolean close = isTooClose(boardField, input.startY - 65 + 1, input.startX, input.endY - 65 + 1, input.endX); 
                            if(close) {
                                continue;
                            } 
                        } else if (input.startX == input.endX ){
                            if (Math.max(input.startY - 65 + 1, input.endY - 65 + 1) - Math.min(input.startY - 65 + 1, input.endY - 65 + 1) + 1 != 2) {
                                System.out.println("Error! Wrong length of the Destroyer! Try again: ");
                                continue;
                            } 
                            boolean close = isTooClose(boardField, input.startY - 65 + 1, input.startX, input.endY - 65 + 1, input.endX); 
                            if(close) {
                                continue;
                            }  
                        } else {
                            System.out.println("Error! Wrong ship location! Try again: ");
                            continue;
                        }                        
                        play(boardField, input);                    
                        break;
                    }
                    break;

                default:
                    System.out.println("Unsupported enum constant.");
            }

        }

    }

    public static Input getCoordinates() {
        // return input details from the method
        String[] coordinates = sc.nextLine().split(" ");

        int startY = coordinates[0].charAt(0);
        int startX = coordinates[0].length() > 2 ? Integer.valueOf(coordinates[0].split("")[1] + coordinates[0].split("")[2]) : Integer.valueOf(coordinates[0].split("")[1]);
        int endY = coordinates[1].charAt(0);
        int endX = coordinates[1].length() > 2 ? Integer.valueOf(coordinates[1].split("")[1] + coordinates[1].split("")[2]) : Integer.valueOf(coordinates[1].split("")[1]);
 
        return new Input(startY, startX, endY, endX);
    }



    public static void play(String[][] board, Input input) {
        

        // System.out.println(input.startY);
        // System.out.println(input.startX);
        // System.out.println(input.endY);
        // System.out.println(input.endX);

        if (input.startY == input.endY) {
            if (input.startX > input.endX) {
                for (int i = input.endX; i <= input.startX; i++) {
                    board[input.startY - 65 + 1][i] = "O ";
                    // System.out.println(input.startY - 65 + 1);
                    // System.out.println(i);
                } 
            } else {
                    for (int i = input.startX; i <= input.endX; i++) {
                        board[input.startY - 65 + 1][i] = "O ";
                        // System.out.println(input.startY - 65 + 1);
                        // System.out.println(i);

                }
            }        

        } else if (input.startX == input.endX) {
            for (int i = input.startY; i <= input.endY; i++) {
                board[i - 65 + 1][input.startX] = "O ";
            }
        }
        printField(board);
    }
    public static boolean isTooClose(String[][] board, int startY, int startX, int endY, int endX) {
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
                    System.out.println("Error! You placed it too close to another one. Try again: ");
                    return true;
                }
            }
        }
        
        return false;
    }

    public static void generateBoard(String[][] board) {
        char x = 'A';
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (j == 0 && i == 0) {
                    board[i][j] = "  ";
                } else if (i == 0) {
                    board[i][j] = String.valueOf(j + " ");
                } else if (j == 0) {
                    board[i][j] = String.valueOf(x++ + " ");
                } else {
                    board[i][j] = "~ ";
                }
            }
        }
    }

    public static void printField(String[][] board) {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
