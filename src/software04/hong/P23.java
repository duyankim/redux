package software04.hong;

public class P23 {

	public static void main(String[] args) {
		// 숫자 읽기 고급 2021-04-02 kopo03 김도연

		int k03_numVal = 1001034567; // 일십억일백삼만사천오백육십칠

		String k03_sNumVal = String.valueOf(k03_numVal); // int를 string값으로 읽는다면 valueOf를 사용

		String k03_sNumVoice = "";// 숫자를 한글로 읽으면 어떻게 읽을지 변수에 선언

		System.out.printf("==> %s [%d자리]\n", k03_sNumVal, k03_sNumVal.length()); // 글자가 몇 자리인지 출력

		int k03_i, k03_j; // 변수 선언부에서 선언을 한다.

		String[] units = { "영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" }; // 일의 자리를 한글로 읽었을 때 배열
		String[] unitX = { "", "십", "백", "천", "만", "십", "백", "천", "억", "십" }; // 단위를 한글로 읽었을 때 배열

		k03_i = 0; // 선언부와 할당을 따로 하여 변수에 0을 할당하고 있다.
		k03_j = k03_sNumVal.length() - 1; // 예를들어, sNumVal이 1자리 String일때 j값은 0이 되어서 j[0]인 ""을 출력해 단위를 붙이지 않게 한다.

		while (true) {// true조건이 성립하면 계속 반복한다.
			if (k03_i >= k03_sNumVal.length())
				break; // 단어의 길이보다 자리수가 길어진다면 중단해야한다.

			System.out.printf("%s[%s]", k03_sNumVal.substring(k03_i, k03_i + 1), // sNumVal은 string이니까 string메소드를 슬 수
																					// 있다.
					units[Integer.parseInt(k03_sNumVal.substring(k03_i, k03_i + 1))]); // string을 다시 int로 바꾼다.

			if (k03_sNumVal.substring(k03_i, k03_i + 1).equals("0")) { // 해당 자리가 0일때 억, 만 자리일 경우만 단위값 붙임

				if (unitX[k03_j].equals("만") || unitX[k03_j].equals("억")) { // 단위 배열에서 만 또는 억에 해당시
					k03_sNumVoice = k03_sNumVoice + "" + unitX[k03_j]; // 해당 자리가 0이면 단위만 붙여준다.
				} else { // 만 또는 억이 아니면 단위를 붙이지 않음

				}
			} else { // 해당 자리가 0이 아닐 때
				k03_sNumVoice = k03_sNumVoice + units[Integer.parseInt(k03_sNumVal.substring(k03_i, k03_i + 1))]
						+ unitX[k03_j];
				/*
				 * sNumVoice가 먼저오고, units계산값이 뒤에 오는 이유는, 숫자를 왼쪽부터 읽기 시작하기 때문이다. i는 0에서부터 시작해서
				 * 왼쪽부터 substring으로 한자리씩 조건문을 돌고 있는데, 일십억 -> 일백삼만 -> 사천 -> 오백 -> 육십 -> 칠 순서로
				 * 인식한다. 따라서 만일 i값이 4일 경우, 이미 sNumVoice값에는 "일십억"이 들어있고, 그 뒤에 "일"을 붙일 것이다.
				 * units[]안에서는 해당 자리값을 substring으로 구한 뒤, 해당 string을 int형으로 바꾼 뒤 units의 인덱스 값으로
				 * 넣어주는 것이다.
				 */
			}
			k03_i++;
			k03_j--; // i값은 string을 읽는 방향인 오른쪽으로 이동해야해서 0에서부터 증가
			// j값은 왼쪽에서부터 점점 커지는 단위값이므로 숫자의 길이-1로 시작해서 점차 감소
		}
		System.out.printf("\n %s[%s]\n", k03_sNumVal, k03_sNumVoice); // 정수와 읽는 방법을 같이 출력
	}

}
