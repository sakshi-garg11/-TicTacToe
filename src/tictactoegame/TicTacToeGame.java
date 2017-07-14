/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sakshi
 */
public class TicTacToeGame extends Application {
    Button btn1 = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button btn4 = new Button();
    Button btn5 = new Button();
    Button btn6 = new Button();
    Button btn7 = new Button();
    Button btn8 = new Button();
    Button btn9 = new Button();
    @Override
    public void start(Stage primaryStage) {
        
        btn1.setText("");
        btn1.setOnAction(event->{
            playGame(1,btn1);
        });
        
        
        btn2.setText("");
        btn2.setOnAction(event->{
            playGame(2,btn2);
        });
        
        
        btn3.setText("");
        btn3.setOnAction(event->{
            playGame(3,btn3);
        });
        
        
        btn4.setText("");
        btn4.setOnAction(event->{
            playGame(4,btn4);
        });
        
        
        btn5.setText("");
        btn5.setOnAction(event->{
            playGame(5,btn5);
        });
        
       
        btn6.setText("");
        btn6.setOnAction(event->{
            playGame(6,btn6);
        });
        
        
        btn7.setText("");
        btn7.setOnAction(event->{
            playGame(7,btn7);
        });
        
        
        btn8.setText("");
        btn8.setOnAction(event->{
            playGame(8,btn8);
        });
        
        
        btn9.setText("");
        btn9.setOnAction(event->{
            playGame(9,btn9);
        });
        
        GridPane grid=new GridPane();
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        grid.add(btn1, 0, 0);
        grid.add(btn2, 1, 0);
        grid.add(btn3, 2, 0);
        grid.add(btn4, 0, 1);
        grid.add(btn5, 1, 1);
        grid.add(btn6, 2, 1);
        grid.add(btn7, 0, 2);
        grid.add(btn8, 1, 2);
        grid.add(btn9, 2, 2);
        
        
        
        
        
        
        Scene scene = new Scene(grid, 400, 400);
        scene.getStylesheets().
                add(TicTacToeGame.class.
                    getResource("style.css").
                        toExternalForm());
        
            primaryStage.setTitle("Tic Tac Toe Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        }
        
        ArrayList<Integer> Player1=new ArrayList<Integer>(); 
        ArrayList<Integer> Player2=new ArrayList<Integer>();
        
        int ActivePlayer=1;
        void playGame(int cellID, Button Selectedbtn){
        System.out.println("CellID:"+ cellID);
        
        if(ActivePlayer==1){
            Player1.add(cellID);
            Selectedbtn.setText("X");
            ActivePlayer=2;
            AutoPlayer();
            
        }
        else if(ActivePlayer==2){
            Player2.add(cellID);
            Selectedbtn.setText("O");
            ActivePlayer=1;
        }
        
        Selectedbtn.setDisable(true);
        
        CheckWinner();
    }
        void CheckWinner()
        {
            int Winner=-1;
            if(Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
                Winner=1;
            }
            if(Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
                Winner=2;
            }
            if(Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
                Winner=1;
            }
            if(Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){
                Winner=2;
            }
            if(Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
                Winner=1;
            } 
            if(Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
                Winner=2;
            }
            if(Player1.contains(1) && Player1.contains(5) && Player1.contains(9)){
                Winner=1;
            } 
            if(Player2.contains(1) && Player2.contains(5) && Player2.contains(9)){
                Winner=2;
            }
            if(Player1.contains(3) && Player1.contains(5) && Player1.contains(7)){
                Winner=1;
            } 
            if(Player2.contains(3) && Player2.contains(5) && Player2.contains(7)){
                Winner=2;
            }
            if(Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
                Winner=1;
            } 
            if(Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
                Winner=2;
            }
            if(Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){
                Winner=1;
            } 
            if(Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){
                Winner=2;
            }
            if(Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){
                Winner=1;
            } 
            if(Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
                Winner=2;
            }
            if((Player1.contains(1)|| Player2.contains(1)) && (Player1.contains(12)|| Player2.contains(2))&& (Player1.contains(3)|| Player2.contains(3))
                && (Player1.contains(4)|| Player2.contains(4)) && (Player1.contains(5)|| Player2.contains(5)) 
                    && (Player1.contains(6)|| Player2.contains(6))&& (Player1.contains(7)|| Player2.contains(7)) && (Player1.contains(8)|| Player2.contains(8))
                    && (Player1.contains(9)|| Player2.contains(9))){
                Winner=3;
            }
            
            
            
            //show winner message
            if(Winner!=-1){
            String msg="";
            if(Winner==1){
             msg="Player 1 is the winner";
            }
            if(Winner==2){
            msg="Player 2 is the winner";
            }
            if(Winner==3){
            msg="Nobody Wins";
            }
            
            
            
            
            //alert msg
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Information");
            alert.setContentText(msg);
            alert.setHeaderText("Playing Information");
            alert.show();
           }
//            else{
//                String msg1="Nobody Won";
//            
//            Alert alert1=new Alert(Alert.AlertType.INFORMATION);
//            alert1.setTitle("Game Information");
//            alert1.setContentText(msg1);
//            alert1.setHeaderText("Playing Information");
//            alert1.show();
//            }
             
        }
        void AutoPlayer(){
            ArrayList<Integer> EmptyCell=new ArrayList<Integer>();
            
             for (int cell = 0; cell < 10; cell++) {
                
                if( !(Player1.contains(cell) || Player2.contains(cell)) ){
                  EmptyCell.add(cell);
                }
                
            }
           Random r=new Random();
           int RandIndex=r.nextInt(EmptyCell.size()-0)+0;
           int cell=EmptyCell.get(RandIndex);
           Button selectedButton;
           switch(cell){
               case 1:
                   selectedButton=btn1;
                   break;
               case 2:
                   selectedButton=btn2;
                   break;
               case 3:
                   selectedButton=btn3;
                   break;
               case 4:
                   selectedButton=btn4;
                   break;
               case 5:
                   selectedButton=btn5;
                   break;
               case 6:
                   selectedButton=btn6;
                   break;
               case 7:
                   selectedButton=btn7;
                   break;
               case 8:
                   selectedButton=btn8;
                   break;
               case 9:
                   selectedButton=btn9;
                   break;
               default:
                   selectedButton=btn1;
           }
          
           playGame(cell, selectedButton);
        }
        
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    } 
}
