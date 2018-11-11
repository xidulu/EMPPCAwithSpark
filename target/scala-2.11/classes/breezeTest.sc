import breeze.linalg.{DenseVector => BDV, SparseVector => BSV, Vector => BV}
import org.apache.spark.mllib.linalg.{Vector, Vectors}

import scala.util.Random


def generateRandomPoints(n: Int, d: Int): List[Vector] = {
  val l = for {
    _ <- 1 to n
  } yield Vectors.dense(
    ((1 to d) map (_ => Random.nextDouble() * 100)).toArray
  )
  l.toList
}


generateRandomPoints(10, 3)

