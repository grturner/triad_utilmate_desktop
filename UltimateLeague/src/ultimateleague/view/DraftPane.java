package ultimateleague.view;

import net.miginfocom.swing.MigLayout;
import ultimateleague.Constants;
import ultimateleague.controller.DatabaseController;

import javax.swing.*;
import java.sql.DriverManager;

/**
 * Created by grturner on 4/6/2017.
 */
public class DraftPane extends JPanel {

    public DraftPane(DatabaseController databaseController, Constants constants){
        this.setLayout(new MigLayout());
        JLabel header = new JLabel(constants.DRAFT_HEADER);
        this.add(header, "span");

    }
}
