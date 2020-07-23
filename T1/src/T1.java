
public class T1 {
	public static void main(String[] args) {
		System.out.println(serie1(1341));
		System.out.println(serie2(8311));
	}

	public static int serie1(int num) {
		if (num <= 0) {
			return -1;
		}
		int v = 1;
		int in = 0;
		int[] array = new int[num];
		for (int i = 0; i < num; i++) {
			if (i == 0) {
				array[i] = 2;

			} else {
				v += 2;
				in = array[i - 1] + v;
				array[i] = in;
			}

		}
		return array[num - 1];
	}

	public static int serie2(int num) {
		if (num <= 0) {
			return -1;
		}
		int v = 0;
		int in = 0;
		int v1 = 0;
		int in1 = 0;
		int[] array = new int[num];
		for (int i = 0; i < num; i++) {
			if (i == 0) {
				array[i] = 3;

			} else {

				if (i % 2 == 0) {

					v += 1;
					in = array[i - 2] + v;
					array[i] = in;
				} else {
					if (i==1) {
						array[i]=4;
					}else {
						array[i]=array[i-2]+8;
					}
				
				}
			}
		}
		return array[num - 1];
	}

}
