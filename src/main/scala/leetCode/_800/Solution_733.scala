package leetCode._800

object Solution_733 {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    if (image(sr)(sc) == newColor) return image
    dfs(image, sr, sc, image(sr)(sc), newColor)
    image
  }

  private def dfs(image: Array[Array[Int]], i: Int, j: Int, color: Int, newColor: Int): Unit = {
    if (i < 0 || i >= image.length || j < 0 || j >= image.head.length || image(i)(j) != color) return
    image(i)(j) = newColor
    dfs(image, i + 1, j, color, newColor)
    dfs(image, i, j + 1, color, newColor)
    dfs(image, i - 1, j, color, newColor)
    dfs(image, i, j - 1, color, newColor)
  }
}
