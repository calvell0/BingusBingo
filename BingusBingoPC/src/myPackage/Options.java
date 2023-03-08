package myPackage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Options
{
	//Arrays
	private ChalArrayBag posChals;
	private CustChalBag customChallenges;
	private String[] easyChallenges = new String[] { 
			"Acquire a legendary armament", 
			"Defeat an optional cave's boss", 							
			"Acquire a +3 flask",  										
			"Kill an NPC invader", 
			"Mix a Physick Flask with 2 tears", 
			"Craft 20 bone arrows", 
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

	private String[] medChallenges = new String[] {
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
	private String[] hardChallenges = new String[] {
			"Acquire Mohg's Greatrune", 
			"Enter Liurnia", 											
			"Defeat Elden Beast", 
			"Enter Mohgwyn Palace",
			"Teleport to Faram Azula from the 4 Belfries", 
			"Defeat Malenia", 
			"Enter the consecrated snowfield", 
			"Enter Elphael Brace of the Haligtree", 					
			"Defeat the boss in Malenia's Arena", 						
			"Defeat the boss in Dragonlord Placidusax's Arena", 
			"Invert the Carian Study Hall", 
			"Equip 3 spells or incantations simultaneously", 
			"Embrace the 3 Fingers", 
			"Burn the thorns from the Erdtree"};
	
	//Status fields
	private boolean easyOn;
	private boolean medOn;
	private boolean hardOn;
	private boolean customOn;
	private long userSeed;
	
	//JFrame element declarations
	private JFrame optionsFrame;
	private JPanel optionsTitlePanel;
	private JLabel optionsTitleLabel;
	
	private JPanel optionsTogglePanel;
	private JRadioButton easyToggle;
	private JRadioButton medToggle;
	private JRadioButton hardToggle;
	private JRadioButton customToggle;
	
	private JPanel optionsSeedPanel;
	private JTextField optionsSeedTextField;
	private JLabel	optionsSeedLabel;
	private JButton optionsSeedConfirmButton;
	private JButton optionsSeedRandomButton;
	private JLabel optionsSeedMessage;
	
	
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
		customOn = false;
		
		//OPTIONS frame
		optionsFrame = new JFrame();
		optionsFrame.setSize(600,200);
		optionsFrame.setLocation(100,100);
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
		easyToggle = new JRadioButton("Enable Easy Challenges");
		medToggle = new JRadioButton("Enable Med Challenges");
		hardToggle = new JRadioButton("Enable Hard Challenges");
		customToggle = new JRadioButton("Enable Custom Challenges");
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
							.addComponent(customToggle))
		);
		toggleLayout.setVerticalGroup(
				toggleLayout.createSequentialGroup()
					.addComponent(easyToggle)
					.addComponent(medToggle)
					.addComponent(hardToggle)
					.addComponent(customToggle)
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
					System.out.println("customOn set to: " + customOn);
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
		optionsSeedMessage = new JLabel("optionsSeedMessage");
		GroupLayout seedLayout = new GroupLayout(optionsSeedPanel);
		optionsSeedPanel.setLayout(seedLayout);
		seedLayout.setAutoCreateGaps(true);
		seedLayout.setAutoCreateContainerGaps(true);
		seedLayout.setHorizontalGroup(
				seedLayout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
//					.addComponent(optionsSeedMessage)
					.addComponent(optionsSeedTextField, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(seedLayout.createSequentialGroup()
							.addComponent(optionsSeedRandomButton, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(optionsSeedConfirmButton, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addComponent(optionsSeedMessage)
		);
		seedLayout.setVerticalGroup(
				seedLayout.createSequentialGroup()
//					.addComponent(optionsSeedMessage)
					.addComponent(optionsSeedTextField, 30, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(seedLayout.createParallelGroup(GroupLayout.Alignment.LEADING, true)						
							.addComponent(optionsSeedRandomButton) 														
							.addComponent(optionsSeedConfirmButton))
					.addComponent(optionsSeedMessage)
		);
		
		this.optionsSeedConfirmButton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		try
        		{
        			String seedString = optionsSeedTextField.getText();
        			setSeed(Long.parseLong(seedString));
        		}
        		catch (NumberFormatException z)
        		{
        			System.out.println("Seed is invalid.\nMaintaining previous seed: "
        									+ userSeed);
        		}
        	}
        });
		this.optionsSeedRandomButton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		Random r = new Random();
        		userSeed = r.nextLong();
        		String s = String.valueOf(userSeed);
        		optionsSeedTextField.setText(s);
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
		System.out.println("A new seed was set: "+ userSeed);
	}
	
	public void initPossibleChallenges()
	{
		posChals = new PossibleChallenges();
	}
}