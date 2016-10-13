package us.richlandbombers.MusicSearch.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class DDWindow extends JComboBox<String>
{
    public DDWindow(String[] options)
    {
	super(options);	//Super is always our first call in Java.
	this.setSelectedIndex(0);
	this.addActionListener(new ActionListener()
	{
	    //Anonymous class, TODO
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		// TODO Auto-generated method stub
	    }
	});
    }
}
