package it.unibo.mvc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> historyOfString = new LinkedList<>();
    private String current;

    @Override
    public void setNextString(final String nextString) {
        this.current = nextString;
    }

    @Override
    public String getNextString() {
        return this.current;
    }

    @Override
    public List<String> historyOfPrintedString() {
        return Collections.unmodifiableList(historyOfString);
    }

    @Override
    public void printCurrentString() throws IllegalStateException {
        if (this.current == null) {
            throw new IllegalStateException("The string is null");
        } else {
            System.out.println(this.current);
            this.historyOfString.add(current);
        }
    }
}
