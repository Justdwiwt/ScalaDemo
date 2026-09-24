package leetCode._4000

object Solution_3998 {
  def transformStr(s: String, strs: Array[String]): Array[Boolean] = {
    val total0 = s.count(_ == '0')

    def check(t: String): Boolean = {
      val cnt0 = t.count(_ == '0')
      val cntQ = t.count(_ == '?')

      if (total0 < cnt0 || total0 > cnt0 + cntQ) false
      else t
        .zip(s)
        .foldLeft((0, 0, cnt0, true)) {
          case ((s1, t1, zeros, ok), (y, x)) =>
            val (ny, nextZeros) =
              if (y == '?') {
                if (zeros < total0) ('0', zeros + 1)
                else ('1', zeros)
              } else (y, zeros)

            val nextS1 = s1 + (if (x == '1') 1 else 0)
            val nextT1 = t1 + (if (ny == '1') 1 else 0)

            (nextS1, nextT1, nextZeros, ok && nextS1 >= nextT1)
        }._4
    }

    strs.map(check)
  }
}
