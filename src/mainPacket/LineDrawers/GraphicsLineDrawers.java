package mainPacket.LineDrawers;

import mainPacket.LineDrawer;
import mainPacket.PixelDrawer;

import java.awt.*;

public class GraphicsLineDrawers implements LineDrawer {
    private Graphics g;

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        drawLine(x1,y1,x2,y2,color);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
    }
    public GraphicsLineDrawers(Graphics g){
        this.g=g;
    }
}
