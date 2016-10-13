package us.richlandbombers.MusicSearch;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class Program
{
    ////////////////////////////////////////////////////////////
    // REQUIRES JVASSISTER TO BUILD.
    ////////////////////////////////////////////////////////////

    private JFrame jf;
    private JPanel contentPane;	//Main content pane, where we stick tabs and stuff... we use the actual JFrame's content pane for other things.
                               //(This is to keep consistency between PC (Both Linux and BSD), Mac, and Wintel machines.

    private JMenu mainmenu;
    private JMenu submenu;

    private Program()
    {
	this.jf = new JFrame("MusicSearch, written by Coders in the Community");
	this.contentPane = new JPanel(new BorderLayout());

	this.mainmenu = new JMenu();
	this.submenu = new JMenu();
    }

    private void init()
    {
	this.jf.pack();
	this.jf.setLayout(new BorderLayout());
	this.jf.getContentPane().add(this.contentPane, BorderLayout.CENTER);
	this.jf.getContentPane().add(mainmenu, BorderLayout.NORTH);
	this.contentPane.add(submenu, BorderLayout.NORTH);
	this.jf.setVisible(true);
    }

    public void redraw()
    {
	//TODO -- update the pane with all of it's new content.
    }

    public static void main(String[] args)
    {
	Program pgrm = new Program();
	pgrm.init();
    }
}
