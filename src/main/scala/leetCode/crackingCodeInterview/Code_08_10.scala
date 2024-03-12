package leetCode.crackingCodeInterview

object Code_08_10 {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    val dx = Array(0, 1, 0, -1)
    val dy = Array(1, 0, -1, 0)
    val diff = Array.ofDim[Int](59, 59)

    def dfs(image: Array[Array[Int]], x: Int, y: Int, newColor: Int, currentColor: Int): Unit = {
      diff(x)(y) = 1
      image(x)(y) = newColor
      (0 until 4).foreach(i => {
        val nx = x + dx(i)
        val ny = y + dy(i)
        if (nx >= 0 && nx < image.length && ny >= 0 && ny < image(0).length && !(diff(nx)(ny) > 0) && image(nx)(ny) == currentColor)
          dfs(image, nx, ny, newColor, currentColor)
      })
    }

    dfs(image, sr, sc, newColor, image(sr)(sc))
    image
  }
}
