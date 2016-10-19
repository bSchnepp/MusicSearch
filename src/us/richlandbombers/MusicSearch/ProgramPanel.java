package us.richlandbombers.MusicSearch;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import us.richlandbombers.MusicSearch.gui.DDContentPane;
import us.richlandbombers.MusicSearch.gui.DDWindow;

@SuppressWarnings("serial")
public class ProgramPanel extends JPanel
{
    private JPanel contentPane;
    private JPanel mainpanel;
    private JMenuBar menu;
    private JMenu file;
    private JMenu edit;
    private JMenu features;
    private DDContentPane cntpne;
    private JMenuItem addQuery;
    private JMenuItem addSearcher;

    public ProgramPanel()
    {
	this.setContentPane(new JPanel());
	this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
	this.setMenu(new JMenuBar());

	this.setFile(new JMenu("File"));
	this.setEdit(new JMenu("Edit"));
	this.setFeatures(new JMenu("Features"));

	this.setAddQuery(new JMenuItem("Add Query"));
	this.addSearcher = new JMenuItem("Add Searcher");

	this.getAddQuery().addActionListener(new ActionListener()
	{

	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		ProgramPanel.this.add(new DDWindow());
	    }
	});

	this.addSearcher.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		Program.addPage(new ProgramPanel());
	    }
	});

	this.getFeatures().add(this.getAddQuery());
	this.getFeatures().add(this.addSearcher);

	this.setMainpanel(new JPanel());
	this.getMainpanel().setLayout(new BorderLayout());
	this.getMainpanel().add(this.getMenu(), BorderLayout.NORTH);
	this.getMainpanel().add(this.getContentPane(), BorderLayout.CENTER);
	this.setCntpne(new DDContentPane());
	this.add(contentPane);	//Legacy from refactoring, oh well, memory difference is basically nothing. Fix it later.
    }

    public void add(DDWindow wds)
    {
	this.cntpne.add(wds);
    }

    public JPanel getContentPane()
    {
	return contentPane;
    }

    public void setContentPane(JPanel contentPane)
    {
	this.contentPane = contentPane;
    }

    public JPanel getMainpanel()
    {
	return mainpanel;
    }

    public void setMainpanel(JPanel mainpanel)
    {
	this.mainpanel = mainpanel;
    }

    public JMenuBar getMenu()
    {
	return menu;
    }

    public void setMenu(JMenuBar menu)
    {
	this.menu = menu;
    }

    public JMenu getFile()
    {
	return file;
    }

    public void setFile(JMenu file)
    {
	this.file = file;
    }

    public JMenu getEdit()
    {
	return edit;
    }

    public void setEdit(JMenu edit)
    {
	this.edit = edit;
    }

    public JMenu getFeatures()
    {
	return features;
    }

    public void setFeatures(JMenu features)
    {
	this.features = features;
    }

    public DDContentPane getCntpne()
    {
	return cntpne;
    }

    public void setCntpne(DDContentPane cntpne)
    {
	this.cntpne = cntpne;
    }

    public JMenuItem getAddQuery()
    {
	return addQuery;
    }

    public void setAddQuery(JMenuItem addQuery)
    {
	this.addQuery = addQuery;
    }
}
