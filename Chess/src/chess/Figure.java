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
public abstract class Figure {
    int color;  // 1 white - 2 black - 0 clear;
    String name; 
    int x;
    int y;
    int[][] stepSarray = new int [8][8];  //matrix of allowed moves

    public Figure(String name, int color, int x, int y) {
        
        this.name = name;
        this.color = color;
        this.x=x;
        this.y=y;
        
    }
    
    boolean onBoardCheck (int x,int y){
        return ((x>=0)&&(x<8)&&(y>=0)&&(y<8));
    }
    
    int getStepArray (int x, int y){
        if (onBoardCheck(x, y)) return stepSarray[x][y];
//!!!!!!!!!!!        
        return 0;
    }
   
    
    void setStepArray (int x, int y, int data){
        if (onBoardCheck(x, y)){
            stepSarray[x][y]= data;
            
        }
    }
    
    //check figure on road, true if got
    Boolean checkEat(int x,int y){
        if (onBoardCheck(x, y)) {
           //System.out.println("find figure "+!Board.arrayChes[x][y].getName().equals("clear"));
            return Board.arrayChes[x][y].getColor()!=0;
        }
        return true;
    }
    
    //check figure color and mark it
    void markEatFigure(int x,int y){
        if (checkColorToEat(x, y, getColor())){
           setStepArray(x, y, 2);   //2 - can eat
       }
        
    }
    
    boolean checkColorToEat(int x, int y, int color){
        if (checkEat(x, y)) {
            System.out.println("chess.Figure.checkColorToEat()-"+getColor());
            if ((color==1)&&(onBoardCheck(x, y))){
                if (Board.arrayChes[x][y].getColor()==2) return true;
            }
            if ((color==2)&&(onBoardCheck(x, y))){
                if (Board.arrayChes[x][y].getColor()==1) return true;
            }
        }
        return false;
    }
    
    
    //check moves 
    Boolean checkGo (int x, int y){ 
    printArrayMove();
        System.out.println("chess.Figure.checkGo() "+getStepArray(x, y));
    if ((getStepArray(x, y)==2)||(getStepArray(x, y)==1)) {
            System.out.println("OK move");
            return true;
        }
        return false;
    }
    
    
    abstract void checkMove(int x, int y); //create matrix of turn
    

    /**
     * @return the color
     */
    public int getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
       if ((x>=0)&&(x<8)) this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        if ((y>=0)&&(y<8)) this.y = y;
    }
    
      void printArrayMove(){
        
        for (int yy=7;yy>=0;yy--){
            for (int xx=0;xx<8; xx++){
                System.out.print(stepSarray[xx][yy]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
