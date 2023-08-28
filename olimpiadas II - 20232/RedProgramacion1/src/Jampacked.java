
import java.util.Scanner;

public class Jampacked {
	public static long getMinJars(long n, long k) {
		if (k > n)
			return n;
		return k - getMinJarsAux(n, k, 0);
	}

	public static long getMinJarsAux(long n, long k, long cont) {
		if (n % k == 0)
			return cont;
		return getMinJarsAux(n - 1, k, cont + 1);

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long k = scanner.nextLong();
		System.out.println(getMinJars(n, k));
	}
}
