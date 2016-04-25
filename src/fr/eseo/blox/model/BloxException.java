package fr.eseo.blox.model;

@SuppressWarnings("serial")
public class BloxException extends Exception{ 

	public static final int BLOX_COLLISION = 1;
	public static final int BLOX_LEFT_GAMEBOARD = 2;

	private int ExceptionCause;
	
	public BloxException(String message, int cause) {
		super(message);	
		this.ExceptionCause = cause;
	}
	
	public int getExceptionCause() { /* Methode non utilisee */
		return this.ExceptionCause;	
	}
	
}
