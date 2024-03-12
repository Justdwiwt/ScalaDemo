package leetCode.LCP

object LCP_51 {
  private var mx = -1

  def perfectMenu(materials: Array[Int], cookbooks: Array[Array[Int]], attribute: Array[Array[Int]], limit: Int): Int = {
    cookbooks.indices.foreach(i => dfs(materials, cookbooks, attribute, limit, 0, 0, i))
    mx
  }

  private def dfs(materials: Array[Int], cookbooks: Array[Array[Int]], attribute: Array[Array[Int]], limit: Int, delicious: Int, full: Int, dishNum: Int): Unit = {
    var isLackOfMaterial = false
    var f = full
    val d = dishNum
    var de = delicious
    (0 until 5).foreach(i => {
      materials(i) -= cookbooks(d)(i)
      if (materials(i) < 0) isLackOfMaterial = true
    })
    if (!isLackOfMaterial) {
      de += attribute(d).head
      f += attribute(d)(1)
      if (f >= limit) mx = mx.max(de)
      (d + 1 until cookbooks.length).foreach(i => dfs(materials, cookbooks, attribute, limit, de, f, i))
      de -= attribute(d).head
      f -= attribute(d)(1)
    }
    (0 until 5).foreach(i => materials(i) += cookbooks(d)(i))
  }
}
