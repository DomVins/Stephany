package com.stephany

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class BorderView(context: Context) : View(context) {

    // Thickness ratio = 4:1
    private  val thickLineSize = 16f
    private  val thinLineSize = 4f

    private val borderPaint = Paint().apply {
        color = 0xFF4285F4.toInt() // Tech blue color
        style = Paint.Style.STROKE
        strokeWidth = thinLineSize
    }

    private val borderPaintThick = Paint().apply {
        color = 0xFF4285F4.toInt() // Tech blue color
        style = Paint.Style.STROKE
        strokeWidth = thickLineSize
    }
    private val borderPaintThickInclined = Paint().apply {
        color = 0xFF4285F4.toInt() // Tech blue color
        style = Paint.Style.STROKE
        strokeWidth = thickLineSize * 0.58f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val chamferLength = width / 12f
        val borderMargin = 0f
        var clearance = thinLineSize * 1.5f
        var thickPortionLength = chamferLength * 2.5f // For the edges ...

        // Draw ...
        canvas.drawLine(borderMargin, chamferLength + borderMargin, borderMargin, thickPortionLength + borderMargin, borderPaintThick)
        canvas.drawLine(borderMargin + clearance, thickPortionLength + borderMargin, borderMargin + clearance, height - thickPortionLength - borderMargin, borderPaint)
        canvas.drawLine(borderMargin , height - thickPortionLength - borderMargin, borderMargin, height - chamferLength - borderMargin, borderPaintThick)
        canvas.drawLine(borderMargin, height - chamferLength - borderMargin, borderMargin + chamferLength, height - borderMargin, borderPaintThickInclined)
        canvas.drawLine(borderMargin + chamferLength, height - borderMargin, thickPortionLength + borderMargin, height - borderMargin, borderPaintThick)
        canvas.drawLine(thickPortionLength + borderMargin, height - borderMargin - clearance, width - thickPortionLength - borderMargin, height - borderMargin - clearance, borderPaint)
        canvas.drawLine(width - thickPortionLength - borderMargin, height - borderMargin, width - chamferLength - borderMargin, height - borderMargin, borderPaintThick)
        canvas.drawLine(width - chamferLength - borderMargin, height - borderMargin, width - borderMargin, height - chamferLength - borderMargin, borderPaintThickInclined)

        canvas.drawLine(width - borderMargin, height - chamferLength - borderMargin, width - borderMargin, chamferLength + borderMargin, borderPaint)
        canvas.drawLine(width - borderMargin, chamferLength + borderMargin, width - chamferLength - borderMargin, borderMargin, borderPaint)
        canvas.drawLine(width - chamferLength - borderMargin, borderMargin,  chamferLength + borderMargin, borderMargin, borderPaint)
        canvas.drawLine(chamferLength + borderMargin, borderMargin, borderMargin, chamferLength + borderMargin, borderPaint)

        // Do not add clearance in thick lines ...

    }
}
