package com.opstty;

import com.opstty.job.DistrictWithTrees;
import com.opstty.job.TreeSpecies;
import com.opstty.job.WordCount;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();
        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");
            programDriver.addClass("districtwithtrees", DistrictWithTrees.class,
                    "A map/reduce program that output the districts with trees.");
            programDriver.addClass("treespecies", TreeSpecies.class,
                    "A map/reduce program that output the genre of trees.");
            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.exit(exitCode);
    }
}
