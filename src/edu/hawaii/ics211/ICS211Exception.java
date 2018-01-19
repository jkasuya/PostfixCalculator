package edu.hawaii.ics211;

/**
 *
 * A generic ics211 runtime exception
 * Spring 2017
 *
 */
@SuppressWarnings("serial")
public class ICS211Exception extends RuntimeException {

	//Default constructor
	public ICS211Exception(){
		super();
	}
	
	//Constructor with message
	public ICS211Exception(String msg){
		super(msg);
	}
}
