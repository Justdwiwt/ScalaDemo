package leetCode._2500

import scala.collection.mutable

object Solution_2456 {
  def mostPopularCreator(creators: Array[String], ids: Array[String], views: Array[Int]): List[List[String]] = {
    var total = mutable.TreeMap.empty[String, Int].withDefaultValue(0)
    val most = mutable.TreeMap.empty[String, (Int, String)].withDefaultValue(-1, "")

    creators.indices.foreach(i => {
      val creator = creators(i)
      val id = ids(i)
      val view = views(i)
      total(creator) += view
      if (view > most(creator)._1 || (view == most(creator)._1 && id < most(creator)._2))
        most(creator) = (view, id)
    })

    val mx = total.values.max
    total = total.filter(x => x._2 == mx)
    total.map(x => List(x._1, most(x._1)._2)).toList
  }
}
