package utilities

import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO
import collection.mutable.Stack
import org.scalatest.FunSuite


class ImageUtilsTest extends FunSuite {
  test("Create watermasked image") {
    var srcImageFile: File = new File("resources/test_image.jpg")
    var overlayImageFile: File = new File("resources/test_overlay.png")
    var srcBufferedImage: BufferedImage = ImageIO.read(srcImageFile)
    var overlayBufferedImage: BufferedImage = ImageIO.read(overlayImageFile)

    var mergedBufferedImage: BufferedImage = ImageUtils.mergeImageCentered(srcBufferedImage, overlayBufferedImage)

    var outputImageFile: File = new File("resources/test_output.jpg")
    ImageIO.write(mergedBufferedImage, "jpeg", outputImageFile)

  }
}
