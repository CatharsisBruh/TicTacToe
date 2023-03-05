
package gr.ihu.cs.niarabi.arampidis5462;

import java.util.ArrayList;

//algorithmos tou AI, xrisimos se paixnidia me antipalous kai prepei na sxediazoun mporsta  
public class AdversarialSearchTicTacToe {
    //algorithmos pou dialegei tin kaliteri epilogi gia tin niki
    public int minMaxDecision(State state){
        ArrayList<State> possibleMoves = successorsOf(state);
        ArrayList<Integer> movesList = new ArrayList<>();


        for (State states: possibleMoves) {
            movesList.add(minValue(states));
        }

        int max = movesList.get(0);
        int bestIndex = 0;

        for (int i = 1; i < movesList.size(); i++) {

            if( movesList.get(i) > max){
                max = movesList.get(i);
                bestIndex = i;
            }
        }
        int action = possibleMoves.get(bestIndex).getPosition();
        return action;
    }
    //Dialegei tin kaliteri epilogi gia ton X 
    private int maxValue(State state){
        if (isTerminal(state)){
            return utilityOf(state);
        }
        int v = (int) -Double.POSITIVE_INFINITY;

        for (State possibleMove: successorsOf(state)) {
            v = Math.max(v, minValue(possibleMove));
        }
        return v;
    }

    //Dialegei tin kaliteri epilogi gia ton O
    private int minValue(State state){
        if (isTerminal(state)){
            return utilityOf(state);
        }

        int v = (int) Double.POSITIVE_INFINITY;
        for (State possibleMove: successorsOf(state)) {

            v = Math.min(v, maxValue(possibleMove));
        }
        return v;
    }

    //Kanei return true an to paixnidi exei teleiosei
    public boolean isTerminal(State state) {
        int takenSpots = 0;
        for (int a = 0; a < 9; a++) {
            if(state.getStateIndex(a).equals("X") || state.getStateIndex(a).equals("O") ){
                takenSpots++;
            }

            String line = checkState(state, a);

            //Elegxei poios nikise
            if (line.equals("XXX")) {
                return true;
            } else if (line.equals("OOO")) {
                return true;
            }

            if(takenSpots == 9){
                return true;
            }
        }
        return false;
    }

    //Return +1 an X einai nikitis
    //Return -1 an O einai nikitis
    //Return 0 an kaneis de kerdise
    private int utilityOf(State state){
        for (int a = 0; a < 8; a++) {
            String line = checkState(state, a);
            //Check for Winners
            if (line.equals("XXX")) {
                return 1;
            } else if (line.equals("OOO")) {
                return -1;
            }
        }
        return 0;
    }
    //Vriskei tis katastaseis nikhs an uparxoun
        private String checkState(State state, int a) {
          String result = "";
          String line;
          switch (a) {
            case 0 :
                line= state.getStateIndex(0) + state.getStateIndex(1) + state.getStateIndex(2);
                result=line;
                return result;

            case 1 :
                line= state.getStateIndex(0) + state.getStateIndex(1) + state.getStateIndex(2);
                result=line;
                return result;
                
            case 2 :
                line= state.getStateIndex(0) + state.getStateIndex(1) + state.getStateIndex(2);
                result=line;
                return result;
        
            case 3 :
                line= state.getStateIndex(0) + state.getStateIndex(1) + state.getStateIndex(2);
                result=line;
                return result;
            case 4 :
                line= state.getStateIndex(0) + state.getStateIndex(1) + state.getStateIndex(2);
                result=line;
                return result;
            case 5 :
                line= state.getStateIndex(0) + state.getStateIndex(1) + state.getStateIndex(2);
                result=line;
                return result;
            case 6 :
                line= state.getStateIndex(0) + state.getStateIndex(1) + state.getStateIndex(2);
                result=line;
                return result;
            case 7 :
                line= state.getStateIndex(0) + state.getStateIndex(1) + state.getStateIndex(2);
                result=line;
                return result;
              
            default:
                return result;
         
                

            }   

        }
    //Epistrefei oles tis pithanes katastaseis gia kathe katastasi
    private ArrayList<State> successorsOf(State state){
        ArrayList<State> possibleMoves = new ArrayList<>();
        int xMoves = 0;
        int yMoves = 0;
        String player;

        //Ypologizei tin seira tou paikti
        for (String s: state.getState()) {
            if (s.equals("X")) {
                xMoves++;
            }else if(s.equals("O")){
                yMoves++;
            }
        }

        if(xMoves <= yMoves){
            player = "X";
        } else {
            player = "O";
        }

        //Dimiourgei oles tis pithanes katastaseis
        for (int i = 0; i < 9; i++) {
            String[] newState = state.getState().clone();

            if(!"X".equals(newState[i]) && !"O".equals(newState[i])){
                newState[i] = player;
                possibleMoves.add(new State(i, newState));
            }
        }
        return possibleMoves;
    }
}
        
