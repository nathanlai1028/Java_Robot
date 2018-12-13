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
    	boolean noError = false;
    	do {
    		noError = false;
	    	try {
	        	return (String)sysClip.getData(DataFlavor.stringFlavor);
	        } catch (NullPointerException | IllegalStateException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            
	        	noError = true;
	        	  try {
	                  Thread.sleep(40);
	              } catch (InterruptedException ex) {
	              }

	        } catch (UnsupportedFlavorException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();      
	            noError = true;
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            noError = true;
	        }
    	}while(noError);
      
        return "";
              
    
    	}
//    }
    
    
    public void clearClipBoard()/* throws HeadlessException,
    UnsupportedFlavorException, IOException*/ {
    	boolean noError = false;
    	do {
    	try {
            sysClip.setContents(new StringSelection(" "), this);
            noError = false;
        } catch (HeadlessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();    
            //noError = true;
        } 
    	catch (NullPointerException | IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            noError = true;
            	try {
                Thread.sleep(40);
            	} catch (InterruptedException ex) {
            	}
          }
    	}while(noError);  	
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
