package leetCode.offer

import scala.collection.mutable

object Offer_33 {
  def verifyPostorder(postorder: Array[Int]): Boolean = {
    val st = new mutable.Stack[Int]()
    var p = Int.MaxValue
    postorder.indices.reverse.foreach(i => {
      if (postorder(i) > p) return false
      while (st.nonEmpty && postorder(i) < st.head) p = st.pop()
      st.push(postorder(i))
    })
    true
  }
}
