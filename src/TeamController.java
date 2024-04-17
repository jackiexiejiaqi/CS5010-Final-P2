import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

public class TeamController {
    private Team model;
    private MainWindow view;

    private int ID = 1;

    ArrayList<Team> TeamList = new ArrayList<>();
    ArrayList<Player> PlayerList = new ArrayList<>();
    private static final int requiredNumberOfPlayers = 11;  // Example requirement

    public TeamController(Team model, MainWindow view) {
        this.model = model;
        this.view = view;
        initView();
    }

    public void initView() {
        this.view.getTeamTotalList().setModel(new DefaultListModel<>());
        this.view.getU10ManageButton().addActionListener(e -> addU10Management());
        this.view.getCreateButton().addActionListener((ActionEvent e) -> CreateToAddPlayer());
        this.view.getManagementBackButton().addActionListener((ActionEvent e) -> goBackToMainPanel());
        this.view.getSelectLineupButton().addActionListener((ActionEvent e) -> selectLineup());
        this.view.getReplacePlayerButton().addActionListener((ActionEvent e) -> replacePlayer());
        this.view.getAddSingleButton().addActionListener((ActionEvent e) -> addSinglePlayer());
        this.view.getAddToTeamButton().addActionListener((ActionEvent e) -> addToTeam());
        this.view.getRemovePlayerButton().addActionListener((ActionEvent e) -> removePlayer());
        this.view.getAddPlayerButton().addActionListener((ActionEvent e) -> addPlayer());
        this.view.getLineupList().addListSelectionListener(listener);
        this.view.getOnBenchList().addListSelectionListener(listener);
    }

    private void addPlayer() {
        System.out.println("Enter from team " + this.view.getU10TeamsComboBox().getSelectedItem()+ " Management by clicking AddPlayer");
        this.view.getMainPanel().removeAll();
        this.view.getMainPanel().add(this.view.getAddPlayerPanel());
        this.view.getMainPanel().repaint();
        this.view.getMainPanel().revalidate();
        this.view.getAddPlayerLabel().setText("U10 Team " + this.view.getU10TeamsComboBox().getSelectedItem() + " Management");
    }

    private void removePlayer() {
        int curID = (int) this.view.getU10TeamsComboBox().getSelectedItem();
        DefaultListModel<Player> model1 =
                (DefaultListModel<Player>) this.view.getTeamTotalList().getModel();
        DefaultListModel<Player> model2 =
                (DefaultListModel<Player>) this.view.getLineupList().getModel();

        Player selected = this.view.getTeamTotalList().getSelectedValue();
        System.out.println(selected.toString());

        if (!containsValue(model2, selected)){
            model1.removeElement(selected);
        } else {
            JOptionPane.showMessageDialog(this.view.getTeamManagementPanel(), "You have to put the on " +
                    "ground player on bench before remove", "Error ", JOptionPane.ERROR_MESSAGE);
        }


        for (Team team : TeamList) {
            if (team.getTeamID() == curID) {
                team.removePlayer(selected);
                this.view.getRemovePlayerButton().setEnabled(team.getPlayersInArray().length > 11);
            }
        }
    }

    private static <T> boolean containsValue(ListModel<T> model, T value) {
        for (int i = 0; i < model.getSize(); i++) {
            if (value.equals(model.getElementAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean findTeam(int ID) {
        for (Team team1: TeamList){
            if (team1.getTeamID() == ID){
                return true;
            }
        }
        return false;
    }

    private void addToTeam() {
        try {
            DefaultListModel<Player> model1 =
                    (DefaultListModel<Player>) this.view.getTeamTotalList().getModel();
            if (this.view.getU10TeamsComboBox().getItemCount() > 0) {
                int curID = (int) this.view.getU10TeamsComboBox().getSelectedItem();
                System.out.println("Try to find existed team with ID: " + curID);
                for (Team team : TeamList) {
                    if (team.getTeamID() == curID) {
                        System.out.println("find existed team " + curID);
                        System.out.println("Current PlayerList" + this.PlayerList);
                        for (Player player : PlayerList) {
                            team.addPlayer(player);
                        }
                        this.PlayerList.clear();
                        System.out.println("After addition PlayerList " + this.PlayerList);
                        this.view.getAddPlayerCurrentTextArea().setText("");

                        this.view.getMainPanel().removeAll();
                        this.view.getMainPanel().add(this.view.getTeamManagementPanel());
                        this.view.getMainPanel().repaint();
                        this.view.getMainPanel().revalidate();
                        this.view.getTeamManagementLabel().setText("U10 Team " + curID + " " +
                                "Management");
                        System.out.println("Enter through AddPlayer for existed team");
                        model1.clear();

                        this.view.getRemovePlayerButton().setEnabled(team.getPlayersInArray().length > 11);
                        this.view.getAddPlayerButton().setEnabled(team.getPlayersInArray().length < 20);

                        for (Player player : team.getPlayers()) { // fill TeamTotalList
                            model1.addElement(player);
                        }
                        return;
                    }
                }

            }
            if (this.view.getU10TeamsComboBox().getItemCount() == 0 ||
                    !findTeam(this.ID)) {

                System.out.println("First team or New team");
                try {
                    Team tempTeam = new Team(ID, PlayerList);
                    this.PlayerList.clear();
                    System.out.println("Current PlayerList" + this.PlayerList);

                    if (!TeamList.contains(tempTeam)) { // if the team does not exist
                        TeamList.add(tempTeam);

                        //System.out.println(tempTeam.teamToString());
                        JOptionPane.showMessageDialog(this.view.getAddPlayerPanel(), "Creation success!", "Success ",
                                JOptionPane.INFORMATION_MESSAGE);
                        this.view.getMainPanel().removeAll();
                        this.view.getMainPanel().add(this.view.getTeamManagementPanel());
                        this.view.getMainPanel().repaint();
                        this.view.getMainPanel().revalidate();
                        this.view.getTeamManagementLabel().setText("U10 Team " + ID + " " +
                                "Management");
                        model1.clear();
                        int curID = (int) this.view.getU10TeamsComboBox().getSelectedItem();
                        System.out.println("new Current ID: " + curID);
                        System.out.println("Enter through create a new team, team " + curID);
                        this.ID+=1;
                        System.out.println("Next ID: " + this.ID);

                        for (Team team : TeamList) {
                            if (team.getTeamID() == curID) {
                                this.view.getRemovePlayerButton().setEnabled(team.getPlayersInArray().length > 11);
                                this.view.getAddPlayerButton().setEnabled(team.getPlayersInArray().length < 20);

                                for (Player player : team.getPlayers()) { // fill TeamTotalList
                                    model1.addElement(player);
                                }
                                this.view.getAddPlayerCurrentTextArea().setText("");
                            }
                        }


                    }
                } catch (IllegalArgumentException iae) {
                    JOptionPane.showMessageDialog(this.view.getAddPlayerPanel(), iae.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(this.view.getAddPlayerPanel(), iae.getMessage(), "Error" +
                    " ", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addSinglePlayer() {
        try {
            System.out.println("Add player button in AddPlayer is pressed");
            Player tempPlayer = new Player(this.view.getFNTextField().getText().trim(),
                    this.view.getLNTextField().getText().trim()
                    , LocalDate.parse(this.view.getDOBTextField().getText(), DateTimeFormatter.ofPattern("yyyy" +
                    "-MM-dd")), (Position) this.view.getPFComboBox().getSelectedItem(), Position.NotAssigned,
                    (Integer) this.view.getSKComboBox().getSelectedItem());
            if (!contain(tempPlayer, PlayerList)) {
                PlayerList.add(tempPlayer);
            } else {
                throw new IllegalArgumentException("Player already existed.");
            }

            if (this.view.getAddPlayerCurrentTextArea().getText().equals("No players prepared to be added.")) {
                this.view.getAddPlayerCurrentTextArea().setText("");
            }
            this.view.getAddPlayerCurrentTextArea().append(tempPlayer + "\n");
            this.view.getFNTextField().setText("");
            this.view.getLNTextField().setText("");
            this.view.getDOBTextField().setText("");
        } catch (DateTimeParseException dtpe) {
            JOptionPane.showMessageDialog(this.view.getAddPlayerPanel(), "Invalid date format. Please use " +
                    "YYYY-MM-DD.", "Error ", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(this.view.getAddPlayerPanel(), iae.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean contain(Player player, ArrayList<Player> lst){
        for (Player player1: lst){
            if (player.getJerseyNumber() == player1.getJerseyNumber() &&
                    player.getSkillLevel() == player1.getSkillLevel() &&
                    player.getFirstName().equals(player1.getFirstName()) &&
                    player.getLastName().equals(player1.getLastName()) &&
                    player.getPreferredPosition().equals(player1.getPreferredPosition()) &&
                    player.getBirthDate().equals(player1.getBirthDate()) &&
                    player.getCurrentPosition().equals(player1.getCurrentPosition())){
                return true;
            }
        }
        return false;
    }

    private void replacePlayer() {
        int curID = (int) this.view.getU10TeamsComboBox().getSelectedItem();
        DefaultListModel<Player> model2 =
                (DefaultListModel<Player>) this.view.getLineupList().getModel();
        DefaultListModel<Player> model3 =
                (DefaultListModel<Player>) this.view.getOnBenchList().getModel();

        for (Team team : TeamList) {  // setup lineup/ onBench start
            if (team.getTeamID() == curID) {  // replace the player in TeamList and JList start
                //System.out.println(team.lineUpToString());
                //System.out.println(team.benchToString());
                //System.out.println(team.getLineup().contains(LineupList.getSelectedValue()));
                //System.out.println(team.getOnBench().contains(OnBenchList.getSelectedValue()));
                Player player1 = this.view.getLineupList().getSelectedValue(), player2 =
                        this.view.getOnBenchList().getSelectedValue();
                //System.out.println(player1.getJerseyNumber() + "    " + player2.getJerseyNumber());
                //System.out.println(team.findPlayerLineup(player1.getJerseyNumber()));
                //team.replacePlayer(team.findPlayerLineup(player1.getJerseyNumber()),
                //        team.findPlayerOnBench(player2.getJerseyNumber()));

                int selectedIndexA = this.view.getLineupList().getSelectedIndex();
                int selectedIndexB = this.view.getOnBenchList().getSelectedIndex();

                if (selectedIndexA != -1 && selectedIndexB != -1) {
                    // Get selected items
                    Player selectedItemA = model2.get(selectedIndexA);
                    Player selectedItemB = model3.get(selectedIndexB);

                    // Swap items
                    model2.set(selectedIndexA, selectedItemB);
                    model3.set(selectedIndexB, selectedItemA);
                }
            }
        }  // replace the player in TeamList and JList end
    }

    private void selectLineup() {
        int curID = (int) this.view.getU10TeamsComboBox().getSelectedItem();
        System.out.println("Team " + curID + "selecting lineup");
        DefaultListModel<Player> model2 =
                (DefaultListModel<Player>) this.view.getLineupList().getModel();
        DefaultListModel<Player> model3 =
                (DefaultListModel<Player>) this.view.getOnBenchList().getModel();
        Player[] lineupTemp = new Player[0], onBenchTemp = new Player[0];

        model2.clear();
        model3.clear();

        for (Team team : TeamList) {  // setup lineup/ onBench start
            if (team.getTeamID() == curID) {  // setup lineup and get lineup, onBench
                team.selectLineUp(null);
                lineupTemp = team.getLineupInArray();
                onBenchTemp = team.getOnBenchInArray();
            }
        }  // setup lineup/ onBench end
        for (Player player : lineupTemp) { // fill LineupList
            model2.addElement(player);
        }
        for (Player player : onBenchTemp) { // fill OnBenchList
            model3.addElement(player);
        }
    }

    private void goBackToMainPanel() {
        System.out.println("Go back to main from management team " + this.ID);
        this.view.getMainPanel().removeAll();
        this.view.getMainPanel().add(this.view.getU10Panel());
        this.view.getMainPanel().repaint();
        this.view.getMainPanel().revalidate();
    }

    public void addU10Management(){
        if (this.view.getU10TeamsComboBox().getItemCount() == 0) { // if the team list is empty,
            // then go to the AddPlayer card
            System.out.println("Enter AddPlayer by Click management button");
            this.view.getMainPanel().removeAll();
            this.view.getMainPanel().add(this.view.getAddPlayerPanel());
            this.view.getMainPanel().repaint();
            this.view.getMainPanel().revalidate();
            this.view.getAddPlayerLabel().setText("U10 Team 1 Add Player");


        } else { // else go to the corresponding management card
            //System.out.println(U10TeamsComboBox.getSelectedItem());
            int curID = (int) this.view.getU10TeamsComboBox().getSelectedItem();
            System.out.println("Enter team " + curID + "Management by clicking management button");
            this.view.getMainPanel().removeAll();
            this.view.getMainPanel().add(this.view.getTeamManagementPanel());
            this.view.getMainPanel().repaint();
            this.view.getMainPanel().revalidate();
            this.view.getTeamManagementLabel().setText("U10 Team " + this.view.getU10TeamsComboBox()
                    .getSelectedItem() + " Management"); // set title for managing player


            for (Team team : TeamList) {
                if (team.getTeamID() == curID) { // find the right team in TeamList
                    // if the team member count reaches the minimum or maximum, disable the corresponding
                    // button
                    this.view.getRemovePlayerButton().setEnabled(team.getPlayersInArray().length > 11);
                    this.view.getAddPlayerButton().setEnabled(team.getPlayersInArray().length < 20);
                    DefaultListModel<Player> model1 =
                            (DefaultListModel<Player>) this.view.getTeamTotalList().getModel();

                    for (Player player : team.getPlayers()) { // fill TeamTotalList
                        model1.addElement(player);
                    }
                }
            }
        }
    }

    public void CreateToAddPlayer() {
        System.out.println("Enter AddPlayer by create button");
        this.view.getMainPanel().removeAll();
        this.view.getMainPanel().add(this.view.getAddPlayerPanel());
        this.view.getMainPanel().repaint();
        this.view.getMainPanel().revalidate();
        this.view.getAddPlayerLabel().setText("U10 Team " + ID + " Add Player"); // set title for
        // managing player
        System.out.println("Add item to combobox after click Create in main window");
        this.view.getU10TeamsComboBox().addItem(ID);
        this.view.getU10TeamsComboBox().setSelectedItem(ID);
  }

    ListSelectionListener listener = e -> {  // ReplacePlayerButtonEnable listener start
        if (!e.getValueIsAdjusting()) {
            int selectedIndexA = this.view.getLineupList().getSelectedIndex();
            int selectedIndexB = this.view.getOnBenchList().getSelectedIndex();

            if (selectedIndexA != -1 && selectedIndexB != -1) {
                this.view.getReplacePlayerButton().setEnabled(true);
            }
        }
    };  // ReplacePlayerButtonEnable listener end



}
