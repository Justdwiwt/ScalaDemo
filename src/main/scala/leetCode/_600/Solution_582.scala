package leetCode._600

import scala.collection.mutable

object Solution_582 {
  def killProcess(pid: List[Int], ppid: List[Int], kill: Int): List[Int] = {
    var res = List.empty[Int]
    var m = mutable.HashMap.empty[Int, List[Int]]
    ppid.indices.foreach(i => {
      val id = ppid(i)
      var p = m.getOrElse(id, List.empty[Int])
      p ::= pid(i)
      m += id -> p
    })
    var q = List.empty[Int]
    q ::= kill
    while (q.nonEmpty) {
      var p = q.head
      q = q.tail
      res ::= p
      m.getOrElse(p, List.empty[Int]).foreach(c => q ::= c)
    }
    res
  }
}
