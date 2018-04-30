/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Andrii Hromov
 */
@RunWith(value = Parameterized.class)
public class AnagramCombinationsTest{

    @Parameters
    public static Collection<String[]> data() {
        return Arrays.asList(new String[][]{
            {"when String Is Empty Then Output Is Empty", "", ""},
            {"when Words Consists Of Letters Only Then Create Anagramed Words", "its test method", "sti tset dohtem"},
            {"when String Consists Of Digits Only Then Digits Stay On Same Places", "123 45678 90", "123 45678 90"},
            {"when Words Consists Of SpecSymbols Only Then Symbols Stay On Same Places", "!@ #$% ^&*()", "!@ #$% ^&*()"},
            {"when Words Consists Of Letters And Digits Then Reverse Letters Numbers Stays On Same Places", "1ts te5t meth0d", "1st te5t dhte0m"},
            {"when Words Consists Of Letters And SpecSymbols Then Reverse Letters Symbols Stays On Same Places", "!ts test& meth()d", "!st tset& dhte()m"},
            {"when String Consists Of Digits And SpecSymbols Then They Stays On Same Places", "!1@2 #3$4%5 ^6&7", "!1@2 #3$4%5 ^6&7"},
            {"when Words Consists Of Letters Digits SpecSymbols Then Reverse Letters Symbols Digits Stay On Same Places", "!1ts te5t& meth0d&", "!1st te5t& dhte0m&"}
        });
    }

    private final Anagram anagram;
    private final String fDescription;
    private final String fInput;
    private final String fExpected;

    public AnagramCombinationsTest(String caseDescription, String input, String expected) {
        this.fDescription = caseDescription;
        this.fInput = input;
        this.fExpected = expected;
        this.anagram = new Anagram();
    }

    @Test
    public void TestCreateAnagramedWords() {
        assertEquals(fDescription, fExpected, anagram.createAnagramedWords(fInput));
    }

}
