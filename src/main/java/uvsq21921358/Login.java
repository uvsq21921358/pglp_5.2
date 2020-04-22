package uvsq21921358;

import java.time.LocalDateTime;
// 
public class Login implements LogInterface {

	public void write(String string) {
		System.out.println(LocalDateTime.now() + ": " + string);
	}
}
