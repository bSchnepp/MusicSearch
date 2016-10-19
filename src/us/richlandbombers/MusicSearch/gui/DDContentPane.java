package us.richlandbombers.MusicSearch.gui;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DDContentPane extends JPanel
{
    private ArrayList<DDWindow> list;

    public DDContentPane()
    {
	super();
	list = new ArrayList<DDWindow>();
	list.add(new DDWindow());
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void add(DDWindow list)
    {
	this.list.add(list);
	this.refresh();
    }

    public void refresh()
    {
	this.removeAll();
	Box box = new Box(BoxLayout.Y_AXIS);
	box.add(Box.createHorizontalGlue());
	box.add(Box.createVerticalGlue());
	for (DDWindow n : list)
	{
	    box.add(n);
	}
	box.add(Box.createVerticalGlue());
	box.add(Box.createHorizontalGlue());

	this.add(box);

    }
}
