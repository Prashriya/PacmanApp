
package cs1.PacmanApp;

import  cs1.app.*;

public class PacmanApp
{   
    //drawing the row of dots
    void drawDotsRow(double startX, double startY, double dotsDist, int n)
    {
        double curX = startX;
        double curY = startY;
        int radius = 6;
        int noOfPellet = 0;
        
        while( noOfPellet < n )
        {
            canvas.drawCircle(curX, curY, radius, "MediumTurquoise" );
            noOfPellet = noOfPellet + 1;
            curX = curX + dotsDist;
        }
    }
    
     //making pacman move in single row
    void movePacmanAlongRow( double startX, double startY, double endX, double speed)
    {
        double centerX = startX;
        double centerY = startY;
        double pacRadius = 22;
        double radius = 24;
        double startAngle = 30;
        double pieAngle = 300;

        while( centerX < endX )
        {
            canvas.drawPie( centerX, centerY, pacRadius, startAngle, pieAngle, "NavajoWhite" );
            canvas.sleep(0.5);
            canvas.drawCircle( centerX, centerY, pacRadius, "NavajoWhite" );
            canvas.sleep(0.5);
            canvas.drawCircle( centerX, centerY, radius, "white" );
            
            centerX = centerX + speed; 
        } 
    }
    
    //drawing the dots grid
    void drawDotsGrid( double startX, double startY, double horizDist, double vertDist, int numRows, int numCols )
    {
        double curX = startX;
        double curY = startY;
        
        int curRow = 1;
        while( curRow <= numRows )
        {
            drawDotsRow( curX, curY, horizDist, numCols );
            curY = curY + vertDist;
            
            curRow = curRow + 1;
        }
    }
    
    //making pacman move along the grid through all rows and cols
    void movePacmanAlongGrid ( double startX, double startY, double endX, double rowSpacing, int numRows, double speed )
    {  
        double curX = startX;
        double curY = startY;
        
        int curRow = 1;
        while( curRow <= numRows )
        {
            movePacmanAlongRow( curX, curY, endX, speed );
            curY = curY + rowSpacing;
            
            curRow = curRow + 1;
        }
    }
    
    void playPacmanGame( int numRows, int numCols, double speed )
    {   
        double horiSpace = (canvas.getWidth() / (numCols + 1));
        double vertSpace = (canvas.getHeight() / (numRows + 1));
        
        double endX = canvas.getWidth() - horiSpace;
        
        drawDotsGrid( horiSpace, vertSpace, horiSpace, vertSpace, numRows, numCols );
        movePacmanAlongGrid( horiSpace, vertSpace, endX, vertSpace, numRows, speed );       
    }
    
    //running the game
    public void run()
    {
        canvas.setBackgroundMusic( "wakawaka" );
        //drawDotsRow( 40, 170, 40, 8 );
        //drawDotsRow( 50, 70, 60, 5 );
        //drawDotsRow( 30, 80, 90, 4 );
        
        //movePacmanAlongRow( 40, 70, 360, 10 );
        //movePacmanAlongRow( 50, 90, 250, 40 );
        //movePacmanAlongRow( 70, 120, 320, 60 );
        
        //drawDotsGrid( 40, 70, 40, 30, 7, 6 );
        //drawDotsGrid( 50, 80, 90, 90, 6, 4 );
        //drawDotsGrid( 60, 60, 60, 40, 10, 5 );
        
        //movePacmanAlongGrid( 40, 70, 245, 30, 7, 40 );
        //movePacmanAlongGrid( 50, 80, 340, 50, 9, 50 );
        //movePacmanAlongGrid( 60, 90, 300, 20, 15, 30 );
        
        //playPacmanGame( 4, 3, 20 );
        //playPacmanGame( 6, 6, 30 );
        playPacmanGame( 5, 10, 10 );
        //playPacmanGame( 12, 8, 10 );
        canvas.stopBackgroundMusic();
    }
}

