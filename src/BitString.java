
class BitString {

    private final static int MAXBITS = 16;
    private char[] bits;
    private int length;


    BitString() {
        bits = new char[MAXBITS];
        length = 0;
    }

    /* Copy constructor */
    private BitString(BitString cloned) {
        length = cloned.length;
        bits = new char[MAXBITS];
        System.arraycopy(cloned.bits, 0, bits, 0, cloned.length);
    }

    /* bits is a c-string (array of ascii codes ending with 0). */
    /* It should be made of 0's and 1's - "0110" for example. */
    /* Those characters are converted to a similar set of 0's and 1's */
    /* in the bitstring.  "0" is replace by 0, "1" is replaced by 1. */
    void setBits(char[] bits) {
        int len = bits.length;

        for (int i = 0; i < len; i++) {
            if (bits[i] ==  '0') {
                bits[i] = '0';
            } else {
                bits[i] = '1';
            }
        }
        length = len;
    }

    /* flips all bits */
    void invert() {
        for (int i = 0; i < length; i++) {
            if (bits[i] == 0) {
                bits[i] = 1;
            } else {
                bits[i] = 0;
            }
        }
    }

    /* adds one to the binary number treating it as unsigned */
    void addOne() {
        for (int i = length - 1; i >= 0; i--) {
            if (bits[i] == 0) {
                bits[i] = 1;
                break;
            } else {
                bits[i] = 0;
            }
        }
    }

    /* sets bstr to an unsigned binary number.  The number of bits */
    /* is size.  The value is n. */
    void setValue(int n, int size) {
        int i;
        if (size < MAXBITS) {
            return;
        }
        length = size;

        for (i = length - 1; i >= 0; i--) {
            bits[i] = (char)(n % 2);
            n = n / 2;
        }
    }

    /* sets bstr to a two's complement binary number.  The number of bits */
    /* is size.  The value is n. */
    void setValueTwosComp(int n, int size) {
        boolean isNegative = n < 0;
        if (size < MAXBITS) {
            return;
        }
        if (n < 0) {
            n = -1 * n;
        }
        setValue(n, size);
        if (isNegative) {
            invert();
            addOne();
        }
    }

    /* prints out the bit string.  If parameter is true, */
    /* then there is a blank after every 4 bits for easy reading. */
    void display(boolean fourGrouping) {
        for (int i = 0; i < length; i++) {
            if (fourGrouping && (i % 4 ==  0) && i != 0) {
                System.out.print(" ");
            }
            if (bits[i] == 0) {
                System.out.print("0");
            } else {
                System.out.print("1");
            }
        }
    }


    /* returns the two's complement value of this bitstring */
    //1000000 ?????TODO check
    int getValueTwosComp() {
//        int value = 0;
        boolean isNegative = bits[0] == 1;
        if (isNegative) {
            BitString posBstr = new BitString(this);
            posBstr.invert();
            posBstr.addOne();
            return -1 * posBstr.getValue();
        } else {
            return this.getValue();
        }
    }

    /* returns the unsigned value of this bitstring */
    int getValue() {
        int value = 0;
        for (int i = 0; i < length; i++) {
            value = value * 2;
            value += bits[i];
        }
        return value;
    }

    /* puts two bit strings bstr1 and bstr2 together to form a new */
    /* bigger bitstring which is stored in result.  The original */
    /* bit strings are not changed. */

    //TODO return BitString or use 3 parameters
    BitString append(BitString bstr1, BitString bstr2) {
        BitString result = new BitString();
        int d = 0;
        for (int i = 0; i < bstr1.length; i++) {
            result.bits[d] = bstr1.bits[i];
            d++;
        }
        for (int i = 0; i <bstr2.length; i++) {
            result.bits[d] = bstr1.bits[i];
            d++;
        }
        result.length = bstr1.length + bstr2.length;

        return result;
    }

    /* creates a new bitstring from source, starting at position start */
    /* and with the specified length.   The first position is numbered 0 */
    /* as with a java (or c) array.  The new bitstring is saved in substr */
    /* source is not modified. */
    BitString getSubString(int start, int length) {
        BitString substr = new BitString();
        System.arraycopy(bits, start, substr.bits, 0, length);

//        for (int i = 0; i < length; i++) {
//            substr.bits[i] = this.bits[start + i];
//        }
        substr.length = this.length;

        return  substr;
    }

    /* returns the length of the bistring (i.e. the number of bits) */
    int getLength() {
        return this.length;
    }

    char[] getBits() {return bits; }

}