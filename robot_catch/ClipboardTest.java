package robot_catch;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

class ClipboardTest extends Thread implements ClipboardOwner
{ 
	Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
//	public ClipboardTest() {
//		clearClipBoard();
//    	System.out.println(getClipBoard());
//	}
//    public static void main(String[] args)
//        throws UnsupportedFlavorException, IOException
//    {
//    	new ClipboardTest();
//    }
    
    public String getClipBoard() throws NullPointerException,
    IllegalStateException,UnsupportedFlavorException, IOException{
    	
//    	while(true) {
        try {
        	//System.out.println("CP1");
            //return (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        	return (String)sysClip.getData(DataFlavor.stringFlavor);
        } catch (NullPointerException | IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();            
        } catch (UnsupportedFlavorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Thread.sleep(40);
        } catch (InterruptedException ex) {
        }
        return "";
              
    
    	}
//    }
    
    
    public void clearClipBoard()/* throws HeadlessException,
    UnsupportedFlavorException, IOException*/ {
    	try {
            sysClip.setContents(new StringSelection(" "), null);
        } catch (HeadlessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();            
        } 
    	catch (NullPointerException | IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(); }
    	
    }
    
    public void lostOwnership(Clipboard c, Transferable t) {
    	  try {
    	    this.sleep(50);
    	  } catch(Exception e) {
    	    System.out.println("Exception: " + e);
    	  }
    	  Transferable contents = sysClip.getContents(this);
    	  regainOwnership(contents);
    	}
    
    void regainOwnership(Transferable t) {
        sysClip.setContents(t, this);
      }
}
