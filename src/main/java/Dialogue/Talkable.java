package Dialogue;

import java.util.ArrayList;
import java.util.List;

import com.theokanning.openai.completion.chat.ChatMessage;

import Entities.Mobs.Player;

public interface Talkable {

public void requestResponse(Player player, String prompt);
	
}
