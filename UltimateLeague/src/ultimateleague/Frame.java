package ultimateleague;

import net.miginfocom.swing.MigLayout;
import ultimateleague.controller.*;
import ultimateleague.view.*;

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
    private DatabaseController mDatabaseController;




    public Frame(){
        mConstants = new Constants();
        this.setTitle(mConstants.TITLE_FRAME);
        this.setLayout(new MigLayout("debug, nocache, fill"));
        mDatabaseController = new DatabaseController();;
        mPanelCenter = new HomePane();
        initEast();
        initMenu();
        this.add(mPanelCenter, "grow");
    }

    private void initMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        JMenuItem helpItem = new JMenuItem("Help");
        JMenuItem aboutItem = new JMenuItem("About");

        /* File Menu Itmes */
        fileMenu.add(exitItem);

        /* Edit Menu Items */
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);

        /* Help Menu Items */
        helpMenu.add(aboutItem);
        helpMenu.add(helpItem);

        /* Main menu Items */
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
    }

    private void initEast(){
        JPanel panelEast = new JPanel();
        panelEast.setLayout(new MigLayout());
        JButton buttonHome = new JButton(mConstants.BUTTON_HOME);
        buttonHome.addActionListener(e -> {
            JPanel panel = new HomePane();
            updateCenter(panel);
        });

        JButton buttonPlayers = new JButton(mConstants.BUTTON_PLAYERS);
        buttonPlayers.addActionListener( e -> {
            JPanel panel = new PlayerPane(mDatabaseController, mConstants);
            updateCenter(panel);
        });
        JButton buttonReports = new JButton(mConstants.BUTTON_REPORTS);
        buttonReports.addActionListener(e -> {
            JPanel panel = new ReportPane();
            updateCenter(panel);
        });
        JButton buttonDraft = new JButton(mConstants.BUTTON_DRAFT);
        buttonDraft.addActionListener(e -> {
            JPanel panel = new DraftPane(mDatabaseController, mConstants);
            updateCenter(panel);
        });
        panelEast.add(buttonHome, "wrap, growx");
        panelEast.add(buttonReports, "wrap, growx");
        panelEast.add(buttonDraft, "wrap, growx");
        panelEast.add(buttonPlayers, "wrap, growx");
        add(panelEast, "west");
    }

    private void updateCenter(JPanel panel){
        this.remove(mPanelCenter);
        Dimension dim = this.getSize();
        mPanelCenter = panel;
        this.add(mPanelCenter, "grow");
        this.revalidate();
        this.pack();
        this.setSize(dim);
    }
}
