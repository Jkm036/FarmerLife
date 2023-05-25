package Entities.Mobs;

import java.util.Random;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import java.util.List;
import java.util.ArrayList;

import Dialogue.DialogueBox;
import Dialogue.Talkable;
import Main.Game;
public class Character extends Mob implements Talkable{
	ChatCompletionResult response;
	String reply= null;
	List<ChatMessage> dialogue_stream;
	String role;
	String background;
	DialogueBox dialogue_output= Game.dialogue_output;
	
	int relationship;
	public boolean inDialogue;
	Random random;
	
	protected Character(int xPos, int yPos, String role) {
		super(xPos, yPos);
		this.role=role;
		background="Act like you are an NPC in a video game talking to the user."
				    +  " Act like you are a " + role + "in the world of "+ Game.WORLD_NAME + 
				    ". Your job is to respond to the user in the most immersive and accurate way possible";
		dialogue_stream= new ArrayList<ChatMessage>();
		dialogue_stream.add(new ChatMessage("system", background));
		random=new Random();
		
		// TODO Auto-generated constructor stub
	}

	public void tick() {
		super.tick();	
		if(!inDialogue) {
			//random movement
			if(time%(random.nextInt(400) + 30) == 0) {
				int movement=random.nextInt(2);
				if(movement==0) {
				up=random.nextBoolean();
				right=random.nextBoolean();
				}
				if(!up) {
				down=random.nextBoolean();
				}
				if(!right) {
				left=random.nextBoolean();
				}
				moving= (up || down || left || right);
						if (random.nextInt(3) == 0) {
							up=false;
							down=false;
							left=false;
							right=false;
							moving=false;
						}
			}
		}else {
			up=false;
			down=false;
			left=false;
			right=false;
			moving=false;
		}
	}
	public void inDialogue() {
		this.inDialogue=true;
	}
	public void performDialogue() {
		// make call to GPT
	}
	public Character getOuter() {
		return this;
	}
	@Override
	public void requestResponse(Player player, String prompt) {
		dialogue_output.setVisible(true);
		dialogue_stream.add(new ChatMessage("user",prompt));
	    ChatCompletionRequest chatrequest= ChatCompletionRequest.builder()
			 							   .model("gpt-3.5-turbo-0301")
			 							   .messages(dialogue_stream)
			 							   .temperature(1.0)
			 							   .n(1)
			 							   .maxTokens(20)
			 							   .build();
	    Thread dialogue_response = new Thread(new Runnable (){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				 response =Game.AIservice.createChatCompletion(chatrequest);
				 reply= response.getChoices().get(0).getMessage().getContent();
				 dialogue_output.setText(reply);
				 dialogue_stream.add(new ChatMessage("system",reply));
				 try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 dialogue_output.setVisible(false);
				 dialogue_output.clearText();
				 player.startDialogue(getOuter());
			}   	
	    });
	    dialogue_response.start();
	    Thread dialogue_waiting = new Thread(new Runnable (){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				 while(reply==null) {
					 dialogue_output.setText("Let me think about that...");
					 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }	
			}   	
	    }); 
	    dialogue_waiting.start();
		
	}



}
