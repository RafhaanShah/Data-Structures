package dst.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {

    private Stack<Object> stack;

    @BeforeEach
    public void setup() {
        stack = new Stack<Object>();
    }

    public void empty_onEmptyStack() {
        assertTrue(stack.empty());
    }

    @Test
    public void empty_onStack() {
        stack.push(new Object());
        assertFalse(stack.empty());
    }

    @Test
    public void pushAndPeek_onStack() {
        Object obj = new Object();
        stack.push(new Object());

        assertEquals(obj, stack.push(obj));
        assertEquals(obj, stack.peek());
    }

    @Test
    public void pushAndPop_onStack() {
        Object obj = new Object();
        stack.push(new Object());

        assertEquals(obj, stack.push(obj));
        assertEquals(obj, stack.pop());

        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    public void peek_onEmptyStack() {
        assertNull(stack.peek());
    }

    @Test
    public void pop_onEmptyStack() {
        assertThrows(EmptyStackException.class, () -> {
            stack.pop();
        });
    }

    @Test
    public void search_onEmpytStack() {
        assertEquals(-1, stack.search(new Object()));
    }

    @Test
    public void search_onStack() {
        Object obj = new Object();
        stack.push(new Object());
        stack.push(new Object());
        stack.push(obj);
        stack.push(new Object());
        stack.push(new Object());

        assertEquals(3, stack.search(obj));
    }

}
