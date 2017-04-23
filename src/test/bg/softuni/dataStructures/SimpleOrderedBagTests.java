package test.bg.softuni.dataStructures;


import bg.softuni.dataStructures.SimpleSortedList;
import bg.softuni.interfaces.SimpleOrderedBag;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class SimpleOrderedBagTests {
    public static final String EXPECTED_VALUR = "Balkan, Georgi, Rosen";
    private SimpleOrderedBag<String> name;

    @Before
    public void setUp(){
        this.name = new SimpleSortedList<>(String.class);
    }

    @Test
    public void testEmptyCtor(){
        this.name = new SimpleSortedList<>(String.class);
        Assert.assertEquals(16, this.name.capacity());
        Assert.assertEquals(0, this.name.size());
    }

    @Test
    public void testCtorWithInitializeCapacity(){
        this.name = new SimpleSortedList<>(String.class, 20);
        Assert.assertEquals(20, this.name.capacity());
        Assert.assertEquals(0, this.name.size());
    }

    @Test
    public void testCtorWithInitializeComparer(){
        this.name = new SimpleSortedList<>(String.class, String.CASE_INSENSITIVE_ORDER);
        Assert.assertEquals(16, this.name.capacity());
        Assert.assertEquals(0, this.name.size());
    }

    @Test
    public void testCtorWithAllParmeters(){
        this.name = new SimpleSortedList<>(String.class, String.CASE_INSENSITIVE_ORDER, 30);
        Assert.assertEquals(30, this.name.capacity());
        Assert.assertEquals(0, this.name.size());
    }

    @Test
    public void testAddInitialiseSize(){
        this.name.add("Test Name");
        Assert.assertEquals(1, this.name.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullThrowsException(){
        this.name.add(null);
    }

    @Test
    public void testAddUnsortedDataIsHeldSorted(){
       this.name.add("Rosen");
       this.name.add("Georgi");
       this.name.add("Balkan");
        Assert.assertEquals(EXPECTED_VALUR, this.name.joinWith(", "));
    }

    @Test
    public void testAddingMoreThanInitialCapacity(){
        for (int i = 0; i < 17; i++) {
            this.name.add("a");
        }
        Assert.assertNotEquals(16, this.name.capacity());
    }

    @Test
    public void testAddingAllFromCollectionIncreasesSize(){
        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        this.name.addAll(list);
        Assert.assertEquals(2, this.name.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingAllFromNullThrowsException(){
        this.name.addAll(null);
    }

    @Test
    public void testAddAllKeepsSorted(){
        this.name.add("v");
        this.name.add("m");
        this.name.add("a");
        this.name.add("y");
        Assert.assertEquals("a, m, v, y", this.name.joinWith(", "));
    }

    @Test
    public void testRemoveValidElementDecreasesSize(){
        this.name.add("s");
        this.name.add("e");
        this.name.remove("s");
        Assert.assertEquals(1, this.name.size());
    }

    @Test
    public void testRemoveValidElementRemovesSelectedOne(){
        this.name.add("ivan");
        this.name.add("nasko");
        this.name.remove("ivan");
        Assert.assertEquals("nasko", this.name.joinWith(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovingNullThrowsException(){
        this.name.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJoinWithNull(){
        this.name.add("s");
        this.name.add("s");
        this.name.joinWith(null);
    }

    @Test
    public void testJoinWorksFine(){
        this.name.add("a");
        this.name.add("a");
        this.name.add("a");
        Assert.assertEquals("a,a,a", this.name.joinWith(","));
    }
}
