package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {	
	
	private static Reader reader;
	private BufferedReader br;
	
	private Reader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static Reader getInstance() {
		if (reader == null) 
			reader = new Reader();
		return reader;
	}
	
	public String read() throws IOException {
		return br.readLine();
	}
	
	public int readInt() throws IOException {
		return Integer.parseInt(read());
	}
	
	public char readChar() throws Exception {
		return read().charAt(0);
	}

}
