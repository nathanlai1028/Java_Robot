package robot_catch;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

class ClipboardTest
{
//	public ClipboardTest() {
//		
//    	System.out.println(getClipBoard());
//	}
//    public static void main(String[] args)
//        throws UnsupportedFlavorException, IOException
//    {
//    	new ClipboardTest();
//    }
    
    public String getClipBoard(){
        try {
        	System.out.println("CP1");
            return (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (HeadlessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();            
        } catch (UnsupportedFlavorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
}
