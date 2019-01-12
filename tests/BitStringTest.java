import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitStringTest {
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

    @BeforeEach
    void setUp() {


    }

    @Test
    void setBits() {
        BitString bstr = new BitString();

        bstr.setBits(program[0].toCharArray());

        assertEquals(program[0].toCharArray(), bstr.getBits());
    }

    @Test
    void invert() {
    }

    @Test
    void addOne() {
    }

    @Test
    void setValue() {
    }

    @Test
    void setValueTwosComp() {
    }

    @Test
    void display() {
    }

    @Test
    void getValueTwosComp() {
    }

    @Test
    void getValue() {
    }

    @Test
    void append() {
    }

    @Test
    void getSubString() {
    }

    @Test
    void getLength() {
    }
}