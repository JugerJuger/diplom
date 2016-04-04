package web.controller.utilize;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	public static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String PHONE_REGEX = "^\\+(?:[0-9] ?){6,14}[0-9]$";

	public static boolean validation(String s, String regEx) {
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(s);
		return m.matches();
	}
}
