package us.richlandbombers.MusicSearch;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import com.gmail.bschneppdev.jvassister.util.ErrorReporter;

import us.richlandbombers.MusicSearch.gui.DDContentPane;
import us.richlandbombers.MusicSearch.gui.DDWindow;
import us.richlandbombers.MusicSearch.gui.MTable;
import us.richlandbombers.MusicSearch.gui.OKBtn;

public class Program
{
    ////////////////////////////////////////////////////////////
    // REQUIRES JVASSISTER TO BUILD.
    ////////////////////////////////////////////////////////////

    private JFrame jf;
    private JPanel contentPane;	//Main content pane, where we stick tabs and stuff... we use the actual JFrame's content pane for other things.
                               //(This is to keep consistency between PC (Both Linux and BSD), Mac, and Wintel machines.

    private JPanel mainpanel;

    private JMenuBar menu;

    private JMenu file;
    private JMenu edit;
    private JMenu features;

    private DDContentPane cntpne;

    private JMenuItem addQuery;

    private Program()
    {
	this.jf = new JFrame("MusicSearch, written by Coders in the Community");
	this.contentPane = new JPanel();
	this.contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

	this.menu = new JMenuBar();

	this.file = new JMenu("File");
	this.edit = new JMenu("Edit");
	this.features = new JMenu("Features");

	this.addQuery = new JMenuItem("Add Query");

	this.addQuery.addActionListener(new ActionListener()
	{

	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		Program.this.add(new DDWindow());
	    }
	});
	this.features.add(addQuery);

	this.mainpanel = new JPanel();
	mainpanel.setLayout(new BorderLayout());
	mainpanel.add(menu, BorderLayout.NORTH);
	mainpanel.add(contentPane, BorderLayout.CENTER);
	this.jf.getContentPane().add(mainpanel);
	this.cntpne = new DDContentPane();
    }

    private void init()
    {
	this.mainpanel.removeAll();
	MTable table = new MTable();
	this.cntpne.refresh();

	this.menu.add(file);
	this.menu.add(edit);
	this.menu.add(features);

	this.contentPane.add(cntpne);
	this.contentPane.add(table);

	this.mainpanel.add(menu, BorderLayout.NORTH);
	this.mainpanel.add(this.contentPane, BorderLayout.CENTER);
	this.mainpanel.add(new OKBtn(), BorderLayout.SOUTH);
	this.jf.pack();
	this.jf.setVisible(true);
    }

    private void redraw()
    {
	//TODO -- update the pane with all of it's new content.
    }

    public void add(DDWindow wds)
    {
	this.cntpne.add(wds);
    }

    public static void main(String[] args)
    {
	for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
	{
	    if ("Nimbus".equals(info.getName()))
	    {
		try
		{
		    UIManager.setLookAndFeel(info.getClassName());
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException
		        | UnsupportedLookAndFeelException exception)
		{
		    ErrorReporter.reportError(exception);
		}
		break;
	    }
	}
	Program pgrm = new Program();
	pgrm.init();
    }

    private JMenuBar getSubMenu()
    {
	return this.menu;
    }

    private void setTitleName(String newName)
    {
	this.jf.setName(newName);
    }
}
