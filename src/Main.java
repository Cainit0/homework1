public class Main {
    public static void main(String[] args) {
        var mutableObj = new ImmutableClass.MutableClass(76, "Mutable");
        var test = new ImmutableClass(67, "Immutable", mutableObj);
        mutableObj.setId(mutableObj.getId() * 50);
        mutableObj.setName(mutableObj.getName() + "01011101");
        System.out.println(test);
    }
}