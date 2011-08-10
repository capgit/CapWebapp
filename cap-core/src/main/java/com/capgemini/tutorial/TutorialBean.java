package com.capgemini.tutorial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanjin Cevro (Capgemini)
 *
 */
public class TutorialBean implements Serializable{

	/**
	 * Serial version UId for class.
	 */
	private static final long serialVersionUID = 2869098669503469876L;

	private static List<TutorialLink> tutorialLinks;
	
	static {
		tutorialLinks = new ArrayList<TutorialLink>();
		final TutorialLink link = new TutorialLink("JSF", "http://docs.jboss.org/richfaces/latest_4_0_X/Developer_Guide/en-US/html/", "Richfaces developer guide");
		final TutorialLink link2 = new TutorialLink("JSF", "http://sica.googlecode.com/svn-history/r145/trunk/Documentos/Materiales/Katz-Practical_RichFaces.pdf", "PDF bok om richfaces");
		final TutorialLink link3 = new TutorialLink("GIT", "http://blog.xkoder.com/2008/08/13/git-tutorial-starting-with-git-using-just-10-commands/", "Git tutorial, part I");
		final TutorialLink link4 = new TutorialLink("GIT", "http://blog.xkoder.com/2009/06/06/git-tutorial-part-ii-sharpen-you-git-fu-with-10-more-commands/", "Git tutorial, part II");
		
		tutorialLinks.add(link);
		tutorialLinks.add(link2);
		tutorialLinks.add(link3);
		tutorialLinks.add(link4);
	}


	/**
	 * @return the tutorialLinks
	 */
	public List<TutorialLink> getTutorialLinks() {
		return tutorialLinks;
	}


	
}
