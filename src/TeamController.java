import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TeamController {
    private Team model;
    private MainView view;
    private static final int requiredNumberOfPlayers = 11;  // Example requirement

    public TeamController(Team model, MainView view) {
        this.model = model;
        this.view = view;
        initView();
    }

    public void initView() {
        view.getAddPlayerButton().addActionListener(e -> addPlayer());
        view.getCreateTeamButton().addActionListener(e -> createTeam());
        view.getGetAllPlayersButton().addActionListener(e -> displayAllPlayers());
        view.getGetStartingLineupButton().addActionListener(e -> displayStartingLineup());
    }

    public void addPlayer() {
        try {
            String firstName = view.getFirstName();
            String lastName = view.getLastName();
            LocalDate dob = view.getDOB();
            Position preferredPosition = view.getPreferredPosition();
            Position currentPosition = view.getCurrentPosition();
            int skillLevel = view.getSkillLevel();

            Player newPlayer = new Player(firstName, lastName, dob, preferredPosition, currentPosition, skillLevel);
            model.addPlayer(newPlayer);
            view.updateTeamTextArea("Player added successfully.\n" + model.teamToString());
        } catch (DateTimeParseException dtpe) {
            view.updateTeamTextArea("Invalid date format. Please use YYYY-MM-DD.");
        } catch (NumberFormatException nfe) {
            view.updateTeamTextArea("Skill level must be a valid integer between 1 and 5.");
        } catch (IllegalArgumentException iae) {
            view.updateTeamTextArea(iae.getMessage());
        } catch (Exception e) {
            view.updateTeamTextArea("An error occurred: " + e.getMessage());
        }
    }

    public void createTeam() {
        if (model.getPlayers().size() < requiredNumberOfPlayers) {
            view.updateTeamTextArea("Not enough players to form a team. At least " + requiredNumberOfPlayers + " players are required.");
        } else {
            model.finalizeTeam();
            view.updateTeamTextArea("Team created successfully!\n" + model.teamToString());
        }
    }

    private void displayAllPlayers() {
        String allPlayers = model.getAllPlayers();
        view.displayInNewWindow("All Players", allPlayers);
    }

    private void displayStartingLineup() {
        String lineup = model.getStartingLineup();
        view.displayInNewWindow("Starting Lineup", lineup);
    }
}
