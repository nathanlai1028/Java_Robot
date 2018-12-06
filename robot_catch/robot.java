package robot_catch;
//package com.sjc.toy;
import java.awt.Robot;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class robot {
	public String property[] = new String[30];
	RobotOperation action = new RobotOperation();
	writer test = new writer();
	ClipboardTest clip = new ClipboardTest();
	
	public robot() {
		actionRetail();
		
	}
	
//asjdfnhiasdhfijasdf
	
	public void selectCopy() {
		action.selectCtrl();
		action.copy();
	}
	
	public void doubleTab() {
		action.tab();
		action.tab();
	}
	
	public void normalCopy() {
		
	}
	

	public void actionRetail() {
		int pointer = 0;
		action.switchWindows();
		action.delay();
		action.selectRightShift();
		action.copy();
		property[pointer] = clip.getClipBoard();
		System.out.println("CP2: "+ property[pointer]);
		pointer++;
		action.shortDelay();
		doubleTab();
		action.copy();
		property[pointer] = clip.getClipBoard();
		System.out.println("CP3: "+ property[pointer]);
		pointer++;
		action.shortDelay();
		action.tab();
		action.copy();
		property[pointer] = clip.getClipBoard();
		System.out.println("CP2: "+ property[pointer]);
		
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
	

public static void main(String[] args){
	//new robot().doThis();
	new robot();
}
}