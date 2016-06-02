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
public class King extends Figure{
    
    public King(String name, int color, int x, int y) {
        super(name, color, x, y);
    }

    @Override
    void checkMove(int x, int y) {
        stepSarray = new int[8][8];
        if (!checkEat(x+1, y)) setStepArray(x+1, y, 1);
        markEatFigure(x+1, y);
        if (!checkEat(x-1, y)) setStepArray(x-1, y, 1);
        markEatFigure(x-1, y);
        if (!checkEat(x+1, y+1)) setStepArray(x+1, y+1, 1);
        markEatFigure(x+1, y+1);
        if (!checkEat(x-1, y-1)) setStepArray(x-1, y-1, 1);
        markEatFigure(x-1, y-1);
        if (!checkEat(x, y+1)) setStepArray(x, y+1, 1);
        markEatFigure(x, y+1);
        if (!checkEat(x, y-1)) setStepArray(x, y-1, 1);
        markEatFigure(x, y-1);
        if (!checkEat(x-1, y+1)) setStepArray(x-1, y+1, 1);
        markEatFigure(x-1, y+1);
        if (!checkEat(x+1, y-1)) setStepArray(x+1, y-1, 1);
        markEatFigure(x+1, y-1);
    }
    
}
