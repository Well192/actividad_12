public class CopyCommand extends Command{
    public CopyCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    boolean execute() {
        app.clipboard = editor.getSelection();
        return false;
    }
}
