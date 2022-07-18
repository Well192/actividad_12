import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class Application {
    public ArrayList<Editor> editors = new ArrayList<>();
    public Editor activeEditor;
    public String clipboard;
    public CommandHistory history;

    public void createIU(){
        JButton copyButton = new JButton("Ctrl+C");
        JButton cutButton = new JButton("Ctrl+X");
        JButton pasteButton = new JButton("Ctrl+V");
        JButton undoButton = new JButton("Ctrl+Z");
        Application app = this;

        //copy
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new CopyCommand(app, activeEditor));
            }
        });

        //cut
        cutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new CutCommand(app, activeEditor));
            }
        });

        //paste
        pasteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new PasteCommand(app, activeEditor));
            }
        });

        //undo
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new UndoCommand(app, activeEditor));
            }
        });
    }

    public void executeCommand(Command command){
        if(command.execute()){
            history.push(command);
        }
    }

    public void undo(){
        Command command = history.pop();
        if(command != null){
            command.undo();
        }
    }
}
