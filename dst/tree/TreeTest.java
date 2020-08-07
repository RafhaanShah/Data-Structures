package dst.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TreeTest {

    private Tree<FakeType> tree;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @BeforeEach
    public void setup() {
        tree = new Tree<FakeType>();
        outContent.reset();
        errContent.reset();
    }

    @Test
    public void testAdd_andContains() {
        addTestData();

        assertTrue(tree.contains(new FakeType(2)));
        assertTrue(tree.contains(new FakeType(8)));
        assertFalse(tree.contains(new FakeType(10)));
    }

    @Test
    public void testRemove_withNoChildren() {
        FakeType a = new FakeType(5);
        tree.add(a);
        tree.remove(a);

        assertFalse(tree.contains(a));
    }

    @Test
    public void testRemove_withOneChild() {
        FakeType a = new FakeType(5);
        FakeType b = new FakeType(3);
        FakeType c = new FakeType(4);

        tree.add(a);
        tree.add(b);
        tree.add(c);

        tree.remove(c);
        assertFalse(tree.contains(c));
        assertTrue(tree.contains(b));
        assertTrue(tree.contains(a));

        tree.remove(b);
        assertFalse(tree.contains(b));
        assertTrue(tree.contains(a));
    }

    @Test
    public void testRemove_withTwoChildren() {
        FakeType a = new FakeType(5);
        FakeType b = new FakeType(6);
        FakeType c = new FakeType(4);

        tree.add(a);
        tree.add(b);
        tree.add(c);

        tree.remove(a);
        assertFalse(tree.contains(a));
        assertTrue(tree.contains(b));
        assertTrue(tree.contains(c));
    }

    @Test
    public void testPreOrderTraversal() {
        addTestData();

        tree.printPreOrder();

        assertEquals("5 3 2 1 4 7 6 8 9 ", outContent.toString());
    }

    @Test
    public void testInOrderTraversal() {
        addTestData();

        tree.printInOrder();

        assertEquals("1 2 3 4 5 6 7 8 9 ", outContent.toString());
    }

    @Test
    public void testPostOrderTraversal() {
        addTestData();

        tree.printPostOrder();

        assertEquals("3 2 1 4 7 6 8 9 5 ", outContent.toString());
    }

    private void addTestData() {
        tree.add(new FakeType(5));

        tree.add(new FakeType(3));
        tree.add(new FakeType(4));
        tree.add(new FakeType(2));
        tree.add(new FakeType(1));

        tree.add(new FakeType(7));
        tree.add(new FakeType(6));
        tree.add(new FakeType(8));
        tree.add(new FakeType(9));
    }

    private class FakeType implements Comparable<FakeType> {

        private int val;

        public FakeType(int i) {
            val = i;
        }

        @Override
        public int compareTo(FakeType t) {
            if (val < t.val) {
                return -1;
            }

            if (val > t.val) {
                return 1;
            }

            return 0;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }

    }

}
