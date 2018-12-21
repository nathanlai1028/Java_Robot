package robot_catch;
import java.io.*;
import java.util.*;
//package com.sjc.toy;
import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.*;


public class robot {
	public String property[];
	RobotOperation action = new RobotOperation();
	writer test = new writer();
	ClipboardTest clip = new ClipboardTest();
	scanner scan = new scanner();
	private int option = 2;				//Default use Ctrl+A to select all
	private int propertyNumber;
	private int page2Needed=2;
	
	public robot()throws HeadlessException,
    UnsupportedFlavorException, IOException{
//		getInformation();
//		actionRetail();				// Use Unicorn Retail Program to be a demo
		action();					// Real implements program
			}															
			
	public void getInformation() {				// Real implements program			Check OK
		this.propertyNumber = scan.getPropertyNumber();
		//this.option = scan.getMethod();
		this.page2Needed = scan.getNeedSecondPage();
		if (this.page2Needed == 1) {
			 property = new String[80];
		}
		else { property = new String[127];}
//		System.out.println("You entered number " + propertyNumber + ";" + option +";" + page2Needed);
	}
	
	
	public void action() throws NullPointerException,					// Real implements program
    IllegalStateException,UnsupportedFlavorException, IOException{
		propertyNumber = 3;					//Test Property Number avoiding input number
		for (int i = 0; i < propertyNumber; i++) {
		int pointer = 0;
		
		if(i != 0){ 							// Tab to Street Name
			action.delay();
			// Need to understand how many fields need to tab after going into next property record
			if(page2Needed == 1 ) {				
			action.f5();
			}
			action.shortDelay();	
		}
		else {
		action.switchWindows();					// Switch to the program
		action.delay();
		}
		
		//Start Copying   Not finish YET
		pointer = page1Up(pointer);
		action.shortDelay();	
		pointer = page1Down(pointer);
		
		
			if(page2Needed == 1 ) {				
			action.f5();
			pointer = page2up(pointer);
			//			pointer = page2down(pointer);
			
			}
		test.writer(property,pointer);	
		action.pageDown(); 						//Next Property Record	
			
		}
	}
	
	public int page1Up(int pointer)throws HeadlessException,
    UnsupportedFlavorException, IOException {        // Real implements program
		
		for (int j = 0; j < 15 ; j++) {      		// To Unit
		_selectionMethod();
		pointer = _normalCopy(pointer);				//Usage
//		action.shortDelay();
		action.tab();	
		}
//		From Property Number to Rent Consent

		for (int j = 0; j < 8 ; j++) {      		
		_selectionMethod();
		pointer = _normalCopy(pointer);				//Usage
//		action.shortDelay();
		action.tab();	
		}
		
		
		return pointer;
	}
	
	public int page1Down(int pointer)throws HeadlessException,
    UnsupportedFlavorException, IOException {        // Real implements program
		
		for (int j = 0; j < 43 ; j++) {      		// From Gross Area
			if(j < 34 || j > 37) {					//LandReg to photo checkbox
			_selectionMethod();
			pointer = _normalCopy(pointer);				//Usage
			action.shortDelay();
			action.tab();
			}
			else{		//Property Number; Contact Post; Commission
				action.tab();						//Extra Tab to avoid call master
			}
		}		
		return pointer;
	}
	
	public int page2up(int pointer)throws HeadlessException,
    UnsupportedFlavorException, IOException {        // Real implements program
		
		for (int j = 0; j < 47 ; j++) {      		// To PRN
			if(j == 3 || j == 6|| j == 10 || j == 12) {
				action.tab();
			}
			else {
		_selectionMethod();
		pointer = _normalCopy(pointer);				//Usage
//		action.shortDelay();
		action.tab();
			}
		}
		
		return pointer;
	}
	
	public int page2down(int pointer)throws HeadlessException,
    UnsupportedFlavorException, IOException {        // Real implements program
		
		for (int j = 0; j < 13 ; j++) {      		// To PRN
		_selectionMethod();
		pointer = _normalCopy(pointer);				//Usage
//		action.shortDelay();
		action.tab();
			if(j < 5 || j > 9) {					// Range out side @Management Fee to G.Rent
				action.tab();
			}
			
		}
		
		return pointer;
	}
	
	

	public void actionRetail() throws HeadlessException,
    UnsupportedFlavorException, IOException {
		int propertyNumber = 7;					//Set how many property record to Loop
		for (int i = 0; i < propertyNumber; i++) {
		int pointer = 0;
		if(i != 0){ 							// Tab to Street Name
			action.delay();
			for(int j = 0; j< 15; j++) {
				action.tab();
			}
			action.shortDelay();
		}
		else {
		action.switchWindows();					//First time Switch to Retail Program
		action.delay();
		}
		pointer = street(pointer);					//Street
//		System.out.println("Pointer:" + pointer);
		action.selectRightShift();					//Building
		pointer = _normalCopy(pointer);
				
		doubleTab();
		
		pointer = _normalCopy(pointer);				//DD Lot
		action.tab();
		action.dontHighlight();	
		action.selectRightShift();					//Shop No
		pointer = _normalCopy(pointer);
		action.tab();
		action.dontHighlight();	
		action.selectRightShift();					//Chinese Floor Name
		pointer = _normalCopy(pointer);
		action.tab();
		action.dontHighlight();						//English Floor Name
		action.selectRightShift();
		pointer = _normalCopy(pointer);				
		action.tab();
		action.dontHighlight();						//Facing
		action.selectRightShift();
		pointer = _normalCopy(pointer);					
		action.tab();
		pointer = _normalCopy(pointer);				//Area
		action.tab();
		
		
		for(int j = 0; j< 4; j++) {
		pointer = _normalCopy(pointer);				//Gross Area
		action.tab();
		pointer = _normalCopy(pointer);				//Net Area
		doubleTab();
		}
		
		action.tab();								//Tab after * button
		
//		Here I will skip the other field to the contacts field
		
		for(int j =0; j<18 ; j++) {
			action.tab();
		}
		
		action.selectRightShift();					//Company Name
		pointer = _normalCopy(pointer);					
		action.tab();
		
		for(int j = 0; j< 2; j++) {
		action.selectRightShift();					//Contact 1
		pointer = _normalCopy(pointer);					
		action.tab();
		action.tab();
		action.tab();
		action.selectRightShift();					//Number 1
		pointer = _normalCopy(pointer);	
		doubleTab();
		action.selectRightShift();					//Number 2
		pointer = _normalCopy(pointer);	
		doubleTab();
		}
		
		test.writer(property,pointer);
		
		
		
		action.pageDown();
		checking();
		}
		//Finish First Turn
		
		
		
	}
	
	
	public int street(int pointer)throws HeadlessException,
    UnsupportedFlavorException, IOException {         //Retail Program Use Only
		for(int i = 0; i< 4; i++) {
		action.selectRightShift();
		pointer = _normalCopy(pointer);	
		action.shortDelay();
		
		doubleTab();						
		action.selectRightShift();					//Copy Street Number
		pointer = _normalCopy(pointer);	
		
		action.tab();
		
		if(i == 0) {								//Copy District Code
		pointer = _normalCopy(pointer);	
		action.shortDelay();
		doubleTab();
			}
		}
		return pointer;
	}
	
	
	
	public int _normalCopy(int pointer)throws HeadlessException,
    UnsupportedFlavorException, IOException {
		action.shortDelay();						//Must ADD Delay time to avoid java.lang.IllegalStateException
		action.copy();
		action.shortDelay();	
		property[pointer] = "\"" + clip.getClipBoard() + "\"";
		pointer++;
		clip.clearClipBoard();
		return pointer;
	}
	
	public void _selectionMethod() {
		if(this.option == 1) {
			action.selectRightShift();
		}
		else {
			action.selectCtrl();
		}
	}
	
	public void doubleTab() {
		action.tab();
		action.tab();
	}
	
	private void checking() {						//Will Disable in live version
		for (int i = 0; i<property.length; i++ ) {
			System.out.println(property[i]);
		}
	}


	public static void main(String[] args)throws HeadlessException,
	UnsupportedFlavorException, IOException{
		new robot();
	}
	}