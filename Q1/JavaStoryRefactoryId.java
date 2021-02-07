
import java.util.*;

class JavaStoryRefactoryId{
	public static String pad(String source, int targetLength, String pad) {
		StringBuilder result = new StringBuilder( source );
		for( int i = source.length(); i < targetLength; i+=pad.length() ) {
		  result.append(pad);
		}
		return result.toString();
	  }

	public static void main(String args[]){	
		Scanner scanner = new Scanner(System.in); // System.out.print("Hello "+ args[0]);

		System.out.print("Enter resto name: ");
		String strResto = scanner.nextLine();//"Warung Makan Sederhana";

		System.out.print("Enter date of print: ");
		String strDate = scanner.nextLine();// "2020/12/2020 15:30:00";

		System.out.print("Enter cashier name: ");
		String strCashier = scanner.nextLine();// "Jokowi dodo";
		
		List<String> mapItem = new ArrayList<>();

		while(true) {
			System.out.print("Enter item: ");
			String masakan = scanner.nextLine(); //"Nasi";
            mapItem.add(masakan);

			if(masakan.equals("exit")) {
				break;
			}
		}

		// String arr[] = {strItem};
	
		System.out.println(String.format("%30s", "=============================="));
		System.out.printf("%27s %n", wrapText(strResto, 30));
		System.out.printf("%-10s %20s %n", "Tanggal : ", wrapText(strDate, 20));
		System.out.printf("%-12s %18s %n", "Nama Kasir: ", wrapText(strCashier, 18));
		System.out.println(String.format("%30s", "=============================="));
		
		for(int i = 0; i < mapItem.size(); i++){
			System.out.println(String.format("%-"+(30-mapItem.get(i).length())+"s", mapItem.get(i)).replaceAll("\\s(?=\\s+$|$)", ".")+mapItem.get(i));
		}
	}

	private static String wrapText(String text, int max){
		StringBuilder sb = new StringBuilder(text);

		int i = 0;
		while ((i = sb.indexOf(" ", i + max)) != -1) {
			sb.replace(i, i + 1, "\n\t\t");
		}

		return sb.toString();
	}
}
