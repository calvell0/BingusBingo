package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import javax.swing.LayoutStyle.ComponentPlacement;

//TODO LIST
	//Reformat enabler menu: Instead of a menu for each
		//difficulty, place all challenges directly into
		//the enable/disable menu, with a JLabel header
		//showing the difficulty, and the corresponding
		//challenges below it.
		//STEPS:
			//Disable the easyMenu and others. They are JMenuItems.
			//Reroute all changes and additions to these (if any)
				//to the Enable/Disable Menu. 
					//IMPORTANT: YOU WILL
					//WANT TO REPLACE THE JMENU ENTIRELY!
					//USE JTABBEDPANE INSTEAD OF JMENU!!!
			//Add JLabels as Headers for difficulty. Probably
				//involves making additional GridLayouts or
				//JPanels. You will most likely want to do
				//this by setting the Menu's layout to GridLayout,
				//or GroupLayout, then adding GridLayouts into the panel.
				//Each will have a JLabel for Difficulty and 20 JCheckBoxes.
			//Add a JLabel to the top of the Enabler/Disabler menu
				//explaining instructions to user.
	//Add functionality to custom enablers
	//Add functionality to easy guarantees
	//Add functionality to medium guarantees
	//Add functionality to hard guarantees
	//Add functionality to custom guarantees

//HOW TO ADD NEW CHALLENGES TO THE EASY/MED/HARD POOLS:
	//Add a new JCheckBox declaration, with the first letter
		//of the difficulty (e,m,h,c). The areas for this
		//are near the top of the options class.
	//Initialize a new String containing the challenge to the String
		//array of the corresponding diffulty. They are located
		//at the very top of the Options class.
	//In the Options constructor, called public Options{}, find the
		//section of code with a comment on the top saying 
		//Initialize (difficulty)EnablerMenuButtons with the
		//corresponding difficulty of your challenge. Initialize
		//your challenge using the same format as the other
		//JCheckBoxes. You can just copy and paste the last one
		//and replace the number in the square brackets with the
		//number in the square brackets of the line above and add 1.
		//Then add your JCheckBoxes name, 
		//(first letter of difficulty)(number of challenge) ex)e21.
	//Add the JCheckBox to the menu of the corresponding difficulty
		//in the advancedOptionsEnablerMenu methods.
	//Copy and paste one of the action listeners from the same method.
		//Replace all instances of its JCheckBox name with your own
		//JCheckBox's name, and all numbers in square brackets with
		//the number you used in the square brackets a couple steps ago.
	//Save and run!

public class Options
{
	//Arrays
	public PossibleChallenges posChals;
	public CustChalBag customChallenges;
	public JCheckBox[] easyEnablerButtons;
	public JCheckBox[] medEnablerButtons;
	public JCheckBox[] hardEnablerButtons;
	public JCheckBox[] custEnablerButtons;
	public String[] easyChallenges = new String[] { 
			"Assassinate Patches", 
			"Acquire a legendary armament", 
			"Defeat an optional cave's boss", 							
			"Acquire a +3 flask",  										
			"Kill an NPC invader", 
			"Mix a Physick Flask with 2 tears", 
			"Craft 20 bone darts", 
			"Defeat the boss in the Soldier Of Godrick's Arena", 
			"Give the beast clergyman a deathroot", 
			"Embrace Fia", 												
			"Enter Stormveil Castle's main gate", 
			"Defeat the boss in Castle Morne", 
			"Defeat the boss outside of the Bestial Sanctum", 								
			"Defeat an Evergaol boss",  
			"Ride from Castle Morne to Liurnia without dismounting", 
			"Kill Blaidd", 
			"Alter a piece of armor", 									
			"Kill a turtle", 
			"Recieve an item from Albus the albinuric", 
			"Knock an enemy off their horse"};	

	public String[] medChallenges = new String[] {
			"Defeat a boss while over 100% equip load", 
			"Level up to 25 arcane", 								   
			"Upgrade a weapon to +15",
			"Use the memory of grace item with 10k+ runes", 
			"Defeat a boss using only ashes of war", 
			"Acquire 10 flasks",
			"Level up to 25 intelligence", 								
			"Level up to 25 faith", 
			"Equip 3 talismans at once", 
			"Kill 3 dragon bosses", 
			"Acquire a seal", 
			"Transpose a rememberance at the Finger-Reader Crone", 		
			"Defeat a gank boss", 
			"Defeat the boss in Fia's Champions' arena", 
			"Defeat a rememberance boss", 
			"Defeat a boss using powerstanced weapons",
			"Equip 2 armor pieces from the same set", 
			"Reach the Altus Plateau",
			"Obtain 3 Great Runes",
			"Defeat a boss without healing more than once"};
	public String[] hardChallenges = new String[] {
			"Acquire Mohg's Greatrune", 
			"Enter Liurnia", 											
			"Defeat Elden Beast", 
			"Enter Mohgwyn Palace",
			"Teleport to Faram Azula from the 4 Belfries", 
			"Defeat Malenia", 						
			"Defeat the boss in Dragonlord Placidusax's Arena", 
			"Equip 3 spells or incantations simultaneously", 
			"Burn the thorns from the Erdtree", 
			"Hard Challenge Placeholder 1",
			"Hard Challenge Placeholder 2",
			"Hard Challenge Placeholder 3",
			"Hard Challenge Placeholder 4",
			"Hard Challenge Placeholder 5",
			"Hard Challenge Placeholder 6",
			"Hard Challenge Placeholder 7",
			"Hard Challenge Placeholder 8",
			"Hard Challenge Placeholder 9",
			"Hard Challenge Placeholder 10",
			"Hard Challenge Placeholder 11"};
	public String[] nightmareChallenges = new String[] {
			"Embrace the 3 Fingers", 
			"Enter Elphael Brace of the Haligtree", 					
			"Defeat the boss in Malenia's Arena", 
			"Invert the Carian Study Hall", 
			"Enter the consecrated snowfield",
			"Defeat a boss without using your hands IRL",
			"Defeat a boss using only your fists",
			"Defeat a rememberance boss using inverted camera controls"
	};
	
	//Status fields
	private boolean easyOn;
	private boolean medOn;
	private boolean hardOn;
	private boolean nightmareOn;
	private boolean customOn;
	private long userSeed;
	private int dispEasyCount = 0;
	private int dispMedCount = 0;
	private int dispHardCount = 0;
	private int dispCustomCount = 0;
	private int dispTotalCount = 0;
	
	//JFrame element declarations
	private JFrame optionsFrame;
	private JPanel optionsTitlePanel;
	private JLabel optionsTitleLabel;
	
	private JPanel optionsTogglePanel;
	private JCheckBox easyToggle;
	private JCheckBox medToggle;
	private JCheckBox hardToggle;
	private JCheckBox nightmareToggle;
	private JCheckBox customToggle;
	private JLabel chalTally;
	
	private JPanel optionsSeedPanel;
	private JTextField optionsSeedTextField;
	private JButton optionsSeedConfirmButton;
	private JButton optionsSeedRandomButton;
	private JLabel optionsSeedMessage;
	private JLabel optionsSeedLog;
	
	private JPanel optionsStartPanel;
	private JButton optionsStartAdvancedButton;
	private JButton optionsStartAboutButton;
	private JButton optionsStartPlayButton;

	//Advanced Options Menu Declarations
		//Overall Window
	private JFrame advMenuFrame;
	private JTabbedPane advMenuTabbedPane;
	private JPanel advMenuEnablerPanel;
	private JPanel advMenuGuaranteePanel;
	private GridLayout advMenuEasyLayout;
	private GridLayout advMenuMedLayout;
	private GridLayout advMenuHardLayout;
	private GridLayout advMenuCustLayout;
		//Enabler Menu Window
	private JPanel advMenuEnablerMessagePanel;
	private JLabel advMenuEnablerMessage;
	private GroupLayout advMenuEnablerLayout;
	private JLabel advMenuEnablerEasyLabel;		
	private JLabel advMenuEnablerMedLabel;
	private JLabel advMenuEnablerHardLabel;
	private JLabel advMenuEnablerCustLabel;
	private JCheckBox advMenuEnablerEasyCheckBox;
	private JCheckBox advMenuEnablerMedCheckBox;
	private JCheckBox advMenuEnablerHardCheckBox;
	private JCheckBox advMenuEnablerCustCheckBox;
	private JPanel advMenuEnablerEasyTopPanel;	
	private JPanel advMenuEnablerMedTopPanel;
	private JPanel advMenuEnablerHardTopPanel;
	private JPanel advMenuEnablerCustTopPanel;
	private GroupLayout advMenuEnablerEasyTopLayout;
	private GroupLayout advMenuEnablerMedTopLayout;
	private GroupLayout advMenuEnablerHardTopLayout;
	private GroupLayout advMenuEnablerCustTopLayout;
	private JPanel advMenuEnablerEasyPanel;
	private JPanel advMenuEnablerMedPanel;
	private JPanel advMenuEnablerHardPanel;
	private JPanel advMenuEnablerCustPanel;

	// easyMenu button declarations
	private JCheckBox e1;
	private JCheckBox e2;
	private JCheckBox e3;
	private JCheckBox e4;
	private JCheckBox e5;
	private JCheckBox e6;
	private JCheckBox e7;
	private JCheckBox e8;
	private JCheckBox e9;
	private JCheckBox e10;
	private JCheckBox e11;
	private JCheckBox e12;
	private JCheckBox e13;
	private JCheckBox e14;
	private JCheckBox e15;
	private JCheckBox e16;
	private JCheckBox e17;
	private JCheckBox e18;
	private JCheckBox e19;
	private JCheckBox e20;

	//medMenu button declarations
	private JCheckBox m1;
	private JCheckBox m2;
	private JCheckBox m3;
	private JCheckBox m4;
	private JCheckBox m5;
	private JCheckBox m6;
	private JCheckBox m7;
	private JCheckBox m8;
	private JCheckBox m9;
	private JCheckBox m10;
	private JCheckBox m11;
	private JCheckBox m12;
	private JCheckBox m13;
	private JCheckBox m14;
	private JCheckBox m15;
	private JCheckBox m16;
	private JCheckBox m17;
	private JCheckBox m18;
	private JCheckBox m19;
	private JCheckBox m20;
	
	//hardMenu button declarations
	private JCheckBox h1;
	private JCheckBox h2;
	private JCheckBox h3;
	private JCheckBox h4;
	private JCheckBox h5;
	private JCheckBox h6;
	private JCheckBox h7;
	private JCheckBox h8;
	private JCheckBox h9;
	private JCheckBox h10;
	private JCheckBox h11;
	private JCheckBox h12;
	private JCheckBox h13;
	private JCheckBox h14;
	private JCheckBox h15;
	private JCheckBox h16;
	private JCheckBox h17;
	private JCheckBox h18;
	private JCheckBox h19;
	private JCheckBox h20;

	//custMenu button declarations
	private JCheckBox c1;
	private JCheckBox c2;
	private JCheckBox c3;
	private JCheckBox c4;
	private JCheckBox c5;
	private JCheckBox c6;
	private JCheckBox c7;
	private JCheckBox c8;
	private JCheckBox c9;
	private JCheckBox c10;
	private JCheckBox c11;
	private JCheckBox c12;
	private JCheckBox c13;
	private JCheckBox c14;
	private JCheckBox c15;
	private JCheckBox c16;
	private JCheckBox c17;
	private JCheckBox c18;
	private JCheckBox c19;
	private JCheckBox c20;

	public Options()
	{
		//Initializers for bags
		initPossibleChallenges();
		customChallenges = new CustChalBag();
		
		//Initializers for booleans
		System.out.println("easyOn = " + easyOn);
		System.out.println("medOn = " + medOn);
		System.out.println("hardOn = " + hardOn);
		System.out.println("customOn = " + customOn);
		System.out.println("-----------------------");
		easyOn = false;
		medOn = false;
		hardOn = false;
		nightmareOn = false;
		customOn = false;
		
		//Initialize easyEnabler menu buttons, add them to
		//JCheckBox array easyEnablerButtons, the set them all
		//to true by default on program startup.
		e1 = new JCheckBox(easyChallenges[0]);
        e2 = new JCheckBox(easyChallenges[1]);
        e3 = new JCheckBox(easyChallenges[2]);
        e4 = new JCheckBox(easyChallenges[3]);
        e5 = new JCheckBox(easyChallenges[4]);
        e6 = new JCheckBox(easyChallenges[5]);
        e7 = new JCheckBox(easyChallenges[6]);
        e8 = new JCheckBox(easyChallenges[7]);
        e9 = new JCheckBox(easyChallenges[8]);
        e10 = new JCheckBox(easyChallenges[9]);
        e11 = new JCheckBox(easyChallenges[10]);
        e12 = new JCheckBox(easyChallenges[11]);
        e13 = new JCheckBox(easyChallenges[12]);
        e14 = new JCheckBox(easyChallenges[13]);
        e15 = new JCheckBox(easyChallenges[14]);
        e16 = new JCheckBox(easyChallenges[15]);
        e17 = new JCheckBox(easyChallenges[16]);
        e18 = new JCheckBox(easyChallenges[17]);
        e19 = new JCheckBox(easyChallenges[18]);
        e20 = new JCheckBox(easyChallenges[19]);
		easyEnablerButtons = new JCheckBox[] {
			e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, 
			e15, e16, e17, e18, e19, e20};
		for (int q = 0; q < easyEnablerButtons.length; q++)
		{
			easyEnablerButtons[q].setSelected(true);
		}

		//Initialize medEnabler menu buttons, add them to
		//JCheckBox array medEnablerButtons, the set them all
		//to true by default on program startup.
		m1 = new JCheckBox(medChallenges[0]);
        m2 = new JCheckBox(medChallenges[1]);
        m3 = new JCheckBox(medChallenges[2]);
        m4 = new JCheckBox(medChallenges[3]);
        m5 = new JCheckBox(medChallenges[4]);
        m6 = new JCheckBox(medChallenges[5]);
        m7 = new JCheckBox(medChallenges[6]);
        m8 = new JCheckBox(medChallenges[7]);
        m9 = new JCheckBox(medChallenges[8]);
        m10 = new JCheckBox(medChallenges[9]);
        m11 = new JCheckBox(medChallenges[10]);
        m12 = new JCheckBox(medChallenges[11]);
        m13 = new JCheckBox(medChallenges[12]);
        m14 = new JCheckBox(medChallenges[13]);
        m15 = new JCheckBox(medChallenges[14]);
        m16 = new JCheckBox(medChallenges[15]);
        m17 = new JCheckBox(medChallenges[16]);
        m18 = new JCheckBox(medChallenges[17]);
        m19 = new JCheckBox(medChallenges[18]);
        m20 = new JCheckBox(medChallenges[19]);
		medEnablerButtons = new JCheckBox[] {
			m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, 
			m15, m16, m17, m18, m19, m20};
		for (int q = 0; q < medEnablerButtons.length; q++)
		{
			medEnablerButtons[q].setSelected(true);
		}
		
		//Initialize hardEnabler menu buttons, add them to
		//JCheckBox array hardEnablerButtons, the set them all
		//to true by default on program startup.
		h1 = new JCheckBox(hardChallenges[0]);
        h2 = new JCheckBox(hardChallenges[1]);
        h3 = new JCheckBox(hardChallenges[2]);
        h4 = new JCheckBox(hardChallenges[3]);
        h5 = new JCheckBox(hardChallenges[4]);
        h6 = new JCheckBox(hardChallenges[5]);
        h7 = new JCheckBox(hardChallenges[6]);
        h8 = new JCheckBox(hardChallenges[7]);
        h9 = new JCheckBox(hardChallenges[8]);
        h10 = new JCheckBox(hardChallenges[9]);
        h11 = new JCheckBox(hardChallenges[10]);
        h12 = new JCheckBox(hardChallenges[11]);
        h13 = new JCheckBox(hardChallenges[12]);
        h14 = new JCheckBox(hardChallenges[13]);
        h15 = new JCheckBox(hardChallenges[14]);
        h16 = new JCheckBox(hardChallenges[15]);
        h17 = new JCheckBox(hardChallenges[16]);
        h18 = new JCheckBox(hardChallenges[17]);
        h19 = new JCheckBox(hardChallenges[18]);
        h20 = new JCheckBox(hardChallenges[19]);
		hardEnablerButtons = new JCheckBox[] {
			h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14, 
			h15, h16, h17, h18, h19, h20};
		for (int q = 0; q < hardEnablerButtons.length; q++)
		{
			hardEnablerButtons[q].setSelected(true);
		}

		//OPTIONS frame
		optionsFrame = new JFrame();
		optionsFrame.setSize(800,300);
		optionsFrame.setLocation(200,200);
		optionsFrame.setVisible(true);
		optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		optionsFrame.setTitle("Elden Ring Randomizer Bingo");
		
		//Options TITLE  panel
		optionsTitlePanel = new JPanel();
		optionsTitlePanel.setBackground(Color.CYAN);
		optionsFrame.add(optionsTitlePanel, BorderLayout.PAGE_START);
		optionsTitleLabel = new JLabel();
		optionsTitleLabel.setText("Options");
		optionsTitlePanel.add(optionsTitleLabel);

		//Options TOGGLE panel
		optionsTogglePanel = new JPanel();
		optionsFrame.add(optionsTogglePanel, BorderLayout.LINE_START);
		easyToggle = new JCheckBox("Enable Easy Challenges");
		medToggle = new JCheckBox("Enable Med Challenges");
		hardToggle = new JCheckBox("Enable Hard Challenges");
		nightmareToggle = new JCheckBox("ENABLE NIGHTMARES");
		customToggle = new JCheckBox("Enable Custom Challenges");
		chalTally = new JLabel("(Challenges Enabled: " + posChals.size() + ")");
		GroupLayout toggleLayout = new GroupLayout(optionsTogglePanel);
		optionsTogglePanel.setLayout(toggleLayout);
		toggleLayout.setAutoCreateGaps(true);
		toggleLayout.setAutoCreateContainerGaps(true);
		toggleLayout.setHorizontalGroup(
				toggleLayout.createSequentialGroup()
					.addGroup(toggleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(easyToggle)
							.addComponent(medToggle)
							.addComponent(hardToggle)
							.addComponent(customToggle)
							.addComponent(nightmareToggle)
							.addComponent(chalTally))
		);
		toggleLayout.setVerticalGroup(
				toggleLayout.createSequentialGroup()
					.addComponent(easyToggle)
					.addComponent(medToggle)
					.addComponent(hardToggle)
					.addComponent(customToggle)
					.addComponent(nightmareToggle)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(chalTally)
		);
		
		this.easyToggle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (easyToggle.isSelected() == true)
				{
					advMenuEnablerEasyCheckBox.setSelected(true);
				}
				else if (easyToggle.isSelected() == false)
				{
					advMenuEnablerEasyCheckBox.setSelected(false);
				}
				if (easyOn == false)
				{
					for (int i = 0; i < easyChallenges.length; i++)
					{
						if (easyEnablerButtons[i].isSelected() == true)
						{
							posChals.add(easyChallenges[i]);
						}
					}
					easyOn = true;
					dispEasyCount = 0;
					for (int p = 0; p < easyEnablerButtons.length; p++)
					{
						dispEasyCount += (posChals.countOccurences(easyChallenges[p]));
					}
					optionsSeedMessage.setText("Enabled " + dispEasyCount + " easy challenges.");
					dispEasyCount = 0;
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("easyOn set to: " + easyOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
				else
				{
					dispEasyCount = 0;
					for (int p = 0; p < easyEnablerButtons.length; p++)
					{
						dispEasyCount += (posChals.countOccurences(easyChallenges[p]));
					}
					optionsSeedMessage.setText("Removed " + dispEasyCount + " easy challenges.");
					for (int i = 0; i < easyChallenges.length; i++)
					{
						if (easyEnablerButtons[i].isSelected() == true)
						{
							posChals.remove(easyChallenges[i]);
						}
					}
					easyOn = false;
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("easyOn set to: " + easyOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
			}
		});
		this.medToggle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (medToggle.isSelected() == true)
				{
					advMenuEnablerMedCheckBox.setSelected(true);
				}
				else if (medToggle.isSelected() == false)
				{
					advMenuEnablerMedCheckBox.setSelected(false);
				}
				if (medOn == false)
				{
					for (int i = 0; i < medChallenges.length; i++)
					{
						if (medEnablerButtons[i].isSelected() == true)
						{
							posChals.add(medChallenges[i]);
						}
					}
					medOn = true;
					dispMedCount = 0;
					for (int p = 0; p < medEnablerButtons.length; p++)
					{
						if (posChals.countOccurences(medChallenges[p]) > 0)
						{
							dispMedCount++;
						}
					}
					optionsSeedMessage.setText("Enabled " + dispMedCount + " med challenges.");
					dispMedCount = 0;
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("medOn set to: " + medOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
				else
				{
					dispMedCount = 0;
					for (int p = 0; p < medEnablerButtons.length; p++)
					{
						if (posChals.countOccurences(medChallenges[p]) > 0)
						{
							dispMedCount++;
						}
					}
					optionsSeedMessage.setText("Removed " + dispMedCount + " med challenges.");
					dispMedCount = 0;
					for (int i = 0; i < medChallenges.length; i++)
					{
						if (medEnablerButtons[i].isSelected() == true)
						{
							posChals.remove(medChallenges[i]);
						}
					}
					medOn = false;
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("medOn set to: " + medOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
			}
		});
		this.hardToggle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (hardToggle.isSelected() == true)
				{
					advMenuEnablerHardCheckBox.setSelected(true);
				}
				else if (hardToggle.isSelected() == false)
				{
					advMenuEnablerHardCheckBox.setSelected(false);
				}
				if (hardOn == false)
				{
					for (int i = 0; i < hardChallenges.length; i++)
					{
						if (hardEnablerButtons[i].isSelected() == true)
						{
							posChals.add(hardChallenges[i]);
						}
					}
					hardOn = true;
					dispHardCount = 0;
					for (int p = 0; p < hardEnablerButtons.length; p++)
					{
						if (posChals.countOccurences(hardChallenges[p]) > 0)
						{
							dispHardCount++;
						}
					}
					optionsSeedMessage.setText("Enabled " + dispHardCount + " hard challenges.");
					dispHardCount = 0;
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("hardOn set to: " + hardOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
				else
				{
					dispHardCount = 0;
					for (int p = 0; p < hardEnablerButtons.length; p++)
					{
						if (posChals.countOccurences(hardChallenges[p]) > 0)
						{
							dispHardCount++;
						}
					}
					optionsSeedMessage.setText("Removed " + dispHardCount + " hard challenges.");
					dispHardCount = 0;
					for (int i = 0; i < hardChallenges.length; i++)
					{
						if (hardEnablerButtons[i].isSelected() == true)
						{
							posChals.remove(hardChallenges[i]);
						}
					}
					hardOn = false;
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("hardOn set to: " + hardOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
			}
		});
		this.customToggle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (customOn == false)
				{
					posChals.addAll(customChallenges);
					customOn = true;
					optionsSeedMessage.setText("Enabled " + customChallenges.size() + " custom challenges.");
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("customOn set to: " + customOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
				else
				{
					for (int i = 0; i < customChallenges.size(); i++)
					{
						posChals.remove(customChallenges.getData(i));
					}
					customOn = false;
					optionsSeedMessage.setText("Disabled " + customChallenges.size() + " custom challenges.");
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("customOn set to: " + customOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
			}
		});
		this.nightmareToggle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (nightmareOn == false)
				{
					for (int i = 0; i < nightmareChallenges.length; i++)
					{
						posChals.add(nightmareChallenges[i]);
					}
					nightmareOn = true;
					optionsSeedMessage.setText("NIGHTMARES ENABLED.");
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					optionsStartPlayButton.setText("GOOD NIGHT GOOD LUCK");
					optionsStartPlayButton.setFont(new Font("Dialogue", Font.BOLD, 12));
					System.out.println("nightmareOn set to: " + nightmareOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
				else
				{
					for (int i = 0; i < nightmareChallenges.length; i++)
					{
						posChals.remove(nightmareChallenges[i]);
					}
					nightmareOn = false;
					optionsSeedMessage.setText("You live another day...");
					optionsStartPlayButton.setText("Play!");
					optionsStartPlayButton.setFont(new Font("Dialogue", Font.BOLD, 12));
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("nightmareOn set to: " + customOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
			}
		});
	
		//Options SEED panel.
		optionsSeedPanel = new JPanel();
		optionsFrame.add(optionsSeedPanel, BorderLayout.CENTER);
		optionsSeedTextField = new JTextField("Enter Custom Seed");
		optionsSeedConfirmButton = new JButton("Confirm Seed");
		optionsSeedRandomButton = new JButton("Randomize Seed");
		optionsSeedMessage = new JLabel(" ");
		optionsSeedLog = new JLabel(" ");
		GroupLayout seedLayout = new GroupLayout(optionsSeedPanel);
		optionsSeedPanel.setLayout(seedLayout);
		seedLayout.setAutoCreateGaps(true);
		seedLayout.setAutoCreateContainerGaps(true);
		seedLayout.setHorizontalGroup(
				seedLayout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
					.addComponent(optionsSeedTextField, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(seedLayout.createSequentialGroup()
							.addComponent(optionsSeedRandomButton, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(optionsSeedConfirmButton, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addComponent(optionsSeedMessage)
					.addComponent(optionsSeedLog)
		);
		seedLayout.setVerticalGroup(
				seedLayout.createSequentialGroup()
					.addComponent(optionsSeedTextField, 30, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(seedLayout.createParallelGroup(GroupLayout.Alignment.LEADING, true)						
							.addComponent(optionsSeedRandomButton) 														
							.addComponent(optionsSeedConfirmButton))
					.addComponent(optionsSeedMessage)
					.addComponent(optionsSeedLog)
		);
		
		this.optionsSeedConfirmButton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		try
        		{
        			String seedString = optionsSeedTextField.getText();
        			setSeed(Long.parseLong(seedString));
					optionsSeedMessage.setText("Seed Confirmed!");
					optionsSeedLog.setText("Current Seed: " + userSeed);
        		}
        		catch (NumberFormatException z)
        		{
        			System.out.println("Seed is invalid.\nMaintaining previous seed: "
        									+ userSeed);
					optionsSeedMessage.setText("ERROR: Invalid seed. Maintaining previous seed.");
					optionsSeedLog.setText("Current Seed: " + userSeed);
        		}
        	}
        });
		this.optionsSeedRandomButton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		Random r = new Random();
        		long j = r.nextLong();
        		String s = String.valueOf(j);
        		optionsSeedTextField.setText(s);
				optionsSeedMessage.setText("Generated a random seed. Click confirm to apply.");
				optionsSeedLog.setText("Current Seed: " + userSeed);
        	}
        });

		//Options START Panel
		optionsStartPanel = new JPanel();
		optionsFrame.add(optionsStartPanel, BorderLayout.LINE_END);
		optionsStartAdvancedButton = new JButton("Advanced Settings");
		optionsStartAboutButton = new JButton("About");
		optionsStartPlayButton = new JButton("PLAY!");
		GroupLayout startLayout = new GroupLayout(optionsStartPanel);
		optionsStartPanel.setLayout(startLayout);
		startLayout.setAutoCreateGaps(true);
		startLayout.setAutoCreateContainerGaps(true);
		startLayout.setHorizontalGroup(
				startLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(optionsStartAdvancedButton, 200, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(optionsStartAboutButton, 200, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(optionsStartPlayButton, 200, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		startLayout.setVerticalGroup(
				startLayout.createSequentialGroup()
					.addComponent(optionsStartAdvancedButton)
					.addComponent(optionsStartAboutButton)
					.addComponent(optionsStartPlayButton, 60, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);

		this.optionsStartAdvancedButton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		openAdvancedOptions();
        	}
        });
	}

	public long getSeed()
	{
		return userSeed;
	}
	
	public void setSeed(long newSeed)
	{
		userSeed = newSeed;
		System.out.println("A new seed was set: " + userSeed);
	}
	
	public void initPossibleChallenges()
	{
		posChals = new PossibleChallenges();
	}

	public void openAdvancedOptions()
	{
		//Creates the Advanced Options Window and displays it.
		advMenuFrame = new JFrame();
		advMenuTabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
		advMenuFrame.add(advMenuTabbedPane);
		advMenuEnablerPanel = new JPanel();
		advMenuGuaranteePanel = new JPanel();
		advMenuTabbedPane.add("[ENABLE/DISABLE CHALLENGES]", advMenuEnablerPanel);
		advMenuTabbedPane.add("[GUARANTEE CHALLENGES]", advMenuGuaranteePanel);
		advMenuFrame.setSize(1000,1000);
		advMenuFrame.setLocation(100,100);
        advMenuFrame.setVisible(true);
		advMenuEasyLayout = new GridLayout(5, 4);
		advMenuMedLayout = new GridLayout(5, 4);
		advMenuHardLayout = new GridLayout(5, 4);
		advMenuCustLayout = new GridLayout(5, 4);

		//Creates and formats the Enabler/Disabler Menu Window
		advMenuEnablerMessagePanel = new JPanel();
		advMenuEnablerMessage = new JLabel("Select Challenges to add or remove them" + 
											" from their respective challenge pools.");
		advMenuEnablerMessagePanel.add(advMenuEnablerMessage, BorderLayout.CENTER);
		advMenuEnablerMessagePanel.setBackground(Color.CYAN);
		advMenuEnablerMessagePanel.setMinimumSize(new Dimension(50, 25));
		advMenuEnablerMessagePanel.setPreferredSize(new Dimension(50, 25));
		advMenuEnablerMessagePanel.setMaximumSize(new Dimension(Short.MAX_VALUE,
                                  Short.MAX_VALUE));
		advMenuEnablerCustLabel = new JLabel("Custom Challenges");
		advMenuEnablerCustPanel = new JPanel();
			//EASY SECTION
		advMenuEnablerEasyLabel = new JLabel("[Easy Challenges]");
		advMenuEnablerEasyCheckBox = new JCheckBox("Enable Easy Challenges");
		advMenuEnablerEasyTopPanel = new JPanel();
		advMenuEnablerEasyTopPanel.setMinimumSize(new Dimension(50, 35));
		advMenuEnablerEasyTopPanel.setPreferredSize(new Dimension(50, 35));
		advMenuEnablerEasyTopPanel.setMaximumSize(new Dimension(Short.MAX_VALUE,
                                  Short.MAX_VALUE));
		advMenuEnablerEasyTopLayout = new GroupLayout(advMenuEnablerEasyTopPanel);
		advMenuEnablerEasyTopPanel.setLayout(advMenuEnablerEasyTopLayout);
		advMenuEnablerEasyTopLayout.setAutoCreateGaps(true);
		advMenuEnablerEasyTopLayout.setAutoCreateContainerGaps(true);
		advMenuEnablerEasyTopLayout.setHorizontalGroup(
			advMenuEnablerEasyTopLayout.createSequentialGroup()
					.addComponent(advMenuEnablerEasyLabel)
					.addComponent(advMenuEnablerEasyCheckBox)
		);
		advMenuEnablerEasyTopLayout.setVerticalGroup(
			advMenuEnablerEasyTopLayout.createSequentialGroup()
					.addGroup(advMenuEnablerEasyTopLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(advMenuEnablerEasyLabel)
							.addComponent(advMenuEnablerEasyCheckBox))
		);
		advMenuEnablerEasyPanel = new JPanel();
		advMenuEnablerEasyPanel.setLayout(advMenuEasyLayout);
		openAdvancedEasyEnablerMenu();	
			//MEDIUM SECTION
		advMenuEnablerMedLabel = new JLabel("[Medium Challenges]");
		advMenuEnablerMedCheckBox = new JCheckBox("Enable Medium Challenges");
		advMenuEnablerMedTopPanel = new JPanel();
		advMenuEnablerMedTopPanel.setMinimumSize(new Dimension(50, 35));
		advMenuEnablerMedTopPanel.setPreferredSize(new Dimension(50, 35));
		advMenuEnablerMedTopPanel.setMaximumSize(new Dimension(Short.MAX_VALUE,
								  Short.MAX_VALUE));
		advMenuEnablerMedTopLayout = new GroupLayout(advMenuEnablerMedTopPanel);
		advMenuEnablerMedTopPanel.setLayout(advMenuEnablerMedTopLayout);
		advMenuEnablerMedTopLayout.setAutoCreateGaps(true);
		advMenuEnablerMedTopLayout.setAutoCreateContainerGaps(true);
		advMenuEnablerMedTopLayout.setHorizontalGroup(
			advMenuEnablerMedTopLayout.createSequentialGroup()
					.addComponent(advMenuEnablerMedLabel)
					.addComponent(advMenuEnablerMedCheckBox)
		);
		advMenuEnablerMedTopLayout.setVerticalGroup(
			advMenuEnablerMedTopLayout.createSequentialGroup()
					.addGroup(advMenuEnablerMedTopLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(advMenuEnablerMedLabel)
							.addComponent(advMenuEnablerMedCheckBox))
		);
		advMenuEnablerMedPanel = new JPanel();
		advMenuEnablerMedPanel.setLayout(advMenuMedLayout);
		openAdvancedMedEnablerMenu();	
			//HARD SECTION
		advMenuEnablerHardLabel = new JLabel("[Hard Challenges]");
		advMenuEnablerHardCheckBox = new JCheckBox("Enable Hard Challenges");
		advMenuEnablerHardTopPanel = new JPanel();
		advMenuEnablerHardTopPanel.setMinimumSize(new Dimension(50, 35));
		advMenuEnablerHardTopPanel.setPreferredSize(new Dimension(50, 35));
		advMenuEnablerHardTopPanel.setMaximumSize(new Dimension(Short.MAX_VALUE,
								  Short.MAX_VALUE));
		advMenuEnablerHardTopLayout = new GroupLayout(advMenuEnablerHardTopPanel);
		advMenuEnablerHardTopPanel.setLayout(advMenuEnablerHardTopLayout);
		advMenuEnablerHardTopLayout.setAutoCreateGaps(true);
		advMenuEnablerHardTopLayout.setAutoCreateContainerGaps(true);
		advMenuEnablerHardTopLayout.setHorizontalGroup(
			advMenuEnablerHardTopLayout.createSequentialGroup()
					.addComponent(advMenuEnablerHardLabel)
					.addComponent(advMenuEnablerHardCheckBox)
		);
		advMenuEnablerHardTopLayout.setVerticalGroup(
			advMenuEnablerHardTopLayout.createSequentialGroup()
					.addGroup(advMenuEnablerHardTopLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(advMenuEnablerHardLabel)
							.addComponent(advMenuEnablerHardCheckBox))
		);
		advMenuEnablerHardPanel = new JPanel();
		advMenuEnablerHardPanel.setLayout(advMenuHardLayout);
		openAdvancedHardEnablerMenu();
			//CUSTOM SECTION
			//FINISHING TOUCHES
		advMenuEnablerLayout = new GroupLayout(advMenuEnablerPanel);
		advMenuEnablerPanel.setLayout(advMenuEnablerLayout);
		advMenuEnablerLayout.setAutoCreateGaps(true);
		advMenuEnablerLayout.setAutoCreateContainerGaps(true);
		advMenuEnablerLayout.setHorizontalGroup(
				advMenuEnablerLayout.createSequentialGroup()
					.addGroup(advMenuEnablerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(advMenuEnablerMessagePanel)
							.addComponent(advMenuEnablerEasyTopPanel)
							.addComponent(advMenuEnablerEasyPanel)
							.addComponent(advMenuEnablerMedTopPanel)
							.addComponent(advMenuEnablerMedPanel)
							.addComponent(advMenuEnablerHardTopPanel)
							.addComponent(advMenuEnablerHardPanel)
							.addComponent(advMenuEnablerCustPanel))
		);
		advMenuEnablerLayout.setVerticalGroup(
				advMenuEnablerLayout.createSequentialGroup()
					.addComponent(advMenuEnablerMessagePanel)
					.addComponent(advMenuEnablerEasyTopPanel)
					.addComponent(advMenuEnablerEasyPanel)
					.addComponent(advMenuEnablerMedTopPanel)
					.addComponent(advMenuEnablerMedPanel)
					.addComponent(advMenuEnablerHardTopPanel)
					.addComponent(advMenuEnablerHardPanel)
					.addComponent(advMenuEnablerCustPanel)
		);
		addEnablerMenuTopPanelActionListeners();
		advMenuFrame.pack();
	}

	public void addEnablerMenuTopPanelActionListeners()
	{
		this.advMenuEnablerEasyCheckBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (advMenuEnablerEasyCheckBox.isSelected() == true)
				{
					easyToggle.setSelected(true);
				}
				else if (advMenuEnablerEasyCheckBox.isSelected() == false)
				{
					easyToggle.setSelected(false);
				}
				if (easyOn == false)
				{
					for (int i = 0; i < easyChallenges.length; i++)
					{
						if (easyEnablerButtons[i].isSelected() == true)
						{
							posChals.add(easyChallenges[i]);
						}
					}
					easyOn = true;
					dispEasyCount = 0;
					for (int p = 0; p < easyEnablerButtons.length; p++)
					{
						dispEasyCount += (posChals.countOccurences(easyChallenges[p]));
					}
					optionsSeedMessage.setText("Enabled " + dispEasyCount + " easy challenges.");
					dispEasyCount = 0;
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("easyOn set to: " + easyOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
				else
				{
					dispEasyCount = 0;
					for (int p = 0; p < easyEnablerButtons.length; p++)
					{
						dispEasyCount += (posChals.countOccurences(easyChallenges[p]));
					}
					optionsSeedMessage.setText("Removed " + dispEasyCount + " easy challenges.");
					for (int i = 0; i < easyChallenges.length; i++)
					{
						if (easyEnablerButtons[i].isSelected() == true)
						{
							posChals.remove(easyChallenges[i]);
						}
					}
					easyOn = false;
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("easyOn set to: " + easyOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
			}
		});
		this.advMenuEnablerMedCheckBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (advMenuEnablerMedCheckBox.isSelected() == true)
				{
					medToggle.setSelected(true);
				}
				else if (advMenuEnablerMedCheckBox.isSelected() == false)
				{
					medToggle.setSelected(false);
				}
				if (medOn == false)
				{
					for (int i = 0; i < medChallenges.length; i++)
					{
						if (medEnablerButtons[i].isSelected() == true)
						{
							posChals.add(medChallenges[i]);
						}
					}
					medOn = true;
					dispMedCount = 0;
					for (int p = 0; p < medEnablerButtons.length; p++)
					{
						dispMedCount += (posChals.countOccurences(medChallenges[p]));
					}
					optionsSeedMessage.setText("Enabled " + dispMedCount + " medium challenges.");
					dispMedCount = 0;
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("medOn set to: " + medOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
				else
				{
					dispMedCount = 0;
					for (int p = 0; p < medEnablerButtons.length; p++)
					{
						dispMedCount += (posChals.countOccurences(medChallenges[p]));
					}
					optionsSeedMessage.setText("Removed " + dispMedCount + " medium challenges.");
					for (int i = 0; i < medChallenges.length; i++)
					{
						if (medEnablerButtons[i].isSelected() == true)
						{
							posChals.remove(medChallenges[i]);
						}
					}
					medOn = false;
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("medOn set to: " + medOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
			}
		});
		this.advMenuEnablerHardCheckBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (advMenuEnablerHardCheckBox.isSelected() == true)
				{
					hardToggle.setSelected(true);
				}
				else if (advMenuEnablerHardCheckBox.isSelected() == false)
				{
					hardToggle.setSelected(false);
				}
				if (hardOn == false)
				{
					for (int i = 0; i < hardChallenges.length; i++)
					{
						if (hardEnablerButtons[i].isSelected() == true)
						{
							posChals.add(hardChallenges[i]);
						}
					}
					hardOn = true;
					dispHardCount = 0;
					for (int p = 0; p < hardEnablerButtons.length; p++)
					{
						if (posChals.countOccurences(hardChallenges[p]) > 0)
						{
							dispHardCount++;
						}
					}
					optionsSeedMessage.setText("Enabled " + dispHardCount + " hard challenges.");
					dispHardCount = 0;
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("hardOn set to: " + hardOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
				else
				{
					dispHardCount = 0;
					for (int p = 0; p < hardEnablerButtons.length; p++)
					{
						if (posChals.countOccurences(hardChallenges[p]) > 0)
						{
							dispHardCount++;
						}
					}
					optionsSeedMessage.setText("Removed " + dispHardCount + " hard challenges.");
					dispHardCount = 0;
					for (int i = 0; i < hardChallenges.length; i++)
					{
						if (hardEnablerButtons[i].isSelected() == true)
						{
							posChals.remove(hardChallenges[i]);
						}
					}
					hardOn = false;
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("hardOn set to: " + hardOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
			}
		});
	}

	public void openAdvancedEasyEnablerMenu()
	{
        advMenuEnablerEasyPanel.add(e1);
        advMenuEnablerEasyPanel.add(e2);
        advMenuEnablerEasyPanel.add(e3);
        advMenuEnablerEasyPanel.add(e4);
        advMenuEnablerEasyPanel.add(e5);
        advMenuEnablerEasyPanel.add(e6);
        advMenuEnablerEasyPanel.add(e7);
        advMenuEnablerEasyPanel.add(e8);
        advMenuEnablerEasyPanel.add(e9);
        advMenuEnablerEasyPanel.add(e10);
        advMenuEnablerEasyPanel.add(e11);
        advMenuEnablerEasyPanel.add(e12);
        advMenuEnablerEasyPanel.add(e13);
        advMenuEnablerEasyPanel.add(e14);
        advMenuEnablerEasyPanel.add(e15);
        advMenuEnablerEasyPanel.add(e16);
        advMenuEnablerEasyPanel.add(e17);
        advMenuEnablerEasyPanel.add(e18);
        advMenuEnablerEasyPanel.add(e19);
        advMenuEnablerEasyPanel.add(e20);



		//PAINPAINPAINPAINPAINPAINPAINPAINPAINPAINPIANOPAINPAINPAIN
		e1.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e1.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[0]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[0]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e1.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[0]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[0]); b++)
							{
								posChals.remove(easyChallenges[0]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
		e2.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e2.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[1]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[1]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e2.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[1]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[1]); b++)
							{
								posChals.remove(easyChallenges[1]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
		   e3.addActionListener(new ActionListener()
		   {
		public void actionPerformed(ActionEvent e)
		{
			if (e3.isSelected() == true)
			{
				if (posChals.countOccurences(easyChallenges[2]) == 0)
				{
					if (easyToggle.isSelected() == true)
					{
						posChals.add(easyChallenges[2]);
					}
				}
				optionsSeedMessage.setText("Added an item to EASY challenge pool.");
			}
			if (e3.isSelected() == false)
			{
				if (posChals.countOccurences(easyChallenges[2]) > 0)
				{
					for (int b = 0; b < posChals.countOccurences(easyChallenges[2]); b++)
					{
						posChals.remove(easyChallenges[2]);
					}
				}
				optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
			}
			chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
		}
   });
   e4.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e4.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[3]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[3]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e4.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[3]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[3]); b++)
							{
								posChals.remove(easyChallenges[3]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
		   e5.addActionListener(new ActionListener()
		   {
		public void actionPerformed(ActionEvent e)
		{
			if (e5.isSelected() == true)
			{
				if (posChals.countOccurences(easyChallenges[4]) == 0)
				{
					if (easyToggle.isSelected() == true)
					{
						posChals.add(easyChallenges[4]);
					}
				}
				optionsSeedMessage.setText("Added an item to EASY challenge pool.");
			}
			if (e5.isSelected() == false)
			{
				if (posChals.countOccurences(easyChallenges[4]) > 0)
				{
					for (int b = 0; b < posChals.countOccurences(easyChallenges[4]); b++)
					{
						posChals.remove(easyChallenges[4]);
					}
				}
				optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
			}
			chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
		}
   });
	e6.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e6.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[5]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[5]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e6.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[5]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[5]); b++)
							{
								posChals.remove(easyChallenges[5]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});	
		   e7.addActionListener(new ActionListener()
		   {
		public void actionPerformed(ActionEvent e)
		{
			if (e7.isSelected() == true)
			{
				if (posChals.countOccurences(easyChallenges[6]) == 0)
				{
					if (easyToggle.isSelected() == true)
					{
						posChals.add(easyChallenges[6]);
					}
				}
				optionsSeedMessage.setText("Added an item to EASY challenge pool.");
			}
			if (e7.isSelected() == false)
			{
				if (posChals.countOccurences(easyChallenges[6]) > 0)
				{
					for (int b = 0; b < posChals.countOccurences(easyChallenges[6]); b++)
					{
						posChals.remove(easyChallenges[6]);
					}
				}
				optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
			}
			chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
		}
   });
   e8.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e8.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[7]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[7]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e8.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[7]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[7]); b++)
							{
								posChals.remove(easyChallenges[7]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
		   e9.addActionListener(new ActionListener()
		   {
		public void actionPerformed(ActionEvent e)
		{
			if (e9.isSelected() == true)
			{
				if (posChals.countOccurences(easyChallenges[8]) == 0)
				{
					if (easyToggle.isSelected() == true)
					{
						posChals.add(easyChallenges[8]);
					}
				}
				optionsSeedMessage.setText("Added an item to EASY challenge pool.");
			}
			if (e9.isSelected() == false)
			{
				if (posChals.countOccurences(easyChallenges[8]) > 0)
				{
					for (int b = 0; b < posChals.countOccurences(easyChallenges[8]); b++)
					{
						posChals.remove(easyChallenges[8]);
					}
				}
				optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
			}
			chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
		}
   });
   e10.addActionListener(new ActionListener()
   {
public void actionPerformed(ActionEvent e)
{
	if (e10.isSelected() == true)
	{
		if (posChals.countOccurences(easyChallenges[9]) == 0)
		{
			if (easyToggle.isSelected() == true)
			{
				posChals.add(easyChallenges[9]);
			}
		}
		optionsSeedMessage.setText("Added an item to EASY challenge pool.");
	}
	if (e10.isSelected() == false)
	{
		if (posChals.countOccurences(easyChallenges[9]) > 0)
		{
			for (int b = 0; b < posChals.countOccurences(easyChallenges[9]); b++)
			{
				posChals.remove(easyChallenges[9]);
			}
		}
		optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
	}
	chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
}
});
	e11.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e11.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[10]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[10]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e11.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[10]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[10]); b++)
							{
								posChals.remove(easyChallenges[10]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			e12.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e12.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[11]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[11]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e12.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[11]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[11]); b++)
							{
								posChals.remove(easyChallenges[11]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			e13.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e13.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[12]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[12]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e13.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[12]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[12]); b++)
							{
								posChals.remove(easyChallenges[12]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			e14.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e14.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[13]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[13]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e14.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[13]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[13]); b++)
							{
								posChals.remove(easyChallenges[13]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			e15.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e15.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[14]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[14]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e15.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[14]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[14]); b++)
							{
								posChals.remove(easyChallenges[14]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			e16.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e16.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[15]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[15]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e16.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[15]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[15]); b++)
							{
								posChals.remove(easyChallenges[15]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			e17.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e17.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[16]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[16]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e17.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[16]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[16]); b++)
							{
								posChals.remove(easyChallenges[16]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			e18.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e18.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[17]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[17]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e18.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[17]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[17]); b++)
							{
								posChals.remove(easyChallenges[17]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			e19.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e19.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[18]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[18]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e19.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[18]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[18]); b++)
							{
								posChals.remove(easyChallenges[18]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			e20.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (e20.isSelected() == true)
					{
						if (posChals.countOccurences(easyChallenges[19]) == 0)
						{
							if (easyToggle.isSelected() == true)
							{
								posChals.add(easyChallenges[19]);
							}
						}
						optionsSeedMessage.setText("Added an item to EASY challenge pool.");
					}
					if (e20.isSelected() == false)
					{
						if (posChals.countOccurences(easyChallenges[19]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(easyChallenges[19]); b++)
							{
								posChals.remove(easyChallenges[19]);
							}
						}
						optionsSeedMessage.setText("Removed an item from EASY challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
	}

	public void openAdvancedMedEnablerMenu()
	{
        advMenuEnablerMedPanel.add(m1);
        advMenuEnablerMedPanel.add(m2);
        advMenuEnablerMedPanel.add(m3);
        advMenuEnablerMedPanel.add(m4);
        advMenuEnablerMedPanel.add(m5);
        advMenuEnablerMedPanel.add(m6);
        advMenuEnablerMedPanel.add(m7);
        advMenuEnablerMedPanel.add(m8);
        advMenuEnablerMedPanel.add(m9);
        advMenuEnablerMedPanel.add(m10);
        advMenuEnablerMedPanel.add(m11);
        advMenuEnablerMedPanel.add(m12);
        advMenuEnablerMedPanel.add(m13);
        advMenuEnablerMedPanel.add(m14);
        advMenuEnablerMedPanel.add(m15);
        advMenuEnablerMedPanel.add(m16);
        advMenuEnablerMedPanel.add(m17);
        advMenuEnablerMedPanel.add(m18);
        advMenuEnablerMedPanel.add(m19);
        advMenuEnablerMedPanel.add(m20);

        advMenuFrame.pack();
		


		//PAINPAINPAINPAINPAINPAINPAINPAINPAINPAINPIANOPAINPAINPAIN
		m1.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m1.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[0]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[0]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m1.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[0]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[0]); b++)
							{
								posChals.remove(medChallenges[0]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
		m2.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m2.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[1]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[1]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m2.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[1]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[1]); b++)
							{
								posChals.remove(medChallenges[1]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
		   m3.addActionListener(new ActionListener()
		   {
		public void actionPerformed(ActionEvent e)
		{
			if (m3.isSelected() == true)
			{
				if (posChals.countOccurences(medChallenges[2]) == 0)
				{
					if (medToggle.isSelected() == true)
					{
						posChals.add(medChallenges[2]);
					}
				}
				optionsSeedMessage.setText("Added an item to med challenge pool.");
			}
			if (m3.isSelected() == false)
			{
				if (posChals.countOccurences(medChallenges[2]) > 0)
				{
					for (int b = 0; b < posChals.countOccurences(medChallenges[2]); b++)
					{
						posChals.remove(medChallenges[2]);
					}
				}
				optionsSeedMessage.setText("Removed an item from med challenge pool.");
			}
			chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
		}
   });
   m4.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m4.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[3]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[3]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m4.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[3]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[3]); b++)
							{
								posChals.remove(medChallenges[3]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
		   m5.addActionListener(new ActionListener()
		   {
		public void actionPerformed(ActionEvent e)
		{
			if (m5.isSelected() == true)
			{
				if (posChals.countOccurences(medChallenges[4]) == 0)
				{
					if (medToggle.isSelected() == true)
					{
						posChals.add(medChallenges[4]);
					}
				}
				optionsSeedMessage.setText("Added an item to med challenge pool.");
			}
			if (m5.isSelected() == false)
			{
				if (posChals.countOccurences(medChallenges[4]) > 0)
				{
					for (int b = 0; b < posChals.countOccurences(medChallenges[4]); b++)
					{
						posChals.remove(medChallenges[4]);
					}
				}
				optionsSeedMessage.setText("Removed an item from med challenge pool.");
			}
			chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
		}
   });
	m6.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m6.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[5]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[5]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m6.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[5]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[5]); b++)
							{
								posChals.remove(medChallenges[5]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});	
		   m7.addActionListener(new ActionListener()
		   {
		public void actionPerformed(ActionEvent e)
		{
			if (m7.isSelected() == true)
			{
				if (posChals.countOccurences(medChallenges[6]) == 0)
				{
					if (medToggle.isSelected() == true)
					{
						posChals.add(medChallenges[6]);
					}
				}
				optionsSeedMessage.setText("Added an item to med challenge pool.");
			}
			if (m7.isSelected() == false)
			{
				if (posChals.countOccurences(medChallenges[6]) > 0)
				{
					for (int b = 0; b < posChals.countOccurences(medChallenges[6]); b++)
					{
						posChals.remove(medChallenges[6]);
					}
				}
				optionsSeedMessage.setText("Removed an item from med challenge pool.");
			}
			chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
		}
   });
   m8.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m8.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[7]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[7]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m8.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[7]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[7]); b++)
							{
								posChals.remove(medChallenges[7]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
		   m9.addActionListener(new ActionListener()
		   {
		public void actionPerformed(ActionEvent e)
		{
			if (m9.isSelected() == true)
			{
				if (posChals.countOccurences(medChallenges[8]) == 0)
				{
					if (medToggle.isSelected() == true)
					{
						posChals.add(medChallenges[8]);
					}
				}
				optionsSeedMessage.setText("Added an item to med challenge pool.");
			}
			if (m9.isSelected() == false)
			{
				if (posChals.countOccurences(medChallenges[8]) > 0)
				{
					for (int b = 0; b < posChals.countOccurences(medChallenges[8]); b++)
					{
						posChals.remove(medChallenges[8]);
					}
				}
				optionsSeedMessage.setText("Removed an item from med challenge pool.");
			}
			chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
		}
   });
   m10.addActionListener(new ActionListener()
   {
public void actionPerformed(ActionEvent e)
{
	if (m10.isSelected() == true)
	{
		if (posChals.countOccurences(medChallenges[9]) == 0)
		{
			if (medToggle.isSelected() == true)
			{
				posChals.add(medChallenges[9]);
			}
		}
		optionsSeedMessage.setText("Added an item to med challenge pool.");
	}
	if (m10.isSelected() == false)
	{
		if (posChals.countOccurences(medChallenges[9]) > 0)
		{
			for (int b = 0; b < posChals.countOccurences(medChallenges[9]); b++)
			{
				posChals.remove(medChallenges[9]);
			}
		}
		optionsSeedMessage.setText("Removed an item from med challenge pool.");
	}
	chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
}
});
	m11.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m11.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[10]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[10]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m11.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[10]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[10]); b++)
							{
								posChals.remove(medChallenges[10]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			m12.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m12.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[11]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[11]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m12.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[11]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[11]); b++)
							{
								posChals.remove(medChallenges[11]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			m13.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m13.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[12]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[12]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m13.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[12]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[12]); b++)
							{
								posChals.remove(medChallenges[12]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			m14.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m14.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[13]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[13]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m14.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[13]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[13]); b++)
							{
								posChals.remove(medChallenges[13]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			m15.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m15.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[14]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[14]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m15.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[14]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[14]); b++)
							{
								posChals.remove(medChallenges[14]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			m16.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m16.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[15]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[15]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m16.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[15]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[15]); b++)
							{
								posChals.remove(medChallenges[15]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			m17.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m17.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[16]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[16]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m17.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[16]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[16]); b++)
							{
								posChals.remove(medChallenges[16]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			m18.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m18.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[17]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[17]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m18.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[17]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[17]); b++)
							{
								posChals.remove(medChallenges[17]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			m19.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m19.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[18]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[18]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m19.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[18]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[18]); b++)
							{
								posChals.remove(medChallenges[18]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			m20.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (m20.isSelected() == true)
					{
						if (posChals.countOccurences(medChallenges[19]) == 0)
						{
							if (medToggle.isSelected() == true)
							{
								posChals.add(medChallenges[19]);
							}
						}
						optionsSeedMessage.setText("Added an item to med challenge pool.");
					}
					if (m20.isSelected() == false)
					{
						if (posChals.countOccurences(medChallenges[19]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(medChallenges[19]); b++)
							{
								posChals.remove(medChallenges[19]);
							}
						}
						optionsSeedMessage.setText("Removed an item from med challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
	}

	public void openAdvancedHardEnablerMenu()
	{
        advMenuEnablerHardPanel.add(h1);
        advMenuEnablerHardPanel.add(h2);
        advMenuEnablerHardPanel.add(h3);
        advMenuEnablerHardPanel.add(h4);
        advMenuEnablerHardPanel.add(h5);
        advMenuEnablerHardPanel.add(h6);
        advMenuEnablerHardPanel.add(h7);
        advMenuEnablerHardPanel.add(h8);
        advMenuEnablerHardPanel.add(h9);
        advMenuEnablerHardPanel.add(h10);
        advMenuEnablerHardPanel.add(h11);
        advMenuEnablerHardPanel.add(h12);
        advMenuEnablerHardPanel.add(h13);
        advMenuEnablerHardPanel.add(h14);
        advMenuEnablerHardPanel.add(h15);
        advMenuEnablerHardPanel.add(h16);
        advMenuEnablerHardPanel.add(h17);
        advMenuEnablerHardPanel.add(h18);
        advMenuEnablerHardPanel.add(h19);
        advMenuEnablerHardPanel.add(h20);

        advMenuFrame.pack();
		


		//PAINPAINPAINPAINPAINPAINPAINPAINPAINPAINPIANOPAINPAINPAIN
		h1.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h1.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[0]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[0]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h1.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[0]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[0]); b++)
							{
								posChals.remove(hardChallenges[0]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
		h2.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h2.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[1]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[1]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h2.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[1]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[1]); b++)
							{
								posChals.remove(hardChallenges[1]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
		   h3.addActionListener(new ActionListener()
		   {
		public void actionPerformed(ActionEvent e)
		{
			if (h3.isSelected() == true)
			{
				if (posChals.countOccurences(hardChallenges[2]) == 0)
				{
					if (hardToggle.isSelected() == true)
					{
						posChals.add(hardChallenges[2]);
					}
				}
				optionsSeedMessage.setText("Added an item to HARD challenge pool.");
			}
			if (h3.isSelected() == false)
			{
				if (posChals.countOccurences(hardChallenges[2]) > 0)
				{
					for (int b = 0; b < posChals.countOccurences(hardChallenges[2]); b++)
					{
						posChals.remove(hardChallenges[2]);
					}
				}
				optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
			}
			chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
		}
   });
   h4.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h4.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[3]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[3]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h4.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[3]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[3]); b++)
							{
								posChals.remove(hardChallenges[3]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
		   h5.addActionListener(new ActionListener()
		   {
		public void actionPerformed(ActionEvent e)
		{
			if (h5.isSelected() == true)
			{
				if (posChals.countOccurences(hardChallenges[4]) == 0)
				{
					if (hardToggle.isSelected() == true)
					{
						posChals.add(hardChallenges[4]);
					}
				}
				optionsSeedMessage.setText("Added an item to HARD challenge pool.");
			}
			if (h5.isSelected() == false)
			{
				if (posChals.countOccurences(hardChallenges[4]) > 0)
				{
					for (int b = 0; b < posChals.countOccurences(hardChallenges[4]); b++)
					{
						posChals.remove(hardChallenges[4]);
					}
				}
				optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
			}
			chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
		}
   });
	h6.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h6.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[5]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[5]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h6.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[5]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[5]); b++)
							{
								posChals.remove(hardChallenges[5]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});	
		   h7.addActionListener(new ActionListener()
		   {
		public void actionPerformed(ActionEvent e)
		{
			if (h7.isSelected() == true)
			{
				if (posChals.countOccurences(hardChallenges[6]) == 0)
				{
					if (hardToggle.isSelected() == true)
					{
						posChals.add(hardChallenges[6]);
					}
				}
				optionsSeedMessage.setText("Added an item to HARD challenge pool.");
			}
			if (h7.isSelected() == false)
			{
				if (posChals.countOccurences(hardChallenges[6]) > 0)
				{
					for (int b = 0; b < posChals.countOccurences(hardChallenges[6]); b++)
					{
						posChals.remove(hardChallenges[6]);
					}
				}
				optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
			}
			chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
		}
   });
   h8.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h8.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[7]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[7]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h8.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[7]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[7]); b++)
							{
								posChals.remove(hardChallenges[7]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
		   h9.addActionListener(new ActionListener()
		   {
		public void actionPerformed(ActionEvent e)
		{
			if (h9.isSelected() == true)
			{
				if (posChals.countOccurences(hardChallenges[8]) == 0)
				{
					if (hardToggle.isSelected() == true)
					{
						posChals.add(hardChallenges[8]);
					}
				}
				optionsSeedMessage.setText("Added an item to HARD challenge pool.");
			}
			if (h9.isSelected() == false)
			{
				if (posChals.countOccurences(hardChallenges[8]) > 0)
				{
					for (int b = 0; b < posChals.countOccurences(hardChallenges[8]); b++)
					{
						posChals.remove(hardChallenges[8]);
					}
				}
				optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
			}
			chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
		}
   });
   h10.addActionListener(new ActionListener()
   {
public void actionPerformed(ActionEvent e)
{
	if (h10.isSelected() == true)
	{
		if (posChals.countOccurences(hardChallenges[9]) == 0)
		{
			if (hardToggle.isSelected() == true)
			{
				posChals.add(hardChallenges[9]);
			}
		}
		optionsSeedMessage.setText("Added an item to HARD challenge pool.");
	}
	if (h10.isSelected() == false)
	{
		if (posChals.countOccurences(hardChallenges[9]) > 0)
		{
			for (int b = 0; b < posChals.countOccurences(hardChallenges[9]); b++)
			{
				posChals.remove(hardChallenges[9]);
			}
		}
		optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
	}
	chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
}
});
	h11.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h11.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[10]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[10]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h11.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[10]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[10]); b++)
							{
								posChals.remove(hardChallenges[10]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			h12.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h12.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[11]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[11]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h12.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[11]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[11]); b++)
							{
								posChals.remove(hardChallenges[11]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			h13.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h13.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[12]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[12]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h13.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[12]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[12]); b++)
							{
								posChals.remove(hardChallenges[12]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			h14.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h14.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[13]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[13]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h14.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[13]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[13]); b++)
							{
								posChals.remove(hardChallenges[13]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			h15.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h15.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[14]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[14]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h15.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[14]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[14]); b++)
							{
								posChals.remove(hardChallenges[14]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			h16.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h16.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[15]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[15]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h16.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[15]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[15]); b++)
							{
								posChals.remove(hardChallenges[15]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			h17.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h17.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[16]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[16]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h17.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[16]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[16]); b++)
							{
								posChals.remove(hardChallenges[16]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			h18.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h18.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[17]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[17]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h18.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[17]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[17]); b++)
							{
								posChals.remove(hardChallenges[17]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			h19.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h19.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[18]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[18]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h19.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[18]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[18]); b++)
							{
								posChals.remove(hardChallenges[18]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});
			h20.addActionListener(new ActionListener()
       	   	 {
        		public void actionPerformed(ActionEvent e)
        		{
        			if (h20.isSelected() == true)
					{
						if (posChals.countOccurences(hardChallenges[19]) == 0)
						{
							if (hardToggle.isSelected() == true)
							{
								posChals.add(hardChallenges[19]);
							}
						}
						optionsSeedMessage.setText("Added an item to HARD challenge pool.");
					}
					if (h20.isSelected() == false)
					{
						if (posChals.countOccurences(hardChallenges[19]) > 0)
						{
							for (int b = 0; b < posChals.countOccurences(hardChallenges[19]); b++)
							{
								posChals.remove(hardChallenges[19]);
							}
						}
						optionsSeedMessage.setText("Removed an item from HARD challenge pool.");
					}
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
         	   }
       	});

		//VSC CRAZY
		//I was control+f replacing each e# in this method with h# and after like
		//8 times it just did them all for me lol
	}
}
