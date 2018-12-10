package robot_catch;
import java.io.*;
import java.util.*;
//package com.sjc.toy;
import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.*;


public class robot {
	public String property[] = new String[40];
	RobotOperation action = new RobotOperation();
	writer test = new writer();
	ClipboardTest clip = new ClipboardTest();
	
	public robot()throws HeadlessException,
    UnsupportedFlavorException, IOException{
		actionRetail();				// Use Unicorn Retail Program to be a demo
//		action();					// Real implements program
	}
	
	
	public void action() throws NullPointerException,
    IllegalStateException,UnsupportedFlavorException, IOException{
		int propertyNumber = 10;					//Set how many property record to Loop
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
		action.switchWindows();
		action.delay();
		}
		
		
		
		
		
		
		
		
		
		}
	}
	
	public void actionRetail() throws HeadlessException,
    UnsupportedFlavorException, IOException {
		int propertyNumber = 6;					//Set how many property record to Loop
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
		
		/*Here I will skip the other field to the contacts field*/
		
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
	
//	public void selectCopy() {
//		action.selectCtrl();
//		action.copy();
//	}
	
	public void doubleTab() {
		action.tab();
		action.tab();
	}
	
	private void checking() {
		for (int i = 0; i<property.length; i++ ) {
			System.out.println(property[i]);
		}
	}


//	public void doThis(){
//		T t = new T();
//		t.start();
//	}
	
//	class T extends Thread{
//		
//		@Override
//		public void run(){
//			try {
//				Robot robot = new Robot();
//				while(true) {
//					Process p = Runtime.getRuntime().exec("H:\\ChinaNetSn\\bin\\NetKeeper.exe");
//					Thread.sleep(1000);
//					
//					//要7个Tab键才能使焦点位于登录按钮上					
//					for(int i=0; i<7; i++) {
//						robot.keyPress(KeyEvent.VK_TAB);
//						robot.keyRelease(KeyEvent.VK_TAB);
//					}							
//					
//					robot.keyPress(KeyEvent.VK_ENTER);
//					robot.keyRelease(KeyEvent.VK_ENTER);
//					Thread.sleep(120000);
//					p.destroy();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	
	

public static void main(String[] args)throws HeadlessException,
UnsupportedFlavorException, IOException{
	//new robot().doThis();
	new robot();
}
}