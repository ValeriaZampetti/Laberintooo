
package EstructurasDeDatos;

/**
 *
 * @author valeriazampetti
 */
public class Muro {
     private boolean left;
    private boolean top;
    private boolean right;
    private boolean bottom;
//    private boolean visited;
    
    public Muro()
    {
        // true -> existe muro
        // false -> no existe muro
        this.bottom = true;
        this.left = true;
        this.right = true;
        this.top = true;
    }

    /**
     * @return the left
     */
    public boolean isLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * @return the top
     */
    public boolean isTop() {
        return top;
    }

    /**
     * @param top the top to set
     */
    public void setTop(boolean top) {
        this.top = top;
    }

    /**
     * @return the right
     */
    public boolean isRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(boolean right) {
        this.right = right;
    }

    /**
     * @return the bottom
     */
    public boolean isBottom() {
        return bottom;
    }

    /**
     * @param bottom the bottom to set
     */
    public void setBottom(boolean bottom) {
        this.bottom = bottom;
    }
    
    
}
