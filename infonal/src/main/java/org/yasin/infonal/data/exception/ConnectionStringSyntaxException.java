package main.java.org.yasin.infonal.data.exception;

public class ConnectionStringSyntaxException extends Exception {

	public ConnectionStringSyntaxException(){
		super();
	}
	
	public ConnectionStringSyntaxException(String string){
		super(string);
	}
}
