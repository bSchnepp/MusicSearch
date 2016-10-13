package us.richlandbombers.MusicSearch.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Content
{
    public String[][] file;

    public void read(File file)
    {
	//By default, we try to read list.mscc, if not found, we prompt user.
	//1st is name, 2nd is composer's name in quotes... so on.
	Scanner scanner = null; //bodge it
	try
	{
	    scanner = new Scanner(file);
	}
	catch (FileNotFoundException exception)
	{
	    exception.printStackTrace();
	}
	while (scanner.hasNextLine())
	{
	    try
	    {
		//TODO
		//TODO
		// Read and interpret!!!!
	    }
	    catch (NullPointerException e)
	    {
		ErrorReporter.reportError(e);
	    }
	}
	scanner.close();
    }

    public void read()
    {
	JFileChooser jfc = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("MusicSearch Compatible Formats", "mscc", "txt");
	jfc.setFileFilter(filter);
	int val = jfc.showOpenDialog(null);
	if (val == JFileChooser.APPROVE_OPTION)
	{
	    File file = jfc.getSelectedFile();
	    read(file);
	}
    }

    public void save(File folder, String name)
    {
	//Note that Java represents folders as files as well.
	File file = new File(folder.getAbsolutePath() + File.separatorChar + name);
	if (!file.exists())
	{
	    try
	    {
		file.createNewFile();
	    }
	    catch (IOException exception)
	    {
		exception.printStackTrace();
	    }
	}
	//TODO, bitwise overwrite (NOT APPEND).
    }

    public void save(File file)
    {
	this.save(file, "list.mscc");
    }

    public String[][] getContent()
    {
	return this.file;
    }
}
