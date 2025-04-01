package com.example.zhangcedemos.png2pdf

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.zhangcedemos.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * author : zhangce
 * date: on 2025/4/1
 **/
class Png2PdfActivity : AppCompatActivity() {
    private lateinit var createFileBtn: Button
    private lateinit var contentView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_png2pdf)
        contentView = findViewById(R.id.png_content_layout)
        createFileBtn = findViewById(R.id.create_file_btn)
        createFileBtn.setOnClickListener {
            viewToPdf(contentView)
        }
    }

    private fun pngToPdf() {
        val basePath = getExternalFilesDir(null)?.absolutePath
        val pdfFilePath: String = basePath + File.separator.toString() + "generate.pdf"
        val pngFilePath = Environment.getExternalStorageDirectory().absolutePath + "/picture/"

        val fullFile = File(pngFilePath)
        if (fullFile.exists()) {
            Log.i("TAG", "list====${fullFile.absolutePath}")
        }
        val listFile = imageFileListReader(fullFile)
        Log.i("TAG", "list====${listFile.size}")
        generatePdf(contentView, listFile, pdfFilePath)
    }

    private fun generatePdf(view: View, listFile: ArrayList<File>, savePdfPath: String) {
        val time = System.currentTimeMillis()
        Log.i("TAG", "PDF的文件生成，正在开始----$time")
        if (listFile.size == 0) {
            Log.i("TAG", "list为空")
            return
        }
        //总页数
        val pdfCount = listFile.size

        //1, 建立PdfDocument
        val document = PdfDocument()

        //生成多页的pdf
        for (i in 0 until pdfCount) {
            // setContentRect(new Rect(0,60,view.getWidth(),60))
            //2 crate a page description
            val pageInfo = PdfDocument.PageInfo.Builder(
                view.width, view.height, pdfCount
            ).create()

            val file = listFile[i].absolutePath
            //3、start a page
            val page = document.startPage(pageInfo)
            val canvas: Canvas = page.canvas
            var mBitmap = BitmapFactory.decodeFile(file)
            mBitmap = mBitmap.copy(Bitmap.Config.ARGB_8888, true)
            //为了完整显示，进行缩放
            mBitmap = imageScale(mBitmap, view.width, view.height)
            //将布局绘制在中间位置
            canvas.drawBitmap(
                mBitmap,
                view.width / 2.0f - mBitmap.width / 2,
                view.height / 2.0f - mBitmap.height / 2,
                Paint()
            );
            view.draw(canvas)
            ///5、finish the page
            document.finishPage(page)
            mBitmap.recycle()
        }
        try {
            //write the document content
            document.writeTo(FileOutputStream(File(savePdfPath)))
            Log.i("TAG", "PDF的文件生成，已完成---${System.currentTimeMillis() - time}")
        } catch (e: IOException) {
            Log.i("TAG", "文件生成失败---${e.printStackTrace()}")

        }
        //close the document
        document.close()
    }

//    fun readResourceIdGeneratePdf(view: View) {
//        val basePath = getExternalFilesDir(null)?.absolutePath
//        val pdfFilePath: String = basePath + File.separator.toString() + "generate.pdf"
//        Log.i("TAG", "generatePdf:===$pdfFilePath")
//        val pdfFile = File(pdfFilePath)
//        if (pdfFile.exists()) {
//            pdfFile.delete()
//        }
//        val pdfCount = 3 //总页数
//        val document = PdfDocument() //1, 建立PdfDocument
//
//        //生成多页的pdf
//        for (i in 0 until pdfCount) {
//            //  .setContentRect(new Rect(0,60,view.getWidth(),60))
//            //2 crate a page description
//            val pageInfo = PdfDocument.PageInfo.Builder(
//                view.width, view.height, pdfCount
//            ).create()
//            //3、start a page
//            val page = document.startPage(pageInfo)
//            val canvas: Canvas = page.canvas
//            var mBitmap = BitmapFactory.decodeResource(resources, R.mipmap.s1)
//            if (i == 1) {
//                mBitmap = BitmapFactory.decodeResource(resources, R.mipmap.s2)
//            } else if (i == 2) {
//                mBitmap = BitmapFactory.decodeResource(resources, R.mipmap.s3)
//            }
//            mBitmap = mBitmap.copy(Bitmap.Config.ARGB_8888, true)
//            //为了完整显示，进行缩放
//            mBitmap = imageScale(mBitmap, view.width, view.height)
//            //将布局绘制在中间位置
//            canvas.drawBitmap(
//                mBitmap,
//                view.width / 2.0f - mBitmap.width / 2,
//                view.height / 2.0f - mBitmap.height / 2,
//                Paint()
//            );
//            view.draw(canvas)
//            ///5、finish the page
//            document.finishPage(page)
//            mBitmap.recycle()
//        }
//        try {
//            //write the document content
//            document.writeTo(FileOutputStream(pdfFile))
//            Log.i("TAG", "文件已生成")
//        } catch (e: IOException) {
//            Log.i("TAG", "文件生成失败---${e.printStackTrace()}")
//
//        }
//        //close the document
//        document.close()
//    }

    fun viewToPdf(view: View) {
        val basePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath
        val pdfFilePath: String = basePath + File.separator.toString() + "generate.pdf"
        Log.i("TAG", "generatePdf:===$pdfFilePath")
        val pdfFile = File(pdfFilePath)
        if (pdfFile.exists()) {
            pdfFile.delete()
        }
        //总页数
        val pdfCount = 3
        //1, 建立PdfDocument
        val document = PdfDocument()

        //生成多页的pdf
        for (i in 0 until pdfCount) {
            //  .setContentRect(new Rect(0,60,view.getWidth(),60))
            //2 crate a page description
            val pageInfo = PdfDocument.PageInfo.Builder(
                view.width, view.height, pdfCount
            ).create()
            //3、start a page
            val page = document.startPage(pageInfo)
            val canvas: Canvas = page.canvas
            view.draw(canvas)
            ///5、finish the page
            document.finishPage(page)
        }
        try {
            //write the document content
            document.writeTo(FileOutputStream(pdfFile))
            Log.i("TAG", "文件已生成")
        } catch (e: IOException) {
            Log.i("TAG", "文件生成失败---${e.printStackTrace()}")

        }
        //close the document
        document.close()

    }

    /**
     * 按比例缩放图片,正方形
     *
     * @param origin 原图
     * @param ratio  比例
     * @return 新的bitmap
     */
    fun scaleBitmapWithSquare(origin: Bitmap?, ratio: Float): Bitmap? {
        if (origin == null) {
            return null
        }
        var width = origin.width
        var height = origin.height
        val matrix = Matrix()
        matrix.preScale(ratio, ratio)
        if (width > height) {
            width = height
        } else {
            height = width
        }
        val newBM = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false)
        if (newBM.equals(origin)) {
            return newBM
        }
        origin.recycle()
        return newBM
    }

    /**
     * 根据给定的宽和高进行拉伸
     * @param bitmap
     * 源
     * @param dst_w
     * 输出宽度
     * @param dst_h
     * 输出高度
     * @return
     */
    private fun imageScale(bitmap: Bitmap, dst_w: Int, dst_h: Int): Bitmap {
        val srcW = bitmap.width
        val srcH = bitmap.height
        val scaleW = dst_w.toFloat() / srcW
        val scaleH = dst_h.toFloat() / srcH

        Log.i("---", "imageScale: ----$scaleW----$scaleH")
        val matrix = Matrix()
        if (scaleW > scaleH) {
            matrix.postScale(scaleH, scaleH)
        } else {
            matrix.postScale(scaleW, scaleW)
        }

        return Bitmap.createBitmap(
            bitmap, 0, 0, srcW, srcH, matrix,
            true
        )
    }

    private fun imageFileListReader(root: File): ArrayList<File> {
        val fileList: ArrayList<File> = ArrayList()
        val files = root.listFiles()
        if (files != null && files.isNotEmpty()) {
            for (i in files.indices)
                if (files[i].name.endsWith(".jpg") ||
                    files[i].name.endsWith(".png")
                )
                    fileList.add(files[i])
        }
        return fileList
    }
}