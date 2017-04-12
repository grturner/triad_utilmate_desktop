package ultimateleague.view;

import net.miginfocom.swing.MigLayout;
import quick.dbtable.DBTable;
import ultimateleague.Constants;
import ultimateleague.controller.DatabaseController;
import ultimateleague.model.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;


/**
 * Created by grturner on 4/3/17.
 */
public class PlayerPane extends JPanel {
    private JLabel mLabelHeader;
    private JScrollPane mScrollPane;
    private DBTable mTable;

    public PlayerPane(DatabaseController databaseController, Constants constants){
        this.setLayout(new MigLayout("fill"));
        mLabelHeader = new JLabel(constants.PLAYER_HEADER);
        this.add(mLabelHeader, "span, growx");
        mScrollPane = new JScrollPane();
        ResultSet resultSet = databaseController.getResults("SELECT * FROM Players");
        mTable = new DBTable();
        try {
            mTable.refresh(resultSet);
        } catch (SQLException ex) {
            /* Do Something meaningful */
        }
        this.add(mTable, "grow");
    }

}
