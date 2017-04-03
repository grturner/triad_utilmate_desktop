package ultimateleague;

import javax.swing.*;
import java.awt.*;

/**
 * Created by grturner on 4/3/17.
 */
public class Frame extends JFrame {
    private Constants constants;
    private JPanel mPanelNorth;
    private JPanel mPanelEast;
    private JPanel mPanelWest;
    private JPanel mPanelSouth;
    private JPanel mPanelCenter;
    private JMenu mMenu;
    private JButton mButtonHome;
    private JButton mButtonPlayers;



    public Frame(){
        this.setTitle("Triad Area Ultimate");
        this.setLayout(new BorderLayout());
        constants = new Constants();
    }

    private void initEast(){
        mPanelEast = new JPanel();
        mPanelEast.setLayout(new GridLayout(1, 0));
        mButtonHome = new JButton(constants.HOMEBUTTON);
        mButtonHome.addActionListener(l -> {
            mPanelCenter = new HomePanel();
            mPanelCenter.invalidate();
        });
        mButtonPlayers = new JButton(constants.PLAYERSBUTTON);
        mPanelEast.add(mButtonPlayers);
        mButtonPlayers.addActionListener(l -> {
            mPanelCenter = new PlayerPanel();
            mPanelCenter.invalidate();
        });

    }
}
