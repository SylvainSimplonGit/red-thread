/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.simplon.moviestack.model;

import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author franck
 */
public class MovieBuffIT {
    
    public MovieBuffIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getIdMovieBuff method, of class MovieBuff.
     */
    @Test
    public void testGetIdMovieBuff() {
        System.out.println("getIdMovieBuff");
        MovieBuff instance = new MovieBuff();
        Long expResult = null;
        Long result = instance.getIdMovieBuff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdMovieBuff method, of class MovieBuff.
     */
    @Test
    public void testSetIdMovieBuff() {
        System.out.println("setIdMovieBuff");
        Long idMovieBuff = null;
        MovieBuff instance = new MovieBuff();
        instance.setIdMovieBuff(idMovieBuff);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class MovieBuff.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        MovieBuff instance = new MovieBuff();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class MovieBuff.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        MovieBuff instance = new MovieBuff();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class MovieBuff.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        MovieBuff instance = new MovieBuff();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class MovieBuff.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        MovieBuff instance = new MovieBuff();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMoviesSeen method, of class MovieBuff.
     */
    @Test
    public void testGetMoviesSeen() {
        System.out.println("getMoviesSeen");
        MovieBuff instance = new MovieBuff();
        List<Movie> expResult = null;
        List<Movie> result = instance.getMoviesSeen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMoviesSeen method, of class MovieBuff.
     */
    @Test
    public void testSetMoviesSeen() {
        System.out.println("setMoviesSeen");
        List<Movie> moviesSeen = null;
        MovieBuff instance = new MovieBuff();
        instance.setMoviesSeen(moviesSeen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
