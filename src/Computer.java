
class Computer {

    private static final int MAXMEM = 50;

    private BitString[] reg;
    private BitString[] mem;
    private BitString pc;
    private BitString ir;

    /* condition code */
    private BitString cc;

    Computer() {
        reg = new BitString[8];
        mem = new BitString[MAXMEM];
        pc = new BitString();
        ir = new BitString();
        cc = new BitString();
    }

    /* initialized the computer  */
    void COMP_Init() {
        pc.setValue(0, 16);
        ir.setValue(0, 16);
        cc.setValue(0, 3);

        //Add some interesting data in registers.
        for (int i = 0; i < 8; i++) {
            reg[i] = new BitString();
            reg[i].setValue(i, 16);
        }

        //Initialize an empty memory array.
        for (int i = 0; i < MAXMEM; i++) {
            mem[i] = new BitString();
            mem[i].setValue(0, 16);
        }
    }

    /* put a word (either data or instruction) into the computer's */
    /* memory at address addr */
    void COMP_LoadWord(int addr, BitString word) {
        //TODO could add validation here
        mem[addr] = word;
    }

    /* Performs Not operation */
// TODO - ACTUAL ASSIGNMENT TODO: Missing Piece: The Condition Code is not set.
    void COMP_ExecuteNot() {
        BitString drBS , srBS;
        drBS = ir.getSubString(4, 3);
        srBS = ir.getSubString(7, 3);
        reg[drBS.getValue()] = reg[srBS.getValue()];
        reg[drBS.getValue()].invert();
    }


    /* execute the computer's stored program */
    /* starting at PC = 0 */
    /* and until the program executes a HALT */
    void COMP_Execute() {
        BitString opCode;
        int opCodeInt;

        ir = mem[pc.getValue()];

        pc.addOne();

        opCode = ir.getSubString(0, 4);
        opCodeInt = opCode.getValue();

        /* what kind of instruction is this? */
        if (opCodeInt == 9) {
            COMP_ExecuteNot();
        }
    }

    /* displays its current contents - register and memory */
    void COMP_Display() {
        System.out.print("\n");

        System.out.print("PC ");
        pc.display(true);
        System.out.print("   ");

        System.out.print("IR ");
        ir.display(true);
        System.out.print("   ");

        System.out.print("CC ");
        cc.display(true);
        System.out.print("\n");

        for (int r = 0; r < 8; r++) {
            System.out.print("R" + r + " ");
            reg[r].display(true);
            compDisplayFormatter(r);
//            if (r % 3 == 2) {
//                System.out.print("\n");
//            }
//            else {
//                System.out.print("   ");
//            }
        }
        System.out.print("\n\n");

        for (int m = 0; m < MAXMEM; m++) {
            System.out.printf("%-3d", m);
            mem[m].display(true);

            compDisplayFormatter(m);
//            if (m % 3 == 2) {
//                System.out.print("\n");
//            } else {
//                System.out.print("   ");
//            }
        }
        System.out.print("\n");
    }
    void compDisplayFormatter(int x)  {
        if (x % 3 == 2) {
            System.out.print("\n");
        } else {
            System.out.print("   ");
        }
    }

}

