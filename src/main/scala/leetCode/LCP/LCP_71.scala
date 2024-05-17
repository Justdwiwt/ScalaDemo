package leetCode.LCP

object LCP_71 {
  val N: Int = 50 * 50 * 4 + 5
  val arr: Array[Int] = new Array[Int](N)

  private def fd(x: Int): Int = {
    if (arr(x) != arr(arr(x))) arr(x) = fd(arr(x))
    arr(x)
  }

  private def mg(x: Int, y: Int): Unit = {
    val rootX = fd(x)
    val rootY = fd(y)
    if (rootX != rootY) arr(rootX) = rootY
  }

  private def co(x: Int, y: Int): Boolean = {
    fd(x) == fd(y)
  }

  def reservoir(shape: Array[String]): Int = {
    val h: Int = shape.length
    val w: Int = shape.head.length
    val n: Int = h * w * 4
    var res: Int = 0

    (0 until N).foreach(i => arr(i) = i)

    (h - 1 to 0 by -1).foreach(i => {
      var k: Int = i * w * 4
      mg(n, k + 1)
      mg(n, k + w * 4 - 1)
      if (i == h - 1)
        (0 until w).foreach(_ => {
          mg(n, k)
          k += 4
        })

      k = i * w * 4
      shape.head.indices.foreach(j => {
        if (shape(i)(j) == '.') {
          mg(k, k + 1)
          mg(k, k + 2)
          mg(k, k + 3)
        } else if (shape(i)(j) == 'l') {
          mg(k, k + 1)
          mg(k + 3, k + 2)
        } else {
          mg(k, k + 3)
          mg(k + 1, k + 2)
        }
        if (j > 0) mg(k + 1, k - 1)
        k += 4
      })

      k = i * w * 4
      shape.head.indices.foreach(_ => (0 until 4).foreach(_ => {
        if (!co(k, n)) res += 1
        k += 1
      }))

      k = i * w * 4
      if (i > 0) shape.head.indices.foreach(_ => {
        mg(k - w * 4, k + 2)
        k += 4
      })
      else shape.head.indices.foreach(_ => {
        mg(n, k + 2)
        k += 4
      })
    })

    (0 until n).foreach(i => if (!co(i, n)) res -= 1)

    res / 2
  }
}
