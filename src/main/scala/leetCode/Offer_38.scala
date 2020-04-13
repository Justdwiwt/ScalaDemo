package leetCode

import scala.util.control.Breaks._

object Offer_38 {
  private var res = Array.empty[String]

  def permutation(s: String): Array[String] = {
    val ch = s.toCharArray
    dfs(ch, 0)
    val str = Array.ofDim[String](res.length)
    if (s == null || s.length == 0) return str
    res.indices.foreach(i => str(i) = res(i))
    str.distinct
  }

  def dfs(ch: Array[Char], start: Int): Unit = {
    if (start == ch.length) {
      res :+= new String(ch)
      return
    }
    val used = Array.ofDim[Boolean](256)
    (start until ch.length).foreach(i => {
      breakable {
        if (used(ch(i))) break()
      }
      used(ch(i)) = true
      swap(ch, start, i)
      dfs(ch, start + 1)
      swap(ch, start, i)
    })
  }

  def swap(ch: Array[Char], i: Int, j: Int): Unit = {
    val t = ch(i)
    ch(i) = ch(j)
    ch(j) = t
  }
}
