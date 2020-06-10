package leetCode

import scala.collection.mutable

object Solution_1357 {

  class Cashier(_n: Int, _discount: Int, _products: Array[Int], _prices: Array[Int]) {

    var cnt = 0
    var n: Int = _n
    var discount: Int = _discount
    var m = new mutable.HashMap[Int, Int]()

    _products.indices.foreach(i => m.put(_products(i), _prices(i)))

    def getBill(product: Array[Int], amount: Array[Int]): Double = {
      var billAmount = 0.0
      product.indices.foreach(i => billAmount += amount(i) * m(product(i)))
      cnt += 1
      if (cnt % n != 0) billAmount else billAmount * (100 - discount) / 100.0
    }

  }

}

