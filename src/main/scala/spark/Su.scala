package spark

import org.apache.spark.rdd.RDD

import scala.reflect.ClassTag

/**
  * 查看RDD分区
  *
  * @author Justdwiwt
  */
object Su {

  /**
    * 查看RDD分区
    *
    * @param rdd array
    * @tparam T RDD
    */
  def debug[T: ClassTag](rdd: RDD[T]): Unit = {
    rdd.mapPartitionsWithIndex((i: Int, iter: Iterator[T]) => {
      val m = scala.collection.mutable.Map[Int, List[T]]()
      var list = List[T]()
      while (iter.hasNext) {
        list = list :+ iter.next
      }
      m(i) = list
      m.iterator
    }).collect().foreach((x: (Int, List[T])) => {
      val i = x._1
      println(s"partition:[$i]")
      x._2.foreach {
        println
      }
    })
  }

}

