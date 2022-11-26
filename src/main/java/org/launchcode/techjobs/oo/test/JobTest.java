package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    //no test info
    @Test
    public void emptyTest() {

        assertEquals(true, true);
    }

    //    ids assigned
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    //    class assignment, parameter
    @Test
    public void testJobConstructorSetsAllfields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job3.getName(), "Product tester");
        assertEquals(job3.getEmployer().getValue(), "ACME");
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertEquals(job3.getPositionType().getValue(), "Quality control");
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");

        assertTrue(job3.getName() instanceof String);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }

    //    new id assigned if duplicate entry (more than one position)
    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job4.equals(job5));
    }

    //blank line before and after job entry
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String testString = job6.toString();
        assertEquals(job6.toString().charAt(0), '\n');
        assertEquals(job6.toString().charAt(job6.toString().length() - 1), '\n');
    }

    //testing print
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job7.toString(),
                "\n" + "ID: 4" +
                        "\n" + "Name: Product tester" +
                        "\n" + "Employer: ACME" +
                        "\n" + "Location: Desert" +
                        "\n" + "Position Type: Quality control" +
                        "\n" + "Core Competency: Persistence" +
                        "\n");
    }

    //empty string field
    @Test
    public void testToStringHandlesEmptyField() {
        Job job8 = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency(""));
        assertEquals(job8.toString(),
                "\n" + "ID: 3" +
                        "\n" + "Name: Product tester" +
                        "\n" + "Employer: ACME" +
                        "\n" + "Location: Data not available" +
                        "\n" + "Position Type: Quality control" +
                        "\n" + "Core Competency: Data not available" +
                        "\n");
    }
}