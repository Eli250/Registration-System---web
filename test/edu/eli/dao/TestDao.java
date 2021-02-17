package edu.eli.dao;

import edu.eli.model.Courses;
import java.util.List;
import javax.swing.JOptionPane;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Eli
 */
public class TestDao {
    GenericDao<Courses> courseDao = new GenericDao<>(Courses.class);
    public TestDao() {
    }

//    @Test
//    public void testCreate() {
//    }
//
//    @Test
//    public void testUpdate() {
//    }
//
//    @Test
//    public void testDelete() {
//    }
//
    @Test
    public void testFindById() {
        Courses list = courseDao.findById("CO1");
        
        JOptionPane.showMessageDialog(null, list);
    }

    @Test
    public void testFindAll() {
        List<Courses> list = courseDao.findAll();
        Assert.assertEquals(list.size(), 3);
        JOptionPane.showMessageDialog(null, list);
    }
    
}
