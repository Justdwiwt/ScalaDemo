package leetCode

import scala.util.control.Breaks._

object Code_16_18 {
  def patternMatching(pattern: String, value: String): Boolean = {
    var a = 0
    var b = 0
    pattern.indices.foreach(i => if (pattern(i) == 'a') a += 1 else b += 1)
    if ("".equals(value)) {
      if (a * b == 0) return true
      return false
    }
    if ("".equals(pattern)) return false
    if (b == pattern.length) a = b
    if (a == pattern.length) {
      if (value.length % a != 0) return false
      val c = value.length / a
      val s = value.substring(0, c)
      (0 until a).foreach(i => if (!s.equals(value.substring(c * i, c * (i + 1)))) return false)
      return true
    }
    var r = Array.empty[Array[Int]]
    breakable {
      (0 to value.length).foreach(i => {
        val t = value.length - a * i
        if (t < 0) break()
        if (t % b == 0) {
          var res = Array.empty[Int]
          res :+= i
          res :+= (t / b)
          r :+= res
        }
      })
    }
    val i = pattern.indexOf('a')
    val j = pattern.indexOf('b')
    r.foreach(v => {
      val m = v(0)
      val n = v(1)
      var sum = 0
      val s1 = value.substring(i * n, i * n + m)
      val s2 = value.substring(j * m, j * m + n)
      breakable {
        if (s1.equals(s2)) break()
      }
      var flag = true
      breakable {
        pattern.indices.foreach(k => {
          val s = if (pattern(k) == 'a') s1 else s2
          var p = if (pattern(k) == 'a') m else n
          if (!s.equals(value.substring(sum, sum + p))) {
            flag = false
            break()
          }
          sum += p
        })
      }
      if (flag) return true
    })
    false
  }
}
