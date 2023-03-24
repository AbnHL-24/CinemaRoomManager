package cinema

fun main() {
    println("Enter the number of rows:")
    val filas = readln().toInt()
    println("Enter the number of seats in each row:")
    val columnas = readln().toInt()
    val ganancia =  if ((filas * columnas) <= 60) {
            filas * columnas * 10
        } else {
            (filas/2) * columnas * 10 + (filas - (filas/2)) * columnas * 8
        }
    println("Total income:")
    println("$${ganancia}")
}