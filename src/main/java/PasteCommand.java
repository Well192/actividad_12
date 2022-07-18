public class PasteCommand extends Command{
    public PasteCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    boolean execute() {
        saveBackup();
        editor.replaceSelection(app.clipboard);
        return true;
    }


}
