package com.yyb.learn.jbasic.utils;

public class ExcelImportUtils {
    /**
     * Checks if is excel 2003.
     *
     * @param filePath the file path
     * @return true, if is excel 2003
     */
    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**
     * Checks if is excel 2007.
     *
     * @param filePath the file path
     * @return true, if is excel 2007
     */
    // @描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    /**
     * 验证EXCEL文件.
     *
     * @param filePath the file path
     * @return true, if successful
     */
    public static boolean validateExcel(String filePath) {
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            return false;
        }
        return true;
    }

}
