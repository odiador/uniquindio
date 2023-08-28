import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Investigating {
	public static int[] getFrogEndPlaces(String posString, int[] moves) {
		List<Integer> positions = Arrays.stream(posString.split(" ")).map(r -> Integer.parseInt(r))
				.collect(Collectors.toList());
		for (int i = 0; i < moves.length; i++) {
			actualizarMovimientos(moves, positions);
			agregarPosiciones(moves, positions, i);
			Collections.sort(positions);
		}
		actualizarMovimientos(moves, positions);
		return moves;
	}

	private static void actualizarMovimientos(int[] moves, List<Integer> positions) {
		for (int i = 0; i < moves.length; i++) {
			int indice = moves[i] - 1;
			moves[i] = positions.get(indice);
		}
	}

	private static void agregarPosiciones(int[] moves, List<Integer> positions, int i) {
		for (int j = moves[i]; j < positions.size(); j++) {
			if (positions.get(j) != j + 1) {
				positions.add(j + 1);
				moves[i] = j + 1;
				return;
			}
		}
		int pos = positions.get(positions.size() - 1) + 1;
		positions.add(pos);
		moves[i] = pos;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String next = null;
		if (sc.hasNextLine())
			next = sc.nextLine();
		int q = -1;
		if (sc.hasNextInt())
			q = sc.nextInt();
		int pos[] = new int[q];
		for (int i = 0; i < q; i++) {
			pos[i] = sc.nextInt();
		}
		int[] endPlaces = getFrogEndPlaces(next, pos);
		for (int i : endPlaces)
			System.out.println(i);
	}
}
