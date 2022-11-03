package me.tomassetti.examples.MarkupParser

import CustomVisitor
import arifm_gLexer
import arifm_gParser
import arifm_gVisitor
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

    fun main(args: Array<String>) {
        val visitor = CustomVisitor()
        val input = mutableListOf<String>()
        input += "1;" // 1 = 1
        input += "1 + 2;" // 1 + 2 = 3
        input += "2 * 3;" // 2 * 3 = 6
        input += "a = 6;" // 6
        input += "b = 1;" // 1
        input += "c = (a * b) + (3 * b);" // c = 6 * 1 + 3 * 1 = 9
        input += "c * (b + 2);" // c * (b + 2) = 9 * 3 = 27
        input.forEach { inp ->
            val inputStream: CharStream = CharStreams.fromString(
                inp
            )
            val myLexer = arifm_gLexer(inputStream)
            val commonTokenStream = CommonTokenStream(myLexer)
            val myParser = arifm_gParser(commonTokenStream)
            val stContext = myParser.st()
            val result = inp.dropLast(1).split('=')[0].trim()
            println(result + " = " +  visitor.visitSt(stContext).toString())
        }
        //visitor.visit(exprContext)
        //visitor.visit(varContext)
    }