package ultimateleague.view;

import net.miginfocom.swing.MigLayout;
import ultimateleague.Constants;
import ultimateleague.controller.DatabaseController;
import ultimateleague.controller.TeamDraft;
import ultimateleague.model.DraftTeam;
import ultimateleague.model.Player;

import javax.swing.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by grturner on 4/6/2017.
 */
public class DraftPane extends JPanel {
    private ArrayList<Player> mPlayers;
    private TeamDraft mDraftArbiter;

    public DraftPane(DatabaseController databaseController, Constants constants){
        this.setLayout(new MigLayout("debug"));
        JLabel header;
        JLabel lblTeamNum;
        JFormattedTextField txtTeamNum;
        JButton btnGenTeam;
        NumberFormat numberFormat;

        numberFormat = NumberFormat.getIntegerInstance();
        numberFormat.setMaximumFractionDigits(0);
        lblTeamNum = new JLabel(constants.DRAFT_TEAM_NUM);
        header = new JLabel(constants.DRAFT_HEADER);
        txtTeamNum = new JFormattedTextField(numberFormat);
        btnGenTeam = new JButton(constants.DRAFT_GEN_BUTTON);
        this.add(header, "span, grow");
        this.add(lblTeamNum, "grow");
        this.add(txtTeamNum, "wrap, grow");
        this.add(btnGenTeam, "span, grow");
        mPlayers = getPlayers(databaseController, constants);
        btnGenTeam.addActionListener(actionEvent -> {
            int numTeams;
            numTeams = Integer.valueOf(txtTeamNum.getText());

        });
    }

    private ArrayList<Player> getPlayers(DatabaseController databaseController, Constants constants){
        ResultSet resultSet;
        ArrayList<Player> players;

        resultSet = databaseController.getResults(constants.DRAFT_QUERY);
        players = new ArrayList<>();
        try {
            while(resultSet.next()){
                Player player;
                player = new Player();
                int skill;
                ResultSet rs;
                String playerSkill = "";

                player.setPlayerId(resultSet.getString("Player_ID"));
                player.setFirstName(resultSet.getString("First_Name"));
                player.setLastName(resultSet.getString("Last_Name"));
                player.setEmail(resultSet.getString("Email_Address"));
                player.setPhone(resultSet.getString("Phone_Number"));
                player.setTeamId(resultSet.getString("Team_ID"));
                player.setBirthDate(resultSet.getDate("Birth_Date").toString());
                player.setTeamId(resultSet.getString("Team_ID"));
                player.setShirtSize(resultSet.getString("Tshirt_Size"));

                rs = databaseController.getResults("SELECT 'Experience_Name' FROM Knowledge " +
                        "WHERE Player_ID = '" + player.getPlayerId() +"';");
                if (rs.first()){
                    playerSkill = rs.getString("Experience_Name").toUpperCase();
                }

                switch (playerSkill){
                    case "NONE":
                        skill = 1;
                        break;
                    case "LIMITED RECREATION":
                        skill = 3;
                        break;
                    case "CLUB LEVEL":
                        skill = 5;
                        break;
                    case "ORGANIZED LEAGUE":
                        skill = 7;
                        break;
                    case "COLLEGE":
                        skill = 9;
                        break;
                    default:
                        skill = 0;
                        break;
                }

                player.setSkill(skill);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return players;
        }

    }

}
