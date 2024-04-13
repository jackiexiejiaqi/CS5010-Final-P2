// Team
/*
FIELDS
 .this.size: String
 .this.players: Player[]
 .this.onGround: Player[]
 .this.onBench: Player[]
 .this.jerseyNums: int[]
 METHODS
 ..this.addPlayer(Player p): void
 ..this.removePlayer(Player p): void
 ..this.replacePlayer(Player p): void
 ..this.selectLineUp(Player[] lst): void
 ..this.teamToString(): String
 ..this.lineUpToString(): String
 ..this.benchToString(): String
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;


/**
 * The Team class represents a sports team.
 */
public class Team implements teamInterface{
  private int size;

  private static final int MAX_TEAM_SIZE = 20;
  private static final int MIN_SKILL_LEVEL = 1;
  private static final int MAX_SKILL_LEVEL = 5;
  private static final int requiredNumberOfPlayers = 11;
  private ArrayList<Player> players, onGround, onBench;

  private int[] jerseyNums;

  /**
   * Constructs a Team object with an array of players.
   *
   * @param players The array of Player objects representing the players in the team.
   * @throws IllegalArgumentException if the players array is null.
   */
  public Team(Player[] players){
    if (players == null) {
      throw new IllegalArgumentException("The players array is null.");
    }
    this.size = players.length;
    this.players = new ArrayList<>(Arrays.asList(players));
    this.onGround = new ArrayList<>();
    this.onBench = new ArrayList<>();
    this.jerseyNums = new int[20];
    ArrayList<Integer> randJNum = new ArrayList<>();
    Random random = new Random();
    int jNum;
    while (randJNum.size() != players.length){
      jNum = random.nextInt(20);
      if (!randJNum.contains(jNum)){randJNum.add(jNum);}
    }
    for (int i = 0; i < players.length; i++) {
      this.players.get(i).setJerseyNumber(randJNum.get(i));
      this.jerseyNums[i] = randJNum.get(i);
    }
  }



  /**
   * Adds a player to the team.
   *
   * @param player The Player object representing the player to be added.
   *
   * @throws IllegalArgumentException if the team already has the maximum number of players or if the player's skill level is not within the valid range.
   */
  @Override
  public void addPlayer(Player player) {
    if (isValidPlayer(player)) {
      this.players.add(player);
      this.size++;
    } else {
      throw new IllegalArgumentException("Team cannot have more than " + MAX_TEAM_SIZE + " members or invalid player parameter");
    }
  }

  /**
   * Checks if a player is valid to be added to the team.
   *
   * @param player The Player object to be checked.
   * @return true if the player is valid, false otherwise.
   */
  private boolean isValidPlayer(Player player) {
    return this.size < MAX_TEAM_SIZE && player.getSkillLevel() >= MIN_SKILL_LEVEL && player.getSkillLevel() <= MAX_SKILL_LEVEL;
  }

  /**
   * Removes a player from the team.
   *
   * @param player The player to be removed from the team
   * @throws IllegalArgumentException If the team has less than 11 members or the player's skill level is not between 1 and 5 (inclusive)
   */
  @Override
  public void removePlayer(Player player) {
    if (this.size - 1 >= 10 && player.getSkillLevel() >= 1 && player.getSkillLevel() <= 5) {
      this.players.remove(player);
      this.size--;
    } else {
      throw new IllegalArgumentException("Team cannot have less than 10 members or invalid " +
              "payer parameter");
    }

  }


  /**
   * Replaces a player on the bench with a player on the ground in the team.
   *
   * @param playerOnBench The player to be replaced on the bench.
   * @param playerOnGround The player to be replaced on the ground.
   * @throws IllegalStateException if the players to be replaced do not exist in the team.
   * @throws IllegalArgumentException if either player's skill level is not between 1 and 5 (inclusive).
   */
  @Override
  public void replacePlayer(Player playerOnBench, Player playerOnGround) {
    if (this.onGround != null && playerOnBench.getSkillLevel() >= 1 && playerOnBench.getSkillLevel() <= 5 &&
            playerOnGround.getSkillLevel() >= 1 && playerOnGround.getSkillLevel() <= 5){
      if (this.onBench.contains(playerOnBench) && this.onGround.contains(playerOnGround)) {
        // remove the player only the onGround contains player and the player has a valid skill level
        this.onGround.set(this.onGround.indexOf(playerOnGround),
                this.onBench.get(this.onBench.indexOf(playerOnBench)));
        this.onBench.set(this.onBench.indexOf(playerOnBench), playerOnGround);
      } else {
        throw new IllegalStateException("The players to be replaced must exist in the team");
      }
    } else {
      throw new IllegalArgumentException("The value of the players to be replaced is invalid");
    }
  }

  /**
   * Selects the lineup of players based on preferred positions.
   *
   * @param playerArrayList The ArrayList of Player objects representing the players to choose from.
   * @return An ArrayList of Player objects representing the selected lineup.
   * @throws IllegalArgumentException if playerArrayList is null.
   */
  @Override
  public ArrayList<Player> selectLineUp(ArrayList<Player> playerArrayList) {
    ArrayList<Player> lineup = new ArrayList<>();
    if (playerArrayList != null){ // if user pass a lineup, then follow user's instruction
      this.onGround.addAll(playerArrayList);
      for (Player player: this.players){
        if (!this.onGround.contains(player)){
          this.onBench.add(player);
        }
      }
    } else {
      /*
      * 1 Goalie
      * 2 Defenders
      * 3 Midfielders
      * 1 Forward
      */
      int G = 1, D = 2, M = 3, F = 1;
      shellSort(this.players);

      for (Player player : this.players) {
        if (player.getPreferredPosition() == Position.Goalie && G > 0) {
          lineup.add(player);
          this.onGround.add(player);
          G--;
        } else if (player.getPreferredPosition() == Position.Defenders && D > 0) {
          lineup.add(player);
          this.onGround.add(player);
          D--;
        } else if (player.getPreferredPosition() == Position.Midfielders && M > 0) {
          lineup.add(player);
          this.onGround.add(player);
          M--;
        } else if (player.getPreferredPosition() == Position.Forward && F > 0) {
          lineup.add(player);
          this.onGround.add(player);
          F--;
        }
      }

      for (Player player : this.players) {
        if (!lineup.contains(player)) {
          this.onBench.add(player);
        }
      }
    }

    return lineup;
  }

  /**
   * Returns a string representation of the team.
   *
   * @return The string representation of the team, including the team total view and details of each player.
   */
  @Override
  public String teamToString() {
    StringBuilder teamString = new StringBuilder();
    teamString.append("Team Total View: ").append("\n");
    for (Player player : this.players) {
      teamString.append(player.toString()).append("\n");
    }
    return teamString.toString();
  }

  /**
   * Returns a string representation of the players currently on the ground.
   *
   * @return a string representing the players currently on the ground
   */
  @Override
  public String lineUpToString() {
    StringBuilder teamString = new StringBuilder();
    teamString.append("Players on Ground: ").append("\n");
    for (Player player : this.onGround) {
      teamString.append(player.toString()).append("\n");
    }
    return teamString.toString();
  }

  /**
   * Returns a string representation of the players on the bench.
   *
   * @return A string representation of the players on the bench.
   */
  @Override
  public String benchToString() {
    StringBuilder teamString = new StringBuilder();
    teamString.append("Players on Bench: ").append("\n");
    for (Player player : this.onBench) {
      teamString.append(player.toString()).append("\n");
    }
    return teamString.toString();
  }

  /**
   * Sorts an ArrayList of Player objects using the shell sort algorithm, descending.
   *
   * @param playerArrayList The ArrayList of Player objects to be sorted.
   *
   * @throws IllegalArgumentException if playerArrayList is null.
   *
   * @see Player
   */
  private void shellSort(ArrayList<Player> playerArrayList){
    int j;
    for (int gap = playerArrayList.size() / 2; gap >  0; gap /= 2){
      for (int i = gap; i < playerArrayList.size(); i++) {
        Player temp = playerArrayList.get(i);
        for (j = i; j >= gap && playerArrayList.get(j - gap).getSkillLevel() < temp.getSkillLevel(); j -= gap) {
          playerArrayList.set(j, playerArrayList.get(j - gap));
        }
        playerArrayList.set(j, temp);
      }
    }
  }

  /**
   * Gets the list of all players in the team.
   *
   * @return a copy of the list of players.
   */
  public List<Player> getPlayers() {
    return new ArrayList<>(players); // Return a copy to protect the internal list.
  }

  public void finalizeTeam() {
    // Example logic to finalize the team setup
    if (players.size() >= requiredNumberOfPlayers) {
      // Assume some sorting or setup
      Collections.sort(players, Comparator.comparing(Player::getSkillLevel).reversed());
      // Just an example of setting up a starting lineup based on sorted players
      onGround.clear();
      onBench.clear();
      for (int i = 0; i < players.size(); i++) {
        if (i < 11) { // Example: Top 11 players make it to the ground
          onGround.add(players.get(i));
        } else {
          onBench.add(players.get(i));
        }
      }
    }
  }

  /**
   * Gets the full list of players on the team.
   * @return A formatted string of all players.
   */
  public String getAllPlayers() {
    StringBuilder builder = new StringBuilder("All Players:\n");
    for (Player player : players) {
      builder.append(player).append("\n");  // Ensure Player class has a suitable toString() method
    }
    return builder.toString();
  }

  /**
   * Gets the list of players in the starting lineup.
   * @return A formatted string of the starting lineup.
   */
  public String getStartingLineup() {
    StringBuilder builder = new StringBuilder("Starting Lineup:\n");
    for (Player player : onGround) {
      builder.append(player).append("\n");  // Ensure Player class has a suitable toString() method
    }
    return builder.toString();
  }
}
