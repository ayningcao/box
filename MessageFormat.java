import java.util.Date;

/**
 * ��ʾ��Java�и�ʽ���ַ����ķ���
 * 
 * @author Alex
 *
 */
public class MessageFormat {

	public static void main(String[] args) {
		String source = "My name is {0}, and today is {1}";
		String output = java.text.MessageFormat.format(source, "Alex", new Date());
		System.out.println(output); //output: My name is Alex, and today is 15-8-8 ����2:13
	}

}
