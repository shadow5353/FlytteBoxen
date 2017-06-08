package Tech;

import javax.swing.*;

public class Messages {

    public void errorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void infoMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Flytteboxen", JOptionPane.INFORMATION_MESSAGE);
    }

    public int confirmMessage(String message) {
        return JOptionPane.showConfirmDialog(null, message, "Flytteboxen", JOptionPane.YES_NO_OPTION);
    }

}
