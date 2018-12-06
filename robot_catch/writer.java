package robot_catch;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class writer {

		private static final String FILENAME = "D:\\sysConTest\\filename.txt";
		String[] propertyRecord;
		
		
//		public writer() {
//			writer(propertyRecord);
//		}
		public void writer(String[] propertyRecord) {
			getString(propertyRecord);
			
			BufferedWriter bw = null;
			FileWriter fw = null;
			
			try {							
				fw = new FileWriter(FILENAME,true);
				bw = new BufferedWriter(fw);
										
				for(int i=0; i < propertyRecord.length; i++) {
				String content = propertyRecord[i];
							
				bw.write(content);
				bw.write(";");
				
					if(i == propertyRecord.length - 1) {
						//bw.write('\n');
						bw.newLine();
						System.out.println("CP1");
					}
				}
				System.out.println("Done");

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}

		}

		
		
		private void getString(String[] propertyRecord) {  //Get Length
			
			this.propertyRecord = propertyRecord;
		}
	
	}

