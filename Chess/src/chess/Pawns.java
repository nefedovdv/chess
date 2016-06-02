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
public class Pawns extends Figure{
    
    public Pawns(String name, int color, int x, int y) {
        super(name, color, x, y);
    }
    

    @Override
    void checkMove(int x, int y) {
       stepSarray = new int[8][8];
       if (getColor()==1){
            if (!checkEat(x, y+1)) setStepArray(x, y+1, 1);
            if ((y==1)&&(!checkEat(x, y+2))&&(!checkEat(x, y+1))) setStepArray(x, y+2, 1);
            
        }
        //check black
        if (getColor()==2){
            if (!checkEat(x, y-1)) setStepArray(x, y-1, 1);
            if ((y==6)&&(!checkEat(x, y-2))&&(!checkEat(x, y-1))) setStepArray(x, y-2, 1);        
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*
    @Override
    Boolean checkGo (int x, int y){
        
        
        
        //check white 
        if (getColor()){
            if (((getY()+1)==y)&&(getX()==x)&&(!checkEat(x, y))) return true;
                    else if (((((getY()+1)==y)&&((getX()+1)==x))||(((getY()+1)==y)&&((getX()-1)==x)))&&checkEat(x, y)) return true;
                    else if ((getY()==1)&&(getY()+2==y)&&(getX()==x)) return true;
                                
        }
        //check black
        if (!getColor()){
            if (((getY()-1)==y)&&(getX()==x)&&(!checkEat(x, y))) return true;
                    else if (((((getY()-1)==y)&&((getX()-1)==x))||(((getY()-1)==y)&&((getX()+1)==x)))&&checkEat(x, y)) return true;
                    else if ((getY()==6)&&(getY()-2==y)&&(getX()==x)) return true;            
        }
        
        
        
        return false; 
    }*/
    
    
}
