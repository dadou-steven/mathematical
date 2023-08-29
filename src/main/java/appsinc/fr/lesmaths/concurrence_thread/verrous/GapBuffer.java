package appsinc.fr.lesmaths.concurrence_thread.verrous;

public class GapBuffer implements EditBuffer {
    private char[] a;
    private int gapStart;
    private int gapLength;

    private void checkRep() {
        assert a != null;
        assert 0 <= gapStart;
        assert gapStart <= a.length;
        assert 0 <= gapLength;
        assert gapLength <= a.length - gapStart;
    }
    
    public GapBuffer() {
        a = new char[1];
        gapStart = 0;
        gapLength = 1;
        checkRep();
    }
    
    @Override
    public void insert(int position, String insertion) {
        int len = insertion.length();
        moveGap(position, len);
        insertion.getChars(0, len, a, gapStart);
        gapStart += len;
    }

    @Override
    public void delete(int position, int len) {
        moveGap(position, 0);
        gapLength += len;
        checkRep();
    }



    @Override
    public int length() {
        return a.length - gapLength;
    }

    @Override
    public String toString() {
        char[] result = new char[a.length - gapLength];
        System.arraycopy(a, 0, result, 0, gapStart);
        System.arraycopy(a, gapStart + gapLength, result, gapStart, a.length - gapStart - gapLength);
        return String.valueOf(result);
    }

    private void moveGap(int newGapStart, int minGapLength) {
        String oldTex = null;
        assert (oldTex = toString()) != null;
        char[] b;
        int newGapLength;

        if (gapLength >= minGapLength) {
            b = a;
            newGapLength = gapLength;
        } else {
            int textLength = a.length - gapLength;
            b = new char[Math.max(textLength * 2, textLength + minGapLength)];
            newGapLength = b.length - textLength;
        }

        int gapEnd = gapStart + gapLength;
        int newGapEnd = newGapStart + newGapLength;

        if (newGapStart < gapStart) {
            System.arraycopy(a, 0, b, 0, newGapStart);
            System.arraycopy(a, newGapStart, b, newGapEnd, gapStart - newGapStart);
            System.arraycopy(a, gapEnd, b, newGapEnd + (gapStart - newGapStart), a.length - gapEnd);
        } else {
            System.arraycopy(a, 0, b, 0, gapStart);
            System.arraycopy(a, gapEnd, b, gapStart, newGapStart - gapStart);
            System.arraycopy(a, gapEnd + (newGapStart - gapStart), b, newGapEnd, b.length - newGapEnd);
        }
        a = b;
        gapStart = newGapStart;
        gapLength = newGapLength;

        assert gapLength >= minGapLength;
        assert toString().equals(oldTex);
    }

    public void result(String solution) {
        System.out.println(solution);
    }

    public static void main(String[] args) {
        GapBuffer gapBuffer = new GapBuffer();
        gapBuffer.result(gapBuffer.toString());
    }
}
