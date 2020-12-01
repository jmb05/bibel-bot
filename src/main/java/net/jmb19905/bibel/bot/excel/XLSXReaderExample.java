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

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class XLSXReaderExample{  
    public static void read(String fileString){  
        try{  
            File file = new File(fileString);   //creating a new file instance  
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
            //creating Workbook instance that refers to .xlsx file  
            XSSFWorkbook wb = new XSSFWorkbook(fis);   
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
            while (itr.hasNext()){ 
                Row row = itr.next();  
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();  
                    switch (cell.getCellType()){
                        case STRING:    //field that represents string cell type  
                            System.out.print(cell.getStringCellValue() + "\t\t\t");  
                            break;  
                        case NUMERIC:    //field that represents number cell type  
                            System.out.print(cell.getNumericCellValue() + "\t\t\t");  
                            break;  
                        default:
                    }
                }
                System.out.println("");
            }
        }
        catch(IOException e)  
        {  
        }  
    }

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
        @SuppressWarnings("null")
        Sheet sheet = wb.getSheetAt(0);   //getting the XSSFSheet object at given index  
        Row row = sheet.getRow(vRow); //returns the logical row  
        Cell cell = row.getCell(vColumn); //getting the cell representing the given column  
        value = cell.getStringCellValue();    //getting cell value  
        return value;               //returns the cell value  
    }
}  