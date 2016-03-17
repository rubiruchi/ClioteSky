package net.estinet.ClioteSky.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.estinet.ClioteSky.Category;
import net.estinet.ClioteSky.Cliote;

public class Categories {
	public void load(){
		File f = new File("./Cliotes");
		String[] directories = f.list();
		List<File> categories = new ArrayList<>();
		for(String direct : directories){
			if(new File("./Cliotes/" + direct).isDirectory()){
				categories.add(new File("./Cliotes/" + direct));
			}
		}
		for(File file : categories){
			Category cat = new Category(file.getName());
			for(File cliotes : file.listFiles()){
				try{
				

				Properties prop = new Properties();
				InputStream input = null;

				try {

					input = new FileInputStream(f.getPath());

					prop.load(input);
					
					Cliote cliote = new Cliote(prop.getProperty("name"), prop.getProperty("ip"), prop.getProperty("port"));
					cat.addCliote(cliote);
				} catch (IOException ex) {
					ex.printStackTrace();
				} finally {
					if (input != null) {
						try {
							input.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				}
				catch(Exception e){
					System.out.println("Error loading Cliote " + cliotes.getName());
					e.printStackTrace();
				}
			}
		}
	}
}