package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    public void setNextString(String nexString);

    public String getNextString();

    public List<String> historyOfPrintedString();

    public void printCurrentString();
}
