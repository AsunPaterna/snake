
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author Asunción Paterna Capilla
 * @version v1.0
 * @see JPanel
 */
public class PlayerSelectScreen extends JPanel {

    JButton go;
    JButton quit;
    MainWindow mw;

    JRadioButton opt1;
    JRadioButton opt2;
    JRadioButton opt3;

    public void quitButtonActionListener() {
        mw.showCard("One");
    }

    public void goButtonActionListener() {
        playerOptions();
        mw.s4.setUpPlayers();
        mw.showCard("Three");
    }

    public void playerOptions() {
        int m = 5;
        if (opt1.isSelected() == true) {
            m = 1;
        } else if (opt2.isSelected() == true) {
            m = 2;
        } else if (opt3.isSelected() == true) {
            m = 3;
        }
        mw.s4.setMaxPlayers(m);
    }

    public PlayerSelectScreen(MainWindow mw) {
        this.mw = mw;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        // <editor-fold desc="Extracciones a una variable">> 
        final String select_Players_ = "Select Players: ";
        final String default_1Player = "Default: 1Player";
        final String _PlayerDefault = "1 Player(Default)";
        final String _2Players = "2 Players";
        final String _3Players = "3 Players";
        final ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                playerOptions();
            }
        };
        final ActionListener actionListener1 = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                goButtonActionListener();
            }
        };
        final ActionListener actionListener2 = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                quitButtonActionListener();
            }
        };
        // </editor-fold>   

        JLabel mess = new JLabel(select_Players_);
        add(mess);
        JLabel uc = new JLabel(default_1Player);
        add(uc);


        //set up radio buttons
        opt1 = new JRadioButton(_PlayerDefault);
        opt1.setSelected(true);
        opt2 = new JRadioButton(_2Players);
        opt3 = new JRadioButton(_3Players);

        ButtonGroup grp = new ButtonGroup();
        grp.add(opt1);
        grp.add(opt2);
        grp.add(opt3);

        add(opt1);
        add(opt2);
        add(opt3);

        opt1.addActionListener(actionListener);
        opt2.addActionListener(actionListener);
        opt3.addActionListener(actionListener);

        go = new JButton("Customize Board");
        quit = new JButton("Back");

        go.addActionListener(actionListener1);
        quit.addActionListener(actionListener2);

        add(go);
        add(quit);
    }
}
