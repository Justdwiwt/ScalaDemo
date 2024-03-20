package leetCode._2100

import scala.collection.mutable.ArrayBuffer

object Solution_2081 {
  def kMirror(k: Int, n: Int): Long = {
    val pow = Array.iterate(1L, 63)(_ * 10)
    var res = 0L
    var ab = ArrayBuffer(0)

    def next(): Boolean = {
      val i = ab.lastIndexWhere(_ != 9)
      if (i == -1) false
      else {
        ab(i) += 1
        (i + 1 until ab.size).foreach(ab(_) = 0)
        true
      }
    }

    def form(len: Int): Long = {
      (ab.indices.iterator ++ (ab.size - (if (len % 2 == 0) 1 else 2) to 0 by -1)
        .iterator)
        .map(ab)
        .zipWithIndex./:(0L)((r, di) => {
        val (dig, idx) = di
        r + dig * pow(idx)
      })
    }

    def isKMir(num: Long): Boolean = {
      if (num % k == 0) return false
      val buf = ArrayBuffer.empty[Long]
      var t = num
      while (t != 0) {
        buf += t % k
        t /= k
      }
      (0 until (buf.size / 2)).forall(i => buf(i) == buf(buf.size - i - 1))
    }

    @scala.annotation.tailrec
    def search(len: Int, left: Int): Unit = {
      if (left != 0) {
        if (!next()) {
          val newLen = len + 1
          ab = ArrayBuffer.fill((newLen + 1) / 2)(9)
          ab(0) = 0
          search(newLen, left)
        } else {
          val num = form(len)
          if (isKMir(num)) {
            res += num
            search(len, left - 1)
          } else search(len, left)
        }
      }
    }

    search(1, n)
    res
  }
}
