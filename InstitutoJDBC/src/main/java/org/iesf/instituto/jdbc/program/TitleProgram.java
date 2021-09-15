package org.iesf.instituto.jdbc.program;

import org.iesf.instituto.jdbc.Title;
import org.iesf.instituto.jdbc.dao.TitleDAO;
import org.iesf.instituto.jdbc.scannerRead.TitleScannerReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TitleProgram {

    private final static Logger log = LoggerFactory.getLogger(TitleProgram.class);

    private TitleScannerReader titleScannerReader;
    private TitleDAO titleDAO;

    public TitleProgram(TitleScannerReader titleScannerReader, TitleDAO titleDAO) {
        this.titleScannerReader = titleScannerReader;
        this.titleDAO = titleDAO;
    }

    public void insert(){
        Title title = titleScannerReader.readScanInstituto();

        titleDAO.insertar(title);
    }

    public void list(){
        List<Title> listTitle = titleDAO.list();
        for (Title title : listTitle) {
            log.info(title.toString());
        }
    }

    public void familySearch(){
        List<String > listTitle = titleDAO.listFamily();
        for (String family : listTitle){
            log.info(family.toString());
        }
    }

    public void listTitleByFamily(String family){
        List<Title> listTitle = titleDAO.listTitleByFamily(family);
        for (Title title : listTitle) {
            log.info(title.toString());
        }
    }
}
