import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

fun starter(input: File): String{
    val visitor = CustomVisitor()
    var calculations = ""
    var lineIndex = 0
    input.forEachLine { inp ->
        lineIndex ++
        val inputStream: CharStream = CharStreams.fromString(
            inp
        )
        val myErrorListener = CustomErrorListener()

        val myLexer = arifm_gLexer(inputStream)
        val commonTokenStream = CommonTokenStream(myLexer)
        val myParser = arifm_gParser(commonTokenStream)

        myParser.removeErrorListeners()
        myParser.addErrorListener(myErrorListener)
        myParser.st()
        calculations += if (myErrorListener.err != "") {
            "Line: $lineIndex, " + myErrorListener.err
        } else {
            myParser.reset()
            val stContext = myParser.st()
            val result = inp.dropLast(1).split('=')[0].trim()
            result + " = " + (visitor.visitSt(stContext)?.toString() ?: "NaN") + "\n"
        }
    }
    return calculations
}

fun main(args: Array<String>) {
    print(starter(File(args[0])))
}