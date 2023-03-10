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



public class Options
{
	//Arrays
	public PossibleChallenges posChals;
	public CustChalBag customChallenges;
	public JCheckBox[] easyEnablerButtons;
	public JCheckBox[] medEnablerButtons;
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
			"Burn the thorns from the Erdtree"};
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
	
	// Enable/Disable Challenges Menu Declarations
	private JFrame advancedMenuFrame;
	private JPanel advancedMenuPanel;
	private GridLayout advancedMenuLayout;
	private JMenuBar advancedMenuBar;
	private JMenu enableMenu;
	private JMenu guaranteeMenu;
	private JMenuItem easyMenu;
	private JMenuItem medMenu;
	private JMenuItem hardMenu;
	private JMenuItem customMenu;

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
		// Creates the Advanced Options Window and displays it.
        advancedMenuFrame = new JFrame("[=] JMenuBar [=]");
        advancedMenuBar = new JMenuBar();
        advancedMenuFrame.setJMenuBar(advancedMenuBar);
        advancedMenuPanel = new JPanel();
        advancedMenuFrame.add(advancedMenuPanel);
        advancedMenuLayout = new GridLayout(10, 3);
        advancedMenuPanel.setLayout(advancedMenuLayout);
        advancedMenuFrame.setSize(500, 500);
        advancedMenuFrame.setVisible(true);
        enableMenu = new JMenu("[View/Toggle Challenges]");
        guaranteeMenu = new JMenu("[Guarantee Challenges]");
        advancedMenuBar.add(enableMenu);
        advancedMenuBar.add(guaranteeMenu);
        easyMenu = new JMenuItem("Easy Challenges");
        medMenu = new JMenuItem("Medium Challenges");
        hardMenu = new JMenuItem("Hard Challenges");
        customMenu = new JMenuItem("Custom Challenges");
        enableMenu.add(easyMenu);
        enableMenu.add(medMenu);
        enableMenu.add(hardMenu);
        enableMenu.add(customMenu);

        //ACTION LISTENERS
        easyMenu.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		openAdvancedEasyEnablerMenu();
            }
        });
        medMenu.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		openAdvancedMedEnablerMenu();
            }
        });
	}

	public void openAdvancedEasyEnablerMenu()
	{
        advancedMenuPanel.add(e1);
        advancedMenuPanel.add(e2);
        advancedMenuPanel.add(e3);
        advancedMenuPanel.add(e4);
        advancedMenuPanel.add(e5);
        advancedMenuPanel.add(e6);
        advancedMenuPanel.add(e7);
        advancedMenuPanel.add(e8);
        advancedMenuPanel.add(e9);
        advancedMenuPanel.add(e10);
        advancedMenuPanel.add(e11);
        advancedMenuPanel.add(e12);
        advancedMenuPanel.add(e13);
        advancedMenuPanel.add(e14);
        advancedMenuPanel.add(e15);
        advancedMenuPanel.add(e16);
        advancedMenuPanel.add(e17);
        advancedMenuPanel.add(e18);
        advancedMenuPanel.add(e19);
        advancedMenuPanel.add(e20);

        advancedMenuFrame.pack();
		


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
					System.out.println("e2 working");
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
			System.out.println("e3 working");
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
					System.out.println("e4 working");
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
			System.out.println("e5 working");
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
        advancedMenuPanel.add(m1);
        advancedMenuPanel.add(m2);
        advancedMenuPanel.add(m3);
        advancedMenuPanel.add(m4);
        advancedMenuPanel.add(m5);
        advancedMenuPanel.add(m6);
        advancedMenuPanel.add(m7);
        advancedMenuPanel.add(m8);
        advancedMenuPanel.add(m9);
        advancedMenuPanel.add(m10);
        advancedMenuPanel.add(m11);
        advancedMenuPanel.add(m12);
        advancedMenuPanel.add(m13);
        advancedMenuPanel.add(m14);
        advancedMenuPanel.add(m15);
        advancedMenuPanel.add(m16);
        advancedMenuPanel.add(m17);
        advancedMenuPanel.add(m18);
        advancedMenuPanel.add(m19);
        advancedMenuPanel.add(m20);

        advancedMenuFrame.pack();
		


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
					System.out.println("m2 working");
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
			System.out.println("m3 working");
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
					System.out.println("m4 working");
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
			System.out.println("m5 working");
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
}
