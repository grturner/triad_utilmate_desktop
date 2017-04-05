package ultimateleague;

import net.miginfocom.swing.MigLayout;
import ultimateleague.controller.DatabaseController;

import javax.swing.*;
import javax.swing.table.TableModel;


/**
 * Created by grturner on 4/3/17.
 */
public class PlayerPane extends JPanel {
    private JLabel mLabelHeader;
    private JTable mTable;

    public PlayerPane(DatabaseController databaseController, Constants constants){
        this.setLayout(new MigLayout());
        mLabelHeader = new JLabel(constants.LABEL_HEADER);
        this.add(mLabelHeader, "wrap");
        mTable = new JTable();

        this.add(mTable, "span 4 4 wrap");
    }

}
