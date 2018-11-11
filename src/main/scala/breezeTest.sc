import breeze.linalg.{inv, DenseMatrix => DM, DenseVector => BDV, SparseVector => BSV, Vector => BV}
import org.apache.spark.mllib.linalg.{Matrices, Vector, Vectors}

import scala.util.Random


def generateRandomPoints(n: Int, d: Int): List[Vector] = {
  val l = for {
    _ <- 1 to n
  } yield Vectors.dense(
    ((1 to d) map (_ => Random.nextDouble() * 100)).toArray
  )
  l.toList
}


//generateRandomPoints(10, 3)

//val W = Matrices.dense(3, 3,
//  Array(1, 0, 0, 0, 1, 0, 0, 0, 1)
//)

//breeze.linalg.DenseMatrix(W.toArray)
//val i_W = Matrices.dense(3, 3,inv(new DM(3, 3, W.toArray)).toArray)

val line = "1,2,3" +
  "\n" +
  "2,4,5"

line.split('\n').map(x => x.split(',').map(_.toDouble).toArray).map(array => BDV(array))