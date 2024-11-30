package com.ems.ixchange.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/** This class represents a chat room in the Chat System
*/
public class ChatRoom
{
	/*
	* used to store name of the room
	*/
	
	private String name;
	private String description;
	private Map<String, Chatter> chatters;
	private List<Message> messages;
	private int messages_size;
	/**
	* This constructor takes a name and description
	* to create a new ChatRoom
	* @param name Name of the Room
	* @param descr Description of the Room
	*/
	public ChatRoom(String name, String descr)
	{
		this.name= name;
		this.description = descr;
		this.chatters = new HashMap<String, Chatter>();
		this.messages = new LinkedList<Message>();
		this.messages_size = 25;
	}
	
	/**
	* Returns name of the room
	* @return java.lang.String
	*/
	public String getName()
	{
		return name;
	}
	
	/**
	* Returns description of the room
	* @return java.lang.String
	*/
	public String getDescription()
	{
		return description;
	}
	
	/**
	* adds a Chatter object to list of Chatters
	* @param chatter Chatter object
	* @return voidgetName 
	*/
	public synchronized void addChatter(Chatter chatter)
	{
		chatters.put(chatter.getMemberId(), chatter);
	}
	/**
	* removes a Chatter object from list of Chatters
	* @param chatterName name of the chatter.
	* @return void
	*/
	public synchronized Object removeChatter(String chatterId)
	{
		return chatters.remove(chatterId);
	}
	
	/**
	* returns a Chatter object from chatters list.
	* @param chatterName name of the chatter
	* @return sukhwinder.chat.Chatter
	*/
	public Chatter getChatter(String chatterId)
	{
		return (Chatter)chatters.get(chatterId);
	}
	
	/**
	* checks whether a chatter exists or not
	* @param chatterName name of the chatter to check
	* @return boolean
	*/
	
	public boolean chatterExists(String chatterId)
	{
		return chatters.containsKey(chatterId);
	}
	
	/**
	* returns total number of chatters in this room
	* @return int
	*/
	public int getNoOfChatters()
	{
		return chatters.size();
	}
	
	/**
	* returns a Set containing all the Chatters in the room
	* @return java.util.Set
	*/
	public Set<Map.Entry<String, Chatter>> getChatters()
	{
		return chatters.entrySet();
	}
	
	/** returns an array containing all Chatter objects
	* @return sukhwinder.chat.Chatter[]
	*/
	public Chatter[] getChattersArray()
	{
		Chatter[] chattersArray = new Chatter[chatters.size()];
		Set<Map.Entry<String, Chatter>> chatters = getChatters();
		Iterator<Entry<String, Chatter>> chattersit = chatters.iterator();
		int i = 0;
		while(chattersit.hasNext())
		{
			Map.Entry<String, Chatter> me = (Map.Entry<String, Chatter>) chattersit.next();
			chattersArray[i] = (Chatter)me.getValue();
			i++;
		}
		return chattersArray;
	}
	
	/** adds the message to the messages list
	* @param msg A Message Object
	* @return void
	*/
	public synchronized void addMessage(Message msg)
	{
		if(messages.size()==messages_size)
		{
			((LinkedList<Message>)messages).removeFirst();
		}
		messages.add(msg);
	}
	
	/**
	* returns a ListIterator object containing all the messages
	* @return java.util.ListIterator
	*/	
	public ListIterator<Message> getMessages()
	{
		return messages.listIterator();
	}

	/**
	* returns an array of messages sent after given time
	* @param afterTimeStamp Time in milliseconds.
	* @return array
	*/	
	public Message[] getMessages(long afterTimeStamp)
	{
		ListIterator<Message> li = messages.listIterator();
		List<Message> temp = new ArrayList<Message>();
		Message m;
		while (li.hasNext())
		{
			m = (Message)li.next();
			if (m.getTimeStamp() >= afterTimeStamp)
			{
				temp.add(m);
			}
		}
		Object o[] = temp.toArray();
		Message[] arr = new Message[o.length];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = (Message)o[i];
		}
		return arr;
	}

	/**
	* returns total number of messages in the messages List
	* @return int
	*/
	public int getNoOfMessages()
	{
		return messages.size();
	}
	
	/**
	* sets maxmium number of messages to this number.
	* @param size the maximum no of messages to hold at a time.
	* @return void
	*/
	public void setMaximumNoOfMessages(int size)
	{
		messages_size = size;
	}
	
	/**
	* returns maxmium number of messages set.
	* @return int
	*/
	public int getMaxiumNoOfMessages()
	{
		return messages_size;
	}
}