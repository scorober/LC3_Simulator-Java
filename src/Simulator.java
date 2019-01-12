public class Simulator {


    public static void main(String[] args) {

        Computer comp = new Computer();

        /************************************** */
        /** The next two variables - program and programSize - */
        /** allow someone using the simulator (such as a grader) */
        /** to decide what program will be simulated. */
        /** The simulation must load and execute */
        /** instructions found in the "program" array. */
        /** For grading purposes, it must be possible for me to */
        /**    - paste in a different set of binary strings to replace the existing ones */
        /**    - adjust the programSize variable */
        /**    - recompile your program without further changes */
        /**    and see the simulator load and execute the new program. */
        /**    Your grade will depend largely on how well that works. */
        /************************************** */


        String[] program =
                {
                        "0010000000000111",
                        "0010001000000111",
                        "0001010000000001",
                        "0000010000000011",
                        "1111000000100001",
                        "0001000000111111",
                        "0000111111111011",
                        "1111000000100101",
                        "0000000000111001",
                        "1111111111010000"
                };

        int programSize = 10;

//        comp.COMP_Init();
//        comp.COMP_Display();

        bitStringTest();

    }


    static void bitStringTest() {
        BitString bstr = new BitString();
        BitString bstr1 = new BitString();
        BitString bstr2 = new BitString();
        BitString bstr3 = new BitString();
        BitString bstr4 = new BitString();

        int testValues[] = {255, -255, -83, 83};

        for (int i = 0; i < 4; i++) {
            bstr.setValueTwosComp(testValues[i], 16);
            bstr.display(true);
            System.out.print("\n Value = " + bstr.getValueTwosComp() + "\n");
        }

        bstr1.setValue(4, 8);
        bstr2.setValue(10, 8);
        bstr1.display(true);
        System.out.println();

        bstr2.display(true);
        System.out.println();

        System.out.println("Length1 = " + bstr1.getLength());
        System.out.println("Length2 = " + bstr2.getLength());

//        bstr3 = append(bstr1, bstr2);

    }

}
