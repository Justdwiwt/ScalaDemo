package leetCode.LCP

object LCP_65 {
  def unSuitability(operate: Array[Int]): Int = {
    val mx = operate.max * 2 + 1

    def updateF(pre: Vector[Int], x: Int): Vector[Int] = {
      val initialF = Vector.fill(mx)(Int.MaxValue)
      (0 until mx).foldLeft(initialF)((f, j) => {
        val dis = pre(j)
        if (dis != Int.MaxValue) {
          val f1 = if (j + x < mx) f.updated(j + x, f(j + x).min(dis.max(j + x))) else f
          val f2 = if (j >= x) f1.updated(j - x, f1(j - x).min(dis)) else f1
          if (j < x) f2.updated(0, f2.head.min(dis - j + x)) else f2
        } else f
      })
    }

    val initialPre = Vector.fill(mx)(Int.MaxValue).updated(0, 0)
    val finalPre = operate.foldLeft(initialPre)((pre, x) => updateF(pre, x))

    finalPre.min
  }
}
