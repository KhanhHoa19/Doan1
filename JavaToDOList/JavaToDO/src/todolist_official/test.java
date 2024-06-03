package todolist_official;

import java.awt.Component;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class test {
public static void main(String[] args) {
	String tEmail="danglekhanhhoa19@gmail.com";
	String stdMail = "hk2056951@gmail.com";
	Pattern p = Pattern.compile("^[a-zA-Z] [a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$");
	if(p.matcher(stdMail).find())
	{
		stdMail = tEmail;
	}
	else
	{
       JOptionPane.showMessageDialog((Component)null, "Email đã nhập không hợp lệ");

	}
	System.out.println(stdMail);
}
}
