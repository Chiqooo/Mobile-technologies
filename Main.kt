fun main(){
    var f1 = Fraction(1,6)
    var f2 = Fraction (5,10)
    println(f1.Multiply(f2))
    println(f1.equals(f2))
    println(f1.toString())
    println(f2.Reduction())
    println(f1.AddUp(f2))

}

class Fraction (val numerator:Int, val denumerator:Int){
    fun AddUp(other: Fraction):Fraction{
        var lcm: Int
    //umciresi saerto jeradi
        lcm = if (denumerator > other.denumerator) denumerator else other.denumerator
        while (true) {
            if (lcm % denumerator == 0 && lcm % other.denumerator == 0) {
                break
            }
            ++lcm
        }
        var newNumerator = ((lcm / denumerator) * numerator) + ((lcm / other.denumerator)) * other.numerator
        var addedupFraction = Fraction(newNumerator,lcm)
        return addedupFraction.Reduction()
    }
    fun Multiply (other: Fraction): Fraction{
        var multipliedFraction = Fraction (numerator * other.numerator, denumerator * other.denumerator)
        return multipliedFraction.Reduction()
    }
    fun Reduction (): Fraction{
        var i = 1
        var gcd = 1
        //udidesi saerto gamyofi
        while (i <= numerator && i<= denumerator){
            if (numerator % i == 0 && denumerator % i == 0)
                gcd = i
            ++i
        }
        return Fraction(numerator / gcd,denumerator / gcd)
    }

    override fun toString(): String {
        return "$numerator / $denumerator"
    }

    override fun equals(other: Any?): Boolean {
        if(other is Fraction) {
            if(numerator * other.denumerator == denumerator * other.numerator){
                return true
            }
        }
        return false
    }

}
