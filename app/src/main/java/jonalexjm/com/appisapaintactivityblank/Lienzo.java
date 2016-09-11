package jonalexjm.com.appisapaintactivityblank;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by andrea on 10/09/2016.
 */






public class Lienzo extends View {

    //path que utilizare para ir pintando las lineas
    private Path drawPath;
    // Paint de dibujar y paint de Canvas
    private static Paint drawPaint;

    private Paint  canvasPaint;
    //color inicial
    private int paintColor = 0xFF660000;
    //CANVAS
    private Canvas drawCanvas;
    //canvas para guardar
    private Bitmap canvasBitmap;

    float TamanoPunto;

    boolean borrado = false;



    public Lienzo(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    private void setupDrawing(){

        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);

        //TamanoPunto=20;

        drawPaint.setStrokeWidth(20);
        drawPaint.setStyle(Paint.Style.STROKE);//PINTAR SOLO EN TRAZOS(REDONDEADA)
        drawPaint.setStrokeJoin(Paint.Join.ROUND);// LA PINTURA SEA REDONDEADA
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);//LE PASAMOS LAS CARACTERISTICAS...PINTAR MAS DIFUMINADO


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    // pinta la vista. sera llamado desde el onTouchEvent
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
    }

    // registra los touch de los usuarios
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);//ve la presion del dedo
                break;
            case  MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);//hace el seguimiento  del dedo
                break;
            case MotionEvent.ACTION_UP:
                drawPath.lineTo(touchX, touchY);//se levanta el dedo
                drawCanvas.drawPath(drawPath, drawPaint);
                drawPath.reset();
                break;
            default:
                return false;
        }

        invalidate();

        return true;
    }

    //actualiza color

    public void setColor(String newColor){
        invalidate();
        paintColor = Color.parseColor(newColor);
        drawPaint.setColor(paintColor);
    }

    //poner tamaño del punto
    public  void setTamanoPunto(Float nuevoTamano){
       // float pixel = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, nuevoTamano, getResources().getDisplayMetrics());
        //TamanoPunto = pixel;
        drawPaint.setStrokeWidth(nuevoTamano);

    }

    public void setBorrado(boolean estaborrado){
        borrado = estaborrado;
        if(borrado){

            drawPaint.setColor(Color.WHITE);
        }
        else{

            drawPaint.setColor(paintColor);
        }

    }

    public void NuevoDibujo(){
        drawCanvas.drawColor(0,PorterDuff.Mode.CLEAR);
        invalidate();
    }
}
