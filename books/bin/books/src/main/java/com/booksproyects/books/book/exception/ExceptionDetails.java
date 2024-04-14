package com.booksproyects.books.book.exception;

public class ExceptionDetails {
String UserMessage;
String severity;


public String getUserMessage() {
	return UserMessage;
}
public void setUserMessage(String userMessage) {
	UserMessage = userMessage;
}
public String getSeverity() {
	return severity;
}
public void setSeverity(String severity) {
	this.severity = severity;
}
public ExceptionDetails(String userMessage, String severity) {
	super();
	UserMessage = userMessage;
	this.severity = severity;
}


}
