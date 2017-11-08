package cm.mldn.main.util.text;

import java.math.BigDecimal;

public class MathTest {
	public static void main(String[] args) {
		 BigDecimal bs = new BigDecimal(new Double(250.999999).toString());
		 Double hand = bs.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	System.out.println("hand" + hand);
	}
}
