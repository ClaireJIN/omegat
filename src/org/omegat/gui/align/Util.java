/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool 
          with fuzzy matching, translation memory, keyword search, 
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2016 Aaron Madlon-Kay
               Home page: http://www.omegat.org/
               Support center: http://groups.yahoo.com/group/OmegaT/

 This file is part of OmegaT.

 OmegaT is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 OmegaT is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************/

package org.omegat.gui.align;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.omegat.util.Language;

/**
 * @author Aaron Madlon-Kay
 */
public class Util {

    static <T> int indexByIdentity(List<T> items, T item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == item) {
                return i;
            }
        }
        return -1;
    }

    static <T> boolean removeByIdentity(List<T> items, T item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == item) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    static <T, U> List<U> mapList(List<T> items, Map<T, U> map) {
        List<U> result = new ArrayList<U>();
        for (T item : items) {
            result.add(map.get(item));
        }
        return result;
    }

    static String join(String delimiter, List<?> items) {
        if (items.isEmpty()) {
            return "";
        }
        if (items.size() == 1) {
            return String.valueOf(items.get(0));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i));
            sb.append(delimiter);
        }
        sb.delete(sb.length() - delimiter.length(), sb.length());
        return sb.toString();
    }

    static String join(Language lang, List<?> items) {
        return Util.join(lang.isSpaceDelimited() ? " " : "", items);
    }

    static <T> boolean deepEquals(Collection<T> items1, Collection<T> items2) {
        if (items1 == items2 || items1.equals(items2)) {
            return true;
        }
        if (items1.size() != items2.size()) {
            return false;
        }
        Iterator<T> i1 = items1.iterator();
        Iterator<T> i2 = items2.iterator();
        while (i1.hasNext()) {
            T o1 = i1.next();
            T o2 = i2.next();
            if (o1 == null && o2 == null) {
                // Fallthrough
            } else if (o1 == null || o2 == null) {
                return false;
            } else if (!o1.equals(o2)) {
                return false;
            }
        }
        return true;
    }
}