package us.richlandbombers.MusicSearch.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.gmail.bschneppdev.jvassister.basic.ArrayUtility;
import com.gmail.bschneppdev.jvassister.guibasic.DisplayMessage;

public class ErrorReporter
{
    public static void reportError(Exception e)
    {
	StringWriter sw = new StringWriter();
	e.printStackTrace(new PrintWriter(sw));
	String exceptionAsString = sw.toString();
	ArrayList<Object> lines = new ArrayList<Object>();
	Scanner emscnr = new Scanner(exceptionAsString);
	while (emscnr.hasNextLine())
	{
	    lines.add(emscnr.nextLine());
	}
	emscnr.close();
	String[] strln = (String[]) ArrayUtility.arrayListToArray(lines);
	StringBuilder finalString = new StringBuilder();
	for (String n : strln)
	{
	    finalString.append(n + "\n");
	}
	String[] finalMsg = new String[strln.length + 1];
	for (int i = 1; i < strln.length; i++)
	{
	    finalMsg[i] = strln[i];
	}
	finalMsg[0] = "An unexpected error occured, printing stack trace:";
	DisplayMessage.displayMessage(finalMsg);
	e.printStackTrace();	//Redundancy!!
    }
}
