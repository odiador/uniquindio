import java.util.Scanner;

public class German {
	public static int countSigns(int n) {
		if (n < 10)
			return n + 1;
		String digString = n + "";
		int cantDig = digString.length();
		int firstNum = Character.getNumericValue(digString.charAt(0));
		String cad = "";
		for (int i = 0; i < cantDig; i++)
			cad += firstNum;
		int dupeNumber = Integer.parseInt(cad);
		return (cantDig - 1) * 10 + (firstNum + (n < dupeNumber ? -1 : 0));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sign = scanner.nextInt();
		System.out.println(countSigns(sign));
	}
}
