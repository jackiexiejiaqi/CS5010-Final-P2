import javax.swing.SwingUtilities;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Player[] initialPlayers = new Player[0]; // Empty array of players
                Team model = new Team(initialPlayers);
                MainView view = new MainView();
                TeamController controller = new TeamController(model, view);
                view.setVisible(true);
            }
        });
    }
}
