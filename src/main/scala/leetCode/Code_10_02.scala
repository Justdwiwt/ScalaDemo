package leetCode

import scala.collection.mutable

object Code_10_02 {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    var res = List.empty[List[String]]
    val m = mutable.HashMap.empty[String, List[String]]
    strs.indices.foreach(i => {
      val arr = strs(i).toCharArray.sorted
      val s = new String(arr)
      if (!m.contains(s)) {
        var t = Array.empty[String]
        t :+= strs(i)
        m += s -> t.toList
      } else m(s) ::= strs(i)
    })
    m.keySet.foreach(k => res ::= m(k))
    res
  }
}
