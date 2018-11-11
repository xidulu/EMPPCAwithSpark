import org.apache.spark.mllib.linalg.{Matrices, Matrix}
import breeze.linalg.{inv, DenseMatrix => DM}

class util {
  def matrixInverse(M: Matrix): Matrix = {
    val col = M.numCols
    val row = M.numRows
    Matrices.dense(col, row, (new DM(col, row, M.toArray)).toArray)
  }
}
