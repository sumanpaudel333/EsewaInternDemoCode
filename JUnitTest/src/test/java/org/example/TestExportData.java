package org.example;

import com.sun.source.tree.AssertTree;
import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestExportData {
    @RepeatedTest(value = 10)
    @DisplayName("Testing Exported Data")
    public void checkExportData(){
        ExportData exportData=new ExportData();
        Assertions.assertEquals("Data Exported",exportData.checkExportData());
    }
    @ParameterizedTest
    @ValueSource(ints = {10,22,32,33,78})
    public void testCheckEven(int number){
        ExportData exportData=new ExportData();
        Assert.assertTrue(exportData.checkEven(number));
    }
    @ParameterizedTest
    @ValueSource(strings={"Suman","Saurav","Shreejal","Preet"})
    public void sayHelloTest(String name){
    ExportData exportData=new ExportData();
    Assertions.assertEquals("Hello Suman",exportData.sayHello(name));
    }
}
