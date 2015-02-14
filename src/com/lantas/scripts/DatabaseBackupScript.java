package com.lantas.scripts;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;

/**
 * Created by maksud on 2/14/15.
 */
public class DatabaseBackupScript {


    public static void main(String[] args) throws IOException {

    	String DB_NAME = "";
        String DATABASE_BACKUP_PATH_ON_DEVICE = "";
        
        
        String path = DatabaseBackupScript.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String decodedPath = URLDecoder.decode(path, "UTF-8");
        File decodedFile = new File(decodedPath);
        File decodedDir = decodedFile.getParentFile();
        
        File destinationFile = new File(decodedDir.getPath());
        String DATABASE_DESTINATION_PATH_ON_MACHINE = destinationFile.getPath();
        
        File outputFile = new File(decodedDir , DB_NAME);
        
        if(args != null){
        	if(args.length > 1){
        		DB_NAME = args[0];
        		
        		File sourceDir = new File(args[1]);
        		DATABASE_BACKUP_PATH_ON_DEVICE = (new File( sourceDir , DB_NAME )).getPath() ;
        	}
        }
        
        if(DATABASE_BACKUP_PATH_ON_DEVICE == null){
        	/**
        	 * NO parameter passed
        	 */
        	System.out.println("No source path specified. Please check whether the localtion to sync from Device is specified properly or not.");
        }
        else{
        	String COMMAND = "adb-sync --reverse" + " "+ DATABASE_BACKUP_PATH_ON_DEVICE + " "+ DATABASE_DESTINATION_PATH_ON_MACHINE;

        	if(outputFile.exists()){
        		outputFile.delete();
        	}
            StringBuffer output = new StringBuffer();
            Process p;
            try {
                System.out.println( "Starting the command to Pulling Database" );
                p = Runtime.getRuntime().exec(COMMAND);
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(p.getInputStream()));

                System.out.println("Ended Processing the Command");
                String line = "";
                while ((line = reader.readLine())!= null) {
                    output.append(line + "\n");
                }
                System.out.printf(output.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
