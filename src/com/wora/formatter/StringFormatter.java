package com.wora.formatter;

public class StringFormatter {

	public static synchronized String format(String text, Object... parameters) {

		try {
			int beginIndex = 0;
			String delimeter = "{" + beginIndex + "}";

			if (parameters != null && parameters.length > 0) {
				
				if(text.indexOf(delimeter) > -1){
					while (text.indexOf(delimeter) > -1) {
						String formatParam = (String) parameters[beginIndex];
						text = text.replace(delimeter, formatParam);
						beginIndex++;
						delimeter = "{" + beginIndex + "}";
					}
					
				}else{
					throw new RuntimeException("No matched any format in text!");
				}
			}else{
				return text;
			}

		} catch (Exception e) {
			// logger.error(e, e);
			e.printStackTrace();
		}

		return text;
	}

	public static void main(String[] args) {

		String text = "Hello, {0}. How {1} are you?";

		System.out.println(StringFormatter.format(text, "Alican", "old"));

	}

}
