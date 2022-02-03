package com.gildedrose;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestTextFixtureTest extends InvokeMainTestCase {

    @Test
    void outputOfTestTextFixtureDoesNotChange() throws IOException {
        MainMethodResult result = invokeMain(TextTestFixture.class);
        String text = result.getTextWrittenToStandardOut();
        String expected = readResourceAsString("expectedTestTextFixture.txt");

        assertThat(text, equalTo(expected));
    }

    @Test
    void outputOf10DaysOfTestTextFixtureDoesNotChange() throws IOException {
        MainMethodResult result = invokeMain(TextTestFixture.class, "10");
        String text = result.getTextWrittenToStandardOut();
        String expected = readResourceAsString("expectedTestTextFixture10Days.txt");

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
