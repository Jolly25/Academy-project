package com.corso.checkstring;

public class Fisher extends CheckStringWithList{

	private int threshold;

	public Fisher() {
		this.threshold = 2;
	}

	@Override
	protected AlgorithmType getAlgo() {
		return AlgorithmType.Fisher;
	}

	@Override
	protected boolean internalcheck(String s, String input) {
		int distance = getDistance(s, input);
		if(distance <= threshold) {
			return true;
		}
		return false;
	}

	private int getDistance(String str1, String str2) {
		int l1 = str1.length(); 
		int l2 = str2.length(); 

		if (l1 == 0) 
			return l2; 

		if (l2 == 0) 
			return l1; 

		int arr[][] = new int[l1 + 1][l2 + 1]; 

		for (int i = 0; i <= l1; i++) 
			arr[i][0] = i; 

		for (int j = 0; j <= l2; j++) 
			arr[0][j] = j; 

		for (int i = 1; i <= l1; i++) { 
			char ch1 = str1.charAt(i - 1); 

			for (int j = 1; j <= l2; j++) { 
				char ch2 = str2.charAt(j - 1); 

				int m = ch1 == ch2 ? 0 : 1; 

				arr[i][j] = Math.min( 
						Math.min((arr[i - 1][j] + 1), 
								(arr[i][j - 1] + 1)), 
						arr[i - 1][j - 1] + m); 
			} 
		} 

		return arr[l1][l2]; 
	}


}

