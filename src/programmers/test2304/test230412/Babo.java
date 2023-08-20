package programmers.test2304.test230412;

public class Babo {

	public static void main(String[] args) {
        String name = "cho";
        System.out.println("Before Name : " + name);
        changeName(name);
        System.out.println("After Name 1 : " + name);
        name += " lovely";
        System.out.println("After Name 2 : " + name);
    }
    public static void changeName(String s) {
        s += " lovely";
    }

}
