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
public class ManageChess extends GameBoard {
    Boolean isItFigure = false;

    public ManageChess() {
        
    }
    
    Figure takeFigure(String textXY){
        return getFigure(splitStringX(textXY),splitStringY(textXY));
        
    }
    
    //  x-->x2
    void moveFigure(int x, int y, int x2, int y2){
        Figure tmp;
        tmp= arrayChes[x][y];
        //clear 
        System.out.println("chess.ManageChess.moveFigure() XY "+x+y);
        System.out.println("chess.ManageChess.moveFigure() X2Y2 "+x2+y2);
        System.out.println("chess.ManageChess.moveFigure() fact xy-"+arrayChes[x][y].getName()+" x2y2-"+arrayChes[x2][y2].getName());
        arrayChes[x][y]= arrayChes[x2][y2];
        arrayChes[x][y].setX(x);
        arrayChes[x][y].setY(y);
        arrayChes[x][y].setName("X");
        arrayChes[x][y].setColor(0);
        
        
        arrayChes[x2][y2] = tmp;
        arrayChes[x2][y2].setX(x2);
        arrayChes[x2][y2].setY(y2);
        
        
    }
    
    
    void moveFigureFromColor(Figure figure, int x, int y){
        if ((figure!=null)&&(figure.checkGo(x, y)))  {
            moveFigure(figure.getX(), figure.getY(), x, y);
            clearBoard();
            //figure = null;
            move = false;
        }
    }
    
    void takeFigureFromColor (boolean white, Figure figure, int x, int y){
        int color;
        if (white) color = 1;
                else color = 2;
        
        if ((figure!=null)&&(figure.color==color)) {
            System.out.println("chess.ManageChess.moveFigureFromColor()");
            //clicked = mgc.takeFigure(me.getComponent().getName());
            figure.checkMove(x, y);
            checkMoveOnPanel(figure);
        }
                
    }
        
    
    
}
