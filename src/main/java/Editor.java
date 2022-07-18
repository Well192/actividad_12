
public class Editor {
    public String text = "seleccion";

    public String getSelection(){
        return text;
    }

    public void deleteSelection(){
        text = "";
    }

    public void replaceSelection(String clipboard) {
        text = clipboard;
    }
}
