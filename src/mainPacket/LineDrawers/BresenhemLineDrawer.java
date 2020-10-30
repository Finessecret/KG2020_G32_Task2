package mainPacket.LineDrawers;

import mainPacket.LineDrawer;
import mainPacket.PixelDrawer;

import java.awt.*;

public class BresenhemLineDrawer implements LineDrawer {
    private final PixelDrawer pd;

    public BresenhemLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    private int sign(int x) {
        return Integer.compare(x, 0); // Возвращает значение, в сравнении с нулём
         /*
         Значение равно 1, x > 0
         Значение равно 0, x = 0
         Значение равно -1, x< 0
         */
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        int dx, dy, dxM, dyM;
        int moveX, moveY, offsX, offsY, acn;

        dx = x2 - x1;
        dy = y2 - y1;

        dxM = Math.abs(dx);
        dyM = Math.abs(dy);

        moveX = sign(dx);
        moveY = sign(dy);

        if (dxM > dyM) { //определяем наклон отрезка
            offsX = moveX;
            offsY = 0;
            dxM = Math.abs(dy);
            dyM = Math.abs(dx);
        } else {
            offsX = 0;
            offsY = moveY;
        }
        pd.drawPixel(x1,y1,Color.BLACK);

        acn = (int) (dyM / 2); // середина между пикселями
        for(int i = 0; i < dyM; i++){ //идём по всем точкам, начиная со второй и до последней
            acn = (acn - dxM);
            if(acn<0){
                acn = (acn + dyM);
                x1 += moveX;
                y1 += moveY;
            }else{
                x1 += offsX;
                y1 += offsY;
            }
            pd.drawPixel(x1,y1,Color.BLACK);
        }
    }




    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        drawLine(x1, y1, x2, y2, Color.BLACK);
    }
}