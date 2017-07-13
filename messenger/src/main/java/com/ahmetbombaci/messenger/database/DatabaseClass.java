package com.ahmetbombaci.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.ahmetbombaci.messenger.model.Message;
import com.ahmetbombaci.messenger.model.Profile;

public class DatabaseClass {
	public static Map<Long, Message> messages = new HashMap<>();
	public static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
