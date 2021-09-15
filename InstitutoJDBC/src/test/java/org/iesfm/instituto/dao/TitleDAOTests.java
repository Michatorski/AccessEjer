package org.iesfm.instituto.dao;

import org.iesf.instituto.jdbc.InstitutoConfiguration;
import org.iesf.instituto.jdbc.dao.TitleDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { InstitutoConfiguration.class })
public class TitleDAOTests {
    @Autowired
    private TitleDAO titleDAO;

    @Test
    public void get(){
        Assert.assertNotNull(titleDAO.get("dam"));
        Assert.assertNull(titleDAO.get("dam2"));
    }
}
