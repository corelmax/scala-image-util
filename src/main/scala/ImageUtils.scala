package utilities

import java.awt.{Dimension, Graphics2D}
import java.awt.image.BufferedImage

object ImageUtils {

  def mergeImageCenteredWithDimension(src: BufferedImage, overlay: BufferedImage, dstDimension: Dimension): BufferedImage = {
    val mergedBufferedImage: BufferedImage = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_RGB)
    val mergedGraphics: Graphics2D = mergedBufferedImage.getGraphics.asInstanceOf[Graphics2D]

    val centerX: Int = src.getWidth() / 2
    val centerY: Int = src.getHeight() / 2

    val beginX: Int = centerX - (dstDimension.width / 2)
    val beginY: Int = centerY - (dstDimension.height / 2)

    mergedGraphics.drawImage(src, 0, 0, src.getWidth(), src.getHeight(), null)
    mergedGraphics.drawImage(overlay, beginX, beginY, dstDimension.width, dstDimension.height, null)
    mergedGraphics.dispose()

    return mergedBufferedImage
  }

  def mergeImageCentered(src: BufferedImage, overlay: BufferedImage): BufferedImage = {

    val srcDimension: Dimension = new Dimension(src.getWidth(), src.getHeight())
    val overlayDimension: Dimension = new Dimension(overlay.getWidth(), overlay.getHeight())

    val dstOverlayDimension: Dimension = getScaledDimension(overlayDimension, srcDimension)

    return mergeImageCenteredWithDimension(src, overlay, dstOverlayDimension)
  }

  def getScaledDimension(imageSize: Dimension, boundary: Dimension): Dimension = {
    val wRatio: Double = boundary.getWidth() / imageSize.getWidth()
    val hRatio: Double = boundary.getHeight() / imageSize.getHeight()
    val ratio: Double = Math.min(wRatio, hRatio)

    return new Dimension((imageSize.getWidth() * ratio).asInstanceOf[Int], (imageSize.getHeight() * ratio).asInstanceOf[Int])
  }

}
