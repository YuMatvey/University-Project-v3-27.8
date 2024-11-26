package org.example;
import org.apache.poi.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {

    public static void writeStatisticsToFile(List<Statistics> statistics, String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Statistics");

        // Создание заголовков
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Профиль", "Средний балл", "Количество студентов", "Количество университетов", "Названия университетов"};
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        headerStyle.setFont(font);

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Заполнение данными
        int rowIndex = 1;
        for (Statistics stat : statistics) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(stat.getProfile());
            row.createCell(1).setCellValue(stat.getAverageScore());
            row.createCell(2).setCellValue(stat.getStudentCount());
            row.createCell(3).setCellValue(stat.getUniversityCount());
            row.createCell(4).setCellValue(String.join(", ", stat.getUniversityNames()));
        }

        // Авторазмер колонок
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Сохранение файла
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
