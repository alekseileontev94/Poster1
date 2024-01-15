package ru.netelogy.Poster;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostersManagerTest {
    PostersManager manager = new PostersManager();

    @Test
    public void getEmpty() {

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addNewPoster() {
        manager.addNew("Poster1");

        String[] expected = {"Poster1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addFewNewPosters() {
        manager.addNew("Poster1");
        manager.addNew("Poster2");

        String[] expected = {"Poster1", "Poster2"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllPostersUnderLimit() {
        manager.addNew("Poster1");
        manager.addNew("Poster2");
        manager.addNew("Poster3");

        String[] expected = {"Poster1", "Poster2", "Poster3"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllPostersUpperLimit() {
        manager.addNew("Poster1");
        manager.addNew("Poster2");
        manager.addNew("Poster3");
        manager.addNew("Poster4");
        manager.addNew("Poster5");
        manager.addNew("Poster6");

        String[] expected = {"Poster1", "Poster2", "Poster3", "Poster4", "Poster5", "Poster6"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastPostersDefaultUnderLimit() {
        manager.addNew("Poster1");
        manager.addNew("Poster2");
        manager.addNew("Poster3");

        String[] expected = {"Poster3", "Poster2", "Poster1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastPostersDefaultUpperLimit() {
        manager.addNew("Poster1");
        manager.addNew("Poster2");
        manager.addNew("Poster3");
        manager.addNew("Poster4");
        manager.addNew("Poster5");
        manager.addNew("Poster6");

        String[] expected = {"Poster6", "Poster5", "Poster4", "Poster3", "Poster2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastPostersCustomUnderLimit() {
        PostersManager manager = new PostersManager(3);

        manager.addNew("Poster1");
        manager.addNew("Poster2");

        String[] expected = {"Poster2", "Poster1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastPostersCustomUpperLimit() {
        PostersManager manager = new PostersManager(3);

        manager.addNew("Poster1");
        manager.addNew("Poster2");
        manager.addNew("Poster3");
        manager.addNew("Poster4");

        String[] expected = {"Poster4", "Poster3", "Poster2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
