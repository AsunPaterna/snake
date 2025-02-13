
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Asunción Paterna Capilla
 * @version v1.0
 * @see JPanel
 */
public class WelcomeScreen extends JPanel {
// <editor-fold desc="Extracciones a constantes">> 

    private static final String SURE = "Are you sure?";
    private static final String TWO = "Two";
    private static final String NEWGAME = "New Game";
    private static final String QUIT = "Quit";
// </editor-fold>   
   
    JLabel title;
    JButton go;
    JButton quit;
    MainWindow mw;


    public void setTitle(String t) {
        title.setText(t);
    }

    public void quitButtonActionListener() {
        if (JOptionPane.showConfirmDialog(this, SURE) == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

    public void goButtonActionListener() {
        mw.showCard(TWO);
    }

    public WelcomeScreen(MainWindow mw) {
        this.mw = mw;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        title = new JLabel();
        add(title);

        //add formatting here
        go = new JButton(NEWGAME);
        quit = new JButton(QUIT);

        go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                goButtonActionListener();
            }
        });

        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                quitButtonActionListener();
            }
        });

        add(go);
        add(quit);
    }

}
