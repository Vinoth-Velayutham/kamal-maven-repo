package swaglab;

import java.util.HashMap;

public class MaxRepeatedCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Vinoth Velayutham Automation Test Engineer".toLowerCase();

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
				}
			}
			map.put(str.charAt(i), count);
			count = 0;
		}
		System.out.println(map);

	}

}
