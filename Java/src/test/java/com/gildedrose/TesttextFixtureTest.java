package com.gildedrose;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TesttextFixtureTest extends InvokeMainTestCase {

    @Test
    void outputOfTesttextFixtureDoesNotChange() throws IOException {
        MainMethodResult result = invokeMain(TexttestFixture.class);
        String text = result.getTextWrittenToStandardOut();
        String expected = readResourceAsString("expectedTexttestFixture.txt");

        assertThat(text, equalTo(expected));
    }

    private String readResourceAsString(String resourceName) throws IOException {
        InputStream input = getClass().getResourceAsStream(resourceName);
        assertThat(input, notNullValue());

        try (
            StringWriter sw = new StringWriter();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        ) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                sw.write(line);
                sw.write('\n');
            }
            return sw.toString();
        }
    }
}
