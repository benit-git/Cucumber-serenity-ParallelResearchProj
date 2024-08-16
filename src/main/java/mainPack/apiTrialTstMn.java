package mainPack;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


public class apiTrialTstMn {

	public static String readJsonfile(int i) throws FileNotFoundException {
		File f = new File(System.getProperty("user.dir") + "//target//cucumber-parallel//" + i + ".json");
		Scanner sc = new Scanner(f);
		StringBuffer sbf = new StringBuffer();
		while (sc.hasNext()) {
			String s = sc.nextLine();
			if (!s.equals("]") && !s.equals("["))
				sbf.append(s + "\n");
		}
		sc.close();
		f.delete();
		return sbf.toString();
	}

	public static void consilidateJsonRepo() {
		JSONArray jary = new JSONArray();
		JSONObject job = new JSONObject();
		HashMap<String, JSONObject> repo = new HashMap<String, JSONObject>();
		// JSONObject fjob = new JSONObject();
		File directory = new File(System.getProperty("user.dir") + "//target//cucumber-parallel"); 
        File[] files = directory.listFiles(); 
		try {
			for (int i = 1; i <= files.length; i++) {
				String jo = readJsonfile(i);
				job = new JSONObject(jo);
				String key = job.get("id").toString().trim();
				if (!repo.containsKey(key)) {
					repo.put(key, job);
				} else {
					JSONArray jEl = job.getJSONArray("elements");
					JSONObject joTemp = repo.get(key);
					JSONArray jE2 = joTemp.getJSONArray("elements");
					for (int j = 0; j < jEl.length(); j++)
					jE2.put(jEl.get(j));
					repo.put(key, joTemp);
				}

			}

			// job.put("elements", jary);
			// System.out.println(jary);
			writeReportJson(repo);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void writeReportJson(HashMap<String, JSONObject> repo) throws IOException {
		for (String key : repo.keySet()) {
			JSONObject rep = repo.get(key);
			FileWriter myWriter = new FileWriter(
					System.getProperty("user.dir") + "//target//cucumber-parallel//" + key + ".json");
			myWriter.write("[" + rep.toString() + "]");
			myWriter.close();
			System.out.println("Successfully wrote to: " + key);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		consilidateJsonRepo();
	}

}
