package org.iesf.instituto.jdbc.program;

import org.iesf.instituto.jdbc.Group;
import org.iesf.instituto.jdbc.dao.GroupDAO;
import org.iesf.instituto.jdbc.scannerRead.GroupScannerReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GroupProgram {
    private final static Logger log = LoggerFactory.getLogger(GroupProgram.class);

    private GroupScannerReader groupScannerReader;
    private GroupDAO groupDAO;

    public GroupProgram(GroupScannerReader groupScannerReader, GroupDAO groupDAO) {
        this.groupScannerReader = groupScannerReader;
        this.groupDAO = groupDAO;
    }

    public void insert(){
        Group group = groupScannerReader.readScanGroup();

        groupDAO.insertar(group);
    }

    public void list(){
        List<Group> listGroup = groupDAO.list();

        for (Group group : listGroup) {
            log.info(group.toString());
        }
    }
}
