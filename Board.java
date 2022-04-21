import java.util.*;
//import java.awt.*;
import javax.swing.*;

public class Board {

    int i=0;
    int result;
    boolean Player1;
    String Symbol1,Symbol2,BoardState;
    JButton[] Gb = new JButton[9];
    Random random = new Random();

    public Board(){

    }

    public void begingame() {
        
    }
    public void firstPlay(){
        if (random.nextInt(2)==0){
                Player1 = true;
                //print (-player 1 name- turn in screen)
        }
        else{
            Player1 = false;
            //print (-player 2 name -turn in screen)
        }
    }
    /*public void nextPlay(){
        for(int i=0; i<9; i++){
            Gb[i].ge
        }


    }*/

    public void ResultCheck(){
        //P1 wins
        if (Gb[0].getText()==Symbol1 &&
            Gb[1].getText()==Symbol1 &&
            Gb[2].getText()==Symbol1){
                result = 1;
        }
        if (Gb[3].getText()==Symbol1 &&
            Gb[4].getText()==Symbol1 &&
            Gb[5].getText()==Symbol1){
                result = 1;
            }
        if (Gb[6].getText()==Symbol1 &&
            Gb[7].getText()==Symbol1 &&
            Gb[8].getText()==Symbol1){
                result = 1;
        }
        if (Gb[0].getText()==Symbol1 &&
            Gb[3].getText()==Symbol1 &&
            Gb[6].getText()==Symbol1){
                result = 1;
            }
        if (Gb[1].getText()==Symbol1 &&
            Gb[4].getText()==Symbol1 &&
            Gb[7].getText()==Symbol1){
                result = 1;
            }
        if (Gb[2].getText()==Symbol1 &&
            Gb[5].getText()==Symbol1 &&
            Gb[8].getText()==Symbol1){
                result = 1;
            }
        if (Gb[0].getText()==Symbol1 &&
            Gb[4].getText()==Symbol1 &&
            Gb[8].getText()==Symbol1){
                result = 1;
            }
        if (Gb[2].getText()==Symbol1 &&
            Gb[4].getText()==Symbol1 &&
            Gb[6].getText()==Symbol1){
                result = 1;
            }
 /**************************************************************** */           
        //P2 wins
        if (Gb[0].getText()==Symbol2 &&
            Gb[1].getText()==Symbol2 &&
            Gb[2].getText()==Symbol2){
                result = -1;
        }
        if (Gb[3].getText()==Symbol2 &&
            Gb[4].getText()==Symbol2 &&
            Gb[5].getText()==Symbol2){
                result = -1;
            }
        if (Gb[6].getText()==Symbol2 &&
            Gb[7].getText()==Symbol2 &&
            Gb[8].getText()==Symbol2){
                result = -1;
        }
        if (Gb[0].getText()==Symbol2 &&
            Gb[3].getText()==Symbol2 &&
            Gb[6].getText()==Symbol2){
                result = -1;
            }
        if (Gb[1].getText()==Symbol2 &&
            Gb[4].getText()==Symbol2 &&
            Gb[7].getText()==Symbol2){
                result = -1;
            }
        if (Gb[2].getText()==Symbol2 &&
            Gb[5].getText()==Symbol2 &&
            Gb[8].getText()==Symbol2){
                result = -1;
            }
        if (Gb[0].getText()==Symbol2 &&
            Gb[4].getText()==Symbol2 &&
            Gb[8].getText()==Symbol2){
                result = -1;
            }
        if (Gb[2].getText()==Symbol2 &&
            Gb[4].getText()==Symbol2 &&
            Gb[6].getText()==Symbol2){
                result = -1;
            }
        //draw
        else{
            result = 0;
        }
    }
    public void State(){
        if (result == 0 || i==9){
            BoardState = "final";
        }
    }
    public void PlayerMoving(int a){
        for (i=0; i<9; i++){
       /* if (actionSource.equals(Gb[i])){
            if (Player1==true){
                if (Gb[i].getText()==""){
                    Gb[i].setText(Symbol1);
                }
            }
        }*/
            if ((i/2)==0 && Player1==true){
                //Player 1 plays
                Gb[a].setText(Symbol1);
            }
            else if((i/2)!=0 && Player1==true){
                //Player 2 plays
                Gb[a].setText(Symbol2);
            }
            else if ((i/2)==0 && Player1==false){
                //Player 2 plays
                Gb[a].setText(Symbol2);
            }
            else{
                //Player 1 plays
                Gb[a].setText(Symbol1);
            }
        }
    }
   /* public void Result(){
        if (BoardState=="final"){
            if (PlayerMoving()!=null){
                if (result==1){
                    //Player 1 wins
                }
                else if(result==-1){
                    //Player 2 wins
                }
                else{
                    //draw
                }
            }
            else{

            }
        }
    }*/
    
}