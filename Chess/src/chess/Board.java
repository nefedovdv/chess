/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author ndv
 */
public class Board {
    static Figure [][] arrayChes = new Figure[8][8];
    
    
    Figure getFigure(int x, int y){
        if (arrayChes[x][y].getColor()!=0) return arrayChes[x][y];
        return null;
    }
    
    
    
    void setFigure (int x, int y, Figure figure){
        figure.setX(x);
        figure.setY(y);
        System.out.println("setFigure "+figure.getName());
        arrayChes[x][y] = figure;
    }
    
    void run(){
        initClearSpace();
        initFigureBishop();
        initFigureKing();
        initFigureKnights();
        initFigurePawns();
        initFigureQueen();
        initFigureRooks();
    }
    
    void initClearSpace (){
        for (int x=0; x<8; x++){
            for (int y=0; y<8; y++){
                arrayChes[x][y]= new Figure("X", 0, x, y) {
                    @Override
                    Boolean checkGo(int x, int y) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    void checkMove(int x, int y) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
                
            }
        }
    }
    
    // add pieces on board
    void initFigurePawns(){
        for (int x=0; x<8; x++)        {
            arrayChes[x][1]= new Pawns("Pawns", 1, x, 1);
            arrayChes[x][6]= new Pawns("Pawns", 2, x, 6);
            
            
        }
    }
    
    // add bishop on board
    void initFigureBishop(){
        arrayChes[2][0]= new Bishop("Bishop", 1, 2, 0);
        arrayChes[5][0]= new Bishop("Bishop", 1, 5, 0);
        arrayChes[2][7]= new Bishop("Bishop", 2, 2, 7);
        arrayChes[5][7]= new Bishop("Bishop", 2, 5, 7);

        //arrayChes[2][2]= new Bishop("Bishop", 2, 2, 2);
    }
    
     // add king on board
    void initFigureKing(){
        arrayChes[4][0]= new King("King", 1, 4, 0);
        arrayChes[4][7]= new King("King", 2, 4, 7);
    }
    
    
     // add knights on board
    void initFigureKnights(){
        arrayChes[1][0]= new Knights("Knights", 1, 1, 0);
        arrayChes[6][0]= new Knights("Knights", 1, 6, 0);
        arrayChes[1][7]= new Knights("Knights", 2, 1, 7);
        arrayChes[6][7]= new Knights("Knights", 2, 6, 7);
    }
    
     // add Queen on board
    void initFigureQueen(){
        arrayChes[3][0]= new Queen("Queen", 1, 3, 0);
        arrayChes[3][7]= new Queen("Queen", 2, 3, 7);
        
        //arrayChes[3][3]= new Queen("Quin", 2, 3, 3);
    }
    
 // add Rooks on board
    void initFigureRooks(){
        arrayChes[0][0]= new Rooks("Rooks", 1, 0, 0);
        arrayChes[7][0]= new Rooks("Rooks", 1, 7, 0);
        arrayChes[0][7]= new Rooks("Rooks", 2, 0, 7);
        arrayChes[7][7]= new Rooks("Rooks", 2, 7, 7);
        
    }
}
