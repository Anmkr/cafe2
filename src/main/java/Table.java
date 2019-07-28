import model.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Table {
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public int numberOfTable() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public String makeOrder() throws IOException {
        return reader.readLine();
    }


}