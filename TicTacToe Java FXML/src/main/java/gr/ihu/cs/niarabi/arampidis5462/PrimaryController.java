package gr.ihu.cs.niarabi.arampidis5462;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


public class PrimaryController implements Initializable {

    Random random = new Random();
    
    ArrayList<Button> buttons;
    
    AdversarialSearchTicTacToe AI = new AdversarialSearchTicTacToe();
    
    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Text winnerText;

@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));

        buttons.forEach(button ->{
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }
    

    
    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        winnerText.setText("Tic-Tac-Toe");
        pickButton(random.nextInt(9));
    }

    public void resetButton(Button button){
        button.setDisable(false);
        button.setText("");
    }

    private void setupButton(Button button) {                       
        button.setOnMouseClicked(mouseEvent -> {
            button.setText("O");
            button.setDisable(true);
            makeAIMove();
            checkIfGameIsOver();
        });
    }
    public void makeAIMove(){
        int move = AI.minMaxDecision(getBoardState());
        pickButton(move);
    }

    public void pickButton(int index){
        buttons.get(index).setText("X");
        buttons.get(index).setDisable(true);
    }
    public State getBoardState(){
        String[] board = new String[9];
        
        for (int i=0; i<buttons.size(); i++)  {
            board[i]=buttons.get(i).getText();
            
        }  
        
        return new State(0,board);
    }

public void checkIfGameIsOver(){
            
        for (int a = 0; a < 8; a++) {
            String line;
                switch (a) {
                case 0 : 
                    line= button1.getText() + button2.getText() + button3.getText();
                    //X nikitis
                    if (line.equals("XXX")) {
                        winnerText.setText("Player X won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                    //O nikitis
                    else if (line.equals("OOO")) {
                        winnerText.setText("Player O won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                    
                case 1 :
                    line= button4.getText() + button5.getText() + button6.getText();
                    //X nikitis
                    if (line.equals("XXX")) {
                        winnerText.setText("Player X won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                    //O nikitis
                    else if (line.equals("OOO")) {
                        winnerText.setText("Player O won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }

                case 2 :
                    line= button7.getText() + button8.getText() + button9.getText();
                    //X nikitis
                    if (line.equals("XXX")) {
                        winnerText.setText("Player X won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                    //O nikitis
                    else if (line.equals("OOO")) {
                        winnerText.setText("Player O won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                case 3 :
                    line= button1.getText() + button5.getText() + button9.getText();
                    //X nikitis
                    if (line.equals("XXX")) {
                        winnerText.setText("Player X won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                    //O nikitis
                    else if (line.equals("OOO")) {
                        winnerText.setText("Player O won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                case 4 :
                    line= button3.getText() + button5.getText() + button7.getText();
                    //X nikitis
                    if (line.equals("XXX")) {
                        winnerText.setText("Player X won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                    //O nikitis
                    else if (line.equals("OOO")) {
                        winnerText.setText("Player O won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                case 5 :
                    line= button1.getText() + button4.getText() + button7.getText();
                    //X nikitis
                    if (line.equals("XXX")) {
                        winnerText.setText("Player X won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                    //O nikitis
                    else if (line.equals("OOO")) {
                        winnerText.setText("Player O won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                case 6 :
                    line= button2.getText() + button5.getText() + button8.getText();
                    //X nikitis
                    if (line.equals("XXX")) {
                        winnerText.setText("Player X won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                    //O nikitis
                    else if (line.equals("OOO")) {
                        winnerText.setText("Player O won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                case 7 :
                    line= button3.getText() + button6.getText() + button9.getText();
                    //X nikitis
                    if (line.equals("XXX")) {
                        winnerText.setText("Player X won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                    //O nikitis
                    else if (line.equals("OOO")) {
                        winnerText.setText("Player O won!");
                        buttons.forEach(button ->{
                            button.setDisable(true);
                        });
                    }
                default:
                    line= null;
            }
        }
    }

    @FXML
    void exitTicTacToe() {
        System.exit(1);
    }

}
