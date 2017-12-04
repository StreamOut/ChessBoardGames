package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import game.ChessBoard;
import game.Piece;
import game.Vector;

public class ConfigLoader {
	
	public static void loadConfigFile(String file, ChessBoard game) {
		String json = "";
		try{
			InputStream ips= new FileInputStream(file); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				json+=ligne+"\n";
			}
			
			br.close(); 
		}		
		catch (Exception e){
			System.out.println("Read file" +e.toString());
		}
		//System.out.println(json);
		JSONParser parser = new JSONParser();
		try{
	         Object obj = parser.parse(json);
	         JSONArray array = (JSONArray)obj;
	         Piece piece;
				
	         System.out.println("The name : "+ array.get(0));
	         for (int i = 1; i < array.size(); i++) {
	        	 System.out.println();
	        	 //System.out.println(array.get(i));
	        	 JSONObject obj1 = (JSONObject) array.get(i);
	        	 System.out.println("The name : "+ obj1.get("name"));
		         System.out.println("The draw : "+ obj1.get("draw"));
		         System.out.println("Mouvements :");
		         piece = new Piece(""+i, (String)array.get(0), "lol", ((String) obj1.get("draw")).charAt(0));
		         JSONArray mouvements = (JSONArray) obj1.get("mouvements");
		         for (int j = 0; j < mouvements.size(); j++) {
		        	 JSONObject obj2 = (JSONObject) mouvements.get(j);
		        	 System.out.println(mouvements.get(j));
		        	 System.out.println(j +"\t"+obj2.get(String.valueOf(j+1)));
		        	 String test = obj2.get(String.valueOf(j+1)).toString();
		        	 System.out.println(test);
		        	 Vector vector = new Vector(test);
		        	 //System.out.println(vector.getWay()[0]);
		        	 piece.addMovement(vector);
		         }
		         System.out.println("Prises :");
		         System.out.println("\t"+obj1.get("prises"));
		         System.out.println("Position : " + Integer.valueOf((String) obj1.get("i")) + " "+Integer.valueOf((String) obj1.get("j")));
		         game.addPiece(piece, Integer.valueOf((String) obj1.get("i")), Integer.valueOf((String) obj1.get("j")));
	         }
	         
	         //System.out.println(obj);
	      }catch(ParseException pe){
			
	         System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
	      }
	}

}
