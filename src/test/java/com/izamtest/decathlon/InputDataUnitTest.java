package com.izamtest.decathlon;

import com.izamtest.decathlon.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputDataUnitTest {
    @Test
    void testRun1500m_TooSmallData() {
        assertEquals(new Run1500m("59.0").getPoints(), 0);
    }

    @Test
    void testRun1500m_WrongInputDataThrows() {
        NumberFormatException thrown = assertThrows(NumberFormatException.class, () -> new Run1500m("aaa_.gfh"));
        assertTrue(thrown.getMessage().contains("For input string"));

        assertThrows(NumberFormatException.class, () -> new Run1500m("4:34.98"));
        assertThrows(NumberFormatException.class, () -> new Run1500m("4.34,98"));
    }

    @Test
    void testRun100m_WrongInputDataThrows() {
        String bad = "dsvgfdfgfh";
        NumberFormatException thrown = assertThrows(NumberFormatException.class, () -> new Run100m(bad));
        assertTrue(thrown.getMessage().contains(bad));

        assertThrows(NumberFormatException.class, () -> new Run100m("dAsadsddfgfh"));
        assertThrows(NullPointerException.class, () -> new Run100m(null));
    }

    @Test
    void testLongJump_WrongInputDataThrows() {
        assertThrows(NumberFormatException.class, () -> new LongJump("^$^#$@"));
        assertThrows(NullPointerException.class, () -> new LongJump(null));
    }

    @Test
    void testDiscussThrow_WrongInputData() {
        assertThrows(NumberFormatException.class, () -> new DiscusThrow("1,3"));
    }

    @Test
    void testPoleVault_WrongInputData() {
        assertThrows(NumberFormatException.class, () -> new PoleVault("-3,06"));
        assertEquals(new PoleVault("-4.30").getPoints(), 0);
    }

}
