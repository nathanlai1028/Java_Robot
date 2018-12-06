package robot_catch;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
public class RobotOperation {
 
//	public static void mouseOp1(double startX, double startY, double secX,double secY, double endX, double endY,double timeInterval) {
//		try {
//			Robot rbt = new Robot();
//			rbt.mouseMove((int) startX, (int) startY);// Initial Position
//			rbt.delay(100);// Delay 0.1s
//			rbt.mousePress(KeyEvent.BUTTON1_DOWN_MASK);// click
//			// rbt.delay(1000);
//			rbt.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);// release
//			rbt.delay((int) timeInterval);// delay
//			rbt.mouseMove((int) secX, (int) secY);
//			rbt.delay(100);
//			rbt.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
//			// rbt.delay(1000);
//			rbt.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
//			rbt.delay((int) timeInterval);
//			rbt.mouseMove((int) endX, (int) endY);
//			rbt.delay(100);
//			rbt.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
//			// rbt.delay(1000);
//			rbt.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
//			rbt.delay((int) timeInterval);
// 
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public static void switchWindows() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_TAB);
			r.delay(20); //set the delay
			r.keyRelease(KeyEvent.VK_ALT);
			r.keyRelease(KeyEvent.VK_TAB);
		}
		catch (AWTException e) {
//			// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	public static void selectCtrl() {   //Ctrl+A to full selection
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.delay(20); //set the delay
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
		}
		catch (AWTException e) {
		e.printStackTrace();
		}	
	}
	
	public static void selectLeftShift() {   //Ctrl+A to full selection
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_SHIFT);
			
			int fieldNumber = 10;              //Set the number program needs to highlight
			for(int i= 0; i<fieldNumber;i++) {
			r.keyPress(KeyEvent.VK_LEFT);
			r.delay(10);
			r.keyRelease(KeyEvent.VK_LEFT);
			r.delay(10);
			}
			r.delay(20); //set the delay
			
			
			r.keyRelease(KeyEvent.VK_SHIFT);

		}
		catch (AWTException e) {
		e.printStackTrace();
		}	
	}
	
	public static void selectRightShift() {   //Ctrl+A to full selection
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_SHIFT);
			int fieldNumber = 10;              //Set the number program needs to highlight
			for(int i= 0; i<fieldNumber;i++) {
			r.keyPress(KeyEvent.VK_RIGHT);
			r.delay(10);
			r.keyRelease(KeyEvent.VK_RIGHT);
			r.delay(10);
			}
			
			r.delay(20); //set the delay
			
			
			r.keyRelease(KeyEvent.VK_SHIFT);

		}
		catch (AWTException e) {
		e.printStackTrace();
		}	
	}
	
	
	public static void copy() {   //Copy Data
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.delay(10); //set the delay
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_C);
		}
		catch (AWTException e) {
		e.printStackTrace();
		}	
	}
	
	
	public static void tab() {  //Use Tap to change fields
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.delay(30); //set the delay
			r.keyRelease(KeyEvent.VK_TAB);
		}
		catch (AWTException e) {
		e.printStackTrace();
		}	
	}
	
	public static void f5() {  //Use f5 to change PAGES
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_F5);
			r.delay(30); //set the delay
			r.keyRelease(KeyEvent.VK_F5);
		}
		catch (AWTException e) {
		e.printStackTrace();
		}	
	}
	
	public static void escape() {  //Use escape to go to index
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.delay(30); //set the delay
			r.keyRelease(KeyEvent.VK_ESCAPE);
		}
		catch (AWTException e) {
		e.printStackTrace();
		}	
	}
	
	public static void delay() { //set the delay
		try {
			Robot r = new Robot();
			r.delay(3000); 
		}
		catch (AWTException e) {
		e.printStackTrace();
		}	
		
	}
	public static void shortDelay() { //set the delay
		try {
			Robot r = new Robot();
			r.delay(30); 
		}
		catch (AWTException e) {
		e.printStackTrace();
		}	
		
	}
	
	
	
	
}
	

