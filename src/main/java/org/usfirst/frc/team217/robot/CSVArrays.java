package org.usfirst.frc.team217.robot;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVArrays {
    File _file;
    private double[] dt;
    private double[] x;
    private double[] y;
    private double[] pos;
    private double[] vel;
    private double[] acc;
    private double[] jerk;
    private double[] head;

    public CSVArrays(String filename) {
        _file = new File(filename);

        //2-dimensional array of strings
        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;

        try
        {
            inputStream = new Scanner(_file);

            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(",");
                lines.add(Arrays.asList(values));
            }

            inputStream.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        
        dt = listToDoubleArray(lines.get(1));
        x = listToDoubleArray(lines.get(2));
        y = listToDoubleArray(lines.get(3));
        pos = listToDoubleArray(lines.get(4));
        vel = listToDoubleArray(lines.get(5));
        acc = listToDoubleArray(lines.get(6));
        jerk = listToDoubleArray(lines.get(7));
        head = listToDoubleArray(lines.get(8));
    }

    public double[] getDt() {
        return dt;
    }

    public double[] getX() {
        return x;
    }
    
    public double[] getY() {
        return y;
    }

    public double[] getPos() {
        return pos;
    }

    public double[] getVel() {
        return vel;
    }

    public double[] getAcc() {
        return acc;
    }

    public double[] getJerk() {
        return jerk;
    }

    public double[] getHead() {
        return head;
    }

    public double[] listToDoubleArray(List<String> l) {
        double[] target = new double[l.size()];
        for (int i = 0; i < target.length; i++) {
           target[i] =  Double.parseDouble(l.get(i));                // java 1.5+ style (outboxing)
        }
        return target;
    }
}