import java.util.ArrayList;

public class LocalTest {

    private ALU alu = new ALU();

    public static void main(String[] args) {
        LocalTest tester = new LocalTest();
        tester.testTrans();
        tester.testFullAdder();
        tester.testClaAdder();
        tester.testPclaAdder();
        tester.testMultiplication();
    }

    public void testTrans() {
        System.out.println("0000000011101001".equals(alu.intToComplement(233)));
    }

    public void testFullAdder() {
        System.out.println("11".equals(alu.fullAdder('1', '1', '1')));
    }


    public void testClaAdder() {
        System.out.println("00101".equals(alu.claAdder("0001", "0100", '0')));
    }

    public void testPclaAdder() {
        System.out.println("10000000000000000".equals(alu.pclaAdder("1111111111111111", "0000000000000000", '1')));
    }

    public void testMultiplication() {
        ArrayList<String> log = new ArrayList<>();
        log.add("000000000000000011111111111110100");
        log.add("000000000000000001111111111111010");
        log.add("000000000000001110111111111111101");
        log.add("111111111111111001011111111111110");
        log.add("000000000000001010101111111111111");
        log.add("000000000000000101010111111111111");
        log.add("000000000000000010101011111111111");
        log.add("000000000000000001010101111111111");
        log.add("000000000000000000101010111111111");
        log.add("000000000000000000010101011111111");
        log.add("000000000000000000001010101111111");
        log.add("000000000000000000000101010111111");
        log.add("000000000000000000000010101011111");
        log.add("000000000000000000000001010101111");
        log.add("000000000000000000000000101010111");
        log.add("000000000000000000000000010101011");
        log.add("000000000000000000000000001010101");
        System.out.println(isSame(log, alu.multiplication(-7, -6)));
    }

    private boolean isSame(ArrayList<String> expected, ArrayList<String> log) {
        if (expected == null || log == null) {
            return false;
        }
        if (expected.size() != log.size()) {
            return false;
        }
        for (int i = 0; i < log.size(); i++) {
            if (!log.get(i).equals(expected.get(i))) {
                return false;
            }
        }
        return true;
    }

}
