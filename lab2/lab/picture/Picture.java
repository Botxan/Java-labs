    /**
     * This class represents a simple picture. You can draw the picture using
     * the draw method. But wait, there's more: being an electronic picture, it
     * can be changed. You can set it to black-and-white display and back to
     * colors (only after it's been drawn, of course).
     *
     * This class was written as an early example for teaching Java with BlueJ.
     * 
     * @author  Michael Kolling and David J. Barnes
     * @version 2006.03.30
     */
    public class Picture
    {
        private Square wall;
        private Square window;
        private Triangle roof;
        private Circle sun;
        private boolean day;
    
        /**
         * Constructor for objects of class Picture
         */
        public Picture()
        {
            createPicture();
        }
    
        /**
         * Draw a house and the sun
         */
        public void createPicture()
        {
            
                wall = new Square(); // Default: (x: 60, y: 50), size 30, color: "red"
                wall.changeSize(100);
                wall.moveVertical(80);
                wall.makeVisible();
              
                window = new Square(); // Default: (x: 60, y: 50), size 30, color: "red"
                window.makeVisible();
                window.moveHorizontal(20);
                window.moveVertical(100);
                window.changeSize(30);
                window.changeColor("black");
                
                roof = new Triangle(); // Default: (x: 50, y: 15), height: 30, width: 40, color: "green" 
                roof.makeVisible();
                roof.moveHorizontal(60);
                roof.moveVertical(70);
                roof.changeSize(50, 140);
                
                sun = new Circle(); // Default: (x: 20, y: 60), diameter: 30, color: "blue"
                sun.makeVisible();
                sun.moveHorizontal(180);
                sun.moveVertical(-10);
                sun.changeSize(60);
                sun.changeColor("yellow");
                
                day = true;
    }
    
    /**
     * Change this picture to night display
     */
    public void setNight()
    {
        if(wall != null && day)    // only if it's already painted  and it is day...
        {
            wall.changeColor("black");
            window.changeColor("white");
            roof.changeColor("black");
            sun.makeInvisible();
            day = false;
        }
    }
    
    /**
     * Change this picture to day display
     */
    public void setDay()
    {
        if(wall != null && !day)   // only if it's already painted  and it is night...
        {
            wall.changeColor("red");
            window.changeColor("black");
            roof.changeColor("green");
            sun.makeVisible();
            day = true;

        }
    }
    
    /**
     * Change ths picture state from day to night and the other way round
     */
    public void changeState(){
        if (day) {
            setNight();
        } else{
            setDay();
        }
    }
}
