package us.richlandbombers.MusicSearch;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import com.gmail.bschneppdev.jvassister.util.ErrorReporter;

import us.richlandbombers.MusicSearch.gui.MTable;
import us.richlandbombers.MusicSearch.gui.OKBtn;

public class Program
{
    ////////////////////////////////////////////////////////////
    // REQUIRES JVASSISTER TO BUILD.
    ////////////////////////////////////////////////////////////

    private JFrame jf;
    private ProgramPanel data;
    private static JTabbedPane tabbedpane;
    private static int counter = 1;

    private Program()
    {
	this.jf = new JFrame("MusicSearch, written by Coders in the Community");
	this.data = new ProgramPanel();
	Program.tabbedpane = new JTabbedPane();
	Program.tabbedpane.add(data.getMainpanel(), "Search " + counter);
	this.jf.getContentPane().add(tabbedpane);
    }

    public static void addPage(ProgramPanel pnl)
    {
	Program.tabbedpane.add(pnl.getMainpanel(), "Search " + ++counter);
	Program.init(pnl);
    }

    private void init()
    {
	this.data.getMainpanel().removeAll();
	MTable table = new MTable();
	this.data.getCntpne().refresh();

	this.data.getMenu().add(data.getFile());
	this.data.getMenu().add(data.getEdit());
	this.data.getMenu().add(data.getFeatures());

	this.data.getContentPane().add(data.getCntpne());
	this.data.getContentPane().add(table);

	this.data.getMainpanel().add(data.getMenu(), BorderLayout.NORTH);
	this.data.getMainpanel().add(this.data.getContentPane(), BorderLayout.CENTER);
	this.data.getMainpanel().add(new OKBtn(), BorderLayout.SOUTH);
	this.jf.pack();
	this.jf.setVisible(true);
    }

    public static void init(ProgramPanel pnl)
    {
	pnl.removeAll();
	MTable table = new MTable();
	pnl.getCntpne().refresh();

	pnl.getMenu().add(pnl.getFile());
	pnl.getMenu().add(pnl.getEdit());
	pnl.getMenu().add(pnl.getFeatures());

	pnl.getContentPane().add(pnl.getCntpne());
	pnl.getContentPane().add(table);

	pnl.getMainpanel().add(pnl.getMenu(), BorderLayout.NORTH);
	pnl.getMainpanel().add(pnl.getContentPane(), BorderLayout.CENTER);
	pnl.getMainpanel().add(new OKBtn(), BorderLayout.SOUTH);
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
	return this.data.getMenu();
    }

    private void setTitleName(String newName)
    {
	this.jf.setName(newName);
    }
}
