
/**
 * Write a description of class Demo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Demo
{
    public static void main(String[] args){
        exercise6b();
        exercise7b();
    }
    
    /**
     * Write instructions for exercise 6b
     */
    private static void exercise6b()
    {
        Triangle triangle1 = new Triangle();
        
        triangle1.makeVisible();
        triangle1.changeSize(300, 300);
        triangle1.moveHorizontal(100);
        triangle1.moveVertical(-15);
    }
      
    /**
     * Write instructions for exercise 7b
     */
    private static void exercise7b()
    {
        Square square1 = new Square();
        
        square1.makeVisible();
        square1.changeSize(10);
        square1.moveHorizontal(-60);
        square1.moveVertical(-50);
        square1.slowMoveHorizontal(290);
        square1.slowMoveVertical(290);
    }   
    

   
}
