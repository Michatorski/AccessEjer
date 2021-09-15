package org.iesfm.accessEjer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArgumentsExample {

    private static Logger log = LoggerFactory.getLogger(ArgumentsExample.class);

    public static void main(String[] args) {
//        for (int i = 0; i < args.length; i++) {
//            log.info("El argumento " +  i + " es " + args[i]);
//        }

        int arg1 = Integer.parseInt(args[0]);
    }
}
