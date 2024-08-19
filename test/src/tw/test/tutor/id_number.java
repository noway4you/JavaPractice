package tw.test.tutor;

public class id_number {

	public static void main(String[] args) {
		System.out.println(tw.test.apis.id_number.isRight("L125261385"));
		System.out.println(tw.test.apis.id_number.isRight2("L125261385"));
		tw.test.apis.id_number id1 = new tw.test.apis.id_number();
		tw.test.apis.id_number id2 = new tw.test.apis.id_number(false);
		tw.test.apis.id_number id3 = new tw.test.apis.id_number('A');
		tw.test.apis.id_number id4 = new tw.test.apis.id_number(true,'B');
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
	}

}
