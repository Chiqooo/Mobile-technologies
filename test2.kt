import kotlin.math.pow
import kotlin.math.sqrt

fun main(){
    var Dot1 = Point(2,3)
    var Dot2 = Point(7,5)
    println(Dot1.toString())
    println(Dot1.equals(Dot2))
    println(Dot1.Symetry())
    println(Dot1.Distance(Dot2))


}

class Point (var Axis: Int,  var Ordinate: Int){
    override
    fun toString(): String {
        return "$Axis, $Ordinate"
    }

   override fun equals(other: Any?): Boolean {
        if(other is Point) {
            if (Ordinate == other.Ordinate && Axis == other.Axis) {
                return true
            }

        }
       return false
    }
    fun Symetry(): Point{
        return Point (Axis * -1,Ordinate * -1  )
    }
    fun Distance(other: Point): Double {
        var firsthalf: Int  = (other.Axis - Axis)
        var otherhalf: Int = (other.Ordinate - Ordinate)
        var sum = firsthalf.toDouble().pow(2) + otherhalf.toDouble().pow(2)
        return Math.sqrt(sum)
    }
}