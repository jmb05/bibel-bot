/*
 * Copyright (C) 2020 Jared
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.jmb19905.bibel.bot.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XLSXReaderExample{

    public static String ReadCellData(String fileName, int vRow, int vColumn){  
        @SuppressWarnings("UnusedAssignment")
        String value = null;          //variable for storing the cell value  
        Workbook wb = null;           //initialize Workbook null  
        try{  
            //reading data from a file in the form of bytes  
            FileInputStream fis = new FileInputStream(fileName);
            //constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
            wb = new XSSFWorkbook(fis);  
        }  
        catch(FileNotFoundException e){
            System.err.println("FileNotFoundException");
        }  
        catch(IOException e1){
            System.err.println("IOException");
        }
        assert wb != null;
        @SuppressWarnings("null")
        Sheet sheet = wb.getSheetAt(0);   //getting the XSSFSheet object at given index  
        Row row = sheet.getRow(vRow); //returns the logical row  
        Cell cell = row.getCell(vColumn); //getting the cell representing the given column  
        value = cell.getStringCellValue();    //getting cell value  
        return value;               //returns the cell value  
    }
}  