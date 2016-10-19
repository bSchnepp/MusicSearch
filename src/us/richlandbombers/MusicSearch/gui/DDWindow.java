package us.richlandbombers.MusicSearch.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.gmail.bschneppdev.jvassister.util.ScreenSizeHandler;

@SuppressWarnings("serial")
public class DDWindow extends JPanel
{
    private JComboBox<String> btn;

    public DDWindow(String[] options)
    {
	super();	//Super is always our first call in Java.
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	this.btn = new JComboBox<String>(options);
	this.btn.setMaximumSize(new Dimension(ScreenSizeHandler.intWidth / 16, ScreenSizeHandler.intHeight / 16));
	this.btn.setSelectedIndex(0);
	this.btn.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		// TODO Auto-generated method stub
	    }
	});
	this.add(btn);
    }

    public DDWindow()
    {
	this(new String[]
	{
	        "Name", "Composer's First Name", "Composer's Last Name", "Difficulty", "Part", "Genre",
	        "Arranger's First Name", "Arranger's Last Name"
	});
    }
}
