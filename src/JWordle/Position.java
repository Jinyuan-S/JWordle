/*
 * Copyright 2022 Jinyuan Sun (https://github.com/Jinyuan-S)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.THE
 * SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package JWordle;

/**
 * Store the current input position and provides several getters and setters.
 * <p>
 *     It is a static class with only static methods and class variables, shared by all the class in the package.
 * </p>
 * <p><b>row</b> indicates the current row.(initial value is 0)</p>
 * <p><b>col</b> indicates the current col.(initial value is 0)</p>
 */
public class Position {
    /**
     * <b>row</b> indicates the current row.(initial value is 0)
     */
    private static int row = 0;
    /**
     * <b>col</b> indicates the current col.(initial value is 0)
     */
    private static int col = 0;

    /**
     * Getter of row.
     * @return the current row.
     */
    public static int getRow(){
        return row;
    }

    /**
     * Getter of col.
     * @return the current column.
     */
    public static int getCol(){
        return col;
    }

    /**
     * Setter of row.
     * @param r Private static int row.
     */
    public static void setRow(int r){
        Position.row = r;
    }

    /**
     * Setter of row.
     * @param c Private static int col.
     */
    public static void setCol(int c){
        Position.col = c;
    }
}
