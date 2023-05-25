package Main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.print.attribute.AttributeSet;
import javax.swing.JButton;

import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionRequest.ChatCompletionRequestBuilder;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.service.OpenAiService;

import Dialogue.DialogueBox;
import Entities.Mobs.Player;
import Event.Action;
import Event.ActionListener;
import Graphics.World;
import Inputs.KeyBoardListener;
import javax.swing.JTextArea;
public class Game extends Canvas implements Runnable, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int SIZE = 16; //bit resolution (ALwys 16 since its a 16-bit game)
	public final static String WORLD_NAME= "Phodeales";
	private final static String AItoken= "Your Open AI Token Here "; 
	public static final OpenAiService AIservice= new OpenAiService(AItoken);
	public static DialogueBox dialogue_input;
	public static DialogueBox dialogue_output;
	ArrayList<ActionListener> listeners;
	JFrame frame;
	int width= 320;
	int height= (width/12)*9;
	int scale =3;
	double x,y=0;
	boolean up, down, left, right;
	
	Thread thread;
	boolean running=true;
	BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	int pixels[]= ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	Graphics2D g;
	
	Dimension d= new Dimension(width*scale, height*scale);
	BufferStrategy bs;
	public static Screen screen;
	KeyBoardListener keyboard;
	World current_world;
	Player player;
	Game(){
		//window object
		frame= new JFrame("Life of a farmer");
		frame.setSize(d);
		frame.setResizable(false);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//dialogue input box
				dialogue_input= new DialogueBox(10);
				dialogue_input.setBounds(0, (height*3)-90, (720), 50);
				dialogue_input.setBackground(Color.LIGHT_GRAY);	
				dialogue_input.setFont(new Font("Serif", Font.ITALIC, 16));
				dialogue_input.setOpaque(false);
				dialogue_input.setVisible(false);
				dialogue_input.setEditable(true);
		//dialogue output box
				dialogue_output= new DialogueBox(10);
				dialogue_output.setBounds(0, (height*3)-90, (720), 50);
				dialogue_output.setBackground(Color.LIGHT_GRAY);	
				dialogue_output.setFont(new Font("Serif", Font.ITALIC, 16));
				dialogue_output.setOpaque(false);
				dialogue_output.setVisible(false);
				dialogue_output.setEditable(true);
	   //screen (manipulated pixels)
		screen = new Screen(pixels,width, height);
		//keyboard listeners
		keyboard=new KeyBoardListener(this);
		this.addKeyListener(keyboard);
		//player & world
		player=new Player(5*SIZE,4*SIZE);
		current_world= new World("/tilemapbeta.png",player);
		
		
		
	
		frame.add(this);
		//Only set visible after all components are added to JFrame
		frame.setVisible(true);
		
		
		
		listeners= new ArrayList<ActionListener>();
		listeners.add(current_world);
		
	}
	
	
	public void run() {
		//game loop
		double secondStart= System.currentTimeMillis();
		double Cyclestart= System.nanoTime();
		int numFrames=0;
		int numTicks=0;
		while(running){						
			double TIPT=1000000000.0/60;
			int ticks=(int) ((System.nanoTime()-Cyclestart)/TIPT);
			if(ticks>=1) {
				Cyclestart=System.nanoTime();
				while(ticks>0) {
					ticks--;
					numTicks++;	
					tick();
				}
			}			
			numFrames++;
			render();
			if((System.currentTimeMillis()- secondStart)>=1000) {
				frame.setTitle("LOAF: Frames:"+ numFrames + " , Ticks: " +numTicks);
				numFrames=0;
				numTicks=0;
				secondStart=System.currentTimeMillis();
			}
		
		}
		
	}//end start
	public void tick() {
		current_world.tick();
	}
	public void render() {
		bs=getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		g= (Graphics2D) bs.getDrawGraphics();
		current_world.render();
		g.drawImage(image,0,0 ,width*scale,height*scale, null);
		if(dialogue_input.isVisible()) {
		dialogue_input.requestFocus();
		g.translate(0, (height*scale)-90);
		dialogue_input.paint(g);
		}
		if(dialogue_output.isVisible()) {
			dialogue_output.requestFocus();
			g.translate((width*scale )- (dialogue_output.getWidth()+ 15), (height*scale)-90);
			dialogue_output.paint(g);
		}
		bs.show();
		g.dispose();
	}


	public static void main(String[] args) {
		Game game= new Game();
		
		game.start();
	}
	
	/*ChatCompletionResult response;
	
	List<ChatMessage> chatlist = new ArrayList<ChatMessage>();	
	chatlist.add(new DialogueMessage("system","Act like a farmer in the world of Morbia. "
			+ "							 You are happy with your life and recently had a son"));
	chatlist.add(new DialogueMessage("user","How are you?"));
	chatlist.add(new DialogueMessage("assistant","I'm Good"));
	chatlist.add(new DialogueMessage("user", "What do you mean by that specifically"));
    ChatCompletionRequest chatrequest= ChatCompletionRequest.builder()
		 							   .model("gpt-3.5-turbo")
		 							   .messages(chatlist)
		 							   .temperature(1.0).build();
    
    response =AIservice.createChatCompletion(chatrequest);
	System.out.println(response.getChoices().get(0).getMessage().getContent());   */
	
	
	/////////////////////////////////////////

	/*Chat completion example
	 * ChatCompletionResult response;
		
		List<ChatMessage> chatlist = new ArrayList<ChatMessage>();		
		chatlist.add(new NPCMessage("user","How are you?"));
		chatlist.add(new NPCMessage("assistant","I'm Good"));
		chatlist.add(new NPCMessage("user", "What do you mean by that specifically"));
	 * 
	 * 
	 * ChatCompletionRequest chatrequest= ChatCompletionRequest.builder()
	.model("text-davinci-003")
	.messages(chatlist).build();*/
	
	/*
	 * Single completion example:
	 * CompletionResult result;
		CompletionRequest completionRequest = CompletionRequest.builder()
			    .prompt("How big is the moon")
			    .model("text-davinci-003")
			    .echo(false)
			    .build();
		
		
		result=AIservice.createCompletion(completionRequest);
	 * 
	 * 
	 * 
	 * */
	
	
	

	public void start() {
		running=true;
		thread= new Thread(this);
		thread.start();
		
	}


	public void Listen(Action a) {
		for(ActionListener al: listeners) {
			al.Listen(a);
		}	
	}




	
}
