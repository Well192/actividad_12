import java.util.ArrayList;

public class CommandHistory {
    private ArrayList<Command> history = new ArrayList<>();

    public void push(Command c){
        history.add(c);
    }

    public Command pop(){
        return history.get(history.size()-1);
    }

}
