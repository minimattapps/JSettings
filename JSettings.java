package DragMath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Settings {
private String settingslocation;
private int MAXVALUES = 1000;
private String [] locations = new String[MAXVALUES];
private String [] values = new String[MAXVALUES];
private int stored = 0;
private boolean showlog = false;
	public Settings(String location){
		
		settingslocation = location;
		for (int i = 0; i < MAXVALUES;i++){
			locations[i] = new String();
			values[i] = new String();
			locations[i] = "";
			values[i] = "";
		}
		ReadSettings();
	}
	public void ShowLog (boolean state){
		showlog = state;
	}
	public void SetValue(String location,String value){
		ReadSettings();
		boolean alreadyset = false;
		for (int i = 0; i < stored; i++){
			if (locations[i].equals(location)){
				alreadyset = true;
				values[i] = value;
			}
		} 
		
		if (alreadyset == false){
		locations[stored] = location;
		values[stored] = value.replace(":", "(#)");
		stored++;
		}
		if (showlog == true){
		System.out.println("JSettings - Stored " + value + " in Location " + location);
		}
		SaveSettings();
		
	}
	
	public String GetValue(String location){
			   ReadSettings();
			    for (int i = 0; i < stored; i++){
			    	if (locations[i].equals(location)){
			    		if (showlog == true){
						    System.out.println("JSettings - Retrieved Value " + values [i] + " from Location " + location);
						    }
			    		return values[i];
			    	}
			    }
			    
			    return "";
			   
			  }
	
	
	
	private void ReadSettings(){
		
		   BufferedReader input;
		   locations = new String[MAXVALUES];
		   values = new String[MAXVALUES];
		   stored = 0;
			try {
				input = new BufferedReader(new FileReader(settingslocation));
		      try {
		        String line = null;
		        while (( line = input.readLine()) != null){
		        	try {
		         locations[stored] = line.split(":")[0];
		         values[stored] = line.split(":")[1].replace("(#)", ":");
		         stored++;
		        	} catch (Exception e){
		        		
		        	}
		        }
		       
		      }
		      finally {
		        input.close();
		      }
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (showlog == true){
			System.out.println("JSettings - Loaded Settings from File");
			}
	}
	
	public void ClearSettings(){
		locations = new String[MAXVALUES];
		   values = new String[MAXVALUES];
		   stored = 0;
		   if (showlog == true){
			  System.out.println("JSettings - Settings Cleared");
		   }
		   SaveSettings();
	}
	
	private void SaveSettings(){
		 try{
			  // Create file 
			  FileWriter fstream = new FileWriter(settingslocation);
			  BufferedWriter out = new BufferedWriter(fstream);
			  String data = "-----------------JSettings - https://github.com/minimattapps/JSettings-----------------\n";
			  for (int i = 0; i < stored;i++){
				  data = data + locations[i] + ":" + values[i] + "\n";
			  }
			  out.write(data);
			  //Close the output stream
			  out.close();
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		 if (showlog == true){
		 System.out.println("JSettings - Saved Settings to File");
		 }
	}
	
}
