package ultimateleague.view;

import net.miginfocom.swing.MigLayout;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ultimateleague.Constants;
import ultimateleague.controller.DatabaseController;
import ultimateleague.controller.TeamDraft;
import ultimateleague.model.DraftTeam;
import ultimateleague.model.Player;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Array;
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
        this.setLayout(new MigLayout("fill, debug"));
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
        this.add(header, "span, growx");
        this.add(lblTeamNum, "growx");
        this.add(txtTeamNum, "wrap, growx");
        this.add(btnGenTeam, "span, growx");
        btnGenTeam.addActionListener(actionEvent -> {
            int numTeams;
            numTeams = Integer.valueOf(txtTeamNum.getText());
            mPlayers = getPlayers(databaseController, constants);
            mDraftArbiter = new TeamDraft(mPlayers, numTeams);
            do {}
            while (!printToFile());

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

                rs = databaseController.getResults("SELECT Experience_Name FROM Knowledge " +
                        "WHERE Player_ID = " + player.getPlayerId() +";");
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
                players.add(player);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return players;
        }

    }

    private ArrayList<DraftTeam> makeDraft(){
        return mDraftArbiter.getTeams();
    }

    private void displayTeams(){
        ArrayList<DraftTeam> teams = mDraftArbiter.getTeams();
        for (int i = 0; i < teams.size(); i++){
            System.out.println(" ---Team " + String.valueOf(i + 1) + "---");
            System.out.println("Avg Score: " + String.valueOf(teams.get(i).getAvgRank()));
            ArrayList<Player> teamPlayers = teams.get(i).getTeamPlayers();
            for (Player player : teamPlayers){
                System.out.println(player.getFirstName() + ", " + player.getLastName() + " | Skill: " + player.getSkill());
            }
        }
    }

    private boolean printToFile(){
        boolean writeSuccess;
        JFileChooser fileChooser;
        int returnValue;
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        Row row;
        Cell cell;
        Header header;

        writeSuccess = false;
        fileChooser = new JFileChooser();
        returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION){
            ArrayList<DraftTeam> draftTeams;
            File selectedFile;

            draftTeams = makeDraft();
            selectedFile = fileChooser.getSelectedFile();
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet();
            int rowNum = 0;
            int colNum;
            int teamIterator = 1;
            header = sheet.getHeader();
            header.setLeft("Triad Area Ultimate League");
            header.setCenter("Team Draft Proposal");
            for (DraftTeam team : draftTeams) {
                row = sheet.createRow(rowNum++);
                colNum = 0;
                cell = row.createCell(colNum++);
                cell.setCellValue("Team " + String.valueOf(teamIterator++));
                ArrayList<Player> players = team.getTeamPlayers();
                row = sheet.createRow(rowNum++);
                colNum = 0;
                cell = row.createCell(colNum++);
                cell.setCellValue("Player ID");
                cell = row.createCell(colNum++);
                cell.setCellValue("Last Name");
                cell = row.createCell(colNum++);
                cell.setCellValue("First Name");
                cell = row.createCell(colNum);
                cell.setCellValue("Skill Rating");
                for (Player player: players){
                    row = sheet.createRow(rowNum++);
                    colNum = 0;
                    cell = row.createCell(colNum++);
                    cell.setCellValue(player.getPlayerId());
                    cell = row.createCell(colNum++);
                    cell.setCellValue(player.getLastName());
                    cell = row.createCell(colNum++);
                    cell.setCellValue(player.getFirstName());
                    cell = row.createCell(colNum);
                    cell.setCellValue(String.valueOf(player.getSkill()));
                }
                row = sheet.createRow(rowNum++);
                colNum = 0;
                cell = row.createCell(colNum++);
                cell.setCellValue("Average Skill:");
                cell = row.createCell(colNum);
                cell.setCellValue(Double.toString(team.getAvgRank()));
                sheet.createRow(rowNum++);
                sheet.createRow(rowNum++);
            }
            for (int x = 0; x < 4; x++) {
                sheet.autoSizeColumn(x);
            }

            try {
                FileOutputStream outputStream = new FileOutputStream(selectedFile);
                workbook.write(outputStream);
                writeSuccess = true;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return writeSuccess;
    }
}
