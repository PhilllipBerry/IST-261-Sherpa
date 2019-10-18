package View;


public class View
{
    //---------------Attributes---------------
    final private InitialFrame initialFrame;

    //--------------Constructor---------------
    public View()
    {
        initialFrame = new InitialFrame();
    }

    //--------------Modules---------------
    public InitialFrame getInitialFrame()
    {
        return initialFrame;
    }    
}
