package ultimateleague;

import ultimateleague.controller.DatabaseController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by grturner on 4/3/17.
 */
public class Frame extends JFrame {
    private Constants mConstants;
    private JPanel mPanelNorth;
    private JPanel mPanelEast;
    private JPanel mPanelWest;
    private JPanel mPanelSouth;
    private JPanel mPanelCenter;
    private JMenu mMenu;
    private JButton mButtonHome;
    private JButton mButtonPlayers;
    private JButton mButtonReports;
    private DatabaseController mDatabaseController;



    public Frame(){
        mConstants = new Constants();
        this.setTitle(mConstants.TITLE_FRAME);
        this.setLayout(new BorderLayout());
        mPanelCenter = new HomePane();
        this.add(mPanelCenter, BorderLayout.CENTER);
        mDatabaseController = new DatabaseController();
        initEast();
    }

    private void initEast(){
        Dimension buttonPrefDims = new Dimension(mConstants.DIM_BUTTON_EAST_W, mConstants.DIM_BUTTON_EAST_H);
        mPanelEast = new JPanel();
        mPanelEast.setLayout(new GridLayout(0, 1));
        mButtonHome = new JButton(mConstants.BUTTON_HOME);
        mButtonHome.setPreferredSize(buttonPrefDims);
        mButtonHome.setMaximumSize(buttonPrefDims);
        mPanelEast.add(mButtonHome);
        mButtonHome.addActionListener(e -> {
            mPanelCenter = new HomePane();
            updateCenter();
        });
        mButtonPlayers = new JButton(mConstants.BUTTON_PLAYERS);
        mButtonPlayers.setPreferredSize(buttonPrefDims);
        mButtonPlayers.setMaximumSize(buttonPrefDims);
        mPanelEast.add(mButtonPlayers);
        mButtonPlayers.addActionListener( e -> {
            mPanelCenter = new PlayerPane(mDatabaseController, mConstants);
            updateCenter();
        });
        mButtonReports = new JButton(mConstants.BUTTON_REPORTS);
        mButtonReports.setPreferredSize(buttonPrefDims);
        mButtonReports.setMaximumSize(buttonPrefDims);
        mPanelEast.add(mButtonReports);
        mButtonReports.addActionListener(e -> {
            mPanelCenter = new ReportPane();
            updateCenter();
        });
        this.add(mPanelEast, BorderLayout.WEST);
    }

    private void updateCenter(){
        this.add(mPanelCenter, BorderLayout.CENTER);
        mPanelCenter.revalidate();
    }
}
