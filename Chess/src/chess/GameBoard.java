/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ndv
 */
import java.awt.event.MouseListener;
public class GameBoard extends Board{
    JFrame frame;
    JPanel panel;
    JLabel label;
    GridLayout gl;
    boolean move=true;
            
    static JLabel[][] labels = new JLabel[8][8];
  
  void init(){
      
    frame = new JFrame();
    frame.setAlwaysOnTop(true);
    frame.setTitle("Chess");
    //frame.setBackground(Color.darkGray);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setVisible(true);
    //frame.setSize(EXIT_ON_CLOSE, EXIT_ON_CLOSE);
    panel = new JPanel(); 
    
    gl = new GridLayout(8, 8);
    panel.setLayout(gl);         
    label = new JLabel(new ImageIcon("img/black.png"));
    //label.
    fillGameBoard();  
    clearBoard();
    //panel.add(label.setLayout(gl.addLayoutComponent()));
    //panel.addMouseListener(mouse);
    panel.setBackground(Color.GRAY);
    panel.setPreferredSize(new Dimension(500,500));
    frame.add(panel);
    frame.pack();
    
    
    
  }
  
  void clearBoard(){
        for (int yy=7;yy>=0;yy--){
            for (int xx=0;xx<8; xx++){
                if (arrayChes[xx][yy].color ==1){
                    labels[xx][yy].setText(arrayChes[xx][yy].getName());
                    labels[xx][yy].setForeground(Color.WHITE);
                }
                if (arrayChes[xx][yy].color ==2){
                    labels[xx][yy].setText(arrayChes[xx][yy].getName());
                    labels[xx][yy].setForeground(Color.BLACK);
                    //labels[xx][yy].setBackground(Color.BLACK);
                    
                }
                if (arrayChes[xx][yy].color ==0){
                    labels[xx][yy].setForeground(Color.LIGHT_GRAY);
                    labels[xx][yy].setText(arrayChes[xx][yy].getName());
                }
            }
        }
        //panel.revalidate();
    }
  
  int splitStringX(String text){
        String[] split = text.split(":");
        return Integer.parseInt(split[0]);
  }
  int splitStringY(String text){
        String[] split = text.split(":");
        return Integer.parseInt(split[1]);
  }
  
  void checkMoveOnPanel(Figure figure){
      for (int yy=7;yy>=0;yy--){
            for (int xx=0;xx<8; xx++){
                if (figure.getStepArray(xx, yy)==2){
                    labels[xx][yy].setForeground(Color.CYAN);
                    //System.out.println(labels[2][2].getName()) ;
                } 
                if (figure.getStepArray(xx, yy)==1){
                    labels[xx][yy].setText("O");
                    //System.out.println(labels[2][2].getName()) ;
                }
            }
        }
  }
  
  void fillGameBoard(){
      Mouse mouse = new Mouse();
      for (int y= 7; y>=0; y--){
          for (int x=0; x<8; x++){
              if (Board.arrayChes[x][y]!=null){
                  
                  //panel.add(new JLabel(Board.arrayChes[x][y].getName()+" "+Board.arrayChes[x][y].getColor()+" x"+x+"y"+y));
                labels[x][y]  = new JLabel(Board.arrayChes[x][y].getName()+" "+Board.arrayChes[x][y].getColor()+" x"+x+"y"+y);
                labels[x][y].addMouseListener(mouse);
                labels[x][y].setName(Board.arrayChes[x][y].getX()+":"+Board.arrayChes[x][y].getY());
                
                panel.add(labels[x][y]);
                  
              } else panel.add(new JLabel("X"));
              
          }
      }
  }
  
  
  

    class Mouse implements MouseListener{
        ManageChess mgc = new ManageChess();
        Figure clicked = null;
            int x;
            int y;
        public Mouse() {
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            
        }

        @Override
        public void mousePressed(MouseEvent me) {
            
       //     System.err.println("0-2"+arrayChes[0][2].getName()+"  "+arrayChes[0][2].getX());
            String[] split = me.getComponent().getName().split(":");
             x= Integer.parseInt(split[0]);
             y = Integer.parseInt(split[1]);  
            if (move){
                //если не пустое место и цвет - белый
                if ((mgc.takeFigure(me.getComponent().getName())!=null)&&(mgc.takeFigure(me.getComponent().getName()).color==1)) {
                    clicked = mgc.takeFigure(me.getComponent().getName());
                    clicked.checkMove(x, y);
                    mgc.checkMoveOnPanel(clicked);
                    }
                if ((clicked!=null)&&(clicked.checkGo(x, y)))  {
                    mgc.moveFigure(clicked.getX(), clicked.getY(), x, y);
                    mgc.clearBoard();
                    clicked = null;
                    move = false;
                }
                
            } else{
                if ((mgc.takeFigure(me.getComponent().getName())!=null)&&(mgc.takeFigure(me.getComponent().getName()).color==2)) {
                    clicked = mgc.takeFigure(me.getComponent().getName());
                    clicked.checkMove(x, y);
                    mgc.checkMoveOnPanel(clicked);
                    }
                if ((clicked!=null)&&(clicked.checkGo(x, y)))  {
                    mgc.moveFigure(clicked.getX(), clicked.getY(), x, y);
                    mgc.clearBoard();
                    clicked = null;
                    move = true;
                }
            }
            
            
                
            }
            
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        

        @Override
        public void mouseReleased(MouseEvent me) {
           //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent me) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
