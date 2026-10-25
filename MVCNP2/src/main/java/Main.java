import model.LoginController;
import view.LoginView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Definir Look and Feel do sistema
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Executar na thread do Swing
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            LoginController loginController = new LoginController(loginView);
            loginController.exibir();
        });
    }
}
