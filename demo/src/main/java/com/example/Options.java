package com.example;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.awt.GridLayout;
// import javax.swing.GroupLayout;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JMenu;
// import javax.swing.JMenuBar;
// import javax.swing.JMenuItem;
// import javax.swing.JPanel;
// import javax.swing.JCheckBox;
// import javax.swing.JTextField;
// import javax.swing.SwingConstants;
// import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Options
{
	//Arrays
	public ChalArrayBag posChals;
	public CustChalBag customChallenges;
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
			"Equip 2 armor pieces from the same set"};
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
			"Defeat a boss using only your fists"
	};
	
	//Status fields
	private boolean easyOn;
	private boolean medOn;
	private boolean hardOn;
	private boolean nightmareOn;
	private boolean customOn;
	private long userSeed;
	
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
	
	//Enable/Disable Challenges Menu Declarations
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

	//easyMenu button declarations
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
						posChals.add(easyChallenges[i]);
					}
					easyOn = true;
					optionsSeedMessage.setText("Enabled " + easyChallenges.length + " easy challenges.");
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("easyOn set to: " + easyOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
				else
				{
					for (int i = 0; i < easyChallenges.length; i++)
					{
						posChals.remove(easyChallenges[i]);
					}
					easyOn = false;
					optionsSeedMessage.setText("Disabled " + easyChallenges.length + " easy challenges.");
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
						posChals.add(medChallenges[i]);
					}
					medOn = true;
					optionsSeedMessage.setText("Enabled " + medChallenges.length + " medium challenges.");
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("medOn set to: " + medOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
				else
				{
					for (int i = 0; i < medChallenges.length; i++)
					{
						posChals.remove(medChallenges[i]);
					}
					medOn = false;
					optionsSeedMessage.setText("Disabled " + medChallenges.length + " medium challenges.");
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
				if (hardOn == false)
				{
					for (int i = 0; i < hardChallenges.length; i++)
					{
						posChals.add(hardChallenges[i]);
					}
					hardOn = true;
					optionsSeedMessage.setText("Enabled " + hardChallenges.length + " hard challenges.");
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println("hardOn set to: " + hardOn);
					System.out.println("# of Possible Challenges: " + posChals.size());
				}
				else
				{
					for (int i = 0; i < hardChallenges.length; i++)
					{
						posChals.remove(hardChallenges[i]);
					}
					hardOn = false;
					optionsSeedMessage.setText("Disabled " + hardChallenges.length + " hard challenges.");
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
					optionsSeedMessage.setText("NIGHTMARES ENABLED. GOOD LUCK...");
					chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
					System.out.println(optionsStartPlayButton.getFont());
					optionsStartPlayButton.setFont(new Font("wingdings", Font.PLAIN, 10));
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
        		openAdvancedMenu();
        	}
        });

		


	//END OF CONSTRUCTOR DONT WRITE PAST HERE LIKE U//////
	//DID EARLIER FOR 20 MINUTES WONDERING WHY ITS NOT////
	//WORKING I SWEAR TO GOD//////////////////////////////
	}

	public void openAdvancedMenu()
	{
		//Displays The Challenge Customizer Menu
		advancedMenuFrame = new JFrame("[=] JMenuBar [=]");
		advancedMenuBar = new JMenuBar();
		advancedMenuFrame.setJMenuBar(advancedMenuBar);
		advancedMenuPanel = new JPanel();
		advancedMenuFrame.add(advancedMenuPanel);
		advancedMenuLayout = new GridLayout(10,3);
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

		//Menu Button Listeners
		this.easyMenu.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
				easyMenu.setVisible(true);
				medMenu.setVisible(false);
				hardMenu.setVisible(false);
				customMenu.setVisible(false);

				//Initialize a checkbox for each easy challenge.
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

        	}
        });
		this.medMenu.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		System.out.println("Currently in medium menu");
        	}
        });
		this.hardMenu.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		System.out.println("Currently in hard menu");
        	}
        });
		this.customMenu.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		System.out.println("Currently in custom menu");
        	}
        });

		//TODO: action listeners are throwing nullpointer exceptions
			//for some reason when the advanced frame opens. Idk why.
			//Also I literally need to make 100 more of these. Awesome.
		// e1.addActionListener(new ActionListener()
		// {
		// 	public void actionPerformed(ActionEvent e)
		// 	{
		// 		System.out.println("e1 clicked");
		// 		if (posChals.countOccurences(easyChallenges[0]) > 0)
		// 		{
		// 				System.out.println("# of Possible Challenges: " + posChals.size());
		// 				chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
		// 				posChals.remove(easyChallenges[0]);
		// 		}
		// 		else
		// 		{
		// 			System.out.println("# of Possible Challenges: " + posChals.size());
		// 			chalTally.setText("(Challenges Enabled: " + posChals.size() + ")");
		// 			posChals.add(easyChallenges[0]);
		// 		}
		// 	}
		// });
		// e2.addActionListener(new ActionListener()
		// {
		// 	public void actionPerformed(ActionEvent e)
		// 	{
		// 		if (posChals.countOccurences(easyChallenges[1]) > 0)
		// 		{
		// 			for (int i = 0; i < posChals.countOccurences(easyChallenges[1]); i++)
		// 			{
		// 				posChals.remove(easyChallenges[1]);
		// 			}
		// 		}
		// 		else
		// 		{
		// 			posChals.add(easyChallenges[1]);
		// 		}
		// 	}
		// });
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
}
