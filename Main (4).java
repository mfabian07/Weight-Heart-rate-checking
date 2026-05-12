import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
double[] weights = new double[10];
int[][] heartRates = new int[10][2];
String[] notes = new String[10];
int count = 0;
boolean running = true;

  while (running) {
    System.out.println("\n1. Add Entry | 2. View Summary | 3. Search | 4. Quit");
    int choice = sc.nextInt();
    sc.nextLine();

    switch (choice) { 
    case 1:
    if (count < 10) {
    System.out.print("Weight: ");
    double w = sc.nextDouble();
    System.out.print("Resting HR: ");
    int rhr = sc.nextInt();
    System.out.print("Active HR: ");
    int ahr = sc.nextInt();
    sc.nextLine();
    System.out.print("Note: ");
    String note = sc.nextLine();
    if (w > 0 && rhr > 0 && ahr > 0) {
    weights[count] = w;
    heartRates[count][0] = rhr;
heartRates[count][1] = ahr;
notes[count] = note;
count++;
        }
    }
  break;
  case 2:
    if (count == 0) System.out.println("No data.");
      else {
        System.out.println("Avg Weight: " + getAvg(weights, count));
        System.out.println("Max HR: " + getExtreme(heartRates, count, true));
            }
          break;
  case 3:
  System.out.print("Keyword: ");
    String key = sc.nextLine().toLowerCase();
      for (int i = 0; i < count; i++) {
        if (notes[i].toLowerCase().contains(key)) System.out.println("Found: " + notes[i]);
                    }
        break;
              case 4: running = false; break;
            }
        }
    }

public static double getAvg(double[] data, int n) {
double sum = 0;
  for (int i = 0; i < n; i++) sum += data[i];
    return sum / n;
    }

public static int getExtreme(int[][] data, int n, boolean max) {
int val = data[0][0];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < 2; j++) {
      if (max) val = Math.max(val, data[i][j]);
        else val = Math.min(val, data[i][j]);
            }
        }
        return val;
    }
}
