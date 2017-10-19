package com.taotao.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class StractTrace {

	public static String getStraceTrace(Throwable throwable){
		Writer writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		throwable.printStackTrace(printWriter);
		return writer.toString();
	}
}
