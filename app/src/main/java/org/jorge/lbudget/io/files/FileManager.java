/*
 * This file is part of LBudget.
 * LBudget is free software: you can redistribute it and/or modify
 * it under the terms of version 3 of the GNU General Public License as published by
 * the Free Software Foundation
 * LBudget is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with LBudget. If not, see <http://www.gnu.org/licenses/>.
 */

package org.jorge.lbudget.io.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class FileManager {
    public static Boolean recursiveDelete(File dir) {
        if (dir == null) return Boolean.FALSE;
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (String aChildren : children) {
                Boolean success = recursiveDelete(new File(dir, aChildren));
                if (!success) {
                    return false;
                }
            }
        }

        return dir.delete();
    }

    public static void writeStringToFile(String string, File file)
            throws IOException {

        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(string.getBytes(Charset.defaultCharset()));
        outputStream.close();
    }
}
