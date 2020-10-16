package leetCode

import scala.collection.mutable

object Solution_420 {
  def strongPasswordChecker(s: String): Int = {
    var add = 0.max(6 - s.length)
    var delete = 0.max(s.length - 20)
    var res = 0

    var d = 1
    var a = 1
    var A = 1

    val ab = mutable.ArrayBuffer[Int]()

    var same = 0
    (0 to s.length).foreach(i => {
      if (i == s.length) {
        if (same > 1) ab += same
      } else if (i == 0 || (s(i) == s(i - 1))) {
        same += 1
      } else {
        if (same > 1) ab += same
        same = 1
      }

      if (i < s.length) {
        if (s(i).isDigit) d = 0
        if (s(i).isLower) a = 0
        if (s(i).isUpper) A = 0
      }
    })

    var missing = d + a + A
    val arr = ab.toArray

    arr.indices.foreach(i => if (arr(i) % 3 == 0) {
      if (delete >= 1) {
        delete -= 1
        res += 1
        arr(i) = arr(i) - 1
      }
    } else if (arr(i) % 3 == 1) {
      if (delete >= 2) {
        delete -= 2
        res += 2
        arr(i) = arr(i) - 2
      }
    })

    arr.indices.foreach(i => {
      val need = arr(i) - 2
      if (need <= delete) {
        arr(i) = arr(i) - need
        delete -= need
        res += need
      } else {
        arr(i) = arr(i) - delete
        res += delete
        delete = 0
      }
    })

    arr.indices.withFilter(i => arr(i) > 2).foreach(i => {
      while (arr(i) > 2 && add > 0) {
        add -= 1
        missing -= 1
        arr(i) -= 2
        res += 1
      }
      missing -= arr(i) / 3
      res += arr(i) / 3
    })

    while (missing > 0) {
      if (add > 0) add -= 1
      res += 1
      missing -= 1
    }

    add + delete + res
  }
}
