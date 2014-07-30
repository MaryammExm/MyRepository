package actions;

public class Start implements ActionListener {
   private StartMode mode;
    
    public Start(StartMode mode) {
        this.mode = mode;
    }

    private void linkDir(File[] files) throws Exception {
        for (File file : files) {
            if (file.isDirectory()) {
                String parentElement = Utility.getParent(file.getPath());
                if (!parentElement.equals(Storage.getRootFolderName())) {
                    Storage.getElement(parentElement).addContent(Storage.getElement(file.getName()));
                } else {
                    root.addContent(Storage.getElement(file.getName()));
                }
                linkDir(file.listFiles());
            }
        }
    }
}
