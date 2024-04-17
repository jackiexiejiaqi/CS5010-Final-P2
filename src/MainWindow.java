import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;

public class MainWindow extends JFrame {
  private JPanel MainPanel;
  private JPanel TeamManagementPanel;
  private JLabel TeamManagementLabel;
  private JPanel TeamManagementSubPanel;
  private JButton AddPlayerButton;
  private JButton RemovePlayerButton;
  private JButton ReplacePlayerButton;
  private JPanel TeamInfoPanel;
  private JPanel U10Panel;
  private JList<Player> TeamTotalList;
  private JLabel TeamTotalLabel;
  private JScrollPane TeamTotalScroll;
  private JLabel LineupLabel;
  private JScrollPane LineupScroll;
  private JList<Player> LineupList;
  private JLabel OnBenchLabel;
  private JScrollPane OnBenchScroll;
  private JList<Player> OnBenchList;
  private JPanel ManagementActionPanel;
  private JPanel AddPlayerPanel;
  private JPanel AddPlayerTopPanel;
  private JPanel AddPlayerActionPanel;
  private JLabel AddPlayerLabel;
  private JPanel AddSinglePanel;
  private JTextField FNTextField;
  private JTextField LNTextField;
  private JTextField DOBTextField;
  private JComboBox<Position> PFComboBox;
  private JLabel FirstNameLabel;
  private JLabel LastNameLabel;
  private JLabel DOBLabel;
  private JLabel PreferredPositionLabel;
  private JLabel SkillLevelLabel;
  private JComboBox<Integer> SKComboBox;
  private JButton AddSingleButton;
  private JTextArea U10WelcomeTextArea;
  private JComboBox<Integer> U10TeamsComboBox;
  private JButton U10Managebutton;
  private JLabel U10Title;
  private JLabel U10TeamsLabel;
  private JPanel U10TeamMangePanel;
  private JTextArea AddPlayerCurrentTextArea;
  private JLabel AddPlayerCurrentLabel;
  private JScrollPane AddPlayerCurrentScroll;
  private JButton AddToTeamButton;
  private JButton ManagementBackButton;
  private JButton SelectLineupButton;
  private JButton CreateButton;


  public MainWindow() {
    ArrayList<Team> TeamList = new ArrayList<>();
    ArrayList<Player> PlayerList = new ArrayList<>();


    // set model for three JLists starts
    TeamTotalList.setModel(new DefaultListModel<>());

    LineupList.setModel(new DefaultListModel<>());

    OnBenchList.setModel(new DefaultListModel<>());
    // set model for three JLists ends

    PFComboBox.addItem(Position.Forward); // Initialize Preferred Position combo box
    PFComboBox.addItem(Position.Defenders);
    PFComboBox.addItem(Position.Goalie);
    PFComboBox.addItem(Position.Midfielders);

    SKComboBox.addItem(1); // Initialize skill level combo box
    SKComboBox.addItem(2);
    SKComboBox.addItem(3);
    SKComboBox.addItem(4);
    SKComboBox.addItem(5);


  }

  // JPanel getter start
  public JPanel getMainPanel() {
    return this.MainPanel;
  }

  public JPanel getU10Panel() {
    return this.U10Panel;
  }

  public JPanel getTeamManagementPanel() {
    return this.TeamManagementPanel;
  }

  public JPanel getAddPlayerPanel() {
    return this.AddPlayerPanel;
  }
  // JPanel getter end

  // JComboBox getter start
  public JComboBox<Integer> getU10TeamsComboBox() {
    return this.U10TeamsComboBox;
  }

  public JComboBox<Position> getPFComboBox() {
    return this.PFComboBox;
  }

  public JComboBox<Integer> getSKComboBox() {
    return this.SKComboBox;
  }

  // JComboBox getter end

  // JList getter start
  public JList<Player> getTeamTotalList() {
    return this.TeamTotalList;
  }

  public JList<Player> getLineupList() {
    return this.LineupList;
  }

  public JList<Player> getOnBenchList() {
    return this.OnBenchList;
  }

  // JList getter end

  // JLabel getter start
  public JLabel getTeamManagementLabel() {
    return this.TeamManagementLabel;
  }

  public JLabel getAddPlayerLabel() {
    return this.AddPlayerLabel;
  }
  // JKLabel getter end


  // JButton getter start
  public JButton getU10ManageButton() {
    return this.U10Managebutton;
  }

  public JButton getCreateButton() {
    return this.CreateButton;
  }

  public JButton getManagementBackButton() {
    return this.ManagementBackButton;
  }

  public JButton getSelectLineupButton() {
    return this.SelectLineupButton;
  }

  public JButton getReplacePlayerButton() {
    return this.ReplacePlayerButton;
  }

  public JButton getAddSingleButton() {
    return this.AddSingleButton;
  }

  public JButton getAddToTeamButton() {
    return this.AddToTeamButton;
  }

  public JButton getAddPlayerButton() {
    return this.AddPlayerButton;
  }

  public JButton getRemovePlayerButton() {
    return this.RemovePlayerButton;
  }
  // JButton getter end

  // JTextField getter start
  public JTextField getFNTextField() {
    return this.FNTextField;
  }

  public JTextField getLNTextField() {
    return this.LNTextField;
  }

  public JTextField getDOBTextField() {
    return this.DOBTextField;
  }
  // JTextField getter end

  // JTextArea getter start
  public JTextArea getAddPlayerCurrentTextArea() {
    return this.AddPlayerCurrentTextArea;
  }
  // JTextArea getter end

  /*
  public static void main(String[] args) {
    MainWindow mainWindow = new MainWindow();
    mainWindow.run();

  }

  public void run() {
    JFrame frame = new JFrame("Main Window");
    frame.setContentPane(new MainWindow().MainPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

   */

  {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
    $$$setupUI$$$();
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    MainPanel = new JPanel();
    MainPanel.setLayout(new CardLayout(0, 0));
    U10Panel = new JPanel();
    U10Panel.setLayout(new BorderLayout(0, 0));
    U10Panel.setMaximumSize(new Dimension(2147483647, 10));
    U10Panel.setMinimumSize(new Dimension(938, 10));
    MainPanel.add(U10Panel, "MainWindow");
    U10Title = new JLabel();
    Font U10TitleFont = this.$$$getFont$$$("Courier New", Font.BOLD, 20, U10Title.getFont());
    if (U10TitleFont != null) U10Title.setFont(U10TitleFont);
    U10Title.setHorizontalAlignment(0);
    U10Title.setHorizontalTextPosition(0);
    U10Title.setText("U10 Team Management APP");
    U10Panel.add(U10Title, BorderLayout.NORTH);
    U10WelcomeTextArea = new JTextArea();
    U10WelcomeTextArea.setEditable(false);
    Font U10WelcomeTextAreaFont = this.$$$getFont$$$("Courier New", Font.BOLD | Font.ITALIC, 16, U10WelcomeTextArea.getFont());
    if (U10WelcomeTextAreaFont != null) U10WelcomeTextArea.setFont(U10WelcomeTextAreaFont);
    U10WelcomeTextArea.setLineWrap(true);
    U10WelcomeTextArea.setText("Welcome to U10 Team Management APP. \n\nPlease select the team you want to manage from the right dropbox;\n\nOr, create your first new team by clicking the right button.");
    U10Panel.add(U10WelcomeTextArea, BorderLayout.CENTER);
    U10TeamMangePanel = new JPanel();
    U10TeamMangePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    U10Panel.add(U10TeamMangePanel, BorderLayout.EAST);
    U10TeamsLabel = new JLabel();
    Font U10TeamsLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, U10TeamsLabel.getFont());
    if (U10TeamsLabelFont != null) U10TeamsLabel.setFont(U10TeamsLabelFont);
    U10TeamsLabel.setText("Team(s): ");
    U10TeamMangePanel.add(U10TeamsLabel);
    U10TeamsComboBox = new JComboBox();
    Font U10TeamsComboBoxFont = this.$$$getFont$$$("Courier New", Font.PLAIN, 16, U10TeamsComboBox.getFont());
    if (U10TeamsComboBoxFont != null) U10TeamsComboBox.setFont(U10TeamsComboBoxFont);
    U10TeamMangePanel.add(U10TeamsComboBox);
    U10Managebutton = new JButton();
    Font U10ManagebuttonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, U10Managebutton.getFont());
    if (U10ManagebuttonFont != null) U10Managebutton.setFont(U10ManagebuttonFont);
    U10Managebutton.setText("Manage/Create");
    U10TeamMangePanel.add(U10Managebutton);
    CreateButton = new JButton();
    Font CreateButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, CreateButton.getFont());
    if (CreateButtonFont != null) CreateButton.setFont(CreateButtonFont);
    CreateButton.setLabel("Create");
    CreateButton.setText("Create");
    U10TeamMangePanel.add(CreateButton);
    TeamManagementPanel = new JPanel();
    TeamManagementPanel.setLayout(new BorderLayout(0, 0));
    MainPanel.add(TeamManagementPanel, "PlayerWindow");
    TeamManagementLabel = new JLabel();
    Font TeamManagementLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 20, TeamManagementLabel.getFont());
    if (TeamManagementLabelFont != null) TeamManagementLabel.setFont(TeamManagementLabelFont);
    TeamManagementLabel.setHorizontalAlignment(0);
    TeamManagementLabel.setText("U10: Management");
    TeamManagementPanel.add(TeamManagementLabel, BorderLayout.NORTH);
    TeamManagementSubPanel = new JPanel();
    TeamManagementSubPanel.setLayout(new BorderLayout(0, 0));
    TeamManagementPanel.add(TeamManagementSubPanel, BorderLayout.CENTER);
    TeamInfoPanel = new JPanel();
    TeamInfoPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 1, new Insets(0, 0, 0, 0), -1, -1));
    TeamManagementSubPanel.add(TeamInfoPanel, BorderLayout.CENTER);
    TeamInfoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
    TeamTotalScroll = new JScrollPane();
    TeamInfoPanel.add(TeamTotalScroll, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    TeamTotalList = new JList();
    Font TeamTotalListFont = this.$$$getFont$$$("Courier New", Font.PLAIN, 16, TeamTotalList.getFont());
    if (TeamTotalListFont != null) TeamTotalList.setFont(TeamTotalListFont);
    TeamTotalList.setSelectionMode(0);
    TeamTotalList.setValueIsAdjusting(false);
    TeamTotalScroll.setViewportView(TeamTotalList);
    TeamTotalLabel = new JLabel();
    Font TeamTotalLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, TeamTotalLabel.getFont());
    if (TeamTotalLabelFont != null) TeamTotalLabel.setFont(TeamTotalLabelFont);
    TeamTotalLabel.setText("Total Team Info:");
    TeamInfoPanel.add(TeamTotalLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    LineupLabel = new JLabel();
    Font LineupLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, LineupLabel.getFont());
    if (LineupLabelFont != null) LineupLabel.setFont(LineupLabelFont);
    LineupLabel.setText("Lineup Info:");
    TeamInfoPanel.add(LineupLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    LineupScroll = new JScrollPane();
    TeamInfoPanel.add(LineupScroll, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    LineupList = new JList();
    Font LineupListFont = this.$$$getFont$$$("Courier New", Font.PLAIN, 16, LineupList.getFont());
    if (LineupListFont != null) LineupList.setFont(LineupListFont);
    LineupScroll.setViewportView(LineupList);
    OnBenchLabel = new JLabel();
    Font OnBenchLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, OnBenchLabel.getFont());
    if (OnBenchLabelFont != null) OnBenchLabel.setFont(OnBenchLabelFont);
    OnBenchLabel.setText("OnBench Info:");
    TeamInfoPanel.add(OnBenchLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    OnBenchScroll = new JScrollPane();
    TeamInfoPanel.add(OnBenchScroll, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    OnBenchList = new JList();
    Font OnBenchListFont = this.$$$getFont$$$("Courier New", Font.PLAIN, 16, OnBenchList.getFont());
    if (OnBenchListFont != null) OnBenchList.setFont(OnBenchListFont);
    OnBenchScroll.setViewportView(OnBenchList);
    ManagementActionPanel = new JPanel();
    ManagementActionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    TeamManagementSubPanel.add(ManagementActionPanel, BorderLayout.SOUTH);
    ManagementBackButton = new JButton();
    Font ManagementBackButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, ManagementBackButton.getFont());
    if (ManagementBackButtonFont != null) ManagementBackButton.setFont(ManagementBackButtonFont);
    ManagementBackButton.setText("Back");
    ManagementActionPanel.add(ManagementBackButton);
    AddPlayerButton = new JButton();
    Font AddPlayerButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, AddPlayerButton.getFont());
    if (AddPlayerButtonFont != null) AddPlayerButton.setFont(AddPlayerButtonFont);
    AddPlayerButton.setLabel("Add Player");
    AddPlayerButton.setText("Add Player");
    ManagementActionPanel.add(AddPlayerButton);
    RemovePlayerButton = new JButton();
    Font RemovePlayerButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, RemovePlayerButton.getFont());
    if (RemovePlayerButtonFont != null) RemovePlayerButton.setFont(RemovePlayerButtonFont);
    RemovePlayerButton.setLabel("Remove Player");
    RemovePlayerButton.setText("Remove Player");
    ManagementActionPanel.add(RemovePlayerButton);
    SelectLineupButton = new JButton();
    Font SelectLineupButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, SelectLineupButton.getFont());
    if (SelectLineupButtonFont != null) SelectLineupButton.setFont(SelectLineupButtonFont);
    SelectLineupButton.setLabel("Select Lineup");
    SelectLineupButton.setText("Select Lineup");
    ManagementActionPanel.add(SelectLineupButton);
    ReplacePlayerButton = new JButton();
    ReplacePlayerButton.setEnabled(false);
    Font ReplacePlayerButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, ReplacePlayerButton.getFont());
    if (ReplacePlayerButtonFont != null) ReplacePlayerButton.setFont(ReplacePlayerButtonFont);
    ReplacePlayerButton.setLabel("Replace Player");
    ReplacePlayerButton.setText("Replace Player");
    ManagementActionPanel.add(ReplacePlayerButton);
    AddPlayerPanel = new JPanel();
    AddPlayerPanel.setLayout(new BorderLayout(0, 0));
    MainPanel.add(AddPlayerPanel, "Card3");
    AddPlayerTopPanel = new JPanel();
    AddPlayerTopPanel.setLayout(new GridBagLayout());
    AddPlayerTopPanel.setAlignmentX(0.3f);
    AddPlayerPanel.add(AddPlayerTopPanel, BorderLayout.NORTH);
    AddPlayerLabel = new JLabel();
    Font AddPlayerLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 20, AddPlayerLabel.getFont());
    if (AddPlayerLabelFont != null) AddPlayerLabel.setFont(AddPlayerLabelFont);
    AddPlayerLabel.setHorizontalAlignment(0);
    AddPlayerLabel.setHorizontalTextPosition(0);
    AddPlayerLabel.setText("U10: Add player");
    GridBagConstraints gbc;
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    AddPlayerTopPanel.add(AddPlayerLabel, gbc);
    AddPlayerActionPanel = new JPanel();
    AddPlayerActionPanel.setLayout(new CardLayout(0, 0));
    AddPlayerPanel.add(AddPlayerActionPanel, BorderLayout.CENTER);
    AddSinglePanel = new JPanel();
    AddSinglePanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(8, 3, new Insets(0, 0, 0, 0), -1, -1));
    AddPlayerActionPanel.add(AddSinglePanel, "Card1");
    FirstNameLabel = new JLabel();
    Font FirstNameLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, FirstNameLabel.getFont());
    if (FirstNameLabelFont != null) FirstNameLabel.setFont(FirstNameLabelFont);
    FirstNameLabel.setText("First Name: ");
    AddSinglePanel.add(FirstNameLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    LastNameLabel = new JLabel();
    Font LastNameLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, LastNameLabel.getFont());
    if (LastNameLabelFont != null) LastNameLabel.setFont(LastNameLabelFont);
    LastNameLabel.setText("Last Name: ");
    AddSinglePanel.add(LastNameLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    DOBLabel = new JLabel();
    Font DOBLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, DOBLabel.getFont());
    if (DOBLabelFont != null) DOBLabel.setFont(DOBLabelFont);
    DOBLabel.setText("Date of Birth (YYYY-MM-DD): ");
    AddSinglePanel.add(DOBLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    PreferredPositionLabel = new JLabel();
    Font PreferredPositionLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, PreferredPositionLabel.getFont());
    if (PreferredPositionLabelFont != null)
      PreferredPositionLabel.setFont(PreferredPositionLabelFont);
    PreferredPositionLabel.setText("Preferred Position: ");
    AddSinglePanel.add(PreferredPositionLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    SkillLevelLabel = new JLabel();
    Font SkillLevelLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, SkillLevelLabel.getFont());
    if (SkillLevelLabelFont != null) SkillLevelLabel.setFont(SkillLevelLabelFont);
    SkillLevelLabel.setText("Skill Level: ");
    AddSinglePanel.add(SkillLevelLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    FNTextField = new JTextField();
    Font FNTextFieldFont = this.$$$getFont$$$("Courier New", Font.PLAIN, 16, FNTextField.getFont());
    if (FNTextFieldFont != null) FNTextField.setFont(FNTextFieldFont);
    AddSinglePanel.add(FNTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
    LNTextField = new JTextField();
    Font LNTextFieldFont = this.$$$getFont$$$("Courier New", Font.PLAIN, 16, LNTextField.getFont());
    if (LNTextFieldFont != null) LNTextField.setFont(LNTextFieldFont);
    AddSinglePanel.add(LNTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
    DOBTextField = new JTextField();
    Font DOBTextFieldFont = this.$$$getFont$$$("Courier New", Font.PLAIN, 16, DOBTextField.getFont());
    if (DOBTextFieldFont != null) DOBTextField.setFont(DOBTextFieldFont);
    AddSinglePanel.add(DOBTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
    PFComboBox = new JComboBox();
    AddSinglePanel.add(PFComboBox, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    SKComboBox = new JComboBox();
    AddSinglePanel.add(SKComboBox, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    AddSingleButton = new JButton();
    Font AddSingleButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, AddSingleButton.getFont());
    if (AddSingleButtonFont != null) AddSingleButton.setFont(AddSingleButtonFont);
    AddSingleButton.setLabel("Add Player");
    AddSingleButton.setText("Add Player");
    AddSinglePanel.add(AddSingleButton, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(130, 82), null, 0, false));
    AddPlayerCurrentScroll = new JScrollPane();
    AddSinglePanel.add(AddPlayerCurrentScroll, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    AddPlayerCurrentTextArea = new JTextArea();
    AddPlayerCurrentTextArea.setEditable(false);
    Font AddPlayerCurrentTextAreaFont = this.$$$getFont$$$("Courier New", Font.BOLD | Font.ITALIC, 16, AddPlayerCurrentTextArea.getFont());
    if (AddPlayerCurrentTextAreaFont != null)
      AddPlayerCurrentTextArea.setFont(AddPlayerCurrentTextAreaFont);
    AddPlayerCurrentTextArea.setText("No players prepared to be added.");
    AddPlayerCurrentScroll.setViewportView(AddPlayerCurrentTextArea);
    AddToTeamButton = new JButton();
    Font AddToTeamButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, AddToTeamButton.getFont());
    if (AddToTeamButtonFont != null) AddToTeamButton.setFont(AddToTeamButtonFont);
    AddToTeamButton.setText("Add To Team");
    AddSinglePanel.add(AddToTeamButton, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
    AddSinglePanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    AddPlayerCurrentLabel = new JLabel();
    Font AddPlayerCurrentLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, AddPlayerCurrentLabel.getFont());
    if (AddPlayerCurrentLabelFont != null) AddPlayerCurrentLabel.setFont(AddPlayerCurrentLabelFont);
    AddPlayerCurrentLabel.setText("Current Player List: \n");
    AddSinglePanel.add(AddPlayerCurrentLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
    AddSinglePanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
  }

  /**
   * @noinspection ALL
   */
  private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
    if (currentFont == null) return null;
    String resultName;
    if (fontName == null) {
      resultName = currentFont.getName();
    } else {
      Font testFont = new Font(fontName, Font.PLAIN, 10);
      if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
        resultName = fontName;
      } else {
        resultName = currentFont.getName();
      }
    }
    Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
    Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
    return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return MainPanel;
  }

}
