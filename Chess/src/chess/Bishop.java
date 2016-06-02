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
public class Bishop extends Figure{
    
    public Bishop(String name, int color, int x, int y) {
        super(name, color, x, y);
    }
    
    @Override
            
    void checkMove(int x, int y) {
       stepSarray = new int[8][8];
       
       while (!checkEat(x+1, y+1)){
            if ((x<8)&&(y<8)){
                setStepArray(x+1, y+1, 1);
                x++;
                y++;
            } 
        }
       
       //check figure color and mark it
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
        //check figure color and mark it
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
          //check figure color and mark it
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
          //check figure color and mark it
       markEatFigure(x-1, y+1);
    }
     /*@Override
    Boolean checkGo(int x, int y) {
       //move(x,y);

//        setStepArray(2, 3, 3);
        printArrayMove();
        System.out.println("steps Array"+getStepArray(3, 2));
        
        if (getStepArray(x, y)==1) {
            System.out.println("OK move");
            return true;
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // check all  move */
    
}
