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
public class Queen extends Figure{
    
    public Queen(String name, int color, int x, int y) {
        super(name, color, x, y);
    }

    
    @Override
    void checkMove(int x, int y) {
        stepSarray = new int[8][8];
       
       while (!checkEat(x+1, y+1)){
            if ((x<8)&&(y<8)){
                System.err.println("1 "+(x+1)+(y+1));
                setStepArray(x+1, y+1, 1);
                x++;
                y++;
            } 
        }
       markEatFigure(x+1, y+1);
        x= getX();
        y = getY();
        while (!checkEat(x+1, y-1)){
            if ((x<8)&&(y>=0)){
                setStepArray(x+1, y-1, 1);
                x++;
                y--;
            } 
        }
        markEatFigure(x+1, y-1);
        x= getX();
        y = getY();
          
          while (!checkEat(x-1, y-1)){
            if ((y>=0)&&(x>=0)){
                setStepArray(x-1, y-1, 1);
                x--;
                y--;
            } 
        }
          markEatFigure(x-1, y-1);
        x= getX();
        y = getY();
        
          while (!checkEat(x-1, y+1)){
            if ((x>=0)&&(y<8)){
                setStepArray(x-1, y+1, 1);
                x--;
                y++;
            } 
        }
          markEatFigure(x-1, y+1);
          x= getX();
        y = getY();
        while (!checkEat(x+1, y)){
            if (x<8){
                //System.err.println("1 "+(x+1)+(y+1));
                setStepArray(x+1, y, 1);
                x++;
            } 
        }
        markEatFigure(x+1, y);
        x= getX();
        y = getY();
        while (!checkEat(x-1,y)){
            if (x>=0){
                setStepArray(x-1, y, 1);
                x--;
            } 
        }
        markEatFigure(x-1, y);
        x= getX();
        y = getY();
          
          while (!checkEat(x, y-1)){
            if (y>=0){
                setStepArray(x, y-1, 1);
                y--;
            } 
        }
          markEatFigure(x, y-1);
        x= getX();
        y = getY();
        
          while (!checkEat(x, y+1)){
            if (y<8){
                setStepArray(x, y+1, 1);
                y++;
            } 
        }
          markEatFigure(x, y+1);
    }
    
}
