import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class MainView extends JFrame {
    private JTextField firstNameField, lastNameField, dobField, skillLevelField;
    private JComboBox<Position> preferredPositionComboBox, currentPositionComboBox;
    private JButton addPlayerButton, createTeamButton, getAllPlayersButton, getStartingLineupButton;
    private JTextArea teamTextArea, displayArea;

    public MainView() {
        setTitle("Team Manager");
        setSize(600, 600); // Adjust size as needed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));

        formPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField(20);
        formPanel.add(firstNameField);

        formPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField(20);
        formPanel.add(lastNameField);

        formPanel.add(new JLabel("DOB (YYYY-MM-DD):"));
        dobField = new JTextField(20);
        formPanel.add(dobField);

        formPanel.add(new JLabel("Preferred Position:"));
        preferredPositionComboBox = new JComboBox<>(Position.values());
        formPanel.add(preferredPositionComboBox);

        formPanel.add(new JLabel("Current Position:"));
        currentPositionComboBox = new JComboBox<>(Position.values());
        formPanel.add(currentPositionComboBox);

        formPanel.add(new JLabel("Skill Level (1-5):"));
        skillLevelField = new JTextField(20);
        formPanel.add(skillLevelField);

        addPlayerButton = new JButton("Add Player");
        formPanel.add(addPlayerButton);

        createTeamButton = new JButton("Create Team");
        formPanel.add(createTeamButton);

        add(formPanel, BorderLayout.NORTH);

        teamTextArea = new JTextArea(10, 30);
        teamTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(teamTextArea);
        add(scrollPane, BorderLayout.CENTER);

        getAllPlayersButton = new JButton("Show All Players");
        getStartingLineupButton = new JButton("Show Starting Lineup");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(getAllPlayersButton);
        buttonPanel.add(getStartingLineupButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void displayInNewWindow(String title, String data) {
        JDialog infoDialog = new JDialog(this, title, true);
        JTextArea textArea = new JTextArea(20, 40);
        textArea.setText(data);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        infoDialog.add(scrollPane);
        infoDialog.pack();
        infoDialog.setLocationRelativeTo(this); // Center the dialog relative to the main window
        infoDialog.setVisible(true);
    }

    public JButton getAddPlayerButton() {
        return addPlayerButton;
    }

    public JButton getCreateTeamButton() {
        return createTeamButton;
    }

    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public LocalDate getDOB() {
        return LocalDate.parse(dobField.getText());
    }

    public Position getPreferredPosition() {
        return (Position) preferredPositionComboBox.getSelectedItem();
    }

    public Position getCurrentPosition() {
        return (Position) currentPositionComboBox.getSelectedItem();
    }

    public int getSkillLevel() {
        return Integer.parseInt(skillLevelField.getText());
    }

    public void updateTeamTextArea(String text) {
        teamTextArea.setText(text);
    }

    public JButton getGetAllPlayersButton() {
        return getAllPlayersButton;
    }

    public JButton getGetStartingLineupButton() {
        return getStartingLineupButton;
    }

    public void updateDisplayArea(String text) {
        displayArea.setText(text);
    }
}
