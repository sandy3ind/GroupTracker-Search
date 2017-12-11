package com.samyuktatech.util;

import com.samyuktatech.document.User;

public class Utility {

	/**
	 * Convert User from Model to User of Document to be used in Elasticsearch
	 * 
	 * @param modelUser
	 * @return
	 */
	public static User userModelToDocument(com.samyuktatech.comman.model.User modelUser) {
		
		User documentUser = new User();
		documentUser.setEmail(modelUser.getEmail());
		documentUser.setName(modelUser.getName());
		documentUser.setUserId(modelUser.getId());
		
		return documentUser;
	}
}
