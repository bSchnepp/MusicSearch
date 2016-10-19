package us.richlandbombers.MusicSearch.util;

public class Music
{
    private String name;
    private int lvl;
    private String firstNameComposer;
    private String lastNameComposer;

    private String firstNameArranger;
    private String lastNameArranger;

    private String genre;

    private String part;

    public Music(String name, int lvl, String firstNameComposer, String lastNameComposer, String firstNameArranger,
            String lastNameArranger, String part, String genre)
    {
	//TODO
	this.name = name;
	this.lvl = lvl;

	this.genre = genre;

	this.firstNameComposer = firstNameComposer;
	this.lastNameComposer = lastNameComposer;

	this.firstNameArranger = firstNameArranger;
	this.lastNameComposer = lastNameComposer;

	this.part = part;
    }
    
    

}
