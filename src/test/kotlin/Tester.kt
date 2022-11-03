import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Tester {
    private val fileStart = "src/test/resources/"

    @Test
    fun testCorrect(){
        var file = File("$fileStart/Correct/test1Correct.txt")
        assertEquals("""
                1 = 1
                1 + 2 = 3
                2 * 3 = 6
                Line: 4, Symbol: 6, Message: mismatched input '=' expecting {';', '*', '+'}
                b = 1
                c = NaN
                c * (b + 2) = NaN
                
            """.trimIndent(),starter(file))
        file = File("$fileStart/Correct/test2Correct.txt")
        assertEquals("""
                a = 45
                b = 120
                a + b = 165
                c = 5400
                c = 5400
                
            """.trimIndent(),starter(file))
        file = File("$fileStart/Correct/test3Correct.txt")
        assertEquals("""
                1+1+1+1+1+1+1 = 7
                a = 2
                b = 3
                a * b = 6
                a = 3
                c = 9
                a = 9
                c = 27
                c = 27
             
            """.trimIndent(),starter(file))
        file = File("$fileStart/Correct/test4Correct.txt")
        assertEquals("""
                a = 1
                b = 2
                c = 3
                d = 4
                e = 5
                a * b * c *d* e = 120
                a+b+c+d+e = 15
             
            """.trimIndent(),starter(file))

    }

    @Test
    fun testCalculationError(){
        val file = File("$fileStart/CalculationError/testCalculationError.txt")
        assertEquals("""
            a = 1
            c = NaN
            b = 3
            c = 4
            c = 4
            d = 0
            e = NaN
            
         """.trimIndent(), starter(file))
    }

    @Test
    fun testCompileError(){
        var file = File("$fileStart/CompileError/test1CompileError.txt")
        assertEquals("""
            a = 2
            b = 3
            Line: 3, Symbol: 10, Message: mismatched input '=' expecting {';', '*', '+'}
  
         """.trimIndent(), starter(file))
        file = File("$fileStart/CompileError/test2CompileError.txt")
        assertEquals("""
            a = 1
            1 = 1
            Line: 3, Symbol: 3, Message: extraneous input '+' expecting {'(', INT, VAR}
            Line: 4, Symbol: 5, Message: missing ';' at '<EOF>'
            Line: 5, Symbol: 5, Message: missing ';' at '<EOF>'
            b = NaN
            
         """.trimIndent(), starter(file))
    }


}